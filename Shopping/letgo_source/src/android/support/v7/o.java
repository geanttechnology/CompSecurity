// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.support.v7:
//            av

public class o
{
    public static interface a
    {

        public abstract void a(o o1, Object obj);
    }


    int a;
    a b;
    Context c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;

    public o(Context context)
    {
        d = false;
        e = false;
        f = true;
        g = false;
        h = false;
        c = context.getApplicationContext();
    }

    public int a()
    {
        return a;
    }

    public void a(int l, a a1)
    {
        if (b != null)
        {
            throw new IllegalStateException("There is already a listener registered");
        } else
        {
            b = a1;
            a = l;
            return;
        }
    }

    public void a(a a1)
    {
        if (b == null)
        {
            throw new IllegalStateException("No listener register");
        }
        if (b != a1)
        {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else
        {
            b = null;
            return;
        }
    }

    public void a(Object obj)
    {
        if (b != null)
        {
            b.a(this, obj);
        }
    }

    public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.print(s);
        printwriter.print("mId=");
        printwriter.print(a);
        printwriter.print(" mListener=");
        printwriter.println(b);
        if (d || g || h)
        {
            printwriter.print(s);
            printwriter.print("mStarted=");
            printwriter.print(d);
            printwriter.print(" mContentChanged=");
            printwriter.print(g);
            printwriter.print(" mProcessingChange=");
            printwriter.println(h);
        }
        if (e || f)
        {
            printwriter.print(s);
            printwriter.print("mAbandoned=");
            printwriter.print(e);
            printwriter.print(" mReset=");
            printwriter.println(f);
        }
    }

    public String b(Object obj)
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        av.a(obj, stringbuilder);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public boolean b()
    {
        return d;
    }

    public boolean c()
    {
        return e;
    }

    public final void d()
    {
        d = true;
        f = false;
        e = false;
        e();
    }

    protected void e()
    {
    }

    public void f()
    {
        d = false;
        g();
    }

    protected void g()
    {
    }

    public void h()
    {
        e = true;
        i();
    }

    protected void i()
    {
    }

    public void j()
    {
        k();
        f = true;
        d = false;
        e = false;
        g = false;
        h = false;
    }

    protected void k()
    {
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        av.a(this, stringbuilder);
        stringbuilder.append(" id=");
        stringbuilder.append(a);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}
