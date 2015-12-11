// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ch;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.content.FormattedString;
import com.wishabi.flipp.content.ab;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.util.q;
import com.wishabi.flipp.widget.FlyerToolbar;
import com.wishabi.flipp.widget.FlyerViewGroup;
import com.wishabi.flipp.widget.ShoppingListPopup;
import com.wishabi.flipp.widget.bh;
import com.wishabi.flipp.widget.bi;
import com.wishabi.flipp.widget.dr;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.app:
//            dq, bf, bg, bh, 
//            bo, bn, FlippApplication, fq, 
//            fp, dp, bi, bm, 
//            bl, cd, ds, FlyerInfoActivity, 
//            fn

public class FlyerCarouselFragment extends Fragment
    implements android.app.LoaderManager.LoaderCallbacks, dq
{

    private static final String k = com/wishabi/flipp/app/FlyerCarouselFragment.getSimpleName();
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    final ch a = new com.wishabi.flipp.app.bh(this);
    bn b;
    Bundle c;
    Parcelable d[];
    VerticalViewPager e;
    int f;
    boolean g;
    String h;
    Integer i;
    int j;
    private final bh l = new bf(this);
    private final dr m = new bg(this);
    private boolean n;
    private View o;
    private FlyerToolbar p;
    private ShoppingListPopup q;
    private int r;
    private Toast s;
    private Menu t;
    private MenuItem u;
    private MenuItem v;
    private boolean w;
    private boolean x;
    private com.wishabi.flipp.content.Flyer.Model y;
    private bo z;

    public FlyerCarouselFragment()
    {
    }

    static bo a(FlyerCarouselFragment flyercarouselfragment, bo bo1)
    {
        flyercarouselfragment.z = bo1;
        return bo1;
    }

    static com.wishabi.flipp.content.Flyer.Model a(FlyerCarouselFragment flyercarouselfragment, com.wishabi.flipp.content.Flyer.Model model)
    {
        flyercarouselfragment.y = model;
        return model;
    }

    static String a(FlyerCarouselFragment flyercarouselfragment, String s1)
    {
        flyercarouselfragment.h = s1;
        return s1;
    }

    private void a()
    {
        Object obj;
        Object obj1;
        Iterator iterator;
        boolean flag1;
        flag1 = true;
        if (z == null)
        {
            return;
        }
        obj1 = (FlyerViewGroup)z.getView();
        if (obj1 == null)
        {
            p.setForwardEnabled(false);
            p.setBackwardEnabled(false);
            return;
        }
        obj = ((FlyerViewGroup) (obj1)).getHighlightAnnotations();
        if (obj == null || ((List) (obj)).isEmpty())
        {
            p.setForwardEnabled(false);
            p.setBackwardEnabled(false);
            return;
        }
        obj1 = ((FlyerViewGroup) (obj1)).getVisibleRect();
        iterator = ((List) (obj)).iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (((bi)iterator.next()).a.left <= ((RectF) (obj1)).right) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L11:
        p.setForwardEnabled(flag);
        obj = ((List) (obj)).iterator();
_L8:
        if (!((Iterator) (obj)).hasNext()) goto _L6; else goto _L5
_L5:
        if (((bi)((Iterator) (obj)).next()).a.right >= ((RectF) (obj1)).left) goto _L8; else goto _L7
_L7:
        flag = flag1;
_L9:
        p.setBackwardEnabled(flag);
        return;
_L6:
        flag = false;
        if (true) goto _L9; else goto _L2
_L2:
        flag = false;
        if (true) goto _L11; else goto _L10
_L10:
    }

    static void a(FlyerCarouselFragment flyercarouselfragment, int i1)
    {
        if (flyercarouselfragment.o != null)
        {
            com.wishabi.flipp.content.Flyer.Model model = (com.wishabi.flipp.content.Flyer.Model)flyercarouselfragment.d[i1];
            ((TextView)flyercarouselfragment.o.findViewById(0x7f0b0143)).setText(model.g);
            ((TextView)flyercarouselfragment.o.findViewById(0x7f0b0144)).setText(com.wishabi.flipp.util.q.a(model.l, model.m));
            if (flyercarouselfragment.b != null)
            {
                flyercarouselfragment.b.a(flyercarouselfragment.o, model);
            }
        }
    }

    static void a(FlyerCarouselFragment flyercarouselfragment, int i1, boolean flag, boolean flag1)
    {
        if (flyercarouselfragment.z == null || flyercarouselfragment.p == null) goto _L2; else goto _L1
_L1:
        FlyerViewGroup flyerviewgroup = (FlyerViewGroup)flyercarouselfragment.z.getView();
        if (flyerviewgroup == null) goto _L2; else goto _L3
_L3:
        flyercarouselfragment.r = i1;
        if (flyercarouselfragment.r != 0 || flyercarouselfragment.B) goto _L5; else goto _L4
_L4:
        flyerviewgroup.setHighlightAnnotations(null);
        flyercarouselfragment.a();
        flyercarouselfragment.a(((String) (null)));
_L2:
        return;
_L5:
        Object obj;
label0:
        {
            ArrayList arraylist = new ArrayList();
            obj = flyercarouselfragment.z.i.iterator();
            int j1 = 0;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                bi bi1 = (bi)((Iterator) (obj)).next();
                int k1 = bi1.d;
                if (k1 == 0)
                {
                    if (flyercarouselfragment.r > 0 && bi1.b >= (float)flyercarouselfragment.r)
                    {
                        arraylist.add(bi1);
                        j1++;
                    }
                } else
                if (k1 == 1 && flyercarouselfragment.B)
                {
                    arraylist.add(bi1);
                }
            } while (true);
            flyerviewgroup.setHighlightAnnotations(arraylist);
            flyercarouselfragment.a();
            if (!flag)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (j1 > 0)
            {
                if (i1 >= 6)
                {
                    obj = flyercarouselfragment.getResources().getQuantityString(0x7f0d0003, j1, new Object[] {
                        Integer.valueOf(j1), Integer.valueOf(i1)
                    });
                } else
                {
                    if (i1 <= 0)
                    {
                        break label0;
                    }
                    obj = flyercarouselfragment.getResources().getQuantityString(0x7f0d0002, j1, new Object[] {
                        Integer.valueOf(j1)
                    });
                }
            } else
            if (flyercarouselfragment.g && flyercarouselfragment.z.d() && flyercarouselfragment.z.d)
            {
                obj = flyercarouselfragment.getString(0x7f0e0102);
            } else
            if (flyercarouselfragment.g && !flyercarouselfragment.z.d())
            {
                obj = flyercarouselfragment.getString(0x7f0e00f0);
            } else
            if (!flyercarouselfragment.z.d())
            {
                obj = flyercarouselfragment.getString(0x7f0e00ef);
            } else
            {
                if (j1 != 0 || i1 <= 0)
                {
                    break label0;
                }
                obj = flyercarouselfragment.getString(0x7f0e00da, new Object[] {
                    Integer.valueOf(i1)
                });
            }
        }
_L7:
        flyercarouselfragment.a(((String) (obj)));
        if (!flag1 || flyerviewgroup.getVisibleHighlightAnnotations().size() != 0 || arraylist.isEmpty()) goto _L2; else goto _L6
_L6:
        flyercarouselfragment.l.a();
        return;
        obj = null;
          goto _L7
    }

    private void a(String s1)
    {
        Activity activity = getActivity();
        if (activity != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        View view;
        if (s != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if ((view = activity.getLayoutInflater().inflate(0x7f03002e, null)) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = new Toast(getActivity());
        s.setView(view);
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        float f1;
        int i1;
        if (q.isShown())
        {
            f1 = 100F;
        } else
        {
            f1 = 55F;
        }
        i1 = (int)TypedValue.applyDimension(1, f1, activity.getResources().getDisplayMetrics());
        s.setGravity(80, 0, i1);
        if (s1 == null)
        {
            s.cancel();
            return;
        } else
        {
            ((TextView)s.getView().findViewById(0x7f0b00c2)).setText(s1);
            s.setDuration(0);
            s.show();
            return;
        }
    }

    static boolean a(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.B;
    }

    static boolean a(FlyerCarouselFragment flyercarouselfragment, boolean flag)
    {
        flyercarouselfragment.B = flag;
        return flag;
    }

    static int b(FlyerCarouselFragment flyercarouselfragment, int i1)
    {
        flyercarouselfragment.f = i1;
        return i1;
    }

    static bo b(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.z;
    }

    private void b()
    {
        if (t != null && y != null)
        {
            if (u == null)
            {
                u = t.findItem(0x7f0b015f);
            }
            int i1;
            if (u != null)
            {
                MenuItem menuitem = u;
                if (y.p)
                {
                    i1 = 0x7f0200cb;
                } else
                {
                    i1 = 0x7f0200ca;
                }
                menuitem.setIcon(i1);
            }
            if (v == null)
            {
                v = t.findItem(0x7f0b015e);
            }
            if (v != null)
            {
                menuitem = v;
                if (x)
                {
                    i1 = 0x7f0200d3;
                } else
                {
                    i1 = 0x7f0200d2;
                }
                menuitem.setIcon(i1);
                return;
            }
        }
    }

    static void b(FlyerCarouselFragment flyercarouselfragment, String s1)
    {
        flyercarouselfragment.a(s1);
    }

    static boolean b(FlyerCarouselFragment flyercarouselfragment, boolean flag)
    {
        flyercarouselfragment.g = flag;
        return flag;
    }

    static int c(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.r;
    }

    static boolean c(FlyerCarouselFragment flyercarouselfragment, boolean flag)
    {
        flyercarouselfragment.D = flag;
        return flag;
    }

    static com.wishabi.flipp.content.Flyer.Model d(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.y;
    }

    static void d(FlyerCarouselFragment flyercarouselfragment, boolean flag)
    {
        FragmentManager fragmentmanager;
label0:
        {
            if (flyercarouselfragment.D && flyercarouselfragment.isResumed())
            {
                flyercarouselfragment.D = false;
                fragmentmanager = flyercarouselfragment.getFragmentManager();
                if (fragmentmanager != null)
                {
                    Context context = FlippApplication.b();
                    int i1;
                    int j1;
                    if (context == null)
                    {
                        i1 = fq.c;
                    } else
                    {
                        i1 = com.wishabi.flipp.app.fp.a(fragmentmanager, "tap_to_hold_tutorial", "tutorial_showed_tap_to_clip", new FormattedString(new com.wishabi.flipp.content.FormattedString.Part[] {
                            new com.wishabi.flipp.content.FormattedString.Part(context.getString(0x7f0e0153), new com.wishabi.flipp.content.FormattedString.Format[] {
                                new com.wishabi.flipp.content.FormattedString.Format(ab.a)
                            }), new com.wishabi.flipp.content.FormattedString.Part(context.getString(0x7f0e0154), new com.wishabi.flipp.content.FormattedString.Format[] {
                                new com.wishabi.flipp.content.FormattedString.Format(ab.b)
                            })
                        }), 0x7f0200fa, 0x7f0200f8, flyercarouselfragment);
                    }
                    if (i1 == fq.b)
                    {
                        flyercarouselfragment.E = flag;
                    }
                    j1 = i1;
                    if (i1 == com.wishabi.flipp.app.fq.a)
                    {
                        j1 = i1;
                        if (flag)
                        {
                            j1 = com.wishabi.flipp.app.fp.a(fragmentmanager);
                        }
                    }
                    if (j1 == com.wishabi.flipp.app.fq.a && flyercarouselfragment.d != null && flyercarouselfragment.d.length > 1)
                    {
                        flyercarouselfragment = FlippApplication.b();
                        if (flyercarouselfragment != null)
                        {
                            break label0;
                        }
                        i1 = fq.c;
                    }
                }
            }
            return;
        }
        com.wishabi.flipp.app.fp.a(fragmentmanager, null, "tutorial_showed_cross_browse", new FormattedString(new com.wishabi.flipp.content.FormattedString.Part[] {
            new com.wishabi.flipp.content.FormattedString.Part(flyercarouselfragment.getString(0x7f0e014c), new com.wishabi.flipp.content.FormattedString.Format[] {
                new com.wishabi.flipp.content.FormattedString.Format(ab.a)
            }), new com.wishabi.flipp.content.FormattedString.Part(flyercarouselfragment.getString(0x7f0e014d), new com.wishabi.flipp.content.FormattedString.Format[] {
                new com.wishabi.flipp.content.FormattedString.Format(ab.b)
            })
        }), 0x7f0200f6, 0x7f0200f8, null);
    }

    static Parcelable[] e(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.d;
    }

    static VerticalViewPager f(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.e;
    }

    static void g(FlyerCarouselFragment flyercarouselfragment)
    {
        flyercarouselfragment.b();
    }

    static boolean h(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.n;
    }

    static boolean i(FlyerCarouselFragment flyercarouselfragment)
    {
        flyercarouselfragment.n = true;
        return true;
    }

    static boolean j(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.w;
    }

    static boolean k(FlyerCarouselFragment flyercarouselfragment)
    {
        flyercarouselfragment.w = false;
        return false;
    }

    static String l(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.h;
    }

    static boolean m(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.C;
    }

    static boolean n(FlyerCarouselFragment flyercarouselfragment)
    {
        flyercarouselfragment.C = false;
        return false;
    }

    static FlyerToolbar o(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.p;
    }

    static Bundle p(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.c;
    }

    static int q(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.j;
    }

    static ShoppingListPopup r(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.q;
    }

    static void s(FlyerCarouselFragment flyercarouselfragment)
    {
        flyercarouselfragment.a();
    }

    static bh t(FlyerCarouselFragment flyercarouselfragment)
    {
        return flyercarouselfragment.l;
    }

    static boolean u(FlyerCarouselFragment flyercarouselfragment)
    {
        flyercarouselfragment.A = false;
        return false;
    }

    public final void a(dp dp1)
    {
        if (getFragmentManager() != null)
        {
            if (!TextUtils.isEmpty(dp1 = dp1.getTag()) && dp1.equals("tap_to_hold_tutorial") && isResumed())
            {
                if (E)
                {
                    com.wishabi.flipp.app.fp.a(getFragmentManager());
                }
                E = false;
                return;
            }
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
            return new CursorLoader(bundle, i.f, null, "_id = ?", new String[] {
                Integer.toString(f)
            }, null);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        menuinflater.inflate(0x7f100006, menu);
        t = menu;
        v = null;
        u = null;
        b();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(0x7f030027, viewgroup, false);
        if (viewgroup == null)
        {
            return null;
        }
        setHasOptionsMenu(true);
        n = false;
        o = layoutinflater.inflate(0x7f030053, null);
        e = (VerticalViewPager)viewgroup.findViewById(0x7f0b00ab);
        if (e == null)
        {
            return null;
        }
        e.setOnPageChangeListener(a);
        e.setAdapter(new com.wishabi.flipp.app.bi(this, getFragmentManager()));
        p = (FlyerToolbar)viewgroup.findViewById(0x7f0b00ac);
        if (p == null)
        {
            return null;
        }
        a();
        p.setFlyerToolbarListener(l);
        q = (ShoppingListPopup)viewgroup.findViewById(0x7f0b00ad);
        if (q == null)
        {
            return null;
        }
        q.setShoppingListPopupListener(m);
        q.a(false);
        j = com.wishabi.flipp.app.bm.a;
        if (bundle == null)
        {
            B = false;
            C = false;
        } else
        {
            r = bundle.getInt("SAVE_STATE_DISCOUNT_KEY");
            w = true;
            n = bundle.getBoolean("SAVE_STATE_CROSS_BROWSE_KEY");
            i = Integer.valueOf(bundle.getInt("SAVE_STATE_CAROUSEL_POSITION_KEY"));
            int i1 = bundle.getInt("flyer_mode", -1);
            if (i1 != -1)
            {
                j = com.wishabi.flipp.app.bm.a()[i1];
            }
            B = bundle.getBoolean("SAVE_STATE_HIGHLIGHT_COUPON_KEY", false);
            boolean flag;
            if (!bundle.getBoolean("SAVE_STATE_SHOW_TUTORIAL_KEY", true))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            C = flag;
            E = bundle.getBoolean("SAVE_STATE_SHOW_COUPON_TUTORIAL_ON_DISMISS_KEY", false);
        }
        p.setShowCoupon(B);
        return viewgroup;
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        obj = (Cursor)obj;
        switch (loader.getId())
        {
        default:
            return;

        case 0: // '\0'
            break;
        }
        boolean flag;
        if (((Cursor) (obj)).getCount() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x = flag;
        b();
    }

    public void onLoaderReset(Loader loader)
    {
        switch (loader.getId())
        {
        default:
            return;

        case 0: // '\0'
            x = false;
            break;
        }
        b();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        boolean flag1 = true;
        Activity activity = getActivity();
        if (activity == null)
        {
            flag1 = super.onOptionsItemSelected(menuitem);
        } else
        if (menuitem.getItemId() == 0x7f0b015f && !A)
        {
            A = true;
            Object obj;
            int i1;
            boolean flag;
            boolean flag2;
            if (z != null && z.d)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i1 = y.a;
            obj = y.g;
            flag2 = g;
            menuitem = new bl(this);
            if (activity != null)
            {
                if (activity.getResources().getConfiguration().isLayoutSizeAtLeast(3) && android.os.Build.VERSION.SDK_INT >= 17)
                {
                    obj = com.wishabi.flipp.app.cd.a(i1, ((String) (obj)), flag2, flag);
                    obj.a = menuitem;
                    ((cd) (obj)).show(activity.getFragmentManager(), "info_pop");
                    i1 = ds.b;
                    return true;
                } else
                {
                    activity.startActivity(com.wishabi.flipp.app.FlyerInfoActivity.a(i1, ((String) (obj)), flag2, flag));
                    activity.overridePendingTransition(0x7f040001, 0x7f040002);
                    i1 = com.wishabi.flipp.app.ds.a;
                    return true;
                }
            }
        } else
        if (menuitem.getItemId() == 0x7f0b015e)
        {
            if (!x)
            {
                a(getString(0x7f0e0005));
                menuitem = new ContentValues();
                menuitem.put("_id", Integer.valueOf(f));
                activity.getContentResolver().insert(i.f, menuitem);
                a.a.a((com.wishabi.flipp.content.Flyer.Model)d[e.getCurrentItem()], true);
                return true;
            } else
            {
                a(getString(0x7f0e0114));
                activity.getContentResolver().delete(i.f, "_id = ?", new String[] {
                    Integer.toString(f)
                });
                a.a.a((com.wishabi.flipp.content.Flyer.Model)d[e.getCurrentItem()], false);
                return true;
            }
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
        return flag1;
    }

    public void onPause()
    {
        super.onPause();
        a.a.a();
    }

    public void onResume()
    {
        super.onResume();
        A = false;
        if (z == null || y == null)
        {
            return;
        } else
        {
            l.a(p, r);
            return;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("SAVE_STATE_DISCOUNT_KEY", r);
        bundle.putBoolean("SAVE_STATE_CROSS_BROWSE_KEY", a.a.r);
        if (e != null)
        {
            bundle.putInt("SAVE_STATE_CAROUSEL_POSITION_KEY", e.getCurrentItem());
        }
        bundle.putInt("flyer_mode", j - 1);
        if (p != null)
        {
            bundle.putBoolean("SAVE_STATE_HIGHLIGHT_COUPON_KEY", p.getShowCoupon());
        }
        bundle.putBoolean("SAVE_STATE_SHOW_TUTORIAL_KEY", D);
        bundle.putBoolean("SAVE_STATE_SHOW_COUPON_TUTORIAL_ON_DISMISS_KEY", E);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        if (E)
        {
            view = getFragmentManager();
            if (view != null)
            {
                if ((view = (fn)view.findFragmentByTag("tap_to_hold_tutorial")) != null)
                {
                    view.a = this;
                    return;
                }
            }
        }
    }

}
