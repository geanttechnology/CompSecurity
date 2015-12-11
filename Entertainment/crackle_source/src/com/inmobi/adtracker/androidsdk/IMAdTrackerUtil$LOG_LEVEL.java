// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.adtracker.androidsdk;


// Referenced classes of package com.inmobi.adtracker.androidsdk:
//            IMAdTrackerUtil

public static final class value extends Enum
{

    public static final VERBOSE DEBUG;
    private static final VERBOSE ENUM$VALUES[];
    public static final VERBOSE NONE;
    public static final VERBOSE VERBOSE;
    private final int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/inmobi/adtracker/androidsdk/IMAdTrackerUtil$LOG_LEVEL, s);
    }

    public static value[] values()
    {
        value avalue[] = ENUM$VALUES;
        int i = avalue.length;
        value avalue1[] = new ENUM.VALUES[i];
        System.arraycopy(avalue, 0, avalue1, 0, i);
        return avalue1;
    }

    public int getValue()
    {
        return value;
    }

    static 
    {
        NONE = new <init>("NONE", 0, 0);
        DEBUG = new <init>("DEBUG", 1, 1);
        VERBOSE = new <init>("VERBOSE", 2, 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            NONE, DEBUG, VERBOSE
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
