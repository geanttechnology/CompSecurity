// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;


// Referenced classes of package co.vine.android.recorder:
//            Processor

public static final class  extends Enum
{

    private static final SLOWER $VALUES[];
    public static final SLOWER FAST;
    public static final SLOWER FASTER;
    public static final SLOWER MEDIUM;
    public static final SLOWER SLOW;
    public static final SLOWER SLOWER;
    public static final SLOWER SUPERFAST;
    public static final SLOWER ULTRAFAST;
    public static final SLOWER VERYFAST;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(co/vine/android/recorder/Processor$Preset, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ULTRAFAST = new <init>("ULTRAFAST", 0);
        SUPERFAST = new <init>("SUPERFAST", 1);
        VERYFAST = new <init>("VERYFAST", 2);
        FASTER = new <init>("FASTER", 3);
        FAST = new <init>("FAST", 4);
        MEDIUM = new <init>("MEDIUM", 5);
        SLOW = new <init>("SLOW", 6);
        SLOWER = new <init>("SLOWER", 7);
        $VALUES = (new .VALUES[] {
            ULTRAFAST, SUPERFAST, VERYFAST, FASTER, FAST, MEDIUM, SLOW, SLOWER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
