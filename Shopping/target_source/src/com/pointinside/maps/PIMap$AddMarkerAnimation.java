// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;


// Referenced classes of package com.pointinside.maps:
//            PIMap

public static final class  extends Enum
{

    private static final FADE $VALUES[];
    public static final FADE DROP;
    public static final FADE FADE;
    public static final FADE NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/maps/PIMap$AddMarkerAnimation, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        DROP = new <init>("DROP", 1);
        FADE = new <init>("FADE", 2);
        $VALUES = (new .VALUES[] {
            NONE, DROP, FADE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
