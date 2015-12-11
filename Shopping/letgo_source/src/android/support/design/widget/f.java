// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.ah;
import android.support.v4.widget.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.design.widget:
//            CoordinatorLayout

public class f extends CoordinatorLayout.a
{
    public static interface a
    {

        public abstract void a(int k);

        public abstract void a(View view);
    }

    private class b
        implements Runnable
    {

        final f a;
        private final View b;
        private final boolean c;

        public void run()
        {
            if (f.b(a) != null && f.b(a).a(true))
            {
                ah.a(b, this);
            } else
            if (c && f.a(a) != null)
            {
                f.a(a).a(b);
                return;
            }
        }

        b(View view, boolean flag)
        {
            a = f.this;
            super();
            b = view;
            c = flag;
        }
    }


    private u a;
    private a b;
    private boolean c;
    private float d;
    private boolean e;
    private int f;
    private float g;
    private float h;
    private float i;
    private final android.support.v4.widget.u.a j = new android.support.v4.widget.u.a() {

        final f a;
        private int b;

        private boolean a(View view, float f1)
        {
            if (f1 == 0.0F) goto _L2; else goto _L1
_L1:
            boolean flag;
            if (ah.g(view) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (f.c(a) != 2) goto _L4; else goto _L3
_L3:
            return true;
_L4:
            if (f.c(a) == 0)
            {
                if (!flag)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (f1 >= 0.0F)
                {
                    return false;
                }
                continue; /* Loop/switch isn't completed */
            }
            break MISSING_BLOCK_LABEL_64;
            if (f1 > 0.0F) goto _L3; else goto _L5
_L5:
            return false;
            if (f.c(a) != 1)
            {
                break; /* Loop/switch isn't completed */
            }
            if (!flag)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (f1 <= 0.0F)
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
            if (f1 < 0.0F) goto _L3; else goto _L6
_L6:
            return false;
_L2:
            int k = view.getLeft();
            int l = b;
            int i1 = Math.round((float)view.getWidth() * f.d(a));
            if (Math.abs(k - l) < i1)
            {
                return false;
            }
            if (true) goto _L3; else goto _L7
_L7:
            return false;
        }

        public int a(View view)
        {
            return view.getWidth();
        }

        public int a(View view, int k, int l)
        {
            int i1;
            if (ah.g(view) == 1)
            {
                l = 1;
            } else
            {
                l = 0;
            }
            if (f.c(a) == 0)
            {
                if (l != 0)
                {
                    i1 = b - view.getWidth();
                    l = b;
                } else
                {
                    i1 = b;
                    l = b + view.getWidth();
                }
            } else
            if (f.c(a) == 1)
            {
                if (l != 0)
                {
                    i1 = b;
                    l = b + view.getWidth();
                } else
                {
                    i1 = b - view.getWidth();
                    l = b;
                }
            } else
            {
                i1 = b - view.getWidth();
                l = b + view.getWidth();
            }
            return f.a(i1, k, l);
        }

        public void a(int k)
        {
            if (f.a(a) != null)
            {
                f.a(a).a(k);
            }
        }

        public void a(View view, float f1, float f2)
        {
            int k = view.getWidth();
            boolean flag = false;
            if (a(view, f1))
            {
                if (view.getLeft() < b)
                {
                    k = b - k;
                } else
                {
                    k = b + k;
                }
                flag = true;
            } else
            {
                k = b;
            }
            if (f.b(a).a(k, view.getTop()))
            {
                ah.a(view, a. new b(view, flag));
            } else
            if (flag && f.a(a) != null)
            {
                f.a(a).a(view);
                return;
            }
        }

        public void a(View view, int k, int l, int i1, int j1)
        {
            float f1 = (float)view.getWidth() * f.e(a);
            float f2 = (float)view.getWidth() * f.f(a);
            if ((float)k <= f1)
            {
                ah.c(view, 1.0F);
                return;
            }
            if ((float)k >= f2)
            {
                ah.c(view, 0.0F);
                return;
            } else
            {
                ah.c(view, f.b(0.0F, 1.0F - f.a(f1, f2, k), 1.0F));
                return;
            }
        }

        public boolean a(View view, int k)
        {
            b = view.getLeft();
            return true;
        }

        public int b(View view, int k, int l)
        {
            return view.getTop();
        }

            
            {
                a = f.this;
                super();
            }
    };

    public f()
    {
        d = 0.0F;
        f = 2;
        g = 0.5F;
        h = 0.0F;
        i = 0.5F;
    }

    static float a(float f1, float f2, float f3)
    {
        return (f3 - f1) / (f2 - f1);
    }

    static int a(int k, int l, int i1)
    {
        return b(k, l, i1);
    }

    static a a(f f1)
    {
        return f1.b;
    }

    private void a(ViewGroup viewgroup)
    {
        if (a == null)
        {
            if (e)
            {
                viewgroup = u.a(viewgroup, d, j);
            } else
            {
                viewgroup = u.a(viewgroup, j);
            }
            a = viewgroup;
        }
    }

    static float b(float f1, float f2, float f3)
    {
        return c(f1, f2, f3);
    }

    private static int b(int k, int l, int i1)
    {
        return Math.min(Math.max(k, l), i1);
    }

    static u b(f f1)
    {
        return f1.a;
    }

    private static float c(float f1, float f2, float f3)
    {
        return Math.min(Math.max(f1, f2), f3);
    }

    static int c(f f1)
    {
        return f1.f;
    }

    static float d(f f1)
    {
        return f1.g;
    }

    static float e(f f1)
    {
        return f1.h;
    }

    static float f(f f1)
    {
        return f1.i;
    }

    public int a()
    {
        if (a != null)
        {
            return a.a();
        } else
        {
            return 0;
        }
    }

    public void a(float f1)
    {
        h = c(0.0F, f1, 1.0F);
    }

    public void a(int k)
    {
        f = k;
    }

    public void a(a a1)
    {
        b = a1;
    }

    public boolean a(CoordinatorLayout coordinatorlayout, View view, MotionEvent motionevent)
    {
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 3: default 36
    //                   0 45
    //                   1 81
    //                   2 36
    //                   3 81;
           goto _L1 _L2 _L3 _L1 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_81;
_L4:
        boolean flag;
        if (c)
        {
            return false;
        } else
        {
            a(((ViewGroup) (coordinatorlayout)));
            return a.a(motionevent);
        }
_L2:
        if (!coordinatorlayout.a(view, (int)motionevent.getX(), (int)motionevent.getY()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
          goto _L4
        if (c)
        {
            c = false;
            return false;
        }
          goto _L4
    }

    public void b(float f1)
    {
        i = c(0.0F, f1, 1.0F);
    }

    public boolean b(CoordinatorLayout coordinatorlayout, View view, MotionEvent motionevent)
    {
        if (a != null)
        {
            a.b(motionevent);
            return true;
        } else
        {
            return false;
        }
    }

    // Unreferenced inner class android/support/design/widget/SwipeDismissBehavior$SwipeDirection
    /* block-local class not found */
    class SwipeDismissBehavior.SwipeDirection {}

}
