// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import java.util.Locale;

// Referenced classes of package com.amazon.identity.auth.device:
//            AccountManagerConstants

public static final class  extends Enum
{

    private static final CN $VALUES[];
    public static final CN CA;
    public static final CN CN;
    public static final CN DE;
    public static final CN ES;
    public static final CN FR;
    public static final CN JP;
    private static final String LOCALE_SEPERATOR = "-";
    public static final CN UK;
    public static final CN US;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/auth/device/AccountManagerConstants$LOCALE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    public String toUrlString()
    {
        if (!US.equals(this))
        {
            return (new StringBuilder()).append(name().toLowerCase(Locale.US)).append("-").toString();
        } else
        {
            return "";
        }
    }

    static 
    {
        US = new <init>("US", 0);
        DE = new <init>("DE", 1);
        UK = new <init>("UK", 2);
        JP = new <init>("JP", 3);
        FR = new <init>("FR", 4);
        CA = new <init>("CA", 5);
        ES = new <init>("ES", 6);
        CN = new <init>("CN", 7);
        $VALUES = (new .VALUES[] {
            US, DE, UK, JP, FR, CA, ES, CN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
