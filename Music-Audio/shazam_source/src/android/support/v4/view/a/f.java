// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

public final class f
{
    static class a extends e
    {

        public final Object a()
        {
            return AccessibilityRecord.obtain();
        }

        public final void a(Object obj, int i)
        {
            ((AccessibilityRecord)obj).setFromIndex(i);
        }

        public final void a(Object obj, boolean flag)
        {
            ((AccessibilityRecord)obj).setScrollable(flag);
        }

        public final void b(Object obj, int i)
        {
            ((AccessibilityRecord)obj).setItemCount(i);
        }

        public final void c(Object obj, int i)
        {
            ((AccessibilityRecord)obj).setToIndex(i);
        }

        a()
        {
        }
    }

    static class b extends a
    {

        b()
        {
        }
    }

    static interface c
    {

        public abstract Object a();

        public abstract void a(Object obj, int i);

        public abstract void a(Object obj, boolean flag);

        public abstract void b(Object obj, int i);

        public abstract void c(Object obj, int i);
    }

    static final class d extends b
    {

        d()
        {
        }
    }

    static class e
        implements c
    {

        public Object a()
        {
            return null;
        }

        public void a(Object obj, int i)
        {
        }

        public void a(Object obj, boolean flag)
        {
        }

        public void b(Object obj, int i)
        {
        }

        public void c(Object obj, int i)
        {
        }

        e()
        {
        }
    }


    private static final c a;
    private final Object b;

    public f(Object obj)
    {
        b = obj;
    }

    public static f a()
    {
        return new f(a.a());
    }

    public final void a(int i)
    {
        a.b(b, i);
    }

    public final void a(boolean flag)
    {
        a.a(b, flag);
    }

    public final void b(int i)
    {
        a.a(b, i);
    }

    public final void c(int i)
    {
        a.c(b, i);
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (f)obj;
        if (b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((f) (obj)).b == null) goto _L1; else goto _L3
_L3:
        return false;
        if (b.equals(((f) (obj)).b)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public final int hashCode()
    {
        if (b == null)
        {
            return 0;
        } else
        {
            return b.hashCode();
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new d();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            a = new b();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new a();
        } else
        {
            a = new e();
        }
    }
}
