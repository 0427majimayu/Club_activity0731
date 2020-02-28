package android.lifeistech.com.club_activity;

import java.util.ArrayList;


public class Practice {
    public String date;
    public String time;
    public String location;
    public ArrayList<Attendance> attendanceList;

    public  Practice(){
    }

    public Practice(String date, String time, String location) {
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public Practice(String date, String time, String location, ArrayList<Attendance> attendanceList) {
        this.date = date;
        this.time = time;
        this.location = location;
        this.attendanceList = attendanceList;
    }




    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(ArrayList<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }
}

