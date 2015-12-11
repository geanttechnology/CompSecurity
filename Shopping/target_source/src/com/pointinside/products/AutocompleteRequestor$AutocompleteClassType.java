// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;


// Referenced classes of package com.pointinside.products:
//            AutocompleteRequestor

public static final class  extends Enum
{

    private static final deal $VALUES[];
    public static final deal autocomplete;
    public static final deal deal;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/products/AutocompleteRequestor$AutocompleteClassType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        autocomplete = new <init>("autocomplete", 0);
        deal = new <init>("deal", 1);
        $VALUES = (new .VALUES[] {
            autocomplete, deal
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
