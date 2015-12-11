// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.db.dao.DaoWidgetSummary;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.WidgetSummary;
import com.groupon.manager.WidgetOnDealDetailsSyncHelper;
import com.groupon.util.PendingAdapterWrapper;
import commonlib.adapter.JavaAdapter;
import commonlib.loader.ListLoaderCallbacks;
import java.util.ArrayList;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.loader:
//            WidgetsForThankYouLoader

public class WidgetsForThankYouLoaderCallbacks extends ListLoaderCallbacks
{

    private Context context;
    private String extendedDatabaseChannel;
    private PendingAdapterWrapper pendingAdapterWrapper;
    private DaoWidgetSummary widgetDao;

    public WidgetsForThankYouLoaderCallbacks(Context context1, JavaAdapter javaadapter, String s, PendingAdapterWrapper pendingadapterwrapper)
    {
        super(javaadapter);
        RoboGuice.getInjector(context1).injectMembers(this);
        extendedDatabaseChannel = WidgetOnDealDetailsSyncHelper.staticGetWidgetsChannelName(Channel.DEAL_WIDGET.extendedDatabaseChannel(s));
        context = context1;
        pendingAdapterWrapper = pendingadapterwrapper;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        bundle = new WidgetsForThankYouLoader(com/groupon/db/models/WidgetSummary, com/groupon/db/events/ChannelUpdateEvent, context, widgetDao, extendedDatabaseChannel);
        bundle.setForceDownload(true);
        return bundle;
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
        }
        super.onLoadFinished(loader, ((List) (obj)));
    }

    public void onLoaderReset(Loader loader)
    {
        pendingAdapterWrapper.enableAppending(true);
        super.onLoaderReset(loader);
    }
}
