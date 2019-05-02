package sg.edu.rp.c346.p03_classjournal;

import java.io.Serializable;

public class DailyCA implements Serializable {
    String dgGrade;
    String moduleCode;
    int week;

    public DailyCA(String dgGrade, String moduleCode, int week) {
        this.dgGrade = dgGrade;
        this.moduleCode = moduleCode;
        this.week = week;
    }

    public String getDgGrade() {
        return dgGrade;
    }

    public void setDgGrade(String dgGrade) {
        this.dgGrade = dgGrade;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}
