// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;

import android.location.Location;
import com.google.ads.mediation.NetworkExtras;

public final class MillennialAdapterExtras
    implements NetworkExtras
{
    public static final class Children extends Enum
    {

        private static final Children $VALUES[];
        public static final Children HAS_KIDS;
        public static final Children NO_KIDS;
        private final String description;

        public static Children valueOf(String s)
        {
            return (Children)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$Children, s);
        }

        public static Children[] values()
        {
            return (Children[])$VALUES.clone();
        }

        public final String getDescription()
        {
            return description;
        }

        static 
        {
            HAS_KIDS = new Children("HAS_KIDS", 0, "true");
            NO_KIDS = new Children("NO_KIDS", 1, "false");
            $VALUES = (new Children[] {
                HAS_KIDS, NO_KIDS
            });
        }

        private Children(String s, int i, String s1)
        {
            super(s, i);
            description = s1;
        }
    }

    public static final class Education extends Enum
    {

        private static final Education $VALUES[];
        public static final Education ASSOCIATES;
        public static final Education BACHELORS;
        public static final Education DOCTORATE;
        public static final Education HIGH_SCHOOL;
        public static final Education IN_COLLEGE;
        public static final Education MASTERS;
        public static final Education OTHER;
        public static final Education SOME_COLLEGE;
        private final String description;

        public static Education valueOf(String s)
        {
            return (Education)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$Education, s);
        }

        public static Education[] values()
        {
            return (Education[])$VALUES.clone();
        }

        public final String getDescription()
        {
            return description;
        }

        static 
        {
            HIGH_SCHOOL = new Education("HIGH_SCHOOL", 0, "highschool");
            IN_COLLEGE = new Education("IN_COLLEGE", 1, "incollege");
            SOME_COLLEGE = new Education("SOME_COLLEGE", 2, "somecollege");
            ASSOCIATES = new Education("ASSOCIATES", 3, "associates");
            BACHELORS = new Education("BACHELORS", 4, "bachelors");
            MASTERS = new Education("MASTERS", 5, "masters");
            DOCTORATE = new Education("DOCTORATE", 6, "doctorate");
            OTHER = new Education("OTHER", 7, "other");
            $VALUES = (new Education[] {
                HIGH_SCHOOL, IN_COLLEGE, SOME_COLLEGE, ASSOCIATES, BACHELORS, MASTERS, DOCTORATE, OTHER
            });
        }

        private Education(String s, int i, String s1)
        {
            super(s, i);
            description = s1;
        }
    }

    public static final class Ethnicity extends Enum
    {

        private static final Ethnicity $VALUES[];
        public static final Ethnicity AFRICAN_AMERICAN;
        public static final Ethnicity ASIAN;
        public static final Ethnicity HISPANIC;
        public static final Ethnicity INDIAN;
        public static final Ethnicity MIDDLE_EASTERN;
        public static final Ethnicity NATIVE_AMERICAN;
        public static final Ethnicity OTHER;
        public static final Ethnicity PACIFIC_ISLANDER;
        public static final Ethnicity WHITE;
        private final String description;

        public static Ethnicity valueOf(String s)
        {
            return (Ethnicity)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$Ethnicity, s);
        }

        public static Ethnicity[] values()
        {
            return (Ethnicity[])$VALUES.clone();
        }

        public final String getDescription()
        {
            return description;
        }

        static 
        {
            HISPANIC = new Ethnicity("HISPANIC", 0, "hispanic");
            AFRICAN_AMERICAN = new Ethnicity("AFRICAN_AMERICAN", 1, "africanamerican");
            ASIAN = new Ethnicity("ASIAN", 2, "asian");
            INDIAN = new Ethnicity("INDIAN", 3, "indian");
            MIDDLE_EASTERN = new Ethnicity("MIDDLE_EASTERN", 4, "middleeastern");
            NATIVE_AMERICAN = new Ethnicity("NATIVE_AMERICAN", 5, "nativeamerican");
            PACIFIC_ISLANDER = new Ethnicity("PACIFIC_ISLANDER", 6, "pacificislander");
            WHITE = new Ethnicity("WHITE", 7, "white");
            OTHER = new Ethnicity("OTHER", 8, "other");
            $VALUES = (new Ethnicity[] {
                HISPANIC, AFRICAN_AMERICAN, ASIAN, INDIAN, MIDDLE_EASTERN, NATIVE_AMERICAN, PACIFIC_ISLANDER, WHITE, OTHER
            });
        }

        private Ethnicity(String s, int i, String s1)
        {
            super(s, i);
            description = s1;
        }
    }

    public static final class Gender extends Enum
    {

        private static final Gender $VALUES[];
        public static final Gender FEMALE;
        public static final Gender MALE;
        public static final Gender OTHER;
        private final String description;

        public static Gender valueOf(String s)
        {
            return (Gender)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$Gender, s);
        }

        public static Gender[] values()
        {
            return (Gender[])$VALUES.clone();
        }

        public final String getDescription()
        {
            return description;
        }

        static 
        {
            MALE = new Gender("MALE", 0, "male");
            FEMALE = new Gender("FEMALE", 1, "female");
            OTHER = new Gender("OTHER", 2, "other");
            $VALUES = (new Gender[] {
                MALE, FEMALE, OTHER
            });
        }

        private Gender(String s, int i, String s1)
        {
            super(s, i);
            description = s1;
        }
    }

    public static final class InterstitialTime extends Enum
    {

        private static final InterstitialTime $VALUES[];
        public static final InterstitialTime APP_LAUNCH;
        public static final InterstitialTime TRANSITION;
        public static final InterstitialTime UNKNOWN;

        public static InterstitialTime valueOf(String s)
        {
            return (InterstitialTime)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$InterstitialTime, s);
        }

        public static InterstitialTime[] values()
        {
            return (InterstitialTime[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new InterstitialTime("UNKNOWN", 0);
            APP_LAUNCH = new InterstitialTime("APP_LAUNCH", 1);
            TRANSITION = new InterstitialTime("TRANSITION", 2);
            $VALUES = (new InterstitialTime[] {
                UNKNOWN, APP_LAUNCH, TRANSITION
            });
        }

        private InterstitialTime(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class MaritalStatus extends Enum
    {

        private static final MaritalStatus $VALUES[];
        public static final MaritalStatus DIVORCED;
        public static final MaritalStatus ENGAGED;
        public static final MaritalStatus MARRIED;
        public static final MaritalStatus OTHER;
        public static final MaritalStatus RELATIONSHIP;
        public static final MaritalStatus SINGLE;
        private final String description;

        public static MaritalStatus valueOf(String s)
        {
            return (MaritalStatus)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$MaritalStatus, s);
        }

        public static MaritalStatus[] values()
        {
            return (MaritalStatus[])$VALUES.clone();
        }

        public final String getDescription()
        {
            return description;
        }

        static 
        {
            SINGLE = new MaritalStatus("SINGLE", 0, "single");
            DIVORCED = new MaritalStatus("DIVORCED", 1, "divorced");
            ENGAGED = new MaritalStatus("ENGAGED", 2, "engaged");
            RELATIONSHIP = new MaritalStatus("RELATIONSHIP", 3, "relationship");
            MARRIED = new MaritalStatus("MARRIED", 4, "married");
            OTHER = new MaritalStatus("OTHER", 5, "other");
            $VALUES = (new MaritalStatus[] {
                SINGLE, DIVORCED, ENGAGED, RELATIONSHIP, MARRIED, OTHER
            });
        }

        private MaritalStatus(String s, int i, String s1)
        {
            super(s, i);
            description = s1;
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
        public static final Politics UNKNOWN;
        private final String description;

        public static Politics valueOf(String s)
        {
            return (Politics)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$Politics, s);
        }

        public static Politics[] values()
        {
            return (Politics[])$VALUES.clone();
        }

        public final String getDescription()
        {
            return description;
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
            UNKNOWN = new Politics("UNKNOWN", 7, "unknown");
            $VALUES = (new Politics[] {
                REPUBLICAN, DEMOCRAT, CONSERVATIVE, MODERATE, LIBERAL, INDEPENDENT, OTHER, UNKNOWN
            });
        }

        private Politics(String s, int i, String s1)
        {
            super(s, i);
            description = s1;
        }
    }


    public static final int NOT_SET = -1;
    private int age;
    private Children children;
    private Education education;
    private Ethnicity ethnicity;
    private Gender gender;
    private Integer income;
    private InterstitialTime interstitialTime;
    private String keywords;
    private Location location;
    private MaritalStatus maritalStatus;
    private Politics politics;
    private String postalCode;

    public MillennialAdapterExtras()
    {
        location = null;
        keywords = null;
        age = -1;
        interstitialTime = InterstitialTime.UNKNOWN;
        income = null;
        children = null;
        maritalStatus = null;
        ethnicity = null;
        gender = null;
        politics = null;
        education = null;
        postalCode = null;
    }

    public final MillennialAdapterExtras clearAge()
    {
        return setAge(-1);
    }

    public final MillennialAdapterExtras clearChildren()
    {
        return setChildren(null);
    }

    public final MillennialAdapterExtras clearEducation()
    {
        return setEducation(null);
    }

    public final MillennialAdapterExtras clearEthnicity()
    {
        return setEthnicity(null);
    }

    public final MillennialAdapterExtras clearGender()
    {
        return setGender(null);
    }

    public final MillennialAdapterExtras clearIncomeInUsDollars()
    {
        return setIncomeInUsDollars(null);
    }

    public final MillennialAdapterExtras clearInterstitialTime()
    {
        return setInterstitialTime(null);
    }

    public final MillennialAdapterExtras clearKeywords()
    {
        return setKeywords(null);
    }

    public final MillennialAdapterExtras clearLocations()
    {
        return setLocations(null);
    }

    public final MillennialAdapterExtras clearMaritalStatus()
    {
        return setMaritalStatus(null);
    }

    public final MillennialAdapterExtras clearPolitics()
    {
        return setPolitics(null);
    }

    public final MillennialAdapterExtras clearPostalCode()
    {
        return setPostalCode(null);
    }

    public final int getAge()
    {
        return age;
    }

    public final Children getChildren()
    {
        return children;
    }

    public final Education getEducation()
    {
        return education;
    }

    public final Ethnicity getEthnicity()
    {
        return ethnicity;
    }

    public final Gender getGender()
    {
        return gender;
    }

    public final Integer getIncomeInUsDollars()
    {
        return income;
    }

    public final InterstitialTime getInterstitialTime()
    {
        return interstitialTime;
    }

    public final String getKeywords()
    {
        return keywords;
    }

    public final Location getLocation()
    {
        return location;
    }

    public final MaritalStatus getMaritalStatus()
    {
        return maritalStatus;
    }

    public final Politics getPolitics()
    {
        return politics;
    }

    public final String getPostalCode()
    {
        return postalCode;
    }

    public final MillennialAdapterExtras setAge(int i)
    {
        age = i;
        return this;
    }

    public final MillennialAdapterExtras setChildren(Children children1)
    {
        children = children1;
        return this;
    }

    public final MillennialAdapterExtras setEducation(Education education1)
    {
        education = education1;
        return this;
    }

    public final MillennialAdapterExtras setEthnicity(Ethnicity ethnicity1)
    {
        ethnicity = ethnicity1;
        return this;
    }

    public final MillennialAdapterExtras setGender(Gender gender1)
    {
        gender = gender1;
        return this;
    }

    public final MillennialAdapterExtras setIncomeInUsDollars(Integer integer)
    {
        income = integer;
        return this;
    }

    public final MillennialAdapterExtras setInterstitialTime(InterstitialTime interstitialtime)
    {
        interstitialTime = interstitialtime;
        return this;
    }

    public final MillennialAdapterExtras setKeywords(String s)
    {
        keywords = s;
        return this;
    }

    public final MillennialAdapterExtras setLocations(Location location1)
    {
        location = location1;
        return this;
    }

    public final MillennialAdapterExtras setMaritalStatus(MaritalStatus maritalstatus)
    {
        maritalStatus = maritalstatus;
        return this;
    }

    public final MillennialAdapterExtras setPolitics(Politics politics1)
    {
        politics = politics1;
        return this;
    }

    public final MillennialAdapterExtras setPostalCode(String s)
    {
        postalCode = s;
        return this;
    }
}
