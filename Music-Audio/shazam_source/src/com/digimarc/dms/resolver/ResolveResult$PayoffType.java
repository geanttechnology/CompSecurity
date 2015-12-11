// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;


// Referenced classes of package com.digimarc.dms.resolver:
//            ResolveResult

public static final class  extends Enum
{

    private static final Error $VALUES[];
    public static final Error Error;
    public static final Error Inactive;
    public static final Error Standard;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/digimarc/dms/resolver/ResolveResult$PayoffType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Standard = new <init>("Standard", 0);
        Inactive = new <init>("Inactive", 1);
        Error = new <init>("Error", 2);
        $VALUES = (new .VALUES[] {
            Standard, Inactive, Error
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
