// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.EmptyWeddingRegistryContainer;
import com.bestbuy.android.activities.registry.MyEmptyWeddingRegistryList;
import com.bestbuy.android.activities.registry.WeddingRegistrySettings;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.base.BBYBaseFragment;

public class jm extends ka
{

    private static int k = 0;
    private RegistryWishList a;
    private String j;

    public jm(Activity activity, BBYBaseFragment bbybasefragment, View view, String s)
    {
        super(activity, bbybasefragment);
        j = s;
        g = view;
    }

    static int a(int i)
    {
        k = i;
        return i;
    }

    static int f()
    {
        int i = k;
        k = i + 1;
        return i;
    }

    public void a()
    {
        k = 0;
        a = fs.b(fr.d(), j, "weddingregistrylists", fr.b());
    }

    public void b()
    {
        k = 0;
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (a != null)
        {
            if ((i instanceof MyEmptyWeddingRegistryList) && i.isAdded())
            {
                ((MyEmptyWeddingRegistryList)i).a(a);
            } else
            {
                if ((i instanceof WeddingRegistrySettings) && i.isAdded())
                {
                    ((WeddingRegistrySettings)i).a(a);
                    return;
                }
                if ((i instanceof EmptyWeddingRegistryContainer) && i.isAdded())
                {
                    ((EmptyWeddingRegistryContainer)i).a(a);
                    return;
                }
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

            final jm a;

            public void a()
            {
                jm.f();
                a.d();
            }

            
            {
                a = jm.this;
                super();
            }
        }, new nn() {

            final jm a;

            public void a()
            {
                jm.a(0);
            }

            
            {
                a = jm.this;
                super();
            }
        }, e, k);
    }

    public void d()
    {
        k++;
        (new jm(f, i, g, j)).executeOnExecutor(nb.g, new Void[0]);
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
