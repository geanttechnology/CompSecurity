// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import b.a.a.b;
import b.a.a.d.aa;
import b.a.a.d.d;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.p;
import com.wishabi.flipp.content.FlyerActivityIntent;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.content.l;
import com.wishabi.flipp.content.o;
import com.wishabi.flipp.util.f;
import com.wishabi.flipp.util.g;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.q;
import com.wishabi.flipp.widget.CollectionView;
import com.wishabi.flipp.widget.ZeroCaseView;
import com.wishabi.flipp.widget.eg;
import com.wishabi.flipp.widget.h;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.wishabi.flipp.app:
//            f, g, h, dr, 
//            i, dn, k

public class ClippingsFragment extends Fragment
    implements android.app.LoaderManager.LoaderCallbacks
{

    private final com.wishabi.flipp.widget.p a = new com.wishabi.flipp.app.f(this);
    private final dn b = new com.wishabi.flipp.app.g(this);
    private final com.wishabi.flipp.app.k c = new com.wishabi.flipp.app.h(this);
    private CollectionView d;
    private ZeroCaseView e;
    private Cursor f;
    private Cursor g;
    private HashMap h;
    private HashMap i;
    private boolean j;

    public ClippingsFragment()
    {
    }

    static CollectionView a(ClippingsFragment clippingsfragment)
    {
        return clippingsfragment.d;
    }

    private static ArrayList a(Cursor cursor)
    {
        ArrayList arraylist = new ArrayList();
        if (cursor != null && cursor.getCount() != 0)
        {
            String s = k.a(null);
            int i1 = cursor.getColumnIndexOrThrow("_id");
            int j1 = cursor.getColumnIndexOrThrow("deleted");
            int k1 = cursor.getColumnIndexOrThrow("postal_code");
            int l1 = cursor.getColumnIndexOrThrow("sent");
            boolean flag = cursor.moveToFirst();
            while (flag) 
            {
                if (cursor.getInt(j1) == 1 && cursor.getString(k1).equalsIgnoreCase(s) || cursor.getInt(l1) == 1)
                {
                    arraylist.add(Integer.valueOf(cursor.getInt(i1)));
                }
                flag = cursor.moveToNext();
            }
        }
        return arraylist;
    }

    private void a()
    {
        if (g == null || f == null)
        {
            return;
        } else
        {
            a.a.a("clippings");
            a a1 = a.a;
            int i1 = f.getCount();
            int j1 = g.getCount();
            HashMap hashmap = new HashMap();
            hashmap.put("count", Integer.toString(i1));
            hashmap.put("coupon_count", Integer.toString(j1));
            a1.a("Clippings", hashmap);
            return;
        }
    }

    private void a(int i1)
    {
        Activity activity = getActivity();
        if (activity != null) goto _L2; else goto _L1
_L1:
        ContentResolver contentresolver;
        return;
_L2:
        if ((contentresolver = activity.getContentResolver()) == null) goto _L1; else goto _L3
_L3:
        switch (i1)
        {
        default:
            return;

        case 2131427665: 
            d.startActionMode(d.getMultiChoiceModeListener());
            return;

        case 2131427666: 
            Object obj = b.a.a.b.a(g.a);
            String as[] = aa.c();
            if (as == null)
            {
                obj = ((b.a.a.a.b) (obj)).toString();
            } else
            {
                obj = as.a(((b.a.a.z) (obj)));
            }
            contentresolver.delete(i.g, "valid_to < ?", new String[] {
                obj
            });
            if (g != null)
            {
                as = a(g);
                if (!as.isEmpty())
                {
                    obj = new ContentValues();
                    ((ContentValues) (obj)).put("clipped", Integer.valueOf(0));
                    as = q.a(as);
                    contentresolver.update(i.t, ((ContentValues) (obj)), com.wishabi.flipp.util.f.a("_id", as), as);
                    return;
                }
            }
            break;

        case 2131427667: 
            contentresolver.delete(i.g, null, null);
            return;

        case 2131427668: 
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("clipped", Integer.valueOf(0));
            contentresolver.update(i.t, contentvalues, null, null);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    static void a(ClippingsFragment clippingsfragment, int i1)
    {
        Activity activity = clippingsfragment.getActivity();
        if (activity == null) goto _L2; else goto _L1
_L1:
        Object obj = (com.wishabi.flipp.widget.g)clippingsfragment.d.getAdapter();
        if (obj == null) goto _L2; else goto _L3
_L3:
        Object obj1 = ((com.wishabi.flipp.widget.g) (obj)).a(i1);
        if (obj1 == null) goto _L2; else goto _L4
_L4:
        int j1 = ((com.wishabi.flipp.widget.g) (obj)).getItemViewType(i1);
        if (j1 != 0) goto _L6; else goto _L5
_L5:
        clippingsfragment = (Cursor)obj1;
        float f1 = clippingsfragment.getFloat(clippingsfragment.getColumnIndexOrThrow("left"));
        float f2 = clippingsfragment.getFloat(clippingsfragment.getColumnIndexOrThrow("top"));
        float f3 = clippingsfragment.getFloat(clippingsfragment.getColumnIndexOrThrow("right"));
        float f4 = clippingsfragment.getFloat(clippingsfragment.getColumnIndexOrThrow("bottom"));
        obj = clippingsfragment.getString(clippingsfragment.getColumnIndexOrThrow("flyer_id"));
        clippingsfragment = new RectF(f1, f2, f3, f4);
_L15:
        obj = activity.getContentResolver().query(i.a, null, "flyer_id = ?", new String[] {
            obj
        }, null);
        if (obj == null) goto _L8; else goto _L7
_L7:
        boolean flag = ((Cursor) (obj)).moveToFirst();
        if (flag) goto _L9; else goto _L8
_L8:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
_L2:
        return;
_L6:
        if (j1 != 1)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        obj = (Cursor)obj1;
        i1 = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("_id"));
        clippingsfragment = (ArrayList)clippingsfragment.i.get(Integer.valueOf(i1));
        if (clippingsfragment == null || clippingsfragment.isEmpty()) goto _L2; else goto _L10
_L10:
        clippingsfragment = (o)clippingsfragment.get(0);
        obj = Integer.toString(((o) (clippingsfragment)).b);
        clippingsfragment = clippingsfragment.a();
        continue; /* Loop/switch isn't completed */
        throw new IllegalArgumentException((new StringBuilder("Invalid index for item click: ")).append(i1).toString());
_L9:
        activity.startActivity(new FlyerActivityIntent(activity, ((Cursor) (obj)), clippingsfragment));
        activity.overridePendingTransition(0x7f040001, 0x7f040002);
        if (obj == null) goto _L2; else goto _L11
_L11:
        ((Cursor) (obj)).close();
        return;
        clippingsfragment;
        obj = null;
_L13:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw clippingsfragment;
        clippingsfragment;
        if (true) goto _L13; else goto _L12
_L12:
        if (true) goto _L15; else goto _L14
_L14:
    }

    static void a(ClippingsFragment clippingsfragment, boolean flag)
    {
        clippingsfragment.j = flag;
        com.wishabi.flipp.widget.g g1 = (com.wishabi.flipp.widget.g)clippingsfragment.d.getAdapter();
        if (g1 != null)
        {
            g1.g = clippingsfragment.j;
            g1.notifyDataSetChanged();
        }
    }

    static Cursor b(ClippingsFragment clippingsfragment)
    {
        return clippingsfragment.g;
    }

    private void b()
    {
        com.wishabi.flipp.widget.g g1 = new com.wishabi.flipp.widget.g(getActivity(), f, g, h, i, b);
        SparseBooleanArray sparsebooleanarray;
        if (d.getActivatedItemPositions() != null)
        {
            sparsebooleanarray = d.getActivatedItemPositions().clone();
        } else
        {
            sparsebooleanarray = null;
        }
        g1.g = j;
        d.setAdapter(g1);
        if (sparsebooleanarray != null)
        {
            int i1 = 0;
            while (i1 < sparsebooleanarray.size()) 
            {
                int j1 = sparsebooleanarray.keyAt(i1);
                boolean flag = sparsebooleanarray.get(j1);
                d.a(j1, flag);
                i1++;
            }
        }
    }

    static void b(ClippingsFragment clippingsfragment, int i1)
    {
        boolean flag = true;
        if (clippingsfragment.getActivity() == null) goto _L2; else goto _L1
_L1:
        Object obj = (com.wishabi.flipp.widget.g)clippingsfragment.d.getAdapter();
        if (obj == null) goto _L2; else goto _L3
_L3:
        int ai[] = ((int []) (((com.wishabi.flipp.widget.g) (obj)).a(i1)));
        if (ai == null) goto _L2; else goto _L4
_L4:
        int j1 = ((com.wishabi.flipp.widget.g) (obj)).getItemViewType(i1);
        if (j1 != 0) goto _L6; else goto _L5
_L5:
        obj = (Cursor)ai;
        long l1 = ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndexOrThrow("_id"));
        obj = (ArrayList)clippingsfragment.h.get(Long.valueOf(l1));
        if (obj != null && !((ArrayList) (obj)).isEmpty()) goto _L7; else goto _L2
_L2:
        return;
_L7:
        ai = com.wishabi.flipp.content.a.a(((ArrayList) (obj)));
        obj = p.h;
_L9:
        clippingsfragment = clippingsfragment.getActivity();
        int k1;
        if (j1 != 1)
        {
            flag = false;
        }
        com.wishabi.flipp.app.dr.a(clippingsfragment, ai, flag, ((p) (obj)));
        return;
_L6:
        if (j1 != 1)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        obj = (Cursor)ai;
        k1 = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("_id"));
        if (((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("deleted")) == 1)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0) goto _L2; else goto _L8
_L8:
        ai = new int[1];
        ai[0] = k1;
        obj = p.f;
          goto _L9
        throw new IllegalArgumentException((new StringBuilder("Invalid index for coupon click: ")).append(i1).toString());
    }

    static Cursor c(ClippingsFragment clippingsfragment)
    {
        return clippingsfragment.f;
    }

    static void c(ClippingsFragment clippingsfragment, int i1)
    {
        clippingsfragment.a(i1);
    }

    public Loader onCreateLoader(int i1, Bundle bundle)
    {
        Activity activity = getActivity();
        if (activity != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        switch (i1)
        {
        default:
            throw new IllegalStateException("Bad loader id");

        case 0: // '\0'
            return new CursorLoader(activity, i.g, null, null, null, "merchant, flyer_id, left");

        case 1: // '\001'
            bundle = bundle.getLongArray("item_ids");
            if (bundle != null)
            {
                return l.a(activity, bundle);
            }
            break;

        case 2: // '\002'
            return new CursorLoader(activity, i.q, new String[] {
                "*", "sent", "clipped"
            }, "clipped = 1", null, "deleted ASC, priority ASC");

        case 3: // '\003'
            bundle = bundle.getIntArray("coupon_ids");
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (bundle == null) goto _L1; else goto _L4
_L4:
        return l.a(activity, bundle, true, true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f100000, menu);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        setHasOptionsMenu(true);
        layoutinflater = layoutinflater.inflate(0x7f030008, viewgroup, false);
        if (layoutinflater == null)
        {
            return null;
        }
        e = (ZeroCaseView)layoutinflater.findViewById(0x7f0b003e);
        e.setIcon(0x7f0200d4);
        e.setTitle(0x7f0e00e6);
        e.setSubTitle(0x7f0e00e7);
        d = (CollectionView)layoutinflater.findViewById(0x7f0b003f);
        if (d == null)
        {
            return null;
        }
        d.setEmptyView(e);
        d.setChoiceMode(3);
        d.setMultiChoiceModeListener(a);
        viewgroup = new eg(getActivity());
        viewgroup.b = new h(getActivity(), d);
        d.setLayout(viewgroup);
        if (bundle != null)
        {
            viewgroup = bundle.getIntArray("activatedClippingPositions");
            if (viewgroup != null)
            {
                int j1 = viewgroup.length;
                for (int i1 = 0; i1 < j1; i1++)
                {
                    int k1 = viewgroup[i1];
                    d.a(k1, true);
                }

            }
        }
        viewgroup = (com.wishabi.flipp.app.i)getFragmentManager().findFragmentByTag("EditDialogFragment");
        if (viewgroup != null)
        {
            viewgroup.a = c;
        }
        viewgroup = getLoaderManager();
        if (viewgroup != null)
        {
            viewgroup.initLoader(0, null, this);
            viewgroup.initLoader(2, null, this);
        }
        return layoutinflater;
    }

    public void onHiddenChanged(boolean flag)
    {
        super.onHiddenChanged(flag);
        if (!flag)
        {
            a();
        } else
        if (d != null)
        {
            d.a();
            return;
        }
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        Object obj1;
        Activity activity;
        obj1 = (Cursor)obj;
        activity = getActivity();
        obj = getLoaderManager();
        if (activity == null) goto _L2; else goto _L1
_L1:
        loader.getId();
        JVM INSTR tableswitch 0 3: default 56
    //                   0 67
    //                   1 283
    //                   2 216
    //                   3 298;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        throw new InvalidParameterException("Bad loader id");
_L4:
        if (f == obj1) goto _L2; else goto _L8
_L8:
        f = ((Cursor) (obj1));
        if (obj != null && obj1 != null) goto _L9; else goto _L2
_L2:
        return;
_L9:
        int i1;
        int j1;
        int k1;
        j1 = ((Cursor) (obj1)).getPosition();
        loader = new long[((Cursor) (obj1)).getCount()];
        k1 = ((Cursor) (obj1)).getColumnIndexOrThrow("_id");
        i1 = 0;
        if (!((Cursor) (obj1)).moveToFirst()) goto _L11; else goto _L10
_L10:
        loader[i1] = ((Cursor) (obj1)).getLong(k1);
        if (((Cursor) (obj1)).moveToNext()) goto _L12; else goto _L11
_L11:
        ((Cursor) (obj1)).moveToPosition(j1);
        if (loader.length > 0)
        {
            obj1 = new Bundle();
            ((Bundle) (obj1)).putLongArray("item_ids", loader);
            ((LoaderManager) (obj)).restartLoader(1, ((Bundle) (obj1)), this);
        }
        b();
        if (!isHidden())
        {
            a();
        }
_L15:
        loader = getFragmentManager();
        if (loader == null) goto _L2; else goto _L13
_L13:
        loader.invalidateOptionsMenu();
        return;
_L6:
        if (g == obj1) goto _L2; else goto _L14
_L14:
        g = ((Cursor) (obj1));
        loader = com.wishabi.flipp.util.f.a(((Cursor) (obj1)), "_id");
        if (loader.length > 0)
        {
            obj1 = new Bundle();
            ((Bundle) (obj1)).putIntArray("coupon_ids", loader);
            ((LoaderManager) (obj)).restartLoader(3, ((Bundle) (obj1)), this);
        }
        b();
        if (!isHidden())
        {
            a();
        }
          goto _L15
_L5:
        h = l.a(((Cursor) (obj1)));
        b();
          goto _L15
_L7:
        i = l.b(((Cursor) (obj1)));
        b();
          goto _L15
_L12:
        i1++;
          goto _L10
    }

    public void onLoaderReset(Loader loader)
    {
        switch (loader.getId())
        {
        default:
            throw new InvalidParameterException("Bad loader id");

        case 0: // '\0'
            f = null;
            b();
            return;

        case 1: // '\001'
            h = null;
            b();
            return;

        case 2: // '\002'
            g = null;
            b();
            return;

        case 3: // '\003'
            i = null;
            break;
        }
        b();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (getActivity() == null)
        {
            return super.onOptionsItemSelected(menuitem);
        }
        if (menuitem.getItemId() == 0x7f0b0151)
        {
            a(menuitem.getItemId());
            return true;
        } else
        {
            com.wishabi.flipp.app.i i1 = new com.wishabi.flipp.app.i();
            Bundle bundle = new Bundle();
            bundle.putInt("EDIT_MENU_ITEM_KEY", menuitem.getItemId());
            i1.setArguments(bundle);
            i1.a = c;
            i1.show(getFragmentManager(), "EditDialogFragment");
            return true;
        }
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
        boolean flag3;
        super.onPrepareOptionsMenu(menu);
        MenuItem menuitem;
        boolean flag1;
        boolean flag2;
        if (g != null && g.getCount() > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (f != null && f.getCount() > 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        menuitem = menu.findItem(0x7f0b0152);
        if (a(g).isEmpty())
        {
            Cursor cursor = f;
            ArrayList arraylist = new ArrayList();
            if (cursor != null && cursor.getCount() != 0)
            {
                b b1 = b.a.a.b.a(g.a);
                int i1 = cursor.getColumnIndexOrThrow("_id");
                int j1 = cursor.getColumnIndexOrThrow("valid_to");
                d d1 = aa.a();
                flag3 = cursor.moveToFirst();
                while (flag3) 
                {
                    Object obj = cursor.getString(j1);
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        obj = d1.a(((String) (obj)));
                        long l1 = b.a.a.f.a(b1);
                        boolean flag;
                        if (((b.a.a.a.b) (obj)).a() < l1)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (flag)
                        {
                            arraylist.add(Long.valueOf(cursor.getLong(i1)));
                        }
                    }
                    flag3 = cursor.moveToNext();
                }
            }
            if (arraylist.isEmpty())
            {
                break MISSING_BLOCK_LABEL_332;
            }
        }
        flag3 = true;
_L1:
        menuitem.setEnabled(flag3);
        menuitem = menu.findItem(0x7f0b0151);
        if (flag1 || flag2)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        menuitem.setEnabled(flag3);
        menu.findItem(0x7f0b0154).setEnabled(flag1);
        menu.findItem(0x7f0b0153).setEnabled(flag2);
        return;
        flag3 = false;
          goto _L1
    }

    public void onResume()
    {
        super.onResume();
        if (!isHidden())
        {
            a();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (d == null || d.getActivatedItemPositions() == null)
        {
            bundle.putIntArray("activatedClippingPositions", null);
            return;
        }
        SparseBooleanArray sparsebooleanarray = d.getActivatedItemPositions();
        int ai[] = new int[sparsebooleanarray.size()];
        int i1 = 0;
        for (int j1 = sparsebooleanarray.size(); i1 < j1; i1++)
        {
            ai[i1] = sparsebooleanarray.keyAt(i1);
        }

        bundle.putIntArray("activatedClippingPositions", ai);
    }
}
