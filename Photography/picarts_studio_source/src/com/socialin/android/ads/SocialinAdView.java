// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;
import com.firegnom.rat.util.DialogUtils;
import com.picsart.studio.ads.i;
import com.socialin.android.d;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.ads:
//            AdProviders, SocialinBannerView

public class SocialinAdView extends ViewFlipper
{

    public static AdProviders b;
    i a;
    public AdProviders c;
    private int d;
    private int e;
    private SocialinBannerView f;
    private int g;

    public SocialinAdView(Context context)
    {
        super(context);
        d = 320;
        e = 50;
        f = null;
        a = null;
        c = AdProviders.NONE;
        g = 320;
        a();
    }

    public SocialinAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d = 320;
        e = 50;
        f = null;
        a = null;
        c = AdProviders.NONE;
        g = 320;
        a();
    }

    private void a()
    {
        d = (int)TypedValue.applyDimension(1, 320F, getContext().getResources().getDisplayMetrics());
        e = (int)TypedValue.applyDimension(1, 50F, getContext().getResources().getDisplayMetrics());
        g = getContext().getResources().getDisplayMetrics().widthPixels;
    }

    public final void a(AdProviders adproviders)
    {
        Context context;
        com.socialin.android.d.b("PicsArt - startProvider() - provider:", new Object[] {
            adproviders.toString()
        });
        c = adproviders;
        f = null;
        a = null;
        context = getContext();
        removeAllViews();
        final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[AdProviders.values().length];
                try
                {
                    a[AdProviders.ADMOB.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[AdProviders.SOCIALIN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[AdProviders.MMEDIA3.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[AdProviders.AMAZON.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[AdProviders.INMOBI.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[AdProviders.MOPUB2.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[AdProviders.FBAD.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2.a[adproviders.ordinal()];
        JVM INSTR tableswitch 1 7: default 92
    //                   1 113
    //                   2 133
    //                   3 154
    //                   4 92
    //                   5 180
    //                   6 206
    //                   7 232;
           goto _L1 _L2 _L3 _L4 _L1 _L5 _L6 _L7
_L1:
        if (a == null) goto _L9; else goto _L8
_L8:
        addView(a.a());
_L11:
        return;
_L2:
        a = m.a(context, AdProviders.ADMOB, context.getString(0x7f0808a2));
        continue; /* Loop/switch isn't completed */
_L3:
        f = new SocialinBannerView((Activity)getContext());
        continue; /* Loop/switch isn't completed */
_L4:
        a = m.a(getContext(), AdProviders.MMEDIA3, getContext().getString(0x7f08093e));
        continue; /* Loop/switch isn't completed */
_L5:
        a = m.a(getContext(), AdProviders.INMOBI, getContext().getString(0x7f0808fd));
        continue; /* Loop/switch isn't completed */
_L6:
        a = m.a(getContext(), AdProviders.MOPUB2, getContext().getString(0x7f08094a));
        continue; /* Loop/switch isn't completed */
_L7:
        a = m.a(getContext(), AdProviders.FBAD, getContext().getString(0x7f0808e1));
        continue; /* Loop/switch isn't completed */
_L9:
        if (f == null) goto _L11; else goto _L10
_L10:
        addView(f, d, e);
        return;
        if (true) goto _L1; else goto _L12
_L12:
    }

    public void addView(View view)
    {
        addView(view, null);
    }

    public void addView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        RelativeLayout relativelayout = new RelativeLayout(getContext());
        relativelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, e));
        int j;
        int k;
        if (layoutparams == null)
        {
            relativelayout.addView(view);
        } else
        {
            relativelayout.addView(view, layoutparams);
        }
        layoutparams = (android.widget.RelativeLayout.LayoutParams)view.getLayoutParams();
        layoutparams.addRule(9);
        layoutparams.height = e;
        layoutparams.width = d;
        if (view.getId() == -1)
        {
            j = (int)System.currentTimeMillis() % 0xf4240;
        } else
        {
            j = view.getId();
        }
        view.setId(j);
        try
        {
            view = new Intent(getContext(), Class.forName("com.picsart.shop.ShopActivity"));
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            view = null;
        }
        k = g - d;
        if ((float)k >= Utils.a(40F, getContext()) && view != null)
        {
            layoutparams = new ImageView(getContext());
            k = Math.min(e, k);
            layoutparams.setLayoutParams(new android.widget.FrameLayout.LayoutParams(k, k));
            layoutparams.setOnClickListener(new android.view.View.OnClickListener(view) {

                private Intent a;
                private SocialinAdView b;

                public final void onClick(View view1)
                {
                    if (!s.a(b.getContext()))
                    {
                        DialogUtils.showNoNetworkDialog((Activity)b.getContext(), 0x7f080307, 0x7f080306, 0x7f080308, 0x7f0802a4, 0x108009b);
                        return;
                    } else
                    {
                        b.getContext().startActivity(a);
                        return;
                    }
                }

            
            {
                b = SocialinAdView.this;
                a = intent;
                super();
            }
            });
            layoutparams.setBackgroundResource(0x7f0205ed);
            relativelayout.addView(layoutparams);
            view = (android.widget.RelativeLayout.LayoutParams)layoutparams.getLayoutParams();
            view.addRule(15, j);
            view.leftMargin = d;
        }
        super.addView(relativelayout);
    }

    protected void onDetachedFromWindow()
    {
        try
        {
            super.onDetachedFromWindow();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void setDefaultAdProvider(AdProviders adproviders)
    {
        b = adproviders;
    }

    public void setKeywords(String s)
    {
        if (!TextUtils.isEmpty(null))
        {
            s = null;
        }
        com.socialin.android.d.b("SinAd.setKeywords() - kewords:", new Object[] {
            s
        });
        if (f != null)
        {
            f.setKeywords(s);
        }
    }

    public void setRefreshEnabled(boolean flag)
    {
    }

    static 
    {
        b = AdProviders.ADMOB;
    }
}
