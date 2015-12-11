// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.view_holders;


// Referenced classes of package com.poshmark.utils.view_holders:
//            PinterestDialog

public static final class  extends Enum
{

    private static final POST_CONN $VALUES[];
    public static final POST_CONN POST_CONN;
    public static final POST_CONN PRE_CONN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PRE_CONN = new <init>("PRE_CONN", 0);
        POST_CONN = new <init>("POST_CONN", 1);
        $VALUES = (new .VALUES[] {
            PRE_CONN, POST_CONN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
