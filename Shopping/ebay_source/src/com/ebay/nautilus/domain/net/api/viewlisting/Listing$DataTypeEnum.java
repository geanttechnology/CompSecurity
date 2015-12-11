// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final STRING $VALUES[];
    public static final STRING DATE;
    public static final STRING DOUBLE;
    public static final STRING INT;
    public static final STRING LONG;
    public static final STRING STRING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$DataTypeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INT = new <init>("INT", 0);
        LONG = new <init>("LONG", 1);
        DOUBLE = new <init>("DOUBLE", 2);
        DATE = new <init>("DATE", 3);
        STRING = new <init>("STRING", 4);
        $VALUES = (new .VALUES[] {
            INT, LONG, DOUBLE, DATE, STRING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
