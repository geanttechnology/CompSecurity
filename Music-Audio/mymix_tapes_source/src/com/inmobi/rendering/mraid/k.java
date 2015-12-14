// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.c;
import com.inmobi.rendering.CustomView;
import com.inmobi.rendering.RenderView;

// Referenced classes of package com.inmobi.rendering.mraid:
//            m

public final class k
{

    private static final String a = com/inmobi/rendering/mraid/k.getSimpleName();
    private RenderView b;
    private ViewGroup c;
    private int d;

    public k(RenderView renderview)
    {
        b = renderview;
    }

    private android.widget.RelativeLayout.LayoutParams a(String s, float f)
    {
        s = a(s);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(50F * f), (int)(50F * f));
        if (s.equals("top-right") || s.equals("bottom-right"))
        {
            layoutparams.addRule(11);
        }
        if (s.equals("bottom-right") || s.equals("bottom-left") || s.equals("bottom-center"))
        {
            layoutparams.addRule(12);
            layoutparams.addRule(4);
        }
        if (s.equals("bottom-center") || s.equals("top-center") || s.equals("center"))
        {
            layoutparams.addRule(13);
        }
        if (s.equals("top-center"))
        {
            layoutparams.addRule(10);
        }
        return layoutparams;
    }

    static RenderView a(k k1)
    {
        return k1.b;
    }

    private String a(String s)
    {
        String s1;
        if (s == null || s.length() == 0)
        {
            s1 = "top-right";
        } else
        {
            s1 = s;
            if (!s.equals("top-left"))
            {
                s1 = s;
                if (!s.equals("top-right"))
                {
                    s1 = s;
                    if (!s.equals("bottom-left"))
                    {
                        s1 = s;
                        if (!s.equals("bottom-right"))
                        {
                            s1 = s;
                            if (!s.equals("top-center"))
                            {
                                s1 = s;
                                if (!s.equals("bottom-center"))
                                {
                                    s1 = s;
                                    if (!s.equals("center"))
                                    {
                                        return "top-right";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return s1;
    }

    private void a(ViewGroup viewgroup, String s)
    {
        float f = DisplayInfo.a().c();
        CustomView customview = new CustomView(b.getContext(), f, com.inmobi.rendering.CustomView.SwitchIconType.CLOSE_TRANSPARENT);
        customview.setId(65531);
        customview.setOnClickListener(new android.view.View.OnClickListener() {

            final k a;

            public void onClick(View view)
            {
                k.a(a).j();
            }

            
            {
                a = k.this;
                super();
            }
        });
        viewgroup.addView(customview, a(s, f));
    }

    private void a(FrameLayout framelayout, FrameLayout framelayout1, m m1)
    {
        float f = DisplayInfo.a().c();
        int i = (int)((float)m1.b * f + 0.5F);
        int j = (int)((float)m1.c * f + 0.5F);
        int l = (int)((float)m1.d * f + 0.5F);
        int i1 = (int)(f * (float)m1.e + 0.5F);
        int ai[] = new int[2];
        int ai1[] = new int[2];
        c.getLocationOnScreen(ai);
        framelayout.getLocationOnScreen(ai1);
        ai[1] = ai[1] - ai1[1];
        ai[0] = ai[0] - ai1[0];
        ai[0] = l + ai[0];
        ai[1] = i1 + ai[1];
        if (!m1.f)
        {
            if (i > framelayout.getWidth() - ai[0])
            {
                ai[0] = framelayout.getWidth() - i;
            }
            if (j > framelayout.getHeight() - ai[1])
            {
                ai[1] = framelayout.getHeight() - j;
            }
            if (ai[0] < 0)
            {
                ai[0] = 0;
            }
            if (ai[1] < 0)
            {
                ai[1] = 0;
            }
        }
        framelayout = new android.widget.FrameLayout.LayoutParams(i, j);
        framelayout.leftMargin = ai[0];
        framelayout.topMargin = ai[1];
        framelayout.gravity = 0x800003;
        framelayout1.setLayoutParams(framelayout);
    }

    private void a(m m1)
    {
        float f = DisplayInfo.a().c();
        int i = (int)((float)m1.b * f + 0.5F);
        int j = (int)(f * (float)m1.c + 0.5F);
        FrameLayout framelayout = (FrameLayout)c.getRootView().findViewById(0x1020002);
        FrameLayout framelayout1 = new FrameLayout(b.getContext());
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        RelativeLayout relativelayout = new RelativeLayout(b.getContext());
        android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(i, j);
        android.widget.RelativeLayout.LayoutParams layoutparams2 = new android.widget.RelativeLayout.LayoutParams(i, j);
        framelayout1.setId(65534);
        if (b.getParent() != null)
        {
            ((ViewGroup)b.getParent()).removeAllViews();
        }
        relativelayout.addView(b, layoutparams2);
        a(((ViewGroup) (relativelayout)), m1.a);
        framelayout1.addView(relativelayout, layoutparams1);
        framelayout.addView(framelayout1, layoutparams);
        a(framelayout, framelayout1, m1);
        framelayout1.setBackgroundColor(0);
    }

    private void c()
    {
        FrameLayout framelayout = new FrameLayout(b.getContext());
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(b.getWidth(), b.getHeight());
        framelayout.setId(65535);
        c.addView(framelayout, d, layoutparams);
        c.removeView(b);
    }

    public void a()
    {
        if (c == null)
        {
            c = (ViewGroup)b.getParent();
            d = c.indexOfChild(b);
        }
        m m1 = b.getResizeProperties();
        c();
        a(m1);
    }

    public void b()
    {
        ViewGroup viewgroup = (ViewGroup)b.getParent();
        View view = viewgroup.getRootView().findViewById(65534);
        View view1 = c.getRootView().findViewById(65535);
        ((ViewGroup)view.getParent()).removeView(view);
        ((ViewGroup)view1.getParent()).removeView(view1);
        viewgroup.removeView(b);
        c.addView(b, d, new android.widget.RelativeLayout.LayoutParams(c.getWidth(), c.getHeight()));
        b.l();
    }

}
