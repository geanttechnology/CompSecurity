// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.a.g;
import android.support.v4.f.c;
import android.support.v4.f.k;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.support.v4.app:
//            n, f, i

class o extends n
{

    static boolean a = false;
    final k b = new k();
    final k c = new k();
    final String d;
    f e;
    boolean f;
    boolean g;
    boolean h;

    o(String s, f f1, boolean flag)
    {
        d = s;
        e = f1;
        f = flag;
    }

    private a c(int j, Bundle bundle, n.a a1)
    {
    /* block-local class not found */
    class a {}

        a a2 = new a(j, bundle, a1);
        a2.d = a1.a(j, bundle);
        return a2;
    }

    private a d(int j, Bundle bundle, n.a a1)
    {
        h = true;
        bundle = c(j, bundle, a1);
        a(bundle);
        h = false;
        return bundle;
        bundle;
        h = false;
        throw bundle;
    }

    public g a(int j, Bundle bundle, n.a a1)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        a a2 = (a)b.a(j);
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("initLoader in ").append(this).append(": args=").append(bundle).toString());
        }
        if (a2 == null)
        {
            a1 = d(j, bundle, a1);
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

    public void a(int j)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("destroyLoader in ").append(this).append(" of ").append(j).toString());
        }
        int l = b.g(j);
        if (l >= 0)
        {
            a a1 = (a)b.f(l);
            b.d(l);
            a1.f();
        }
        j = c.g(j);
        if (j >= 0)
        {
            a a2 = (a)c.f(j);
            c.d(j);
            a2.f();
        }
        if (e != null && !a())
        {
            e.mFragments.g();
        }
    }

    void a(f f1)
    {
        e = f1;
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
            for (int j = 0; j < b.b(); j++)
            {
                a a1 = (a)b.f(j);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(b.e(j));
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
            for (int l = ((flag) ? 1 : 0); l < c.b(); l++)
            {
                a a2 = (a)c.f(l);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(c.e(l));
                printwriter.print(": ");
                printwriter.println(a2.toString());
                a2.a(s2, filedescriptor, printwriter, as);
            }

        }
    }

    public boolean a()
    {
        int l = b.b();
        int j = 0;
        boolean flag1 = false;
        while (j < l) 
        {
            a a1 = (a)b.f(j);
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

    public g b(int j)
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

    public g b(int j, Bundle bundle, n.a a1)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        a a2 = (a)b.a(j);
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("restartLoader in ").append(this).append(": args=").append(bundle).toString());
        }
        if (a2 != null)
        {
            a a3 = (a)c.a(j);
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
                    c.b(j, a2);
                } else
                if (!a2.h)
                {
                    if (a)
                    {
                        Log.v("LoaderManager", "  Current loader is stopped; replacing");
                    }
                    b.b(j, null);
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
                    a2.n = c(j, bundle, a1);
                    return a2.n.d;
                }
            } else
            {
                if (a)
                {
                    Log.v("LoaderManager", (new StringBuilder()).append("  Making last loader inactive: ").append(a2).toString());
                }
                a2.d.h();
                c.b(j, a2);
            }
        }
        return d(j, bundle, a1).d;
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
            int j = b.b() - 1;
            while (j >= 0) 
            {
                ((a)b.f(j)).a();
                j--;
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
        for (int j = b.b() - 1; j >= 0; j--)
        {
            ((a)b.f(j)).e();
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
            int j = b.b() - 1;
            while (j >= 0) 
            {
                ((a)b.f(j)).b();
                j--;
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
            for (int j = b.b() - 1; j >= 0; j--)
            {
                ((a)b.f(j)).c();
            }

        }
    }

    void f()
    {
        for (int j = b.b() - 1; j >= 0; j--)
        {
            ((a)b.f(j)).k = true;
        }

    }

    void g()
    {
        for (int j = b.b() - 1; j >= 0; j--)
        {
            ((a)b.f(j)).d();
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
            for (int j = b.b() - 1; j >= 0; j--)
            {
                ((a)b.f(j)).f();
            }

            b.c();
        }
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("Destroying Inactive in ").append(this).toString());
        }
        for (int l = c.b() - 1; l >= 0; l--)
        {
            ((a)c.f(l)).f();
        }

        c.c();
    }

    public String toString()
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
