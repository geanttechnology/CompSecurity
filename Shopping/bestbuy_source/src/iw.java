// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponseRoot;
import com.bestbuy.android.api.lib.models.remix.StoreList;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class iw extends ka
{

    private static int l = 0;
    private String a;
    private PDPOverviewResponseRoot j;
    private nb k;
    private Activity m;
    private String n;

    public iw(Activity activity, String s, String s1, BBYBaseFragment bbybasefragment, View view)
    {
        a = "";
        m = activity;
        a = s;
        n = s1;
        i = bbybasefragment;
        k = nb.a();
        g = view;
    }

    static int a(int i)
    {
        l = i;
        return i;
    }

    static Activity a(iw iw1)
    {
        return iw1.m;
    }

    static String b(iw iw1)
    {
        return iw1.a;
    }

    static String c(iw iw1)
    {
        return iw1.n;
    }

    static BBYBaseFragment d(iw iw1)
    {
        return iw1.i;
    }

    static View e(iw iw1)
    {
        return iw1.g;
    }

    static int f()
    {
        int i = l;
        l = i + 1;
        return i;
    }

    private BBYStore g()
    {
        Object obj = fs.a(i.getActivity(), k.y(), k.z(), a, 1, 10).getStores();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        if (((ArrayList) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_62;
        }
        obj = (BBYStore)((ArrayList) (obj)).get(0);
        return ((BBYStore) (obj));
        Exception exception;
        exception;
        exception.printStackTrace();
        return null;
    }

    public void a()
    {
        if (n != null && !n.isEmpty())
        {
            j = fs.f(a, n);
        } else
        {
            BBYStore bbystore;
            if (!String.valueOf(k.y()).equalsIgnoreCase("0.0") && !String.valueOf(k.z()).equalsIgnoreCase("0.0"))
            {
                bbystore = g();
            } else
            {
                bbystore = null;
            }
            if (bbystore != null && a != null && !a.isEmpty())
            {
                j = fs.f(a, bbystore.getStoreId());
                return;
            }
            if (a != null && !a.isEmpty())
            {
                j = fs.f(a, null);
                return;
            }
        }
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (j != null && (i instanceof ix) && i.isAdded())
        {
            l = 0;
            (new hc(m, i, a)).executeOnExecutor(nb.h, new Void[0]);
            ((ix)i).a(j);
            return;
        } else
        {
            e = false;
            c();
            return;
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(m, new no() {

            final iw a;

            public void a()
            {
                iw.f();
                (new iw(iw.a(a), iw.b(a), iw.c(a), iw.d(a), iw.e(a))).executeOnExecutor(nb.h, new Void[0]);
            }

            
            {
                a = iw.this;
                super();
            }
        }, new nn() {

            final iw a;

            public void a()
            {
                iw.a(0);
                ((HomeActivity)iw.a(a)).onBackPressed();
            }

            
            {
                a = iw.this;
                super();
            }
        }, e, l);
    }

}
