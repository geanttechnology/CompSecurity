// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.publicurl;


// Referenced classes of package com.amazon.mShop.publicurl:
//            PublicURLProcessException

public static final class  extends Enum
{

    private static final ERROR_CODE_ERROR_PATH $VALUES[];
    public static final ERROR_CODE_ERROR_PATH ERROR_CODE_ERROR_HOSTNAME;
    public static final ERROR_CODE_ERROR_PATH ERROR_CODE_ERROR_PATH;
    public static final ERROR_CODE_ERROR_PATH ERROR_CODE_NEED_SIGNIN;
    public static final ERROR_CODE_ERROR_PATH ERROR_CODE_NEED_SWITCH_LOCALE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ERROR_CODE_NEED_SWITCH_LOCALE = new <init>("ERROR_CODE_NEED_SWITCH_LOCALE", 0);
        ERROR_CODE_NEED_SIGNIN = new <init>("ERROR_CODE_NEED_SIGNIN", 1);
        ERROR_CODE_ERROR_HOSTNAME = new <init>("ERROR_CODE_ERROR_HOSTNAME", 2);
        ERROR_CODE_ERROR_PATH = new <init>("ERROR_CODE_ERROR_PATH", 3);
        $VALUES = (new .VALUES[] {
            ERROR_CODE_NEED_SWITCH_LOCALE, ERROR_CODE_NEED_SIGNIN, ERROR_CODE_ERROR_HOSTNAME, ERROR_CODE_ERROR_PATH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
