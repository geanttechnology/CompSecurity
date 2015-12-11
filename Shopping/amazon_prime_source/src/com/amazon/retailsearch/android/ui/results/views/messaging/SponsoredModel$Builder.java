// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Decorations;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            SponsoredModel

public static class 
{

    public SponsoredModel build(String s, Decorations decorations)
    {
        if (decorations != null && !Utils.isEmpty(decorations.getHeader()))
        {
            s = new SponsoredModel();
            SponsoredModel.access$000(s, decorations.getHeader());
            SponsoredModel.access$100(s, decorations.getTracking());
            return s;
        } else
        {
            return null;
        }
    }

    public ()
    {
    }
}
