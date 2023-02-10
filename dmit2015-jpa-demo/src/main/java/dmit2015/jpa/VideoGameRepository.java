package dmit2015.jpa;

import dmit2015.jpa.GamingPlatform;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class VideoGameRepository {

    @PersistenceContext(unitName = "local-mssql-dmit2015-jpa-pu")
    private EntityManager em;

    public VideoGame create(VideoGame newVideoGame) {
        em.persist(newVideoGame);
        return newVideoGame;
    }

    public VideoGame update(VideoGame existingVideoGame) {
        em.merge(existingVideoGame);
        return existingVideoGame;
    }

    public Optional<VideoGame> findById(Long webCode) {
        Optional<VideoGame> optionalVideoGame;

        try {
            VideoGame existingVideo = em.createQuery("""
                            SELECT g
                            FROM VideoGame g
                            WHERE g.webCode = :webCodeValue
                            """, VideoGame.class)
                    .setParameter("webCodeValue", webCode)
                    .getSingleResult();
            optionalVideoGame = Optional.of(existingVideo);
        } catch (NoResultException e) {
//            e.printStackTrace();
            optionalVideoGame = Optional.empty();
        }

        return optionalVideoGame;
    }

    public List<VideoGame> findAll() {
        List<VideoGame> games;

        games = em.createQuery("""
                        SELECT g
                        FROM VideoGame g
                        ORDER BY g.title
                        """, VideoGame.class)
                .getResultList();

        return games;
    }

    public void delete(VideoGame existingVideoGame) {

        if (!em.contains(existingVideoGame)) {
            existingVideoGame = em.merge(existingVideoGame);
        }
        em.remove(existingVideoGame);

    }

    public void deleteAll() {

        em.createQuery("DELETE FROM VideoGame").executeUpdate();

    }

    public List<VideoGame> findByGamingPlatform(GamingPlatform platform) {
        List<VideoGame> resultList = em.createQuery("SELECT g FROM VideoGame g WHERE g.platform = :platformValue ORDER BY g.title", VideoGame.class)
                .setParameter("platformValue", platform)
                .getResultList();
        return resultList;
    }

    public List<String> mapToTitle() {
        List<String> resultList = em.createQuery("SELECT g.title FROM VideoGame g ORDER BY g.title", String.class)
                .getResultList();
        return resultList;
    }

    public List<Double> mapToDistinctPrices() {
        List<Double> resultList = em.createQuery("SELECT g.price FROM VideoGame g GROUP BY g.price ORDER BY g.price DESC", Double.class)
                .getResultList();
        return resultList;
    }

    public Set<Double> mapToPriceSet() {
        Set<Double> resultSet = em.createQuery("SELECT g.price FROM VideoGame g GROUP BY g.price ORDER BY g.price DESC", Double.class)
                .getResultStream()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return resultSet;
    }

    public List<VideoGame> sortByPlatformThenTitleThenPriceDescending() {
        List<VideoGame> resultList = em.createQuery(
                "SELECT g FROM VideoGame g ORDER BY g.platform, g.title, g.price DESC ", VideoGame.class)
                .getResultList();
        return resultList;
    }

    public Optional<VideoGame> findFirstByTitleAndPlatform(String title, GamingPlatform platform) {
        List<VideoGame> resultList = em.createQuery("SELECT g FROM VideoGame g WHERE g.title = :titleParam AND g.platform = :platformParam", VideoGame.class)
                .setParameter("titleParam",title)
                .setParameter("platformParam",platform)
                .getResultList();
        Optional<VideoGame> optionalVideoGame = Optional.empty();
        if (resultList.size() > 0) {
            optionalVideoGame = Optional.of(resultList.get(0));
        }
        return optionalVideoGame;
    }

    public long count() {
        long countValue = em.createQuery("SELECT COUNT(g) FROM VideoGame g", Long.class).getSingleResult();
        return countValue;
    }
    public double sumAllPrices() {
        double sum = em.createQuery("SELECT SUM(g.price) FROM VideoGame g", Double.class).getSingleResult();
        return sum;
    }

    public double highestPriceByPlatform(GamingPlatform platform) {
        double highestPrice = em.createQuery("SELECT MAX(g.price) FROM VideoGame g WHERE g.platform = :platformParam", Double.class)
                .setParameter("platformParam", platform)
                .getSingleResult();
        return highestPrice;
    }

    public double lowestPriceByPlatform(GamingPlatform platform) {
        double lowestPrice = em.createQuery("SELECT MIN(g.price) FROM VideoGame g WHERE g.platform = :platformParam", Double.class)
                .setParameter("platformParam", platform)
                .getSingleResult();
        return lowestPrice;
    }

    public double averagePriceByPlatform(GamingPlatform platform) {
        double averagePrice = em.createQuery("SELECT AVG(g.price) FROM VideoGame g WHERE g.platform = :platformParam", Double.class)
                .setParameter("platformParam", platform)
                .getSingleResult();
        return averagePrice;
    }

    public Optional<VideoGame> highestPriceGame() {
        List<VideoGame> resultList = em.createQuery("SELECT g FROM VideoGame g WHERE g.price >= (SELECT MAX(g.price) FROM VideoGame g)", VideoGame.class)
                .getResultList();
        Optional<VideoGame> optionalVideoGame = Optional.empty();
        if (resultList.size() > 0) {
            optionalVideoGame = Optional.of(resultList.get(0));
        }
        return optionalVideoGame;
    }

    public Optional<VideoGame> lowestPriceGame() {
        List<VideoGame> resultList = em.createQuery("SELECT g FROM VideoGame g WHERE g.price <= (SELECT MIN(g.price) FROM VideoGame g)", VideoGame.class)
                .getResultList();
        Optional<VideoGame> optionalVideoGame = Optional.empty();
        if (resultList.size() > 0) {
            optionalVideoGame = Optional.of(resultList.get(0));
        }
        return optionalVideoGame;
    }

    public Map<GamingPlatform, List<VideoGame>> groupByPlatform() {
        Map<GamingPlatform, List<VideoGame>> resultMap = em.createQuery(
                        "SELECT g FROM VideoGame g ORDER BY g.platform", VideoGame.class)
                .getResultStream()
                .collect(Collectors.groupingBy(VideoGame::getPlatform));

        return resultMap;
    }


}