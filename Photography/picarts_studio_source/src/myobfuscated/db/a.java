// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.db;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Point;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.socialin.camera.masks.d;
import com.socialin.camera.masks.e;
import com.socialin.picsin.camera.CameraMainActivity;
import java.util.ArrayList;
import myobfuscated.da.b;
import myobfuscated.da.c;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.db:
//            b

public final class a extends Fragment
    implements c
{

    public static String a = "open_gl_effects_menu_tag";
    public boolean b;
    public com.socialin.camera.opengl.a c;
    public myobfuscated.da.a d;
    public d e;
    public b f;
    public int g;
    private boolean h;
    private boolean i;
    private com.socialin.camera.masks.b j;
    private ListView k;
    private ListView l;
    private e m;
    private com.socialin.android.net.a n;
    private int o;
    private int p;
    private int q;
    private ArrayList r;
    private int s[] = {
        0x7f100758, 0x7f10075d
    };

    public a()
    {
        b = false;
        h = true;
        i = false;
        g = -1;
        o = 0;
        p = 0;
        q = 0;
        r = new ArrayList();
    }

    public a(com.socialin.camera.opengl.a a1, int i1)
    {
        b = false;
        h = true;
        i = false;
        g = -1;
        o = 0;
        p = 0;
        q = 0;
        r = new ArrayList();
        c = a1;
        g = i1;
        if (c != null)
        {
            c.x = this;
        }
    }

    static int a(a a1, int i1)
    {
        a1.p = i1;
        return i1;
    }

    private View a(View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        return view1;
    }

    static ArrayList a(a a1)
    {
        return a1.r;
    }

    private void a(int i1, boolean flag, boolean flag1)
    {
        myobfuscated.db.b b1;
        boolean flag2;
        flag2 = false;
        b1 = (myobfuscated.db.b)getActivity();
        i1;
        JVM INSTR tableswitch 0 1: default 36
    //                   0 75
    //                   1 114;
           goto _L1 _L2 _L3
_L1:
        if (!b1.a())
        {
            b1.a(i1, flag, flag1);
            flag = true;
        } else
        {
            c.a(i1, true, false, flag, flag1);
            flag = true;
        }
_L5:
        if (i1 != 4 && i1 != 21)
        {
            c(flag);
        }
        return;
_L2:
        flag = flag2;
        if (b1.a())
        {
            int j1 = g;
            b1.a(true);
            g = j1;
            flag = flag2;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (!b1.a())
        {
            b1.a(0, true, flag1);
            flag = flag2;
        } else
        {
            c.a(0, true, true, true, flag1);
            flag = flag2;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    static void a(a a1, View view)
    {
        a1.c(view);
    }

    static int b(a a1)
    {
        return a1.p;
    }

    static int b(a a1, int i1)
    {
        a1.q = i1;
        return i1;
    }

    private ListView b(View view)
    {
        view = a(view);
        if (view != null)
        {
            return (ListView)view.findViewById(0x7f1005ca);
        } else
        {
            return null;
        }
    }

    static void b(a a1, View view)
    {
        a1.d(view);
    }

    static int c(a a1)
    {
        return a1.q;
    }

    private void c(View view)
    {
        view.setRotation(o);
    }

    static void c(a a1, View view)
    {
        a1.e(view);
    }

    static com.socialin.camera.masks.b d(a a1)
    {
        return a1.j;
    }

    private void d(View view)
    {
        float f1 = 0.0F;
        if (p > 0 && q > 0)
        {
            view = b(view);
            if (view != null)
            {
                float f2;
                if (o == 270 || o == 90)
                {
                    f2 = -p / 2 + q / 2;
                    f1 = q / 2 - p / 2;
                } else
                {
                    f2 = 0.0F;
                }
                view.setTranslationX(f2);
                view.setTranslationY(f1);
                view.setRotation(o);
            }
        }
    }

    private void d(boolean flag)
    {
        View view;
label0:
        {
            view = getView();
            if (view != null)
            {
                if (!flag)
                {
                    break label0;
                }
                view.findViewById(0x7f10075b).setVisibility(0);
            }
            return;
        }
        view.findViewById(0x7f10075b).setVisibility(8);
    }

    static b e(a a1)
    {
        return a1.f;
    }

    private void e(View view)
    {
        View view1 = getView();
        if (view1 != null)
        {
            Object obj = AnimationUtils.loadAnimation(getActivity(), 0x7f040018);
            ((Animation) (obj)).setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                private a a;

                public final void onAnimationEnd(Animation animation)
                {
                    a.g(a).setVisibility(8);
                }

                public final void onAnimationRepeat(Animation animation)
                {
                }

                public final void onAnimationStart(Animation animation)
                {
                }

            
            {
                a = a.this;
                super();
            }
            });
            k.startAnimation(((Animation) (obj)));
            obj = view;
            if (view == null)
            {
                obj = view1.findViewById(0x7f1006e4);
            }
            ((View) (obj)).startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x7f04003e));
        }
    }

    static d f(a a1)
    {
        return a1.e;
    }

    static ListView g(a a1)
    {
        return a1.k;
    }

    static boolean h(a a1)
    {
        a1.i = false;
        return false;
    }

    public final void a()
    {
        View view = getView();
        if (view != null)
        {
            view.setVisibility(0);
        }
    }

    public final void a(int i1)
    {
        Object obj;
        if (d != null)
        {
            d.b = i1;
            obj = a(((View) (null)));
            int j1;
            if (obj != null)
            {
                obj = (ListView)((View) (obj)).findViewById(0x7f100754);
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                d.notifyDataSetChanged();
            }
        }
        if (f != null)
        {
            f.e = i1;
            obj = a(((View) (null)));
            if (obj != null)
            {
                obj = (ListView)((View) (obj)).findViewById(0x7f100755);
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                f.notifyDataSetChanged();
            }
        }
        o = i1;
        d(((View) (null)));
        obj = getView();
        if (obj != null)
        {
            for (i1 = 0; i1 < s.length; i1++)
            {
                j1 = s[i1];
                r.get(i1);
                c(((View) (obj)).findViewById(j1));
            }

        }
    }

    public final void a(int i1, View view)
    {
        if (view == null) goto _L2; else goto _L1
_L1:
        view.setVisibility(0);
        d(false);
        g = i1;
        i1;
        JVM INSTR tableswitch 0 1: default 44
    //                   0 45
    //                   1 174;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        if (n != null)
        {
            n.b();
        }
        ListView listview = (ListView)view.findViewById(0x7f100754);
        listview.setVisibility(0);
        view.findViewById(0x7f1005ca).setVisibility(8);
        view.findViewById(0x7f1006e7).setVisibility(8);
        if (listview.getAdapter() == null || d == null)
        {
            d = new myobfuscated.da.a(getActivity(), c);
            d.b = o;
            listview.setAdapter(d);
        }
        view = (LinearLayout)view.findViewById(0x7f100759);
        c.q = view;
        a(0, true, false);
        return;
_L4:
        view.findViewById(0x7f100754).setVisibility(8);
        c(false);
        view.findViewById(0x7f1005ca).setVisibility(0);
        view.findViewById(0x7f1006e7).setVisibility(0);
        if (e == null)
        {
            e = new d(getActivity(), "mask.json");
        }
        if (view != null)
        {
            k = (ListView)view.findViewById(0x7f1005ca);
            if (k.getAdapter() == null || j == null)
            {
                j = new com.socialin.camera.masks.b(getActivity(), e.a);
                k.setAdapter(j);
            }
            if (l == null)
            {
                l = (ListView)view.findViewById(0x7f100755);
            }
            if (n == null)
            {
                n = myobfuscated.f.m.b(getActivity());
            }
            if (f == null || l.getAdapter() == null)
            {
                com.socialin.camera.masks.c c1 = (com.socialin.camera.masks.c)e.a.get(0);
                f = new b(getActivity(), n, this, c1);
                f.e = o;
                l.setAdapter(f);
                l.setOnItemClickListener(f);
            } else
            {
                f.c = -1;
                f.notifyDataSetChanged();
            }
            if (m == null)
            {
                m = new e(getActivity(), f);
            }
            f.d = m;
            m.e = f;
            n.a(m);
            f.a(-1);
            k.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final a a;

                public final void onItemClick(AdapterView adapterview, View view1, int j1, long l1)
                {
                    for (adapterview = a.getView(); adapterview == null || myobfuscated.db.a.d(a).a == j1;)
                    {
                        return;
                    }

                    view1 = myobfuscated.db.a.e(a);
                    com.socialin.android.util.c.b(((b) (view1)).a);
                    ((b) (view1)).b.clear();
                    System.gc();
                    myobfuscated.db.a.e(a).a((com.socialin.camera.masks.c)a.f(a).a.get(j1));
                    myobfuscated.db.a.e(a).notifyDataSetChanged();
                    myobfuscated.db.a.d(a).a = j1;
                    myobfuscated.db.a.d(a).notifyDataSetChanged();
                    myobfuscated.db.a.e(a).a(-1);
                    view1 = AnimationUtils.loadAnimation(a.getActivity(), 0x7f040018);
                    view1.setAnimationListener(new android.view.animation.Animation.AnimationListener(this) {

                        private _cls6 a;

                        public final void onAnimationEnd(Animation animation)
                        {
                            a.g(a.a).setVisibility(8);
                        }

                        public final void onAnimationRepeat(Animation animation)
                        {
                        }

                        public final void onAnimationStart(Animation animation)
                        {
                        }

            
            {
                a = _pcls6;
                super();
            }
                    });
                    a.g(a).startAnimation(view1);
                    adapterview.findViewById(0x7f1006e4).startAnimation(AnimationUtils.loadAnimation(a.getActivity(), 0x7f04003e));
                }

            
            {
                a = a.this;
                super();
            }
            });
            view.findViewById(0x7f1006e4).setOnClickListener(new android.view.View.OnClickListener() {

                private a a;

                public final void onClick(View view1)
                {
                    if (a.g(a).getVisibility() == 8)
                    {
                        a.g(a).setVisibility(0);
                        a.g(a).startAnimation(AnimationUtils.loadAnimation(a.getActivity(), 0x7f040019));
                        view1.startAnimation(AnimationUtils.loadAnimation(a.getActivity(), 0x7f04003f));
                        return;
                    } else
                    {
                        myobfuscated.db.a.c(a, view1);
                        return;
                    }
                }

            
            {
                a = a.this;
                super();
            }
            });
            view.findViewById(0x7f10075f).setOnClickListener(new android.view.View.OnClickListener() {

                private a a;

                public final void onClick(View view1)
                {
label0:
                    {
                        view1 = a.getView();
                        if (view1 != null)
                        {
                            view1 = view1.findViewById(0x7f10075c);
                            if (view1.getVisibility() != 0)
                            {
                                break label0;
                            }
                            view1.setVisibility(8);
                        }
                        return;
                    }
                    view1.setVisibility(0);
                }

            
            {
                a = a.this;
                super();
            }
            });
        }
        a(4, true, false);
        return;
    }

    public final void a(int i1, boolean flag)
    {
        d.a(i1);
        a(((Integer)c.r.get(i1)).intValue(), flag, true);
    }

    public final void a(String s1, com.socialin.camera.masks.a a1, boolean flag)
    {
        if (c != null)
        {
            myobfuscated.db.b b1 = (myobfuscated.db.b)getActivity();
            if (b1 != null && b1.a() && g == 1)
            {
                d(true);
                Object obj1 = getView();
                Object obj;
                if (obj1 != null)
                {
                    ((View) (obj1)).findViewById(0x7f10075c).setVisibility(0);
                    LinearLayout linearlayout = (LinearLayout)((View) (obj1)).findViewById(0x7f10075e);
                    linearlayout.setVisibility(0);
                    obj = linearlayout.findViewById(0x7f100403);
                    View view = linearlayout.findViewById(0x7f100404);
                    if (obj == null || view == null)
                    {
                        linearlayout.removeAllViews();
                        obj = (LinearLayout)getActivity().getLayoutInflater().inflate(0x7f0300c5, linearlayout, false);
                        ((TextView)((LinearLayout) (obj)).findViewById(0x7f100403)).setText("Fade");
                        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
                        layoutparams.gravity = 16;
                        ((LinearLayout) (obj)).setLayoutParams(layoutparams);
                        linearlayout.addView(((View) (obj)));
                    } else
                    {
                        obj = (LinearLayout)((View) (obj1)).findViewById(0x7f100402);
                    }
                    if (k != null && k.getVisibility() == 0)
                    {
                        e(((View) (obj1)).findViewById(0x7f1006e4));
                    }
                } else
                {
                    obj = null;
                }
                obj1 = c;
                if (((com.socialin.camera.opengl.a) (obj1)).c == 4)
                {
                    ((CameraMainActivity)((com.socialin.camera.opengl.a) (obj1)).a).h.queueEvent(new com.socialin.camera.opengl._cls6(((com.socialin.camera.opengl.a) (obj1)), a1, s1, flag, ((LinearLayout) (obj))));
                }
            }
        }
    }

    public final void a(boolean flag)
    {
label0:
        {
            if (g == 1 && n != null && m != null)
            {
                if (!flag)
                {
                    break label0;
                }
                n.a(m);
            }
            return;
        }
        n.b();
    }

    public final void b()
    {
        View view = getView();
        if (view != null)
        {
            if (g == 0)
            {
                view = view.findViewById(0x7f100757);
            } else
            {
                view = view.findViewById(0x7f10075c);
            }
            view.setVisibility(0);
        }
    }

    public final void b(boolean flag)
    {
        View view = getView();
        if (view == null) goto _L2; else goto _L1
_L1:
        if (view.getVisibility() != 0) goto _L4; else goto _L3
_L3:
        if (!flag) goto _L6; else goto _L5
_L5:
        if (!i) goto _L7; else goto _L2
_L2:
        return;
_L7:
        i = true;
        Animation animation = AnimationUtils.loadAnimation(getActivity(), 0x7f04001a);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(view) {

            private View a;
            private a b;

            public final void onAnimationEnd(Animation animation2)
            {
                a.setVisibility(8);
                a.h(b);
            }

            public final void onAnimationRepeat(Animation animation2)
            {
            }

            public final void onAnimationStart(Animation animation2)
            {
            }

            
            {
                b = a.this;
                a = view;
                super();
            }
        });
        view.startAnimation(animation);
        return;
_L6:
        view.setVisibility(8);
        return;
_L4:
        if (flag)
        {
            if (!i)
            {
                i = true;
                view.setVisibility(0);
                Animation animation1 = AnimationUtils.loadAnimation(getActivity(), 0x7f040045);
                animation1.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                    private a a;

                    public final void onAnimationEnd(Animation animation2)
                    {
                        a.h(a);
                    }

                    public final void onAnimationRepeat(Animation animation2)
                    {
                    }

                    public final void onAnimationStart(Animation animation2)
                    {
                    }

            
            {
                a = a.this;
                super();
            }
                });
                view.startAnimation(animation1);
                return;
            }
        } else
        {
            view.setVisibility(0);
            return;
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

    public final void c(boolean flag)
    {
        View view;
label0:
        {
            view = getView();
            if (view != null)
            {
                if (!flag)
                {
                    break label0;
                }
                view.findViewById(0x7f100756).setVisibility(0);
            }
            return;
        }
        view.findViewById(0x7f100756).setVisibility(8);
    }

    public final boolean c()
    {
        boolean flag1 = false;
        View view = getView();
        boolean flag = flag1;
        if (view != null)
        {
            flag = flag1;
            if (view.getVisibility() == 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (b)
        {
            bundle = getView();
            if (bundle != null)
            {
                bundle.setVisibility(8);
            }
            b = false;
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        boolean flag = false;
        layoutinflater = layoutinflater.inflate(0x7f030181, viewgroup, false);
        ((ListView)layoutinflater.findViewById(0x7f100754)).setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private a a;

            public final void onItemClick(AdapterView adapterview, View view, int k1, long l1)
            {
                a.a(k1, true);
            }

            
            {
                a = a.this;
                super();
            }
        });
        layoutinflater.findViewById(0x7f10075a).setOnClickListener(new android.view.View.OnClickListener() {

            private a a;

            public final void onClick(View view)
            {
label0:
                {
                    view = a.getView();
                    if (view != null)
                    {
                        view = view.findViewById(0x7f100757);
                        if (view.getVisibility() != 0)
                        {
                            break label0;
                        }
                        view.setVisibility(8);
                    }
                    return;
                }
                view.setVisibility(0);
            }

            
            {
                a = a.this;
                super();
            }
        });
        if (c != null)
        {
            a(g, layoutinflater);
        }
        viewgroup = b(layoutinflater);
        if (viewgroup != null)
        {
            viewgroup.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(viewgroup, layoutinflater) {

                private ListView a;
                private View b;
                private a c;

                public final void onGlobalLayout()
                {
                    if (myobfuscated.db.a.b(c) == 0 || myobfuscated.db.a.c(c) == 0)
                    {
                        int k1 = a.getWidth();
                        int l1 = a.getHeight();
                        if (k1 > 0 && l1 > 0)
                        {
                            a.a(c, k1);
                            myobfuscated.db.a.b(c, l1);
                            myobfuscated.f.m.a(a, this);
                            myobfuscated.db.a.b(c, b);
                        }
                    }
                }

            
            {
                c = a.this;
                a = listview;
                b = view;
                super();
            }
            });
        }
        int i1 = 0;
        int j1;
        do
        {
            j1 = ((flag) ? 1 : 0);
            if (i1 >= s.length)
            {
                break;
            }
            r.add(new Point());
            i1++;
        } while (true);
        for (; j1 < s.length; j1++)
        {
            viewgroup = layoutinflater.findViewById(s[j1]);
            viewgroup.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(j1, viewgroup) {

                private int a;
                private View b;
                private a c;

                public final void onGlobalLayout()
                {
                    Point point = (Point)a.a(c).get(a);
                    int k1 = point.x;
                    int i2 = point.y;
                    if (k1 == 0 || i2 == 0)
                    {
                        int l1 = b.getWidth();
                        int j2 = b.getHeight();
                        if (l1 > 0 && j2 > 0)
                        {
                            point.x = l1;
                            point.y = j2;
                            myobfuscated.f.m.a(b, this);
                            a.a(c, b);
                        }
                    }
                }

            
            {
                c = a.this;
                a = i1;
                b = view;
                super();
            }
            });
        }

        return layoutinflater;
    }

    public final void onDestroyView()
    {
        super.onDestroyView();
        if (n != null)
        {
            n.b();
            n = null;
        }
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        view = getView();
        if (view != null && h)
        {
            h = false;
            view.setVisibility(8);
            b(true);
        }
    }

}
