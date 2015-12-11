// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.ListIdSearchFragment;
import com.bestbuy.android.activities.registry.RegistrySearchResults;
import com.bestbuy.android.api.lib.models.registry.RegistryWishListCompleteData;
import com.bestbuy.android.base.BBYBaseFragment;

public class js extends ka
{

    private static int n = 0;
    private String a;
    private RegistryWishListCompleteData j;
    private boolean k;
    private int l;
    private String m;

    public js(Activity activity, BBYBaseFragment bbybasefragment, String s, boolean flag, View view, int i, String s1)
    {
        super(activity, bbybasefragment);
        a = s;
        k = flag;
        g = view;
        l = i;
        m = s1;
    }

    static int a(int i)
    {
        n = i;
        return i;
    }

    public void a()
    {
        String s = "weddingregistrylist";
        if (k)
        {
            s = "list";
        }
        j = fs.a(a, s, k, l, m);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (j != null)
        {
            if ((i instanceof RegistrySearchResults) && i.isAdded())
            {
                ((RegistrySearchResults)i).a(j);
            } else
            if ((i instanceof ListIdSearchFragment) && i.isAdded())
            {
                ((ListIdSearchFragment)i).a(j);
                return;
            }
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final js a;

            public void a()
            {
                a.d();
            }

            
            {
                a = js.this;
                super();
            }
        }, new nn() {

            final js a;

            public void a()
            {
                js.a(0);
            }

            
            {
                a = js.this;
                super();
            }
        }, e, n);
    }

    public void d()
    {
        n++;
        (new js(f, i, a, k, g, l, m)).executeOnExecutor(nb.g, new Void[0]);
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
