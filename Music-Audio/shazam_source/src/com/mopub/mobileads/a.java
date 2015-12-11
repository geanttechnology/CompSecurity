// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.b;

// Referenced classes of package com.mopub.mobileads:
//            b

public final class com.mopub.mobileads.a extends android.view.GestureDetector.SimpleOnGestureListener
{
    static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        private static final a f[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/mopub/mobileads/a$a, s);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        static 
        {
            a = new a("UNSET", 0);
            b = new a("GOING_RIGHT", 1);
            c = new a("GOING_LEFT", 2);
            d = new a("FINISHED", 3);
            e = new a("FAILED", 4);
            f = (new a[] {
                a, b, c, d, e
            });
        }

        private a(String s, int k)
        {
            super(s, k);
        }
    }


    final b a;
    com.mopub.mobileads.b b;
    a c;
    View d;
    private float e;
    private float f;
    private boolean g;
    private boolean h;
    private int i;
    private float j;

    com.mopub.mobileads.a(View view, b b1)
    {
        e = 100F;
        c = a.a;
        if (view != null && view.getWidth() > 0)
        {
            e = Math.min(100F, (float)view.getWidth() / 3F);
        }
        d = view;
        a = b1;
    }

    final void a()
    {
        i = 0;
        c = a.a;
    }

    public final boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
    {
        boolean flag3;
        boolean flag4;
        flag4 = true;
        flag3 = true;
        if (c == a.d)
        {
            return super.onScroll(motionevent, motionevent1, f1, f2);
        }
        float f3 = motionevent.getY();
        boolean flag;
        if (Math.abs(motionevent1.getY() - f3) > 100F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            c = a.e;
            return super.onScroll(motionevent, motionevent1, f1, f2);
        }
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[a.values().length];
                try
                {
                    a[a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.mopub.mobileads.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[a.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[a.e.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[c.ordinal()];
        JVM INSTR tableswitch 1 3: default 116
    //                   1 134
    //                   2 164
    //                   3 263;
           goto _L1 _L2 _L3 _L4
_L1:
        f = motionevent1.getX();
        return super.onScroll(motionevent, motionevent1, f1, f2);
_L2:
        j = motionevent.getX();
        if (motionevent1.getX() > j)
        {
            c = com.mopub.mobileads.a.b;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        float f4 = motionevent1.getX();
        boolean flag1;
        if (h)
        {
            flag1 = true;
        } else
        if (f4 >= j + e)
        {
            g = false;
            h = true;
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            if (f4 < f)
            {
                flag1 = flag3;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                c = a.c;
                j = f4;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        float f5 = motionevent1.getX();
        boolean flag2;
        if (g)
        {
            flag2 = true;
        } else
        if (f5 <= j - e)
        {
            h = false;
            g = true;
            i = i + 1;
            if (i >= 4)
            {
                c = a.d;
            }
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag2)
        {
            if (f5 > f)
            {
                flag2 = flag4;
            } else
            {
                flag2 = false;
            }
            if (flag2)
            {
                c = com.mopub.mobileads.a.b;
                j = f5;
            }
        }
        if (true) goto _L1; else goto _L5
_L5:
    }
}
