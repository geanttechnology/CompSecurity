// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;


// Referenced classes of package com.rdio.android.core.sequencing:
//            SequencerUnit

public static final class _cls9 extends Enum
{

    private static final RepeatOne $VALUES[];
    public static final RepeatOne Normal;
    public static final RepeatOne RepeatAll;
    public static final RepeatOne RepeatOne;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/rdio/android/core/sequencing/SequencerUnit$Mode, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        Normal = new <init>("Normal", 0);
        RepeatAll = new <init>("RepeatAll", 1);
        RepeatOne = new <init>("RepeatOne", 2);
        $VALUES = (new .VALUES[] {
            Normal, RepeatAll, RepeatOne
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
