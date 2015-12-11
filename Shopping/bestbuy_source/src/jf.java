// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.registry.MyWishListsFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class jf extends ka
{

    private static int j = 0;
    private ArrayList a;

    public jf(Activity activity, BBYBaseFragment bbybasefragment, View view)
    {
        super(activity, bbybasefragment);
        g = view;
    }

    static int a(int i)
    {
        j = i;
        return i;
    }

    static BBYBaseFragment a(jf jf1)
    {
        return jf1.i;
    }

    static Activity b(jf jf1)
    {
        return jf1.f;
    }

    public void a()
    {
        a = fs.e(fr.d(), fr.b());
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if ((i instanceof MyWishListsFragment) && i.isAdded())
        {
            ((MyWishListsFragment)i).a(a);
        }
        if ((i instanceof PDPFragment) && i.isAdded())
        {
            ((PDPFragment)i).a(a);
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final jf a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jf.this;
                super();
            }
        }, new nn() {

            final jf a;

            public void a()
            {
                jf.a(0);
                if (!(jf.a(a) instanceof PDPFragment))
                {
                    ((HomeActivity)jf.b(a)).onBackPressed();
                }
            }

            
            {
                a = jf.this;
                super();
            }
        }, e, j);
    }

    public void d()
    {
        j++;
        (new jf(f, i, g)).executeOnExecutor(nb.g, new Void[0]);
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
