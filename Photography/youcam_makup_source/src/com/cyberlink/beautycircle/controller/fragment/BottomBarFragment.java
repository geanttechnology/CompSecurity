// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.f;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.cyberlink.beautycircle.view.widgetpool.common.ObservableScrollView;
import com.cyberlink.beautycircle.view.widgetpool.common.n;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.d;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            a, b

public class BottomBarFragment extends Fragment
{

    static int b = 0;
    private android.widget.AbsListView.OnScrollListener A;
    private d B;
    private n C;
    private TreeSet D;
    public boolean a;
    protected android.view.View.OnLongClickListener c;
    protected android.view.View.OnLongClickListener d;
    protected android.view.View.OnClickListener e;
    protected android.view.View.OnClickListener f;
    protected android.view.View.OnClickListener g;
    protected android.view.View.OnClickListener h;
    protected android.view.View.OnClickListener i;
    protected android.view.View.OnClickListener j;
    protected android.view.View.OnClickListener k;
    private a l;
    private View m;
    private View n;
    private View o;
    private View p;
    private View q;
    private View r;
    private View s;
    private View t;
    private View u;
    private boolean v;
    private boolean w;
    private AnimatorSet x;
    private TreeMap y;
    private TreeMap z;

    public BottomBarFragment()
    {
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = true;
        w = false;
        x = null;
        a = false;
        y = new TreeMap(new Comparator() {

            final BottomBarFragment a;

            public int a(View view, View view1)
            {
                return view.hashCode() - view1.hashCode();
            }

            public int compare(Object obj, Object obj1)
            {
                return a((View)obj, (View)obj1);
            }

            
            {
                a = BottomBarFragment.this;
                super();
            }
        });
        z = new TreeMap(new Comparator() {

            final BottomBarFragment a;

            public int a(View view, View view1)
            {
                return view.hashCode() - view1.hashCode();
            }

            public int compare(Object obj, Object obj1)
            {
                return a((View)obj, (View)obj1);
            }

            
            {
                a = BottomBarFragment.this;
                super();
            }
        });
        c = new android.view.View.OnLongClickListener() {

            final BottomBarFragment a;

            public boolean onLongClick(View view)
            {
                if (BottomBarFragment.b < 3)
                {
                    BottomBarFragment.b++;
                    return false;
                } else
                {
                    BottomBarFragment.b = 0;
                    return false;
                }
            }

            
            {
                a = BottomBarFragment.this;
                super();
            }
        };
        d = new android.view.View.OnLongClickListener() {

            final BottomBarFragment a;

            public boolean onLongClick(View view)
            {
                if (BottomBarFragment.b >= 3)
                {
                    BottomBarFragment.b++;
                    if (BottomBarFragment.b == 6)
                    {
                        view = a.getActivity();
                        if (view instanceof MainActivity)
                        {
                            Globals.g();
                            ((BaseActivity)view).a(a.getString(m.bc_developmode_text), 5000);
                            ((MainActivity)view).c(null);
                        }
                    }
                    return false;
                } else
                {
                    BottomBarFragment.b = 0;
                    return false;
                }
            }

            
            {
                a = BottomBarFragment.this;
                super();
            }
        };
        A = new android.widget.AbsListView.OnScrollListener() {

            final BottomBarFragment a;
            private boolean b;
            private int c;
            private float d;

            public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
            {
                boolean flag = false;
                for (Iterator iterator = BottomBarFragment.a(a).iterator(); iterator.hasNext(); ((b)iterator.next()).onScroll(abslistview, i1, j1, k1)) { }
                float f1;
                if (b && j1 > 0)
                {
                    if ((f1 = abslistview.getChildAt(0).getY()) < 0.0F)
                    {
                        if (c == i1)
                        {
                            BottomBarFragment.a(a, f1 - d);
                        }
                        if (BottomBarFragment.b(a).containsKey(abslistview) || BottomBarFragment.c(a).containsKey(abslistview))
                        {
                            View view = (View)BottomBarFragment.b(a).get(abslistview);
                            View view1 = (View)BottomBarFragment.c(a).get(abslistview);
                            if (i1 < ((ListView)abslistview).getHeaderViewsCount() + 1)
                            {
                                BottomBarFragment.a(a, false);
                            } else
                            {
                                flag = true;
                            }
                            a.a(view, view1, flag);
                        }
                        c = i1;
                        d = f1;
                        return;
                    }
                }
            }

            public void onScrollStateChanged(AbsListView abslistview, int i1)
            {
                for (Iterator iterator = BottomBarFragment.a(a).iterator(); iterator.hasNext(); ((b)iterator.next()).onScrollStateChanged(abslistview, i1)) { }
                if (i1 == 0)
                {
                    b = false;
                    BottomBarFragment.b(a, false);
                } else
                if (abslistview != null)
                {
                    b = true;
                    c = abslistview.getFirstVisiblePosition();
                    abslistview = abslistview.getChildAt(0);
                    float f1;
                    if (abslistview != null)
                    {
                        f1 = abslistview.getY();
                    } else
                    {
                        f1 = 0.0F;
                    }
                    d = f1;
                    return;
                }
            }

            
            {
                a = BottomBarFragment.this;
                super();
                b = false;
                c = -1;
                d = -1F;
            }
        };
        B = new d() {

            public boolean a;
            final BottomBarFragment b;
            private int c;
            private float d;

            public void a(PLA_AbsListView pla_abslistview, int i1)
            {
                b.a = true;
                for (Iterator iterator = BottomBarFragment.a(b).iterator(); iterator.hasNext(); ((b)iterator.next()).a(pla_abslistview, i1)) { }
                if (i1 == 0)
                {
                    a = false;
                    BottomBarFragment.b(b, false);
                } else
                if (pla_abslistview != null)
                {
                    a = true;
                    c = pla_abslistview.getFirstVisiblePosition();
                    pla_abslistview = pla_abslistview.getChildAt(0);
                    float f1;
                    if (pla_abslistview != null)
                    {
                        f1 = pla_abslistview.getY();
                    } else
                    {
                        f1 = 0.0F;
                    }
                    d = f1;
                    return;
                }
            }

            public void a(PLA_AbsListView pla_abslistview, int i1, int j1, int k1)
            {
                boolean flag = false;
                for (Iterator iterator = BottomBarFragment.a(b).iterator(); iterator.hasNext(); ((b)iterator.next()).a(pla_abslistview, i1, j1, k1)) { }
                float f1;
                if (a && j1 > 0)
                {
                    if ((f1 = pla_abslistview.getChildAt(0).getY()) < 0.0F)
                    {
                        if (c == i1)
                        {
                            BottomBarFragment.a(b, f1 - d);
                        }
                        if (BottomBarFragment.b(b).containsKey(pla_abslistview) || BottomBarFragment.c(b).containsKey(pla_abslistview))
                        {
                            View view = (View)BottomBarFragment.b(b).get(pla_abslistview);
                            View view1 = (View)BottomBarFragment.c(b).get(pla_abslistview);
                            if (i1 < ((CLMultiColumnListView)pla_abslistview).getHeaderViewsCount())
                            {
                                BottomBarFragment.a(b, false);
                            } else
                            {
                                flag = true;
                            }
                            b.a(view, view1, flag);
                        }
                        c = i1;
                        d = f1;
                        return;
                    }
                }
            }

            
            {
                b = BottomBarFragment.this;
                super();
                a = false;
                c = -1;
                d = -1F;
            }
        };
        C = new n() {

            final BottomBarFragment a;

            public void a(ObservableScrollView observablescrollview, int i1)
            {
                if (i1 == 0)
                {
                    BottomBarFragment.b(a, false);
                }
            }

            public void a(ObservableScrollView observablescrollview, int i1, int j1, int k1, int l1)
            {
                BottomBarFragment.a(a, l1 - j1);
            }

            
            {
                a = BottomBarFragment.this;
                super();
            }
        };
        e = new android.view.View.OnClickListener() {

            final BottomBarFragment a;

            public void onClick(View view)
            {
                Iterator iterator = BottomBarFragment.b(a).entrySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Object obj = (java.util.Map.Entry)iterator.next();
                    if (view.equals(((java.util.Map.Entry) (obj)).getValue()))
                    {
                        obj = (View)((java.util.Map.Entry) (obj)).getKey();
                        if (obj != null)
                        {
                            view.setTag(j.to_top_btn, Boolean.valueOf(true));
                            if (obj instanceof ListView)
                            {
                                int i1 = ((ListView)obj).getFirstVisiblePosition();
                                BottomBarFragment.a(a, true);
                                if (i1 > 4)
                                {
                                    ((ListView)obj).setSelection(4);
                                }
                                ((ListView)obj).smoothScrollToPositionFromTop(0, 0);
                                ((ListView)obj).postDelayed(new Runnable(this, ((View) (obj))) {

                                    final View a;
                                    final _cls17 b;

                                    public void run()
                                    {
                                        ((ListView)a).setSelection(0);
                                    }

            
            {
                b = _pcls17;
                a = view;
                super();
            }
                                }, 300L);
                            } else
                            if (obj instanceof ObservableScrollView)
                            {
                                ((ObservableScrollView)obj).scrollTo(0, 0);
                            } else
                            if (obj instanceof CLMultiColumnListView)
                            {
                                int j1 = ((CLMultiColumnListView)obj).getFirstVisiblePosition();
                                BottomBarFragment.a(a, true);
                                if (j1 > 4)
                                {
                                    ((CLMultiColumnListView)obj).setSelection(4);
                                }
                                ((CLMultiColumnListView)obj).b(0, 0);
                                ((CLMultiColumnListView)obj).postDelayed(new Runnable(this, ((View) (obj))) {

                                    final View a;
                                    final _cls17 b;

                                    public void run()
                                    {
                                        ((CLMultiColumnListView)a).setSelection(0);
                                    }

            
            {
                b = _pcls17;
                a = view;
                super();
            }
                                }, 300L);
                            }
                        }
                    }
                } while (true);
            }

            
            {
                a = BottomBarFragment.this;
                super();
            }
        };
        f = new android.view.View.OnClickListener() {

            final BottomBarFragment a;

            public void onClick(View view)
            {
                if (com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.d(a) != null && com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.d(a).a(Tab.a))
                {
                    BottomBarFragment.a(a, view);
                }
            }

            
            {
                a = BottomBarFragment.this;
                super();
            }

            private class Tab extends Enum
            {

                public static final Tab a;
                public static final Tab b;
                public static final Tab c;
                public static final Tab d;
                public static final Tab e;
                public static final Tab f;
                private static final Tab g[];

                public static Tab valueOf(String s1)
                {
                    return (Tab)Enum.valueOf(com/cyberlink/beautycircle/controller/fragment/BottomBarFragment$Tab, s1);
                }

                public static Tab[] values()
                {
                    return (Tab[])g.clone();
                }

                static 
                {
                    a = new Tab("Feed", 0);
                    b = new Tab("Discover", 1);
                    c = new Tab("Products", 2);
                    d = new Tab("Notifications", 3);
                    e = new Tab("Me", 4);
                    f = new Tab("Developer", 5);
                    g = (new Tab[] {
                        a, b, c, d, e, f
                    });
                }

                private Tab(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

        };
        g = new android.view.View.OnClickListener() {

            final BottomBarFragment a;

            public void onClick(View view)
            {
                BottomBarFragment.b = 0;
                if (com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.d(a) != null && com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.d(a).a(Tab.c))
                {
                    BottomBarFragment.a(a, view);
                }
            }

            
            {
                a = BottomBarFragment.this;
                super();
            }
        };
        h = new android.view.View.OnClickListener() {

            final BottomBarFragment a;

            public void onClick(View view)
            {
                BottomBarFragment.b = 0;
                if (com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.d(a) != null && com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.d(a).a(Tab.b))
                {
                    BottomBarFragment.a(a, view);
                }
            }

            
            {
                a = BottomBarFragment.this;
                super();
            }
        };
        i = new android.view.View.OnClickListener() {

            final BottomBarFragment a;

            public void onClick(View view)
            {
                BottomBarFragment.b = 0;
                if (com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.d(a) != null && com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.d(a).a(com.cyberlink.beautycircle.controller.fragment.Tab.f))
                {
                    BottomBarFragment.a(a, view);
                }
            }

            
            {
                a = BottomBarFragment.this;
                super();
            }
        };
        j = new android.view.View.OnClickListener() {

            final BottomBarFragment a;

            public void onClick(View view)
            {
                if (com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.d(a) != null && com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.d(a).a(Tab.e))
                {
                    BottomBarFragment.a(a, view);
                }
            }

            
            {
                a = BottomBarFragment.this;
                super();
            }
        };
        k = new android.view.View.OnClickListener() {

            final BottomBarFragment a;

            public void onClick(View view)
            {
                if (com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.d(a) != null && com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.d(a).a(com.cyberlink.beautycircle.controller.fragment.Tab.d))
                {
                    BottomBarFragment.a(a, view);
                }
            }

            
            {
                a = BottomBarFragment.this;
                super();
            }
        };
        D = new TreeSet(new Comparator() {

            final BottomBarFragment a;

            public int a(b b1, b b2)
            {
                if (b1 == null || b2 == null)
                {
                    return 0;
                } else
                {
                    return b1.hashCode() - b2.hashCode();
                }
            }

            public int compare(Object obj, Object obj1)
            {
                return a((b)obj, (b)obj1);
            }

            
            {
                a = BottomBarFragment.this;
                super();
            }
        });
    }

    static TreeSet a(BottomBarFragment bottombarfragment)
    {
        return bottombarfragment.D;
    }

    private void a(float f1)
    {
        float f2;
        for (f2 = 0.0F; v || m == null;)
        {
            return;
        }

        f1 = m.getTranslationY() - f1;
        if (f1 >= 0.0F) goto _L2; else goto _L1
_L1:
        f1 = f2;
_L4:
        m.setTranslationY(f1);
        d().setTranslationY(f1);
        return;
_L2:
        if (f1 > (float)m.getHeight())
        {
            f1 = m.getHeight();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(View view)
    {
        o = view.findViewById(j.bottom_bar_tab_feed);
        if (o != null)
        {
            o.setOnClickListener(f);
            o.setOnLongClickListener(c);
        }
        q = view.findViewById(j.bottom_bar_tab_discover);
        if (q != null)
        {
            q.setOnClickListener(h);
        }
        p = view.findViewById(j.bottom_bar_tab_products);
        if (p != null)
        {
            if (AccountManager.n())
            {
                p.setOnClickListener(g);
            } else
            {
                p.setVisibility(8);
            }
        }
        r = view.findViewById(j.bottom_bar_tab_notifications);
        if (r != null)
        {
            r.setOnClickListener(k);
        }
        s = view.findViewById(j.bottom_bar_tab_me);
        if (s != null)
        {
            s.setOnClickListener(j);
            s.setOnLongClickListener(d);
        }
        t = view.findViewById(j.bottom_bar_tab_developer);
        if (t != null)
        {
            t.setOnClickListener(i);
            t.setVisibility(8);
        }
    }

    private void a(View view, boolean flag)
    {
        if (view != null)
        {
            view.setSelected(flag);
        }
    }

    static void a(BottomBarFragment bottombarfragment, float f1)
    {
        bottombarfragment.a(f1);
    }

    static void a(BottomBarFragment bottombarfragment, View view)
    {
        bottombarfragment.b(view);
    }

    static boolean a(BottomBarFragment bottombarfragment, boolean flag)
    {
        bottombarfragment.w = flag;
        return flag;
    }

    static TreeMap b(BottomBarFragment bottombarfragment)
    {
        return bottombarfragment.z;
    }

    private void b(View view)
    {
        boolean flag1 = true;
        View view1 = o;
        boolean flag;
        if (o == view)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(view1, flag);
        view1 = q;
        if (q == view)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(view1, flag);
        view1 = p;
        if (p == view)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(view1, flag);
        view1 = r;
        if (r == view)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(view1, flag);
        view1 = s;
        if (s == view)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(view1, flag);
        view1 = t;
        if (t == view)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(view1, flag);
        view1 = u;
        if (u == view)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        a(view1, flag);
    }

    static void b(BottomBarFragment bottombarfragment, boolean flag)
    {
        bottombarfragment.b(flag);
    }

    private void b(boolean flag)
    {
        float f1;
        if (!v || flag)
        {
            if ((f1 = m.getTranslationY()) > 0.0F && (flag || f1 < (float)m.getHeight()))
            {
                Animator animator = AnimatorInflater.loadAnimator(getActivity(), f.bc_anim_restore_bottom_bar);
                animator.setTarget(m);
                animator.start();
                animator = AnimatorInflater.loadAnimator(getActivity(), f.bc_anim_restore_bottom_bar);
                animator.setTarget(d());
                animator.start();
                return;
            }
        }
    }

    static TreeMap c(BottomBarFragment bottombarfragment)
    {
        return bottombarfragment.y;
    }

    private View d()
    {
        if (n == null)
        {
            n = getActivity().findViewById(j.fragment_bottombar_shadow);
        }
        return n;
    }

    static a d(BottomBarFragment bottombarfragment)
    {
        return bottombarfragment.l;
    }

    private void e()
    {
        if (r != null)
        {
            Object obj = r.findViewById(j.bc_new_alert);
            ((View) (obj)).setVisibility(0);
            if (obj != null)
            {
                obj = ObjectAnimator.ofPropertyValuesHolder(obj, new PropertyValuesHolder[] {
                    PropertyValuesHolder.ofFloat("scaleX", new float[] {
                        0.0F, 1.0F
                    }), PropertyValuesHolder.ofFloat("scaleY", new float[] {
                        0.0F, 1.0F
                    })
                });
                ((ObjectAnimator) (obj)).setDuration(2000L);
                ((ObjectAnimator) (obj)).setInterpolator(new DecelerateInterpolator());
                ((ObjectAnimator) (obj)).addListener(new android.animation.Animator.AnimatorListener() {

                    final BottomBarFragment a;

                    public void onAnimationCancel(Animator animator)
                    {
                    }

                    public void onAnimationEnd(Animator animator)
                    {
                        BottomBarFragment.e(a);
                    }

                    public void onAnimationRepeat(Animator animator)
                    {
                    }

                    public void onAnimationStart(Animator animator)
                    {
                    }

            
            {
                a = BottomBarFragment.this;
                super();
            }
                });
                ((ObjectAnimator) (obj)).start();
            }
        }
    }

    static void e(BottomBarFragment bottombarfragment)
    {
        bottombarfragment.g();
    }

    static AnimatorSet f(BottomBarFragment bottombarfragment)
    {
        return bottombarfragment.x;
    }

    private void f()
    {
        if (r != null)
        {
            h();
            View view = r.findViewById(j.bc_new_alert);
            if (view != null && view.getVisibility() == 0)
            {
                ObjectAnimator objectanimator = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[] {
                    PropertyValuesHolder.ofFloat("scaleX", new float[] {
                        1.0F, 0.0F
                    }), PropertyValuesHolder.ofFloat("scaleY", new float[] {
                        1.0F, 0.0F
                    })
                });
                objectanimator.setDuration(1000L);
                objectanimator.setInterpolator(new DecelerateInterpolator());
                objectanimator.addListener(new android.animation.Animator.AnimatorListener(view) {

                    final View a;
                    final BottomBarFragment b;

                    public void onAnimationCancel(Animator animator)
                    {
                    }

                    public void onAnimationEnd(Animator animator)
                    {
                        a.setVisibility(4);
                        a.findViewById(j.bc_new_alert_outter).setVisibility(4);
                    }

                    public void onAnimationRepeat(Animator animator)
                    {
                    }

                    public void onAnimationStart(Animator animator)
                    {
                    }

            
            {
                b = BottomBarFragment.this;
                a = view;
                super();
            }
                });
                objectanimator.start();
            }
        }
    }

    private void g()
    {
        if (r != null)
        {
            Object obj = r.findViewById(j.bc_new_alert_outter);
            ((View) (obj)).setVisibility(0);
            if (obj != null)
            {
                x = new AnimatorSet();
                ObjectAnimator objectanimator = ObjectAnimator.ofPropertyValuesHolder(obj, new PropertyValuesHolder[] {
                    PropertyValuesHolder.ofFloat("scaleX", new float[] {
                        0.5F, 1.0F
                    }), PropertyValuesHolder.ofFloat("scaleY", new float[] {
                        0.5F, 1.0F
                    }), PropertyValuesHolder.ofFloat("alpha", new float[] {
                        0.6F, 0.0F
                    })
                });
                objectanimator.setDuration(2000L);
                objectanimator.setInterpolator(new DecelerateInterpolator());
                obj = ObjectAnimator.ofPropertyValuesHolder(obj, new PropertyValuesHolder[] {
                    PropertyValuesHolder.ofFloat("scaleX", new float[] {
                        1.0F, 1.0F
                    }), PropertyValuesHolder.ofFloat("scaleY", new float[] {
                        1.0F, 1.0F
                    }), PropertyValuesHolder.ofFloat("alpha", new float[] {
                        0.0F, 0.0F
                    })
                });
                ((ObjectAnimator) (obj)).setInterpolator(new DecelerateInterpolator());
                ((ObjectAnimator) (obj)).setDuration(200L);
                x.play(objectanimator).after(((Animator) (obj)));
                x.addListener(new android.animation.Animator.AnimatorListener() {

                    final BottomBarFragment a;

                    public void onAnimationCancel(Animator animator)
                    {
                    }

                    public void onAnimationEnd(Animator animator)
                    {
                        com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.f(a).start();
                    }

                    public void onAnimationRepeat(Animator animator)
                    {
                    }

                    public void onAnimationStart(Animator animator)
                    {
                    }

            
            {
                a = BottomBarFragment.this;
                super();
            }
                });
                x.start();
            }
        }
    }

    private void h()
    {
        if (x != null)
        {
            x.cancel();
        }
    }

    public void a()
    {
        b(true);
    }

    protected void a(View view, View view1, boolean flag)
    {
        if (w)
        {
            flag = false;
        }
        if (flag)
        {
            if (view != null && view.getVisibility() != 0)
            {
                view.setVisibility(0);
                ObjectAnimator.ofFloat(view, "alpha", new float[] {
                    0.0F, 1.0F
                }).setDuration(300L).start();
            }
            if (view1 != null)
            {
                view1.setVisibility(4);
            }
        } else
        {
            if (view != null && view.getVisibility() != 4)
            {
                view.setVisibility(4);
            }
            if (view1 != null)
            {
                view1.setVisibility(0);
                ObjectAnimator.ofFloat(view1, "alpha", new float[] {
                    0.0F, 1.0F
                }).setDuration(300L).start();
                return;
            }
        }
    }

    public void a(ViewGroup viewgroup, View view)
    {
        if (viewgroup != null && view != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Class class1;
        class1 = viewgroup.getClass();
        if (!class1.isAssignableFrom(android/widget/ListView))
        {
            continue; /* Loop/switch isn't completed */
        }
        ((ListView)viewgroup).setOnScrollListener(null);
_L4:
        z.remove(viewgroup);
        view.setOnClickListener(null);
        return;
        if (!class1.isAssignableFrom(com/cyberlink/beautycircle/view/widgetpool/common/CLMultiColumnListView)) goto _L1; else goto _L3
_L3:
        ((CLMultiColumnListView)viewgroup).setOnScrollListener(null);
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void a(ViewGroup viewgroup, View view, View view1)
    {
        if (viewgroup != null && view != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Class class1;
        class1 = viewgroup.getClass();
        if (!class1.isAssignableFrom(android/widget/ListView))
        {
            continue; /* Loop/switch isn't completed */
        }
        ((ListView)viewgroup).setOnScrollListener(A);
_L4:
        y.put(viewgroup, view1);
        z.put(viewgroup, view);
        view.setOnClickListener(e);
        a(view, view1, false);
        return;
        if (!class1.isAssignableFrom(com/cyberlink/beautycircle/view/widgetpool/common/CLMultiColumnListView)) goto _L1; else goto _L3
_L3:
        ((CLMultiColumnListView)viewgroup).setOnScrollListener(B);
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void a(Tab tab)
    {
        int i1 = 0x1020004;
        if (tab != Tab.a) goto _L2; else goto _L1
_L1:
        i1 = j.bottom_bar_tab_feed;
_L4:
        tab = getActivity();
        if (tab != null)
        {
            b(tab.findViewById(i1));
        }
        return;
_L2:
        if (tab == Tab.b)
        {
            i1 = j.bottom_bar_tab_discover;
        } else
        if (tab == Tab.c)
        {
            i1 = j.bottom_bar_tab_products;
        } else
        if (tab == com.cyberlink.beautycircle.controller.fragment.Tab.d)
        {
            i1 = j.bottom_bar_tab_notifications;
        } else
        if (tab == Tab.e)
        {
            i1 = j.bottom_bar_tab_me;
        } else
        if (tab == com.cyberlink.beautycircle.controller.fragment.Tab.f)
        {
            i1 = j.bottom_bar_tab_developer;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(a a1)
    {
        l = a1;
    }

    public void a(b b1)
    {
        D.add(b1);
    }

    public void a(ObservableScrollView observablescrollview, View view)
    {
        observablescrollview.setOnScrollChangeListener((n)null);
        z.remove(observablescrollview);
        if (view != null)
        {
            view.setOnClickListener(null);
        }
    }

    public void a(ObservableScrollView observablescrollview, View view, View view1)
    {
        observablescrollview.setOnScrollChangeListener(C);
        y.put(observablescrollview, view1);
        z.put(observablescrollview, view);
        if (view != null)
        {
            view.setOnClickListener(e);
            a(view, view1, false);
        }
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            e();
            return;
        } else
        {
            f();
            return;
        }
    }

    public void b()
    {
        float f1 = m.getHeight();
        if (m.getTranslationY() >= f1)
        {
            return;
        } else
        {
            ObjectAnimator.ofFloat(m, "translationY", new float[] {
                f1
            }).setDuration(200L).start();
            ObjectAnimator.ofFloat(d(), "translationY", new float[] {
                f1
            }).setDuration(200L).start();
            return;
        }
    }

    public void b(b b1)
    {
        D.remove(b1);
    }

    public void c()
    {
        if (t != null)
        {
            t.setVisibility(0);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        m = layoutinflater.inflate(k.bc_fragment_bottombar, viewgroup, false);
        a(m);
        return m;
    }

}
