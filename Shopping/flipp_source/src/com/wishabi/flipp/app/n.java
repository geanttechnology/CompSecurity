// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import android.widget.Toast;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.p;
import com.wishabi.flipp.content.c;
import com.wishabi.flipp.content.d;
import com.wishabi.flipp.content.l;
import com.wishabi.flipp.content.o;
import com.wishabi.flipp.util.f;
import com.wishabi.flipp.util.i;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.q;
import com.wishabi.flipp.widget.aa;
import com.wishabi.flipp.widget.ae;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.app:
//            dl, m, s, t, 
//            FlippApplication, o, r

public class n extends dl
    implements android.app.LoaderManager.LoaderCallbacks
{

    private static final String a = com/wishabi/flipp/app/n.getSimpleName();
    private RecyclerView c;
    private View d;
    private int e[];
    private boolean f;
    private boolean g;
    private p h;
    private int i;
    private Cursor j;
    private aa k;
    private HashMap l;
    private HashMap m;
    private ae n;

    public n()
    {
    }

    public static Bundle a(int ai[], boolean flag, p p1)
    {
        Bundle bundle = new Bundle();
        bundle.putIntArray("SAVE_STATE_COUPON_IDS_KEY", ai);
        bundle.putBoolean("SAVE_STATE_SHOW_ASSOCIATION_KEY", flag);
        bundle.putInt("SAVE_STATE_SOURCE", p1.j);
        return bundle;
    }

    public static n a(Bundle bundle)
    {
        n n1 = new n();
        n1.setArguments(bundle);
        return n1;
    }

    static aa a(n n1)
    {
        return n1.k;
    }

    static HashMap a(n n1, HashMap hashmap)
    {
        n1.m = hashmap;
        return hashmap;
    }

    static void a(n n1, int i1)
    {
        Object obj = n1.getActivity();
        if (obj != null && n1.k != null && n1.l != null)
        {
            c c1 = n1.k.d(i1);
            if (c1 != null)
            {
                n1 = (ArrayList)n1.l.get(Integer.valueOf(c1.a));
                a a1 = a.a;
                if (c1 != null)
                {
                    HashMap hashmap = new HashMap();
                    hashmap.put("coupon_id", Integer.toString(c1.a));
                    if (n1 != null && !n1.isEmpty())
                    {
                        ArrayList arraylist = new ArrayList();
                        for (n1 = n1.iterator(); n1.hasNext(); arraylist.add(Integer.valueOf(((o)n1.next()).a))) { }
                        n1 = q.a(arraylist, ",");
                    } else
                    {
                        n1 = "";
                    }
                    hashmap.put("matchup_ids", n1);
                    a1.a("matchup_feedback", hashmap, false);
                }
                n1 = View.inflate(((android.content.Context) (obj)), 0x7f030046, null);
                if (n1 != null)
                {
                    ((TextView)n1.findViewById(0x7f0b00c2)).setText(0x7f0e0080);
                    obj = new Toast(((android.content.Context) (obj)));
                    ((Toast) (obj)).setView(n1);
                    ((Toast) (obj)).setGravity(80, 0, com.wishabi.flipp.util.i.a(10));
                    ((Toast) (obj)).setDuration(0);
                    ((Toast) (obj)).show();
                }
            }
        }
    }

    static HashMap b(n n1)
    {
        return n1.l;
    }

    private void b()
    {
        Activity activity;
        for (activity = getActivity(); activity == null || j == null || m == null || f && l == null;)
        {
            return;
        }

        Object obj1 = new d(j);
        Object obj = new ArrayList();
        j.moveToFirst();
        for (int i1 = 0; !j.isAfterLast(); i1++)
        {
            ((List) (obj)).add(new Pair(Integer.valueOf(i1), new c(j, ((d) (obj1)))));
            j.moveToNext();
        }

        Collections.sort(((List) (obj)), new m(l));
        obj1 = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((ArrayList) (obj1)).add(((Pair)((Iterator) (obj)).next()).second)) { }
        k = new aa(activity, ((List) (obj1)), l, m, n);
        c.a(k);
        if (!g)
        {
            a.a.a(((ArrayList) (obj1)), com.wishabi.flipp.b.q.a, h);
            g = true;
        }
        d.animate().alpha(0.0F).setDuration(i).setListener(new s(this));
        com.wishabi.flipp.app.FlippApplication.a(new t(this));
    }

    static HashMap c(n n1)
    {
        return n1.m;
    }

    static void d(n n1)
    {
        n1.b();
    }

    static View e(n n1)
    {
        return n1.d;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = getArguments();
        }
        if (bundle1 != null)
        {
            e = bundle1.getIntArray("SAVE_STATE_COUPON_IDS_KEY");
            f = bundle1.getBoolean("SAVE_STATE_SHOW_ASSOCIATION_KEY");
            h = p.a(bundle1.getInt("SAVE_STATE_SOURCE", -1));
            g = bundle1.getBoolean("SAVE_STATE_SENT_ANALYTICS");
        }
        i = getResources().getInteger(0x10e0000);
    }

    public Loader onCreateLoader(int i1, Bundle bundle)
    {
        bundle = getActivity();
        String s2;
        String as1[];
        if (bundle != null)
        {
            if (!TextUtils.isEmpty(s2 = com.wishabi.flipp.util.k.a(null)) && !com.wishabi.flipp.util.a.a(as1 = q.a(e)))
            {
                switch (i1)
                {
                default:
                    throw new InvalidParameterException((new StringBuilder("Invalid loader id ")).append(i1).toString());

                case 0: // '\0'
                    android.net.Uri uri = com.wishabi.flipp.content.i.q;
                    String s1 = (new StringBuilder()).append(com.wishabi.flipp.util.f.a("c._id", as1)).append(" AND postal_code = ? AND deleted = 0").toString();
                    String as[] = com.wishabi.flipp.util.a.a(as1, new String[] {
                        s2
                    });
                    return new CursorLoader(bundle, uri, new String[] {
                        "*", "clipped", "sent"
                    }, s1, as, "priority ASC, available_from DESC, _id DESC");

                case 1: // '\001'
                    return com.wishabi.flipp.content.l.a(bundle, e, false, false);
                }
            }
        }
        return null;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        if (getActivity() != null)
        {
            setHasOptionsMenu(true);
            layoutinflater = layoutinflater.inflate(0x7f03001c, viewgroup, false);
            if (layoutinflater != null)
            {
                c = (RecyclerView)layoutinflater.findViewById(0x7f0b0077);
                c.setLayoutManager(new LinearLayoutManager());
                d = layoutinflater.findViewById(0x7f0b0078);
                n = new com.wishabi.flipp.app.o(this);
                if (e != null)
                {
                    int i1 = e.length;
                    if (i1 == 1)
                    {
                        b(getString(0x7f0e0078));
                    } else
                    {
                        b(getString(0x7f0e0079, new Object[] {
                            Integer.valueOf(i1)
                        }));
                    }
                }
                return layoutinflater;
            }
        }
        return null;
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
label0:
        {
            obj = (Cursor)obj;
            if (getLoaderManager() != null)
            {
                (new StringBuilder("on load finished ")).append(loader.getId());
                switch (loader.getId())
                {
                default:
                    throw new IllegalStateException("Invalid loader id");

                case 1: // '\001'
                    break label0;

                case 0: // '\0'
                    if (j != obj)
                    {
                        j = ((Cursor) (obj));
                        if (obj != null)
                        {
                            b();
                        }
                    }
                    break;
                }
            }
            return;
        }
        l = com.wishabi.flipp.content.l.a(((Cursor) (obj)), true);
        b();
    }

    public void onLoaderReset(Loader loader)
    {
        (new StringBuilder("on load reset ")).append(loader.getId());
        switch (loader.getId())
        {
        default:
            throw new IllegalStateException("Invalid loader id");

        case 0: // '\0'
            j = null;
            k = null;
            return;

        case 1: // '\001'
            l = null;
            break;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        Activity activity = getActivity();
        if (activity == null)
        {
            return super.onOptionsItemSelected(menuitem);
        }
        if (menuitem.getItemId() == 0x7f0b0158)
        {
            menuitem = new Intent("android.intent.action.SEND");
            menuitem.putExtra("android.intent.extra.TEXT", "TODO coupon share message here");
            menuitem.setType("text/plain");
            activity.startActivity(Intent.createChooser(menuitem, null));
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (getActivity() != null)
        {
            LoaderManager loadermanager = getLoaderManager();
            if (loadermanager != null)
            {
                String s1 = com.wishabi.flipp.util.k.a(null);
                if (s1 != null)
                {
                    loadermanager.initLoader(0, null, this);
                    if (f)
                    {
                        loadermanager.initLoader(1, null, this);
                    }
                    (new r(this, e, s1)).execute(new Void[0]);
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putIntArray("SAVE_STATE_COUPON_IDS_KEY", e);
        bundle.putBoolean("SAVE_STATE_SHOW_ASSOCIATION_KEY", f);
        bundle.putInt("SAVE_STATE_SOURCE", h.j);
        bundle.putBoolean("SAVE_STATE_SENT_ANALYTICS", g);
    }

}
