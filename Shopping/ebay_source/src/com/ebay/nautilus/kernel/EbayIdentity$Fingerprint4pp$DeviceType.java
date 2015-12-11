// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel;


// Referenced classes of package com.ebay.nautilus.kernel:
//            EbayIdentity

public static final class  extends Enum
{

    private static final Computer $VALUES[];
    public static final Computer Computer;
    public static final Computer Mid;
    public static final Computer Phone;
    public static final Computer Tablet;
    public static final Computer Unknown;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/kernel/EbayIdentity$Fingerprint4pp$DeviceType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Unknown = new <init>("Unknown", 0);
        Phone = new <init>("Phone", 1);
        Mid = new <init>("Mid", 2);
        Tablet = new <init>("Tablet", 3);
        Computer = new <init>("Computer", 4);
        $VALUES = (new .VALUES[] {
            Unknown, Phone, Mid, Tablet, Computer
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
