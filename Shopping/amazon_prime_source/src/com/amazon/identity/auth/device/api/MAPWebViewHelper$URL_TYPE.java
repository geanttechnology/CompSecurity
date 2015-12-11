// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;


// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPWebViewHelper

public static final class  extends Enum
{

    private static final CONFIRM_CREDENTIAL $VALUES[];
    public static final CONFIRM_CREDENTIAL CONFIRM_CREDENTIAL;
    public static final CONFIRM_CREDENTIAL REGULAR;
    public static final CONFIRM_CREDENTIAL SIGNIN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        REGULAR = new <init>("REGULAR", 0);
        SIGNIN = new <init>("SIGNIN", 1);
        CONFIRM_CREDENTIAL = new <init>("CONFIRM_CREDENTIAL", 2);
        $VALUES = (new .VALUES[] {
            REGULAR, SIGNIN, CONFIRM_CREDENTIAL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
