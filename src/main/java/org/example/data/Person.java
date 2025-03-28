package org.example.data;

import com.opencsv.bean.CsvBindByName;


public class Person {
    // dane z pliku CSV
    @CsvBindByName(column = "groupID")
    private Integer groupID;

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "goalID")
    private Integer goalID;

    @CsvBindByName(column = "qualifications")
    private String qualifications;

    @CsvBindByName(column = "start")
    private String start;

    @CsvBindByName(column = "finish")
    private String finish;

    // dodatkowe dane
    private String firstName;
    private String lastName;

    private boolean canChat;
    private boolean canFL;
    private boolean canBL;

    private Integer startHour;
    private Integer finishHour;

    private boolean deletable = false;


    // konstruktor wymagany przez OpenCSV
    public Person() {
    }

    // tu już pełny konstruktor
    public Person(Integer groupID, String name, Integer goalID, String qualifications, String start, String finish) {
        this.groupID = groupID;
        this.name = name;
        this.goalID = goalID;
        this.qualifications = qualifications;
        this.start = start;
        this.finish = finish;
    }


    // gettery i settery
    public Integer getGroupID() {
        return groupID;
    }
    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoalID() {
        return goalID;
    }
    public void setGoalID(Integer goalID) {
        this.goalID = goalID;
    }

    public String getQualifications() {
        return qualifications;
    }
    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }
    public void setFinish(String finish) {
        this.finish = finish;
    }


    // metody do kwaliifikacji
    public void setQualifications() {
        if (qualifications != null) {
            canChat = qualifications.toUpperCase().contains("CHAT");
            canFL = qualifications.toUpperCase().contains("FL");
            canBL = qualifications.toUpperCase().contains("BL");
        }
    }

    public boolean getFL() {
        return canFL;
    }

    public boolean getBL() {
        return canBL;
    }

    public boolean getChat() {
        return canChat;
    }


    // metody do godzin
    private void setHours() {
        if (start == null || start.isEmpty() || finish == null || finish.isEmpty())
            return;
        startHour =  Integer.parseInt(start.split(":")[0]);
        finishHour =  Integer.parseInt(finish.split(":")[0]);
    }

    private Integer getFinish(String time) {
        return finishHour;
    }

    private Integer getStart(String time) {
        return startHour;
    }


    // metody do imion i nazwisk
    private void setNames() {
        if (name == null || name.isEmpty())
            return;
        String[] names = name.split("\\.");
        if (names.length > 0)
            firstName = names[0];
        if (names.length > 1)
            lastName = names[1];
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    // użycie całego setup'u w jednej metodzie
    public void setup() {
        // po prostu usuń sam siebie jeśli to jest null
        if(name == null || groupID == null || start == null || finish == null || goalID == null || qualifications == null)
            this.deletable = true;

        setQualifications();
        setHours();
        setNames();
    }

    public boolean isDeletable() {
        return deletable;
    }


    @Override
    public String toString() {
        String qualif = "";
        if(canChat)
            qualif += "CHAT";
        if(canFL) {
            if (!qualif.equals(""))
                qualif += " & ";
            qualif += "FL";
        }
        if(canBL){
            if (!qualif.equals(""))
                qualif += " & ";
            qualif += "BL";
        }
        if(qualif == "")
            qualif = null;

        return "Person {" +
                "groupID=" + groupID +
                ", first name='" + firstName + '\'' +
                ", last name='" + lastName + '\'' +
                ", goalID=" + goalID +
                ", qualifications='" + qualif + '\'' +
                ", start='" + startHour + '\'' +
                ", finish='" + finishHour + '\'' +
                '}';
    }
}