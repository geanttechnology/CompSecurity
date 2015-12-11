// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.a;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.f.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class d
{
    public final class a extends ContentObserver
    {

        final d a;

        public final boolean deliverSelfNotifications()
        {
            return true;
        }

        public final void onChange(boolean flag)
        {
            a.i();
        }

        public a()
        {
            a = d.this;
            super(new Handler());
        }
    }

    public static interface b
    {

        public abstract void a(d d1, Object obj);
    }


    public int f;
    public b g;
    public Context h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    public d(Context context)
    {
        i = false;
        j = false;
        k = true;
        l = false;
        m = false;
        h = context.getApplicationContext();
    }

    protected void a()
    {
    }

    public final void a(b b1)
    {
        if (g == null)
        {
            throw new IllegalStateException("No listener register");
        }
        if (g != b1)
        {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else
        {
            g = null;
            return;
        }
    }

    public void a(Object obj)
    {
        if (g != null)
        {
            g.a(this, obj);
        }
    }

    public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.print(s);
        printwriter.print("mId=");
        printwriter.print(f);
        printwriter.print(" mListener=");
        printwriter.println(g);
        if (i || l || m)
        {
            printwriter.print(s);
            printwriter.print("mStarted=");
            printwriter.print(i);
            printwriter.print(" mContentChanged=");
            printwriter.print(l);
            printwriter.print(" mProcessingChange=");
            printwriter.println(m);
        }
        if (j || k)
        {
            printwriter.print(s);
            printwriter.print("mAbandoned=");
            printwriter.print(j);
            printwriter.print(" mReset=");
            printwriter.println(k);
        }
    }

    public void d()
    {
    }

    public final void e()
    {
        a();
    }

    public void f()
    {
    }

    public void g()
    {
    }

    public final boolean h()
    {
        boolean flag = l;
        l = false;
        m = m | flag;
        return flag;
    }

    public final void i()
    {
        if (i)
        {
            a();
            return;
        } else
        {
            l = true;
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        c.a(this, stringbuilder);
        stringbuilder.append(" id=");
        stringbuilder.append(f);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}
