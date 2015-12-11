// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            Container

public static final class  extends Enum
{

    private static final NETWORK $VALUES[];
    public static final NETWORK NETWORK;
    public static final NETWORK SAVED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/tagmanager/Container$RefreshType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SAVED = new <init>("SAVED", 0);
        NETWORK = new <init>("NETWORK", 1);
        $VALUES = (new .VALUES[] {
            SAVED, NETWORK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
