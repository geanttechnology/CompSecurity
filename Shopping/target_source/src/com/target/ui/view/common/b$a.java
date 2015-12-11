// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;


// Referenced classes of package com.target.ui.view.common:
//            b

public static final class  extends Enum
{

    private static final ERROR_DEFAULT $VALUES[];
    public static final ERROR_DEFAULT ERROR_DEFAULT;
    public static final ERROR_DEFAULT ERROR_NO_NETWORK;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/view/common/b$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ERROR_NO_NETWORK = new <init>("ERROR_NO_NETWORK", 0);
        ERROR_DEFAULT = new <init>("ERROR_DEFAULT", 1);
        $VALUES = (new .VALUES[] {
            ERROR_NO_NETWORK, ERROR_DEFAULT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
