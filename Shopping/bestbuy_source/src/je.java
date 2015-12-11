// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.CreateWishListFragment;
import com.bestbuy.android.activities.registry.WishListSettingsFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class je extends ka
{

    private static int j = 0;
    private ArrayList a;

    public je(Activity activity, BBYBaseFragment bbybasefragment, View view)
    {
        super(activity, bbybasefragment);
        g = view;
    }

    static int a(int i)
    {
        j = i;
        return i;
    }

    static int f()
    {
        int i = j;
        j = i + 1;
        return i;
    }

    public void a()
    {
        j = 0;
        a = fs.d();
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if ((i instanceof CreateWishListFragment) && i.isAdded())
        {
            ((CreateWishListFragment)i).a(a);
        }
        if ((i instanceof WishListSettingsFragment) && i.isAdded())
        {
            ((WishListSettingsFragment)i).a(a);
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final je a;

            public void a()
            {
                je.f();
                a.d();
            }

            
            {
                a = je.this;
                super();
            }
        }, new nn() {

            final je a;

            public void a()
            {
                je.a(0);
            }

            
            {
                a = je.this;
                super();
            }
        }, e, j);
    }

    public void d()
    {
        j++;
        (new je(f, i, g)).executeOnExecutor(nb.g, new Void[0]);
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
