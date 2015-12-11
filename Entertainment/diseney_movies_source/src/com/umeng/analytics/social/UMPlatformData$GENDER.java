// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;

import java.util.Locale;

// Referenced classes of package com.umeng.analytics.social:
//            UMPlatformData

public static class <init> extends Enum
{

    public static final FEMALE FEMALE;
    public static final FEMALE MALE;
    private static final FEMALE a[];
    public int value;

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/umeng/analytics/social/UMPlatformData$GENDER, s);
    }

    public static <init>[] values()
    {
        <init> a_3C_init>[] = a;
        int i = a_3C_init>.length;
        <init> a_3C_init>1[] = new a[i];
        System.arraycopy(a_3C_init>, 0, a_3C_init>1, 0, i);
        return a_3C_init>1;
    }

    static 
    {
        MALE = new UMPlatformData.GENDER("MALE", 0, 0) {

            public String toString()
            {
                return String.format(Locale.US, "Male:%d", new Object[] {
                    Integer.valueOf(value)
                });
            }

        };
        FEMALE = new UMPlatformData.GENDER("FEMALE", 1, 1) {

            public String toString()
            {
                return String.format(Locale.US, "Female:%d", new Object[] {
                    Integer.valueOf(value)
                });
            }

        };
        a = (new a[] {
            MALE, FEMALE
        });
    }

    private _cls2(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    value(String s, int i, int j, value value1)
    {
        this(s, i, j);
    }
}
