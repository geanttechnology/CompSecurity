// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.v4.a.a;
import android.support.v4.a.d;
import android.support.v4.a.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.shazam.android.k:
//            k, b

public final class j extends a
{

    public final k n;
    public com.shazam.android.k.a.a o;
    protected final Uri p;
    protected Object q;
    boolean r;
    private final android.support.v4.a.d.a s = new android.support.v4.a.d.a(this);

    public j(Context context, k k1)
    {
        super(context);
        r = true;
        p = k1.a;
        n = k1;
        n.a(this);
        context.getContentResolver().registerContentObserver(p, false, s);
    }

    public final void a(Object obj)
    {
        while (super.k || !super.i) 
        {
            return;
        }
        super.a(obj);
    }

    public final void a(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        super.a(s1, filedescriptor, printwriter, as);
        printwriter.print(s1);
        printwriter.print("mUri=");
        printwriter.println(p);
        printwriter.print(s1);
        printwriter.print("isLoading=");
        printwriter.print(r);
        printwriter.print(s1);
        printwriter.print("isError=");
        printwriter.print(n.a());
    }

    public final Object c()
    {
        o = null;
        try
        {
            b b1 = n.a(super.h);
            q = b1.a;
            r = b1.b;
        }
        catch (Exception exception)
        {
            p.toString();
            if (exception instanceof com.shazam.android.k.a.a)
            {
                o = (com.shazam.android.k.a.a)exception;
            } else
            {
                o = new com.shazam.android.k.a.a("Unknown issue loading content", exception);
            }
        }
        return q;
    }

    protected final void d()
    {
        if (q != null)
        {
            a(q);
        }
        if (h() || q == null)
        {
            e();
        }
    }

    protected final void g()
    {
        super.g();
        k k1 = n;
        if (k1.c)
        {
            k1.c = false;
            Context context = ((d) (k1.d)).h;
            if (k1.e != null)
            {
                e.a(context).a(k1.e);
            }
        }
        q = null;
        super.h.getContentResolver().unregisterContentObserver(s);
    }
}
