// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.home.DODHomeCard;
import com.bestbuy.android.api.lib.models.remix.StoreList;
import com.bestbuy.android.api.lib.models.search.SearchApi;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class hf extends ka
{

    private static int o = 0;
    private SearchApi a;
    private String j;
    private String k;
    private int l;
    private int m;
    private boolean n;
    private nb p;
    private boolean q;
    private BBYStore r;

    public hf(Activity activity, BBYBaseFragment bbybasefragment, String s, String s1, int i, int i1, boolean flag, 
            View view, boolean flag1)
    {
        super(activity, bbybasefragment, view);
        a = new SearchApi();
        j = s;
        k = s1;
        l = i;
        m = i1;
        n = flag;
        q = flag1;
    }

    public hf(Activity activity, BBYBaseFragment bbybasefragment, String s, String s1, int i, int i1, boolean flag, 
            View view, boolean flag1, BBYStore bbystore)
    {
        super(activity, bbybasefragment, view);
        a = new SearchApi();
        j = s;
        k = s1;
        l = i;
        m = i1;
        n = flag;
        q = flag1;
        r = bbystore;
    }

    private BBYStore f()
    {
        Object obj = fs.a(i.getActivity(), p.y(), p.z(), null, 1, 1).getStores();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (((ArrayList) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_58;
        }
        obj = (BBYStore)((ArrayList) (obj)).get(0);
        return ((BBYStore) (obj));
        Exception exception;
        exception;
        exception.printStackTrace();
        return null;
    }

    public void a()
    {
        BBYStore bbystore = null;
        Object obj = null;
        p = nb.a();
        if (q)
        {
            bbystore = obj;
            if (!String.valueOf(p.y()).equalsIgnoreCase("0.0"))
            {
                bbystore = obj;
                if (!String.valueOf(p.z()).equalsIgnoreCase("0.0"))
                {
                    if (r != null)
                    {
                        bbystore = r;
                    } else
                    {
                        bbystore = f();
                    }
                }
            }
            j = (new StringBuilder()).append(j).append("&facetsOnly=false&storeId=").append(bbystore.getStoreId()).toString();
        }
        a = fs.b(j, k, m);
        a.setStoreDetails(bbystore);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (a == null)
        {
            c();
        } else
        {
            o = 0;
            if ((i instanceof PLPFragment) && i.isAdded())
            {
                ((PLPFragment)i).a(a, false);
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
        if ((i instanceof DODHomeCard) && i.isAdded())
        {
            ((DODHomeCard)i).b();
        }
    }

    public void e()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
