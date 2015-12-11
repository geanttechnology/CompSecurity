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
//            p, i, l

final class c
    implements android.support.v4.a.a
{

    final int a;
    final Bundle b = null;
    tring c;
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
    tring n;
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
            d d2 = n;
            if (d2 != null)
            {
                if (p.a)
                {
                    (new StringBuilder("  Switching to pending loader: ")).append(d2);
                }
                n = null;
                o.b.a(a, null);
                c();
                o.a(d2);
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
            d1 = (b)o.c.a(a);
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
            printwriter.print(((ragments) (s)).a);
            printwriter.print(" mArgs=");
            printwriter.println((() (s)).b);
            printwriter.print(s1);
            printwriter.print("mCallbacks=");
            printwriter.println((() (s)).c);
            printwriter.print(s1);
            printwriter.print("mLoader=");
            printwriter.println((() (s)).d);
            if (((d) (s)).d != null)
            {
                ((d) (s)).d.a((new StringBuilder()).append(s1).append("  ").toString(), filedescriptor, printwriter, as);
            }
            if (((tring) (s)).e || ((e) (s)).f)
            {
                printwriter.print(s1);
                printwriter.print("mHaveData=");
                printwriter.print(((f) (s)).e);
                printwriter.print("  mDeliveredData=");
                printwriter.println((() (s)).f);
                printwriter.print(s1);
                printwriter.print("mData=");
                printwriter.println((() (s)).g);
            }
            printwriter.print(s1);
            printwriter.print("mStarted=");
            printwriter.print(((g) (s)).h);
            printwriter.print(" mReportNextStart=");
            printwriter.print(((h) (s)).k);
            printwriter.print(" mDestroyed=");
            printwriter.println((() (s)).l);
            printwriter.print(s1);
            printwriter.print("mRetaining=");
            printwriter.print(((l) (s)).i);
            printwriter.print(" mRetainingStarted=");
            printwriter.print(((i) (s)).j);
            printwriter.print(" mListenerRegistered=");
            printwriter.println((() (s)).m);
            if (((m) (s)).n != null)
            {
                printwriter.print(s1);
                printwriter.println("Pending Loader ");
                printwriter.print((() (s)).n);
                printwriter.println(":");
                s = (() (s)).n;
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
        ragments ragments = this;
        do
        {
            if (p.a)
            {
                (new StringBuilder("  Destroying: ")).append(ragments);
            }
            ragments.l = true;
            boolean flag = ragments.f;
            ragments.f = false;
            if (ragments.c != null && ragments.d != null && ragments.e && flag)
            {
                if (p.a)
                {
                    (new StringBuilder("  Reseting: ")).append(ragments);
                }
                Object obj;
                if (ragments.o.e != null)
                {
                    obj = ragments.o.e.mFragments.u;
                    ragments.o.e.mFragments.u = "onLoaderReset";
                } else
                {
                    obj = null;
                }
                if (ragments.o.e != null)
                {
                    ragments.o.e.mFragments.u = ((String) (obj));
                }
            }
            ragments.c = null;
            ragments.g = null;
            ragments.e = false;
            if (ragments.d != null)
            {
                if (ragments.m)
                {
                    ragments.m = false;
                    ragments.d.a(ragments);
                }
                obj = ragments.d;
                ((d) (obj)).g();
                obj.k = true;
                obj.i = false;
                obj.j = false;
                obj.l = false;
                obj.m = false;
            }
            if (ragments.n != null)
            {
                ragments = ragments.n;
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

    public tion(p p1, int i1, tion tion)
    {
        o = p1;
        super();
        a = i1;
        c = tion;
    }
}
