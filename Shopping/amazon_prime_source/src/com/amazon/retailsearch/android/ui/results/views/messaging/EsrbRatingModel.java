// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.text.TextUtils;
import com.amazon.searchapp.retailsearch.model.AudienceRating;

public class EsrbRatingModel
{
    public static class Builder
    {

        public EsrbRatingModel build(AudienceRating audiencerating)
        {
            if (audiencerating == null || TextUtils.isEmpty(audiencerating.getRating()))
            {
                return null;
            } else
            {
                EsrbRatingModel esrbratingmodel = new EsrbRatingModel();
                esrbratingmodel.setEsrbRatingMessage(audiencerating.getRating());
                return esrbratingmodel;
            }
        }

        public Builder()
        {
        }
    }


    private String esrbRatingMessage;

    public EsrbRatingModel()
    {
    }

    private void setEsrbRatingMessage(String s)
    {
        esrbRatingMessage = s;
    }

    public String getEsrbRatingMessage()
    {
        return esrbRatingMessage;
    }

}
