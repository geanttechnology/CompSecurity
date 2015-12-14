// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.sdk;


// Referenced classes of package com.inmobi.sdk:
//            InMobiSdk

public static final class a extends Enum
{

    private static final MALE $VALUES[];
    public static final MALE FEMALE;
    public static final MALE MALE;
    private String a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/sdk/InMobiSdk$Gender, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    public String toString()
    {
        return a;
    }

    static 
    {
        FEMALE = new <init>("FEMALE", 0, "f");
        MALE = new <init>("MALE", 1, "m");
        $VALUES = (new .VALUES[] {
            FEMALE, MALE
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        a = s1;
    }
}
