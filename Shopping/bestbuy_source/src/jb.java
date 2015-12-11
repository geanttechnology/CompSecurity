// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.widget.ProgressBar;
import com.bestbuy.android.activities.registry.ScannedItemFragment;
import com.bestbuy.android.activities.registry.WishListWithProductsFragment;
import com.bestbuy.android.base.BBYBaseFragment;

public class jb extends ka
{

    private static int m = 0;
    private String a;
    private String j;
    private String k;
    private boolean l;
    private ProgressBar n;

    public jb(Activity activity, BBYBaseFragment bbybasefragment, String s, String s1, String s2)
    {
        super(activity, bbybasefragment);
        a = s;
        j = s1;
        k = s2;
    }

    public jb(Activity activity, BBYBaseFragment bbybasefragment, String s, String s1, String s2, ProgressBar progressbar)
    {
        super(activity, bbybasefragment);
        f = activity;
        i = bbybasefragment;
        a = s;
        j = s1;
        k = s2;
        n = progressbar;
    }

    static int a(int i)
    {
        m = i;
        return i;
    }

    public void a()
    {
        l = fs.a(fr.d(), a, j, k, fr.b());
    }

    public void b()
    {
        if (n != null)
        {
            n.setVisibility(8);
        }
        m = 0;
        if ((i instanceof WishListWithProductsFragment) && i.isAdded())
        {
            ((WishListWithProductsFragment)i).a(l, j, a, k);
            ((WishListWithProductsFragment)i).a(true);
        } else
        if ((i instanceof ScannedItemFragment) && i.isAdded())
        {
            ((ScannedItemFragment)i).c();
            return;
        }
    }

    public void c()
    {
        if (n != null)
        {
            n.setVisibility(8);
        }
        nm.a(f, new no() {

            final jb a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jb.this;
                super();
            }
        }, new nn() {

            final jb a;

            public void a()
            {
                jb.a(0);
            }

            
            {
                a = jb.this;
                super();
            }
        }, e, m);
    }

    public void d()
    {
        m++;
        (new jb(f, i, a, j, k)).executeOnExecutor(nb.g, new Void[0]);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (n != null)
        {
            n.setVisibility(0);
            n.bringToFront();
        }
    }

}
