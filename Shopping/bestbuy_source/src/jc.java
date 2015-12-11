// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.WeddingRegistrySettings;
import com.bestbuy.android.activities.registry.WishListSettingsFragment;
import com.bestbuy.android.base.BBYBaseFragment;

public class jc extends ka
{

    private static int l = 0;
    private String a;
    private String j;
    private boolean k;

    public jc(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, String s1)
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

    public void a()
    {
        k = fs.a(fr.d(), j, a, fr.b());
    }

    public void b()
    {
        l = 0;
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (k)
        {
            if ((i instanceof WishListSettingsFragment) && i.isAdded())
            {
                ((WishListSettingsFragment)i).d();
            } else
            if ((i instanceof WeddingRegistrySettings) && i.isAdded())
            {
                ((WeddingRegistrySettings)i).c();
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

            final jc a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jc.this;
                super();
            }
        }, new nn() {

            final jc a;

            public void a()
            {
                jc.a(0);
            }

            
            {
                a = jc.this;
                super();
            }
        }, e, l);
    }

    public void d()
    {
        l++;
        (new jc(f, i, g, a, j)).executeOnExecutor(nb.g, new Void[0]);
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
