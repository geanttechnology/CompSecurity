// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.b;

import android.support.v4.e.a;
import java.io.PrintWriter;

// Referenced classes of package android.support.v4.b:
//            g

public final class f
{

    private int a;
    private g b;
    private g c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;

    public final void a()
    {
        d = true;
        f = false;
        e = false;
    }

    public final void a(int i, g g1)
    {
        if (b != null)
        {
            throw new IllegalStateException("There is already a listener registered");
        } else
        {
            b = g1;
            a = i;
            return;
        }
    }

    public final void a(g g1)
    {
        if (b == null)
        {
            throw new IllegalStateException("No listener register");
        }
        if (b != g1)
        {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else
        {
            b = null;
            return;
        }
    }

    public final void a(String s, PrintWriter printwriter)
    {
        printwriter.print(s);
        printwriter.print("mId=");
        printwriter.print(a);
        printwriter.print(" mListener=");
        printwriter.println(b);
        if (d)
        {
            printwriter.print(s);
            printwriter.print("mStarted=");
            printwriter.print(d);
            printwriter.print(" mContentChanged=");
            printwriter.print(false);
            printwriter.print(" mProcessingChange=");
            printwriter.println(false);
        }
        if (f)
        {
            printwriter.print(s);
            printwriter.print("mAbandoned=");
            printwriter.print(false);
            printwriter.print(" mReset=");
            printwriter.println(f);
        }
    }

    public final void b()
    {
        d = false;
    }

    public final void b(g g1)
    {
        if (c != null)
        {
            throw new IllegalStateException("There is already a listener registered");
        } else
        {
            c = g1;
            return;
        }
    }

    public final void c()
    {
        f = true;
        d = false;
        e = false;
        g = false;
        h = false;
    }

    public final void c(g g1)
    {
        if (c == null)
        {
            throw new IllegalStateException("No listener register");
        }
        if (c != g1)
        {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else
        {
            c = null;
            return;
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        android.support.v4.e.a.a(this, stringbuilder);
        stringbuilder.append(" id=");
        stringbuilder.append(a);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}
