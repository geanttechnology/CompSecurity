// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.a.d;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.google.android.gms.common.api:
//            v, c

static final class a extends d
    implements a, a
{

    public final c a;
    boolean b;
    private ConnectionResult c;

    private void b(ConnectionResult connectionresult)
    {
        c = connectionresult;
        if (super.i && !super.j)
        {
            a(connectionresult);
        }
    }

    public final void a(int i)
    {
    }

    public final void a(Bundle bundle)
    {
        b = false;
        b(ConnectionResult.a);
    }

    public final void a(ConnectionResult connectionresult)
    {
        b = true;
        b(connectionresult);
    }

    public final void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        super.a(s, filedescriptor, printwriter, as);
        a.a(s, printwriter);
    }

    protected final void d()
    {
        super.d();
        a.a(this);
        a.a(this);
        if (c != null)
        {
            a(c);
        }
        if (!a.d() && !a.e() && !b)
        {
            a.b();
        }
    }

    protected final void f()
    {
        a.c();
    }

    protected final void g()
    {
        c = null;
        b = false;
        a.b(this);
        a.b(this);
        a.c();
    }

    public onResult(Context context, c c1)
    {
        super(context);
        a = c1;
    }
}
