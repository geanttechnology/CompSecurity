// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.widget.ProgressBar;
import com.bestbuy.android.activities.registry.ScannedItemFragment;
import com.bestbuy.android.activities.registry.WishListWithProductsFragment;
import com.bestbuy.android.base.BBYBaseFragment;

public class jv extends ka
{

    private static int n = 0;
    private String a;
    private String j;
    private String k;
    private boolean l;
    private boolean m;
    private ProgressBar o;
    private mp p;

    public jv(Activity activity, BBYBaseFragment bbybasefragment, String s, String s1, String s2, boolean flag, ProgressBar progressbar, 
            mp mp)
    {
        super(activity, bbybasefragment);
        a = s;
        j = s1;
        k = s2;
        l = flag;
        o = progressbar;
        p = mp;
    }

    static int a(int i)
    {
        n = i;
        return i;
    }

    public void a()
    {
        m = fs.a(fr.d(), a, j, k, fr.b(), l);
    }

    public void b()
    {
        n = 0;
        if (o != null)
        {
            o.setVisibility(8);
        }
        if ((i instanceof WishListWithProductsFragment) && i.isAdded())
        {
            ((WishListWithProductsFragment)i).a(m, a, k, j, p);
        } else
        if ((i instanceof ScannedItemFragment) && i.isAdded())
        {
            ((ScannedItemFragment)i).a(l);
            return;
        }
    }

    public void c()
    {
        if (o != null)
        {
            o.setVisibility(8);
        }
        nm.a(f, new no() {

            final jv a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jv.this;
                super();
            }
        }, new nn() {

            final jv a;

            public void a()
            {
                jv.a(0);
            }

            
            {
                a = jv.this;
                super();
            }
        }, e, n);
    }

    public void d()
    {
        n++;
        (new jv(f, i, a, j, k, l, o, p)).executeOnExecutor(nb.g, new Void[0]);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (o != null)
        {
            o.setVisibility(0);
            o.bringToFront();
        }
    }

}
