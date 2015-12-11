// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.an;
import android.support.v7.widget.ao;
import android.support.v7.widget.au;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.s;
import com.wishabi.flipp.content.ShoppingList;
import com.wishabi.flipp.content.SimpleSearchResult;
import com.wishabi.flipp.content.aj;
import com.wishabi.flipp.content.ar;
import com.wishabi.flipp.content.as;
import com.wishabi.flipp.content.ay;
import com.wishabi.flipp.content.az;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.widget.CustomAutoCompleteTextView;
import com.wishabi.flipp.widget.ShoppingListZeroCaseView;
import com.wishabi.flipp.widget.db;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.wishabi.flipp.app:
//            FocusedRecyclerView, ff, SearchActivity, en, 
//            ew, et, ex, ey, 
//            ez, fa, fb, fc, 
//            fd, fe, eu, ev

public class ShoppingListFragment extends Fragment
    implements ar, ay
{

    ShoppingList a;
    ff b;
    long c;
    private FocusedRecyclerView d;
    private as e;
    private ShoppingListZeroCaseView f;
    private String g;
    private Toast h;
    private PopupMenu i;
    private View j;
    private View k;
    private CustomAutoCompleteTextView l;
    private ActionMode m;
    private android.view.ActionMode.Callback n;
    private com.wishabi.flipp.b.ar o;
    private final HashMap p = new HashMap();
    private int q;
    private SharedPreferences r;
    private android.content.SharedPreferences.OnSharedPreferenceChangeListener s;

    public ShoppingListFragment()
    {
        c = -1L;
        q = 0;
    }

    static long a(ShoppingListFragment shoppinglistfragment, long l1)
    {
        shoppinglistfragment.c = l1;
        return l1;
    }

    static SharedPreferences a(ShoppingListFragment shoppinglistfragment)
    {
        return shoppinglistfragment.r;
    }

    static String a(ShoppingListFragment shoppinglistfragment, String s1)
    {
        shoppinglistfragment.g = s1;
        return s1;
    }

    private void a(long l1, boolean flag)
    {
        int i1;
        int j1;
        if (b != null)
        {
            if ((i1 = a.a(l1)) >= 0 && i1 < e.d.a() && i1 != (j1 = a.a(a.f)))
            {
                if (j1 != -1)
                {
                    e.c(j1);
                }
                a.f = l1;
                if (flag)
                {
                    e.c(i1);
                    return;
                }
            }
        }
    }

    private void a(Menu menu)
    {
        if (getActivity() == null || a == null)
        {
            return;
        }
        MenuItem menuitem = menu.findItem(0x7f0b0161);
        MenuItem menuitem1 = menu.findItem(0x7f0b0162);
        MenuItem menuitem2 = menu.findItem(0x7f0b0163);
        menu = menu.findItem(0x7f0b0164);
        if (a.a() == 0)
        {
            menuitem.setEnabled(false);
            menu.setEnabled(false);
        } else
        {
            menuitem.setEnabled(true);
            menu.setEnabled(true);
        }
        if (a.g == 0)
        {
            menuitem1.setEnabled(false);
            menuitem2.setEnabled(false);
            return;
        } else
        {
            menuitem1.setEnabled(true);
            menuitem2.setEnabled(true);
            return;
        }
    }

    static void a(ShoppingListFragment shoppinglistfragment, Menu menu)
    {
        shoppinglistfragment.a(menu);
    }

    private void a(boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        if (l.isFocused())
        {
            obj = l;
        } else
        {
            obj = d.getFocusedChild();
        }
        obj1 = getActivity();
        if (obj != null && obj1 != null) goto _L3; else goto _L2
_L2:
        d.requestFocus();
        return;
_L3:
        obj1 = (InputMethodManager)((Context) (obj1)).getSystemService("input_method");
        if (obj1 != null)
        {
            ((InputMethodManager) (obj1)).hideSoftInputFromWindow(((View) (obj)).getWindowToken(), 2);
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    private boolean a(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131427681 2131427684: default 36
    //                   2131427681 228
    //                   2131427682 38
    //                   2131427683 126
    //                   2131427684 177;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return false;
_L3:
        menuitem = a;
        ContentResolver contentresolver = ((ShoppingList) (menuitem)).d.getContentResolver();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("checked", Integer.valueOf(0));
        contentvalues.put("datetime_updated", Long.valueOf(System.currentTimeMillis()));
        int i1 = contentresolver.update(i.k, contentvalues, "shopping_list_id = ? AND checked = ?", new String[] {
            Integer.toString(((ShoppingList) (menuitem)).c), "1"
        });
        a.a.a(null, s.h, i1);
_L7:
        return true;
_L4:
        menuitem = a;
        int j1 = ((ShoppingList) (menuitem)).d.getContentResolver().delete(i.k, "shopping_list_id = ? AND checked = 1", new String[] {
            Integer.toString(((ShoppingList) (menuitem)).c)
        });
        a.a.a(null, s.f, j1);
        continue; /* Loop/switch isn't completed */
_L5:
        menuitem = a;
        int k1 = ((ShoppingList) (menuitem)).d.getContentResolver().delete(i.k, "shopping_list_id = ?", new String[] {
            Integer.toString(((ShoppingList) (menuitem)).c)
        });
        a.a.a(null, s.g, k1);
        continue; /* Loop/switch isn't completed */
_L2:
        c();
        if (true) goto _L7; else goto _L6
_L6:
    }

    static boolean a(ShoppingListFragment shoppinglistfragment, MenuItem menuitem)
    {
        return shoppinglistfragment.a(menuitem);
    }

    static ShoppingList b(ShoppingListFragment shoppinglistfragment)
    {
        return shoppinglistfragment.a;
    }

    private void b()
    {
        if (f != null)
        {
            if (a.a() == 0 && f.getVisibility() != 0)
            {
                f.setVisibility(0);
                f.setAlpha(0.0F);
                f.animate().alpha(1.0F).setDuration(600L).start();
                return;
            }
            if (a.a() > 0 && f.getVisibility() == 0)
            {
                f.setVisibility(8);
                return;
            }
        }
    }

    static ff c(ShoppingListFragment shoppinglistfragment)
    {
        return shoppinglistfragment.b;
    }

    private void c()
    {
        if (i == null)
        {
            m = getActivity().startActionMode(n);
        } else
        if (j != null && k != null)
        {
            a(true);
            e.a(true);
            j.setVisibility(4);
            k.setVisibility(0);
            l.setEnabled(false);
            return;
        }
    }

    private void d()
    {
        if (m != null)
        {
            m.finish();
            m = null;
        } else
        if (j != null && k != null)
        {
            a(true);
            e.a(false);
            j.setVisibility(0);
            k.setVisibility(4);
            l.setEnabled(true);
            return;
        }
    }

    static void d(ShoppingListFragment shoppinglistfragment)
    {
        shoppinglistfragment.a(true);
    }

    static as e(ShoppingListFragment shoppinglistfragment)
    {
        return shoppinglistfragment.e;
    }

    private void e()
    {
        for (Iterator iterator = p.values().iterator(); iterator.hasNext(); ((com.wishabi.flipp.b.as)iterator.next()).cancel(true)) { }
        p.clear();
    }

    static CustomAutoCompleteTextView f(ShoppingListFragment shoppinglistfragment)
    {
        return shoppinglistfragment.l;
    }

    static FocusedRecyclerView g(ShoppingListFragment shoppinglistfragment)
    {
        return shoppinglistfragment.d;
    }

    static PopupMenu h(ShoppingListFragment shoppinglistfragment)
    {
        return shoppinglistfragment.i;
    }

    static void i(ShoppingListFragment shoppinglistfragment)
    {
        shoppinglistfragment.d();
    }

    static HashMap j(ShoppingListFragment shoppinglistfragment)
    {
        return shoppinglistfragment.p;
    }

    public final void a()
    {
        b();
    }

    public final void a(int i1)
    {
        if (e == null)
        {
            return;
        } else
        {
            e.c(i1);
            return;
        }
    }

    public final void a(EditText edittext)
    {
        edittext.setText("");
        a(false);
    }

    public final void a(ShoppingList shoppinglist)
    {
        if (e == null)
        {
            return;
        }
        if (shoppinglist.b(shoppinglist.f) == null && b != null)
        {
            b.a();
        }
        if (shoppinglist.b() == 0)
        {
            e();
        }
        b();
        ((an) (e)).a.b();
    }

    public final void a(az az1)
    {
        a(true);
        if (getActivity() == null)
        {
            return;
        }
        if (b != null)
        {
            b.a(az1.b());
            a(az1.a(), true);
            return;
        } else
        {
            Intent intent = new Intent(getActivity(), com/wishabi/flipp/app/SearchActivity);
            intent.setAction("android.intent.action.SEARCH");
            intent.putExtra("query", az1.b());
            az1 = new Bundle();
            az1.putInt("search_mode", en.b - 1);
            intent.putExtra("com.wishabi.flipp.search_bundle", az1);
            startActivity(intent);
            getActivity().overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        }
    }

    public final void a(az az1, int i1, boolean flag)
    {
        if (e == null)
        {
            return;
        }
        if (az1.a() == c)
        {
            az1.c = true;
        }
        b();
        if (flag)
        {
            ((an) (e)).a.a(i1 - 1, 2);
        } else
        {
            ((an) (e)).a.a(i1, 1);
        }
        if (az1.a() == c)
        {
            a(az1.a(), false);
        }
        az1 = d;
        ((RecyclerView) (az1)).f.a(az1, i1);
    }

    public final void a(db db1)
    {
        db1.setPressed(false);
        c();
    }

    public final void a(db db1, az az1, boolean flag)
    {
        if (az1 == null)
        {
            return;
        }
        Object obj = a.d.getContentResolver();
        ContentValues contentvalues = new ContentValues();
        int i1;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        contentvalues.put("checked", Integer.valueOf(i1));
        contentvalues.put("datetime_updated", Long.valueOf(System.currentTimeMillis()));
        ((ContentResolver) (obj)).update(i.k, contentvalues, "id = ?", new String[] {
            Long.toString(az1.a())
        });
        if (d.getFocusedChild() == db1)
        {
            a(true);
        }
        db1 = a.a;
        obj = az1.b();
        if (flag)
        {
            i1 = s.i;
        } else
        {
            i1 = s.j;
        }
        db1.a(((String) (obj)), i1, az1.b);
    }

    final void a(String s1)
    {
        Object obj = getActivity();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (h != null)
        {
            break; /* Loop/switch isn't completed */
        }
        h = new Toast(getActivity());
        h.setGravity(80, 0, (int)TypedValue.applyDimension(1, 55F, ((Activity) (obj)).getResources().getDisplayMetrics()));
        obj = ((Activity) (obj)).getLayoutInflater().inflate(0x7f03002e, null);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        h.setView(((View) (obj)));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        if (s1 == null)
        {
            h.cancel();
            return;
        } else
        {
            ((TextView)h.getView().findViewById(0x7f0b00c2)).setText(s1);
            h.setDuration(0);
            h.show();
            return;
        }
    }

    public final boolean a(db db1, az az1)
    {
        if (az1 == null)
        {
            a(true);
            return false;
        }
        db1 = db1.getName().trim();
        if (db1.equals(""))
        {
            a.b(az1);
            a(true);
            return false;
        }
        if (b != null)
        {
            b.a(db1);
        }
        az1.b = -1;
        az1.c = false;
        az1.c = true;
        Object obj = a;
        if (db1 != null && !db1.equals(""))
        {
            obj = ((ShoppingList) (obj)).d.getContentResolver();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("name", db1);
            contentvalues.put("datetime_updated", Long.valueOf(System.currentTimeMillis()));
            ((ContentResolver) (obj)).update(i.k, contentvalues, "id = ?", new String[] {
                Long.toString(az1.a())
            });
        }
        a.d(az1.a());
        a(az1.a(), false);
        a(true);
        a.a.a(db1, s.d, -1);
        return false;
    }

    public final void b(az az1)
    {
        if (g != null)
        {
            long l1 = az1.a();
            String s1 = az1.b();
            SimpleSearchResult simplesearchresult = a.c(l1);
            com.wishabi.flipp.b.as as1 = (com.wishabi.flipp.b.as)p.get(Long.valueOf(l1));
            long l2 = System.currentTimeMillis();
            if (as1 == null && (simplesearchresult == null || l2 >= simplesearchresult.c))
            {
                a.d(az1.a());
                az1 = new ew(this, g, az1.b(), getActivity(), l1, s1);
                p.put(Long.valueOf(l1), az1);
                az1.execute(new Void[0]);
                return;
            }
        }
    }

    public final void b(az az1, int i1, boolean flag)
    {
        if (e == null)
        {
            return;
        }
        if (az1.a() == a.f && b != null)
        {
            b.a();
        }
        if (a.a() == 0 && e.e)
        {
            d();
        }
        b();
        az1 = (com.wishabi.flipp.b.as)p.get(Long.valueOf(az1.a()));
        if (az1 != null)
        {
            az1.cancel(true);
        }
        if (flag)
        {
            ((an) (e)).a.b(i1 - 1, 2);
            return;
        } else
        {
            ((an) (e)).a.b(i1, 1);
            return;
        }
    }

    public final void b(db db1, az az1, boolean flag)
    {
        int i1;
        for (i1 = a.a(az1); flag || i1 == -1 || d.p || d.getScrollState() != 0 || db1.a;)
        {
            return;
        }

        e.c(i1);
    }

    public final void c(az az1)
    {
        if (az1 == null)
        {
            return;
        } else
        {
            a.b(az1);
            a.a.a(az1.b(), s.e, az1.b);
            return;
        }
    }

    public final void d(az az1)
    {
        e.c(a.a(az1));
        a(false);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getActivity() == null)
        {
            return;
        }
        if (bundle != null)
        {
            q = bundle.getInt("list_id", -1);
            a = (ShoppingList)bundle.getParcelable("shopping_list");
            g = bundle.getString("postal_code");
        }
        if (q == -1 || a == null)
        {
            q = 0;
            a = new ShoppingList(q);
        }
        bundle = getActivity().getContentResolver();
        Cursor cursor = bundle.query(i.j, null, "id = ?", new String[] {
            Integer.toString(q)
        }, null);
        if (cursor == null || cursor.getCount() == 0)
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("id", Integer.valueOf(q));
            contentvalues.put("name", "default");
            bundle.insert(i.j, contentvalues);
        }
        a.d = getActivity();
        r = getActivity().getSharedPreferences("com.wishabi.flipp.preferences", 0);
        bundle = r.getString("postal_code", null);
        if (g != null && !g.equals(bundle))
        {
            a.c();
        }
        a.e = this;
        g = bundle;
        s = new et(this);
        r.registerOnSharedPreferenceChangeListener(s);
        n = new ex(this);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            menu = menu.addSubMenu(0, 0x7f0b0005, 0, 0x7f0e0093);
            menu.getItem().setShowAsAction(2);
            menu.setIcon(0x7f02009c);
            menuinflater.inflate(0x7f10000a, menu);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03004e, viewgroup, false);
        l = (CustomAutoCompleteTextView)layoutinflater.findViewById(0x7f0b011d);
        l.setImeActionLabel(getActivity().getString(0x7f0e0002), 6);
        l.setOnEditorActionListener(new ey(this));
        l.setOnFocusChangeListener(new ez(this));
        l.setKeyboardDimissedListener(new fa(this));
        d = (FocusedRecyclerView)layoutinflater.findViewById(0x7f0b011b);
        viewgroup = d;
        getActivity();
        viewgroup.setLayoutManager(new fb(this));
        d.setOnScrollListener(new fc(this));
        e = new as(getActivity(), a);
        viewgroup = e;
        if (((as) (viewgroup)).c != null)
        {
            throw new IllegalStateException("Only one listener is allowedfor shopping list");
        }
        viewgroup.c = this;
        ((an) (viewgroup)).a.b();
        boolean flag;
        if (bundle != null && bundle.getBoolean("is_edit_mode"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d.setAdapter(e);
        f = (ShoppingListZeroCaseView)layoutinflater.findViewById(0x7f0b011c);
        if (Locale.getDefault().getLanguage().equals("fr"))
        {
            f.setItems(aj.a(0x7f070001));
        } else
        {
            f.setItems(aj.a(0x7f070000));
        }
        f.setListener(new fd(this));
        j = layoutinflater.findViewById(0x7f0b0131);
        k = layoutinflater.findViewById(0x7f0b0130);
        if (j != null && k != null)
        {
            i = new PopupMenu(getActivity(), j);
            i.getMenuInflater().inflate(0x7f10000a, i.getMenu());
            i.setOnMenuItemClickListener(new fe(this));
            j.setOnClickListener(new eu(this));
            k.setOnClickListener(new ev(this));
        } else
        {
            setHasOptionsMenu(true);
        }
        getLoaderManager().initLoader(0, null, a);
        getLoaderManager().initLoader(1, null, a);
        if (flag)
        {
            c();
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (s != null)
        {
            r.unregisterOnSharedPreferenceChangeListener(s);
            s = null;
            r = null;
        }
        if (o != null)
        {
            o.cancel(true);
            o = null;
        }
        e();
    }

    public void onHiddenChanged(boolean flag)
    {
        Activity activity;
        super.onHiddenChanged(flag);
        activity = getActivity();
        break MISSING_BLOCK_LABEL_10;
        if (activity != null && !flag)
        {
            a.a.a("shopping list");
            activity.setTitle(getString(0x7f0e0135));
            if (o == null || o.getStatus() == android.os.AsyncTask.Status.FINISHED)
            {
                long l1 = r.getLong("last_cat_download", 0L);
                String s1 = r.getString("last_cat_download_locale", "");
                if (System.currentTimeMillis() - l1 >= 0x5265c00L || !Locale.getDefault().toString().equals(s1))
                {
                    o = new com.wishabi.flipp.b.ar(getActivity().getContentResolver(), activity);
                    o.execute(new Void[0]);
                    return;
                }
            }
        }
        return;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f0b0005 && getActivity() != null && menuitem.getSubMenu() != null)
        {
            a(menuitem.getSubMenu());
        }
        return a(menuitem) || super.onOptionsItemSelected(menuitem);
    }

    public void onResume()
    {
        super.onResume();
        if (!isHidden())
        {
            a.a.a("shopping list");
        }
        if (l != null && l.isFocused())
        {
            l.dismissDropDown();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("list_id", q);
        bundle.putString("postal_code", g);
        bundle.putBoolean("is_edit_mode", e.e);
        bundle.putParcelable("shopping_list", a);
    }

    public void onStart()
    {
        super.onStart();
        if (e != null)
        {
            ((an) (e)).a.b();
        }
    }
}
