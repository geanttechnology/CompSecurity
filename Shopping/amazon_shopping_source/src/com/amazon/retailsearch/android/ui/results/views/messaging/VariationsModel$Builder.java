// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.text.TextUtils;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Variation;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            VariationsModel

public static class 
{

    public VariationsModel build(List list)
    {
        if (list != null && !list.isEmpty())
        {
            if ((list = (Variation)list.get(0)) != null && list.getLink() != null && !TextUtils.isEmpty(list.getLink().getText()))
            {
                VariationsModel variationsmodel = new VariationsModel();
                VariationsModel.access$000(variationsmodel, list.getLink().getText());
                return variationsmodel;
            }
        }
        return null;
    }

    public ()
    {
    }
}
