// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.google.android.gms.common.api:
//            u, c

private class c
    implements c
{

    public final int a;
    public final c b;
    public final onResult c;
    final u d;

    public void a()
    {
        b.b(this);
        b.c();
    }

    public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.append(s).append("GoogleApiClient #").print(a);
        printwriter.println(":");
        b.a((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        u.d(d).post(new <init>(d, a, connectionresult));
    }

    public onResult(u u1, int i, c c1, onResult onresult)
    {
        d = u1;
        super();
        a = i;
        b = c1;
        c = onresult;
        c1.a(this);
    }
}
