// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.searchapp.retailsearch.model.Points;
import java.util.List;

public class LoyaltyPointsModel
{
    public static class Builder
    {

        public LoyaltyPointsModel build(Points points)
        {
            if (points == null || points.getLabel() == null)
            {
                return null;
            } else
            {
                LoyaltyPointsModel loyaltypointsmodel = new LoyaltyPointsModel();
                loyaltypointsmodel.setLabelStyledText(points.getLabel());
                return loyaltypointsmodel;
            }
        }

        public Builder()
        {
        }
    }


    private List labelStyledText;

    public LoyaltyPointsModel()
    {
    }

    private void setLabelStyledText(List list)
    {
        labelStyledText = list;
    }

    public List getLabelStyledText()
    {
        return labelStyledText;
    }

}
