// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.google.android.gms.common.api:
//            zzm, d

private class c
    implements c
{

    public final int a;
    public final d b;
    public final b c;
    final zzm d;

    public void a()
    {
        b.b(this);
        b.d();
    }

    public void a(ConnectionResult connectionresult)
    {
        zzm.d(d).post(new <init>(d, a, connectionresult));
    }

    public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.append(s).append("GoogleApiClient #").print(a);
        printwriter.println(":");
        b.a((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
    }

    public Result(zzm zzm1, int i, d d1, Result result)
    {
        d = zzm1;
        super();
        a = i;
        b = d1;
        c = result;
        d1.a(this);
    }
}
