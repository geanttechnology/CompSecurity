// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.registry.EmptyWeddingRegistryContainer;
import com.bestbuy.android.activities.registry.MyEmptyWeddingRegistryList;
import com.bestbuy.android.activities.registry.WeddingRegistrySettings;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.base.BBYBaseFragment;

public class jj extends ka
{

    private static int l = 0;
    private String a;
    private String j;
    private RegistryWishList k;

    public jj(Activity activity, BBYBaseFragment bbybasefragment, View view, String s)
    {
        super(activity, bbybasefragment);
        a = s;
        g = view;
    }

    static int a(int i)
    {
        l = i;
        return i;
    }

    static Activity a(jj jj1)
    {
        return jj1.f;
    }

    public void a()
    {
        k = fs.c(a, fr.b());
    }

    public void b()
    {
        if ((i instanceof MyEmptyWeddingRegistryList) || (i instanceof PDPFragment) || (i instanceof EmptyWeddingRegistryContainer))
        {
            if (k != null)
            {
                if ((i instanceof MyEmptyWeddingRegistryList) && i.isAdded())
                {
                    ((MyEmptyWeddingRegistryList)i).a(k);
                } else
                if ((i instanceof WeddingRegistrySettings) && i.isAdded())
                {
                    ((WeddingRegistrySettings)i).a(k);
                } else
                if ((i instanceof EmptyWeddingRegistryContainer) && i.isAdded())
                {
                    ((EmptyWeddingRegistryContainer)i).a(k);
                }
                j = k.getUuid();
            } else
            {
                c();
            }
        }
        if (g != null)
        {
            g.setVisibility(8);
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final jj a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jj.this;
                super();
            }
        }, new nn() {

            final jj a;

            public void a()
            {
                jj.a(0);
                ((HomeActivity)jj.a(a)).onBackPressed();
            }

            
            {
                a = jj.this;
                super();
            }
        }, e, l);
    }

    public void d()
    {
        l++;
        (new jj(f, i, g, fr.d())).executeOnExecutor(nb.g, new Void[0]);
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
