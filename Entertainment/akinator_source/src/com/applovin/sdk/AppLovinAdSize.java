// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.sdk;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AppLovinAdSize
{

    public static final AppLovinAdSize BANNER = new AppLovinAdSize(-1, 50, "BANNER");
    public static final AppLovinAdSize INTERSTITIAL = new AppLovinAdSize(-1, -1, "INTER");
    public static final AppLovinAdSize LEADER = new AppLovinAdSize(-1, 75, "LEADER");
    public static final AppLovinAdSize MREC = new AppLovinAdSize(300, 250, "MREC");
    public static final int SPAN = -1;
    private final int a;
    private final int b;
    private final String c;

    AppLovinAdSize(int i, int j, String s)
    {
        if (i < 0 && i != -1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Ad width must be a positive number. Number provided: ").append(i).toString());
        }
        if (i > 9999)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Ad width must be less then 9999. Number provided: ").append(i).toString());
        }
        if (j < 0 && j != -1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Ad height must be a positive number. Number provided: ").append(j).toString());
        }
        if (j > 9999)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Ad height must be less then 9999. Number provided: ").append(j).toString());
        }
        if (s == null)
        {
            throw new IllegalArgumentException("No label specified");
        }
        if (s.length() > 9)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Provided label is too long. Label provided: ").append(s).toString());
        } else
        {
            a = i;
            b = j;
            c = s;
            return;
        }
    }

    public AppLovinAdSize(String s)
    {
        this(0, 0, s);
    }

    private static int a(String s)
    {
        if ("span".equalsIgnoreCase(s))
        {
            return -1;
        }
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0;
        }
        return i;
    }

    public static Set allSizes()
    {
        HashSet hashset = new HashSet(4);
        hashset.add(BANNER);
        hashset.add(MREC);
        hashset.add(INTERSTITIAL);
        hashset.add(LEADER);
        return hashset;
    }

    public static AppLovinAdSize fromString(String s)
    {
        if (s == null || s.length() < 1)
        {
            return null;
        }
        String s1 = s.toLowerCase(Locale.ENGLISH);
        if (s1.equals("banner"))
        {
            return BANNER;
        }
        if (s1.equals("interstitial") || s1.equals("inter"))
        {
            return INTERSTITIAL;
        }
        if (s1.equals("mrec"))
        {
            return MREC;
        }
        if (s1.equals("leader"))
        {
            return LEADER;
        }
        String as[] = s.split("x");
        if (as.length == 2)
        {
            return new AppLovinAdSize(a(as[0]), a(as[1]), s);
        } else
        {
            return new AppLovinAdSize(0, 0, s);
        }
    }

    public int getHeight()
    {
        return b;
    }

    public String getLabel()
    {
        return c.toUpperCase(Locale.ENGLISH);
    }

    public int getWidth()
    {
        return a;
    }

    public String toString()
    {
        return getLabel();
    }

}
