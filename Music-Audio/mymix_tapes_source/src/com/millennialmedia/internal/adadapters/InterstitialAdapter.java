// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;

import android.content.Context;

// Referenced classes of package com.millennialmedia.internal.adadapters:
//            AdAdapter

public abstract class InterstitialAdapter extends AdAdapter
{
    public static interface InterstitialAdapterListener
    {

        public abstract void initFailed();

        public abstract void initSucceeded();

        public abstract void onAdLeftApplication();

        public abstract void onClicked();

        public abstract void onClosed();

        public abstract void onExpired();

        public abstract void showFailed(com.millennialmedia.InterstitialAd.InterstitialErrorStatus interstitialerrorstatus);

        public abstract void shown();
    }


    protected InterstitialAdapterListener adapterListener;

    public InterstitialAdapter()
    {
    }

    public abstract void init(Context context, InterstitialAdapterListener interstitialadapterlistener);

    public abstract void show(Context context, com.millennialmedia.InterstitialAd.DisplayOptions displayoptions);
}
