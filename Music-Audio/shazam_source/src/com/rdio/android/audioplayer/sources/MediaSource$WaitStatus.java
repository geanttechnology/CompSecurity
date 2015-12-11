// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.sources;


// Referenced classes of package com.rdio.android.audioplayer.sources:
//            MediaSource

public static final class A extends Enum
{

    private static final Cancelled $VALUES[];
    public static final Cancelled Cancelled;
    public static final Cancelled Success;
    public static final Cancelled TimedOut;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/rdio/android/audioplayer/sources/MediaSource$WaitStatus, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        Success = new <init>("Success", 0);
        TimedOut = new <init>("TimedOut", 1);
        Cancelled = new <init>("Cancelled", 2);
        $VALUES = (new .VALUES[] {
            Success, TimedOut, Cancelled
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
