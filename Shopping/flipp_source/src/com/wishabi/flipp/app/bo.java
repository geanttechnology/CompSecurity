// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.TextView;
import android.widget.Toast;
import com.a.b.ad;
import com.a.b.aw;
import com.wishabi.flipp.b.o;
import com.wishabi.flipp.content.a;
import com.wishabi.flipp.content.ag;
import com.wishabi.flipp.content.c;
import com.wishabi.flipp.content.l;
import com.wishabi.flipp.util.f;
import com.wishabi.flipp.util.g;
import com.wishabi.flipp.util.i;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.p;
import com.wishabi.flipp.util.q;
import com.wishabi.flipp.widget.FlyerViewGroup;
import com.wishabi.flipp.widget.bi;
import com.wishabi.flipp.widget.bj;
import com.wishabi.flipp.widget.bk;
import com.wishabi.flipp.widget.bl;
import com.wishabi.flipp.widget.bm;
import com.wishabi.flipp.widget.bn;
import com.wishabi.flipp.widget.bv;
import com.wishabi.flipp.widget.dw;
import com.wishabi.flipp.widget.dx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

// Referenced classes of package com.wishabi.flipp.app:
//            bp, bu, dr, bt, 
//            WebVideoActivity, ds, df, ItemDetailsActivity, 
//            fu, fx, WebViewActivity, bv, 
//            bq, br, bw

public class bo extends Fragment
    implements android.app.LoaderManager.LoaderCallbacks
{

    private static final String l = com/wishabi/flipp/app/bo.getSimpleName();
    private final HashMap A = new HashMap();
    bu a;
    FlyerViewGroup b;
    RectF c;
    boolean d;
    int e;
    com.wishabi.flipp.content.Flyer.Model f;
    boolean g;
    final HashMap h = new HashMap();
    final List i = new ArrayList();
    final HashSet j = new HashSet();
    Comparator k;
    private Toast m;
    private String n;
    private String o;
    private boolean p;
    private String q;
    private String r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private HashMap y;
    private final HashSet z = new HashSet();

    public bo()
    {
        v = true;
        w = true;
        x = true;
        k = new bp(this);
    }

    private static String a(String s1)
    {
        SharedPreferences sharedpreferences = com.wishabi.flipp.util.p.a();
        return s1.replace("__FLIPP_POSTAL_CODE__", com.wishabi.flipp.util.k.a("NULL")).replace("__FLIPP_SID__", sharedpreferences.getString("advertising_id", "NULL")).replace("__FLIPP_PUSH_TOKEN__", sharedpreferences.getString("gcm_registration_id", "NULL")).replace("__FLIPP_LOCALE__", Locale.getDefault().toString());
    }

    static void a(bo bo1, String s1)
    {
        if (bo1.a == null) goto _L2; else goto _L1
_L1:
        bo1.a.a(s1);
_L4:
        return;
_L2:
        Object obj = bo1.getActivity();
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (bo1.m != null)
        {
            break; /* Loop/switch isn't completed */
        }
        bo1.m = new Toast(bo1.getActivity());
        bo1.m.setGravity(80, 0, (int)TypedValue.applyDimension(1, 55F, ((Activity) (obj)).getResources().getDisplayMetrics()));
        obj = ((Activity) (obj)).getLayoutInflater().inflate(0x7f03002e, null);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        bo1.m.setView(((View) (obj)));
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        if (s1 == null)
        {
            bo1.m.cancel();
            return;
        } else
        {
            ((TextView)bo1.m.getView().findViewById(0x7f0b00c2)).setText(s1);
            bo1.m.setDuration(0);
            bo1.m.show();
            return;
        }
    }

    static boolean a(bo bo1)
    {
        bo1.v = false;
        return false;
    }

    static boolean a(bo bo1, long l1)
    {
        if (bo1.y != null)
        {
            int ai[] = com.wishabi.flipp.content.a.a((ArrayList)bo1.y.get(Long.valueOf(l1)));
            if (com.wishabi.flipp.app.dr.a(bo1.getActivity(), ai, false, com.wishabi.flipp.b.p.a) != 0)
            {
                return true;
            }
        }
        return false;
    }

    static boolean a(bo bo1, bt bt1)
    {
        Activity activity;
        if (bt1 != null)
        {
            if ((activity = bo1.getActivity()) != null && URLUtil.isValidUrl(bt1.q) && com.wishabi.flipp.util.g.c())
            {
                Object obj = MimeTypeMap.getFileExtensionFromUrl(bt1.q);
                if (!TextUtils.isEmpty(((CharSequence) (obj))) && (((String) (obj)).equalsIgnoreCase("mp4") || ((String) (obj)).equalsIgnoreCase("3gp")))
                {
                    if (TextUtils.isEmpty(bt1.g))
                    {
                        obj = activity.getString(0x7f0e00d3);
                    } else
                    {
                        obj = bt1.g;
                    }
                    obj = com.wishabi.flipp.app.WebVideoActivity.a(((String) (obj)), bt1.q);
                } else
                {
                    obj = new Intent("android.intent.action.VIEW");
                    ((Intent) (obj)).setData(Uri.parse(bt1.q));
                }
                activity.startActivity(((Intent) (obj)));
                activity.overridePendingTransition(0x7f040001, 0x7f040002);
                com.wishabi.flipp.b.a.a.a(bo1.f, bt1.a, o.l);
                return true;
            }
        }
        return false;
    }

    static boolean a(bo bo1, bi bi1)
    {
        Activity activity = bo1.getActivity();
        android.app.FragmentManager fragmentmanager = bo1.getFragmentManager();
        if (activity != null && fragmentmanager != null && bi1 != null)
        {
            bt bt1 = (bt)bi1.c;
            float f1 = (bi1.a.bottom - bi1.a.top) / (bi1.a.right - bi1.a.left);
            String s1 = com.wishabi.flipp.util.q.a(bo1.f.l, bo1.f.m);
            Activity activity1 = bo1.getActivity();
            long l1 = bt1.a;
            int i1;
            if (activity1 == null)
            {
                i1 = 0;
            } else
            if (activity1.getResources().getConfiguration().isLayoutSizeAtLeast(3) && android.os.Build.VERSION.SDK_INT >= 17)
            {
                com.wishabi.flipp.app.df.a(l1, f1).show(activity1.getFragmentManager(), "item_details");
                i1 = ds.b;
            } else
            {
                activity1.startActivity(com.wishabi.flipp.app.ItemDetailsActivity.a(l1, f1, s1));
                activity1.overridePendingTransition(0x7f040001, 0x7f040002);
                i1 = com.wishabi.flipp.app.ds.a;
            }
            if (i1 == com.wishabi.flipp.app.ds.a)
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add(bi1);
                bo1.b.setHighlightAnnotations(arraylist);
            }
            if (i1 != 0)
            {
                return true;
            }
        }
        return false;
    }

    static void b(bo bo1)
    {
        bo1.e();
    }

    static boolean b(bo bo1, long l1)
    {
label0:
        {
            if (bo1.y == null)
            {
                break label0;
            }
            bo1 = (ArrayList)bo1.y.get(Long.valueOf(l1));
            if (bo1 == null || bo1.isEmpty())
            {
                return false;
            }
            bo1 = bo1.iterator();
            do
            {
                if (!bo1.hasNext())
                {
                    break label0;
                }
            } while (!((c)bo1.next()).q);
            return true;
        }
        return false;
    }

    static boolean b(bo bo1, bt bt1)
    {
        if (bt1 != null) goto _L2; else goto _L1
_L1:
        Activity activity;
        return false;
_L2:
        if ((activity = bo1.getActivity()) == null) goto _L1; else goto _L3
_L3:
        if (URLUtil.isValidUrl(bt1.p))
        {
            break; /* Loop/switch isn't completed */
        }
        String s1 = bt1.p;
        boolean flag;
        if (!TextUtils.isEmpty(s1) && s1.startsWith("tel:"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L1; else goto _L4
_L4:
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(a(bt1.p))));
        com.wishabi.flipp.b.a.a.a(bo1.f, bt1.a, o.b);
        return true;
    }

    static bu c(bo bo1)
    {
        return bo1.a;
    }

    static boolean c(bo bo1, bt bt1)
    {
        while (bt1 == null || bo1.getActivity() == null || !URLUtil.isValidUrl(bt1.p) || !com.wishabi.flipp.util.g.c()) 
        {
            return false;
        }
        Object obj = a(bt1.p);
        obj = fu.b().a(((String) (obj))).a().b();
        ((fx) (obj)).a.putBoolean("enable_javascript", true);
        obj = com.wishabi.flipp.app.WebViewActivity.a(((fx) (obj)).a);
        bo1.getActivity().startActivity(((Intent) (obj)));
        bo1.getActivity().overridePendingTransition(0x7f040001, 0x7f040002);
        com.wishabi.flipp.b.a.a.a(bo1.f, bt1.a, o.a);
        return true;
    }

    static FlyerViewGroup d(bo bo1)
    {
        return bo1.b;
    }

    static boolean d(bo bo1, bt bt1)
    {
        if (bt1.r == null)
        {
            return false;
        }
        bt1 = (com.wishabi.flipp.app.bv)bo1.A.get(bt1.r);
        if (bt1 == null || bo1.b == null)
        {
            return false;
        } else
        {
            bo1.b.a(new RectF(((com.wishabi.flipp.app.bv) (bt1)).a, ((com.wishabi.flipp.app.bv) (bt1)).d, ((com.wishabi.flipp.app.bv) (bt1)).c, ((com.wishabi.flipp.app.bv) (bt1)).b), true, false);
            return true;
        }
    }

    private void e()
    {
        ArrayList arraylist;
        Iterator iterator1;
        int l1;
        int i2;
        while (b() || y == null || h.isEmpty()) 
        {
            return;
        }
        Iterator iterator = j.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj2 = (Long)iterator.next();
            if (y.get(obj2) == null)
            {
                FlyerViewGroup flyerviewgroup = b;
                long l2 = ((Long) (obj2)).longValue();
                obj2 = flyerviewgroup.d;
                ((bn) (obj2)).e.remove(Long.valueOf(l2));
                ((bn) (obj2)).invalidate();
            }
        } while (true);
        l1 = -com.wishabi.flipp.util.i.a(4);
        i2 = com.wishabi.flipp.util.i.a(4);
        arraylist = new ArrayList();
        j.clear();
        iterator1 = y.entrySet().iterator();
_L10:
        Object obj1;
        bt bt1;
        long l3;
        boolean flag;
label0:
        {
            Object obj;
            do
            {
                if (!iterator1.hasNext())
                {
                    break MISSING_BLOCK_LABEL_1189;
                }
                l3 = ((Long)((java.util.Map.Entry)iterator1.next()).getKey()).longValue();
                obj = (bi)h.get(Long.valueOf(l3));
            } while (obj == null);
            bt1 = (bt)((bi) (obj)).c;
            boolean flag1 = false;
            obj = (ArrayList)y.get(Long.valueOf(l3));
            flag = flag1;
            if (obj == null)
            {
                break label0;
            }
            obj = ((ArrayList) (obj)).iterator();
            do
            {
                flag = flag1;
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!((c)((Iterator) (obj)).next()).q);
            flag = true;
        }
        Object obj3 = new bl((bj)b.d.e.get(Long.valueOf(l3)), (byte)0);
        float f1;
        float f6;
        int i1;
        if (flag)
        {
            obj1 = (new int[] {
                0x7f020061, 0x7f020062, 0x7f020063, 0x7f020064, 0x7f020065, 0x7f020066, 0x7f020067, 0x7f020068, 0x7f020069, 0x7f02006a, 
                0x7f02006b
            });
        } else
        {
            obj1 = (new int[] {
                0x7f020056, 0x7f020057, 0x7f020058, 0x7f020059, 0x7f02005a, 0x7f02005b, 0x7f02005c, 0x7f02005d, 0x7f02005e, 0x7f02005f, 
                0x7f020060
            });
        }
        obj1 = ((bl) (obj3)).a(((int []) (obj1)));
        obj3 = new PointF(bt1.f, bt1.d);
        i1 = bm.a;
        obj1.c = ((PointF) (obj3));
        obj1.f = i1;
        obj1.g = null;
        f1 = l1;
        f6 = i2;
        obj1.d = f1;
        obj1.e = f6;
        if (((bl) (obj1)).b == null || ((bl) (obj1)).b.isEmpty())
        {
            throw new RuntimeException("Drawables cannot be null or empty");
        }
        if (((bl) (obj1)).f == 0)
        {
            obj1.f = bm.b;
        }
        if (((bl) (obj1)).c == null)
        {
            obj1.c = new PointF(0.0F, 0.0F);
        }
        if (((bl) (obj1)).g != null && !((bl) (obj1)).g.isEmpty()) goto _L2; else goto _L1
_L1:
        Object obj4;
        obj4 = (Drawable)((bl) (obj1)).b.get(0);
        obj1.g = new RectF();
        bk.a[((bl) (obj1)).f - 1];
        JVM INSTR tableswitch 1 5: default 684
    //                   1 774
    //                   2 879
    //                   3 958
    //                   4 1037
    //                   5 1116;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_1116;
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L2:
        obj1 = new bj(((bl) (obj1)), (byte)0);
        obj4 = b.d;
        ((bn) (obj4)).e.put(Long.valueOf(l3), obj1);
        ((bn) (obj4)).invalidate();
        j.add(Long.valueOf(l3));
        arraylist.add(new bi(bt1.e, bt1.d, bt1.f, bt1.c));
        if (true) goto _L10; else goto _L9
_L9:
        int j1 = ((Drawable) (obj4)).getIntrinsicWidth() / 2;
        int k1 = ((Drawable) (obj4)).getIntrinsicHeight() / 2;
        ((bl) (obj1)).g.left = ((bl) (obj1)).c.x - (float)j1;
        ((bl) (obj1)).g.top = ((bl) (obj1)).c.y - (float)k1;
        obj4 = ((bl) (obj1)).g;
        float f2 = ((bl) (obj1)).c.x;
        obj4.right = (float)j1 + f2;
        obj4 = ((bl) (obj1)).g;
        f2 = ((bl) (obj1)).c.y;
        obj4.bottom = (float)k1 + f2;
          goto _L2
_L5:
        ((bl) (obj1)).g.left = ((bl) (obj1)).c.x;
        ((bl) (obj1)).g.top = ((bl) (obj1)).c.y;
        ((bl) (obj1)).g.right = ((bl) (obj1)).c.x + (float)((Drawable) (obj4)).getIntrinsicWidth();
        RectF rectf = ((bl) (obj1)).g;
        float f3 = ((bl) (obj1)).c.y;
        rectf.bottom = (float)((Drawable) (obj4)).getIntrinsicHeight() + f3;
          goto _L2
_L6:
        ((bl) (obj1)).g.left = ((bl) (obj1)).c.x - (float)((Drawable) (obj4)).getIntrinsicWidth();
        ((bl) (obj1)).g.top = ((bl) (obj1)).c.y;
        ((bl) (obj1)).g.right = ((bl) (obj1)).c.x;
        RectF rectf1 = ((bl) (obj1)).g;
        float f4 = ((bl) (obj1)).c.y;
        rectf1.bottom = (float)((Drawable) (obj4)).getIntrinsicHeight() + f4;
          goto _L2
_L7:
        ((bl) (obj1)).g.left = ((bl) (obj1)).c.x;
        ((bl) (obj1)).g.top = ((bl) (obj1)).c.y - (float)((Drawable) (obj4)).getIntrinsicHeight();
        RectF rectf2 = ((bl) (obj1)).g;
        float f5 = ((bl) (obj1)).c.x;
        rectf2.right = (float)((Drawable) (obj4)).getIntrinsicWidth() + f5;
        ((bl) (obj1)).g.bottom = ((bl) (obj1)).c.y;
          goto _L2
        ((bl) (obj1)).g.left = ((bl) (obj1)).c.x - (float)((Drawable) (obj4)).getIntrinsicWidth();
        ((bl) (obj1)).g.top = ((bl) (obj1)).c.y - (float)((Drawable) (obj4)).getIntrinsicHeight();
        ((bl) (obj1)).g.right = ((bl) (obj1)).c.x;
        ((bl) (obj1)).g.bottom = ((bl) (obj1)).c.y;
          goto _L2
        Collections.sort(arraylist, k);
        if (g)
        {
            b.a();
        }
        i.clear();
        i.addAll(h.values());
        i.addAll(arraylist);
        Collections.sort(i, k);
        f();
        return;
    }

    static boolean e(bo bo1)
    {
        return bo1.u;
    }

    static com.wishabi.flipp.content.Flyer.Model f(bo bo1)
    {
        return bo1.f;
    }

    private void f()
    {
        if (b != null && !b() && y != null && !h.isEmpty())
        {
            Object obj = new HashMap();
            Iterator iterator = j.iterator();
label0:
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Long long2 = (Long)iterator.next();
                Object obj3 = (bi)h.get(long2);
                if (obj3 == null)
                {
                    continue;
                }
                obj3 = (bt)((bi) (obj3)).c;
                if (!ag.b(((bt) (obj3)).o))
                {
                    continue;
                }
                Object obj4 = (ArrayList)y.get(long2);
                if (obj4 == null || ((ArrayList) (obj4)).isEmpty())
                {
                    continue;
                }
                obj4 = ((ArrayList) (obj4)).iterator();
                do
                {
                    if (!((Iterator) (obj4)).hasNext())
                    {
                        continue label0;
                    }
                } while (!((c)((Iterator) (obj4)).next()).q);
                ((HashMap) (obj)).put(long2, obj3);
            } while (true);
            iterator = z.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj1 = (Long)iterator.next();
                if (((HashMap) (obj)).get(obj1) == null)
                {
                    FlyerViewGroup flyerviewgroup = b;
                    long l1 = ((Long) (obj1)).longValue();
                    obj1 = flyerviewgroup.b;
                    ((com.wishabi.flipp.widget.bo) (obj1)).c.remove(Long.valueOf(l1));
                    ((com.wishabi.flipp.widget.bo) (obj1)).invalidate();
                }
            } while (true);
            z.clear();
            obj = ((HashMap) (obj)).entrySet().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Object obj2 = (java.util.Map.Entry)((Iterator) (obj)).next();
                Long long1 = (Long)((java.util.Map.Entry) (obj2)).getKey();
                obj2 = (bt)((java.util.Map.Entry) (obj2)).getValue();
                b.a(long1.longValue(), new RectF(((bt) (obj2)).e, ((bt) (obj2)).d, ((bt) (obj2)).f, ((bt) (obj2)).c));
                z.add(long1);
            }
        }
    }

    static boolean g(bo bo1)
    {
        return bo1.w;
    }

    static boolean h(bo bo1)
    {
        return bo1.s;
    }

    static HashMap i(bo bo1)
    {
        return bo1.y;
    }

    public final void a()
    {
        u = true;
        if (b != null)
        {
            com.wishabi.flipp.b.a.a.a(f, b.getVisibleRect(), b.getZoomScale());
        }
    }

    public final boolean b()
    {
        return w && v || x;
    }

    public final void c()
    {
        while (b() || a == null) 
        {
            return;
        }
        bu bu1 = a;
        String s1 = r;
        boolean flag;
        if (!w && !v && !x)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bu1.a(this, s1, flag);
    }

    public final boolean d()
    {
        return !h.isEmpty();
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
            return new CursorLoader(bundle, com.wishabi.flipp.content.i.c, null, "flyer_id = ?", new String[] {
                r
            }, null);

        case 1: // '\001'
            return new CursorLoader(bundle, com.wishabi.flipp.content.i.g, null, "flyer_id = ?", new String[] {
                r
            }, null);

        case 2: // '\002'
            return com.wishabi.flipp.content.l.a(bundle, "flyer_item_coupons.flyer_id = ?", new String[] {
                Integer.toString(Integer.valueOf(r).intValue())
            }, false);

        case 3: // '\003'
            return new CursorLoader(bundle, com.wishabi.flipp.content.i.d, null, "flyer_id = ?", new String[] {
                r
            }, null);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03002a, viewgroup, false);
        if (layoutinflater == null)
        {
            return null;
        }
        b = (FlyerViewGroup)layoutinflater.findViewById(0x7f0b00b2);
        if (bundle != null)
        {
            c = (RectF)bundle.getParcelable("mInitialRect");
            f = (com.wishabi.flipp.content.Flyer.Model)bundle.getParcelable("mFlyerModel");
        }
        viewgroup = getActivity();
        if (viewgroup != null && f != null && c != null) goto _L2; else goto _L1
_L1:
        if (u)
        {
            a();
        }
        return layoutinflater;
_L2:
        r = String.valueOf(f.a);
        bundle = com.wishabi.flipp.util.k.a(null);
        v = true;
        w = true;
        x = true;
        (new bq(this, viewgroup.getContentResolver(), bundle, r, viewgroup)).execute(new Void[0]);
        q = f.m;
        n = f.g;
        o = f.h;
        p = f.e;
        bundle = b;
        String s1 = f.k;
        float af[] = f.q;
        int i1 = f.i.intValue();
        int j1 = f.j.intValue();
        bundle.e = i1;
        bundle.f = j1;
        ((FlyerViewGroup) (bundle)).a.a(s1, af, i1, j1);
        bundle = ((FlyerViewGroup) (bundle)).d;
        bundle.c = i1;
        bundle.d = j1;
        t = f.n;
        b.scrollTo(0, 0);
        if (!c.isEmpty())
        {
            b.setInitialRect(c);
            c.setEmpty();
        }
        b.setFlyerViewListener(new br(this, viewgroup));
        viewgroup = getLoaderManager();
        if (viewgroup != null)
        {
            viewgroup.initLoader(0, null, this);
            viewgroup.initLoader(1, null, this);
            viewgroup.initLoader(2, null, this);
            viewgroup.initLoader(3, null, this);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onDestroy()
    {
        super.onDestroy();
        FlyerViewGroup flyerviewgroup = b;
        Object obj = flyerviewgroup.a;
        java.util.Map.Entry entry;
        for (Iterator iterator = ((dw) (obj)).e.entrySet().iterator(); iterator.hasNext(); ((dw) (obj)).c.a((aw)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
            ((dx)entry.getValue()).c = null;
        }

        for (Iterator iterator1 = ((dw) (obj)).d.entrySet().iterator(); iterator1.hasNext();)
        {
            ((dx)((java.util.Map.Entry)iterator1.next()).getValue()).c = null;
        }

        for (Iterator iterator2 = ((dw) (obj)).f.iterator(); iterator2.hasNext();)
        {
            ((dx)iterator2.next()).c = null;
        }

        ((dw) (obj)).e.clear();
        ((dw) (obj)).d.clear();
        ((dw) (obj)).f.clear();
        flyerviewgroup.b.c.clear();
        obj = flyerviewgroup.c;
        obj.a = null;
        obj.b = null;
        flyerviewgroup.d.e.clear();
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        obj = (Cursor)obj;
        loader.getId();
        JVM INSTR tableswitch 0 3: default 40
    //                   0 41
    //                   1 682
    //                   2 869
    //                   3 891;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        s = false;
        int j1 = ((Cursor) (obj)).getColumnIndexOrThrow("_id");
        int k1 = ((Cursor) (obj)).getColumnIndexOrThrow("flyer_id");
        int l1 = ((Cursor) (obj)).getColumnIndexOrThrow("bottom");
        int i2 = ((Cursor) (obj)).getColumnIndexOrThrow("top");
        int j2 = ((Cursor) (obj)).getColumnIndexOrThrow("left");
        int k2 = ((Cursor) (obj)).getColumnIndexOrThrow("right");
        int l2 = ((Cursor) (obj)).getColumnIndexOrThrow("name");
        int i3 = ((Cursor) (obj)).getColumnIndexOrThrow("short_name");
        int j3 = ((Cursor) (obj)).getColumnIndexOrThrow("discount");
        int k3 = ((Cursor) (obj)).getColumnIndexOrThrow("price");
        int l3 = ((Cursor) (obj)).getColumnIndexOrThrow("thumbnail");
        int i4 = ((Cursor) (obj)).getColumnIndexOrThrow("display_type");
        int j4 = ((Cursor) (obj)).getColumnIndexOrThrow("ttm_url");
        int k4 = ((Cursor) (obj)).getColumnIndexOrThrow("video_url");
        int l4 = ((Cursor) (obj)).getColumnIndexOrThrow("page_destination");
        loader = new ArrayList();
        boolean flag4 = ((Cursor) (obj)).moveToFirst();
        boolean flag1 = true;
        int i1 = 0;
        while (flag4) 
        {
            s = true;
            bt bt1 = new bt((byte)0);
            bt1.a = ((Cursor) (obj)).getLong(j1);
            bt1.b = ((Cursor) (obj)).getInt(k1);
            bt1.c = ((Cursor) (obj)).getFloat(l1);
            bt1.d = ((Cursor) (obj)).getFloat(i2);
            bt1.e = ((Cursor) (obj)).getFloat(j2);
            bt1.f = ((Cursor) (obj)).getFloat(k2);
            bt1.g = n;
            bt1.h = o;
            bt1.i = p;
            bt1.j = ((Cursor) (obj)).getString(l2);
            bt1.k = ((Cursor) (obj)).getString(i3);
            bt1.l = ((Cursor) (obj)).getString(k3);
            bt1.m = ((Cursor) (obj)).getString(l3);
            bt1.n = q;
            bt1.o = ((Cursor) (obj)).getInt(i4);
            bt1.p = ((Cursor) (obj)).getString(j4);
            bt1.q = ((Cursor) (obj)).getString(k4);
            bt1.r = com.wishabi.flipp.util.f.c(((Cursor) (obj)), l4);
            float f1 = ((Cursor) (obj)).getFloat(j3);
            if (f1 > 0.0F)
            {
                i1++;
            }
            boolean flag;
            if (bt1.l == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            loader.add(new bi(bt1.e, bt1.d, bt1.f, bt1.c, f1, bt1.l, bt1, 0));
            flag4 = ((Cursor) (obj)).moveToNext();
            flag1 &= flag;
        }
        d = flag1;
        e = i1;
        Collections.sort(loader, k);
        b.setTapAnnotations(loader);
        h.clear();
        bt bt2;
        for (loader = loader.iterator(); loader.hasNext(); h.put(Long.valueOf(bt2.a), obj))
        {
            obj = (bi)loader.next();
            bt2 = (bt)((bi) (obj)).c;
        }

        if (!h.isEmpty())
        {
            w = false;
        }
        e();
        c();
        return;
_L3:
        loader = b.b;
        ((com.wishabi.flipp.widget.bo) (loader)).c.clear();
        loader.invalidate();
        for (boolean flag2 = ((Cursor) (obj)).moveToFirst(); flag2; flag2 = ((Cursor) (obj)).moveToNext())
        {
            loader = new RectF();
            loader.left = ((Cursor) (obj)).getFloat(((Cursor) (obj)).getColumnIndexOrThrow("left"));
            loader.top = ((Cursor) (obj)).getFloat(((Cursor) (obj)).getColumnIndexOrThrow("top"));
            loader.right = ((Cursor) (obj)).getFloat(((Cursor) (obj)).getColumnIndexOrThrow("right"));
            loader.bottom = ((Cursor) (obj)).getFloat(((Cursor) (obj)).getColumnIndexOrThrow("bottom"));
            long l5 = ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndexOrThrow("_id"));
            b.a(l5, loader);
            if (z.contains(Long.valueOf(l5)))
            {
                z.remove(Long.valueOf(l5));
            }
        }

        f();
        return;
_L4:
        y = com.wishabi.flipp.content.l.a(((Cursor) (obj)));
        x = false;
        e();
        c();
        return;
_L5:
        A.clear();
        loader = new bw(((Cursor) (obj)), (byte)0);
        boolean flag3 = ((Cursor) (obj)).moveToFirst();
        while (flag3) 
        {
            com.wishabi.flipp.app.bv bv1 = new com.wishabi.flipp.app.bv(loader, ((Cursor) (obj)));
            A.put(Integer.valueOf(bv1.e), bv1);
            flag3 = ((Cursor) (obj)).moveToNext();
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void onLoaderReset(Loader loader)
    {
        switch (loader.getId())
        {
        case 1: // '\001'
        default:
            return;

        case 0: // '\0'
            b.setTapAnnotations(null);
            w = true;
            h.clear();
            i.clear();
            return;

        case 2: // '\002'
            x = true;
            y = null;
            i.clear();
            return;

        case 3: // '\003'
            A.clear();
            break;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("mInitialRect", c);
        bundle.putParcelable("mFlyerModel", f);
    }

}
