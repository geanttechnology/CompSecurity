// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;


// Referenced classes of package com.pointinside.products:
//            LookupResult

public static final class  extends Enum
{

    private static final FOUND $VALUES[];
    public static final FOUND FOUND;
    public static final FOUND NOT_FOUND;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/products/LookupResult$LookupStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NOT_FOUND = new <init>("NOT_FOUND", 0);
        FOUND = new <init>("FOUND", 1);
        $VALUES = (new .VALUES[] {
            NOT_FOUND, FOUND
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
