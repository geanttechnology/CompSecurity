// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.extension.medialets;


// Referenced classes of package tv.freewheel.hybrid.extension.medialets:
//            MedialetsExtension

private static final class  extends Enum
{

    private static final STOP $VALUES[];
    public static final STOP RESUME;
    public static final STOP START;
    public static final STOP STOP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(tv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        START = new <init>("START", 0);
        RESUME = new <init>("RESUME", 1);
        STOP = new <init>("STOP", 2);
        $VALUES = (new .VALUES[] {
            START, RESUME, STOP
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
