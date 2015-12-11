// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.stores.StoreDetailsFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class ih extends ka
{

    private static int a = 0;
    private ArrayList j;
    private ArrayList k;

    public ih(Activity activity, BBYBaseFragment bbybasefragment, View view, ArrayList arraylist)
    {
        super(activity, bbybasefragment);
        g = view;
        j = arraylist;
    }

    public void a()
    {
        k = fs.a(j);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (k != null && !k.isEmpty())
        {
            a = 0;
            if ((i instanceof StoreDetailsFragment) && i.isAdded())
            {
                ((StoreDetailsFragment)i).a(k);
            }
            return;
        } else
        {
            c();
            return;
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if ((i instanceof StoreDetailsFragment) && i.isAdded())
        {
            ((StoreDetailsFragment)i).b();
        }
    }

    public void d()
    {
        a++;
        (new ih(f, i, g, j)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void e()
    {
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
