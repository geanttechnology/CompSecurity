// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.j;
import java.util.ArrayList;
import java.util.Queue;

// Referenced classes of package com.appnexus.opensdk:
//            k, r, e, z, 
//            ap, j, s, ae

public final class v extends k
{

    static v q;
    protected boolean r;
    protected boolean s;
    private int t;
    private int u;
    private Queue v;
    private AdActivity.a w;

    private static boolean b(r r1)
    {
        if (r1 == null || r1.c())
        {
            com.appnexus.opensdk.b.b.e(b.b, "Loaded an ad with an invalid displayable");
            return false;
        } else
        {
            return true;
        }
    }

    protected final void a(Context context, AttributeSet attributeset)
    {
        int i;
        int l;
        super.a(context, attributeset);
        a.a(-1);
        j.a = com.appnexus.opensdk.z.b;
        WindowManager windowmanager = (WindowManager)context.getSystemService("window");
        attributeset = new DisplayMetrics();
        windowmanager.getDefaultDisplay().getMetrics(attributeset);
        i = ((DisplayMetrics) (attributeset)).heightPixels;
        l = ((DisplayMetrics) (attributeset)).widthPixels;
        int i1;
        context = (Activity)context;
        Rect rect = new Rect();
        context.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        i1 = context.getWindow().findViewById(0x1020002).getTop();
        i -= i1 + 0;
_L2:
        float f1 = ((DisplayMetrics) (attributeset)).density;
        i = (int)((float)i / f1 + 0.5F);
        l = (int)((float)l / f1 + 0.5F);
        j.f = l;
        j.g = i;
        context = new ArrayList();
        if ((new com.appnexus.opensdk.j(300, 250)).a(l, i))
        {
            context.add(new com.appnexus.opensdk.j(300, 250));
        }
        if ((new com.appnexus.opensdk.j(320, 480)).a(l, i))
        {
            context.add(new com.appnexus.opensdk.j(320, 480));
        }
        if ((new com.appnexus.opensdk.j(900, 500)).a(l, i))
        {
            context.add(new com.appnexus.opensdk.j(900, 500));
        }
        if ((new com.appnexus.opensdk.j(1024, 1024)).a(l, i))
        {
            context.add(new com.appnexus.opensdk.j(1024, 1024));
        }
        j.q = context;
        return;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected final void a(ae ae1)
    {
        if (b(ae1))
        {
            if (f != null)
            {
                f.destroy();
            }
            if (!r && !s)
            {
                f = ae1;
                v.add(new s(ae1, Long.valueOf(System.currentTimeMillis()), true, ae1.b));
                return;
            }
            if (ae1 != null)
            {
                ae1.destroy();
                return;
            }
        }
    }

    protected final void a(r r1)
    {
        if (b(r1))
        {
            if (f != null)
            {
                f.destroy();
            }
            if (!r && !s)
            {
                f = r1;
                v.add(new s(r1, Long.valueOf(System.currentTimeMillis()), false, null));
                return;
            }
            if (r1 != null)
            {
                r1.destroy();
                return;
            }
        }
    }

    protected final void b(Context context, AttributeSet attributeset)
    {
        context = context.obtainStyledAttributes(attributeset, an.e.InterstitialAdView);
        int l = context.getIndexCount();
        com.appnexus.opensdk.b.b.a(b.g, com.appnexus.opensdk.b.b.a(an.d.found_n_in_xml, l));
        int i = 0;
        while (i < l) 
        {
            int i1 = context.getIndex(i);
            if (i1 == an.e.InterstitialAdView_placement_id)
            {
                setPlacementID(context.getString(i1));
                com.appnexus.opensdk.b.b.b(b.g, com.appnexus.opensdk.b.b.a(an.d.placement_id, context.getString(i1)));
            } else
            if (i1 == an.e.InterstitialAdView_test)
            {
                j.a().i = context.getBoolean(i1, false);
                com.appnexus.opensdk.b.b.b(b.g, com.appnexus.opensdk.b.b.a(an.d.xml_set_test, j.a().i));
            } else
            if (i1 == an.e.InterstitialAdView_opens_native_browser)
            {
                com.appnexus.opensdk.b.b.b(b.g, com.appnexus.opensdk.b.b.a(an.d.xml_set_opens_native_browser));
                setOpensNativeBrowser(context.getBoolean(i1, false));
            } else
            if (i1 == an.e.InterstitialAdView_show_loading_indicator)
            {
                com.appnexus.opensdk.b.b.b(b.g, com.appnexus.opensdk.b.b.a(an.d.show_loading_indicator_xml));
                setShowLoadingIndicator(context.getBoolean(i1, true));
            } else
            if (i1 == an.e.InterstitialAdView_load_landing_page_in_background)
            {
                setLoadsInBackground(context.getBoolean(i1, true));
                com.appnexus.opensdk.b.b.b(b.g, com.appnexus.opensdk.b.b.a(an.d.xml_load_landing_page_in_background, this.i));
            }
            i++;
        }
        context.recycle();
    }

    final boolean e()
    {
        return false;
    }

    final boolean f()
    {
        return true;
    }

    final void g()
    {
        if (w != null)
        {
            w.d();
        }
    }

    final Queue getAdQueue()
    {
        return v;
    }

    public final ArrayList getAllowedSizes()
    {
        com.appnexus.opensdk.b.b.b(b.d, com.appnexus.opensdk.b.b.a(an.d.get_allowed_sizes));
        return j.f();
    }

    public final int getBackgroundColor()
    {
        com.appnexus.opensdk.b.b.b(b.d, com.appnexus.opensdk.b.b.a(an.d.get_bg));
        return t;
    }

    public final int getCloseButtonDelay()
    {
        return u;
    }

    public final int getCreativeHeight()
    {
        return -1;
    }

    public final int getCreativeWidth()
    {
        return -1;
    }

    public final z getMediaType()
    {
        return com.appnexus.opensdk.z.b;
    }

    public final void k_()
    {
        super.k_();
        com.appnexus.opensdk.b.b.b(b.d, com.appnexus.opensdk.b.b.a(an.d.destroy_int));
        if (a != null)
        {
            a.a();
        }
        v.clear();
        q = null;
    }

    protected final void onLayout(boolean flag, int i, int l, int i1, int j1)
    {
    }

    final void setAdImplementation(AdActivity.a a1)
    {
        w = a1;
    }

    public final void setAllowedSizes(ArrayList arraylist)
    {
        com.appnexus.opensdk.b.b.b(b.d, com.appnexus.opensdk.b.b.a(an.d.set_allowed_sizes));
        j.q = arraylist;
    }

    public final void setBackgroundColor(int i)
    {
        com.appnexus.opensdk.b.b.b(b.d, com.appnexus.opensdk.b.b.a(an.d.set_bg));
        t = i;
    }

    public final void setCloseButtonDelay(int i)
    {
        u = Math.min(i, 10000);
    }
}
