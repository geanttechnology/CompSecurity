// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.product;


// Referenced classes of package com.target.ui.model.product:
//            ProductVariationModel

public static final class _cls9 extends Enum
{

    private static final SINGLE_DIMENSION_GRID $VALUES[];
    public static final SINGLE_DIMENSION_GRID NONE;
    public static final SINGLE_DIMENSION_GRID SINGLE_DIMENSION_GRID;
    public static final SINGLE_DIMENSION_GRID SINGLE_DIMENSION_LIST;
    public static final SINGLE_DIMENSION_GRID TWO_DIMENSION;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/target/ui/model/product/ProductVariationModel$a, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        TWO_DIMENSION = new <init>("TWO_DIMENSION", 1);
        SINGLE_DIMENSION_LIST = new <init>("SINGLE_DIMENSION_LIST", 2);
        SINGLE_DIMENSION_GRID = new <init>("SINGLE_DIMENSION_GRID", 3);
        $VALUES = (new .VALUES[] {
            NONE, TWO_DIMENSION, SINGLE_DIMENSION_LIST, SINGLE_DIMENSION_GRID
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
