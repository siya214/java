import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display currency options
        System.out.println("Select the base currency: ");
        System.out.println("1: USD");
        System.out.println("2: EUR");
        System.out.println("3: GBP");
        System.out.println("4: INR");

        int baseCurrency = scanner.nextInt();

        System.out.println("Select the target currency: ");
        System.out.println("1: USD");
        System.out.println("2: EUR");
        System.out.println("3: GBP");
        System.out.println("4: INR");

        int targetCurrency = scanner.nextInt();

        System.out.println("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);

        String targetCurrencySymbol = getCurrencySymbol(targetCurrency);

        System.out.println("Converted Amount: " + convertedAmount + " " + targetCurrencySymbol);

        scanner.close();
    }

    private static double convertCurrency(int baseCurrency, int targetCurrency, double amount) {
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
        return amount * exchangeRate;
    }

    private static double getExchangeRate(int baseCurrency, int targetCurrency) {
        // Static exchange rates for simplicity
        // In a real application, fetch real-time rates from a reliable API

        // Exchange rates relative to USD
        double[] exchangeRates = {1.0, 0.85, 0.75, 73.5}; // USD, EUR, GBP, INR

        double baseRate = exchangeRates[baseCurrency - 1];
        double targetRate = exchangeRates[targetCurrency - 1];

        return targetRate / baseRate;
    }

    private static String getCurrencySymbol(int currency) {
        switch (currency) {
            case 1:
                return "USD";
            case 2:
                return "EUR";
            case 3:
                return "GBP";
            case 4:
                return "INR";
            default:
                return "";
        }
    }
}

