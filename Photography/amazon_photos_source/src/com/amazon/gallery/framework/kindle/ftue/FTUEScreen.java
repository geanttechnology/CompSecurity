// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ViewTarget;

public abstract class FTUEScreen extends Fragment
{

    protected FTUEFragmentActivity activity;
    protected DialogManager dialogManager;
    protected Handler handler;
    protected View layout;
    protected NetworkConnectivity networkConnectivity;
    protected RestClient restClient;
    protected AppCompatProgressDialog spinnerDialog;
    protected long startTime;

    public FTUEScreen()
    {
    }

    private void init()
    {
        activity = (FTUEFragmentActivity)getActivity();
        restClient = (RestClient)activity.getApplicationBean(Keys.REST_CLIENT);
        networkConnectivity = (NetworkConnectivity)activity.getApplicationBean(Keys.NETWORK_CONNECTIVITY);
        spinnerDialog = (new com.amazon.gallery.thor.widget.AppCompatProgressDialog.Builder(activity)).build();
        dialogManager = activity.getDialogManager();
        handler = new Handler();
    }

    protected abstract int getBackgroundResource();

    public abstract int getLayout();

    public abstract com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEvent getShowScreenMetric();

    public void logTimerMetric(Enum enum)
    {
        activity.getProfiler().trackTimer(enum, SystemClock.uptimeMillis() - startTime);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (viewgroup == null)
        {
            return null;
        } else
        {
            init();
            layout = layoutinflater.inflate(getLayout(), viewgroup, false);
            Glide.with(this).load(Integer.valueOf(getBackgroundResource())).into(new ViewTarget(layout) {

                final FTUEScreen this$0;

                public void onResourceReady(GlideDrawable glidedrawable, GlideAnimation glideanimation)
                {
                    layout.setBackgroundDrawable(glidedrawable);
                }

                public volatile void onResourceReady(Object obj, GlideAnimation glideanimation)
                {
                    onResourceReady((GlideDrawable)obj, glideanimation);
                }

            
            {
                this$0 = FTUEScreen.this;
                super(view);
            }
            });
            startTime = SystemClock.uptimeMillis();
            return layout;
        }
    }

    public void onShowView(FTUEFragmentActivity ftuefragmentactivity)
    {
        if (getShowScreenMetric() != null)
        {
            ftuefragmentactivity.getProfiler().trackEvent(getShowScreenMetric());
        }
    }
}
