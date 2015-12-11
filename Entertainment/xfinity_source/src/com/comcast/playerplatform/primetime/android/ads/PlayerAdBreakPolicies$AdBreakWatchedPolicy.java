// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;


// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            PlayerAdBreakPolicies

public static final class a extends Enum
{

    private static final DO_NOT_MARK $VALUES[];
    public static final DO_NOT_MARK DO_NOT_MARK;
    public static final DO_NOT_MARK MARK_AS_WATCHED;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    static 
    {
        MARK_AS_WATCHED = new <init>("MARK_AS_WATCHED", 0);
        DO_NOT_MARK = new <init>("DO_NOT_MARK", 1);
        $VALUES = (new .VALUES[] {
            MARK_AS_WATCHED, DO_NOT_MARK
        });
    }

    private a(String s, int i)
    {
        super(s, i);
    }
}
