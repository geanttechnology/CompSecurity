// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;


// Referenced classes of package com.moodmedia.moodpresence:
//            MoodPresenceResult

public static final class a extends Enum
{

    public static final ULTRASONIC SONIC;
    public static final ULTRASONIC ULTRASONIC;
    private static final ULTRASONIC b[];
    private int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/moodmedia/moodpresence/MoodPresenceResult$Type, s);
    }

    public static a[] values()
    {
        a aa[] = b;
        int i = aa.length;
        a aa1[] = new b[i];
        System.arraycopy(aa, 0, aa1, 0, i);
        return aa1;
    }

    public final int getValue()
    {
        return a;
    }

    static 
    {
        SONIC = new <init>("SONIC", 0, 0);
        ULTRASONIC = new <init>("ULTRASONIC", 1, 1);
        b = (new b[] {
            SONIC, ULTRASONIC
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
