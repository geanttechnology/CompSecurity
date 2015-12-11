// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;


// Referenced classes of package co.vine.android.recorder:
//            AudioArray

public static final class  extends Enum
{

    private static final SHORT $VALUES[];
    public static final SHORT BYTE;
    public static final SHORT SHORT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(co/vine/android/recorder/AudioArray$AudioArrayType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BYTE = new <init>("BYTE", 0);
        SHORT = new <init>("SHORT", 1);
        $VALUES = (new .VALUES[] {
            BYTE, SHORT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
