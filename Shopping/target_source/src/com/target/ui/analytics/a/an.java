// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.analytics.a:
//            e, y, s

public class an extends e
{

    public static final int ADD_TO_CART = 2;
    public static final int DELETE = 1;
    public static final int SAVE_FOR_LATER = 3;
    private static final String SAVE_FOR_LATER_LEVEL_2 = "shopping cart";
    private static final String SAVE_FOR_LATER_LEVEL_3 = "save for later";
    private final y mTapAction;

    private an(int j)
    {
        switch (j)
        {
        default:
            mTapAction = y.RemoveFromCartFromSaveForLater;
            return;

        case 2: // '\002'
            mTapAction = y.AddToCartFromSaveForLater;
            return;

        case 3: // '\003'
            mTapAction = y.AddToSaveForLaterFromCart;
            break;
        }
    }

    public static an a(int j)
    {
        return new an(j);
    }

    protected s c()
    {
        if (mTapAction == y.AddToSaveForLaterFromCart)
        {
            return s.Cart;
        } else
        {
            return s.SaveForLater;
        }
    }

    protected List d()
    {
        ArrayList arraylist = new ArrayList(2);
        arraylist.add("shopping cart");
        if (mTapAction == y.AddToSaveForLaterFromCart)
        {
            return arraylist;
        } else
        {
            arraylist.add("save for later");
            return arraylist;
        }
    }

    protected y i()
    {
        return mTapAction;
    }
}
