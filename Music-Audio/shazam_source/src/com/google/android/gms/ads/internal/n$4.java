// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.e;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.bv;
import com.google.android.gms.d.gb;
import com.google.android.gms.d.id;

// Referenced classes of package com.google.android.gms.ads.internal:
//            n, q

final class b
    implements Runnable
{

    final String a;
    final gb b;
    final n c;

    public final void run()
    {
        try
        {
            ((bv)c.c.v.get(a)).a((e)b.w);
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    .client.b(n n1, String s, gb gb1)
    {
        c = n1;
        a = s;
        b = gb1;
        super();
    }
}
