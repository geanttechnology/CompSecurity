// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.support.v4.a.k;
import android.support.v4.c.d;
import android.support.v4.c.p;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.support.v4.app:
//            az, bc, ba, ac

final class bb extends az
{

    static boolean a = false;
    final p b = new p();
    final p c = new p();
    final String d;
    ac e;
    boolean f;
    boolean g;
    boolean h;

    bb(String s, ac ac, boolean flag)
    {
        d = s;
        e = ac;
        f = flag;
    }

    private bc b(ba ba1)
    {
        bc bc1;
        h = true;
        bc1 = new bc(this, ba1);
        bc1.d = ba1.onCreateLoader(0, null);
        a(bc1);
        h = false;
        return bc1;
        ba1;
        h = false;
        throw ba1;
    }

    public final k a(ba ba1)
    {
        if (h)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        bc bc1 = (bc)b.a(0);
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder("initLoader in ")).append(this).append(": args=").append(null).toString());
        }
        if (bc1 == null)
        {
            bc1 = b(ba1);
            ba1 = bc1;
            if (a)
            {
                Log.v("LoaderManager", (new StringBuilder("  Created new loader ")).append(bc1).toString());
                ba1 = bc1;
            }
        } else
        {
            if (a)
            {
                Log.v("LoaderManager", (new StringBuilder("  Re-using existing loader ")).append(bc1).toString());
            }
            bc1.c = ba1;
            ba1 = bc1;
        }
        if (((bc) (ba1)).e && f)
        {
            ba1.b(((bc) (ba1)).d, ((bc) (ba1)).g);
        }
        return ((bc) (ba1)).d;
    }

    final void a(bc bc1)
    {
        b.a(bc1.a, bc1);
        if (f)
        {
            bc1.a();
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
                bc bc1 = (bc)b.c(i);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(b.b(i));
                printwriter.print(": ");
                printwriter.println(bc1.toString());
                bc1.a(s1, filedescriptor, printwriter, as);
            }

        }
        if (c.a() > 0)
        {
            printwriter.print(s);
            printwriter.println("Inactive Loaders:");
            String s2 = (new StringBuilder()).append(s).append("    ").toString();
            for (int j = ((flag) ? 1 : 0); j < c.a(); j++)
            {
                bc bc2 = (bc)c.c(j);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(c.b(j));
                printwriter.print(": ");
                printwriter.println(bc2.toString());
                bc2.a(s2, filedescriptor, printwriter, as);
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
            bc bc1 = (bc)b.c(i);
            boolean flag;
            if (bc1.h && !bc1.f)
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

    final void b()
    {
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder("Starting in ")).append(this).toString());
        }
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
                ((bc)b.c(i)).a();
                i--;
            }
        }
    }

    final void c()
    {
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder("Stopping in ")).append(this).toString());
        }
        if (!f)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder("Called doStop when not started: ")).append(this).toString(), runtimeexception);
            return;
        }
        for (int i = b.a() - 1; i >= 0; i--)
        {
            ((bc)b.c(i)).b();
        }

        f = false;
    }

    final void d()
    {
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder("Retaining in ")).append(this).toString());
        }
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
                bc bc1 = (bc)b.c(i);
                if (a)
                {
                    Log.v("LoaderManager", (new StringBuilder("  Retaining: ")).append(bc1).toString());
                }
                bc1.i = true;
                bc1.j = bc1.h;
                bc1.h = false;
                bc1.c = null;
                i--;
            }
        }
    }

    final void e()
    {
        for (int i = b.a() - 1; i >= 0; i--)
        {
            ((bc)b.c(i)).k = true;
        }

    }

    final void f()
    {
        for (int i = b.a() - 1; i >= 0; i--)
        {
            bc bc1 = (bc)b.c(i);
            if (!bc1.h || !bc1.k)
            {
                continue;
            }
            bc1.k = false;
            if (bc1.e)
            {
                bc1.b(bc1.d, bc1.g);
            }
        }

    }

    final void g()
    {
        if (!g)
        {
            if (a)
            {
                Log.v("LoaderManager", (new StringBuilder("Destroying Active in ")).append(this).toString());
            }
            for (int i = b.a() - 1; i >= 0; i--)
            {
                ((bc)b.c(i)).c();
            }

            b.b();
        }
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder("Destroying Inactive in ")).append(this).toString());
        }
        for (int j = c.a() - 1; j >= 0; j--)
        {
            ((bc)c.c(j)).c();
        }

        c.b();
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("LoaderManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        android.support.v4.c.d.a(e, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

}
