// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.o;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.google.android.gms.common.api:
//            v, c

static class i extends o
    implements i, i
{

    public final c i;
    private boolean j;
    private ConnectionResult k;

    private void a(ConnectionResult connectionresult)
    {
        k = connectionresult;
        if (b() && !c())
        {
            a(connectionresult);
        }
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
        if (!i.d() && !i.e() && !j)
        {
            i.b();
        }
    }

    protected void g()
    {
        i.c();
    }

    protected void k()
    {
        k = null;
        j = false;
        i.b(this);
        i.b(this);
        i.c();
    }

    public boolean l()
    {
        return j;
    }

    public void onConnected(Bundle bundle)
    {
        j = false;
        a(ConnectionResult.a);
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        j = true;
        a(connectionresult);
    }

    public void onConnectionSuspended(int i1)
    {
    }

    public onResult(Context context, c c1)
    {
        super(context);
        i = c1;
    }
}
