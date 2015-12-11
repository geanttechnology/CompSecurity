// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.g.l;
import android.support.v4.g.m;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.support.v4.app:
//            x, ab, t, ay, 
//            az, Fragment

public abstract class z extends x
{

    final Context a;
    final ab b;
    private final Activity c;
    private final Handler d;
    private int e;
    private l f;
    private ay g;
    private boolean h;
    private boolean i;

    private z(Activity activity, Context context, Handler handler, int i1)
    {
        b = new ab();
        c = activity;
        a = context;
        d = handler;
        e = 0;
    }

    z(t t1)
    {
        this(((Activity) (t1)), ((Context) (t1)), t1.mHandler, 0);
    }

    final ay a(String s, boolean flag, boolean flag1)
    {
        if (f == null)
        {
            f = new l();
        }
        ay ay1 = (ay)f.get(s);
        if (ay1 == null)
        {
            if (flag1)
            {
                ay1 = new ay(s, this, flag);
                f.put(s, ay1);
            }
            return ay1;
        } else
        {
            ay1.a(this);
            return ay1;
        }
    }

    public View a(int i1)
    {
        return null;
    }

    void a(Fragment fragment)
    {
    }

    public void a(Fragment fragment, Intent intent, int i1)
    {
        if (i1 != -1)
        {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        } else
        {
            a.startActivity(intent);
            return;
        }
    }

    public void a(Fragment fragment, String as[], int i1)
    {
    }

    final void a(l l1)
    {
        f = l1;
    }

    public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
    }

    final void a(boolean flag)
    {
        while (g == null || !i) 
        {
            return;
        }
        i = false;
        if (flag)
        {
            g.d();
            return;
        } else
        {
            g.c();
            return;
        }
    }

    public boolean a()
    {
        return true;
    }

    public boolean a(String s)
    {
        return false;
    }

    final void b(String s)
    {
        if (f != null)
        {
            ay ay1 = (ay)f.get(s);
            if (ay1 != null && !ay1.e)
            {
                ay1.g();
                f.remove(s);
            }
        }
    }

    final void b(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.print(s);
        printwriter.print("mLoadersStarted=");
        printwriter.println(i);
        if (g != null)
        {
            printwriter.print(s);
            printwriter.print("Loader Manager ");
            printwriter.print(Integer.toHexString(System.identityHashCode(g)));
            printwriter.println(":");
            g.a((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }
    }

    public boolean b()
    {
        return true;
    }

    public LayoutInflater c()
    {
        return (LayoutInflater)a.getSystemService("layout_inflater");
    }

    public void d()
    {
    }

    public boolean e()
    {
        return true;
    }

    public int f()
    {
        return e;
    }

    public abstract Object g();

    final Activity h()
    {
        return c;
    }

    final Handler i()
    {
        return d;
    }

    final ay j()
    {
        if (g != null)
        {
            return g;
        } else
        {
            h = true;
            g = a("(root)", i, true);
            return g;
        }
    }

    final void k()
    {
        if (i)
        {
            return;
        }
        i = true;
        if (g == null) goto _L2; else goto _L1
_L1:
        g.b();
_L4:
        h = true;
        return;
_L2:
        if (!h)
        {
            g = a("(root)", i, false);
            if (g != null && !g.d)
            {
                g.b();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    final void l()
    {
        if (g == null)
        {
            return;
        } else
        {
            g.g();
            return;
        }
    }

    final void m()
    {
        if (f != null)
        {
            int l1 = f.size();
            ay aay[] = new ay[l1];
            for (int i1 = l1 - 1; i1 >= 0; i1--)
            {
                aay[i1] = (ay)f.c(i1);
            }

            for (int j1 = 0; j1 < l1; j1++)
            {
                ay ay1 = aay[j1];
                if (ay1.e)
                {
                    ay1.e = false;
                    for (int k1 = ay1.b.a() - 1; k1 >= 0; k1--)
                    {
                        az az1 = (az)ay1.b.b(k1);
                        if (!az1.f)
                        {
                            continue;
                        }
                        az1.f = false;
                        if (az1.e != az1.g && !az1.e)
                        {
                            az1.a();
                        }
                    }

                }
                ay1.f();
            }

        }
    }

    final l n()
    {
        int j1 = 0;
        boolean flag1;
        if (f != null)
        {
            int k1 = f.size();
            ay aay[] = new ay[k1];
            for (int i1 = k1 - 1; i1 >= 0; i1--)
            {
                aay[i1] = (ay)f.c(i1);
            }

            boolean flag = false;
            do
            {
                flag1 = flag;
                if (j1 >= k1)
                {
                    break;
                }
                ay ay1 = aay[j1];
                if (ay1.e)
                {
                    flag = true;
                } else
                {
                    ay1.g();
                    f.remove(ay1.c);
                }
                j1++;
            } while (true);
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            return f;
        } else
        {
            return null;
        }
    }
}
