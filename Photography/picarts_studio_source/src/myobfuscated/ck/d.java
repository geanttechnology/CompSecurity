// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.photo.effect.Effect;
import com.socialin.android.util.c;
import myobfuscated.bw.a;
import myobfuscated.ci.b;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.ck:
//            c

public class d
{

    public final String a = (new StringBuilder()).append(myobfuscated/ck/d.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
    Bitmap b;
    Bitmap c;
    ImageView d;
    TextView e;
    public RelativeLayout f;
    myobfuscated.bw.d g;
    myobfuscated.bw.d h;
    TextView i;
    long j;
    android.animation.Animator.AnimatorListener k;
    Context l;
    Handler m;
    myobfuscated.ck.c n;
    private Object o;
    private long p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private boolean u;

    public d(Context context, myobfuscated.ck.c c1)
    {
        b = null;
        c = null;
        o = null;
        p = 0L;
        q = true;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = 0L;
        r = true;
        s = -1;
        t = -1;
        k = null;
        u = false;
        l = null;
        m = null;
        n = c1;
        l = context;
    }

    static int a(d d1)
    {
        return d1.s;
    }

    static int a(d d1, int i1)
    {
        d1.t = i1;
        return i1;
    }

    static long a(d d1, long l1)
    {
        d1.j = l1;
        return l1;
    }

    static Bitmap a(d d1, Bitmap bitmap)
    {
        d1.c = bitmap;
        return bitmap;
    }

    static Object a(d d1, Object obj)
    {
        d1.o = null;
        return null;
    }

    public static void a(View view)
    {
        myobfuscated.f.m.f().a(view, null);
    }

    static void a(d d1, boolean flag)
    {
        int j1 = 0;
        int i1;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (!flag)
        {
            j1 = 200;
        }
        d1.i.animate().setStartDelay(j1).alpha(i1).setListener(d1. new android.animation.Animator.AnimatorListener(flag) {

            private boolean a;
            private d b;

            public final void onAnimationCancel(Animator animator)
            {
            }

            public final void onAnimationEnd(Animator animator)
            {
                if (a)
                {
                    d.g(b).setVisibility(0);
                    return;
                } else
                {
                    d.g(b).setVisibility(4);
                    return;
                }
            }

            public final void onAnimationRepeat(Animator animator)
            {
            }

            public final void onAnimationStart(Animator animator)
            {
            }

            
            {
                b = d.this;
                a = flag;
                super();
            }
        });
    }

    static int b(d d1, int i1)
    {
        d1.s = i1;
        return i1;
    }

    static long b(d d1, long l1)
    {
        d1.p = l1;
        return l1;
    }

    static Bitmap b(d d1, Bitmap bitmap)
    {
        d1.b = bitmap;
        return bitmap;
    }

    static void b(d d1)
    {
        d1.s = -1;
        d1.p = 0L;
        d1.f.clearAnimation();
        d1.f.animate().setDuration(300L).setStartDelay(100L).setListener(d1. new android.animation.Animator.AnimatorListener() {

            private d a;

            public final void onAnimationCancel(Animator animator)
            {
                a.f.setVisibility(4);
                d.o(a).setImageBitmap(null);
                if (myobfuscated.ck.d.c(a) != null && !myobfuscated.ck.d.c(a).equals(d.k(a)))
                {
                    com.socialin.android.util.c.a(myobfuscated.ck.d.c(a));
                }
                d.d(a, false);
            }

            public final void onAnimationEnd(Animator animator)
            {
                a.f.setVisibility(4);
                d.o(a).setImageBitmap(null);
                if (myobfuscated.ck.d.c(a) != null && !myobfuscated.ck.d.c(a).equals(d.k(a)))
                {
                    com.socialin.android.util.c.a(myobfuscated.ck.d.c(a));
                }
                d.d(a, false);
            }

            public final void onAnimationRepeat(Animator animator)
            {
            }

            public final void onAnimationStart(Animator animator)
            {
                d.d(a, true);
            }

            
            {
                a = d.this;
                super();
            }
        }).alpha(0.0F).start();
    }

    static boolean b(d d1, boolean flag)
    {
        d1.r = flag;
        return flag;
    }

    static Bitmap c(d d1)
    {
        return d1.b;
    }

    static boolean c(d d1, boolean flag)
    {
        d1.q = flag;
        return flag;
    }

    static int d(d d1)
    {
        return d1.t;
    }

    static boolean d(d d1, boolean flag)
    {
        d1.u = flag;
        return flag;
    }

    static long e(d d1)
    {
        return d1.j;
    }

    static boolean f(d d1)
    {
        return d1.r;
    }

    static TextView g(d d1)
    {
        return d1.i;
    }

    static long h(d d1)
    {
        return d1.p;
    }

    static boolean i(d d1)
    {
        return d1.u;
    }

    static boolean j(d d1)
    {
        return d1.q;
    }

    static Bitmap k(d d1)
    {
        return d1.c;
    }

    static myobfuscated.ck.c l(d d1)
    {
        return d1.n;
    }

    static Context m(d d1)
    {
        return d1.l;
    }

    static Handler n(d d1)
    {
        return d1.m;
    }

    static ImageView o(d d1)
    {
        return d1.d;
    }

    static TextView p(d d1)
    {
        return d1.e;
    }

    static Object q(d d1)
    {
        return d1.o;
    }

    static void r(d d1)
    {
        d1.a();
    }

    static android.animation.Animator.AnimatorListener s(d d1)
    {
        return d1.k;
    }

    final void a()
    {
        d.setImageBitmap(b);
    }

    // Unreferenced inner class myobfuscated/ck/d$1

/* anonymous class */
    final class _cls1 extends Handler
    {

        private d a;

        public final void handleMessage(Message message)
        {
            super.handleMessage(message);
            if (message.arg1 == myobfuscated.ck.d.a(a))
            {
                myobfuscated.ck.d.b(a);
            }
        }

            
            {
                a = d.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/d$2

/* anonymous class */
    final class _cls2
        implements android.animation.Animator.AnimatorListener
    {

        private d a;

        public final void onAnimationCancel(Animator animator)
        {
        }

        public final void onAnimationEnd(Animator animator)
        {
            if (myobfuscated.ck.d.c(a) != null && !myobfuscated.ck.d.c(a).isRecycled() && a.f.getVisibility() != 0)
            {
                a.f.setAlpha(0.0F);
                a.f.animate().setDuration(300L).setListener(null).alpha(1.0F);
                a.f.setVisibility(0);
            }
        }

        public final void onAnimationRepeat(Animator animator)
        {
        }

        public final void onAnimationStart(Animator animator)
        {
        }

            
            {
                a = d.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/d$3

/* anonymous class */
    final class _cls3
        implements myobfuscated.bw.d
    {

        private d a;

        public final void a()
        {
        }

        public final boolean a(View view, MotionEvent motionevent)
        {
            if (d.d(a) != view.hashCode())
            {
                myobfuscated.ck.d.a(a, 0L);
                myobfuscated.ck.d.a(a, false);
                myobfuscated.ck.d.a(a, view.hashCode());
            }
            if (motionevent.getAction() != 10) goto _L2; else goto _L1
_L1:
            myobfuscated.ck.d.a(a, -1);
            myobfuscated.ck.d.a(a, 0L);
            myobfuscated.ck.d.a(a, false);
_L4:
            return false;
_L2:
            if (d.e(a) == 0L)
            {
                myobfuscated.ck.d.a(a, System.currentTimeMillis());
                return false;
            }
            if (System.currentTimeMillis() - d.e(a) < 300L)
            {
                myobfuscated.ck.d.b(a, true);
                return false;
            }
            if (motionevent.getAction() != 9 && !d.f(a)) goto _L4; else goto _L3
_L3:
            myobfuscated.ck.d.b(a, false);
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)d.g(a).getLayoutParams();
            int ai[] = new int[2];
            view.getLocationOnScreen(ai);
            layoutparams.leftMargin = (int)((float)ai[0] + motionevent.getX());
            d.g(a).setLayoutParams(layoutparams);
            if (view.getId() != 0x7f100762) goto _L6; else goto _L5
_L5:
            d.g(a).setText(0x7f080435);
_L8:
            myobfuscated.ck.d.a(a, true);
            return false;
_L6:
            if (view.getId() == 0x7f1006f9)
            {
                d.g(a).setText(0x7f080432);
            } else
            if (view.getId() == 0x7f10018b)
            {
                d.g(a).setText(0x7f080362);
            } else
            if (view.getId() == 0x7f100136)
            {
                d.g(a).setText(0x7f080433);
            } else
            if (view.getId() == 0x7f10018c)
            {
                d.g(a).setText(0x7f080434);
            } else
            if (view.getId() == 0x7f100761)
            {
                d.g(a).setText(0x7f0802a4);
            } else
            if (view.getId() == 0x7f100540)
            {
                d.g(a).setText(0x7f0802b8);
            }
            if (true) goto _L8; else goto _L7
_L7:
        }

            
            {
                a = d.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/d$4

/* anonymous class */
    final class _cls4
        implements myobfuscated.bw.d
    {

        private d a;

        public final void a()
        {
        }

        public final boolean a(View view, MotionEvent motionevent)
        {
            if (d.h(a) != 0L) goto _L2; else goto _L1
_L1:
            myobfuscated.ck.d.b(a, System.currentTimeMillis());
_L4:
            return true;
_L2:
            if (System.currentTimeMillis() - d.h(a) >= 300L && !d.i(a))
            {
                break; /* Loop/switch isn't completed */
            }
            myobfuscated.ck.d.c(a, true);
            if (motionevent.getAction() == 9 || motionevent.getAction() == 10)
            {
                myobfuscated.ck.d.b(a, 0L);
                return true;
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (motionevent.getAction() != 9 && !d.j(a))
            {
                continue; /* Loop/switch isn't completed */
            }
            if (d.k(a) == null && d.l(a) != null)
            {
                myobfuscated.ck.d.a(a, d.l(a).a(myobfuscated.ck.d.m(a)));
            }
            if (d.k(a) == null) goto _L4; else goto _L5
_L5:
            d.n(a).removeMessages(0);
            int ai[] = new int[2];
            view.getLocationOnScreen(ai);
            Object obj;
            String s1;
            int i1;
            int j1;
            int k1;
            if (myobfuscated.ck.d.a(a) != -1)
            {
                i1 = 300;
            } else
            {
                i1 = 0;
            }
            myobfuscated.ck.d.b(a, view.hashCode());
            if (myobfuscated.ck.d.c(a) != null && !myobfuscated.ck.d.c(a).equals(d.k(a)))
            {
                d.o(a).setImageBitmap(null);
                com.socialin.android.util.c.a(myobfuscated.ck.d.c(a));
                myobfuscated.ck.d.b(a, null);
            }
            obj = (String)((ImageView)view.findViewById(0x7f100233)).getTag();
            s1 = (String)((TextView)view.findViewById(0x7f100234)).getTag();
            d.p(a).setText(s1);
            if (d.q(a) == null && d.l(a) != null)
            {
                myobfuscated.ck.d.a(a, null);
            }
            if (((String) (obj)).compareTo("None") == 0)
            {
                myobfuscated.ck.d.b(a, d.k(a));
                d.r(a);
            } else
            {
                d d1 = a;
                if (obj != null && ((String) (obj)).compareTo("None") != 0)
                {
                    obj = d1.n.h.a(((String) (obj)));
                    if (obj != null && ((b) (obj)).b)
                    {
                        d1.b = ((b) (obj)).a(d1.l).a(d1.l, d1.c);
                        if (d1.b != null)
                        {
                            com.socialin.android.util.c.a(d1.b, d1.a, false);
                        }
                        d1.a();
                    }
                }
            }
            j1 = (d.k(a).getWidth() - view.getWidth()) / 2;
            k1 = ((d.k(a).getHeight() + d.p(a).getMeasuredHeight()) - view.getHeight()) / 2;
            if (myobfuscated.ck.d.m(a).getResources().getConfiguration().orientation == 2)
            {
                j1 = Math.min(Math.max(ai[1] - k1, 0), ((View)a.f.getParent()).getMeasuredHeight() - (d.k(a).getHeight() + d.p(a).getMeasuredHeight()));
                a.f.animate().translationY(j1).setDuration(i1).setListener(d.s(a));
            } else
            {
                j1 = Math.min(Math.max(0, ai[0] - j1), ((View)a.f.getParent()).getMeasuredWidth() - d.k(a).getWidth());
                a.f.animate().translationX(j1).setDuration(i1).setListener(d.s(a));
            }
            if (d.j(a))
            {
                myobfuscated.ck.d.c(a, false);
            }
            if (motionevent.getAction() != 10) goto _L4; else goto _L6
_L6:
            motionevent = d.n(a).obtainMessage();
            motionevent.what = 0;
            motionevent.arg1 = view.hashCode();
            d.n(a).sendMessageDelayed(motionevent, 300L);
            return true;
        }

            
            {
                a = d.this;
                super();
            }
    }

}
