// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.registry.BuyerRegistryAndWishListFragment;
import com.bestbuy.android.activities.registry.WishListWithProductsFragment;
import com.bestbuy.android.api.lib.models.registry.Entities;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class jn extends ka
{

    private static int k = 0;
    private ArrayList a;
    private ArrayList j;
    private boolean l;
    private ArrayList m;
    private ArrayList n;
    private ArrayList o;

    public jn(Activity activity, BBYBaseFragment bbybasefragment, View view, ArrayList arraylist, boolean flag)
    {
        super(activity, bbybasefragment);
        a = new ArrayList();
        j = new ArrayList();
        m = new ArrayList();
        n = new ArrayList();
        o = new ArrayList();
        g = view;
        l = flag;
        m = arraylist;
    }

    static int a(int i)
    {
        k = i;
        return i;
    }

    public void a()
    {
        boolean flag = false;
        HashMap hashmap = new HashMap();
        for (int i = 0; i < m.size(); i++)
        {
            hashmap.put(((Entities)m.get(i)).getSku(), m.get(i));
            a.add(((Entities)m.get(i)).getSku());
        }

        j = fs.a(a);
        ArrayList arraylist = new ArrayList();
        if (j != null && !j.isEmpty())
        {
            HashMap hashmap1 = new HashMap();
            BBYProduct bbyproduct;
            for (Iterator iterator = j.iterator(); iterator.hasNext(); hashmap1.put(bbyproduct.getSkuId(), bbyproduct))
            {
                bbyproduct = (BBYProduct)iterator.next();
            }

            if (m.size() > j.size())
            {
                for (Iterator iterator1 = m.iterator(); iterator1.hasNext();)
                {
                    Entities entities = (Entities)iterator1.next();
                    if (!hashmap1.containsKey(entities.getSku()))
                    {
                        hashmap.remove(entities.getSku());
                    } else
                    {
                        arraylist.add(entities);
                    }
                }

                m.clear();
                m.addAll(arraylist);
            }
        } else
        {
            m.clear();
        }
        if ((this.i instanceof BuyerRegistryAndWishListFragment) && m != null)
        {
            int i1 = ((flag) ? 1 : 0);
            while (i1 < m.size()) 
            {
                if (((Entities)m.get(i1)).isFavorite())
                {
                    n.add(m.get(i1));
                } else
                {
                    o.add(m.get(i1));
                }
                i1++;
            }
            m.clear();
            m.addAll(n);
            m.addAll(o);
        }
    }

    public void b()
    {
        k = 0;
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (j != null)
        {
            if ((i instanceof WishListWithProductsFragment) && i.isAdded())
            {
                ((WishListWithProductsFragment)i).a(j, m, l);
            }
            if ((i instanceof BuyerRegistryAndWishListFragment) && i.isAdded())
            {
                ((BuyerRegistryAndWishListFragment)i).a(j, m, l);
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

            final jn a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jn.this;
                super();
            }
        }, new nn() {

            final jn a;

            public void a()
            {
                jn.a(0);
            }

            
            {
                a = jn.this;
                super();
            }
        }, e, k);
    }

    public void d()
    {
        k++;
        (new jn(f, i, g, m, l)).executeOnExecutor(nb.h, new Void[0]);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

}
