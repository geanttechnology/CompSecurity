// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.s;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.ao;
import com.wishabi.flipp.b.p;
import com.wishabi.flipp.b.q;
import com.wishabi.flipp.content.c;
import com.wishabi.flipp.content.d;
import com.wishabi.flipp.util.g;
import com.wishabi.flipp.util.i;
import com.wishabi.flipp.widget.ck;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// Referenced classes of package com.wishabi.flipp.app:
//            dx, dt, du, dv, 
//            dw

public class PrintCouponFragment extends Fragment
    implements android.app.LoaderManager.LoaderCallbacks
{

    private static final String a = com/wishabi/flipp/app/PrintCouponFragment.getSimpleName();
    private Cursor b;
    private MenuItem c;
    private Toast d;
    private View e;
    private RecyclerView f;
    private FrameLayout g;
    private ck h;
    private ao i;
    private boolean j;
    private String k;
    private SparseBooleanArray l;

    public PrintCouponFragment()
    {
    }

    public static PrintCouponFragment a()
    {
        return new PrintCouponFragment();
    }

    static ck a(PrintCouponFragment printcouponfragment)
    {
        return printcouponfragment.h;
    }

    static void a(PrintCouponFragment printcouponfragment, String s1)
    {
        printcouponfragment.a(s1, 1);
    }

    private void a(String s1, int i1)
    {
        Activity activity = getActivity();
        if (activity != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        View view;
        if (d != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if ((view = View.inflate(activity, 0x7f030046, null)) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        d = new Toast(activity);
        d.setView(view);
        d.setGravity(80, 0, com.wishabi.flipp.util.i.a(10));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        if (TextUtils.isEmpty(s1))
        {
            d.cancel();
            return;
        } else
        {
            ((TextView)d.getView().findViewById(0x7f0b00c2)).setText(s1);
            d.setDuration(i1);
            d.show();
            return;
        }
    }

    private void b()
    {
        if (b == null)
        {
            return;
        } else
        {
            a a1 = a.a;
            int i1 = b.getCount();
            HashMap hashmap = new HashMap();
            hashmap.put("count", Integer.toString(i1));
            a1.a("Coupon Redemption", hashmap);
            a1.a("coupon sender", null, null, Long.valueOf(i1));
            return;
        }
    }

    static void b(PrintCouponFragment printcouponfragment)
    {
        printcouponfragment.c();
    }

    private void c()
    {
        Object obj;
        obj = getActivity();
        break MISSING_BLOCK_LABEL_5;
        while (true) 
        {
            do
            {
                return;
            } while (obj == null || h == null);
            com.wishabi.flipp.util.g.a(((Activity) (obj)));
            obj = h;
            int l1 = ((ck) (obj)).d.size();
            Object obj1 = new ArrayList();
            for (int i1 = 0; i1 < l1; i1++)
            {
                if (((ck) (obj)).d.valueAt(i1))
                {
                    ((ArrayList) (obj1)).add(Integer.valueOf(((ck) (obj)).d.keyAt(i1)));
                }
            }

            int ai[] = com.wishabi.flipp.util.a.a(((java.util.List) (obj1)));
            if (ai.length == 0)
            {
                a(getString(0x7f0e0167), 0);
                return;
            }
            obj1 = h.e;
            obj = obj1;
            if (obj1 != null)
            {
                obj = ((String) (obj1)).trim();
            }
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                a(getString(0x7f0e0125), 0);
                return;
            }
            int j1 = ai.length;
            obj1 = getActivity();
            if (obj1 != null)
            {
                c.setVisible(false);
                g.setVisibility(0);
                ((Activity) (obj1)).setProgressBarIndeterminateVisibility(true);
            }
            a(getString(0x7f0e0127), 0);
            i = new dx(this, ((String) (obj)), ai, j1);
            i.execute(new Void[0]);
            if (b != null)
            {
                HashSet hashset = new HashSet();
                int i2 = ai.length;
                for (int k1 = 0; k1 < i2; k1++)
                {
                    hashset.add(Integer.valueOf(ai[k1]));
                }

                d d1 = new d(b);
                boolean flag = b.moveToFirst();
                while (flag) 
                {
                    if (hashset.contains(Integer.valueOf(b.getInt(d1.a))))
                    {
                        c c1 = new c(b, d1);
                        a.a.a(c1, q.e, p.i);
                    }
                    flag = b.moveToNext();
                }
            }
        }
    }

    static void c(PrintCouponFragment printcouponfragment)
    {
        Activity activity = printcouponfragment.getActivity();
        if (activity != null)
        {
            printcouponfragment.c.setVisible(true);
            printcouponfragment.g.setVisibility(8);
            activity.setProgressBarIndeterminateVisibility(false);
        }
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
            return new CursorLoader(bundle, com.wishabi.flipp.content.i.q, new String[] {
                "*", "clipped", "sent"
            }, "clipped = 1 AND deleted = 0", null, "sent ASC, priority ASC, available_from DESC, _id DESC");
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (getActivity() == null)
        {
            return;
        }
        menuinflater.inflate(0x7f100008, menu);
        c = menu.findItem(0x7f0b0160);
        menu = c;
        boolean flag;
        if (!j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        menu.setVisible(flag);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        Activity activity = getActivity();
        if (activity == null)
        {
            return null;
        }
        setHasOptionsMenu(true);
        activity.setProgressBarIndeterminateVisibility(false);
        layoutinflater = layoutinflater.inflate(0x7f030045, viewgroup, false);
        e = layoutinflater.findViewById(0x7f0b003e);
        f = (RecyclerView)layoutinflater.findViewById(0x7f0b0077);
        g = (FrameLayout)layoutinflater.findViewById(0x7f0b0107);
        g.setVisibility(8);
        int i1 = Math.max(com.wishabi.flipp.util.i.a() / 180, 2);
        viewgroup = new s(i1);
        viewgroup.g = new dt(this, i1);
        f.setLayoutManager(viewgroup);
        f.setDescendantFocusability(0x20000);
        f.setFocusable(true);
        f.setFocusableInTouchMode(true);
        f.setOnTouchListener(new du(this));
        g.setOnTouchListener(new dv(this));
        if (bundle != null) goto _L2; else goto _L1
_L1:
        viewgroup = com.wishabi.flipp.util.p.a();
        if (viewgroup == null)
        {
            k = null;
        } else
        {
            k = viewgroup.getString("print_coupon_user_email", null);
        }
        l = null;
_L4:
        viewgroup = getLoaderManager();
        if (viewgroup != null)
        {
            viewgroup.initLoader(0, null, this);
        }
        return layoutinflater;
_L2:
        k = bundle.getString("SAVE_STATE_EMAIL_KEY");
        viewgroup = bundle.getIntArray("SAVE_STATE_SELECTION_ID_KEY");
        bundle = bundle.getBooleanArray("SAVE_STATE_SELECTION_VALUE_KEY");
        if (viewgroup != null && bundle != null && viewgroup.length == bundle.length)
        {
            l = new SparseBooleanArray();
            int k1 = viewgroup.length;
            int j1 = 0;
            while (j1 < k1) 
            {
                l.put(viewgroup[j1], bundle[j1]);
                j1++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onHiddenChanged(boolean flag)
    {
        super.onHiddenChanged(flag);
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        Activity activity;
        obj = (Cursor)obj;
        activity = getActivity();
        if (activity == null) goto _L2; else goto _L1
_L1:
        loader.getId();
        JVM INSTR tableswitch 0 0: default 36
    //                   0 37;
           goto _L2 _L3
_L2:
        return;
_L3:
        if (b != obj)
        {
            b = ((Cursor) (obj));
            if (obj != null)
            {
                if (((Cursor) (obj)).getCount() == 0)
                {
                    e.setVisibility(0);
                    f.setVisibility(8);
                    j = true;
                    if (c != null)
                    {
                        c.setVisible(false);
                        return;
                    }
                } else
                {
                    e.setVisibility(8);
                    f.setVisibility(0);
                    j = false;
                    if (c != null)
                    {
                        c.setVisible(true);
                    }
                    h = new ck(activity, b, k, l, new dw(this));
                    f.setAdapter(h);
                    b();
                    return;
                }
            }
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void onLoaderReset(Loader loader)
    {
        switch (loader.getId())
        {
        default:
            return;

        case 0: // '\0'
            b = null;
            break;
        }
        h = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (getActivity() == null)
        {
            return super.onOptionsItemSelected(menuitem);
        }
        if (c == menuitem)
        {
            c();
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
        boolean flag = false;
        super.onSaveInstanceState(bundle);
        if (h == null)
        {
            return;
        }
        k = h.e;
        bundle.putString("SAVE_STATE_EMAIL_KEY", k);
        ck ck1 = h;
        SparseBooleanArray sparsebooleanarray = new SparseBooleanArray();
        int k1 = ck1.d.size();
        for (int i1 = 0; i1 < k1; i1++)
        {
            sparsebooleanarray.put(ck1.d.keyAt(i1), ck1.d.valueAt(i1));
        }

        l = sparsebooleanarray;
        k1 = l.size();
        int ai[] = new int[k1];
        boolean aflag[] = new boolean[k1];
        for (int j1 = ((flag) ? 1 : 0); j1 < k1; j1++)
        {
            ai[j1] = l.keyAt(j1);
            aflag[j1] = l.valueAt(j1);
        }

        bundle.putIntArray("SAVE_STATE_SELECTION_ID_KEY", ai);
        bundle.putBooleanArray("SAVE_STATE_SELECTION_VALUE_KEY", aflag);
    }

}
