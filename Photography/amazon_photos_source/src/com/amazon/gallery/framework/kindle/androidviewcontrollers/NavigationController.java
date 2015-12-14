// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.androidviewcontrollers;

import android.content.Intent;
import android.view.View;
import android.widget.ListAdapter;
import com.amazon.gallery.foundation.ui.controller.androidviewcontroller.AndroidViewController;
import com.amazon.gallery.foundation.utils.TimeTracker;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.activity.SingleViewActivity;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;

public class NavigationController
    implements AndroidViewController
{

    private final NativeGalleryActivity nativeGalleryActivity;

    public NavigationController(NativeGalleryActivity nativegalleryactivity)
    {
        nativeGalleryActivity = nativegalleryactivity;
    }

    public boolean onClick(View view, int i)
    {
        view = nativeGalleryActivity.getListAdapter();
        if (view != null)
        {
            if ((view = ((View) (view.getItem(i)))) instanceof MediaItem)
            {
                Intent intent = new Intent(nativeGalleryActivity, com/amazon/gallery/framework/kindle/activity/SingleViewActivity);
                if (nativeGalleryActivity.getIntent().getBooleanExtra("view_hidden_content_button", false))
                {
                    intent.putExtra("view_hidden_content_button", true);
                }
                if (nativeGalleryActivity.getIntent().hasExtra("thisDayYear"))
                {
                    intent.putExtra("thisDayYear", nativeGalleryActivity.getIntent().getIntExtra("thisDayYear", 0));
                    intent.putExtra("weekData", nativeGalleryActivity.getIntent().getBooleanExtra("weekData", false));
                }
                if (nativeGalleryActivity.getIntent().hasExtra("navigationFromFolders"))
                {
                    intent.putExtra("navigationFromFolders", true);
                }
                MediaContentConfiguration mediacontentconfiguration = nativeGalleryActivity.getMediaContentConfiguration();
                intent.setData(mediacontentconfiguration.getContentUri());
                if (((SyncManager)ThorGalleryApplication.getBean(Keys.SYNC_MANAGER)).isColdBootCompleted())
                {
                    intent.putExtra("START_POSITION", nativeGalleryActivity.getMediaItemIndex(i));
                } else
                {
                    intent.putExtra("mediaItem", ((MediaItem)view).getObjectId());
                }
                IntentUtil.setExtrasForDescriptor(mediacontentconfiguration.toViewDescriptor(), intent);
                nativeGalleryActivity.startActivity(intent);
                TimeTracker.log("Starting single view");
                return true;
            }
        }
        return false;
    }

    public boolean onLongClick(View view, int i)
    {
        return false;
    }
}
