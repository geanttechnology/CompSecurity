// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;


// Referenced classes of package co.vine.android.recorder:
//            VineFrameGrabber

public static final class _cls9 extends Enum
{

    private static final RAW $VALUES[];
    public static final RAW COLOR;
    public static final RAW GRAY;
    public static final RAW RAW;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(co/vine/android/recorder/VineFrameGrabber$ImageMode, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        COLOR = new <init>("COLOR", 0);
        GRAY = new <init>("GRAY", 1);
        RAW = new <init>("RAW", 2);
        $VALUES = (new .VALUES[] {
            COLOR, GRAY, RAW
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
