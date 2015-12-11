// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.app.SearchManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.s;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.p;
import com.wishabi.flipp.b.u;
import com.wishabi.flipp.content.FlyerActivityIntent;
import com.wishabi.flipp.content.c;
import com.wishabi.flipp.content.d;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.content.l;
import com.wishabi.flipp.content.o;
import com.wishabi.flipp.util.f;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.widget.PullableRecyclerView;
import com.wishabi.flipp.widget.SearchView;
import com.wishabi.flipp.widget.ZeroCaseView;
import com.wishabi.flipp.widget.an;
import com.wishabi.flipp.widget.cy;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.a.b;

// Referenced classes of package com.wishabi.flipp.app:
//            l, dr, x, m, 
//            y, FlippApplication, u, en, 
//            v, w, PrintCouponActivity, dn

public class CouponFragment extends Fragment
    implements android.app.ActionBar.OnNavigationListener, android.app.LoaderManager.LoaderCallbacks, b
{

    private static final String a = com/wishabi/flipp/app/CouponFragment.getSimpleName();
    private PullToRefreshLayout b;
    private RecyclerView c;
    private View d;
    private MenuItem e;
    private int f;
    private SharedPreferences g;
    private android.content.SharedPreferences.OnSharedPreferenceChangeListener h;
    private an i;
    private Cursor j;
    private HashMap k;
    private String l[];
    private String m;
    private dn n;

    public CouponFragment()
    {
    }

    static an a(CouponFragment couponfragment)
    {
        return couponfragment.i;
    }

    private void a(int i1)
    {
        f = i1;
        if (e == null)
        {
            return;
        }
        if (f == 0)
        {
            e.setTitle(0x7f0e0105);
            return;
        } else
        {
            e.setTitle(getResources().getQuantityString(0x7f0d0004, f, new Object[] {
                Integer.valueOf(f)
            }));
            return;
        }
    }

    static void a(CouponFragment couponfragment, int i1)
    {
        Activity activity = couponfragment.getActivity();
        c c1;
        if (activity != null && couponfragment.i != null && couponfragment.k != null)
        {
            if ((c1 = couponfragment.i.d(i1)) != null && ((couponfragment = (ArrayList)couponfragment.k.get(Integer.valueOf(c1.a))) != null && !couponfragment.isEmpty()))
            {
                activity.startActivity(new FlyerActivityIntent(activity, (o)couponfragment.get(0)));
                activity.overridePendingTransition(0x7f040001, 0x7f040002);
                return;
            }
        }
    }

    private void a(String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("category", s1);
        s1 = getLoaderManager();
        if (s1 != null)
        {
            s1.restartLoader(0, bundle, this);
        }
    }

    private void a(String as[])
    {
        int i1;
        i1 = 0;
        l = as;
        break MISSING_BLOCK_LABEL_7;
        if (!isHidden() && getActivity() != null)
        {
            as = getActivity().getActionBar();
            if (as != null)
            {
                getActivity().setTitle("");
                as.setNavigationMode(1);
                as.setListNavigationCallbacks(new com.wishabi.flipp.app.l(getActivity(), l), this);
                if (l == null || l.length == 0)
                {
                    as.setNavigationMode(0);
                    getActivity().setTitle(0x7f0e0086);
                    a("All Deals");
                    return;
                }
                int j1 = 0;
                for (; i1 < l.length; i1++)
                {
                    if (l[i1].equals(m))
                    {
                        j1 = i1;
                    }
                }

                as.setSelectedNavigationItem(j1);
                return;
            }
        }
        return;
    }

    static PullToRefreshLayout b(CouponFragment couponfragment)
    {
        return couponfragment.b;
    }

    private void b()
    {
        if (j == null || l == null)
        {
            return;
        }
        a.a.a("coupons");
        a a1 = a.a;
        int i1 = j.getCount();
        Object obj;
        HashMap hashmap;
        if (getActivity() == null)
        {
            obj = null;
        } else
        {
            obj = getActivity().getActionBar();
            if (obj == null)
            {
                obj = null;
            } else
            {
                int j1 = ((ActionBar) (obj)).getSelectedNavigationIndex();
                if (j1 < 0 || j1 >= l.length)
                {
                    obj = null;
                } else
                {
                    obj = l[j1];
                }
            }
        }
        hashmap = new HashMap();
        hashmap.put("count", Integer.toString(i1));
        hashmap.put("category", obj);
        a1.a("Coupons", hashmap);
        a1.a("coupon listing", String.format("%s | %s", new Object[] {
            "coupon listing", obj
        }), null, Long.valueOf(i1));
    }

    static void b(CouponFragment couponfragment, int i1)
    {
        if (couponfragment.i != null)
        {
            Object obj = couponfragment.i.d(i1);
            if (obj != null)
            {
                couponfragment = couponfragment.getActivity();
                i1 = ((c) (obj)).a;
                obj = p.d;
                com.wishabi.flipp.app.dr.a(couponfragment, new int[] {
                    i1
                }, true, ((p) (obj)));
            }
        }
    }

    private void c()
    {
        while (getActivity() == null || com.wishabi.flipp.util.k.a(null) == null) 
        {
            return;
        }
        b.setRefreshing(true);
        u.a.a(null, new x(this));
    }

    private void d()
    {
        Activity activity = getActivity();
        if (activity == null)
        {
            return;
        }
        if (j == null || k == null)
        {
            i = null;
            c.setAdapter(null);
            d.setVisibility(8);
            c.setVisibility(8);
            return;
        }
        if (j.getCount() == 0)
        {
            i = null;
            c.setAdapter(null);
            d.setVisibility(0);
            c.setVisibility(8);
            return;
        }
        Object obj2 = new d(j);
        Object obj1 = new ArrayList();
        Object obj = new ArrayList();
        j.moveToFirst();
        int i1 = 0;
        while (!j.isAfterLast()) 
        {
            c c1 = new c(j, ((d) (obj2)));
            ArrayList arraylist1 = (ArrayList)k.get(Integer.valueOf(c1.a));
            if (arraylist1 == null || arraylist1.isEmpty())
            {
                ((List) (obj)).add(new Pair(Integer.valueOf(i1), c1));
            } else
            if (((o)arraylist1.get(0)).b())
            {
                ((List) (obj1)).add(new Pair(Integer.valueOf(i1), c1));
            } else
            {
                ((List) (obj)).add(new Pair(Integer.valueOf(i1), c1));
            }
            j.moveToNext();
            i1++;
        }
        obj2 = new m(k);
        Collections.sort(((List) (obj1)), ((java.util.Comparator) (obj2)));
        Collections.sort(((List) (obj)), ((java.util.Comparator) (obj2)));
        obj2 = new ArrayList();
        ArrayList arraylist = new ArrayList();
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj2)).add(((Pair)((Iterator) (obj1)).next()).second)) { }
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((Pair)((Iterator) (obj)).next()).second)) { }
        i = new an(activity, ((List) (obj2)), arraylist, k, n);
        c.a(i);
        c.setVisibility(0);
        d.setVisibility(8);
        e();
    }

    private void e()
    {
        if (isResumed() && !isHidden() && i != null)
        {
            com.wishabi.flipp.app.FlippApplication.a(new y(this));
        }
    }

    public final void a()
    {
        c();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        g = com.wishabi.flipp.util.p.a();
        h = new com.wishabi.flipp.app.u(this);
        g.registerOnSharedPreferenceChangeListener(h);
        if (bundle != null)
        {
            m = bundle.getString("category");
        }
        a(0);
        bundle = getLoaderManager();
        if (bundle != null)
        {
            bundle.destroyLoader(3);
            bundle.destroyLoader(0);
            bundle.destroyLoader(2);
            bundle.destroyLoader(1);
        }
    }

    public Loader onCreateLoader(int i1, Bundle bundle)
    {
        Activity activity = getActivity();
        if (activity != null) goto _L2; else goto _L1
_L1:
        String s2;
        return null;
_L2:
        if (TextUtils.isEmpty(s2 = com.wishabi.flipp.util.k.a(null))) goto _L1; else goto _L3
_L3:
        switch (i1)
        {
        default:
            throw new InvalidParameterException((new StringBuilder("Invalid loader id ")).append(i1).toString());

        case 0: // '\0'
            bundle = bundle.getString("category");
            if (bundle != null)
            {
                return new CursorLoader(activity, i.q, new String[] {
                    "*", "clipped", "sent", "category"
                }, "category = ? AND postal_code = ? AND deleted = 0", new String[] {
                    bundle, s2
                }, "priority ASC, available_from DESC, _id DESC");
            }
            break;

        case 1: // '\001'
            bundle = bundle.getIntArray("coupon_ids");
            if (bundle != null)
            {
                return com.wishabi.flipp.content.l.a(activity, bundle, false, true);
            }
            break;

        case 2: // '\002'
            return new CursorLoader(activity, i.q, new String[] {
                "_id", "clipped", "sent"
            }, "clipped = 1 AND (sent = 0 OR sent IS NULL) AND deleted = 0", null, null);

        case 3: // '\003'
            bundle = com.wishabi.flipp.util.p.a().getString("coupon_category_order", null);
            String s1;
            String as[];
            String as1[];
            if (bundle != null)
            {
                bundle = bundle.split(",");
            } else
            {
                bundle = null;
            }
            if (bundle != null)
            {
                s1 = com.wishabi.flipp.util.f.a("category", bundle, true);
            } else
            {
                s1 = "category ASC";
            }
            as1 = new String[1];
            as1[0] = s2;
            as = as1;
            if (bundle != null)
            {
                as = (String[])com.wishabi.flipp.util.a.a(as1, bundle);
            }
            return new CursorLoader(activity, i.q, new String[] {
                "DISTINCT category", "deleted", "postal_code"
            }, "deleted = 0 AND postal_code = ?", as, s1);
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        Object obj = getActivity();
        if (obj != null)
        {
            menuinflater.inflate(0x7f100001, menu);
            menuinflater = menu.findItem(0x7f0b0155);
            if (menuinflater != null)
            {
                menuinflater = (SearchView)menuinflater.getActionView();
                if (menuinflater != null)
                {
                    menuinflater.setSearchableInfo(((SearchManager)((Activity) (obj)).getSystemService("search")).getSearchableInfo(((Activity) (obj)).getComponentName()));
                    menuinflater.setIconifiedByDefault(true);
                    menuinflater.setClearAfterQuery(true);
                    menuinflater.setQueryHint(((Activity) (obj)).getString(0x7f0e011f));
                    obj = new Bundle();
                    ((Bundle) (obj)).putInt("search_mode", com.wishabi.flipp.app.en.c - 1);
                    menuinflater.setSearchExtraData("com.wishabi.flipp.search_bundle", ((Bundle) (obj)));
                    e = menu.findItem(0x7f0b0156);
                    a(f);
                    return;
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        bundle = getActivity();
        if (bundle == null)
        {
            return null;
        }
        setHasOptionsMenu(true);
        layoutinflater = layoutinflater.inflate(0x7f03001e, viewgroup, false);
        b = (PullToRefreshLayout)layoutinflater.findViewById(0x7f0b0095);
        c = (RecyclerView)layoutinflater.findViewById(0x7f0b0097);
        d = layoutinflater.findViewById(0x7f0b0096);
        viewgroup = uk.co.senab.actionbarpulltorefresh.library.a.a(bundle).a(new View[] {
            c, d
        });
        bundle = new cy();
        if (((uk.co.senab.actionbarpulltorefresh.library.b) (viewgroup)).c == null)
        {
            viewgroup.c = new HashMap();
        }
        ((uk.co.senab.actionbarpulltorefresh.library.b) (viewgroup)).c.put(com/wishabi/flipp/widget/PullableRecyclerView, bundle);
        viewgroup.b = this;
        viewgroup.a(b);
        n = new v(this);
        int j1 = Math.max(com.wishabi.flipp.util.i.a() / 180, 2);
        int i1;
        int k1;
        if (j1 % 2 == 1)
        {
            i1 = j1 - 1;
        } else
        {
            i1 = j1;
        }
        i1 /= 2;
        if (j1 == 3)
        {
            i1 = 2;
        }
        k1 = j1 * i1;
        i1 = k1 / i1;
        j1 = k1 / j1;
        viewgroup = new s(k1);
        viewgroup.g = new w(this, k1, i1, j1);
        c.setLayoutManager(viewgroup);
        viewgroup = (ZeroCaseView)layoutinflater.findViewById(0x7f0b003e);
        viewgroup.setIcon(0x7f0200d6);
        viewgroup.setTitle(0x7f0e00e8);
        viewgroup.setSubTitle(0x7f0e00e9);
        viewgroup = getLoaderManager();
        if (viewgroup != null)
        {
            viewgroup.initLoader(2, null, this);
            viewgroup.initLoader(3, null, this);
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (h != null)
        {
            g.unregisterOnSharedPreferenceChangeListener(h);
            h = null;
            g = null;
        }
    }

    public void onHiddenChanged(boolean flag)
    {
        super.onHiddenChanged(flag);
        while (getActivity() == null || getActivity().getActionBar() == null) 
        {
            return;
        }
        if (!flag)
        {
            a(l);
            b();
        }
        e();
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        Object obj1;
        int i1;
        boolean flag;
        i1 = 0;
        flag = false;
        obj1 = (Cursor)obj;
        (new StringBuilder("Finished loading ")).append(loader.getId());
        obj = getLoaderManager();
        loader.getId();
        JVM INSTR tableswitch 0 3: default 68
    //                   0 69
    //                   1 127
    //                   2 140
    //                   3 179;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        if (j != obj1)
        {
            j = ((Cursor) (obj1));
            if (obj1 != null)
            {
                loader = com.wishabi.flipp.util.f.a(((Cursor) (obj1)), "_id");
                obj1 = new Bundle();
                ((Bundle) (obj1)).putIntArray("coupon_ids", loader);
                ((LoaderManager) (obj)).restartLoader(1, ((Bundle) (obj1)), this);
            }
            d();
            b();
            return;
        }
          goto _L1
_L3:
        k = com.wishabi.flipp.content.l.b(((Cursor) (obj1)));
        d();
        return;
_L4:
        i1 = ((flag) ? 1 : 0);
        if (obj1 != null)
        {
            if (((Cursor) (obj1)).getCount() == 0)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = ((Cursor) (obj1)).getCount();
            }
        }
        a(i1);
        return;
_L5:
        int j1 = ((Cursor) (obj1)).getColumnIndexOrThrow("category");
        loader = new String[((Cursor) (obj1)).getCount()];
        ((Cursor) (obj1)).moveToFirst();
        for (; i1 < ((Cursor) (obj1)).getCount(); i1++)
        {
            loader[i1] = ((Cursor) (obj1)).getString(j1);
            ((Cursor) (obj1)).moveToNext();
        }

        a(loader);
        return;
    }

    public void onLoaderReset(Loader loader)
    {
        switch (loader.getId())
        {
        default:
            return;

        case 0: // '\0'
            j = null;
            d();
            return;

        case 1: // '\001'
            k = null;
            d();
            return;

        case 2: // '\002'
            a(0);
            return;

        case 3: // '\003'
            a(((String []) (null)));
            break;
        }
    }

    public boolean onNavigationItemSelected(int i1, long l1)
    {
        while (l == null || i1 >= l.length) 
        {
            return true;
        }
        m = l[i1];
        a(m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (getActivity() == null)
        {
            return super.onOptionsItemSelected(menuitem);
        }
        if (menuitem.getItemId() == 0x7f0b0157)
        {
            c();
            return true;
        }
        if (menuitem.getItemId() == 0x7f0b0156)
        {
            startActivity(com.wishabi.flipp.app.PrintCouponActivity.a());
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (!isHidden())
        {
            b();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("category", m);
    }

}
