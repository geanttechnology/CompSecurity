// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.RemoteException;
import com.google.android.gms.plus.internal.c;
import com.google.android.gms.plus.internal.d;

// Referenced classes of package com.google.android.gms.d:
//            jo

final class api.c extends api.c
{

    final jo c;

    protected final void a(com.google.android.gms.common.api.a a1)
    {
        d d1 = (d)a1;
        d1.l();
        d1.p();
        a1 = new com.google.android.gms.plus.internal.init>(this);
        try
        {
            ((c)d1.m()).b(a1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            a1.(8, null);
        }
    }

    api.c(jo jo1, com.google.android.gms.common.api.c c1)
    {
        c = jo1;
        super(c1, (byte)0);
    }
}
