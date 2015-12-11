// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.home.TrendingHomeCardFragment;
import com.bestbuy.android.api.lib.models.home.Recommendation;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class hn extends ka
{

    private static int j = 0;
    private ArrayList a;
    private Recommendation k;

    public hn(Activity activity, BBYBaseFragment bbybasefragment, View view)
    {
        super(activity, bbybasefragment, view);
    }

    public hn(Activity activity, BBYBaseFragment bbybasefragment, View view, Recommendation recommendation)
    {
        super(activity, bbybasefragment, view);
        k = recommendation;
    }

    public void a()
    {
        a = fs.a(k);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (a == null || a.isEmpty())
        {
            c();
        } else
        {
            j = 0;
            if ((i instanceof TrendingHomeCardFragment) && i.isAdded())
            {
                ((TrendingHomeCardFragment)i).a(a);
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
        if ((i instanceof TrendingHomeCardFragment) && i.isAdded())
        {
            ((TrendingHomeCardFragment)i).b();
        }
    }

    public void d()
    {
        j++;
        (new hn(f, i, g)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void e()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
        a = new ArrayList();
    }

}
