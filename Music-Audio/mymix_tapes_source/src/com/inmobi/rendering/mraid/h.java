// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.RenderingProperties;

public final class h
{

    private static final String a = com/inmobi/rendering/mraid/h.getSimpleName();
    private RenderView b;
    private boolean c;
    private ViewGroup d;
    private int e;

    public h(RenderView renderview)
    {
        b = renderview;
        c = false;
    }

    private void b()
    {
        FrameLayout framelayout = new FrameLayout(b.getContext());
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(b.getWidth(), b.getHeight());
        framelayout.setId(65535);
        d.addView(framelayout, e, layoutparams);
        d.removeView(b);
    }

    public void a()
    {
        if (b.getOriginalRenderView() == null)
        {
            View view = d.getRootView().findViewById(65535);
            ((ViewGroup)b.getParent()).removeView(b);
            ((ViewGroup)view.getParent()).removeView(view);
            d.addView(b, e, new android.widget.RelativeLayout.LayoutParams(d.getWidth(), d.getHeight()));
            b.l();
        }
    }

    public void a(String s, String s1)
    {
        if (d == null)
        {
            d = (ViewGroup)b.getParent();
            e = d.indexOfChild(b);
        }
        if (b == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Please check if the MRAID processor was initialized correctly.");
        } else
        {
            s = b.getExpandProperties();
            c = URLUtil.isValidUrl(s1);
            int i;
            if (c)
            {
                RenderView renderview = new RenderView(b.getContext(), new RenderingProperties(com.inmobi.rendering.RenderingProperties.PlacementType.INLINE));
                renderview.a(b.getListener(), b.getRenderingConfig(), b.getMraidConfig());
                renderview.setOriginalRenderView(b);
                renderview.loadUrl(s1);
                i = InMobiAdActivity.a(renderview);
            } else
            {
                b();
                i = InMobiAdActivity.a(b);
            }
            s1 = new Intent(b.getContext(), com/inmobi/rendering/InMobiAdActivity);
            s1.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
            s1.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_RENDERVIEW_INDEX", i);
            b.getContext().startActivity(s1);
            if (s != null)
            {
                InMobiAdActivity.a().setUseCustomClose(b.d());
                return;
            }
        }
    }

}
