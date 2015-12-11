// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.support.v7.av;
import android.support.v7.bb;
import android.support.v7.o;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

// Referenced classes of package android.support.v4.app:
//            o, g, j

class p extends android.support.v4.app.o
{
    final class a
        implements android.support.v7.o.a
    {

        final int a;
        final Bundle b;
        o.a c;
        o d;
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

        void a()
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
                    Log.v("LoaderManager", (new StringBuilder()).append("  Starting: ").append(this).toString());
                }
                if (d == null && c != null)
                {
                    d = c.a(a, b);
                }
                if (d != null)
                {
                    if (d.getClass().isMemberClass() && !Modifier.isStatic(d.getClass().getModifiers()))
                    {
                        throw new IllegalArgumentException((new StringBuilder()).append("Object returned from onCreateLoader must not be a non-static inner member class: ").append(d).toString());
                    }
                    if (!m)
                    {
                        d.a(a, this);
                        m = true;
                    }
                    d.d();
                    return;
                }
            }
        }

        public void a(o o1, Object obj)
        {
            if (p.a)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("onLoadComplete: ").append(this).toString());
            }
            if (!l) goto _L2; else goto _L1
_L1:
            if (p.a)
            {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
_L4:
            return;
_L2:
            if (o.b.a(a) == this)
            {
                break; /* Loop/switch isn't completed */
            }
            if (p.a)
            {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
            a a1 = n;
            if (a1 != null)
            {
                if (p.a)
                {
                    Log.v("LoaderManager", (new StringBuilder()).append("  Switching to pending loader: ").append(a1).toString());
                }
                n = null;
                o.b.b(a, null);
                f();
                o.a(a1);
                return;
            }
            if (g != obj || !e)
            {
                g = obj;
                e = true;
                if (h)
                {
                    b(o1, obj);
                }
            }
            o1 = (a)o.c.a(a);
            if (o1 != null && o1 != this)
            {
                o1.f = false;
                o1.f();
                o.c.c(a);
            }
            if (o.e != null && !o.a())
            {
                o.e.b.f();
                return;
            }
            if (true) goto _L4; else goto _L5
_L5:
        }

        public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
        {
            printwriter.print(s);
            printwriter.print("mId=");
            printwriter.print(a);
            printwriter.print(" mArgs=");
            printwriter.println(b);
            printwriter.print(s);
            printwriter.print("mCallbacks=");
            printwriter.println(c);
            printwriter.print(s);
            printwriter.print("mLoader=");
            printwriter.println(d);
            if (d != null)
            {
                d.a((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
            }
            if (e || f)
            {
                printwriter.print(s);
                printwriter.print("mHaveData=");
                printwriter.print(e);
                printwriter.print("  mDeliveredData=");
                printwriter.println(f);
                printwriter.print(s);
                printwriter.print("mData=");
                printwriter.println(g);
            }
            printwriter.print(s);
            printwriter.print("mStarted=");
            printwriter.print(h);
            printwriter.print(" mReportNextStart=");
            printwriter.print(k);
            printwriter.print(" mDestroyed=");
            printwriter.println(l);
            printwriter.print(s);
            printwriter.print("mRetaining=");
            printwriter.print(i);
            printwriter.print(" mRetainingStarted=");
            printwriter.print(j);
            printwriter.print(" mListenerRegistered=");
            printwriter.println(m);
            if (n != null)
            {
                printwriter.print(s);
                printwriter.println("Pending Loader ");
                printwriter.print(n);
                printwriter.println(":");
                n.a((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
            }
        }

        void b()
        {
            if (p.a)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("  Retaining: ").append(this).toString());
            }
            i = true;
            j = h;
            h = false;
            c = null;
        }

        void b(o o1, Object obj)
        {
            if (c == null)
            {
                break MISSING_BLOCK_LABEL_130;
            }
            String s;
            if (o.e != null)
            {
                s = o.e.b.u;
                o.e.b.u = "onLoadFinished";
            } else
            {
                s = null;
            }
            if (p.a)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("  onLoadFinished in ").append(o1).append(": ").append(o1.b(obj)).toString());
            }
            c.a(o1, obj);
            if (o.e != null)
            {
                o.e.b.u = s;
            }
            f = true;
            return;
            o1;
            if (o.e != null)
            {
                o.e.b.u = s;
            }
            throw o1;
        }

        void c()
        {
            if (i)
            {
                if (p.a)
                {
                    Log.v("LoaderManager", (new StringBuilder()).append("  Finished Retaining: ").append(this).toString());
                }
                i = false;
                if (h != j && !h)
                {
                    e();
                }
            }
            if (h && e && !k)
            {
                b(d, g);
            }
        }

        void d()
        {
            if (h && k)
            {
                k = false;
                if (e)
                {
                    b(d, g);
                }
            }
        }

        void e()
        {
            if (p.a)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("  Stopping: ").append(this).toString());
            }
            h = false;
            if (!i && d != null && m)
            {
                m = false;
                d.a(this);
                d.f();
            }
        }

        void f()
        {
            if (p.a)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("  Destroying: ").append(this).toString());
            }
            l = true;
            boolean flag = f;
            f = false;
            if (c == null || d == null || !e || !flag)
            {
                break MISSING_BLOCK_LABEL_181;
            }
            if (p.a)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("  Reseting: ").append(this).toString());
            }
            String s;
            Exception exception;
            if (o.e != null)
            {
                s = o.e.b.u;
                o.e.b.u = "onLoaderReset";
            } else
            {
                s = null;
            }
            c.a(d);
            if (o.e != null)
            {
                o.e.b.u = s;
            }
            c = null;
            g = null;
            e = false;
            if (d != null)
            {
                if (m)
                {
                    m = false;
                    d.a(this);
                }
                d.j();
            }
            if (n != null)
            {
                n.f();
            }
            return;
            exception;
            if (o.e != null)
            {
                o.e.b.u = s;
            }
            throw exception;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder(64);
            stringbuilder.append("LoaderInfo{");
            stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringbuilder.append(" #");
            stringbuilder.append(a);
            stringbuilder.append(" : ");
            av.a(d, stringbuilder);
            stringbuilder.append("}}");
            return stringbuilder.toString();
        }

        public a(int i1, Bundle bundle, o.a a1)
        {
            o = p.this;
            super();
            a = i1;
            b = bundle;
            c = a1;
        }
    }


    static boolean a = false;
    final bb b = new bb();
    final bb c = new bb();
    final String d;
    g e;
    boolean f;
    boolean g;
    boolean h;

    p(String s, g g1, boolean flag)
    {
        d = s;
        e = g1;
        f = flag;
    }

    private a c(int i, Bundle bundle, o.a a1)
    {
        a a2 = new a(i, bundle, a1);
        a2.d = a1.a(i, bundle);
        return a2;
    }

    private a d(int i, Bundle bundle, o.a a1)
    {
        h = true;
        bundle = c(i, bundle, a1);
        a(bundle);
        h = false;
        return bundle;
        bundle;
        h = false;
        throw bundle;
    }

    public o a(int i, Bundle bundle, o.a a1)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        a a2 = (a)b.a(i);
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("initLoader in ").append(this).append(": args=").append(bundle).toString());
        }
        if (a2 == null)
        {
            a1 = d(i, bundle, a1);
            bundle = a1;
            if (a)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("  Created new loader ").append(a1).toString());
                bundle = a1;
            }
        } else
        {
            if (a)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("  Re-using existing loader ").append(a2).toString());
            }
            a2.c = a1;
            bundle = a2;
        }
        if (((a) (bundle)).e && f)
        {
            bundle.b(((a) (bundle)).d, ((a) (bundle)).g);
        }
        return ((a) (bundle)).d;
    }

    public void a(int i)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("destroyLoader in ").append(this).append(" of ").append(i).toString());
        }
        int k = b.g(i);
        if (k >= 0)
        {
            a a1 = (a)b.f(k);
            b.d(k);
            a1.f();
        }
        i = c.g(i);
        if (i >= 0)
        {
            a a2 = (a)c.f(i);
            c.d(i);
            a2.f();
        }
        if (e != null && !a())
        {
            e.b.f();
        }
    }

    void a(g g1)
    {
        e = g1;
    }

    void a(a a1)
    {
        b.b(a1.a, a1);
        if (f)
        {
            a1.a();
        }
    }

    public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        boolean flag = false;
        if (b.b() > 0)
        {
            printwriter.print(s);
            printwriter.println("Active Loaders:");
            String s1 = (new StringBuilder()).append(s).append("    ").toString();
            for (int i = 0; i < b.b(); i++)
            {
                a a1 = (a)b.f(i);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(b.e(i));
                printwriter.print(": ");
                printwriter.println(a1.toString());
                a1.a(s1, filedescriptor, printwriter, as);
            }

        }
        if (c.b() > 0)
        {
            printwriter.print(s);
            printwriter.println("Inactive Loaders:");
            String s2 = (new StringBuilder()).append(s).append("    ").toString();
            for (int k = ((flag) ? 1 : 0); k < c.b(); k++)
            {
                a a2 = (a)c.f(k);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(c.e(k));
                printwriter.print(": ");
                printwriter.println(a2.toString());
                a2.a(s2, filedescriptor, printwriter, as);
            }

        }
    }

    public boolean a()
    {
        int k = b.b();
        int i = 0;
        boolean flag1 = false;
        while (i < k) 
        {
            a a1 = (a)b.f(i);
            boolean flag;
            if (a1.h && !a1.f)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 |= flag;
            i++;
        }
        return flag1;
    }

    public o b(int i)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        a a1 = (a)b.a(i);
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

    public o b(int i, Bundle bundle, o.a a1)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        a a2 = (a)b.a(i);
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("restartLoader in ").append(this).append(": args=").append(bundle).toString());
        }
        if (a2 != null)
        {
            a a3 = (a)c.a(i);
            if (a3 != null)
            {
                if (a2.e)
                {
                    if (a)
                    {
                        Log.v("LoaderManager", (new StringBuilder()).append("  Removing last inactive loader: ").append(a2).toString());
                    }
                    a3.f = false;
                    a3.f();
                    a2.d.h();
                    c.b(i, a2);
                } else
                if (!a2.h)
                {
                    if (a)
                    {
                        Log.v("LoaderManager", "  Current loader is stopped; replacing");
                    }
                    b.b(i, null);
                    a2.f();
                } else
                {
                    if (a2.n != null)
                    {
                        if (a)
                        {
                            Log.v("LoaderManager", (new StringBuilder()).append("  Removing pending loader: ").append(a2.n).toString());
                        }
                        a2.n.f();
                        a2.n = null;
                    }
                    if (a)
                    {
                        Log.v("LoaderManager", "  Enqueuing as new pending loader");
                    }
                    a2.n = c(i, bundle, a1);
                    return a2.n.d;
                }
            } else
            {
                if (a)
                {
                    Log.v("LoaderManager", (new StringBuilder()).append("  Making last loader inactive: ").append(a2).toString());
                }
                a2.d.h();
                c.b(i, a2);
            }
        }
        return d(i, bundle, a1).d;
    }

    void b()
    {
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("Starting in ").append(this).toString());
        }
        if (f)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder()).append("Called doStart when already started: ").append(this).toString(), runtimeexception);
        } else
        {
            f = true;
            int i = b.b() - 1;
            while (i >= 0) 
            {
                ((a)b.f(i)).a();
                i--;
            }
        }
    }

    void c()
    {
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("Stopping in ").append(this).toString());
        }
        if (!f)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder()).append("Called doStop when not started: ").append(this).toString(), runtimeexception);
            return;
        }
        for (int i = b.b() - 1; i >= 0; i--)
        {
            ((a)b.f(i)).e();
        }

        f = false;
    }

    void d()
    {
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("Retaining in ").append(this).toString());
        }
        if (!f)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder()).append("Called doRetain when not started: ").append(this).toString(), runtimeexception);
        } else
        {
            g = true;
            f = false;
            int i = b.b() - 1;
            while (i >= 0) 
            {
                ((a)b.f(i)).b();
                i--;
            }
        }
    }

    void e()
    {
        if (g)
        {
            if (a)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("Finished Retaining in ").append(this).toString());
            }
            g = false;
            for (int i = b.b() - 1; i >= 0; i--)
            {
                ((a)b.f(i)).c();
            }

        }
    }

    void f()
    {
        for (int i = b.b() - 1; i >= 0; i--)
        {
            ((a)b.f(i)).k = true;
        }

    }

    void g()
    {
        for (int i = b.b() - 1; i >= 0; i--)
        {
            ((a)b.f(i)).d();
        }

    }

    void h()
    {
        if (!g)
        {
            if (a)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("Destroying Active in ").append(this).toString());
            }
            for (int i = b.b() - 1; i >= 0; i--)
            {
                ((a)b.f(i)).f();
            }

            b.c();
        }
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("Destroying Inactive in ").append(this).toString());
        }
        for (int k = c.b() - 1; k >= 0; k--)
        {
            ((a)c.f(k)).f();
        }

        c.c();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("LoaderManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        av.a(e, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

}
