// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.AddItemsToPLPFragment;
import com.bestbuy.android.activities.registry.MyEmptyWeddingRegistryList;
import com.bestbuy.android.activities.registry.MyEmptyWishListFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class ji extends ka
{

    private ArrayList a;

    public ji(Activity activity, BBYBaseFragment bbybasefragment, View view)
    {
        super(activity, bbybasefragment);
        g = view;
    }

    public void a()
    {
        a = fs.e();
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if ((i instanceof MyEmptyWishListFragment) && i.isAdded())
        {
            ((MyEmptyWishListFragment)i).a(a);
        } else
        {
            if ((i instanceof MyEmptyWeddingRegistryList) && i.isAdded())
            {
                ((MyEmptyWeddingRegistryList)i).a(a);
                return;
            }
            if ((i instanceof AddItemsToPLPFragment) && i.isAdded())
            {
                ((AddItemsToPLPFragment)i).a(a);
                return;
            }
        }
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
