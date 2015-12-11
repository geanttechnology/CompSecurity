// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import android.text.TextUtils;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.NonPrimeOffer;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.price:
//            ForcedPrimeModel

public static class 
{

    public ForcedPrimeModel build(NonPrimeOffer nonprimeoffer, String s)
    {
        if (nonprimeoffer == null || nonprimeoffer.getLink() == null || TextUtils.isEmpty(nonprimeoffer.getLink().getText()))
        {
            return null;
        } else
        {
            ForcedPrimeModel forcedprimemodel = new ForcedPrimeModel();
            ForcedPrimeModel.access$000(forcedprimemodel, nonprimeoffer.getLink().getText());
            ForcedPrimeModel.access$100(forcedprimemodel, nonprimeoffer.getLabel());
            ForcedPrimeModel.access$200(forcedprimemodel, nonprimeoffer.getAsin());
            ForcedPrimeModel.access$300(forcedprimemodel, nonprimeoffer.getLink().getUrl());
            ForcedPrimeModel.access$400(forcedprimemodel, s);
            return forcedprimemodel;
        }
    }

    public ()
    {
    }
}
