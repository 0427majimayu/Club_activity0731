package android.lifeistech.com.club_activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Practice implements Serializable {
    public String date;
    public String time;
    public String location;
    public List<Attendance> attendanceList;

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

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }
}


