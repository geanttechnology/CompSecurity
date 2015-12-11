// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

final class al extends aj
{

    static boolean a = false;
    final dl b = new dl();
    final dl c = new dl();
    final String d;
    m e;
    boolean f;
    boolean g;
    private boolean h;

    al(String s, m m1, boolean flag)
    {
        d = s;
        e = m1;
        f = flag;
    }

    private am c(int i, Bundle bundle, ak ak1)
    {
        bundle = new am(this, i, bundle, ak1);
        bundle.c = ak1.a(i);
        return bundle;
    }

    private am d(int i, Bundle bundle, ak ak1)
    {
        h = true;
        bundle = c(i, bundle, ak1);
        a(bundle);
        h = false;
        return bundle;
        bundle;
        h = false;
        throw bundle;
    }

    public final bu a(int i, Bundle bundle, ak ak1)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        bundle = (am)b.a(i);
        if (bundle == null)
        {
            bundle = d(i, null, ak1);
        } else
        {
            bundle.b = ak1;
        }
        if (((am) (bundle)).d && f)
        {
            bundle.b(((am) (bundle)).c, ((am) (bundle)).f);
        }
        return ((am) (bundle)).c;
    }

    public final void a(int i)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        int j = b.e(i);
        if (j >= 0)
        {
            am am1 = (am)b.d(j);
            b.b(j);
            am1.c();
        }
        i = c.e(i);
        if (i >= 0)
        {
            am am2 = (am)c.d(i);
            c.b(i);
            am2.c();
        }
        if (e != null && !a())
        {
            e.b.d();
        }
    }

    final void a(am am1)
    {
        b.a(am1.a, am1);
        if (f)
        {
            am1.a();
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
            for (int i = 0; i < b.a(); i++)
            {
                am am1 = (am)b.d(i);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(b.c(i));
                printwriter.print(": ");
                printwriter.println(am1.toString());
                am1.a(s1, filedescriptor, printwriter, as);
            }

        }
        if (c.a() > 0)
        {
            printwriter.print(s);
            printwriter.println("Inactive Loaders:");
            String s2 = (new StringBuilder()).append(s).append("    ").toString();
            for (int j = ((flag) ? 1 : 0); j < c.a(); j++)
            {
                am am2 = (am)c.d(j);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(c.c(j));
                printwriter.print(": ");
                printwriter.println(am2.toString());
                am2.a(s2, filedescriptor, printwriter, as);
            }

        }
    }

    public final boolean a()
    {
        int j = b.a();
        int i = 0;
        boolean flag1 = false;
        while (i < j) 
        {
            am am1 = (am)b.d(i);
            boolean flag;
            if (am1.g && !am1.e)
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

    public final bu b(int i)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        am am1 = (am)b.a(i);
        if (am1 != null)
        {
            if (am1.k != null)
            {
                return am1.k.c;
            } else
            {
                return am1.c;
            }
        } else
        {
            return null;
        }
    }

    public final bu b(int i, Bundle bundle, ak ak1)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        bundle = (am)b.a(i);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        am am1 = (am)c.a(i);
        if (am1 == null) goto _L4; else goto _L3
_L3:
        if (!((am) (bundle)).d) goto _L6; else goto _L5
_L5:
        am1.e = false;
        am1.c();
_L4:
        ((am) (bundle)).c.d = true;
        c.a(i, bundle);
_L2:
        return d(i, null, ak1).c;
_L6:
        if (((am) (bundle)).g)
        {
            break; /* Loop/switch isn't completed */
        }
        b.a(i, null);
        bundle.c();
        if (true) goto _L2; else goto _L7
_L7:
        if (((am) (bundle)).k != null)
        {
            ((am) (bundle)).k.c();
            bundle.k = null;
        }
        bundle.k = c(i, null, ak1);
        return ((am) (bundle)).k.c;
    }

    final void b()
    {
        if (f)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder("Called doStart when already started: ")).append(this).toString(), runtimeexception);
        } else
        {
            f = true;
            int i = b.a() - 1;
            while (i >= 0) 
            {
                ((am)b.d(i)).a();
                i--;
            }
        }
    }

    final void c()
    {
        if (!f)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder("Called doStop when not started: ")).append(this).toString(), runtimeexception);
            return;
        }
        for (int i = b.a() - 1; i >= 0; i--)
        {
            ((am)b.d(i)).b();
        }

        f = false;
    }

    final void d()
    {
        if (!f)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder("Called doRetain when not started: ")).append(this).toString(), runtimeexception);
        } else
        {
            g = true;
            f = false;
            int i = b.a() - 1;
            while (i >= 0) 
            {
                am am1 = (am)b.d(i);
                am1.h = true;
                am1.i = am1.g;
                am1.g = false;
                am1.b = null;
                i--;
            }
        }
    }

    final void e()
    {
        for (int i = b.a() - 1; i >= 0; i--)
        {
            ((am)b.d(i)).j = true;
        }

    }

    final void f()
    {
        for (int i = b.a() - 1; i >= 0; i--)
        {
            am am1 = (am)b.d(i);
            if (!am1.g || !am1.j)
            {
                continue;
            }
            am1.j = false;
            if (am1.d)
            {
                am1.b(am1.c, am1.f);
            }
        }

    }

    final void g()
    {
        if (!g)
        {
            for (int i = b.a() - 1; i >= 0; i--)
            {
                ((am)b.d(i)).c();
            }

            b.b();
        }
        for (int j = c.a() - 1; j >= 0; j--)
        {
            ((am)c.d(j)).c();
        }

        c.b();
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("LoaderManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        a.a(e, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

}
