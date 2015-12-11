// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel;


// Referenced classes of package com.ebay.nautilus.kernel:
//            EbayIdentity

public static final class  extends Enum
{

    private static final WindowsMobile $VALUES[];
    public static final WindowsMobile Android;
    public static final WindowsMobile Blackberry;
    public static final WindowsMobile Ios;
    public static final WindowsMobile Unknown;
    public static final WindowsMobile WindowsMobile;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/kernel/EbayIdentity$Fingerprint4pp$DeviceOs, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Unknown = new <init>("Unknown", 0);
        Ios = new <init>("Ios", 1);
        Android = new <init>("Android", 2);
        Blackberry = new <init>("Blackberry", 3);
        WindowsMobile = new <init>("WindowsMobile", 4);
        $VALUES = (new .VALUES[] {
            Unknown, Ios, Android, Blackberry, WindowsMobile
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
