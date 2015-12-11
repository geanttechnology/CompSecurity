// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.RegistryAdditionalOptions;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.base.BBYBaseFragment;

public class iz extends ka
{

    private static int k = 0;
    private WeddingRegistryData a;
    private RegistryWishList j;

    public iz(Activity activity, BBYBaseFragment bbybasefragment, View view, WeddingRegistryData weddingregistrydata)
    {
        super(activity, bbybasefragment);
        a = weddingregistrydata;
        g = view;
    }

    static int a(int i)
    {
        k = i;
        return i;
    }

    public void a()
    {
        j = fs.a(fr.d(), "weddingregistrylists", fr.b(), a);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (j != null && (i instanceof RegistryAdditionalOptions) && i.isAdded())
        {
            ((RegistryAdditionalOptions)i).a(j);
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final iz a;

            public void a()
            {
                a.d();
            }

            
            {
                a = iz.this;
                super();
            }
        }, new nn() {

            final iz a;

            public void a()
            {
                iz.a(0);
            }

            
            {
                a = iz.this;
                super();
            }
        }, e, k);
    }

    public void d()
    {
        k++;
        (new iz(f, i, g, a)).executeOnExecutor(nb.g, new Void[0]);
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
