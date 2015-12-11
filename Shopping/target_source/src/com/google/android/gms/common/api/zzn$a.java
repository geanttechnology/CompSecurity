// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.a.g;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.google.android.gms.common.api:
//            zzn, d

static class i extends g
    implements i, i
{

    public final d i;
    private boolean j;
    private ConnectionResult k;

    private void b(ConnectionResult connectionresult)
    {
        k = connectionresult;
        if (b() && !c())
        {
            a(connectionresult);
        }
    }

    public void a(int i1)
    {
    }

    public void a(Bundle bundle)
    {
        j = false;
        b(ConnectionResult.a);
    }

    public void a(ConnectionResult connectionresult)
    {
        j = true;
        b(connectionresult);
    }

    public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        super.a(s, filedescriptor, printwriter, as);
        i.a(s, filedescriptor, printwriter, as);
    }

    protected void e()
    {
        super.e();
        i.a(this);
        i.a(this);
        if (k != null)
        {
            a(k);
        }
        if (!i.e() && !i.f() && !j)
        {
            i.c();
        }
    }

    protected void g()
    {
        i.d();
    }

    protected void k()
    {
        k = null;
        j = false;
        i.b(this);
        i.b(this);
        i.d();
    }

    public boolean l()
    {
        return j;
    }

    public Result(Context context, d d1)
    {
        super(context);
        i = d1;
    }
}
