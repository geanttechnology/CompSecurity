// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            UserData

public static final class value extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN FEMALE;
    public static final UNKNOWN MALE;
    public static final UNKNOWN UNKNOWN;
    public final String value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/millennialmedia/UserData$Gender, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    static 
    {
        MALE = new <init>("MALE", 0, "M");
        FEMALE = new <init>("FEMALE", 1, "F");
        UNKNOWN = new <init>("UNKNOWN", 2, "O");
        $VALUES = (new .VALUES[] {
            MALE, FEMALE, UNKNOWN
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }
}
