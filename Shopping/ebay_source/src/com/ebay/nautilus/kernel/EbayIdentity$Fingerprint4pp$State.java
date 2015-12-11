// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel;


// Referenced classes of package com.ebay.nautilus.kernel:
//            EbayIdentity

private static final class  extends Enum
{

    private static final Encrypted $VALUES[];
    public static final Encrypted Encrypted;
    public static final Encrypted HmacCalculated;
    public static final Encrypted Unencrypted;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/kernel/EbayIdentity$Fingerprint4pp$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Unencrypted = new <init>("Unencrypted", 0);
        HmacCalculated = new <init>("HmacCalculated", 1);
        Encrypted = new <init>("Encrypted", 2);
        $VALUES = (new .VALUES[] {
            Unencrypted, HmacCalculated, Encrypted
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
