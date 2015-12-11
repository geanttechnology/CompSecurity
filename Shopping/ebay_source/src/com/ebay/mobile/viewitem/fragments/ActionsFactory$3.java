// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.view.View;
import com.ebay.mobile.widget.PriceView;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory

static final class val.amountEditor
    implements android.view.ner
{

    final tion val$action;
    final PriceView val$amountEditor;
    final ActionsFactory val$factory;

    public void onClick(View view)
    {
        val$action.execute(val$factory, Double.valueOf(val$amountEditor.getPrice()));
    }

    tion(tion tion, ActionsFactory actionsfactory, PriceView priceview)
    {
        val$action = tion;
        val$factory = actionsfactory;
        val$amountEditor = priceview;
        super();
    }
}
