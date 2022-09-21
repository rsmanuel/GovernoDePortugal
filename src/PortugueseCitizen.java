public class PortugueseCitizen {
    public String name;
    public String age;
    private String vatNumber;
    private String ciNumber;

    public PortugueseCitizen(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getVatNumber() {
        if(this.vatNumber.length() > 0) {
            return this.vatNumber;
        }
        return null;
    }

    public String getCiNumber() {
        if(this.ciNumber.length() > 0) {
            return this.ciNumber;
        }
        return null;
    }

    public void setVatNumber() {
        int random = (int)(Math.random() * 1000000000) + 100000000;
        this.vatNumber = String.valueOf(random);
    }

    public void setCiNumber() {
        int random = (int)(Math.random() * 1000000000) + 100000000;
        this.ciNumber = String.valueOf(random);
    }
}
