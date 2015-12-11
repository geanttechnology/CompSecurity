// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Decorations;
import java.util.List;

public class SponsoredModel
{
    public static class Builder
    {

        public SponsoredModel build(String s, Decorations decorations)
        {
            if (decorations != null && !Utils.isEmpty(decorations.getHeader()))
            {
                s = new SponsoredModel();
                s.setMessage(decorations.getHeader());
                s.setTracking(decorations.getTracking());
                return s;
            } else
            {
                return null;
            }
        }

        public Builder()
        {
        }
    }


    private List message;
    private List tracking;

    public SponsoredModel()
    {
    }

    private void setMessage(List list)
    {
        message = list;
    }

    private void setTracking(List list)
    {
        tracking = list;
    }

    public List getMessage()
    {
        return message;
    }

    public List getTracking()
    {
        return tracking;
    }


}
