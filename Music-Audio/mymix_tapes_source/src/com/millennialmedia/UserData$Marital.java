// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            UserData

public static final class value extends Enum
{

    private static final RELATIONSHIP $VALUES[];
    public static final RELATIONSHIP DIVORCED;
    public static final RELATIONSHIP MARRIED;
    public static final RELATIONSHIP RELATIONSHIP;
    public static final RELATIONSHIP SINGLE;
    public final String value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/millennialmedia/UserData$Marital, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    static 
    {
        SINGLE = new <init>("SINGLE", 0, "S");
        MARRIED = new <init>("MARRIED", 1, "M");
        DIVORCED = new <init>("DIVORCED", 2, "D");
        RELATIONSHIP = new <init>("RELATIONSHIP", 3, "O");
        $VALUES = (new .VALUES[] {
            SINGLE, MARRIED, DIVORCED, RELATIONSHIP
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }
}
