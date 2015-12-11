// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.searchapp.retailsearch.model.Availability;
import java.util.List;

public class FastTrackModel
{
    public static class Builder
    {

        public FastTrackModel build(Availability availability)
        {
            if (availability == null || availability.getFastTrack() == null || availability.getFastTrack().size() == 0)
            {
                return null;
            } else
            {
                FastTrackModel fasttrackmodel = new FastTrackModel();
                fasttrackmodel.setFastTrackStyledText(availability.getFastTrack());
                return fasttrackmodel;
            }
        }

        public Builder()
        {
        }
    }


    private List fastTrackStyledText;

    public FastTrackModel()
    {
    }

    private void setFastTrackStyledText(List list)
    {
        fastTrackStyledText = list;
    }

    public List getFastTrackSyledText()
    {
        return fastTrackStyledText;
    }

}
