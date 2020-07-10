package android.lifeistech.com.club_activity;

public class Attendance {
    public String name;
    public boolean atab;

    public Attendance(String name) {
        this.name = name;
    }

    public Attendance(String name, boolean atab){
        this.name = name;
        this.atab = atab;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAtab() {
        return atab;
    }

    public void setAtab(boolean atab) {
        this.atab = atab;
    }





}
