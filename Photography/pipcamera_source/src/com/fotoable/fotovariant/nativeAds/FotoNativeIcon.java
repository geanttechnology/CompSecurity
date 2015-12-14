// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotovariant.nativeAds;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import ja;
import jc;

public abstract class FotoNativeIcon extends FrameLayout
{

    public Activity activity;
    public boolean isLoaded;
    public boolean isLoading;
    public jc nativeItem;
    public int sortIndex;

    public FotoNativeIcon(Context context)
    {
        super(context);
        nativeItem = null;
        isLoaded = false;
        isLoading = false;
        activity = null;
    }

    public FotoNativeIcon(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        nativeItem = null;
        isLoaded = false;
        isLoading = false;
        activity = null;
    }

    public FotoNativeIcon(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        nativeItem = null;
        isLoaded = false;
        isLoading = false;
        activity = null;
    }

    public abstract void destroyNativeIcon();

    public abstract void loadNativeAd(String s, ja ja);

    public abstract void registImpression();
}
