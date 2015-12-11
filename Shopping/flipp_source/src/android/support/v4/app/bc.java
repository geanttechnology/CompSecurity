// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.a.k;
import android.support.v4.a.l;
import android.support.v4.c.c;
import android.support.v4.c.d;
import android.support.v4.c.p;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

// Referenced classes of package android.support.v4.app:
//            bb, ba, ac, ai

final class bc
    implements l
{

    final int a = 0;
    final Bundle b = null;
    ba c;
    k d;
    boolean e;
    boolean f;
    Object g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    bc n;
    final bb o;

    public bc(bb bb1, ba ba1)
    {
        o = bb1;
        super();
        c = ba1;
    }

    final void a()
    {
        if (i && j)
        {
            h = true;
        } else
        if (!h)
        {
            h = true;
            if (bb.a)
            {
                Log.v("LoaderManager", (new StringBuilder("  Starting: ")).append(this).toString());
            }
            if (d == null && c != null)
            {
                d = c.onCreateLoader(a, b);
            }
            if (d != null)
            {
                if (d.getClass().isMemberClass() && !Modifier.isStatic(d.getClass().getModifiers()))
                {
                    throw new IllegalArgumentException((new StringBuilder("Object returned from onCreateLoader must not be a non-static inner member class: ")).append(d).toString());
                }
                if (!m)
                {
                    d.registerListener(a, this);
                    m = true;
                }
                d.startLoading();
                return;
            }
        }
    }

    public final void a(k k1, Object obj)
    {
        if (bb.a)
        {
            Log.v("LoaderManager", (new StringBuilder("onLoadComplete: ")).append(this).toString());
        }
        if (!l) goto _L2; else goto _L1
_L1:
        if (bb.a)
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
        if (bb.a)
        {
            Log.v("LoaderManager", "  Ignoring load complete -- not active");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        bc bc1 = n;
        if (bc1 != null)
        {
            if (bb.a)
            {
                Log.v("LoaderManager", (new StringBuilder("  Switching to pending loader: ")).append(bc1).toString());
            }
            n = null;
            o.b.a(a, null);
            c();
            o.a(bc1);
            return;
        }
        if (g != obj || !e)
        {
            g = obj;
            e = true;
            if (h)
            {
                b(k1, obj);
            }
        }
        k1 = (bc)o.c.a(a);
        if (k1 != null && k1 != this)
        {
            k1.f = false;
            k1.c();
            k1 = o.c;
            int i1 = a;
            i1 = android.support.v4.c.c.a(((p) (k1)).c, ((p) (k1)).e, i1);
            if (i1 >= 0 && ((p) (k1)).d[i1] != p.a)
            {
                ((p) (k1)).d[i1] = p.a;
                k1.b = true;
            }
        }
        if (o.e != null && !o.a())
        {
            o.e.mFragments.c();
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public final void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        String s1 = s;
        s = this;
        do
        {
            printwriter.print(s1);
            printwriter.print("mId=");
            printwriter.print(((bc) (s)).a);
            printwriter.print(" mArgs=");
            printwriter.println(((bc) (s)).b);
            printwriter.print(s1);
            printwriter.print("mCallbacks=");
            printwriter.println(((bc) (s)).c);
            printwriter.print(s1);
            printwriter.print("mLoader=");
            printwriter.println(((bc) (s)).d);
            if (((bc) (s)).d != null)
            {
                ((bc) (s)).d.dump((new StringBuilder()).append(s1).append("  ").toString(), filedescriptor, printwriter, as);
            }
            if (((bc) (s)).e || ((bc) (s)).f)
            {
                printwriter.print(s1);
                printwriter.print("mHaveData=");
                printwriter.print(((bc) (s)).e);
                printwriter.print("  mDeliveredData=");
                printwriter.println(((bc) (s)).f);
                printwriter.print(s1);
                printwriter.print("mData=");
                printwriter.println(((bc) (s)).g);
            }
            printwriter.print(s1);
            printwriter.print("mStarted=");
            printwriter.print(((bc) (s)).h);
            printwriter.print(" mReportNextStart=");
            printwriter.print(((bc) (s)).k);
            printwriter.print(" mDestroyed=");
            printwriter.println(((bc) (s)).l);
            printwriter.print(s1);
            printwriter.print("mRetaining=");
            printwriter.print(((bc) (s)).i);
            printwriter.print(" mRetainingStarted=");
            printwriter.print(((bc) (s)).j);
            printwriter.print(" mListenerRegistered=");
            printwriter.println(((bc) (s)).m);
            if (((bc) (s)).n != null)
            {
                printwriter.print(s1);
                printwriter.println("Pending Loader ");
                printwriter.print(((bc) (s)).n);
                printwriter.println(":");
                s = ((bc) (s)).n;
                s1 = (new StringBuilder()).append(s1).append("  ").toString();
            } else
            {
                return;
            }
        } while (true);
    }

    final void b()
    {
        if (bb.a)
        {
            Log.v("LoaderManager", (new StringBuilder("  Stopping: ")).append(this).toString());
        }
        h = false;
        if (!i && d != null && m)
        {
            m = false;
            d.unregisterListener(this);
            d.stopLoading();
        }
    }

    final void b(k k1, Object obj)
    {
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        String s;
        if (o.e != null)
        {
            s = o.e.mFragments.u;
            o.e.mFragments.u = "onLoadFinished";
        } else
        {
            s = null;
        }
        if (bb.a)
        {
            Log.v("LoaderManager", (new StringBuilder("  onLoadFinished in ")).append(k1).append(": ").append(k1.dataToString(obj)).toString());
        }
        c.onLoadFinished(k1, obj);
        if (o.e != null)
        {
            o.e.mFragments.u = s;
        }
        f = true;
        return;
        k1;
        if (o.e != null)
        {
            o.e.mFragments.u = s;
        }
        throw k1;
    }

    final void c()
    {
        bc bc1 = this;
_L2:
        if (bb.a)
        {
            Log.v("LoaderManager", (new StringBuilder("  Destroying: ")).append(bc1).toString());
        }
        bc1.l = true;
        boolean flag = bc1.f;
        bc1.f = false;
        if (bc1.c == null || bc1.d == null || !bc1.e || !flag)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        if (bb.a)
        {
            Log.v("LoaderManager", (new StringBuilder("  Reseting: ")).append(bc1).toString());
        }
        String s;
        Exception exception;
        if (bc1.o.e != null)
        {
            s = bc1.o.e.mFragments.u;
            bc1.o.e.mFragments.u = "onLoaderReset";
        } else
        {
            s = null;
        }
        bc1.c.onLoaderReset(bc1.d);
        if (bc1.o.e != null)
        {
            bc1.o.e.mFragments.u = s;
        }
        bc1.c = null;
        bc1.g = null;
        bc1.e = false;
        if (bc1.d != null)
        {
            if (bc1.m)
            {
                bc1.m = false;
                bc1.d.unregisterListener(bc1);
            }
            bc1.d.reset();
        }
        if (bc1.n != null)
        {
            bc1 = bc1.n;
        } else
        {
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        if (bc1.o.e != null)
        {
            bc1.o.e.mFragments.u = s;
        }
        throw exception;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        stringbuilder.append("LoaderInfo{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" #");
        stringbuilder.append(a);
        stringbuilder.append(" : ");
        android.support.v4.c.d.a(d, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }
}
