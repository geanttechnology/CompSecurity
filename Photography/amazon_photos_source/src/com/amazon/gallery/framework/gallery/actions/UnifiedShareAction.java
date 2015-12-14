// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.content.Intent;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActivityResultEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            GenericShareAction

public class UnifiedShareAction extends GenericShareAction
{

    private static final String TAG = com/amazon/gallery/framework/gallery/actions/UnifiedShareAction.getName();
    private List lastUsedMediaItems;

    public UnifiedShareAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, ShareStore sharestore, RestClient restclient, Profiler profiler)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e0097, sharestore, restclient, profiler);
        lastUsedMediaItems = null;
    }

    public void onActivityResultReceived(ActivityResultEvent activityresultevent)
    {
        GlobalMessagingBus.unregister(this);
        if (context != activityresultevent.currentActivity)
        {
            GLogger.w(TAG, "Wrong activity to receive result from.", new Object[0]);
        } else
        if (lastUsedMediaItems != null && activityresultevent.launchedActivity != null)
        {
            trackEvent(lastUsedMediaItems, activityresultevent.launchedActivity);
            lastUsedMediaItems = null;
            return;
        }
    }

    protected void startActivity(Intent intent)
    {
        GlobalMessagingBus.register(this);
        Intent intent1 = new Intent();
        intent1.setAction("com.amazon.unifiedshare.AMAZON_CHOOSER");
        intent1.putExtra("android.intent.extra.INTENT", intent);
        context.startActivityForResult(intent1, 1010);
    }

    protected void trackEvent(List list)
    {
        lastUsedMediaItems = list;
    }

}
