// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.loader;

import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.commonlib.loader.ListLoaderCallbacksV3;
import java.util.ArrayList;

// Referenced classes of package com.groupon.v3.loader:
//            UniversalListLoader, IUniversalCallback, UniversalListLoadResultData

public class UniversalLoaderCallbacks extends ListLoaderCallbacksV3
{

    protected Context context;
    protected String pagerChannelAndSubchannel;
    protected IUniversalCallback universalCallback;

    public UniversalLoaderCallbacks(UniversalListAdapter universallistadapter, Context context1, String s, IUniversalCallback iuniversalcallback)
    {
        super(universallistadapter);
        context = context1;
        pagerChannelAndSubchannel = s;
        universalCallback = iuniversalcallback;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        bundle = new UniversalListLoader(java/lang/Object, com/groupon/db/events/UniversalUpdateEvent, context, pagerChannelAndSubchannel);
        bundle.setBackgroundDataProcessors(backgroundDataProcessors);
        return bundle;
    }

    public void onLoadFinished(Loader loader, UniversalListLoadResultData universallistloadresultdata)
    {
        universalCallback.onLoaderDataChanged(universallistloadresultdata, false);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (UniversalListLoadResultData)obj);
    }

    public void onLoaderReset(Loader loader)
    {
        super.onLoaderReset(loader);
        loader = new UniversalListLoadResultData(new ArrayList(), null, null);
        universalCallback.onLoaderDataChanged(loader, true);
    }

    public void setChannel(String s)
    {
        pagerChannelAndSubchannel = s;
    }
}
