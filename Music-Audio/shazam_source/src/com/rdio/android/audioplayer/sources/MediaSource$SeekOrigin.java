// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.sources;


// Referenced classes of package com.rdio.android.audioplayer.sources:
//            MediaSource

public static final class A extends Enum
{

    private static final End $VALUES[];
    public static final End Begin;
    public static final End Current;
    public static final End End;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/rdio/android/audioplayer/sources/MediaSource$SeekOrigin, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        Begin = new <init>("Begin", 0);
        Current = new <init>("Current", 1);
        End = new <init>("End", 2);
        $VALUES = (new .VALUES[] {
            Begin, Current, End
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
