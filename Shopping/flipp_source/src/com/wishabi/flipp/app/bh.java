// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.location.Location;
import android.support.v4.view.ae;
import android.support.v4.view.ch;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.l;
import com.wishabi.flipp.b.m;
import com.wishabi.flipp.b.r;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.util.p;
import com.wishabi.flipp.widget.FlyerToolbar;
import com.wishabi.flipp.widget.FlyerViewGroup;
import com.wishabi.flipp.widget.bn;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;
import java.util.HashMap;
import java.util.Timer;

// Referenced classes of package com.wishabi.flipp.app:
//            FlyerCarouselFragment, bo

final class bh extends ch
{

    final FlyerCarouselFragment a;

    bh(FlyerCarouselFragment flyercarouselfragment)
    {
        a = flyercarouselfragment;
        super();
    }

    public final void a(int j)
    {
label0:
        {
            com.wishabi.flipp.app.FlyerCarouselFragment.a(a, j);
            Object obj;
            com.wishabi.flipp.content.Flyer.Model model;
            boolean flag;
            boolean flag1;
            if (FlyerCarouselFragment.d(a) != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                SharedPreferences sharedpreferences = p.a();
                if (sharedpreferences != null && !sharedpreferences.getBoolean("tutorial_showed_cross_browse", false))
                {
                    sharedpreferences.edit().putBoolean("tutorial_showed_cross_browse", true).commit();
                }
            }
            model = (com.wishabi.flipp.content.Flyer.Model)FlyerCarouselFragment.e(a)[j];
            com.wishabi.flipp.app.FlyerCarouselFragment.a(a, model);
            FlyerCarouselFragment.b(a, model.n);
            FlyerCarouselFragment.b(a, model.d);
            com.wishabi.flipp.app.FlyerCarouselFragment.a(a, String.valueOf(model.a));
            com.wishabi.flipp.app.FlyerCarouselFragment.a(a, (bo)FlyerCarouselFragment.f(a).getAdapter().a(FlyerCarouselFragment.f(a), FlyerCarouselFragment.f(a).getCurrentItem()));
            FlyerCarouselFragment.g(a);
            a.a.r = FlyerCarouselFragment.h(a);
            com.wishabi.flipp.app.FlyerCarouselFragment.i(a);
            if (!FlyerCarouselFragment.j(a))
            {
                Object obj1 = a.a;
                com.wishabi.flipp.content.Flyer.Model model2 = FlyerCarouselFragment.d(a);
                ((a) (obj1)).b();
                if (model2 != null)
                {
                    obj1.d = false;
                    ((a) (obj1)).a("flyerView");
                    ((a) (obj1)).a("open", String.format("open | MER %s | MID %d", new Object[] {
                        model2.g, Integer.valueOf(model2.d)
                    }), String.format("open | MER %s | MID %d | FID %d", new Object[] {
                        model2.g, Integer.valueOf(model2.d), Integer.valueOf(model2.a)
                    }));
                    obj1.g = new Timer();
                    ((a) (obj1)).g.schedule(new m(((a) (obj1)), model2), 8000L);
                    flag1 = ((a) (obj1)).b(model2, r.a);
                    HashMap hashmap = new HashMap();
                    hashmap.put("flyer_id", String.valueOf(model2.a));
                    hashmap.put("analytics_payload", model2.o);
                    hashmap.put("flyer_run_id", String.valueOf(model2.b));
                    hashmap.put("flyer_type_id", String.valueOf(model2.c));
                    hashmap.put("merchant_id", String.valueOf(model2.d));
                    if (model2.e)
                    {
                        obj = "1";
                    } else
                    {
                        obj = "0";
                    }
                    hashmap.put("flipp_premium_merchant", obj);
                    hashmap.put("postal_code", model2.f);
                    if (flag1)
                    {
                        obj = "1";
                    } else
                    {
                        obj = "0";
                    }
                    hashmap.put("repeat", obj);
                    if (((a) (obj1)).c != null)
                    {
                        obj = String.valueOf(((a) (obj1)).c.getLatitude());
                    } else
                    {
                        obj = "0";
                    }
                    hashmap.put("lat", obj);
                    if (((a) (obj1)).c != null)
                    {
                        obj = String.valueOf(((a) (obj1)).c.getLongitude());
                    } else
                    {
                        obj = "0";
                    }
                    hashmap.put("lon", obj);
                    com.wishabi.flipp.b.a.b("Flyer Open", hashmap);
                    ((a) (obj1)).a("open", hashmap, false);
                    ((a) (obj1)).a(model2, r.a);
                }
            } else
            {
                obj = a.a;
                com.wishabi.flipp.content.Flyer.Model model1 = FlyerCarouselFragment.d(a);
                ((a) (obj)).b();
                obj.g = new Timer();
                ((a) (obj)).g.schedule(new l(((a) (obj)), model1), 8000L);
                FlyerCarouselFragment.k(a);
            }
            FlyerCarouselFragment.b(a).a();
            obj = FlyerCarouselFragment.b(a);
            obj.g = true;
            if (((bo) (obj)).b != null)
            {
                if (((bo) (obj)).g)
                {
                    ((bo) (obj)).b.a();
                } else
                {
                    ((bo) (obj)).b.d.a();
                }
            }
            obj = a.getActivity();
            if (obj != null)
            {
                obj1 = new ContentValues();
                ((ContentValues) (obj1)).put("_id", com.wishabi.flipp.app.FlyerCarouselFragment.l(a));
                ((ContentValues) (obj1)).put("valid_to", model.m);
                ((Activity) (obj)).getContentResolver().insert(i.h, ((ContentValues) (obj1)));
            }
            obj = a;
            if (!com.wishabi.flipp.app.FlyerCarouselFragment.m(a))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            FlyerCarouselFragment.c(((FlyerCarouselFragment) (obj)), flag1);
            FlyerCarouselFragment.n(a);
            obj = a.getLoaderManager();
            if (obj != null)
            {
                ((LoaderManager) (obj)).restartLoader(0, null, a);
                if (!FlyerCarouselFragment.b(a).b())
                {
                    break label0;
                }
                FlyerCarouselFragment.o(a).setProgressVisible(true);
            }
            return;
        }
        FlyerCarouselFragment.b(a).c();
    }
}
