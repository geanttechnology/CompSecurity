// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.flurry.android.ICustomAdNetworkHandler;
import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.AdSpaceLayout;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            s, ap, cr, j, 
//            i, gd, av, aw, 
//            co, ef, ec

public class eg
{

    private static final String a = com/flurry/sdk/eg.getSimpleName();
    private static final Map b = b();

    public eg()
    {
    }

    private static int a(ViewGroup viewgroup, AdUnit adunit)
    {
        int k = viewgroup.getChildCount();
        if (adunit == null || adunit.adFrames.size() < 1)
        {
            return k;
        }
        viewgroup = ((AdFrame)adunit.adFrames.get(0)).adSpaceLayout;
        if (viewgroup != null)
        {
            viewgroup = ((AdSpaceLayout) (viewgroup)).alignment.split("-");
            if (viewgroup.length == 2 && "t".equals(viewgroup[0]))
            {
                return 0;
            }
        }
        return k;
    }

    private static c a(ViewGroup viewgroup)
    {
        return (c)b.get(viewgroup.getClass());
    }

    static String a()
    {
        return a;
    }

    public static void a(Context context, s s1)
    {
        if (context == null || s1 == null)
        {
            return;
        }
        ap ap1 = s1.k();
        AdUnit adunit = ap1.a();
        Object obj = (AdFrame)adunit.adFrames.get(0);
        int k = ((AdFrame) (obj)).binding;
        String s2 = ((AdFrame) (obj)).content;
        obj = cr.a(((AdFrame) (obj)).adSpaceLayout);
        ICustomAdNetworkHandler icustomadnetworkhandler = j.a().c();
        ef ef1 = i.a().p();
        if (k == 4 && icustomadnetworkhandler != null)
        {
            obj = icustomadnetworkhandler.getAdFromNetwork(context, ((com.flurry.android.AdCreative) (obj)), s2);
        } else
        {
            obj = ef1.b(context, s1);
        }
        if (obj == null)
        {
            gd.e(a, (new StringBuilder()).append("Failed to create view for ad network: ").append(s2).append(", network is unsupported on Android, or no ICustomAdNetworkHandler was registered or it failed to return a view.").toString());
            obj = new HashMap();
            ((Map) (obj)).put("errorCode", Integer.toString(av.p.a()));
            if (k == 4)
            {
                ((Map) (obj)).put("binding_3rd_party", Integer.toString(4));
            }
            co.a(aw.g, ((Map) (obj)), context, s1, ap1, 1);
            return;
        } else
        {
            a(s1, ((ec) (obj)), adunit);
            return;
        }
    }

    private static void a(s s1, ec ec1, AdUnit adunit)
    {
        if (s1 == null || ec1 == null || adunit == null)
        {
            return;
        }
        ViewGroup viewgroup = s1.f();
        RelativeLayout relativelayout = s1.s();
        if (relativelayout == null)
        {
            relativelayout = new RelativeLayout(s1.e());
            s1.a(relativelayout);
        }
        ViewGroup viewgroup1 = (ViewGroup)relativelayout.getParent();
        if (viewgroup1 != null)
        {
            viewgroup1.removeView(relativelayout);
        }
        relativelayout.removeAllViews();
        viewgroup1 = (ViewGroup)ec1.getParent();
        if (viewgroup1 != null)
        {
            viewgroup1.removeView(ec1);
        }
        relativelayout.addView(ec1, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        ec1.initLayout();
        ec1 = b(viewgroup, adunit);
        if (ec1 != null)
        {
            relativelayout.setLayoutParams(ec1);
            gd.a(3, a, (new StringBuilder()).append("banner ad holder layout params = ").append(ec1.getClass().getName()).append(" {width = ").append(((android.view.ViewGroup.LayoutParams) (ec1)).width).append(", height = ").append(((android.view.ViewGroup.LayoutParams) (ec1)).height).append("} for banner ad with adSpaceName = ").append(s1.g()).toString());
        }
        viewgroup.setBackgroundColor(0x16000000);
        viewgroup.addView(relativelayout, a(viewgroup, adunit));
    }

    private static android.view.ViewGroup.LayoutParams b(ViewGroup viewgroup, AdUnit adunit)
    {
        if (adunit == null || adunit.adFrames.size() < 1)
        {
            adunit = null;
        } else
        {
            adunit = ((AdFrame)adunit.adFrames.get(0)).adSpaceLayout;
            if (adunit == null)
            {
                return null;
            }
            Object obj = a(viewgroup);
            if (obj == null)
            {
                gd.a(5, a, (new StringBuilder()).append("Ad space layout and alignment from the server is being ignored for ViewGroup subclass ").append(viewgroup.getClass().getSimpleName()).toString());
                return null;
            }
            obj = ((c) (obj)).a(adunit);
            adunit = ((AdUnit) (obj));
            if (obj == null)
            {
                gd.a(6, a, (new StringBuilder()).append("Ad space layout and alignment from the server is being ignored for ViewGroup subclass ").append(viewgroup.getClass().getSimpleName()).toString());
                return ((android.view.ViewGroup.LayoutParams) (obj));
            }
        }
        return adunit;
    }

    private static Map b()
    {
        HashMap hashmap = new HashMap();
        hashmap.put(android/widget/LinearLayout, new d());
        hashmap.put(android/widget/AbsoluteLayout, new a());
        hashmap.put(android/widget/FrameLayout, new b());
        hashmap.put(android/widget/RelativeLayout, new e());
        return Collections.unmodifiableMap(hashmap);
    }


    private class c
    {

        private static boolean h(AdSpaceLayout adspacelayout)
        {
            return adspacelayout.adWidth != 0;
        }

        private static boolean i(AdSpaceLayout adspacelayout)
        {
            return adspacelayout.adHeight != 0;
        }

        public abstract android.view.ViewGroup.LayoutParams a(AdSpaceLayout adspacelayout);

        public int b(AdSpaceLayout adspacelayout)
        {
            if (h(adspacelayout))
            {
                return d(adspacelayout);
            } else
            {
                return f(adspacelayout);
            }
        }

        public int c(AdSpaceLayout adspacelayout)
        {
            if (i(adspacelayout))
            {
                return e(adspacelayout);
            } else
            {
                return g(adspacelayout);
            }
        }

        public int d(AdSpaceLayout adspacelayout)
        {
            return hn.b(adspacelayout.adWidth);
        }

        public int e(AdSpaceLayout adspacelayout)
        {
            return hn.b(adspacelayout.adHeight);
        }

        public int f(AdSpaceLayout adspacelayout)
        {
            return -1;
        }

        public int g(AdSpaceLayout adspacelayout)
        {
            return -2;
        }

        private c()
        {
        }

    }


    private class d extends c
    {

        public android.view.ViewGroup.LayoutParams a(AdSpaceLayout adspacelayout)
        {
            return new android.widget.LinearLayout.LayoutParams(b(adspacelayout), c(adspacelayout));
        }

        d()
        {
        }
    }


    private class a extends c
    {

        public android.view.ViewGroup.LayoutParams a(AdSpaceLayout adspacelayout)
        {
            gd.a(5, eg.a(), "AbsoluteLayout is deprecated, please consider to use FrameLayout or RelativeLayout for banner ad container view");
            return new android.widget.AbsoluteLayout.LayoutParams(b(adspacelayout), c(adspacelayout), 0, 0);
        }

        a()
        {
        }
    }


    private class b extends c
    {

        public android.view.ViewGroup.LayoutParams a(AdSpaceLayout adspacelayout)
        {
            return new android.widget.FrameLayout.LayoutParams(b(adspacelayout), c(adspacelayout), 17);
        }

        b()
        {
        }
    }


    private class e extends c
    {

        private static final Map a = a();

        private static Integer a(String s1)
        {
            return (Integer)a.get(s1);
        }

        private static Map a()
        {
            HashMap hashmap = new HashMap();
            hashmap.put("b", Integer.valueOf(12));
            hashmap.put("t", Integer.valueOf(10));
            hashmap.put("m", Integer.valueOf(15));
            hashmap.put("c", Integer.valueOf(14));
            hashmap.put("l", Integer.valueOf(9));
            hashmap.put("r", Integer.valueOf(11));
            return Collections.unmodifiableMap(hashmap);
        }

        public android.view.ViewGroup.LayoutParams a(AdSpaceLayout adspacelayout)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(b(adspacelayout), c(adspacelayout));
            adspacelayout = adspacelayout.alignment.split("-");
            if (adspacelayout.length == 2)
            {
                Integer integer = a(adspacelayout[0]);
                if (integer != null)
                {
                    layoutparams.addRule(integer.intValue());
                }
                adspacelayout = a(adspacelayout[1]);
                if (adspacelayout != null)
                {
                    layoutparams.addRule(adspacelayout.intValue());
                }
            }
            return layoutparams;
        }

        public int g(AdSpaceLayout adspacelayout)
        {
            return -1;
        }


        e()
        {
        }
    }

}
