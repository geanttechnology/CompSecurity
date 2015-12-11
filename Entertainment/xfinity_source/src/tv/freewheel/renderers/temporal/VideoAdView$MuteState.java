// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.temporal;


// Referenced classes of package tv.freewheel.renderers.temporal:
//            VideoAdView

private static final class  extends Enum
{

    private static final UNMUTED $VALUES[];
    public static final UNMUTED MUTED;
    public static final UNMUTED UNINITIALIZED;
    public static final UNMUTED UNMUTED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(tv/freewheel/renderers/temporal/VideoAdView$MuteState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNINITIALIZED = new <init>("UNINITIALIZED", 0);
        MUTED = new <init>("MUTED", 1);
        UNMUTED = new <init>("UNMUTED", 2);
        $VALUES = (new .VALUES[] {
            UNINITIALIZED, MUTED, UNMUTED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
