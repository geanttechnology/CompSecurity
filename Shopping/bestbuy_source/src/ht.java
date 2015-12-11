// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import java.util.ArrayList;

public class ht extends ka
{

    private mq a;
    private String j;
    private String k;
    private String l;
    private String m;
    private BBYProduct n;
    private String o;

    public ht(Activity activity, mq mq1, String s)
    {
        super(activity, null);
        a = mq1;
        j = s;
        k = PDPFragment.b();
    }

    public ht(Activity activity, mq mq1, String s, String s1, BBYProduct bbyproduct)
    {
        super(activity, null);
        a = mq1;
        j = s;
        k = bbyproduct.getSkuId();
        l = bbyproduct.getEp();
        m = s1;
        n = bbyproduct;
    }

    public ht(Activity activity, mq mq1, String s, String s1, String s2)
    {
        super(activity, null);
        a = mq1;
        j = s;
        k = PDPFragment.b();
        l = s1;
        m = s2;
    }

    public ht(Activity activity, mq mq1, String s, String s1, String s2, BBYProduct bbyproduct)
    {
        super(activity, null);
        a = mq1;
        j = s;
        m = s1;
        o = s2;
        n = bbyproduct;
    }

    public void a()
    {
        if (j.equals("load"))
        {
            if (a.b() != null && a.b().size() > 0)
            {
                fs.a(a.g());
            }
            if (a.a() != null && a.a().size() > 0)
            {
                fs.a(a.h());
            }
        } else
        {
            if (j.equals("clickcustomeralsoviewed") || j.equals("clickcustomeralsobought"))
            {
                fs.a(a.a(m, n));
                return;
            }
            if (j.equals("addtocart"))
            {
                fs.a(a.a(k, l, m));
                return;
            }
            if (j.equals("productsloadmostpopular") || j.equals("cartloadmostpopular") || j.equals("storeloadmostpopular"))
            {
                fs.a(a.b(m, l));
                return;
            }
            if (j.equals("productsclickmostpopular") || j.equals("cartclickmostpopular") || j.equals("storesclickmostpopular"))
            {
                fs.a(a.c(m, n));
                return;
            }
            if (j.equals("homeloadrecentlyviewed"))
            {
                fs.a(a.a(m, o, n));
                return;
            }
            if (j.equals("homeclickrecentlyviewed"))
            {
                fs.a(a.d(m, n));
                return;
            }
            if (j.equals("homeloadalsoviewed"))
            {
                fs.a(a.b(m, o, n));
                return;
            }
            if (j.equals("homeclickcustomeralsoviewed"))
            {
                fs.a(a.e(m, n));
                return;
            }
            if (j.equals("homeloadtrendingnow"))
            {
                fs.a(a.a(m, l));
                return;
            }
            if (j.equals("homeclicktrendingnow"))
            {
                fs.a(a.b(m, n));
                return;
            }
            if (j.equals("wishlistloadrecentlyviewed") || j.equals("registryloadrecentlyviewed"))
            {
                fs.a(a.a(m, o, n));
                return;
            }
            if (j.equals("wishlistclickrecentlyviewed") || j.equals("registryclickrecentlyviewed"))
            {
                fs.a(a.d(m, n));
                return;
            }
        }
    }

    public void b()
    {
    }

    public void c()
    {
    }

    public void onPreExecute()
    {
        super.onPreExecute();
    }
}
