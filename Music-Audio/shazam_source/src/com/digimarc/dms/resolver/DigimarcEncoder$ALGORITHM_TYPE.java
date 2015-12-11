// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;


// Referenced classes of package com.digimarc.dms.resolver:
//            DigimarcEncoder

public static final class  extends Enum
{

    private static final SHA512 $VALUES[];
    public static final SHA512 SHA256;
    public static final SHA512 SHA512;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/digimarc/dms/resolver/DigimarcEncoder$ALGORITHM_TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SHA256 = new <init>("SHA256", 0);
        SHA512 = new <init>("SHA512", 1);
        $VALUES = (new .VALUES[] {
            SHA256, SHA512
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
