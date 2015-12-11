// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.util.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.wishabi.flipp.app:
//            af, ac, ad, ae

public class DrawerFragment extends Fragment
    implements android.app.LoaderManager.LoaderCallbacks, android.view.View.OnClickListener
{

    af a;
    private SharedPreferences b;
    private android.content.SharedPreferences.OnSharedPreferenceChangeListener c;
    private TextView d;
    private TextView e;
    private TextView f;
    private LinearLayout g;
    private final Map h = new HashMap();
    private Cursor i;
    private final HashMap j = new HashMap();
    private final HashMap k = new HashMap();
    private String l;

    public DrawerFragment()
    {
    }

    public static int a(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if (s.equals("All Flyers"))
            {
                return 0x7f0e001b;
            }
            if (s.equals("Favorites"))
            {
                return 0x7f0e00b4;
            }
            if (s.equals("Clippings"))
            {
                return 0x7f0e0034;
            }
            if (s.equals("Shopping List"))
            {
                return 0x7f0e0135;
            }
            if (s.equals("Coupons"))
            {
                return 0x7f0e0086;
            }
            if (s.equals("Print Coupons"))
            {
                return 0x7f0e0105;
            }
            if (s.equals("Categories"))
            {
                return 0x7f0e001a;
            }
            if (s.equals("Automotive"))
            {
                return 0x7f0e001c;
            }
            if (s.equals("Baby & Kids"))
            {
                return 0x7f0e001d;
            }
            if (s.equals("Electronics"))
            {
                return 0x7f0e001e;
            }
            if (s.equals("Fashion"))
            {
                return 0x7f0e001f;
            }
            if (s.equals("Groceries"))
            {
                return 0x7f0e0020;
            }
            if (s.equals("Health & Pharmacy"))
            {
                return 0x7f0e0021;
            }
            if (s.equals("Home & Garden"))
            {
                return 0x7f0e0022;
            }
            if (s.equals("Office"))
            {
                return 0x7f0e0023;
            }
            if (s.equals("Pets"))
            {
                return 0x7f0e0025;
            }
            if (s.equals("Pharmacy"))
            {
                return 0x7f0e0026;
            }
            if (s.equals("Sporting Goods"))
            {
                return 0x7f0e0027;
            }
        }
        return 0;
    }

    static TextView a(DrawerFragment drawerfragment)
    {
        return drawerfragment.d;
    }

    private void a(TextView textview, String s)
    {
        int i1 = a(s);
        String s1;
        if (i1 != 0)
        {
            s1 = getString(i1);
        } else
        {
            s1 = s;
        }
        textview.setText(s1);
        textview.setTag(s);
        textview.setCompoundDrawablesWithIntrinsicBounds((Drawable)h.get(s), null, null, null);
        textview.setBackgroundResource(0x7f09006c);
        textview.setOnClickListener(this);
    }

    static af b(DrawerFragment drawerfragment)
    {
        return drawerfragment.a;
    }

    private void b(String s)
    {
        java.util.Map.Entry entry;
        String s1;
        for (Iterator iterator = j.entrySet().iterator(); iterator.hasNext(); ((View)entry.getValue()).setSelected(s1.equals(s)))
        {
            entry = (java.util.Map.Entry)iterator.next();
            s1 = (String)entry.getKey();
        }

        java.util.Map.Entry entry1;
        String s2;
        for (Iterator iterator1 = k.entrySet().iterator(); iterator1.hasNext(); ((View)entry1.getValue()).setSelected(s2.equals(s)))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
            s2 = (String)entry1.getKey();
        }

        l = s;
    }

    public void onClick(View view)
    {
        view = (String)view.getTag();
        if (!TextUtils.isEmpty(view) && a != null)
        {
            a.a(view);
        }
        b(view);
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

        case 0: // '\0'
            return new CursorLoader(bundle, i.b, new String[] {
                "name"
            }, "name <> 'All Flyers'", null, "name");

        case 1: // '\001'
            return new CursorLoader(bundle, i.q, new String[] {
                "_id", "clipped", "sent"
            }, "clipped = 1 AND (sent = 0 OR sent IS NULL) AND deleted = 0", null, null);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (getActivity() == null)
        {
            return null;
        }
        layoutinflater = layoutinflater.inflate(0x7f030022, viewgroup, false);
        if (layoutinflater == null)
        {
            return null;
        }
        b = p.a();
        c = new ac(this);
        b.registerOnSharedPreferenceChangeListener(c);
        d = (TextView)layoutinflater.findViewById(0x7f0b009a);
        d.setText(b.getString("postal_code", null));
        e = (TextView)layoutinflater.findViewById(0x7f0b00a2);
        e.setVisibility(8);
        f = (TextView)layoutinflater.findViewById(0x7f0b00a3);
        g = (LinearLayout)layoutinflater.findViewById(0x7f0b00a4);
        ((TextView)layoutinflater.findViewById(0x7f0b009b)).setOnClickListener(new ad(this));
        ((TextView)layoutinflater.findViewById(0x7f0b00a1)).setOnClickListener(new ae(this));
        h.put("All Flyers", getResources().getDrawable(0x7f020093));
        h.put("Favorites", getResources().getDrawable(0x7f020092));
        h.put("Clippings", getResources().getDrawable(0x7f02008e));
        h.put("Shopping List", getResources().getDrawable(0x7f02009a));
        h.put("Coupons", getResources().getDrawable(0x7f02008f));
        h.put("Automotive", getResources().getDrawable(0x7f02008c));
        h.put("Baby & Kids", getResources().getDrawable(0x7f02008d));
        h.put("Electronics", getResources().getDrawable(0x7f020090));
        h.put("Fashion", getResources().getDrawable(0x7f020091));
        h.put("Groceries", getResources().getDrawable(0x7f020094));
        h.put("Health & Pharmacy", getResources().getDrawable(0x7f020099));
        h.put("Home & Garden", getResources().getDrawable(0x7f020095));
        h.put("Office", getResources().getDrawable(0x7f020096));
        h.put("Pets", getResources().getDrawable(0x7f020098));
        h.put("Pharmacy", getResources().getDrawable(0x7f020099));
        h.put("Sporting Goods", getResources().getDrawable(0x7f02009b));
        viewgroup = (TextView)layoutinflater.findViewById(0x7f0b009c);
        a(viewgroup, "All Flyers");
        j.put("All Flyers", viewgroup);
        viewgroup = (TextView)layoutinflater.findViewById(0x7f0b009e);
        a(viewgroup, "Favorites");
        j.put("Favorites", viewgroup);
        viewgroup = (TextView)layoutinflater.findViewById(0x7f0b009f);
        a(viewgroup, "Clippings");
        j.put("Clippings", viewgroup);
        viewgroup = (TextView)layoutinflater.findViewById(0x7f0b00a0);
        a(viewgroup, "Shopping List");
        j.put("Shopping List", viewgroup);
        viewgroup = (TextView)layoutinflater.findViewById(0x7f0b009d);
        a(viewgroup, "Coupons");
        j.put("Coupons", viewgroup);
        if (bundle != null)
        {
            l = bundle.getString("SAVE_STATE_CATEGORY_SELECTED_KEY");
        }
        viewgroup = getLoaderManager();
        if (viewgroup != null)
        {
            viewgroup.initLoader(0, null, this);
            viewgroup.initLoader(1, null, this);
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (c != null)
        {
            b.unregisterOnSharedPreferenceChangeListener(c);
            c = null;
            b = null;
        }
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        android.app.Activity activity;
        obj = (Cursor)obj;
        activity = getActivity();
        if (activity == null) goto _L2; else goto _L1
_L1:
        loader.getId();
        JVM INSTR tableswitch 0 1: default 40
    //                   0 41
    //                   1 198;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        if (i != obj)
        {
            i = ((Cursor) (obj));
            g.removeAllViews();
            k.clear();
            if (obj == null || ((Cursor) (obj)).getCount() == 0)
            {
                f.setVisibility(8);
                return;
            }
            f.setVisibility(0);
            int i1 = ((Cursor) (obj)).getColumnIndexOrThrow("name");
            for (boolean flag = ((Cursor) (obj)).moveToFirst(); flag; flag = ((Cursor) (obj)).moveToNext())
            {
                loader = ((Cursor) (obj)).getString(i1);
                if (!TextUtils.isEmpty(loader))
                {
                    TextView textview = (TextView)View.inflate(activity, 0x7f030006, null);
                    a(textview, loader);
                    g.addView(textview);
                    k.put(loader, textview);
                }
            }

            b(l);
            return;
        }
        if (true) goto _L2; else goto _L4
_L4:
        if (obj == null || ((Cursor) (obj)).getCount() == 0)
        {
            e.setVisibility(8);
            return;
        } else
        {
            e.setText(Integer.toString(((Cursor) (obj)).getCount()));
            e.setVisibility(0);
            return;
        }
    }

    public void onLoaderReset(Loader loader)
    {
        switch (loader.getId())
        {
        default:
            return;

        case 0: // '\0'
            i = null;
            break;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("SAVE_STATE_CATEGORY_SELECTED_KEY", l);
    }
}
