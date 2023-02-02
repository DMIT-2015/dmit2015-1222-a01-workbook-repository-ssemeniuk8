package dmit2015.model;

import lombok.Data;

import java.util.Optional;

@Data
public class CanadianPersonalIncomeTaxRate {

    private String regionAbbreviation;
    private String regionName;
    private int taxYear;
    private int bracketNo;
    //BigDecimal for accuracy with mathematical operations
    //double is used for simplicity, but is less accurate with mathematical operations
    private double startingIncome;
    private Double endingIncome; //May not be included in every line of the csv - Double is used to allow null values
    private double taxRate;
    private double baseTaxAmount;
    private double roundedBaseTaxAmount;


    public static Optional<CanadianPersonalIncomeTaxRate> parseCsv(String line){
        Optional<CanadianPersonalIncomeTaxRate> optionalCanadianPersonalIncomeTaxRate = Optional.empty();
        final String DELIMITER = ",";
        /*
           The order of the columns are:
                0 - Region Abbreviation
                1 - Region Name
                2 - Tax Year
                3 - Bracket No
                4 - Starting Income
                5 - Ending Income
                6 - Tax Rate
                7 - Base Tax Amount
                8 - Rounded Base Tax Amount - Not interested in this field
         */
        String[] tokens = line.split(line);
        if (tokens.length != 9) {
            throw new RuntimeException("Line does not contain exactly 9 values");
        }
        String regionAbbreviation = tokens[0];
        String regionName = tokens[1];
        int taxYear = Integer.parseInt(tokens[2]);
        int bracketNo = Integer.parseInt(tokens[3]);
        double startingIncome = Double.parseDouble(tokens[4]);
        //Double endingIncome = tokens[5].isBlank() ? null: Double.valueOf(tokens[5]);
        Double endingIncome = tokens[5].isBlank() ? Integer.MAX_VALUE: Double.valueOf(tokens[5]);
        double taxRate = Double.parseDouble(tokens[6]);
        double baseTaxAmount = Double.parseDouble(tokens[7]);
        CanadianPersonalIncomeTaxRate currentIncomeTaxRate = new CanadianPersonalIncomeTaxRate();
        currentIncomeTaxRate.setRegionAbbreviation(regionAbbreviation);
        currentIncomeTaxRate.setRegionName(regionName);
        currentIncomeTaxRate.setTaxYear(taxYear);
        currentIncomeTaxRate.setBracketNo(bracketNo);
        currentIncomeTaxRate.setStartingIncome(startingIncome);
        currentIncomeTaxRate.setEndingIncome(endingIncome);
        currentIncomeTaxRate.setTaxRate(taxRate);
        currentIncomeTaxRate.setBaseTaxAmount(baseTaxAmount);

        optionalCanadianPersonalIncomeTaxRate = Optional.of(currentIncomeTaxRate);

        return optionalCanadianPersonalIncomeTaxRate;
    }
}
