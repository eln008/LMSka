package Package.Model;

public class Lesson {
    private static int idd=1;
    private int id;
    private String lessonName;

    private String lessonDesc;

    public Lesson() {
        this.id = idd++;
    }

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Lesson.idd = idd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDesc() {
        return lessonDesc;
    }

    public void setLessonDesc(String lessonDesc) {
        this.lessonDesc = lessonDesc;
    }


    @Override
    public String toString() {
        return "Lesson    " +
                "id:" + id +"   "+
                "lesson Name: " + lessonName + "   "+
                "lesson Description: " + lessonDesc + "   ";
    }
}

