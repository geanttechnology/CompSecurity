// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.refine;


// Referenced classes of package com.target.ui.model.refine:
//            ProductRefineModel

public static final class mLabel extends Enum
{

    private static final OTHERS $VALUES[];
    public static final OTHERS CATEGORY;
    public static final OTHERS COLOR;
    public static final OTHERS OTHERS;
    public static final OTHERS PRICE;
    private String mLabel;

    public static mLabel a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        mLabel mlabel = OTHERS;
_L4:
        return mlabel;
_L2:
        mLabel amlabel[];
        int i;
        int j;
        amlabel = values();
        j = amlabel.length;
        i = 0;
_L6:
        mLabel mlabel1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        mlabel1 = amlabel[i];
        mlabel = mlabel1;
        if (s.equalsIgnoreCase(mlabel1.a())) goto _L4; else goto _L3
_L3:
        mlabel = mlabel1;
        if (s.equalsIgnoreCase(mlabel1.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return OTHERS;
    }

    private String a()
    {
        return mLabel;
    }

    static String a(mLabel mlabel)
    {
        return mlabel.a();
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/ui/model/refine/ProductRefineModel$a, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    static 
    {
        CATEGORY = new <init>("CATEGORY", 0, "category");
        PRICE = new <init>("PRICE", 1, "price");
        COLOR = new <init>("COLOR", 2, "color");
        OTHERS = new <init>("OTHERS", 3, "");
        $VALUES = (new .VALUES[] {
            CATEGORY, PRICE, COLOR, OTHERS
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mLabel = s1;
    }
}
