// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.app.Activity;
import com.apprupt.sdk.adview.AdViewWrapper;
import com.apprupt.sdk.adview.AdViewWrapperListener;

// Referenced classes of package com.apprupt.sdk:
//            CvAdColony, CvError, CvContext

static interface istener
{

    public abstract AdViewWrapper createInlineAd(CvContext cvcontext, int i, int j, AdViewWrapperListener adviewwrapperlistener)
        throws CvError;

    public abstract AdViewWrapper createInlineAd(CvContext cvcontext, String s, int i, AdViewWrapperListener adviewwrapperlistener)
        throws CvError;

    public abstract void init(Activity activity);

    public abstract boolean isActiveForSpace(int i, boolean flag);

    public abstract boolean isActiveForSpace(String s, boolean flag);

    public abstract void onPause();

    public abstract void onResume(Activity activity);

    public abstract void reinit(Activity activity);

    public abstract void setAlwaysStartMuted(boolean flag);

    public abstract void showInterstitial(int i, istener istener);

    public abstract void showInterstitial(String s, istener istener);
}
