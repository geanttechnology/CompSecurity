// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.search.SearchApi;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYWebView;
import java.util.ArrayList;

public class iu extends ka
{

    private static int k = 0;
    private BBYWebView a;
    private String j;
    private SearchApi l;

    public iu(Activity activity, BBYBaseFragment bbybasefragment, String s, View view, BBYWebView bbywebview)
    {
        super(activity, bbybasefragment);
        j = s;
        g = view;
        a = bbywebview;
    }

    static int a(int i)
    {
        k = i;
        return i;
    }

    static Activity a(iu iu1)
    {
        return iu1.f;
    }

    static BBYBaseFragment b(iu iu1)
    {
        return iu1.i;
    }

    static String c(iu iu1)
    {
        return iu1.j;
    }

    static View d(iu iu1)
    {
        return iu1.g;
    }

    static BBYWebView e(iu iu1)
    {
        return iu1.a;
    }

    static int f()
    {
        int i = k;
        k = i + 1;
        return i;
    }

    static Activity f(iu iu1)
    {
        return iu1.f;
    }

    public void a()
    {
        l = fs.a(j, "promo", null, null, "Best-Match", false, false, 20, 1);
        if (l == null)
        {
            c();
        }
    }

    public void b()
    {
        if (l == null || l.getSkuList() == null || l.getSkuList().size() <= 0)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        k = 0;
        if (!(i instanceof MdotWebFragment) || !i.isAdded()) goto _L2; else goto _L1
_L1:
        a.a(l);
_L4:
        return;
_L2:
        if (!(i instanceof PLPFragment) || !i.isAdded()) goto _L4; else goto _L3
_L3:
        return;
        c();
        return;
    }

    public void c()
    {
        nm.a(f, new no() {

            final iu a;

            public void a()
            {
                iu.f();
                (new iu(iu.a(a), iu.b(a), iu.c(a), iu.d(a), iu.e(a))).executeOnExecutor(nb.h, new Void[0]);
            }

            
            {
                a = iu.this;
                super();
            }
        }, new nn() {

            final iu a;

            public void a()
            {
                iu.a(0);
                ((FragmentActivity)iu.f(a)).getSupportFragmentManager().popBackStack();
            }

            
            {
                a = iu.this;
                super();
            }
        }, e, k);
    }

    public void e()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
