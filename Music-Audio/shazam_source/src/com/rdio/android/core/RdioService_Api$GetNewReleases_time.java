// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;


// Referenced classes of package com.rdio.android.core:
//            RdioService_Api

public static final class  extends Enum
{

    private static final Twoweeks $VALUES[];
    public static final Twoweeks Lastweek;
    public static final Twoweeks Overview;
    public static final Twoweeks Thisweek;
    public static final Twoweeks Twoweeks;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/core/RdioService_Api$GetNewReleases_time, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Thisweek = new <init>("Thisweek", 0);
        Overview = new <init>("Overview", 1);
        Lastweek = new <init>("Lastweek", 2);
        Twoweeks = new <init>("Twoweeks", 3);
        $VALUES = (new .VALUES[] {
            Thisweek, Overview, Lastweek, Twoweeks
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
