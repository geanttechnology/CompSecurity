// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.app.SearchManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.u;
import com.wishabi.flipp.content.h;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.p;
import com.wishabi.flipp.widget.CollectionView;
import com.wishabi.flipp.widget.SearchView;
import com.wishabi.flipp.widget.ZeroCaseView;
import com.wishabi.flipp.widget.ax;
import com.wishabi.flipp.widget.ba;
import com.wishabi.flipp.widget.bc;
import com.wishabi.flipp.widget.bw;
import com.wishabi.flipp.widget.ca;
import com.wishabi.flipp.widget.cb;
import com.wishabi.flipp.widget.cz;
import com.wishabi.flipp.widget.eg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.a.b;

// Referenced classes of package com.wishabi.flipp.app:
//            av, au, as, en, 
//            ao, ap, aq, ar, 
//            at

public class FeaturedFragment extends Fragment
    implements android.app.LoaderManager.LoaderCallbacks, b
{

    private static final HashMap l = new HashMap();
    private static final HashSet m = new HashSet();
    String a;
    CollectionView b;
    private SharedPreferences c;
    private android.content.SharedPreferences.OnSharedPreferenceChangeListener d;
    private View e;
    private PullToRefreshLayout f;
    private final SparseBooleanArray g = new SparseBooleanArray();
    private bw h;
    private bc i;
    private cb j;
    private final List k = new ArrayList();

    public FeaturedFragment()
    {
        a = "All Flyers";
    }

    static bw a(FeaturedFragment featuredfragment)
    {
        return featuredfragment.h;
    }

    static String a(cb cb1)
    {
        return b(cb1);
    }

    static void a(FeaturedFragment featuredfragment, cb cb1)
    {
        featuredfragment.j = cb1;
    }

    private void a(List list, int i1)
    {
        if (l.isEmpty())
        {
            k.clear();
        }
        Object obj = (Long)l.get(Integer.valueOf(i1));
        h h1;
        if (obj != null)
        {
            obj = com.wishabi.flipp.content.h.a(list, ((Long) (obj)).longValue());
        } else
        {
            obj = null;
        }
        h1 = ((h) (obj));
        if (obj == null)
        {
            h1 = com.wishabi.flipp.content.h.a(list);
        }
        if (h1 != null)
        {
            k.add(h1);
            l.put(Integer.valueOf(h1.b), Long.valueOf(h1.a));
        }
    }

    static String b(FeaturedFragment featuredfragment)
    {
        return featuredfragment.a;
    }

    private static String b(cb cb1)
    {
        switch (com.wishabi.flipp.app.av.b[cb1.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return "Featured";

        case 2: // '\002'
            return "Alphabetical";

        case 3: // '\003'
            return "Latest";
        }
    }

    public static void b()
    {
        l.clear();
        m.clear();
    }

    static cb c(FeaturedFragment featuredfragment)
    {
        return featuredfragment.j;
    }

    private void c()
    {
        a.a.a("featured");
        if (b != null && b.getAdapter() != null)
        {
            a a1 = a.a;
            StringBuilder stringbuilder = new StringBuilder("featured-");
            String s;
            if (a == null)
            {
                s = "All Flyers";
            } else
            {
                s = a;
            }
            a1.a(stringbuilder.append(s).toString(), b(j), ((cz) ((bw)b.getAdapter())).d);
            return;
        }
        a a2 = a.a;
        StringBuilder stringbuilder1 = new StringBuilder("featured-");
        String s1;
        if (a == null)
        {
            s1 = "All Flyers";
        } else
        {
            s1 = a;
        }
        a2.b(stringbuilder1.append(s1).toString());
    }

    private void d()
    {
        while (getActivity() == null || com.wishabi.flipp.util.k.a(null) == null) 
        {
            return;
        }
        f.setRefreshing(true);
        u.a.a(null, new au(this));
    }

    static void d(FeaturedFragment featuredfragment)
    {
        if (featuredfragment.isResumed())
        {
            SparseArray sparsearray = featuredfragment.b.getActiveViews();
            int j1 = sparsearray.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                int k1 = sparsearray.keyAt(i1);
                if (featuredfragment.h.e(k1) != ca.b)
                {
                    continue;
                }
                ba ba1 = (ba)sparsearray.get(k1);
                Object obj = (Cursor)featuredfragment.h.getItem(k1);
                if (obj == null)
                {
                    continue;
                }
                k1 = ((Cursor) (obj)).getColumnIndex("flyer_id");
                if (k1 < 0)
                {
                    continue;
                }
                k1 = ((Cursor) (obj)).getInt(k1);
                if (!m.contains(Integer.valueOf(k1)) && ba1.getPercentVisibility() > 50F)
                {
                    m.add(Integer.valueOf(k1));
                    obj = new com.wishabi.flipp.content.Flyer.Model(((Cursor) (obj)));
                    a.a.a(((com.wishabi.flipp.content.Flyer.Model) (obj)), "All Flyers".toLowerCase(Locale.US), ba1.getFeaturedItem());
                }
            }

        }
    }

    static CollectionView e(FeaturedFragment featuredfragment)
    {
        return featuredfragment.b;
    }

    static PullToRefreshLayout f(FeaturedFragment featuredfragment)
    {
        return featuredfragment.f;
    }

    public final void a()
    {
        d();
    }

    public void onCreate(Bundle bundle)
    {
        cb cb1;
        super.onCreate(bundle);
        if (getActivity() == null)
        {
            return;
        }
        c = p.a();
        d = new as(this);
        c.registerOnSharedPreferenceChangeListener(d);
        cb1 = cb.a;
        if (bundle != null) goto _L2; else goto _L1
_L1:
        b();
        bundle = cb1;
_L4:
        j = bundle;
        return;
_L2:
        int i1 = bundle.getInt("SAVE_STATE_SORT_MODE_KEY", -1);
        bundle = cb1;
        if (i1 != -1)
        {
            bundle = cb.values()[i1];
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Loader onCreateLoader(int i1, Bundle bundle)
    {
        bundle = getActivity();
        if (bundle == null)
        {
            return null;
        }
        switch (i1)
        {
        default:
            return null;

        case 1: // '\001'
            return new CursorLoader(bundle, i.h, null, null, null, null);

        case 0: // '\0'
            String s = com.wishabi.flipp.util.k.a(null);
            if (s == null)
            {
                return null;
            }
            String s1 = bw.a(j);
            if (a == null)
            {
                return new CursorLoader(bundle, i.a, null, "postal_code = ?", new String[] {
                    s
                }, null);
            } else
            {
                android.net.Uri.Builder builder = i.a.buildUpon();
                builder.appendQueryParameter("filter_field", "categories");
                builder.appendQueryParameter("filter_values", a);
                return new CursorLoader(bundle, builder.build(), null, "postal_code = ?", new String[] {
                    s
                }, s1);
            }

        case 2: // '\002'
            return new CursorLoader(bundle, i.e, null, null, null, "flyer_id ASC");
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        Activity activity = getActivity();
        if (activity != null)
        {
            menuinflater.inflate(0x7f100005, menu);
            menu = menu.findItem(0x7f0b0155);
            if (menu != null)
            {
                menu = (SearchView)menu.getActionView();
                if (menu != null)
                {
                    menu.setSearchableInfo(((SearchManager)activity.getSystemService("search")).getSearchableInfo(activity.getComponentName()));
                    menu.setIconifiedByDefault(true);
                    menu.setClearAfterQuery(true);
                    menuinflater = new Bundle();
                    menuinflater.putInt("search_mode", com.wishabi.flipp.app.en.a - 1);
                    menu.setSearchExtraData("com.wishabi.flipp.search_bundle", menuinflater);
                    return;
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        setHasOptionsMenu(true);
        layoutinflater = layoutinflater.inflate(0x7f030025, viewgroup, false);
        if (layoutinflater == null)
        {
            return null;
        }
        f = (PullToRefreshLayout)layoutinflater.findViewById(0x7f0b0095);
        viewgroup = (ZeroCaseView)layoutinflater.findViewById(0x7f0b003e);
        viewgroup.setTitle(0x7f0e00ed);
        viewgroup.setSubTitle(0x7f0e00ee);
        viewgroup.setIcon(0x7f0200d6);
        e = layoutinflater.findViewById(0x7f0b0096);
        b = (CollectionView)layoutinflater.findViewById(0x7f0b003f);
        if (b == null)
        {
            return layoutinflater;
        }
        viewgroup = uk.co.senab.actionbarpulltorefresh.library.a.a(getActivity()).a(new View[] {
            b, e
        });
        viewgroup.b = this;
        viewgroup.a(f);
        viewgroup = new eg(getActivity());
        viewgroup.b = new ax(getActivity(), b);
        b.setLayout(viewgroup);
        b.setOnItemClickListener(new ao(this));
        b.setOnScrollListener(new ap(this));
        b.addOnLayoutChangeListener(new aq(this));
        i = new ar(this);
        if (bundle != null)
        {
            a = bundle.getString("mCategory");
        }
        viewgroup = getLoaderManager();
        if (viewgroup != null)
        {
            viewgroup.initLoader(0, null, this);
            viewgroup.initLoader(1, null, this);
            viewgroup.initLoader(2, null, this);
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (d != null)
        {
            c.unregisterOnSharedPreferenceChangeListener(d);
            d = null;
            c = null;
        }
    }

    public void onHiddenChanged(boolean flag)
    {
        super.onHiddenChanged(flag);
        if (!flag)
        {
            c();
        }
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        obj = (Cursor)obj;
        loader.getId();
        JVM INSTR tableswitch 0 2: default 36
    //                   0 99
    //                   1 37
    //                   2 245;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L3:
        for (boolean flag = ((Cursor) (obj)).moveToFirst(); flag; flag = ((Cursor) (obj)).moveToNext())
        {
            g.put(((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("_id")), true);
        }

        if (h != null)
        {
            h.notifyDataSetChanged();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!isHidden())
        {
            a a1 = a.a;
            StringBuilder stringbuilder = new StringBuilder("featured-");
            if (a == null)
            {
                loader = "All Flyers";
            } else
            {
                loader = a;
            }
            a1.a(stringbuilder.append(loader).toString(), b(j), ((Cursor) (obj)));
        }
        b.setEmptyView(e);
        if (obj != null)
        {
            h = new bw(getActivity(), ((Cursor) (obj)), g, k, j, true, new at(this), i);
            b.setAdapter(h);
            loader = getLoaderManager();
            if (loader != null)
            {
                loader.initLoader(2, null, this);
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
        loader = new ArrayList();
        boolean flag1 = ((Cursor) (obj)).moveToFirst();
        int i1;
        int j1;
        for (i1 = -1; flag1; i1 = j1)
        {
            h h1 = new h(((Cursor) (obj)));
            j1 = i1;
            if (i1 != h1.b)
            {
                a(loader, i1);
                loader.clear();
                j1 = h1.b;
            }
            loader.add(h1);
            flag1 = ((Cursor) (obj)).moveToNext();
        }

        a(loader, i1);
        if (h != null)
        {
            h.notifyDataSetChanged();
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void onLoaderReset(Loader loader)
    {
        switch (loader.getId())
        {
        default:
            return;

        case 1: // '\001'
            g.clear();
            return;

        case 0: // '\0'
            h = null;
            b.setAdapter(null);
            return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (getActivity() == null)
        {
            return super.onOptionsItemSelected(menuitem);
        }
        if (menuitem.getItemId() == 0x7f0b0157)
        {
            d();
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
            c();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("mCategory", a);
        bundle.putInt("SAVE_STATE_SORT_MODE_KEY", j.ordinal());
    }

}
