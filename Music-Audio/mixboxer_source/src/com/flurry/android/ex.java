// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            fm, bw, fq, eu, 
//            x, FlurryAds, gv, v, 
//            p, AdUnit, AdFrame, cd, 
//            AdSpaceLayout

final class ex extends fm
{

    private static final Map gC;
    private static final String p = com/flurry/android/ex.getSimpleName();
    private final p gD;

    public ex(p p1, AdUnit adunit)
    {
        super(adunit);
        gD = p1;
    }

    public final void a(Context context, ViewGroup viewgroup)
    {
        (new StringBuilder()).append("render(").append(context).append(", ").append(viewgroup).append(")").toString();
        if (gD == null || context == null || viewgroup == null)
        {
            (new StringBuilder()).append("failed to render banner ad for bannerView = ").append(gD).append(" for context = ").append(context).append(" for viewGroup = ").append(viewgroup).toString();
            return;
        }
        Object obj = FlurryAds.getInstance();
        v v1 = ((FlurryAds) (obj)).hn.a(((FlurryAds) (obj)), context, viewgroup, bs());
        if (v1 == null)
        {
            (new StringBuilder()).append("failed to render banner ad for holder = ").append(v1).append(" for adSpaceName = ").append(bs()).toString();
            return;
        }
        obj = (ViewGroup)v1.getParent();
        if (obj != null)
        {
            ((ViewGroup) (obj)).removeView(v1);
        }
        v1.stop();
        v1.removeAllViews();
        obj = (ViewGroup)gD.getParent();
        if (obj != null)
        {
            ((ViewGroup) (obj)).removeView(gD);
        }
        v1.addView(gD, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        gD.initLayout(context);
        int i;
        if (L() == null || L().getAdFrames().size() < 1)
        {
            context = null;
        } else
        {
            Object obj1 = ((AdFrame)L().getAdFrames().get(0)).getAdSpaceLayout();
            if (obj1 == null)
            {
                context = null;
            } else
            {
                cd cd1 = (cd)gC.get(viewgroup.getClass());
                if (cd1 == null)
                {
                    (new StringBuilder()).append("Ad space layout and alignment from the server is being ignored for ViewGroup subclass ").append(viewgroup.getClass().getSimpleName()).toString();
                    context = null;
                } else
                {
                    obj1 = cd1.a(context, ((AdSpaceLayout) (obj1)));
                    context = ((Context) (obj1));
                    if (obj1 == null)
                    {
                        (new StringBuilder()).append("Ad space layout and alignment from the server is being ignored for ViewGroup subclass ").append(viewgroup.getClass().getSimpleName()).toString();
                        context = ((Context) (obj1));
                    }
                }
            }
        }
        if (context != null)
        {
            v1.setLayoutParams(context);
            (new StringBuilder()).append("banner ad holder layout params = ").append(context.getClass().getName()).append(" {width = ").append(((android.view.ViewGroup.LayoutParams) (context)).width).append(", height = ").append(((android.view.ViewGroup.LayoutParams) (context)).height).append("} for banner ad with adSpaceName = ").append(bs()).toString();
        }
        i = viewgroup.getChildCount();
        if (L() != null && L().getAdFrames().size() >= 1)
        {
            context = ((AdFrame)L().getAdFrames().get(0)).getAdSpaceLayout();
            if (context != null)
            {
                context = context.getAlignment().toString().split("-");
                if (context.length == 2 && "t".equals(context[0]))
                {
                    i = 0;
                }
            }
        }
        viewgroup.addView(v1, i);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put(android/widget/LinearLayout, new bw());
        hashmap.put(android/widget/AbsoluteLayout, new fq());
        hashmap.put(android/widget/FrameLayout, new eu());
        hashmap.put(android/widget/RelativeLayout, new x());
        gC = Collections.unmodifiableMap(hashmap);
    }
}
