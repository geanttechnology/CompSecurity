// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.ProductAvailabilityFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPAvailabilityFragment;
import com.bestbuy.android.api.lib.models.remix.StoreList;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class ik extends ka
{

    private static int k = 0;
    private String a;
    private String j;
    private ArrayList l;

    public ik(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, String s1)
    {
        super(activity, bbybasefragment, view);
        a = s1;
        j = s;
    }

    static int a(int i)
    {
        k = i;
        return i;
    }

    static Activity a(ik ik1)
    {
        return ik1.f;
    }

    static BBYBaseFragment b(ik ik1)
    {
        return ik1.i;
    }

    static View c(ik ik1)
    {
        return ik1.g;
    }

    static String d(ik ik1)
    {
        return ik1.j;
    }

    static String e(ik ik1)
    {
        return ik1.a;
    }

    static int f()
    {
        int i = k;
        k = i + 1;
        return i;
    }

    public void a()
    {
        l = fs.a(j, a, 0, 25).getStores();
    }

    public void b()
    {
        k = 0;
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (l != null)
        {
            while ((i instanceof PDPAvailabilityFragment) && i.isAdded() || !(i instanceof ProductAvailabilityFragment) || !i.isAdded()) 
            {
                return;
            }
            ((ProductAvailabilityFragment)i).a(l);
            return;
        } else
        {
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
        if ((i instanceof ProductAvailabilityFragment) && i.isAdded())
        {
            ((ProductAvailabilityFragment)i).a(j);
            return;
        } else
        {
            nm.a(f, new no() {

                final ik a;

                public void a()
                {
                    ik.f();
                    (new ik(ik.a(a), ik.b(a), ik.c(a), ik.d(a), ik.e(a))).executeOnExecutor(nb.h, new Void[0]);
                }

            
            {
                a = ik.this;
                super();
            }
            }, new nn() {

                final ik a;

                public void a()
                {
                    ik.a(0);
                }

            
            {
                a = ik.this;
                super();
            }
            }, e, k);
            return;
        }
    }

    public void onPreExecute()
    {
        super.onPreExecute();
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
