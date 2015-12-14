// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            UserData

public static final class value extends Enum
{

    private static final PROFESSIONAL $VALUES[];
    public static final PROFESSIONAL ASSOCIATE;
    public static final PROFESSIONAL BACHELOR;
    public static final PROFESSIONAL HIGH_SCHOOL;
    public static final PROFESSIONAL MASTERS;
    public static final PROFESSIONAL PHD;
    public static final PROFESSIONAL PROFESSIONAL;
    public static final PROFESSIONAL SOME_COLLEGE;
    public final String value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/millennialmedia/UserData$Education, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    static 
    {
        HIGH_SCHOOL = new <init>("HIGH_SCHOOL", 0, "highschool");
        SOME_COLLEGE = new <init>("SOME_COLLEGE", 1, "somecollege");
        ASSOCIATE = new <init>("ASSOCIATE", 2, "associate");
        BACHELOR = new <init>("BACHELOR", 3, "bachelor");
        MASTERS = new <init>("MASTERS", 4, "masters");
        PHD = new <init>("PHD", 5, "phd");
        PROFESSIONAL = new <init>("PROFESSIONAL", 6, "professional");
        $VALUES = (new .VALUES[] {
            HIGH_SCHOOL, SOME_COLLEGE, ASSOCIATE, BACHELOR, MASTERS, PHD, PROFESSIONAL
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }
}
