// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.app.Activity;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.actions.MediaItemAction;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.kindle.ui.PhotoInfoDialog;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import java.util.List;

public class InfoAction extends MediaItemAction
{

    private final String infoMenuLabel;

    public InfoAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e0121);
        infoMenuLabel = activity.getString(0x7f0e0121);
    }

    public boolean canExecute(List list)
    {
        return list.size() == 1 && super.canExecute(list);
    }

    public boolean canExecuteTags(List list)
    {
        return false;
    }

    public void execute(final List photoInfoDialog)
    {
        if (photoInfoDialog.size() == 1)
        {
            super.execute(photoInfoDialog);
            photoInfoDialog = new PhotoInfoDialog(context, (MediaItem)photoInfoDialog.get(0));
            context.runOnUiThread(new Runnable() {

                final InfoAction this$0;
                final PhotoInfoDialog val$photoInfoDialog;

                public void run()
                {
                    photoInfoDialog.show();
                }

            
            {
                this$0 = InfoAction.this;
                photoInfoDialog = photoinfodialog;
                super();
            }
            });
            GlobalMessagingBus.post(new ActionCompleteEvent());
        }
    }

    protected boolean isValid(Tag tag)
    {
        return false;
    }

    public void recordOnActionMetrics(List list)
    {
        if (isWhisperPlayMode())
        {
            list = com.amazon.gallery.whisperplay.metrics.WhisperPlayMetrics.MetricsEvent.WPInfoAction;
            profiler.trackEvent(list, CustomerMetricsHelper.getExtraEventTag(list.toString()));
        }
    }
}
