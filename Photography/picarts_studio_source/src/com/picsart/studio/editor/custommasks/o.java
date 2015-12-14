// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.animation.Animator;
import android.app.Activity;
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
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import myobfuscated.bw.d;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            p

public class o
{

    public RelativeLayout a;
    d b;
    d c;
    private final p d;
    private Bitmap e;
    private Bitmap f;
    private long g;
    private boolean h;
    private ImageView i;
    private TextView j;
    private TextView k;
    private long l;
    private boolean m;
    private int n;
    private int o;
    private android.animation.Animator.AnimatorListener p;
    private boolean q;
    private Activity r;
    private Handler s;
    private int t;

    public o(Activity activity, p p1)
    {
        (new StringBuilder()).append(com/picsart/studio/editor/custommasks/o.getSimpleName()).append("_").append(System.currentTimeMillis());
        a = null;
        e = null;
        f = null;
        g = 0L;
        h = true;
        i = null;
        j = null;
        b = null;
        c = null;
        k = null;
        l = 0L;
        m = true;
        n = -1;
        o = -1;
        p = null;
        q = false;
        r = null;
        s = null;
        t = 0;
        r = activity;
        d = p1;
    }

    static int a(o o1)
    {
        return o1.n;
    }

    static int a(o o1, int i1)
    {
        o1.o = i1;
        return i1;
    }

    static long a(o o1, long l1)
    {
        o1.l = l1;
        return l1;
    }

    static Bitmap a(o o1, Bitmap bitmap)
    {
        o1.e = bitmap;
        return bitmap;
    }

    static void a(o o1, boolean flag)
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
        o1.k.animate().setStartDelay(j1).alpha(i1).setListener(o1. new android.animation.Animator.AnimatorListener(flag) {

            private boolean a;
            private o b;

            public final void onAnimationCancel(Animator animator)
            {
            }

            public final void onAnimationEnd(Animator animator)
            {
                if (a)
                {
                    o.g(b).setVisibility(0);
                    return;
                } else
                {
                    o.g(b).setVisibility(4);
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
                b = o.this;
                a = flag;
                super();
            }
        });
    }

    static int b(o o1, int i1)
    {
        o1.n = i1;
        return i1;
    }

    static long b(o o1, long l1)
    {
        o1.g = l1;
        return l1;
    }

    static Bitmap b(o o1, Bitmap bitmap)
    {
        o1.f = bitmap;
        return bitmap;
    }

    static void b(o o1)
    {
        o1.n = -1;
        o1.g = 0L;
        o1.a.clearAnimation();
        o1.a.animate().setDuration(300L).setStartDelay(100L).setListener(o1. new android.animation.Animator.AnimatorListener() {

            private o a;

            public final void onAnimationCancel(Animator animator)
            {
                a.a.setVisibility(4);
                if (com.picsart.studio.editor.custommasks.o.c(a) != null && !com.picsart.studio.editor.custommasks.o.c(a).equals(o.l(a)))
                {
                    com.socialin.android.util.c.a(com.picsart.studio.editor.custommasks.o.c(a));
                }
                com.picsart.studio.editor.custommasks.o.d(a, false);
            }

            public final void onAnimationEnd(Animator animator)
            {
                a.a.setVisibility(4);
                if (com.picsart.studio.editor.custommasks.o.c(a) != null && !com.picsart.studio.editor.custommasks.o.c(a).equals(o.l(a)))
                {
                    com.socialin.android.util.c.a(com.picsart.studio.editor.custommasks.o.c(a));
                }
                com.picsart.studio.editor.custommasks.o.d(a, false);
            }

            public final void onAnimationRepeat(Animator animator)
            {
            }

            public final void onAnimationStart(Animator animator)
            {
                com.picsart.studio.editor.custommasks.o.d(a, true);
            }

            
            {
                a = o.this;
                super();
            }
        }).alpha(0.0F).start();
    }

    static boolean b(o o1, boolean flag)
    {
        o1.m = flag;
        return flag;
    }

    static Bitmap c(o o1)
    {
        return o1.e;
    }

    static boolean c(o o1, boolean flag)
    {
        o1.h = flag;
        return flag;
    }

    static int d(o o1)
    {
        return o1.o;
    }

    static boolean d(o o1, boolean flag)
    {
        o1.q = flag;
        return flag;
    }

    static long e(o o1)
    {
        return o1.l;
    }

    static boolean f(o o1)
    {
        return o1.m;
    }

    static TextView g(o o1)
    {
        return o1.k;
    }

    static long h(o o1)
    {
        return o1.g;
    }

    static boolean i(o o1)
    {
        return o1.q;
    }

    static boolean j(o o1)
    {
        return o1.h;
    }

    static Handler k(o o1)
    {
        return o1.s;
    }

    static Bitmap l(o o1)
    {
        return o1.f;
    }

    static ImageView m(o o1)
    {
        return o1.i;
    }

    static p n(o o1)
    {
        return o1.d;
    }

    static TextView o(o o1)
    {
        return o1.j;
    }

    static void p(o o1)
    {
        o1.i.setImageBitmap(o1.e);
    }

    static Activity q(o o1)
    {
        return o1.r;
    }

    static int r(o o1)
    {
        return o1.t;
    }

    static android.animation.Animator.AnimatorListener s(o o1)
    {
        return o1.p;
    }

    public final void a(View view)
    {
        i = (ImageView)view.findViewById(0x7f1005cd);
        j = (TextView)view.findViewById(0x7f1005ce);
        a = (RelativeLayout)view.findViewById(0x7f1005cc);
        t = (int)(r.getResources().getDimension(0x7f0b0095) + 0.5F);
        s = new Handler() {

            private o a;

            public final void handleMessage(Message message)
            {
                super.handleMessage(message);
                if (message.arg1 == o.a(a))
                {
                    o.b(a);
                }
            }

            
            {
                a = o.this;
                super();
            }
        };
        p = new android.animation.Animator.AnimatorListener() {

            private o a;

            public final void onAnimationCancel(Animator animator)
            {
            }

            public final void onAnimationEnd(Animator animator)
            {
                if (com.picsart.studio.editor.custommasks.o.c(a) != null && !com.picsart.studio.editor.custommasks.o.c(a).isRecycled() && a.a.getVisibility() != 0)
                {
                    a.a.setAlpha(0.0F);
                    a.a.animate().setDuration(300L).setListener(null).alpha(1.0F);
                    a.a.setVisibility(0);
                }
            }

            public final void onAnimationRepeat(Animator animator)
            {
            }

            public final void onAnimationStart(Animator animator)
            {
            }

            
            {
                a = o.this;
                super();
            }
        };
        k = (TextView)r.findViewById(0x7f1006b6);
        new d() {

            private o a;

            public final void a()
            {
            }

            public final boolean a(View view1, MotionEvent motionevent)
            {
                if (com.picsart.studio.editor.custommasks.o.d(a) != view1.hashCode())
                {
                    o.a(a, 0L);
                    o.a(a, false);
                    o.a(a, view1.hashCode());
                }
                if (motionevent.getAction() != 10) goto _L2; else goto _L1
_L1:
                o.a(a, -1);
                o.a(a, 0L);
                o.a(a, false);
_L4:
                return false;
_L2:
                if (o.e(a) == 0L)
                {
                    o.a(a, System.currentTimeMillis());
                    return false;
                }
                if (System.currentTimeMillis() - o.e(a) < 300L)
                {
                    o.b(a, true);
                    return false;
                }
                if (motionevent.getAction() != 9 && !o.f(a)) goto _L4; else goto _L3
_L3:
                o.b(a, false);
                android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)o.g(a).getLayoutParams();
                int ai[] = new int[2];
                view1.getLocationOnScreen(ai);
                layoutparams.leftMargin = (int)((float)ai[0] + motionevent.getX() + 5F);
                layoutparams.topMargin = (int)((float)ai[1] + motionevent.getY()) + 10;
                o.g(a).setLayoutParams(layoutparams);
                if (view1.getId() != 0x7f100762) goto _L6; else goto _L5
_L5:
                o.g(a).setText(0x7f080435);
_L8:
                o.a(a, true);
                return false;
_L6:
                if (view1.getId() == 0x7f1006f9)
                {
                    o.g(a).setText(0x7f080432);
                } else
                if (view1.getId() == 0x7f10018b)
                {
                    o.g(a).setText(0x7f080362);
                } else
                if (view1.getId() == 0x7f100136)
                {
                    o.g(a).setText(0x7f080433);
                } else
                if (view1.getId() == 0x7f10018c)
                {
                    o.g(a).setText(0x7f080434);
                }
                if (true) goto _L8; else goto _L7
_L7:
            }

            
            {
                a = o.this;
                super();
            }
        };
        b = new d() {

            private o a;

            public final void a()
            {
            }

            public final boolean a(View view1, MotionEvent motionevent)
            {
                if (o.h(a) != 0L) goto _L2; else goto _L1
_L1:
                o.b(a, System.currentTimeMillis());
_L4:
                return true;
_L2:
                if (System.currentTimeMillis() - o.h(a) >= 300L && !o.i(a))
                {
                    break; /* Loop/switch isn't completed */
                }
                com.picsart.studio.editor.custommasks.o.c(a, true);
                if (motionevent.getAction() == 9 || motionevent.getAction() == 10)
                {
                    o.b(a, 0L);
                    return true;
                }
                if (true) goto _L4; else goto _L3
_L3:
                if (motionevent.getAction() == 9 || o.j(a))
                {
                    o.k(a).removeMessages(0);
                    int ai[] = new int[2];
                    view1.getLocationOnScreen(ai);
                    String s1;
                    int i1;
                    int j1;
                    int k1;
                    if (o.a(a) != -1)
                    {
                        i1 = 300;
                    } else
                    {
                        i1 = 0;
                    }
                    o.b(a, view1.hashCode());
                    if (com.picsart.studio.editor.custommasks.o.c(a) != null && !com.picsart.studio.editor.custommasks.o.c(a).equals(o.l(a)))
                    {
                        com.socialin.android.util.c.a(com.picsart.studio.editor.custommasks.o.c(a));
                        o.a(a, null);
                    }
                    s1 = ((TextView)view1.findViewById(0x7f100234)).getText().toString();
                    if (o.l(a) != null)
                    {
                        com.socialin.android.util.c.a(o.l(a));
                        o.b(a, null);
                        o.m(a).setImageBitmap(null);
                    }
                    o.b(a, o.n(a).a(view1, false, 0));
                    if (o.l(a) == null)
                    {
                        o.b(a);
                        return true;
                    }
                    o.o(a).setText(s1);
                    o.a(a, o.l(a));
                    o.m(a).setImageBitmap(com.picsart.studio.editor.custommasks.o.c(a));
                    o.p(a);
                    j1 = (o.l(a).getWidth() - view1.getWidth()) / 2;
                    k1 = ((o.l(a).getHeight() + (int)Utils.a(2.0F, o.q(a).getApplicationContext()) + o.o(a).getMeasuredHeight()) - view1.getMeasuredHeight()) / 2;
                    if (o.q(a).getResources().getConfiguration().orientation == 2)
                    {
                        j1 = (int)Math.min(Math.max(ai[1] - o.r(a) - k1, 0), (float)((View)a.a.getParent()).getMeasuredHeight() - Utils.a(2.0F, o.q(a).getApplicationContext()) - (float)o.l(a).getHeight() - (float)o.o(a).getMeasuredHeight());
                        a.a.animate().translationY(j1).translationX((float)(ai[0] - o.l(a).getWidth()) - Utils.a(7F, o.q(a).getApplicationContext())).setDuration(i1).setListener(o.s(a));
                    } else
                    {
                        j1 = Math.min(Math.max(ai[0] - j1, 0), ((View)a.a.getParent()).getMeasuredWidth() - o.l(a).getWidth());
                        float f1 = ai[1] - o.l(a).getHeight() - o.o(a).getMeasuredHeight();
                        float f2 = Utils.a(7F, o.q(a).getApplicationContext());
                        a.a.animate().translationX(j1).translationY(f1 - f2).setDuration(i1).setListener(o.s(a));
                    }
                    if (o.j(a))
                    {
                        com.picsart.studio.editor.custommasks.o.c(a, false);
                    }
                }
                if (motionevent.getAction() == 10)
                {
                    motionevent = o.k(a).obtainMessage();
                    motionevent.what = 0;
                    motionevent.arg1 = view1.hashCode();
                    o.k(a).sendMessageDelayed(motionevent, 300L);
                    return true;
                }
                if (true) goto _L4; else goto _L5
_L5:
            }

            
            {
                a = o.this;
                super();
            }
        };
        c = new d() {

            private o a;

            public final void a()
            {
            }

            public final boolean a(View view1, MotionEvent motionevent)
            {
                if (o.h(a) != 0L) goto _L2; else goto _L1
_L1:
                o.b(a, System.currentTimeMillis());
_L4:
                return true;
_L2:
                if (System.currentTimeMillis() - o.h(a) >= 300L && !o.i(a))
                {
                    break; /* Loop/switch isn't completed */
                }
                com.picsart.studio.editor.custommasks.o.c(a, true);
                if (motionevent.getAction() == 9 || motionevent.getAction() == 10)
                {
                    o.b(a, 0L);
                    return true;
                }
                if (true) goto _L4; else goto _L3
_L3:
                if (motionevent.getAction() != 9 && !o.j(a))
                {
                    continue; /* Loop/switch isn't completed */
                }
                o.k(a).removeMessages(0);
                int ai[] = new int[2];
                view1.getLocationOnScreen(ai);
                int i1;
                int j1;
                if (o.a(a) != -1)
                {
                    i1 = 300;
                } else
                {
                    i1 = 0;
                }
                o.b(a, view1.hashCode());
                if (com.picsart.studio.editor.custommasks.o.c(a) != null && !com.picsart.studio.editor.custommasks.o.c(a).equals(o.l(a)))
                {
                    com.socialin.android.util.c.a(com.picsart.studio.editor.custommasks.o.c(a));
                    o.a(a, null);
                }
                if (o.l(a) != null)
                {
                    com.socialin.android.util.c.a(o.l(a));
                    o.b(a, null);
                }
                o.o(a).setText(((TextView)view1).getText());
                o.b(a, o.n(a).a(view1, true, ((Integer)view1.getTag()).intValue()));
                if (o.l(a) == null) goto _L4; else goto _L5
_L5:
                o.a(a, o.l(a));
                o.p(a);
                j1 = Math.min(ai[1] - view1.getHeight(), ((View)a.a.getParent()).getMeasuredHeight() - o.l(a).getHeight() - o.o(a).getMeasuredHeight() - (int)Utils.a(2.0F, o.q(a).getApplicationContext()));
                a.a.animate().translationX(ai[0] + view1.getWidth()).translationY(j1).setDuration(i1).setListener(o.s(a));
                if (o.j(a))
                {
                    com.picsart.studio.editor.custommasks.o.c(a, false);
                }
                if (motionevent.getAction() != 10) goto _L4; else goto _L6
_L6:
                motionevent = o.k(a).obtainMessage();
                motionevent.what = 0;
                motionevent.arg1 = view1.hashCode();
                o.k(a).sendMessageDelayed(motionevent, 300L);
                return true;
            }

            
            {
                a = o.this;
                super();
            }
        };
    }
}
