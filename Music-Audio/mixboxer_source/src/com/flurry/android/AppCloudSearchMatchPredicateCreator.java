// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            AppCloudSearchPredicateMatch

public class AppCloudSearchMatchPredicateCreator
{

    private AppCloudSearchMatchPredicateCreator()
    {
    }

    public static AppCloudSearchPredicateMatch beginsWith(String s, String s1)
    {
        return new AppCloudSearchPredicateMatch((new StringBuilder()).append(s).append("%20bw%20").append(s1).toString());
    }

    public static AppCloudSearchPredicateMatch contains(String s, String s1)
    {
        return new AppCloudSearchPredicateMatch((new StringBuilder()).append(s).append("%20c%20").append(s1).toString());
    }

    public static AppCloudSearchPredicateMatch endsWith(String s, String s1)
    {
        return new AppCloudSearchPredicateMatch((new StringBuilder()).append(s).append("%20ew%20").append(s1).toString());
    }

    public static AppCloudSearchPredicateMatch equalTo(String s, String s1)
    {
        return new AppCloudSearchPredicateMatch((new StringBuilder()).append(s).append("%20eq%20").append(s1).toString());
    }

    public static AppCloudSearchPredicateMatch greaterThan(String s, String s1)
    {
        return new AppCloudSearchPredicateMatch((new StringBuilder()).append(s).append("%20gt%20").append(s1).toString());
    }

    public static AppCloudSearchPredicateMatch greaterThanOrEquals(String s, String s1)
    {
        return new AppCloudSearchPredicateMatch((new StringBuilder()).append(s).append("%20gte%20").append(s1).toString());
    }

    public static AppCloudSearchPredicateMatch inRange(String s, String as[])
    {
        String s1 = "";
        int i = 0;
        while (i < as.length) 
        {
            if (i == as.length - 1)
            {
                s1 = (new StringBuilder()).append(s1).append(as[i]).toString();
            } else
            {
                s1 = (new StringBuilder()).append(s1).append(as[i]).append(",").toString();
            }
            i++;
        }
        return new AppCloudSearchPredicateMatch((new StringBuilder()).append(s).append("%20in%20").append(s1).toString());
    }

    public static AppCloudSearchPredicateMatch lessThan(String s, String s1)
    {
        return new AppCloudSearchPredicateMatch((new StringBuilder()).append(s).append("%20lt%20").append(s1).toString());
    }

    public static AppCloudSearchPredicateMatch lessThanOrEquals(String s, String s1)
    {
        return new AppCloudSearchPredicateMatch((new StringBuilder()).append(s).append("%20lte%20").append(s1).toString());
    }

    public static AppCloudSearchPredicateMatch notBeginsWith(String s, String s1)
    {
        return new AppCloudSearchPredicateMatch((new StringBuilder()).append(s).append("%20nbw%20").append(s1).toString());
    }

    public static AppCloudSearchPredicateMatch notContains(String s, String s1)
    {
        return new AppCloudSearchPredicateMatch((new StringBuilder()).append(s).append("%20nc%20").append(s1).toString());
    }

    public static AppCloudSearchPredicateMatch notEndsWith(String s, String s1)
    {
        return new AppCloudSearchPredicateMatch((new StringBuilder()).append(s).append("%20new%20").append(s1).toString());
    }

    public static AppCloudSearchPredicateMatch notEqualTo(String s, String s1)
    {
        return new AppCloudSearchPredicateMatch((new StringBuilder()).append(s).append("%20ne%20").append(s1).toString());
    }
}
