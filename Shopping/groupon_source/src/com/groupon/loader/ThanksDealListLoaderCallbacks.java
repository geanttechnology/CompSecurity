// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.DealSummary;
import com.groupon.fragment.DealCardListLoader;
import com.groupon.util.PendingAdapterWrapper;
import commonlib.adapter.JavaAdapter;
import commonlib.loader.ListLoaderCallbacks;
import java.util.List;

public class ThanksDealListLoaderCallbacks extends ListLoaderCallbacks
{

    private Context context;
    private PendingAdapterWrapper pendingAdapterWrapper;

    public ThanksDealListLoaderCallbacks(Context context1, JavaAdapter javaadapter, PendingAdapterWrapper pendingadapterwrapper)
    {
        super(javaadapter);
        context = context1;
        pendingAdapterWrapper = pendingadapterwrapper;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        bundle = new DealCardListLoader(com/groupon/db/models/DealSummary, com/groupon/db/events/ChannelUpdateEvent, context, Channel.POST_PURCHASE.name());
        bundle.setForceDownload(true);
        return bundle;
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        if (list != null)
        {
            super.onLoadFinished(loader, list);
        }
    }

    public void onLoaderReset(Loader loader)
    {
        pendingAdapterWrapper.enableAppending(true);
        super.onLoaderReset(loader);
    }
}
