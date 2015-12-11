// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.searchapp.retailsearch.model.Availability;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            FastTrackModel

public static class 
{

    public FastTrackModel build(Availability availability)
    {
        if (availability == null || availability.getFastTrack() == null || availability.getFastTrack().size() == 0)
        {
            return null;
        } else
        {
            FastTrackModel fasttrackmodel = new FastTrackModel();
            FastTrackModel.access$000(fasttrackmodel, availability.getFastTrack());
            return fasttrackmodel;
        }
    }

    public ()
    {
    }
}
