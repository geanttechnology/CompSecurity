// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Handler;
import com.inmobi.commons.core.configs.b;
import com.inmobi.commons.core.configs.c;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.info.e;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.rendering.mraid.i;
import com.inmobi.signals.a;
import com.inmobi.signals.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class InMobiSdk
{
    public static final class AgeGroup extends Enum
    {

        private static final AgeGroup $VALUES[];
        public static final AgeGroup ABOVE_55;
        public static final AgeGroup BELOW_18;
        public static final AgeGroup BETWEEN_18_AND_20;
        public static final AgeGroup BETWEEN_21_AND_24;
        public static final AgeGroup BETWEEN_25_AND_34;
        public static final AgeGroup BETWEEN_35_AND_54;
        private String a;

        public static AgeGroup valueOf(String s)
        {
            return (AgeGroup)Enum.valueOf(com/inmobi/sdk/InMobiSdk$AgeGroup, s);
        }

        public static AgeGroup[] values()
        {
            return (AgeGroup[])$VALUES.clone();
        }

        public String toString()
        {
            return a;
        }

        static 
        {
            BELOW_18 = new AgeGroup("BELOW_18", 0, "below18");
            BETWEEN_18_AND_20 = new AgeGroup("BETWEEN_18_AND_20", 1, "between18and20");
            BETWEEN_21_AND_24 = new AgeGroup("BETWEEN_21_AND_24", 2, "between21and24");
            BETWEEN_25_AND_34 = new AgeGroup("BETWEEN_25_AND_34", 3, "between25and34");
            BETWEEN_35_AND_54 = new AgeGroup("BETWEEN_35_AND_54", 4, "between35and54");
            ABOVE_55 = new AgeGroup("ABOVE_55", 5, "above55");
            $VALUES = (new AgeGroup[] {
                BELOW_18, BETWEEN_18_AND_20, BETWEEN_21_AND_24, BETWEEN_25_AND_34, BETWEEN_35_AND_54, ABOVE_55
            });
        }

        private AgeGroup(String s, int j, String s1)
        {
            super(s, j);
            a = s1;
        }
    }

    public static final class Education extends Enum
    {

        private static final Education $VALUES[];
        public static final Education COLLEGE_OR_GRADUATE;
        public static final Education HIGH_SCHOOL_OR_LESS;
        public static final Education POST_GRADUATE_OR_ABOVE;
        private String a;

        public static Education valueOf(String s)
        {
            return (Education)Enum.valueOf(com/inmobi/sdk/InMobiSdk$Education, s);
        }

        public static Education[] values()
        {
            return (Education[])$VALUES.clone();
        }

        public String toString()
        {
            return a;
        }

        static 
        {
            HIGH_SCHOOL_OR_LESS = new Education("HIGH_SCHOOL_OR_LESS", 0, "highschoolorless");
            COLLEGE_OR_GRADUATE = new Education("COLLEGE_OR_GRADUATE", 1, "collegeorgraduate");
            POST_GRADUATE_OR_ABOVE = new Education("POST_GRADUATE_OR_ABOVE", 2, "postgraduateorabove");
            $VALUES = (new Education[] {
                HIGH_SCHOOL_OR_LESS, COLLEGE_OR_GRADUATE, POST_GRADUATE_OR_ABOVE
            });
        }

        private Education(String s, int j, String s1)
        {
            super(s, j);
            a = s1;
        }
    }

    public static final class Ethnicity extends Enum
    {

        private static final Ethnicity $VALUES[];
        public static final Ethnicity AFRICAN_AMERICAN;
        public static final Ethnicity ASIAN;
        public static final Ethnicity CAUCASIAN;
        public static final Ethnicity HISPANIC;
        public static final Ethnicity OTHER;
        private String a;

        public static Ethnicity valueOf(String s)
        {
            return (Ethnicity)Enum.valueOf(com/inmobi/sdk/InMobiSdk$Ethnicity, s);
        }

        public static Ethnicity[] values()
        {
            return (Ethnicity[])$VALUES.clone();
        }

        public String toString()
        {
            return a;
        }

        static 
        {
            AFRICAN_AMERICAN = new Ethnicity("AFRICAN_AMERICAN", 0, "africanamerican");
            ASIAN = new Ethnicity("ASIAN", 1, "asian");
            CAUCASIAN = new Ethnicity("CAUCASIAN", 2, "caucasian");
            HISPANIC = new Ethnicity("HISPANIC", 3, "hispanic");
            OTHER = new Ethnicity("OTHER", 4, "other");
            $VALUES = (new Ethnicity[] {
                AFRICAN_AMERICAN, ASIAN, CAUCASIAN, HISPANIC, OTHER
            });
        }

        private Ethnicity(String s, int j, String s1)
        {
            super(s, j);
            a = s1;
        }
    }

    public static final class Gender extends Enum
    {

        private static final Gender $VALUES[];
        public static final Gender FEMALE;
        public static final Gender MALE;
        private String a;

        public static Gender valueOf(String s)
        {
            return (Gender)Enum.valueOf(com/inmobi/sdk/InMobiSdk$Gender, s);
        }

        public static Gender[] values()
        {
            return (Gender[])$VALUES.clone();
        }

        public String toString()
        {
            return a;
        }

        static 
        {
            FEMALE = new Gender("FEMALE", 0, "f");
            MALE = new Gender("MALE", 1, "m");
            $VALUES = (new Gender[] {
                FEMALE, MALE
            });
        }

        private Gender(String s, int j, String s1)
        {
            super(s, j);
            a = s1;
        }
    }

    public static final class HouseHoldIncome extends Enum
    {

        private static final HouseHoldIncome $VALUES[];
        public static final HouseHoldIncome ABOVE_USD_150K;
        public static final HouseHoldIncome BELOW_USD_5K;
        public static final HouseHoldIncome BETWEEN_USD_100K_AND_150K;
        public static final HouseHoldIncome BETWEEN_USD_10K_AND_15K;
        public static final HouseHoldIncome BETWEEN_USD_15K_AND_20K;
        public static final HouseHoldIncome BETWEEN_USD_20K_AND_25K;
        public static final HouseHoldIncome BETWEEN_USD_25K_AND_50K;
        public static final HouseHoldIncome BETWEEN_USD_50K_AND_75K;
        public static final HouseHoldIncome BETWEEN_USD_5K_AND_10K;
        public static final HouseHoldIncome BETWEEN_USD_75K_AND_100K;
        private String a;

        public static HouseHoldIncome valueOf(String s)
        {
            return (HouseHoldIncome)Enum.valueOf(com/inmobi/sdk/InMobiSdk$HouseHoldIncome, s);
        }

        public static HouseHoldIncome[] values()
        {
            return (HouseHoldIncome[])$VALUES.clone();
        }

        public String toString()
        {
            return a;
        }

        static 
        {
            BELOW_USD_5K = new HouseHoldIncome("BELOW_USD_5K", 0, "belowusd5k");
            BETWEEN_USD_5K_AND_10K = new HouseHoldIncome("BETWEEN_USD_5K_AND_10K", 1, "betweenusd5kand10k");
            BETWEEN_USD_10K_AND_15K = new HouseHoldIncome("BETWEEN_USD_10K_AND_15K", 2, "betweenusd10kand15k");
            BETWEEN_USD_15K_AND_20K = new HouseHoldIncome("BETWEEN_USD_15K_AND_20K", 3, "betweenusd15kand20k");
            BETWEEN_USD_20K_AND_25K = new HouseHoldIncome("BETWEEN_USD_20K_AND_25K", 4, "betweenusd20kand25k");
            BETWEEN_USD_25K_AND_50K = new HouseHoldIncome("BETWEEN_USD_25K_AND_50K", 5, "betweenusd25kand50k");
            BETWEEN_USD_50K_AND_75K = new HouseHoldIncome("BETWEEN_USD_50K_AND_75K", 6, "betweenusd50kand75k");
            BETWEEN_USD_75K_AND_100K = new HouseHoldIncome("BETWEEN_USD_75K_AND_100K", 7, "betweenusd75kand100k");
            BETWEEN_USD_100K_AND_150K = new HouseHoldIncome("BETWEEN_USD_100K_AND_150K", 8, "betweenusd100kand150k");
            ABOVE_USD_150K = new HouseHoldIncome("ABOVE_USD_150K", 9, "aboveusd150k");
            $VALUES = (new HouseHoldIncome[] {
                BELOW_USD_5K, BETWEEN_USD_5K_AND_10K, BETWEEN_USD_10K_AND_15K, BETWEEN_USD_15K_AND_20K, BETWEEN_USD_20K_AND_25K, BETWEEN_USD_25K_AND_50K, BETWEEN_USD_50K_AND_75K, BETWEEN_USD_75K_AND_100K, BETWEEN_USD_100K_AND_150K, ABOVE_USD_150K
            });
        }

        private HouseHoldIncome(String s, int j, String s1)
        {
            super(s, j);
            a = s1;
        }
    }

    public static final class ImIdType extends Enum
    {

        private static final ImIdType $VALUES[];
        public static final ImIdType LOGIN;
        public static final ImIdType SESSION;

        public static ImIdType valueOf(String s)
        {
            return (ImIdType)Enum.valueOf(com/inmobi/sdk/InMobiSdk$ImIdType, s);
        }

        public static ImIdType[] values()
        {
            return (ImIdType[])$VALUES.clone();
        }

        static 
        {
            LOGIN = new ImIdType("LOGIN", 0);
            SESSION = new ImIdType("SESSION", 1);
            $VALUES = (new ImIdType[] {
                LOGIN, SESSION
            });
        }

        private ImIdType(String s, int j)
        {
            super(s, j);
        }
    }

    public static final class LogLevel extends Enum
    {

        private static final LogLevel $VALUES[];
        public static final LogLevel DEBUG;
        public static final LogLevel ERROR;
        public static final LogLevel NONE;

        public static LogLevel valueOf(String s)
        {
            return (LogLevel)Enum.valueOf(com/inmobi/sdk/InMobiSdk$LogLevel, s);
        }

        public static LogLevel[] values()
        {
            return (LogLevel[])$VALUES.clone();
        }

        static 
        {
            NONE = new LogLevel("NONE", 0);
            ERROR = new LogLevel("ERROR", 1);
            DEBUG = new LogLevel("DEBUG", 2);
            $VALUES = (new LogLevel[] {
                NONE, ERROR, DEBUG
            });
        }

        private LogLevel(String s, int j)
        {
            super(s, j);
        }
    }


    private static final String TAG = com/inmobi/sdk/InMobiSdk.getSimpleName();

    public InMobiSdk()
    {
    }

    public static final void addIdType(ImIdType imidtype, String s)
    {
        if (imidtype == ImIdType.LOGIN)
        {
            e.n(s);
        } else
        if (imidtype == ImIdType.SESSION)
        {
            e.o(s);
            return;
        }
    }

    private static void clearCachedData(Context context)
    {
        List list1 = Arrays.asList(new String[] {
            "carbpreference", "IMAdMLtvpRuleCache", "inmobiAppAnalyticsSession", "aeskeygenerate", "impref", "IMAdTrackerStatusUpload", "IMAdMMediationCache", "inmobiAppAnalyticsAppId", "inmobiAppAnalyticsSession", "inmobisdkaid", 
            "IMAdTrackerStatusUpload", "testAppPref"
        });
        List list = Arrays.asList(new String[] {
            a.a(), c.a(), com.inmobi.commons.core.utilities.a.a.a(), i.a(), e.a()
        });
        for (int j = 0; j < list1.size(); j++)
        {
            File file3 = new File((new StringBuilder()).append("/data/data/").append(context.getPackageName()).append("/shared_prefs/").append((String)list1.get(j)).append(".xml").toString());
            if (file3.exists())
            {
                file3.delete();
            }
        }

        for (int k = 0; k < list.size(); k++)
        {
            File file = new File((new StringBuilder()).append("/data/data/").append(context.getPackageName()).append("/shared_prefs/").append((String)list.get(k)).append(".xml").toString());
            if (file.exists())
            {
                file.delete();
            }
        }

        list = Arrays.asList(new String[] {
            "inmobi.cache", "inmobi.cache.data", "inmobi.cache.data.events.number", "inmobi.cache.data.events.timestamp"
        });
        for (int l = 0; l < list.size(); l++)
        {
            if (context.getCacheDir() == null)
            {
                continue;
            }
            File file1 = new File(context.getCacheDir(), (String)list.get(l));
            if (file1.exists())
            {
                file1.delete();
            }
        }

        list = Arrays.asList(new String[] {
            "eventlog", "imai_click_events"
        });
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            if (context.getDir("data", 0) == null)
            {
                continue;
            }
            File file2 = new File(context.getDir("data", 0), (String)list.get(i1));
            if (file2.exists())
            {
                file2.delete();
            }
        }

        context.deleteDatabase("adcache.db");
        context.deleteDatabase("appengage.db");
        context.deleteDatabase("im.db");
        context.deleteDatabase("ltvp.db");
        context.deleteDatabase("analytics.db");
        context.deleteDatabase("com.im.db");
    }

    private static void deInitComponents()
    {
        b.a().c();
        com.inmobi.commons.core.c.a.a().c();
        o.a().c();
        com.inmobi.ads.i.a().c();
    }

    public static String getVersion()
    {
        return com.inmobi.commons.a.b.b();
    }

    private static boolean hasSdkVersionChanged(Context context)
    {
        return com.inmobi.commons.a.b.a(context) == null || !com.inmobi.commons.a.b.a(context).equals(com.inmobi.commons.a.b.b());
    }

    public static void init(Context context, String s)
    {
        if (context == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Context supplied as null, SDK could not be initialized.");
        } else
        {
            if (s == null || s.trim().length() == 0)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Account ID cannot be null or empty. Please provide a valid Account ID.");
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.inmobi.rendering.InMobiAdActivity");
            if (context.getPackageManager().resolveActivity(intent, 0x10000) == null)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "The activity com.inmobi.rendering.InMobiAdActivity not present in AndroidManifest. SDK could not be initialized.");
                return;
            }
            s = s.trim();
            if (s.length() != 32 && s.length() != 36)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.DEBUG, TAG, "Invalid account id passed to init. Please provide a valid account id");
            }
            if (com.inmobi.commons.a.a.a())
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, TAG, "SDK already initialized");
                return;
            }
            if (hasSdkVersionChanged(context))
            {
                clearCachedData(context);
                com.inmobi.commons.a.b.a(context, com.inmobi.commons.a.b.b());
            }
            com.inmobi.commons.a.a.a(context, s);
            e.b();
            initComponents();
            b.a().d();
            context = com.inmobi.commons.core.utilities.a.a();
            if (context != null)
            {
                context.a(new com.inmobi.commons.core.utilities.a.b() {

                    public void a(boolean flag)
                    {
                        com.inmobi.commons.a.a.a(flag);
                        if (flag)
                        {
                            InMobiSdk.initComponents();
                            return;
                        } else
                        {
                            InMobiSdk.deInitComponents();
                            return;
                        }
                    }

                });
                return;
            }
        }
    }

    private static void initComponents()
    {
        com.inmobi.commons.core.utilities.uid.c.a().b();
        com.inmobi.commons.core.utilities.uid.c.a().d();
        b.a().b();
        com.inmobi.rendering.a.c.a().b();
        com.inmobi.commons.core.a.c.a();
        com.inmobi.commons.core.c.a.a().b();
        o.a().b();
        (new Handler(com.inmobi.commons.a.a.b().getMainLooper())).postDelayed(new Runnable() {

            public void run()
            {
                InMobiSdk.promptUserForLocationPermissionsIfNeeded();
            }

        }, 250L);
        com.inmobi.ads.i.a().b();
    }

    private static void promptUserForLocationPermissionsIfNeeded()
    {
        if (android.os.Build.VERSION.SDK_INT >= 23 && o.a().h())
        {
            ArrayList arraylist = new ArrayList();
            if (com.inmobi.commons.a.a.b().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && com.inmobi.commons.a.a.a("android.permission.ACCESS_FINE_LOCATION"))
            {
                arraylist.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if (com.inmobi.commons.a.a.b().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0 && com.inmobi.commons.a.a.a("android.permission.ACCESS_COARSE_LOCATION"))
            {
                arraylist.add("android.permission.ACCESS_COARSE_LOCATION");
            }
            InMobiAdActivity.a((String[])arraylist.toArray(new String[arraylist.size()]), null);
        }
    }

    public static final void removeIdType(ImIdType imidtype)
    {
        if (imidtype == ImIdType.LOGIN)
        {
            e.n(null);
        } else
        if (imidtype == ImIdType.SESSION)
        {
            e.o(null);
            return;
        }
    }

    public static final void setAge(int j)
    {
        e.a(j);
    }

    public static final void setAgeGroup(AgeGroup agegroup)
    {
        e.a(agegroup.toString().toLowerCase(Locale.ENGLISH));
    }

    public static final void setAreaCode(String s)
    {
        e.b(s);
    }

    public static final void setEducation(Education education)
    {
        e.i(education.toString().toLowerCase(Locale.ENGLISH));
    }

    public static final void setEthnicity(Ethnicity ethnicity)
    {
        e.h(ethnicity.toString().toLowerCase(Locale.ENGLISH));
    }

    public static final void setGender(Gender gender)
    {
        e.g(gender.toString().toLowerCase(Locale.ENGLISH));
    }

    public static final void setHouseHoldIncome(HouseHoldIncome householdincome)
    {
        e.k(householdincome.toString().toLowerCase(Locale.ENGLISH));
    }

    public static final void setIncome(int j)
    {
        e.c(j);
    }

    public static final void setInterests(String s)
    {
        e.l(s);
    }

    public static final void setLanguage(String s)
    {
        e.j(s);
    }

    public static final void setLocation(Location location)
    {
        e.a(location);
    }

    public static final void setLocationWithCityStateCountry(String s, String s1, String s2)
    {
        e.d(s);
        e.e(s1);
        e.f(s2);
    }

    public static void setLogLevel(LogLevel loglevel)
    {
        static class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[LogLevel.values().length];
                try
                {
                    a[LogLevel.NONE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[LogLevel.ERROR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[LogLevel.DEBUG.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.inmobi.sdk._cls3.a[loglevel.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.NONE);
            return;

        case 2: // '\002'
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR);
            return;

        case 3: // '\003'
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.DEBUG);
            break;
        }
    }

    public static final void setNationality(String s)
    {
        e.m(s);
    }

    public static final void setPostalCode(String s)
    {
        e.c(s);
    }

    public static final void setYearOfBirth(int j)
    {
        e.b(j);
    }




}
