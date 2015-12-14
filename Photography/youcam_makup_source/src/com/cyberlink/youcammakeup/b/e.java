// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.b;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity;
import com.cyberlink.youcammakeup.activity.PromotionWebViewerActivity;
import com.cyberlink.youcammakeup.activity.SponsorAdActivity;
import com.cyberlink.youcammakeup.activity.WebViewerExActivity;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.clflurry.ae;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.u;
import com.cyberlink.youcammakeup.flurry.LauncherGotoEvent;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.d;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.pages.moreview.ag;
import com.cyberlink.youcammakeup.utility.a;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.b:
//            a

public class e extends com.cyberlink.youcammakeup.b.a
{

    private int a;
    private View b;
    private View c;
    private List d;
    private Map e;
    private boolean f;

    static int a(e e1, int i)
    {
        e1.a = i;
        return i;
    }

    static View a(e e1)
    {
        return e1.b;
    }

    static List a(e e1, List list)
    {
        e1.d = list;
        return list;
    }

    private void a(ViewFlipper viewflipper)
    {
        if (viewflipper == null)
        {
            return;
        }
        Object obj = Globals.d().getResources().getDisplayMetrics();
        double d1 = (double)((DisplayMetrics) (obj)).heightPixels / (double)((DisplayMetrics) (obj)).widthPixels;
        int i;
        if (Math.abs(1080 - ((DisplayMetrics) (obj)).widthPixels) < Math.abs(720 - ((DisplayMetrics) (obj)).widthPixels))
        {
            if (Math.abs(d1 - 1.7777777777777777D) < Math.abs(d1 - 1.3333333333333333D))
            {
                i = (int)(((double)((DisplayMetrics) (obj)).widthPixels / 1080D) * 173D);
            } else
            {
                i = (int)(((double)((DisplayMetrics) (obj)).widthPixels / 1080D) * 140D);
            }
        } else
        if (Math.abs(d1 - 1.7777777777777777D) < Math.abs(d1 - 1.3333333333333333D))
        {
            i = (int)(((double)((DisplayMetrics) (obj)).widthPixels / 720D) * 115D);
        } else
        {
            i = (int)(((double)((DisplayMetrics) (obj)).widthPixels / 720D) * 93D);
        }
        obj = viewflipper.getLayoutParams();
        obj.height = i;
        viewflipper.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
    }

    static void a(e e1, View view)
    {
        e1.d(view);
    }

    private boolean a(String s1)
    {
        return s1.indexOf(ag.b) == 0 || s1.indexOf(ag.a) == 0;
    }

    static View b(e e1)
    {
        return e1.c;
    }

    static void b(e e1, View view)
    {
        e1.c(view);
    }

    private void c(View view)
    {
        AnimationSet animationset = new AnimationSet(true);
        animationset.setInterpolator(new LinearInterpolator());
        animationset.setDuration(150L);
        animationset.addAnimation(new AlphaAnimation(0.0F, 1.0F));
        animationset.addAnimation(new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.5F, 1, 0.0F));
        view.clearAnimation();
        view.startAnimation(animationset);
    }

    private void d(View view)
    {
        AnimationSet animationset = new AnimationSet(true);
        animationset.setInterpolator(new LinearInterpolator());
        animationset.setDuration(150L);
        animationset.addAnimation(new AlphaAnimation(1.0F, 0.0F));
        animationset.addAnimation(new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 0.5F));
        view.clearAnimation();
        view.startAnimation(animationset);
    }

    private void w()
    {
        if (c != null)
        {
            c.setOnClickListener(new android.view.View.OnClickListener() {

                final e a;

                public void onClick(View view)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(com.cyberlink.youcammakeup.clflurry.BaseEvent.EventName.a);
                    com.cyberlink.youcammakeup.b.e.a(a).setVisibility(8);
                    com.cyberlink.youcammakeup.b.e.b(a).setVisibility(8);
                    com.cyberlink.youcammakeup.b.e.a(a, com.cyberlink.youcammakeup.b.e.a(a));
                }

            
            {
                a = e.this;
                super();
            }
            });
        }
    }

    private void x()
    {
        b.setVisibility(8);
        if (c != null)
        {
            c.setVisibility(8);
        }
        d d1 = new d();
        d1.a(new com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.e(d1) {

            final d a;
            final e b;

            public void a(List list)
            {
                if (list.size() <= 0)
                {
                    return;
                } else
                {
                    Globals.d(new Runnable(this, list) {

                        final List a;
                        final _cls2 b;

                        public void run()
                        {
                            com.cyberlink.youcammakeup.b.e.a(b.b, b.a.a());
                            com.cyberlink.youcammakeup.b.e.a(b.b, a);
                            b.b.m();
                        }

            
            {
                b = _pcls2;
                a = list;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                b = e.this;
                a = d1;
                super();
            }
        });
    }

    protected View a(LayoutInflater layoutinflater, Bitmap bitmap, String s1)
    {
        layoutinflater = layoutinflater.inflate(f(), null);
        ((ImageView)layoutinflater.findViewById(g())).setImageBitmap(bitmap);
        return layoutinflater;
    }

    protected Animation a(boolean flag)
    {
        AnimationSet animationset = new AnimationSet(true);
        ScaleAnimation scaleanimation = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        animationset.setDuration(e());
        animationset.setStartOffset(e());
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.addAnimation(scaleanimation);
        animationset.addAnimation(alphaanimation);
        return animationset;
    }

    public void a()
    {
        super.a();
        w();
        a((ViewFlipper)b.findViewById(0x7f0c0137));
        x();
    }

    protected void a(Activity activity, LayoutInflater layoutinflater, List list)
    {
        if (d != null)
        {
            if (e != null)
            {
                e.clear();
                e = null;
            }
            e = new HashMap();
            list = d.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner promotionbanner = (com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner)list.next();
                Object obj = promotionbanner.k;
                String s1 = promotionbanner.b;
                com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl skutryiturl = promotionbanner.l;
                long l = promotionbanner.a;
                if ((promotionbanner.j || a(s1) || com.cyberlink.youcammakeup.utility.a.b(s1)) && (obj != com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner.Scheme.b || f && (com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(skutryiturl.type, skutryiturl.skuGuid, skutryiturl.itemGuid) != null || a(s1) || com.cyberlink.youcammakeup.utility.a.b(s1))))
                {
                    obj = a(layoutinflater, promotionbanner.a(), null, new Runnable(((com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner.Scheme) (obj)), activity, s1, l, skutryiturl) {

                        final com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner.Scheme a;
                        final Activity b;
                        final String c;
                        final long d;
                        final com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl e;
                        final e f;

                        public void run()
                        {
                            Intent intent = new Intent();
                            if (a == com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner.Scheme.c)
                            {
                                intent.setClass(b, com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                                intent.putExtra("RedirectUrl", c);
                                intent.putExtra("BannerID", String.valueOf(d));
                            } else
                            if (com.cyberlink.youcammakeup.utility.a.b(c))
                            {
                                intent.setClass(b, com/cyberlink/youcammakeup/activity/PromotionWebViewerActivity);
                                intent.putExtra("PromotionPageID", String.valueOf(com.cyberlink.youcammakeup.utility.a.d(c)));
                            } else
                            if (c.indexOf(ag.b) == 0 || c.indexOf(ag.a) == 0)
                            {
                                YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.b.a());
                                intent.setClass(b, com/cyberlink/youcammakeup/activity/ExtraDownloadCategoryActivity);
                                com.cyberlink.youcammakeup.utility.a.a(c, b, intent);
                            } else
                            {
                                intent.setClass(b, com/cyberlink/youcammakeup/activity/SponsorAdActivity);
                                intent.putExtra("URL_CONTENT", e);
                                intent.putExtra(SponsorAdActivity.b, String.valueOf(d));
                            }
                            b.startActivity(intent);
                            b.finish();
                            f.k();
                            f.n();
                        }

            
            {
                f = e.this;
                a = scheme;
                b = activity;
                c = s1;
                d = l;
                e = skutryiturl;
                super();
            }
                    });
                    e.put(obj, promotionbanner);
                }
            } while (true);
        }
    }

    protected void a(View view)
    {
        b.setVisibility(8);
        if (c != null)
        {
            c.setVisibility(8);
        }
        if (e != null)
        {
            Object obj = (com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner)e.get(view);
            if (obj != null)
            {
                view = ((com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner) (obj)).l.type;
                String s1 = ((com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner) (obj)).l.skuGuid;
                String s2 = ((com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner) (obj)).l.itemGuid;
                obj = String.valueOf(((com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner) (obj)).a);
                if (view != null && s1 != null && s2 != null)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.e(view, s1, s2, ((String) (obj))));
                }
                com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.k));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent.LauncherTileName.k));
                if (obj != null)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new u(((String) (obj))));
                }
            }
        }
    }

    protected Animation b(boolean flag)
    {
        AnimationSet animationset = new AnimationSet(true);
        ScaleAnimation scaleanimation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, 1, 0.5F, 1, 0.5F);
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        animationset.setDuration(e());
        animationset.setInterpolator(new AccelerateInterpolator());
        animationset.addAnimation(scaleanimation);
        animationset.addAnimation(alphaanimation);
        return animationset;
    }

    protected void b(View view)
    {
        if (e != null)
        {
            view = (com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner)e.get(view);
            if (view != null)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new ae(String.valueOf(((com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner) (view)).a)));
            }
        }
    }

    protected int d()
    {
        int i = 1000;
        if (a > 1000)
        {
            i = a;
        }
        return i;
    }

    protected int f()
    {
        return 0x7f030207;
    }

    protected int g()
    {
        return 0x7f0c08e2;
    }

    protected int h()
    {
        return -1;
    }

    protected void m()
    {
        super.m();
        u();
    }

    public void n()
    {
        super.n();
        if (c != null)
        {
            c.setOnClickListener(null);
        }
        c = null;
        b = null;
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        for (Iterator iterator = d.iterator(); iterator.hasNext(); ((com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner)iterator.next()).b()) { }
          goto _L1
        Exception exception;
        exception;
        com.pf.common.utility.m.e("BigBangLauncherBannerCtrl", com.cyberlink.youcammakeup.utility.d.a(exception));
_L2:
        return;
_L1:
        d.clear();
        d = null;
        if (e != null)
        {
            e.clear();
            e = null;
            return;
        }
          goto _L2
    }

    protected List o()
    {
        return new ArrayList();
    }

    protected int p()
    {
        return 0x7f0c0144;
    }

    protected boolean s()
    {
        return true;
    }

    public void u()
    {
        if (e != null && e.size() > 0 && b.getVisibility() != 0)
        {
            Globals.d(new Runnable() {

                final e a;

                public void run()
                {
                    com.cyberlink.youcammakeup.b.e.a(a).setVisibility(0);
                    if (com.cyberlink.youcammakeup.b.e.b(a) != null)
                    {
                        com.cyberlink.youcammakeup.b.e.b(a).setVisibility(0);
                    }
                    com.cyberlink.youcammakeup.b.e.b(a, com.cyberlink.youcammakeup.b.e.a(a));
                }

            
            {
                a = e.this;
                super();
            }
            });
        }
    }

    public void v()
    {
        com.pf.common.utility.m.b("BigBangLauncherBannerCtrl", "notifySkuReady");
        f = true;
        m();
    }
}
