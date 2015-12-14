// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.os.Bundle;
import android.view.Window;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.messaging.ContentConfigurationEvent;
import com.amazon.gallery.framework.kindle.cds.SyncHandler;
import com.amazon.gallery.thor.app.activity.ThorSettingsActivity;
import com.amazon.gallery.thor.camera.ThorLaunchCamera;
import com.amazon.gallery.thor.di.NativeActivityBeans;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            NativeGalleryActivity, GridActivityParams

public class SlideShowActivity extends NativeGalleryActivity
{

    public SlideShowActivity()
    {
        super(new GridActivityParams(-1, com/amazon/gallery/thor/app/activity/ThorSettingsActivity, new ThorLaunchCamera(), new NativeActivityBeans()));
    }

    protected boolean autoSaveDialogsEnabled()
    {
        return false;
    }

    protected SyncHandler createSyncHandler()
    {
        return null;
    }

    protected void launchFragment()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        overridePendingTransition(0x7f040020, 0x7f040021);
    }

    public void onDestroy()
    {
        super.onDestroy();
        getWindow().clearFlags(128);
    }

    public void onPause()
    {
        super.onPause();
        GlobalMessagingBus.unregister(this);
        overridePendingTransition(0x7f040020, 0x7f040021);
    }

    public void onResume()
    {
        super.onResume();
        GlobalMessagingBus.register(this);
    }

    public ContentConfigurationEvent produceContentConfiguration()
    {
        return new ContentConfigurationEvent(contentConfiguration);
    }

    public void setActivityContentView()
    {
        setContentView(0x7f0300da);
    }

    protected void setupNavPane()
    {
    }
}
