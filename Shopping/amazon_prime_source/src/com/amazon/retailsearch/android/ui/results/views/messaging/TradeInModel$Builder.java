// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.text.TextUtils;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.TradeIn;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            TradeInModel

public static class 
{

    public TradeInModel build(TradeIn tradein)
    {
        if (tradein == null || tradein.getLink() == null || TextUtils.isEmpty(tradein.getLink().getText()))
        {
            return null;
        } else
        {
            TradeInModel tradeinmodel = new TradeInModel();
            TradeInModel.access$000(tradeinmodel, tradein.getLink().getText());
            return tradeinmodel;
        }
    }

    public ()
    {
    }
}
