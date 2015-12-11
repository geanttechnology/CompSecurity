// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class am
    implements bv
{

    final int a;
    ak b;
    bu c;
    boolean d;
    boolean e;
    Object f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    am k;
    private Bundle l;
    private boolean m;
    private boolean n;
    private al o;

    public am(al al1, int i1, Bundle bundle, ak ak1)
    {
        o = al1;
        super();
        a = i1;
        l = bundle;
        b = ak1;
    }

    final void a()
    {
        if (h && i)
        {
            g = true;
        } else
        if (!g)
        {
            g = true;
            if (c == null && b != null)
            {
                ak ak1 = b;
                int i1 = a;
                Bundle bundle = l;
                c = ak1.a(i1);
            }
            if (c != null)
            {
                if (c.getClass().isMemberClass() && !Modifier.isStatic(c.getClass().getModifiers()))
                {
                    throw new IllegalArgumentException((new StringBuilder("Object returned from onCreateLoader must not be a non-static inner member class: ")).append(c).toString());
                }
                if (!n)
                {
                    bu bu1 = c;
                    int j1 = a;
                    if (bu1.b != null)
                    {
                        throw new IllegalStateException("There is already a listener registered");
                    }
                    bu1.b = this;
                    bu1.a = j1;
                    n = true;
                }
                c.a();
                return;
            }
        }
    }

    public final void a(bu bu1, Object obj)
    {
        if (!m && o.b.a(a) == this)
        {
            am am1 = k;
            if (am1 != null)
            {
                k = null;
                o.b.a(a, null);
                c();
                o.a(am1);
                return;
            }
            if (f != obj || !d)
            {
                f = obj;
                d = true;
                if (g)
                {
                    b(bu1, obj);
                }
            }
            bu1 = (am)o.c.a(a);
            if (bu1 != null && bu1 != this)
            {
                bu1.e = false;
                bu1.c();
                bu1 = o.c;
                int i1 = a;
                i1 = db.a(((dl) (bu1)).c, ((dl) (bu1)).e, i1);
                if (i1 >= 0 && ((dl) (bu1)).d[i1] != dl.a)
                {
                    ((dl) (bu1)).d[i1] = dl.a;
                    bu1.b = true;
                }
            }
            if (o.e != null && !o.a())
            {
                o.e.b.d();
                return;
            }
        }
    }

    public final void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        filedescriptor = s;
        s = this;
        do
        {
            printwriter.print(filedescriptor);
            printwriter.print("mId=");
            printwriter.print(((am) (s)).a);
            printwriter.print(" mArgs=");
            printwriter.println(((am) (s)).l);
            printwriter.print(filedescriptor);
            printwriter.print("mCallbacks=");
            printwriter.println(((am) (s)).b);
            printwriter.print(filedescriptor);
            printwriter.print("mLoader=");
            printwriter.println(((am) (s)).c);
            if (((am) (s)).c != null)
            {
                as = ((am) (s)).c;
                String s1 = (new StringBuilder()).append(filedescriptor).append("  ").toString();
                printwriter.print(s1);
                printwriter.print("mId=");
                printwriter.print(((bu) (as)).a);
                printwriter.print(" mListener=");
                printwriter.println(((bu) (as)).b);
                if (((bu) (as)).c)
                {
                    printwriter.print(s1);
                    printwriter.print("mStarted=");
                    printwriter.print(((bu) (as)).c);
                    printwriter.print(" mContentChanged=");
                    printwriter.print(false);
                    printwriter.print(" mProcessingChange=");
                    printwriter.println(false);
                }
                if (((bu) (as)).d || ((bu) (as)).e)
                {
                    printwriter.print(s1);
                    printwriter.print("mAbandoned=");
                    printwriter.print(((bu) (as)).d);
                    printwriter.print(" mReset=");
                    printwriter.println(((bu) (as)).e);
                }
            }
            if (((am) (s)).d || ((am) (s)).e)
            {
                printwriter.print(filedescriptor);
                printwriter.print("mHaveData=");
                printwriter.print(((am) (s)).d);
                printwriter.print("  mDeliveredData=");
                printwriter.println(((am) (s)).e);
                printwriter.print(filedescriptor);
                printwriter.print("mData=");
                printwriter.println(((am) (s)).f);
            }
            printwriter.print(filedescriptor);
            printwriter.print("mStarted=");
            printwriter.print(((am) (s)).g);
            printwriter.print(" mReportNextStart=");
            printwriter.print(((am) (s)).j);
            printwriter.print(" mDestroyed=");
            printwriter.println(((am) (s)).m);
            printwriter.print(filedescriptor);
            printwriter.print("mRetaining=");
            printwriter.print(((am) (s)).h);
            printwriter.print(" mRetainingStarted=");
            printwriter.print(((am) (s)).i);
            printwriter.print(" mListenerRegistered=");
            printwriter.println(((am) (s)).n);
            if (((am) (s)).k != null)
            {
                printwriter.print(filedescriptor);
                printwriter.println("Pending Loader ");
                printwriter.print(((am) (s)).k);
                printwriter.println(":");
                s = ((am) (s)).k;
                filedescriptor = (new StringBuilder()).append(filedescriptor).append("  ").toString();
            } else
            {
                return;
            }
        } while (true);
    }

    final void b()
    {
        g = false;
        if (!h && c != null && n)
        {
            n = false;
            c.a(this);
            c.c();
        }
    }

    final void b(bu bu1, Object obj)
    {
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        String s;
        if (o.e != null)
        {
            s = o.e.b.k;
            o.e.b.k = "onLoadFinished";
        } else
        {
            s = null;
        }
        b.a(bu1, obj);
        if (o.e != null)
        {
            o.e.b.k = s;
        }
        e = true;
        return;
        bu1;
        if (o.e != null)
        {
            o.e.b.k = s;
        }
        throw bu1;
    }

    final void c()
    {
        am am1 = this;
_L2:
        am1.m = true;
        boolean flag = am1.e;
        am1.e = false;
        if (am1.b == null || am1.c == null || !am1.d || !flag)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        String s;
        Exception exception;
        if (am1.o.e != null)
        {
            s = am1.o.e.b.k;
            am1.o.e.b.k = "onLoaderReset";
        } else
        {
            s = null;
        }
        am1.b.a(am1.c);
        if (am1.o.e != null)
        {
            am1.o.e.b.k = s;
        }
        am1.b = null;
        am1.f = null;
        am1.d = false;
        if (am1.c != null)
        {
            if (am1.n)
            {
                am1.n = false;
                am1.c.a(am1);
            }
            am1.c.e();
        }
        if (am1.k != null)
        {
            am1 = am1.k;
        } else
        {
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        if (am1.o.e != null)
        {
            am1.o.e.b.k = s;
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
        a.a(c, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }
}
