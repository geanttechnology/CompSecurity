// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import java.util.Date;

// Referenced classes of package com.millennialmedia:
//            MMSDK, MMLog

public class UserData
{
    public static final class Education extends Enum
    {

        private static final Education $VALUES[];
        public static final Education ASSOCIATE;
        public static final Education BACHELOR;
        public static final Education HIGH_SCHOOL;
        public static final Education MASTERS;
        public static final Education PHD;
        public static final Education PROFESSIONAL;
        public static final Education SOME_COLLEGE;
        public final String value;

        public static Education valueOf(String s)
        {
            return (Education)Enum.valueOf(com/millennialmedia/UserData$Education, s);
        }

        public static Education[] values()
        {
            return (Education[])$VALUES.clone();
        }

        static 
        {
            HIGH_SCHOOL = new Education("HIGH_SCHOOL", 0, "highschool");
            SOME_COLLEGE = new Education("SOME_COLLEGE", 1, "somecollege");
            ASSOCIATE = new Education("ASSOCIATE", 2, "associate");
            BACHELOR = new Education("BACHELOR", 3, "bachelor");
            MASTERS = new Education("MASTERS", 4, "masters");
            PHD = new Education("PHD", 5, "phd");
            PROFESSIONAL = new Education("PROFESSIONAL", 6, "professional");
            $VALUES = (new Education[] {
                HIGH_SCHOOL, SOME_COLLEGE, ASSOCIATE, BACHELOR, MASTERS, PHD, PROFESSIONAL
            });
        }

        private Education(String s, int i, String s1)
        {
            super(s, i);
            value = s1;
        }
    }

    public static final class Ethnicity extends Enum
    {

        private static final Ethnicity $VALUES[];
        public static final Ethnicity ASIAN;
        public static final Ethnicity BLACK;
        public static final Ethnicity HISPANIC;
        public static final Ethnicity INDIAN;
        public static final Ethnicity MIDDLE_EASTERN;
        public static final Ethnicity NATIVE_AMERICAN;
        public static final Ethnicity OTHER;
        public static final Ethnicity PACIFIC_ISLANDER;
        public static final Ethnicity WHITE;
        public final String value;

        public static Ethnicity valueOf(String s)
        {
            return (Ethnicity)Enum.valueOf(com/millennialmedia/UserData$Ethnicity, s);
        }

        public static Ethnicity[] values()
        {
            return (Ethnicity[])$VALUES.clone();
        }

        static 
        {
            HISPANIC = new Ethnicity("HISPANIC", 0, "hispanic");
            BLACK = new Ethnicity("BLACK", 1, "africanamerican");
            ASIAN = new Ethnicity("ASIAN", 2, "asian");
            INDIAN = new Ethnicity("INDIAN", 3, "indian");
            MIDDLE_EASTERN = new Ethnicity("MIDDLE_EASTERN", 4, "middleeastern");
            NATIVE_AMERICAN = new Ethnicity("NATIVE_AMERICAN", 5, "nativeamerican");
            PACIFIC_ISLANDER = new Ethnicity("PACIFIC_ISLANDER", 6, "pacificislander");
            WHITE = new Ethnicity("WHITE", 7, "white");
            OTHER = new Ethnicity("OTHER", 8, "other");
            $VALUES = (new Ethnicity[] {
                HISPANIC, BLACK, ASIAN, INDIAN, MIDDLE_EASTERN, NATIVE_AMERICAN, PACIFIC_ISLANDER, WHITE, OTHER
            });
        }

        private Ethnicity(String s, int i, String s1)
        {
            super(s, i);
            value = s1;
        }
    }

    public static final class Gender extends Enum
    {

        private static final Gender $VALUES[];
        public static final Gender FEMALE;
        public static final Gender MALE;
        public static final Gender UNKNOWN;
        public final String value;

        public static Gender valueOf(String s)
        {
            return (Gender)Enum.valueOf(com/millennialmedia/UserData$Gender, s);
        }

        public static Gender[] values()
        {
            return (Gender[])$VALUES.clone();
        }

        static 
        {
            MALE = new Gender("MALE", 0, "M");
            FEMALE = new Gender("FEMALE", 1, "F");
            UNKNOWN = new Gender("UNKNOWN", 2, "O");
            $VALUES = (new Gender[] {
                MALE, FEMALE, UNKNOWN
            });
        }

        private Gender(String s, int i, String s1)
        {
            super(s, i);
            value = s1;
        }
    }

    public static final class Marital extends Enum
    {

        private static final Marital $VALUES[];
        public static final Marital DIVORCED;
        public static final Marital MARRIED;
        public static final Marital RELATIONSHIP;
        public static final Marital SINGLE;
        public final String value;

        public static Marital valueOf(String s)
        {
            return (Marital)Enum.valueOf(com/millennialmedia/UserData$Marital, s);
        }

        public static Marital[] values()
        {
            return (Marital[])$VALUES.clone();
        }

        static 
        {
            SINGLE = new Marital("SINGLE", 0, "S");
            MARRIED = new Marital("MARRIED", 1, "M");
            DIVORCED = new Marital("DIVORCED", 2, "D");
            RELATIONSHIP = new Marital("RELATIONSHIP", 3, "O");
            $VALUES = (new Marital[] {
                SINGLE, MARRIED, DIVORCED, RELATIONSHIP
            });
        }

        private Marital(String s, int i, String s1)
        {
            super(s, i);
            value = s1;
        }
    }

    public static final class Politics extends Enum
    {

        private static final Politics $VALUES[];
        public static final Politics CONSERVATIVE;
        public static final Politics DEMOCRAT;
        public static final Politics INDEPENDENT;
        public static final Politics LIBERAL;
        public static final Politics MODERATE;
        public static final Politics OTHER;
        public static final Politics REPUBLICAN;
        public final String value;

        public static Politics valueOf(String s)
        {
            return (Politics)Enum.valueOf(com/millennialmedia/UserData$Politics, s);
        }

        public static Politics[] values()
        {
            return (Politics[])$VALUES.clone();
        }

        static 
        {
            REPUBLICAN = new Politics("REPUBLICAN", 0, "republican");
            DEMOCRAT = new Politics("DEMOCRAT", 1, "democrat");
            CONSERVATIVE = new Politics("CONSERVATIVE", 2, "conservative");
            MODERATE = new Politics("MODERATE", 3, "moderate");
            LIBERAL = new Politics("LIBERAL", 4, "liberal");
            INDEPENDENT = new Politics("INDEPENDENT", 5, "independent");
            OTHER = new Politics("OTHER", 6, "other");
            $VALUES = (new Politics[] {
                REPUBLICAN, DEMOCRAT, CONSERVATIVE, MODERATE, LIBERAL, INDEPENDENT, OTHER
            });
        }

        private Politics(String s, int i, String s1)
        {
            super(s, i);
            value = s1;
        }
    }


    private static final String TAG = com/millennialmedia/UserData.getName();
    private Integer age;
    private Integer children;
    private String country;
    private String dma;
    private Date dob;
    private String education;
    private String ethnicity;
    private String gender;
    private Integer income;
    private String keywords;
    private String marital;
    private String politics;
    private String postalCode;
    private String state;

    public UserData()
    {
        if (!MMSDK.initialized)
        {
            throw new IllegalStateException("Unable to create UserData instance, SDK must be initialized first");
        } else
        {
            return;
        }
    }

    public Integer getAge()
    {
        return age;
    }

    public Integer getChildren()
    {
        return children;
    }

    public String getCountry()
    {
        return country;
    }

    public String getDma()
    {
        return dma;
    }

    public Date getDob()
    {
        return dob;
    }

    public String getEducation()
    {
        return education;
    }

    public String getEthnicity()
    {
        return ethnicity;
    }

    public String getGender()
    {
        return gender;
    }

    public Integer getIncome()
    {
        return income;
    }

    public String getKeywords()
    {
        return keywords;
    }

    public String getMarital()
    {
        return marital;
    }

    public String getPolitics()
    {
        return politics;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String getState()
    {
        return state;
    }

    public UserData setAge(int i)
    {
        if (i < 0 || i > 150)
        {
            MMLog.e(TAG, "Age must be at least 0 and no greater than 150");
            return this;
        } else
        {
            age = Integer.valueOf(i);
            return this;
        }
    }

    public UserData setChildren(int i)
    {
        if (i < 0)
        {
            MMLog.e(TAG, "Number of children must be greater than or equal to zero");
            return this;
        } else
        {
            children = Integer.valueOf(i);
            return this;
        }
    }

    public UserData setCountry(String s)
    {
        country = s;
        return this;
    }

    public UserData setDma(String s)
    {
        dma = s;
        return this;
    }

    public UserData setDob(Date date)
    {
        dob = date;
        return this;
    }

    public UserData setEducation(Education education1)
    {
        education = education1.value;
        return this;
    }

    public UserData setEthnicity(Ethnicity ethnicity1)
    {
        ethnicity = ethnicity1.value;
        return this;
    }

    public UserData setGender(Gender gender1)
    {
        gender = gender1.value;
        return this;
    }

    public UserData setIncome(int i)
    {
        income = Integer.valueOf(i);
        return this;
    }

    public UserData setKeywords(String s)
    {
        keywords = s;
        return this;
    }

    public UserData setMarital(Marital marital1)
    {
        marital = marital1.value;
        return this;
    }

    public UserData setPolitics(Politics politics1)
    {
        politics = politics1.value;
        return this;
    }

    public UserData setPostalCode(String s)
    {
        postalCode = s;
        return this;
    }

    public UserData setState(String s)
    {
        state = s;
        return this;
    }

}
