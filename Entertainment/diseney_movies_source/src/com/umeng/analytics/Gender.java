// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import java.util.Locale;
import u.aly.ap;

public class Gender extends Enum
{

    public static final Gender Female;
    public static final Gender Male;
    public static final Gender Unknown;
    private static int a[];
    private static final Gender b[];
    public int value;

    private Gender(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    Gender(String s, int i, int j, Gender gender)
    {
        this(s, i, j);
    }

    static int[] a()
    {
        int ai[] = a;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[values().length];
        try
        {
            ai[Female.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[Male.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[Unknown.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        a = ai;
        return ai;
    }

    public static Gender getGender(int i)
    {
        switch (i)
        {
        default:
            return Unknown;

        case 1: // '\001'
            return Male;

        case 2: // '\002'
            return Female;
        }
    }

    public static ap transGender(Gender gender)
    {
        switch (a()[gender.ordinal()])
        {
        default:
            return ap.c;

        case 1: // '\001'
            return ap.a;

        case 2: // '\002'
            return ap.b;
        }
    }

    public static Gender valueOf(String s)
    {
        return (Gender)Enum.valueOf(com/umeng/analytics/Gender, s);
    }

    public static Gender[] values()
    {
        Gender agender[] = b;
        int i = agender.length;
        Gender agender1[] = new Gender[i];
        System.arraycopy(agender, 0, agender1, 0, i);
        return agender1;
    }

    public int value()
    {
        return value;
    }

    static 
    {
        Male = new Gender("Male", 0, 1) {

            public String toString()
            {
                return String.format(Locale.US, "Male:%d", new Object[] {
                    Integer.valueOf(value)
                });
            }

        };
        Female = new Gender("Female", 1, 2) {

            public String toString()
            {
                return String.format(Locale.US, "Female:%d", new Object[] {
                    Integer.valueOf(value)
                });
            }

        };
        Unknown = new Gender("Unknown", 2, 0) {

            public String toString()
            {
                return String.format(Locale.US, "Unknown:%d", new Object[] {
                    Integer.valueOf(value)
                });
            }

        };
        b = (new Gender[] {
            Male, Female, Unknown
        });
    }
}
