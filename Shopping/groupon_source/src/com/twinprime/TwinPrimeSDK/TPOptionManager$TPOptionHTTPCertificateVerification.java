// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPOptionManager

static final class  extends Enum
{

    private static final TPOptionHTTPCertificateVerification_disable $VALUES[];
    public static final TPOptionHTTPCertificateVerification_disable TPOptionHTTPCertificateVerification_disable;
    public static final TPOptionHTTPCertificateVerification_disable TPOptionHTTPCertificateVerification_enable;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionHTTPCertificateVerification, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TPOptionHTTPCertificateVerification_enable = new <init>("TPOptionHTTPCertificateVerification_enable", 0);
        TPOptionHTTPCertificateVerification_disable = new <init>("TPOptionHTTPCertificateVerification_disable", 1);
        $VALUES = (new .VALUES[] {
            TPOptionHTTPCertificateVerification_enable, TPOptionHTTPCertificateVerification_disable
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
