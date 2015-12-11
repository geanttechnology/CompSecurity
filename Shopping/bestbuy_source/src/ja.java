// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.WishlistAdditionalOptions;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.base.BBYBaseFragment;

public class ja extends ka
{

    private static int k = 0;
    private WeddingRegistryData a;
    private RegistryWishList j;

    public ja(Activity activity, BBYBaseFragment bbybasefragment, View view, WeddingRegistryData weddingregistrydata)
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
        a.setCreatedBy(fr.c());
        a.setLastModifiedBy(fr.c());
        a.setFirstName(fr.e());
        a.setLastName(fr.f());
        j = fs.a(fr.d(), a.getListType(), fr.b(), a);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        k = 0;
        if (j != null && (i instanceof WishlistAdditionalOptions) && i.isAdded())
        {
            ((WishlistAdditionalOptions)i).a(j);
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final ja a;

            public void a()
            {
                a.d();
            }

            
            {
                a = ja.this;
                super();
            }
        }, new nn() {

            final ja a;

            public void a()
            {
                ja.a(0);
            }

            
            {
                a = ja.this;
                super();
            }
        }, e, k);
    }

    public void d()
    {
        k++;
        (new ja(f, i, g, a)).executeOnExecutor(nb.g, new Void[0]);
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
