// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.widget.ProgressBar;
import com.bestbuy.android.activities.registry.WishListWithProductsFragment;
import com.bestbuy.android.base.BBYBaseFragment;

public class jw extends ka
{

    private static int m = 0;
    private String a;
    private String j;
    private String k;
    private int l;
    private boolean n;
    private ProgressBar o;
    private mp p;

    public jw(Activity activity, BBYBaseFragment bbybasefragment, String s, String s1, String s2, int i, ProgressBar progressbar, 
            mp mp)
    {
        super(activity, bbybasefragment);
        a = s;
        j = s1;
        k = s2;
        l = i;
        o = progressbar;
        p = mp;
    }

    static int a(int i)
    {
        m = i;
        return i;
    }

    public void a()
    {
        n = fs.a(fr.d(), a, j, k, l, fr.b());
    }

    public void b()
    {
        m = 0;
        if (o != null)
        {
            o.setVisibility(8);
        }
        if ((i instanceof WishListWithProductsFragment) && i.isAdded())
        {
            ((WishListWithProductsFragment)i).a(n, a, k, j, l, p);
        }
    }

    public void c()
    {
        if (o != null)
        {
            o.setVisibility(8);
        }
        nm.a(f, new no() {

            final jw a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jw.this;
                super();
            }
        }, new nn() {

            final jw a;

            public void a()
            {
                jw.a(0);
            }

            
            {
                a = jw.this;
                super();
            }
        }, e, m);
    }

    public void d()
    {
        m++;
        (new jw(f, i, a, j, k, l, o, p)).executeOnExecutor(nb.g, new Void[0]);
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
