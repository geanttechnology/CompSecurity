// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;


// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            NativeController

public static final class  extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN DATA;
    public static final UNKNOWN IMAGE;
    public static final UNKNOWN TITLE;
    public static final UNKNOWN UNKNOWN;
    public static final UNKNOWN VIDEO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/millennialmedia/internal/adcontrollers/NativeController$Asset$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TITLE = new <init>("TITLE", 0);
        IMAGE = new <init>("IMAGE", 1);
        VIDEO = new <init>("VIDEO", 2);
        DATA = new <init>("DATA", 3);
        UNKNOWN = new <init>("UNKNOWN", 4);
        $VALUES = (new .VALUES[] {
            TITLE, IMAGE, VIDEO, DATA, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
