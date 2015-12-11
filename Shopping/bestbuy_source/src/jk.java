// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.registry.WishListSettingsFragment;
import com.bestbuy.android.activities.registry.WishListWithProductsFragment;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.base.BBYBaseFragment;

public class jk extends ka
{

    private static int l = 0;
    private String a;
    private String j;
    private RegistryWishList k;

    public jk(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, String s1)
    {
        super(activity, bbybasefragment);
        a = s;
        j = s1;
        g = view;
    }

    static int a(int i)
    {
        l = i;
        return i;
    }

    static Activity a(jk jk1)
    {
        return jk1.f;
    }

    public void a()
    {
        k = fs.b(fr.d(), a, j, fr.b());
    }

    public void b()
    {
        if ((i instanceof WishListSettingsFragment) && i.isAdded())
        {
            if (g != null)
            {
                g.setVisibility(8);
            }
            ((WishListSettingsFragment)i).a(k);
        } else
        if ((i instanceof WishListWithProductsFragment) && i.isAdded())
        {
            ((WishListWithProductsFragment)i).a(k);
            return;
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final jk a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jk.this;
                super();
            }
        }, new nn() {

            final jk a;

            public void a()
            {
                jk.a(0);
                ((HomeActivity)jk.a(a)).onBackPressed();
            }

            
            {
                a = jk.this;
                super();
            }
        }, e, l);
    }

    public void d()
    {
        l++;
        (new jk(f, i, g, a, j)).executeOnExecutor(nb.g, new Void[0]);
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
