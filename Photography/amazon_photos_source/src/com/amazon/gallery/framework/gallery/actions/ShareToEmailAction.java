// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.content.Intent;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            AbstractShareAction

public class ShareToEmailAction extends AbstractShareAction
{

    public static final String TAG = com/amazon/gallery/framework/gallery/actions/ShareToEmailAction.getName();

    public ShareToEmailAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, ShareStore sharestore, RestClient restclient, Profiler profiler)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e0095, sharestore, restclient, profiler);
    }

    public void execute(List list)
    {
        if (list.size() > 0 && !((MediaItem)list.get(0)).hasProperty(CommonMediaProperty.LOCAL) && networkConnectivity.promptIfOffline(context))
        {
            return;
        }
        if (photosDemoManager.isInDemoMode())
        {
            photosDemoManager.showWarningForUnavailableAction(context);
            return;
        } else
        {
            super.execute(list);
            GLogger.d("ShareToEmailAction", "Executing Email MediaItems Action on a List<MediaItem>:", new Object[0]);
            Intent intent = getShareIntent(list);
            intent.setPackage("com.android.email");
            intent.setType(getMIMEType(list));
            prepareItemsToShare(intent, list);
            return;
        }
    }

}
