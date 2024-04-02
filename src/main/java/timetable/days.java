package timetable;

public class Days {

    protected String classCode;
    protected int classTime;
    protected int classDuration;
    protected String classLocation;

    public Days(String classCode, int classTime, int classDuration, String classLocation) {
        this.classCode = classCode;
        this.classTime = classTime;
        this.classDuration = classDuration;
        this.classLocation = classLocation;
    }

    public String getClassCode() {
        return classCode;
    }

    public int getClassDuration() {
        return classDuration;
    }

    public int getClassTime() {
        return classTime;
    }

    public String getClassLocation() {
        return classLocation;
    }

    public String toStringStorage() {
        return classCode + " | " + classDuration + " | " + classLocation;
    }

    @Override
    public String toString() {
        return "Code: " + classCode + ", Class Time: " + classTime + ", Duration: " + classDuration +
                ", Location: " + classLocation;
    }
}
