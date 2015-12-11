// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;


// Referenced classes of package co.vine.android.recorder:
//            VineFrameGrabber

static class ageMode
{

    static final int $SwitchMap$co$vine$android$recorder$VineFrameGrabber$ImageMode[];

    static 
    {
        $SwitchMap$co$vine$android$recorder$VineFrameGrabber$ImageMode = new int[ageMode.values().length];
        try
        {
            $SwitchMap$co$vine$android$recorder$VineFrameGrabber$ImageMode[ageMode.COLOR.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$co$vine$android$recorder$VineFrameGrabber$ImageMode[ageMode.GRAY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$co$vine$android$recorder$VineFrameGrabber$ImageMode[ageMode.RAW.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
