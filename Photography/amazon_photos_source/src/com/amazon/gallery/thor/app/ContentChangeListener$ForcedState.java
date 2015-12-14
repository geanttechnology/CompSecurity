// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;


// Referenced classes of package com.amazon.gallery.thor.app:
//            ContentChangeListener

private static final class  extends Enum
{

    private static final FORCED_OFF $VALUES[];
    public static final FORCED_OFF FORCED_OFF;
    public static final FORCED_OFF FORCED_ON;
    public static final FORCED_OFF NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/app/ContentChangeListener$ForcedState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        FORCED_ON = new <init>("FORCED_ON", 1);
        FORCED_OFF = new <init>("FORCED_OFF", 2);
        $VALUES = (new .VALUES[] {
            NONE, FORCED_ON, FORCED_OFF
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
