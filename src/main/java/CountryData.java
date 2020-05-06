import lombok.Data;
import lombok.ToString;


class CountryData {
    private String country;
    private long recovered;
    private long cases;
    private long totalDeaths;
    private long deaths;
    private  long totalTests;
    private long totalCases;
    private long active;
    private  long critical;

    public long getCritical() {
        return critical;
    }

    public long getActive() {
        return active;
    }

    public long getDeaths() {
        return deaths;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    public long getCases() {
        return cases;
    }

    public void setCases(long cases) {
        this.cases = cases;
    }

    public long getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(long totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public long getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(long totalTests) {
        this.totalTests = totalTests;
    }

    public long getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(long totalCases) {
        this.totalCases = totalCases;
    }

    @Override
    public String toString() {
        return "CountryData{" +
                "country='" + country + '\'' +
                ", recovered=" + recovered +
                ", cases=" + cases +
                ", critical=" + critical +
                ", active=" + active +
                ", deaths=" + deaths +
                ", totalTests=" + totalTests +
                '}';
    }
}
