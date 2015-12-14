// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotovariant.nativeAds;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import anv;

public abstract class FotoNativeBaseWall extends FrameLayout
{

    public FotoNativeBaseWall(Context context)
    {
        super(context);
    }

    public abstract void destroyAdWall();

    public abstract void loadAd(Context context, anv anv, String s);

    public abstract void registerImpression(Context context, View view);

    public void reloadView(Activity activity)
    {
    }
}
