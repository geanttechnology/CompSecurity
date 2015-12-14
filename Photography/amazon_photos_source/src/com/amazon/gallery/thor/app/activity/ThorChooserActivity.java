// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.Intent;
import android.net.Uri;
import android.widget.ListAdapter;
import com.amazon.gallery.foundation.utils.messaging.ChooserResultEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.messaging.ContentConfigurationEvent;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.Chooser;
import com.amazon.gallery.framework.kindle.activity.LaunchSourceMetrics;
import com.amazon.gallery.framework.kindle.fragment.FragmentController;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorNativeGalleryActivity, RequestCode

public class ThorChooserActivity extends ThorNativeGalleryActivity
    implements Chooser
{

    public ThorChooserActivity()
    {
    }

    public void finishActivityAndAttachResult(Uri uri, String s)
    {
        GlobalMessagingBus.post(new ChooserResultEvent(uri, s));
        Intent intent = new Intent();
        intent.setDataAndType(uri, s);
        setResult(-1, intent);
        finish();
    }

    public String getImageMediaType()
    {
        return getIntent().getStringExtra("imageMediaType");
    }

    public Object getItemAtPosition(int i)
    {
        return getListAdapter().getItem(i);
    }

    protected void logLaunchSource()
    {
        if (!"com.amazon.photos.INTERNAL".equals(getIntent().getAction()))
        {
            ((LaunchSourceMetrics)getApplicationBean(Keys.LAUNCH_SOURCE_PROFILER)).trackEvent(com.amazon.gallery.framework.kindle.activity.LaunchSourceMetrics.MetricsEvent.PickMode);
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == RequestCode.CHOOSER.ordinal() && j == -1 && intent != null)
        {
            setResult(j, intent);
            finish();
            return;
        } else
        {
            super.onActivityResult(i, j, intent);
            return;
        }
    }

    public ContentConfigurationEvent produceContentConfiguration()
    {
        return new ContentConfigurationEvent(contentConfiguration);
    }

    protected void setupFragmentController()
    {
        super.setupFragmentController();
        fragmentController.setInChooserMode(true);
    }
}
