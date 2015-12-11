// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

public class j
    implements ComponentCallbacks, android.view.View.OnCreateContextMenuListener
{

    private static final dk a = new dk();
    static final Object c = new Object();
    int A;
    String B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    boolean H;
    int I;
    ViewGroup J;
    View K;
    View L;
    boolean M;
    boolean N;
    al O;
    boolean P;
    boolean Q;
    Object R;
    Object S;
    Object T;
    r U;
    r V;
    private Object W;
    private Object X;
    private Object b;
    int d;
    View e;
    int f;
    Bundle g;
    SparseArray h;
    public int i;
    String j;
    public Bundle k;
    j l;
    int m;
    int n;
    boolean o;
    public boolean p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    int u;
    t v;
    public m w;
    t x;
    j y;
    int z;

    public j()
    {
        d = 0;
        i = -1;
        m = -1;
        G = true;
        N = true;
        b = null;
        R = c;
        W = null;
        S = c;
        X = null;
        T = c;
        U = null;
        V = null;
    }

    public static j a(Context context, String s1)
    {
        return a(context, s1, null);
    }

    public static j a(Context context, String s1, Bundle bundle)
    {
        Class class1;
        Class class2;
        try
        {
            class2 = (Class)a.get(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new l((new StringBuilder("Unable to instantiate fragment ")).append(s1).append(": make sure class name exists, is public, and has an empty constructor that is public").toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new l((new StringBuilder("Unable to instantiate fragment ")).append(s1).append(": make sure class name exists, is public, and has an empty constructor that is public").toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new l((new StringBuilder("Unable to instantiate fragment ")).append(s1).append(": make sure class name exists, is public, and has an empty constructor that is public").toString(), context);
        }
        class1 = class2;
        if (class2 != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        class1 = context.getClassLoader().loadClass(s1);
        a.put(s1, class1);
        context = (j)class1.newInstance();
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        bundle.setClassLoader(context.getClass().getClassLoader());
        context.k = bundle;
        return context;
    }

    static boolean b(Context context, String s1)
    {
        Class class1;
        Class class2;
        boolean flag;
        try
        {
            class2 = (Class)a.get(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        class1 = class2;
        if (class2 != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        class1 = context.getClassLoader().loadClass(s1);
        a.put(s1, class1);
        flag = j.isAssignableFrom(class1);
        return flag;
    }

    public static void e()
    {
    }

    public static Animation g()
    {
        return null;
    }

    public static void h()
    {
    }

    public static void i()
    {
    }

    final View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (x != null)
        {
            x.j = false;
        }
        return null;
    }

    public void a()
    {
        H = true;
    }

    public void a(int i1, int j1)
    {
    }

    final void a(int i1, j j1)
    {
        i = i1;
        if (j1 != null)
        {
            j = (new StringBuilder()).append(j1.j).append(":").append(i).toString();
            return;
        } else
        {
            j = (new StringBuilder("android:fragment:")).append(i).toString();
            return;
        }
    }

    public void a(Activity activity)
    {
        H = true;
    }

    public void a(Bundle bundle)
    {
        H = true;
    }

    public LayoutInflater b(Bundle bundle)
    {
        bundle = w.getLayoutInflater().cloneInContext(w);
        if (x != null) goto _L2; else goto _L1
_L1:
        j();
        if (d < 5) goto _L4; else goto _L3
_L3:
        x.k();
_L2:
        t t1 = x;
        bundle.setFactory(x);
        return bundle;
_L4:
        if (d >= 4)
        {
            x.j();
        } else
        if (d >= 2)
        {
            x.i();
        } else
        if (d > 0)
        {
            x.h();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void b()
    {
        H = true;
        if (!P)
        {
            P = true;
            if (!Q)
            {
                Q = true;
                O = w.a(j, P, false);
            }
            if (O != null)
            {
                O.b();
            }
        }
    }

    public void c()
    {
        H = true;
    }

    public void d()
    {
        H = true;
    }

    public void d(Bundle bundle)
    {
        H = true;
    }

    public void e(Bundle bundle)
    {
    }

    public final boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    public final aj f()
    {
        if (O != null)
        {
            return O;
        }
        if (w == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            Q = true;
            O = w.a(j, P, true);
            return O;
        }
    }

    final void f(Bundle bundle)
    {
        e(bundle);
        if (x != null)
        {
            android.os.Parcelable parcelable = x.g();
            if (parcelable != null)
            {
                bundle.putParcelable("android:support:fragments", parcelable);
            }
        }
    }

    public final int hashCode()
    {
        return super.hashCode();
    }

    final void j()
    {
        x = new t();
        x.a(w, new k(this), this);
    }

    final void k()
    {
label0:
        {
            if (x != null)
            {
                x.a(2, false);
            }
            if (P)
            {
                P = false;
                if (!Q)
                {
                    Q = true;
                    O = w.a(j, P, false);
                }
                if (O != null)
                {
                    if (w.d)
                    {
                        break label0;
                    }
                    O.c();
                }
            }
            return;
        }
        O.d();
    }

    final void l()
    {
        if (x != null)
        {
            x.n();
        }
        H = false;
        H = true;
        if (!Q)
        {
            Q = true;
            O = w.a(j, P, false);
        }
        if (O != null)
        {
            O.g();
        }
        if (!H)
        {
            throw new bt((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onDestroy()").toString());
        } else
        {
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        H = true;
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        w.onCreateContextMenu(contextmenu, view, contextmenuinfo);
    }

    public void onLowMemory()
    {
        H = true;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        a.a(this, stringbuilder);
        if (i >= 0)
        {
            stringbuilder.append(" #");
            stringbuilder.append(i);
        }
        if (z != 0)
        {
            stringbuilder.append(" id=0x");
            stringbuilder.append(Integer.toHexString(z));
        }
        if (B != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append(B);
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

}
