// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.view.ViewGroup;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.metrics.impressions.AsinImpressionTracker;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            SearchLayout, UserState

public class FlipBookLayout
    implements SearchLayout
{

    private final AsinImpressionTracker asinImpressionTracker;
    private final ViewGroup container;
    private final ResourceProvider resourceProvider;

    public FlipBookLayout(ViewGroup viewgroup, ResourceProvider resourceprovider, AsinImpressionTracker asinimpressiontracker)
    {
        container = viewgroup;
        resourceProvider = resourceprovider;
        asinImpressionTracker = asinimpressiontracker;
    }

    public void changeOrientation(int i, UserState userstate)
    {
    }

    public UserState disable()
    {
        return null;
    }

    public void enable(UserState userstate)
    {
    }

    public UserState getUserState()
    {
        return null;
    }

    public void pause()
    {
    }

    public void resume()
    {
    }

    public void setEntryGroupAsin(String s)
    {
    }
}
