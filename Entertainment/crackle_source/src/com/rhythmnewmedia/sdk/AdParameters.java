// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.content.Context;
import com.rhythmnewmedia.sdk.util.Util;
import java.util.GregorianCalendar;

public class AdParameters
{
    public static final class Gender extends Enum
    {

        private static final Gender a[];
        public static final Gender female;
        public static final Gender male;

        public static Gender valueOf(String s)
        {
            return (Gender)Enum.valueOf(com/rhythmnewmedia/sdk/AdParameters$Gender, s);
        }

        public static Gender[] values()
        {
            return (Gender[])a.clone();
        }

        static 
        {
            male = new Gender("male", 0);
            female = new Gender("female", 1);
            a = (new Gender[] {
                male, female
            });
        }

        private Gender(String s, int i)
        {
            super(s, i);
        }
    }


    private static String a;
    private static Gender b;
    private static String c;
    private static String d;
    private static GregorianCalendar e;
    private static boolean f = false;

    public AdParameters()
    {
    }

    public static String getAppId()
    {
        return a;
    }

    public static String getAreaCode()
    {
        return d;
    }

    public static GregorianCalendar getBirthday()
    {
        return e;
    }

    public static String getBuildDate()
    {
        return "09/28/2011 04:45 PM";
    }

    public static String getBuildNumber()
    {
        return "50831";
    }

    public static Gender getGender()
    {
        return b;
    }

    public static String getPostalCode()
    {
        return c;
    }

    public static String getUdid(Context context)
    {
        return Util.a(context);
    }

    public static String getVersion()
    {
        return "5.0.1";
    }

    public static boolean isTestMode()
    {
        return f;
    }

    public static void setAppId(String s)
    {
        a = s;
    }

    public static void setAreaCode(String s)
    {
        d = s;
    }

    public static void setBirthday(int i, int j, int k)
    {
        e = new GregorianCalendar(i, j, k);
    }

    public static void setBirthday(GregorianCalendar gregoriancalendar)
    {
        e = gregoriancalendar;
    }

    public static void setGender(Gender gender)
    {
        b = gender;
    }

    public static void setPostalCode(String s)
    {
        c = s;
    }

    public static void setTestMode(boolean flag)
    {
        f = flag;
    }

}
