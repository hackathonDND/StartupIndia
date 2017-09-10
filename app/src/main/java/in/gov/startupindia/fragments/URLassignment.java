package in.gov.startupindia.fragments;

/**
 * Created by A.K on 3/23/2017.
 */

public class URLassignment {
    static int id,CheckURL,age,checkForm,checkHelp;
    static boolean isStoragePermission;
    public static void setId(int id) {
        URLassignment.id = id;
    }

    public static int getId() {

        return id;
    }

    public static void setCheckURL(int i)
    {
        CheckURL=i;
    }

    public static int getCheckURL()
    {
        return CheckURL;
    }

    public static void setAge(int age)
    {
        URLassignment.age = age;
    }

    public static int getAge()
    {
        return age;
    }
    public static void main (String args[])
    {
        URLassignment urLassignment = new URLassignment();
    }

    public static void setCheckForm(int checkForm) {
        URLassignment.checkForm = checkForm;
    }

    public static int getCheckForm() {
        return checkForm;
    }

    public static void setCheckHelp(int checkHelp) {
        URLassignment.checkHelp = checkHelp;
    }

    public static int getCheckHelp() {
        return checkHelp;
    }

    public static void setIsStoragePermission(boolean isStoragePermission)
    {
        URLassignment.isStoragePermission = isStoragePermission;
    }

    public static boolean isStoragePermission() {
        return isStoragePermission;
    }
}
