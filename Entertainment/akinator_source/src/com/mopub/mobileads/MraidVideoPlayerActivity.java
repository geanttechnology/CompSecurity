// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.mraid.MraidVideoViewController;

// Referenced classes of package com.mopub.mobileads:
//            BaseVideoPlayerActivity, VastVideoViewController, BaseVideoViewController, EventForwardingBroadcastReceiver

public class MraidVideoPlayerActivity extends BaseVideoPlayerActivity
    implements BaseVideoViewController.BaseVideoViewControllerListener
{

    private BaseVideoViewController mBaseVideoController;
    private long mBroadcastIdentifier;

    public MraidVideoPlayerActivity()
    {
    }

    private BaseVideoViewController createVideoViewController(Bundle bundle)
        throws IllegalStateException
    {
        String s = getIntent().getStringExtra("video_view_class_name");
        if ("vast".equals(s))
        {
            return new VastVideoViewController(this, getIntent().getExtras(), bundle, mBroadcastIdentifier, this);
        }
        if ("mraid".equals(s))
        {
            return new MraidVideoViewController(this, getIntent().getExtras(), bundle, this);
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Unsupported video type: ").append(s).toString());
        }
    }

    protected static long getBroadcastIdentifierFromIntent(Intent intent)
    {
        return intent.getLongExtra("broadcastIdentifier", -1L);
    }

    BaseVideoViewController getBaseVideoViewController()
    {
        return mBaseVideoController;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (mBaseVideoController != null)
        {
            mBaseVideoController.onActivityResult(i, j, intent);
        }
    }

    public void onBackPressed()
    {
        if (mBaseVideoController != null && mBaseVideoController.backButtonEnabled())
        {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (mBaseVideoController != null)
        {
            mBaseVideoController.onConfigurationChanged(configuration);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        mBroadcastIdentifier = getBroadcastIdentifierFromIntent(getIntent());
        try
        {
            mBaseVideoController = createVideoViewController(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            EventForwardingBroadcastReceiver.broadcastAction(this, mBroadcastIdentifier, "com.mopub.action.interstitial.fail");
            finish();
            return;
        }
        mBaseVideoController.onCreate();
    }

    protected void onDestroy()
    {
        if (mBaseVideoController != null)
        {
            mBaseVideoController.onDestroy();
        }
        super.onDestroy();
    }

    public void onFinish()
    {
        finish();
    }

    protected void onPause()
    {
        if (mBaseVideoController != null)
        {
            mBaseVideoController.onPause();
        }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        if (mBaseVideoController != null)
        {
            mBaseVideoController.onResume();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (mBaseVideoController != null)
        {
            mBaseVideoController.onSaveInstanceState(bundle);
        }
    }

    public void onSetContentView(View view)
    {
        setContentView(view);
    }

    public void onSetRequestedOrientation(int i)
    {
        setRequestedOrientation(i);
    }

    public void onStartActivityForResult(Class class1, int i, Bundle bundle)
    {
        if (class1 == null)
        {
            return;
        }
        bundle = Intents.getStartActivityIntent(this, class1, bundle);
        try
        {
            startActivityForResult(bundle, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            MoPubLog.d((new StringBuilder()).append("Activity ").append(class1.getName()).append(" not found. Did you declare it in your AndroidManifest.xml?").toString());
        }
    }

    void setBaseVideoViewController(BaseVideoViewController basevideoviewcontroller)
    {
        mBaseVideoController = basevideoviewcontroller;
    }
}
