// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.sdk;


// Referenced classes of package com.inmobi.sdk:
//            InMobiSdk

public static final class a extends Enum
{

    private static final OTHER $VALUES[];
    public static final OTHER AFRICAN_AMERICAN;
    public static final OTHER ASIAN;
    public static final OTHER CAUCASIAN;
    public static final OTHER HISPANIC;
    public static final OTHER OTHER;
    private String a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/sdk/InMobiSdk$Ethnicity, s);
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
        AFRICAN_AMERICAN = new <init>("AFRICAN_AMERICAN", 0, "africanamerican");
        ASIAN = new <init>("ASIAN", 1, "asian");
        CAUCASIAN = new <init>("CAUCASIAN", 2, "caucasian");
        HISPANIC = new <init>("HISPANIC", 3, "hispanic");
        OTHER = new <init>("OTHER", 4, "other");
        $VALUES = (new .VALUES[] {
            AFRICAN_AMERICAN, ASIAN, CAUCASIAN, HISPANIC, OTHER
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        a = s1;
    }
}
