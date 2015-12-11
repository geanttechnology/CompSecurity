// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.mopub.common.logging.MoPubLog;

// Referenced classes of package com.mopub.mobileads:
//            EventForwardingBroadcastReceiver

public abstract class BaseVideoViewController
{
    public static interface BaseVideoViewControllerListener
    {

        public abstract void onFinish();

        public abstract void onSetContentView(View view);

        public abstract void onSetRequestedOrientation(int i);

        public abstract void onStartActivityForResult(Class class1, int i, Bundle bundle);
    }


    private final BaseVideoViewControllerListener mBaseVideoViewControllerListener;
    private Long mBroadcastIdentifier;
    private final Context mContext;
    private final RelativeLayout mLayout;

    protected BaseVideoViewController(Context context, Long long1, BaseVideoViewControllerListener basevideoviewcontrollerlistener)
    {
        mContext = context.getApplicationContext();
        mBroadcastIdentifier = long1;
        mBaseVideoViewControllerListener = basevideoviewcontrollerlistener;
        mLayout = new RelativeLayout(mContext);
    }

    public boolean backButtonEnabled()
    {
        return true;
    }

    void broadcastAction(String s)
    {
        if (mBroadcastIdentifier != null)
        {
            EventForwardingBroadcastReceiver.broadcastAction(mContext, mBroadcastIdentifier.longValue(), s);
            return;
        } else
        {
            MoPubLog.w("Tried to broadcast a video event without a braodcast identifier to send to.");
            return;
        }
    }

    protected BaseVideoViewControllerListener getBaseVideoViewControllerListener()
    {
        return mBaseVideoViewControllerListener;
    }

    protected Context getContext()
    {
        return mContext;
    }

    public ViewGroup getLayout()
    {
        return mLayout;
    }

    protected abstract VideoView getVideoView();

    void onActivityResult(int i, int j, Intent intent)
    {
    }

    protected abstract void onConfigurationChanged(Configuration configuration);

    protected void onCreate()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutparams.addRule(13);
        mLayout.addView(getVideoView(), 0, layoutparams);
        mBaseVideoViewControllerListener.onSetContentView(mLayout);
    }

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onResume();

    protected abstract void onSaveInstanceState(Bundle bundle);

    protected void videoCompleted(boolean flag)
    {
        if (flag)
        {
            mBaseVideoViewControllerListener.onFinish();
        }
    }

    protected void videoError(boolean flag)
    {
        MoPubLog.e("Video cannot be played.");
        broadcastAction("com.mopub.action.interstitial.fail");
        if (flag)
        {
            mBaseVideoViewControllerListener.onFinish();
        }
    }
}
