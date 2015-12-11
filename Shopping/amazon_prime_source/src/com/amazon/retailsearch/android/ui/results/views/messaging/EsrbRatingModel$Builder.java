// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.text.TextUtils;
import com.amazon.searchapp.retailsearch.model.AudienceRating;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            EsrbRatingModel

public static class 
{

    public EsrbRatingModel build(AudienceRating audiencerating)
    {
        if (audiencerating == null || TextUtils.isEmpty(audiencerating.getRating()))
        {
            return null;
        } else
        {
            EsrbRatingModel esrbratingmodel = new EsrbRatingModel();
            EsrbRatingModel.access$000(esrbratingmodel, audiencerating.getRating());
            return esrbratingmodel;
        }
    }

    public ()
    {
    }
}
