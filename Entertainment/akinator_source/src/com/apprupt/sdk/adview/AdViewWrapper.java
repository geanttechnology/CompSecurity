// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk.adview;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.apprupt.sdk.CvAnimationType;

// Referenced classes of package com.apprupt.sdk.adview:
//            AdViewWrapperListener, ExpandedAdWrapperListener, ExpandProperties, OrientationProperties

public interface AdViewWrapper
{

    public abstract boolean canBeCleaned();

    public abstract void clear();

    public abstract void close(AdViewWrapperListener adviewwrapperlistener);

    public abstract void close(ExpandedAdWrapperListener expandedadwrapperlistener);

    public abstract void forceSizeChange(int i, int j);

    public abstract int getAdHeight();

    public abstract int getAdWidth();

    public abstract Animation getAnimationIn(CvAnimationType cvanimationtype);

    public abstract Animation getAnimationOut(CvAnimationType cvanimationtype);

    public abstract Context getContext();

    public abstract ExpandProperties getExpandProperties();

    public abstract OrientationProperties getOrientationProperties();

    public abstract View getView();

    public abstract void init();

    public abstract void loadUrl(String s);

    public abstract void onAfterClose();

    public abstract void onAfterExpand();

    public abstract void onAfterResize();

    public abstract void prepareAd();

    public abstract void run();

    public abstract void setExpandedViewListener(ExpandedAdWrapperListener expandedadwrapperlistener);

    public abstract void setListener(AdViewWrapperListener adviewwrapperlistener);
}
