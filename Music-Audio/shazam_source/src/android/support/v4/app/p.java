// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.a.d;
import android.support.v4.f.b;
import android.support.v4.f.c;
import android.support.v4.f.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

// Referenced classes of package android.support.v4.app:
//            o, i, l

public final class p extends o
{
    final class a
        implements android.support.v4.a.d.b
    {

        final int a;
        final Bundle b = null;
        o.a c;
        d d;
        boolean e;
        boolean f;
        Object g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        a n;
        final p o;

        final void a()
        {
            if (i && j)
            {
                h = true;
            } else
            if (!h)
            {
                h = true;
                if (p.a)
                {
                    (new StringBuilder("  Starting: ")).append(this);
                }
                if (d == null && c != null)
                {
                    d = c.a(a);
                }
                if (d != null)
                {
                    if (d.getClass().isMemberClass() && !Modifier.isStatic(d.getClass().getModifiers()))
                    {
                        throw new IllegalArgumentException((new StringBuilder("Object returned from onCreateLoader must not be a non-static inner member class: ")).append(d).toString());
                    }
                    if (!m)
                    {
                        d d1 = d;
                        int i1 = a;
                        if (d1.g != null)
                        {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        d1.g = this;
                        d1.f = i1;
                        m = true;
                    }
                    d d2 = d;
                    d2.i = true;
                    d2.k = false;
                    d2.j = false;
                    d2.d();
                    return;
                }
            }
        }

        public final void a(d d1, Object obj)
        {
            if (p.a)
            {
                (new StringBuilder("onLoadComplete: ")).append(this);
            }
            break MISSING_BLOCK_LABEL_20;
            if (!l && o.b.a(a) == this)
            {
                a a1 = n;
                if (a1 != null)
                {
                    if (p.a)
                    {
                        (new StringBuilder("  Switching to pending loader: ")).append(a1);
                    }
                    n = null;
                    o.b.a(a, null);
                    c();
                    o.a(a1);
                    return;
                }
                if (g != obj || !e)
                {
                    g = obj;
                    e = true;
                    if (h)
                    {
                        b(d1, obj);
                    }
                }
                d1 = (a)o.c.a(a);
                if (d1 != null && d1 != this)
                {
                    d1.f = false;
                    d1.c();
                    d1 = o.c;
                    int i1 = a;
                    i1 = android.support.v4.f.b.a(((i) (d1)).c, ((i) (d1)).e, i1);
                    if (i1 >= 0 && ((i) (d1)).d[i1] != i.a)
                    {
                        ((i) (d1)).d[i1] = i.a;
                        d1.b = true;
                    }
                }
                if (o.e != null && !o.a())
                {
                    o.e.mFragments.h();
                    return;
                }
            }
            return;
        }

        public final void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
        {
            String s1 = s;
            s = this;
            do
            {
                printwriter.print(s1);
                printwriter.print("mId=");
                printwriter.print(((a) (s)).a);
                printwriter.print(" mArgs=");
                printwriter.println(((a) (s)).b);
                printwriter.print(s1);
                printwriter.print("mCallbacks=");
                printwriter.println(((a) (s)).c);
                printwriter.print(s1);
                printwriter.print("mLoader=");
                printwriter.println(((a) (s)).d);
                if (((a) (s)).d != null)
                {
                    ((a) (s)).d.a((new StringBuilder()).append(s1).append("  ").toString(), filedescriptor, printwriter, as);
                }
                if (((a) (s)).e || ((a) (s)).f)
                {
                    printwriter.print(s1);
                    printwriter.print("mHaveData=");
                    printwriter.print(((a) (s)).e);
                    printwriter.print("  mDeliveredData=");
                    printwriter.println(((a) (s)).f);
                    printwriter.print(s1);
                    printwriter.print("mData=");
                    printwriter.println(((a) (s)).g);
                }
                printwriter.print(s1);
                printwriter.print("mStarted=");
                printwriter.print(((a) (s)).h);
                printwriter.print(" mReportNextStart=");
                printwriter.print(((a) (s)).k);
                printwriter.print(" mDestroyed=");
                printwriter.println(((a) (s)).l);
                printwriter.print(s1);
                printwriter.print("mRetaining=");
                printwriter.print(((a) (s)).i);
                printwriter.print(" mRetainingStarted=");
                printwriter.print(((a) (s)).j);
                printwriter.print(" mListenerRegistered=");
                printwriter.println(((a) (s)).m);
                if (((a) (s)).n != null)
                {
                    printwriter.print(s1);
                    printwriter.println("Pending Loader ");
                    printwriter.print(((a) (s)).n);
                    printwriter.println(":");
                    s = ((a) (s)).n;
                    s1 = (new StringBuilder()).append(s1).append("  ").toString();
                } else
                {
                    return;
                }
            } while (true);
        }

        final void b()
        {
            if (p.a)
            {
                (new StringBuilder("  Stopping: ")).append(this);
            }
            h = false;
            if (!i && d != null && m)
            {
                m = false;
                d.a(this);
                d d1 = d;
                d1.i = false;
                d1.f();
            }
        }

        final void b(d d1, Object obj)
        {
            if (c == null)
            {
                break MISSING_BLOCK_LABEL_152;
            }
            String s;
            StringBuilder stringbuilder;
            StringBuilder stringbuilder1;
            if (o.e != null)
            {
                s = o.e.mFragments.u;
                o.e.mFragments.u = "onLoadFinished";
            } else
            {
                s = null;
            }
            if (p.a)
            {
                stringbuilder = (new StringBuilder("  onLoadFinished in ")).append(d1).append(": ");
                stringbuilder1 = new StringBuilder(64);
                android.support.v4.f.c.a(obj, stringbuilder1);
                stringbuilder1.append("}");
                stringbuilder.append(stringbuilder1.toString());
            }
            c.a(d1, obj);
            if (o.e != null)
            {
                o.e.mFragments.u = s;
            }
            f = true;
            return;
            d1;
            if (o.e != null)
            {
                o.e.mFragments.u = s;
            }
            throw d1;
        }

        final void c()
        {
            a a1 = this;
            do
            {
                if (p.a)
                {
                    (new StringBuilder("  Destroying: ")).append(a1);
                }
                a1.l = true;
                boolean flag = a1.f;
                a1.f = false;
                if (a1.c != null && a1.d != null && a1.e && flag)
                {
                    if (p.a)
                    {
                        (new StringBuilder("  Reseting: ")).append(a1);
                    }
                    Object obj;
                    if (a1.o.e != null)
                    {
                        obj = a1.o.e.mFragments.u;
                        a1.o.e.mFragments.u = "onLoaderReset";
                    } else
                    {
                        obj = null;
                    }
                    if (a1.o.e != null)
                    {
                        a1.o.e.mFragments.u = ((String) (obj));
                    }
                }
                a1.c = null;
                a1.g = null;
                a1.e = false;
                if (a1.d != null)
                {
                    if (a1.m)
                    {
                        a1.m = false;
                        a1.d.a(a1);
                    }
                    obj = a1.d;
                    ((d) (obj)).g();
                    obj.k = true;
                    obj.i = false;
                    obj.j = false;
                    obj.l = false;
                    obj.m = false;
                }
                if (a1.n != null)
                {
                    a1 = a1.n;
                } else
                {
                    return;
                }
            } while (true);
        }

        public final String toString()
        {
            StringBuilder stringbuilder = new StringBuilder(64);
            stringbuilder.append("LoaderInfo{");
            stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringbuilder.append(" #");
            stringbuilder.append(a);
            stringbuilder.append(" : ");
            android.support.v4.f.c.a(d, stringbuilder);
            stringbuilder.append("}}");
            return stringbuilder.toString();
        }

        public a(int i1, o.a a1)
        {
            o = p.this;
            super();
            a = i1;
            c = a1;
        }
    }


    public static boolean a = false;
    final i b = new i();
    final i c = new i();
    final String d;
    android.support.v4.app.i e;
    boolean f;
    boolean g;
    boolean h;

    p(String s, android.support.v4.app.i j, boolean flag)
    {
        d = s;
        e = j;
        f = flag;
    }

    private a c(int j, o.a a1)
    {
        a a2 = new a(j, a1);
        a2.d = a1.a(j);
        return a2;
    }

    private a d(int j, o.a a1)
    {
        h = true;
        a1 = c(j, a1);
        a(a1);
        h = false;
        return a1;
        a1;
        h = false;
        throw a1;
    }

    public final d a(int j, o.a a1)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        a a2 = (a)b.a(j);
        if (a)
        {
            (new StringBuilder("initLoader in ")).append(this).append(": args=").append(null);
        }
        if (a2 == null)
        {
            a2 = d(j, a1);
            a1 = a2;
            if (a)
            {
                (new StringBuilder("  Created new loader ")).append(a2);
                a1 = a2;
            }
        } else
        {
            if (a)
            {
                (new StringBuilder("  Re-using existing loader ")).append(a2);
            }
            a2.c = a1;
            a1 = a2;
        }
        if (((a) (a1)).e && f)
        {
            a1.b(((a) (a1)).d, ((a) (a1)).g);
        }
        return ((a) (a1)).d;
    }

    public final void a(int j)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (a)
        {
            (new StringBuilder("destroyLoader in ")).append(this).append(" of ").append(j);
        }
        int k = b.e(j);
        if (k >= 0)
        {
            a a1 = (a)b.d(k);
            b.b(k);
            a1.c();
        }
        j = c.e(j);
        if (j >= 0)
        {
            a a2 = (a)c.d(j);
            c.b(j);
            a2.c();
        }
        if (e != null && !a())
        {
            e.mFragments.h();
        }
    }

    final void a(a a1)
    {
        b.a(a1.a, a1);
        if (f)
        {
            a1.a();
        }
    }

    public final void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        boolean flag = false;
        if (b.a() > 0)
        {
            printwriter.print(s);
            printwriter.println("Active Loaders:");
            String s1 = (new StringBuilder()).append(s).append("    ").toString();
            for (int j = 0; j < b.a(); j++)
            {
                a a1 = (a)b.d(j);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(b.c(j));
                printwriter.print(": ");
                printwriter.println(a1.toString());
                a1.a(s1, filedescriptor, printwriter, as);
            }

        }
        if (c.a() > 0)
        {
            printwriter.print(s);
            printwriter.println("Inactive Loaders:");
            String s2 = (new StringBuilder()).append(s).append("    ").toString();
            for (int k = ((flag) ? 1 : 0); k < c.a(); k++)
            {
                a a2 = (a)c.d(k);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(c.c(k));
                printwriter.print(": ");
                printwriter.println(a2.toString());
                a2.a(s2, filedescriptor, printwriter, as);
            }

        }
    }

    public final boolean a()
    {
        int k = b.a();
        int j = 0;
        boolean flag1 = false;
        while (j < k) 
        {
            a a1 = (a)b.d(j);
            boolean flag;
            if (a1.h && !a1.f)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 |= flag;
            j++;
        }
        return flag1;
    }

    public final d b(int j)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        a a1 = (a)b.a(j);
        if (a1 != null)
        {
            if (a1.n != null)
            {
                return a1.n.d;
            } else
            {
                return a1.d;
            }
        } else
        {
            return null;
        }
    }

    public final d b(int j, o.a a1)
    {
        a a2;
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        a2 = (a)b.a(j);
        if (a)
        {
            (new StringBuilder("restartLoader in ")).append(this).append(": args=").append(null);
        }
        if (a2 == null) goto _L2; else goto _L1
_L1:
        a a3 = (a)c.a(j);
        if (a3 == null) goto _L4; else goto _L3
_L3:
        if (!a2.e) goto _L6; else goto _L5
_L5:
        if (a)
        {
            (new StringBuilder("  Removing last inactive loader: ")).append(a2);
        }
        a3.f = false;
        a3.c();
_L9:
        a2.d.j = true;
        c.a(j, a2);
_L2:
        return d(j, a1).d;
_L6:
        if (a2.h)
        {
            break; /* Loop/switch isn't completed */
        }
        b.a(j, null);
        a2.c();
        if (true) goto _L2; else goto _L7
_L7:
        if (a2.n != null)
        {
            if (a)
            {
                (new StringBuilder("  Removing pending loader: ")).append(a2.n);
            }
            a2.n.c();
            a2.n = null;
        }
        a2.n = c(j, a1);
        return a2.n.d;
_L4:
        if (a)
        {
            (new StringBuilder("  Making last loader inactive: ")).append(a2);
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    final void b()
    {
        if (a)
        {
            (new StringBuilder("Starting in ")).append(this);
        }
        if (f)
        {
            (new RuntimeException("here")).fillInStackTrace();
            (new StringBuilder("Called doStart when already started: ")).append(this);
        } else
        {
            f = true;
            int j = b.a() - 1;
            while (j >= 0) 
            {
                ((a)b.d(j)).a();
                j--;
            }
        }
    }

    final void c()
    {
        if (a)
        {
            (new StringBuilder("Stopping in ")).append(this);
        }
        if (!f)
        {
            (new RuntimeException("here")).fillInStackTrace();
            (new StringBuilder("Called doStop when not started: ")).append(this);
            return;
        }
        for (int j = b.a() - 1; j >= 0; j--)
        {
            ((a)b.d(j)).b();
        }

        f = false;
    }

    final void d()
    {
        if (a)
        {
            (new StringBuilder("Retaining in ")).append(this);
        }
        if (!f)
        {
            (new RuntimeException("here")).fillInStackTrace();
            (new StringBuilder("Called doRetain when not started: ")).append(this);
        } else
        {
            g = true;
            f = false;
            int j = b.a() - 1;
            while (j >= 0) 
            {
                a a1 = (a)b.d(j);
                if (a)
                {
                    (new StringBuilder("  Retaining: ")).append(a1);
                }
                a1.i = true;
                a1.j = a1.h;
                a1.h = false;
                a1.c = null;
                j--;
            }
        }
    }

    final void e()
    {
        for (int j = b.a() - 1; j >= 0; j--)
        {
            ((a)b.d(j)).k = true;
        }

    }

    final void f()
    {
        for (int j = b.a() - 1; j >= 0; j--)
        {
            a a1 = (a)b.d(j);
            if (!a1.h || !a1.k)
            {
                continue;
            }
            a1.k = false;
            if (a1.e)
            {
                a1.b(a1.d, a1.g);
            }
        }

    }

    final void g()
    {
        if (!g)
        {
            if (a)
            {
                (new StringBuilder("Destroying Active in ")).append(this);
            }
            for (int j = b.a() - 1; j >= 0; j--)
            {
                ((a)b.d(j)).c();
            }

            b.b();
        }
        if (a)
        {
            (new StringBuilder("Destroying Inactive in ")).append(this);
        }
        for (int k = c.a() - 1; k >= 0; k--)
        {
            ((a)c.d(k)).c();
        }

        c.b();
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("LoaderManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        android.support.v4.f.c.a(e, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

}
