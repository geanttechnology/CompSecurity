// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.RegistryAndGiftsFragment;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.base.BBYBaseFragment;

public class jo extends ka
{

    private static int k = 0;
    private RegistryWishList a;
    private String j;

    public jo(Activity activity, BBYBaseFragment bbybasefragment, View view, String s)
    {
        super(activity, bbybasefragment);
        g = view;
        j = s;
    }

    static int a(int i)
    {
        k = i;
        return i;
    }

    public void a()
    {
        a = fs.d(j, fr.b());
    }

    public void b()
    {
        k = 0;
        if (g != null)
        {
            g.setVisibility(8);
        }
        if ((i instanceof RegistryAndGiftsFragment) && i.isAdded())
        {
            boolean flag;
            if (a != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((RegistryAndGiftsFragment)i).a(flag);
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final jo a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jo.this;
                super();
            }
        }, new nn() {

            final jo a;

            public void a()
            {
                jo.a(0);
            }

            
            {
                a = jo.this;
                super();
            }
        }, e, k);
    }

    public void d()
    {
        k++;
        (new jo(f, i, g, j)).executeOnExecutor(nb.g, new Void[0]);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
