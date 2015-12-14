// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ac;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ao;
import com.cyberlink.youcammakeup.widgetpool.dialogs.l;
import com.cyberlink.youcammakeup.widgetpool.dialogs.m;
import com.cyberlink.youcammakeup.widgetpool.dialogs.v;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import com.cyberlink.youcammakeup.widgetpool.dialogs.x;
import com.cyberlink.youcammakeup.widgetpool.dialogs.y;
import com.cyberlink.youcammakeup.widgetpool.dialogs.z;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            l, q, r, p

public class o
{

    private static boolean a;
    private static StatusManager e = StatusManager.j();
    private static Fragment f;
    private static com.cyberlink.youcammakeup.utility.l l = new com.cyberlink.youcammakeup.utility.l();
    private static l m = new l();
    private boolean b;
    private boolean c;
    private boolean d;
    private ac g;
    private v h;
    private z i;
    private r j;
    private q k;

    public o()
    {
        a = false;
        g = new ac();
    }

    static r a(o o1)
    {
        return o1.j;
    }

    public static void a(Activity activity)
    {
        boolean flag = false;
        Object obj = e.o();
        if (obj != null)
        {
            a = false;
            if (obj.equals(Globals.d().v()))
            {
                e.a(f, activity);
                return;
            }
            if (activity instanceof BaseActivity)
            {
                flag = ((BaseActivity)activity).b();
            }
            if (f instanceof DialogFragment)
            {
                if (((DialogFragment)f).getFragmentManager() != null && ((DialogFragment)f).getActivity() != null && f.getActivity().equals(activity))
                {
                    ((DialogFragment)f).dismissAllowingStateLoss();
                }
                f = null;
                return;
            }
            obj = activity.findViewById(0x7f0c0002);
            if (f != null && obj != null && !activity.isFinishing() && !flag)
            {
                if (f.getActivity() != null && f.getActivity().equals(activity))
                {
                    FragmentTransaction fragmenttransaction = activity.getFragmentManager().beginTransaction();
                    fragmenttransaction.remove(f);
                    fragmenttransaction.commitAllowingStateLoss();
                }
                f = null;
                activity.runOnUiThread(new Runnable(((View) (obj))) {

                    final View a;

                    public void run()
                    {
                        if (a != null)
                        {
                            a.setVisibility(8);
                        }
                    }

            
            {
                a = view;
                super();
            }
                });
                return;
            }
        }
    }

    public static void a(Activity activity, DialogFragment dialogfragment, String s)
    {
        if (!b(activity))
        {
            return;
        } else
        {
            a(activity.getFragmentManager(), dialogfragment, s);
            return;
        }
    }

    public static void a(FragmentManager fragmentmanager, int i1, String s, int j1, int k1, int l1, m m1, android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        m.a(i1);
        m.a(s);
        m.b(j1);
        m.c(k1);
        m.d(l1);
        m.a(m1);
        m.a(ondismisslistener);
        a(fragmentmanager, ((DialogFragment) (m)), "HintInputTextDialog");
    }

    public static void a(FragmentManager fragmentmanager, DialogFragment dialogfragment, String s)
    {
        if (StatusManager.j().o() == null || !StatusManager.j().o().equals(Globals.d().v()))
        {
            break MISSING_BLOCK_LABEL_37;
        }
        StatusManager.j().a(fragmentmanager, dialogfragment, s);
_L1:
        return;
        if (android.os.Build.VERSION.SDK_INT < 17 || !fragmentmanager.isDestroyed())
        {
            FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();
            fragmentmanager = fragmentmanager.findFragmentByTag(s);
            if (fragmentmanager != null)
            {
                fragmenttransaction.remove(fragmentmanager);
            }
            fragmenttransaction.addToBackStack(null);
            dialogfragment.show(fragmenttransaction, s);
            return;
        }
          goto _L1
        fragmentmanager;
    }

    public static void a(FragmentManager fragmentmanager, View view, android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        a(fragmentmanager, view, ondismisslistener, false);
    }

    private static void a(FragmentManager fragmentmanager, View view, android.content.DialogInterface.OnDismissListener ondismisslistener, boolean flag)
    {
        l.a(view);
        l.a(ondismisslistener);
        l.a(flag);
        a(fragmentmanager, ((DialogFragment) (l)), "DeleteModeTouchMask");
    }

    static boolean a(o o1, boolean flag)
    {
        o1.c = flag;
        return flag;
    }

    public static void b(FragmentManager fragmentmanager, DialogFragment dialogfragment, String s)
    {
        if (StatusManager.j().o().equals(Globals.d().v()))
        {
            StatusManager.j().b(fragmentmanager, dialogfragment, s);
            return;
        } else
        {
            dialogfragment.dismissAllowingStateLoss();
            return;
        }
    }

    public static void b(FragmentManager fragmentmanager, View view, android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        a(fragmentmanager, view, ondismisslistener, true);
    }

    private static boolean b(Activity activity)
    {
        boolean flag1;
        for (flag1 = true; activity == null || activity.isFinishing();)
        {
            return false;
        }

        boolean flag = flag1;
        if (activity instanceof BaseActivity)
        {
            activity = (BaseActivity)activity;
            if (!activity.g() && !activity.b())
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        return flag;
    }

    static boolean b(o o1)
    {
        return o1.b;
    }

    public static void c()
    {
        l.dismiss();
    }

    public void a(int i1)
    {
        if (f != null)
        {
            g.a(i1);
        }
    }

    public void a(Fragment fragment, Context context, boolean flag)
    {
        if (e.o() == null || !e.o().equals(Globals.d().v()))
        {
            break MISSING_BLOCK_LABEL_46;
        }
        context = (Activity)context;
        e.a(fragment, context, flag);
        f = fragment;
_L1:
        return;
        if (f != null && (f instanceof DialogFragment))
        {
            a(context);
        }
        a = true;
        f = fragment;
        Object obj1 = (Activity)context;
        if (b(((Activity) (obj1))))
        {
            if (fragment instanceof DialogFragment)
            {
                a(((Activity) (obj1)), (DialogFragment)fragment, fragment.getTag());
                return;
            }
            RelativeLayout relativelayout = (RelativeLayout)((Activity) (obj1)).findViewById(0x7f0c0002);
            Object obj = relativelayout;
            if (relativelayout == null)
            {
                FrameLayout framelayout = (FrameLayout)((Activity) (obj1)).getWindow().getDecorView();
                obj = (FrameLayout)((Activity) (obj1)).findViewById(0x1020002);
                obj1 = new RelativeLayout(Globals.d().getApplicationContext());
                Object obj2 = new Rect();
                ((FrameLayout) (obj)).getWindowVisibleDisplayFrame(((Rect) (obj2)));
                obj = new RelativeLayout(Globals.d().getApplicationContext());
                obj2 = new android.widget.RelativeLayout.LayoutParams(((Rect) (obj2)).width(), ((Rect) (obj2)).height());
                ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(13);
                framelayout.addView(((View) (obj1)), new android.widget.RelativeLayout.LayoutParams(-1, -1));
                ((RelativeLayout) (obj1)).addView(((View) (obj)), ((android.view.ViewGroup.LayoutParams) (obj2)));
                ((RelativeLayout) (obj)).setId(0x7f0c0002);
                ((RelativeLayout) (obj)).setClickable(true);
            }
            if (flag)
            {
                ((RelativeLayout) (obj)).setBackgroundColor(0);
            } else
            {
                ((RelativeLayout) (obj)).setBackgroundColor(Color.parseColor("#C2000000"));
            }
            context = ((Activity)context).getFragmentManager().beginTransaction();
            context.replace(0x7f0c0002, fragment);
            context.commitAllowingStateLoss();
            ((RelativeLayout) (obj)).setVisibility(0);
            return;
        }
          goto _L1
        fragment;
    }

    public void a(Context context)
    {
        if (context == null)
        {
            return;
        }
        try
        {
            a((Activity)context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public void a(Context context, int i1, w w)
    {
        c(context);
        y y1 = new y(true, true, true, true, context.getString(0x7f070366), context.getString(0x7f070365));
        h.a(y1);
        h.a(x.a, context.getString(i1));
        h.a(w);
        a(new w(context, w) {

            final Context a;
            final w b;
            final o c;

            public void a(boolean flag)
            {
                c.i(a);
                if (b != null)
                {
                    b.a(flag);
                }
            }

            public void b(boolean flag)
            {
                c.i(a);
                if (b != null)
                {
                    b.b(flag);
                }
            }

            
            {
                c = o.this;
                a = context;
                b = w1;
                super();
            }
        });
    }

    public void a(Context context, long l1)
    {
        ao ao1 = new ao();
        ao1.a(l1);
        a(((Fragment) (ao1)), context, true);
    }

    public void a(Context context, Drawable drawable, String s, boolean flag)
    {
        c(context);
        drawable = new y(true, false, true, false, context.getString(0x7f0703fd), null);
        h.a(drawable);
        h.a(x.a, s);
        a(new w(context) {

            final Context a;
            final o b;

            public void a(boolean flag1)
            {
                b.i(a);
                if (o.a(b) != null)
                {
                    o.a(b).a();
                }
            }

            public void b(boolean flag1)
            {
            }

            
            {
                b = o.this;
                a = context;
                super();
            }
        });
    }

    public void a(Context context, ViewGroup viewgroup, p p)
    {
        b = false;
        c = false;
        Animation animation = AnimationUtils.loadAnimation(context, 0x7f04002d);
        context = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030118, viewgroup, false);
        View view = context.findViewById(0x7f0c0593);
        viewgroup.addView(context);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(animation, viewgroup, context, p) {

            final Animation a;
            final ViewGroup b;
            final View c;
            final p d;
            final o e;

            private void a()
            {
                b.removeView(c);
                d.a();
            }

            public void onAnimationEnd(Animation animation1)
            {
                a();
            }

            public void onAnimationRepeat(Animation animation1)
            {
                o.a(e, true);
                if (o.b(e))
                {
                    a.cancel();
                }
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                e = o.this;
                a = animation;
                b = viewgroup;
                c = view;
                d = p1;
                super();
            }
        });
        k = new q(animation) {

            final Animation a;
            final o b;

            public void a()
            {
                a.cancel();
            }

            
            {
                b = o.this;
                a = animation;
                super();
            }
        };
        viewgroup.post(new Runnable(view, animation) {

            final View a;
            final Animation b;
            final o c;

            public void run()
            {
                a.startAnimation(b);
            }

            
            {
                c = o.this;
                a = view;
                b = animation;
                super();
            }
        });
    }

    public void a(Context context, com.cyberlink.youcammakeup.Globals.ActivityType activitytype, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1, String s)
    {
        i = new z();
        i.a(onclicklistener);
        if (onclicklistener1 != null)
        {
            i.b(onclicklistener1);
        }
        i.a(activitytype);
        if (s != null && !s.isEmpty())
        {
            i.a(s);
        }
        a(((Fragment) (i)), context, true);
    }

    public void a(Context context, w w)
    {
        c(context);
        y y1 = new y(true, false, true, false, context.getString(0x7f0703fd), null);
        h.a(y1);
        h.a(x.a, context.getString(0x7f070370));
        h.a(0);
        a(w);
    }

    public void a(Context context, String s, String s1)
    {
        a(((Fragment) (g)), context, false);
        g.a(s);
        g.b(s1);
    }

    public void a(Context context, boolean flag, boolean flag1, boolean flag2, w w)
    {
        c(context);
        y y1;
        int i1;
        if (!flag2)
        {
            y1 = new y(true, false, true, false, context.getString(0x7f0703fd), context.getString(0x7f070365));
            i1 = 0x7f0700b5;
        } else
        if (flag1)
        {
            y1 = new y(true, true, true, true, context.getString(0x7f0703fc), context.getString(0x7f0703ff));
            i1 = 0x7f070539;
        } else
        {
            y1 = new y(true, true, true, true, context.getString(0x7f0703fc), context.getString(0x7f0703fe));
            i1 = 0x7f070538;
        }
        h.a(y1);
        h.a(x.a, context.getString(i1));
        h.a(w);
        a(new w(context, w) {

            final Context a;
            final w b;
            final o c;

            public void a(boolean flag3)
            {
                c.i(a);
                if (b != null)
                {
                    b.a(flag3);
                }
            }

            public void b(boolean flag3)
            {
                c.i(a);
                if (b != null)
                {
                    b.b(flag3);
                }
            }

            
            {
                c = o.this;
                a = context;
                b = w1;
                super();
            }
        });
    }

    public void a(Drawable drawable, String s)
    {
        if (h != null)
        {
            h.a(drawable, s);
        }
    }

    public void a(q q1)
    {
        k = q1;
    }

    public void a(r r)
    {
        j = r;
    }

    public void a(w w)
    {
        if (h != null)
        {
            h.a(w);
        }
    }

    public void a(y y1)
    {
        if (h != null)
        {
            h.a(y1);
        }
    }

    public void a(boolean flag)
    {
        b = true;
        if (flag && c)
        {
            k.a();
        }
    }

    public boolean a()
    {
        return a;
    }

    public void b(Context context)
    {
        if (d)
        {
            return;
        } else
        {
            a(new ao(), context, true);
            return;
        }
    }

    public void b(Drawable drawable, String s)
    {
        if (h != null)
        {
            h.a(drawable, s);
        }
    }

    public void b(boolean flag)
    {
        d = flag;
    }

    public boolean b()
    {
        return f != null && (f instanceof ao);
    }

    public void c(Context context)
    {
        h = new v();
        a(h, context, true);
    }

    public void d(Context context)
    {
        if (h == null)
        {
            return;
        } else
        {
            String s = context.getString(0x7f070402);
            context = new y(true, true, true, true, context.getString(0x7f0703fd), context.getString(0x7f0703fa));
            h.a(context);
            h.a(x.a, s);
            return;
        }
    }

    public void e(Context context)
    {
        if (h == null)
        {
            return;
        } else
        {
            String s = context.getString(0x7f070060);
            context = new y(true, false, true, false, context.getString(0x7f0703fd), context.getString(0x7f0703fd));
            h.a(context);
            h.a(x.a, s);
            return;
        }
    }

    public void f(Context context)
    {
        if (h == null)
        {
            return;
        } else
        {
            String s = context.getString(0x7f07005d);
            context = new y(true, false, true, false, context.getString(0x7f0703fd), context.getString(0x7f0703fd));
            h.a(context);
            h.a(x.a, s);
            return;
        }
    }

    public void g(Context context)
    {
        a(context);
    }

    public void h(Context context)
    {
        if (!d)
        {
            a(context);
        }
    }

    public void i(Context context)
    {
        a(context);
    }

    public void j(Context context)
    {
        a(context, context.getString(0x7f070341), context.getString(0x7f07048e));
    }

    public void k(Context context)
    {
        a(context);
    }

    public void l(Context context)
    {
        a(context);
    }

}
