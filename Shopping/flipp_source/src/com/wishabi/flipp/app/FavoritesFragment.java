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
//            an, ah, en, ai, 
//            aj, ak, al, am

public class FavoritesFragment extends Fragment
    implements android.app.LoaderManager.LoaderCallbacks, b
{

    private static final HashMap m = new HashMap();
    private static final HashSet n = new HashSet();
    private int a;
    private CollectionView b;
    private View c;
    private ZeroCaseView d;
    private PullToRefreshLayout e;
    private final SparseBooleanArray f = new SparseBooleanArray();
    private bw g;
    private bc h;
    private Cursor i;
    private SharedPreferences j;
    private android.content.SharedPreferences.OnSharedPreferenceChangeListener k;
    private final List l = new ArrayList();

    public FavoritesFragment()
    {
    }

    static CollectionView a(FavoritesFragment favoritesfragment)
    {
        return favoritesfragment.b;
    }

    private void a(List list, int i1)
    {
        if (m.isEmpty())
        {
            l.clear();
        }
        Object obj = (Long)m.get(Integer.valueOf(i1));
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
            l.add(h1);
            m.put(Integer.valueOf(h1.b), Long.valueOf(h1.a));
        }
    }

    public static void b()
    {
        m.clear();
        n.clear();
    }

    static void b(FavoritesFragment favoritesfragment)
    {
        if (favoritesfragment.isResumed())
        {
            SparseArray sparsearray = favoritesfragment.b.getActiveViews();
            int j1 = sparsearray.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                int k1 = sparsearray.keyAt(i1);
                if (favoritesfragment.g.e(k1) != ca.b)
                {
                    continue;
                }
                ba ba1 = (ba)sparsearray.get(k1);
                Object obj = (Cursor)favoritesfragment.g.getItem(k1);
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
                if (!n.contains(Integer.valueOf(k1)) && ba1.getPercentVisibility() > 50F)
                {
                    n.add(Integer.valueOf(k1));
                    obj = new com.wishabi.flipp.content.Flyer.Model(((Cursor) (obj)));
                    a.a.a(((com.wishabi.flipp.content.Flyer.Model) (obj)), "Favorites".toLowerCase(Locale.US), ba1.getFeaturedItem());
                }
            }

        }
    }

    static bw c(FavoritesFragment favoritesfragment)
    {
        return favoritesfragment.g;
    }

    private void c()
    {
        a.a.a("favorites");
        if (b != null && b.getAdapter() != null)
        {
            a.a.a("favorites", null, ((cz) ((bw)b.getAdapter())).d);
            return;
        } else
        {
            a.a.b("favorites");
            return;
        }
    }

    static int d(FavoritesFragment favoritesfragment)
    {
        return favoritesfragment.a;
    }

    private void d()
    {
        while (getActivity() == null || com.wishabi.flipp.util.k.a(null) == null) 
        {
            return;
        }
        e.setRefreshing(true);
        u.a.a(null, new an(this));
    }

    static PullToRefreshLayout e(FavoritesFragment favoritesfragment)
    {
        return favoritesfragment.e;
    }

    public final void a()
    {
        d();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Activity activity = getActivity();
        if (activity != null)
        {
            j = activity.getSharedPreferences("com.wishabi.flipp.preferences", 0);
            k = new ah(this, activity);
            j.registerOnSharedPreferenceChangeListener(k);
            if (bundle == null)
            {
                b();
                return;
            }
        }
    }

    public Loader onCreateLoader(int i1, Bundle bundle)
    {
        Activity activity = getActivity();
        if (activity == null)
        {
            return null;
        }
        switch (i1)
        {
        default:
            return null;

        case 0: // '\0'
            return new CursorLoader(activity, i.f, null, null, null, null);

        case 1: // '\001'
            return new CursorLoader(activity, i.a, null, bundle.getString("merchant_clause"), bundle.getStringArray("merchant_args"), null);

        case 2: // '\002'
            return new CursorLoader(activity, i.h, null, null, null, null);

        case 3: // '\003'
            return new CursorLoader(activity, i.e, null, null, null, "flyer_id ASC");
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        Activity activity = getActivity();
        if (activity != null)
        {
            menuinflater.inflate(0x7f100004, menu);
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
        layoutinflater = layoutinflater.inflate(0x7f030024, viewgroup, false);
        if (layoutinflater == null)
        {
            return null;
        }
        d = (ZeroCaseView)layoutinflater.findViewById(0x7f0b003e);
        c = layoutinflater.findViewById(0x7f0b0096);
        b = (CollectionView)layoutinflater.findViewById(0x7f0b003f);
        if (b == null)
        {
            return layoutinflater;
        }
        e = (PullToRefreshLayout)layoutinflater.findViewById(0x7f0b0095);
        viewgroup = uk.co.senab.actionbarpulltorefresh.library.a.a(getActivity()).a(new View[] {
            b, c
        });
        viewgroup.b = this;
        viewgroup.a(e);
        viewgroup = new eg(getActivity());
        viewgroup.b = new ax(getActivity(), b);
        b.setLayout(viewgroup);
        b.setOnItemClickListener(new ai(this));
        b.setOnScrollListener(new aj(this));
        b.addOnLayoutChangeListener(new ak(this));
        h = new al(this);
        viewgroup = getLoaderManager();
        if (viewgroup != null)
        {
            viewgroup.initLoader(0, null, this);
            viewgroup.initLoader(2, null, this);
            viewgroup.initLoader(3, null, this);
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (k != null)
        {
            j.unregisterOnSharedPreferenceChangeListener(k);
            k = null;
            j = null;
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
        JVM INSTR tableswitch 0 3: default 40
    //                   0 41
    //                   1 288
    //                   2 411
    //                   3 473;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        if (i == obj) goto _L1; else goto _L6
_L6:
        i = ((Cursor) (obj));
        loader = getLoaderManager();
        if (loader == null || obj == null) goto _L1; else goto _L7
_L7:
        String as[];
        int i1;
        as = new String[((Cursor) (obj)).getCount()];
        i1 = 0;
        if (!((Cursor) (obj)).moveToFirst()) goto _L9; else goto _L8
_L8:
        as[i1] = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("_id"));
        if (((Cursor) (obj)).moveToNext())
        {
            break MISSING_BLOCK_LABEL_583;
        }
_L9:
        if (as.length == 0)
        {
            d.setIcon(0x7f0200d5);
            d.setTitle(0x7f0e00ea);
            d.setSubTitle(0x7f0e00eb);
            b.setEmptyView(c);
            b.setAdapter(null);
            loader.destroyLoader(1);
            return;
        }
        StringBuilder stringbuilder = new StringBuilder((as.length - 1) * 2 + 15);
        stringbuilder.append("merchant_id in (?");
        for (i1 = 1; i1 < as.length; i1++)
        {
            stringbuilder.append(",?");
        }

        stringbuilder.append(")");
        a = ((Cursor) (obj)).getCount();
        obj = new Bundle();
        ((Bundle) (obj)).putString("merchant_clause", stringbuilder.toString());
        ((Bundle) (obj)).putStringArray("merchant_args", as);
        loader.restartLoader(1, ((Bundle) (obj)), this);
        return;
_L3:
        loader = getActivity();
        if (loader != null)
        {
            d.setIcon(0x7f0200d5);
            d.setTitle(0x7f0e00ec);
            d.setSubTitle(null);
            b.setEmptyView(c);
            g = new am(this, loader, ((Cursor) (obj)), f, l, cb.a, h);
            b.setAdapter(g);
            if (!isHidden())
            {
                a.a.a("favorites", null, ((Cursor) (obj)));
            }
            loader = getLoaderManager();
            if (loader != null)
            {
                loader.initLoader(3, null, this);
                return;
            }
        }
          goto _L1
_L4:
        for (boolean flag = ((Cursor) (obj)).moveToFirst(); flag; flag = ((Cursor) (obj)).moveToNext())
        {
            f.put(((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("_id")), true);
        }

        if (g != null)
        {
            g.notifyDataSetChanged();
            return;
        }
          goto _L1
_L5:
        loader = new ArrayList();
        boolean flag1 = ((Cursor) (obj)).moveToFirst();
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
        if (g != null)
        {
            g.notifyDataSetChanged();
            return;
        }
          goto _L1
        i1++;
          goto _L8
    }

    public void onLoaderReset(Loader loader)
    {
        switch (loader.getId())
        {
        default:
            return;

        case 0: // '\0'
            i = null;
            return;

        case 2: // '\002'
            f.clear();
            return;

        case 1: // '\001'
            g = null;
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

}
