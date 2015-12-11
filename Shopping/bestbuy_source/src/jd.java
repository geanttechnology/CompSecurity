// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.EmptyWeddingRegistryContainer;
import com.bestbuy.android.activities.registry.ListIdSearchFragment;
import com.bestbuy.android.activities.registry.MyRegistryDetailsFragment;
import com.bestbuy.android.activities.registry.MyWeddingRegistryFragment;
import com.bestbuy.android.activities.registry.MyWishListsFragment;
import com.bestbuy.android.activities.registry.RegistrySearchResults;
import com.bestbuy.android.activities.registry.WishListWithProductsFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class jd extends ka
{

    private static int m = 0;
    private String a;
    private String j;
    private String k;
    private ArrayList l;
    private boolean n;
    private boolean o;

    public jd(Activity activity, BBYBaseFragment bbybasefragment, String s, String s1, String s2, boolean flag, View view)
    {
        super(activity, bbybasefragment);
        o = false;
        a = s;
        k = s1;
        j = s2;
        n = flag;
        g = view;
    }

    static int a(int i)
    {
        m = i;
        return i;
    }

    public void a()
    {
        l = fs.c(a, k, j, fr.b());
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        m = 0;
        if ((i instanceof WishListWithProductsFragment) && i.isAdded())
        {
            ((WishListWithProductsFragment)i).a(l);
        } else
        {
            if ((i instanceof MyWeddingRegistryFragment) && i.isAdded())
            {
                ((MyWeddingRegistryFragment)i).a(l);
                return;
            }
            if ((i instanceof RegistrySearchResults) && i.isAdded())
            {
                ((RegistrySearchResults)i).a(l);
                return;
            }
            if ((i instanceof MyRegistryDetailsFragment) && i.isAdded())
            {
                ((MyRegistryDetailsFragment)i).a(l);
                return;
            }
            if ((i instanceof ListIdSearchFragment) && i.isAdded())
            {
                ((ListIdSearchFragment)i).a(l);
                return;
            }
            if ((i instanceof EmptyWeddingRegistryContainer) && i.isAdded())
            {
                ((EmptyWeddingRegistryContainer)i).a(l);
                return;
            }
            if ((i instanceof MyWishListsFragment) && i.isAdded())
            {
                ((MyWishListsFragment)i).b(l);
                return;
            }
        }
    }

    public void c()
    {
        nm.a(f, new no() {

            final jd a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jd.this;
                super();
            }
        }, new nn() {

            final jd a;

            public void a()
            {
                jd.a(0);
            }

            
            {
                a = jd.this;
                super();
            }
        }, e, m);
    }

    public void d()
    {
        m++;
        (new jd(f, i, a, k, j, false, g)).executeOnExecutor(nb.g, new Void[0]);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (g != null)
        {
            g.setVisibility(0);
            g.bringToFront();
        }
    }

}
