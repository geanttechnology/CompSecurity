// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

// Referenced classes of package com.flurry.android:
//            FlurryFullscreenTakeoverActivity, cf

final class aq
{

    private View cJ;
    private int cK;
    private BasicWebView.BasicWebViewFullScreenTransitionHandler.BasicWebViewFullScreenTransitionCallback cL;
    private FrameLayout cM;
    final FlurryFullscreenTakeoverActivity u;

    aq(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
    {
        this(flurryfullscreentakeoveractivity, (byte)0);
    }

    private aq(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity, byte byte0)
    {
        u = flurryfullscreentakeoveractivity;
        super();
    }

    public final void U()
    {
        if (cJ == null)
        {
            return;
        }
        ((ViewGroup)u.getWindow().getDecorView()).removeView(cM);
        cM.removeView(cJ);
        if (cL != null)
        {
            cL.onBasicWebViewTransitionFromFullScreenFinished();
        }
        u.setRequestedOrientation(cK);
        cL = null;
        cM = null;
        cJ = null;
    }

    public final void a(cf cf, View view, int i, BasicWebView.BasicWebViewFullScreenTransitionHandler.BasicWebViewFullScreenTransitionCallback basicwebviewfullscreentransitioncallback)
    {
        if (cJ != null)
        {
            U();
        }
        cJ = view;
        cK = u.getRequestedOrientation();
        cL = basicwebviewfullscreentransitioncallback;
        cM = new FrameLayout(u);
        cM.setBackgroundColor(0xff000000);
        cM.addView(cJ, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        ((ViewGroup)u.getWindow().getDecorView()).addView(cM, -1, -1);
        u.setRequestedOrientation(i);
    }
}
