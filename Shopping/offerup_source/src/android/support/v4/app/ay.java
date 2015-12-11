// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.support.v4.b.f;
import android.support.v4.e.a;
import android.support.v4.g.m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

// Referenced classes of package android.support.v4.app:
//            ax, az, z

final class ay extends ax
{

    static boolean a = false;
    final m b = new m();
    final String c;
    boolean d;
    boolean e;
    private m f;
    private z g;

    ay(String s, z z, boolean flag)
    {
        f = new m();
        c = s;
        g = z;
        d = flag;
    }

    final void a(z z)
    {
        g = z;
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
                az az1 = (az)b.b(i);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(b.a(i));
                printwriter.print(": ");
                printwriter.println(az1.toString());
                az1.a(s1, filedescriptor, printwriter, as);
            }

        }
        if (f.a() > 0)
        {
            printwriter.print(s);
            printwriter.println("Inactive Loaders:");
            String s2 = (new StringBuilder()).append(s).append("    ").toString();
            for (int j = ((flag) ? 1 : 0); j < f.a(); j++)
            {
                az az2 = (az)f.b(j);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(f.a(j));
                printwriter.print(": ");
                printwriter.println(az2.toString());
                az2.a(s2, filedescriptor, printwriter, as);
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
            az az1 = (az)b.b(i);
            boolean flag;
            if (az1.e && !az1.d)
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
        if (d)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder("Called doStart when already started: ")).append(this).toString(), runtimeexception);
        } else
        {
            d = true;
            int i = b.a() - 1;
            while (i >= 0) 
            {
                az az1 = (az)b.b(i);
                if (az1.f && az1.g)
                {
                    az1.e = true;
                } else
                if (!az1.e)
                {
                    az1.e = true;
                    if (az1.c != null)
                    {
                        if (az1.c.getClass().isMemberClass() && !Modifier.isStatic(az1.c.getClass().getModifiers()))
                        {
                            throw new IllegalArgumentException((new StringBuilder("Object returned from onCreateLoader must not be a non-static inner member class: ")).append(az1.c).toString());
                        }
                        if (!az1.i)
                        {
                            az1.c.a(az1.a, az1);
                            az1.c.b(az1);
                            az1.i = true;
                        }
                        az1.c.a();
                    }
                }
                i--;
            }
        }
    }

    final void c()
    {
        if (!d)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder("Called doStop when not started: ")).append(this).toString(), runtimeexception);
            return;
        }
        for (int i = b.a() - 1; i >= 0; i--)
        {
            ((az)b.b(i)).a();
        }

        d = false;
    }

    final void d()
    {
        if (!d)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder("Called doRetain when not started: ")).append(this).toString(), runtimeexception);
        } else
        {
            e = true;
            d = false;
            int i = b.a() - 1;
            while (i >= 0) 
            {
                az az1 = (az)b.b(i);
                az1.f = true;
                az1.g = az1.e;
                az1.e = false;
                az1.b = null;
                i--;
            }
        }
    }

    final void e()
    {
        for (int i = b.a() - 1; i >= 0; i--)
        {
            ((az)b.b(i)).h = true;
        }

    }

    final void f()
    {
        for (int i = b.a() - 1; i >= 0; i--)
        {
            az az1 = (az)b.b(i);
            if (az1.e && az1.h)
            {
                az1.h = false;
            }
        }

    }

    final void g()
    {
        if (!e)
        {
            for (int i = b.a() - 1; i >= 0; i--)
            {
                ((az)b.b(i)).b();
            }

            b.b();
        }
        for (int j = f.a() - 1; j >= 0; j--)
        {
            ((az)f.b(j)).b();
        }

        f.b();
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("LoaderManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        android.support.v4.e.a.a(g, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

}
