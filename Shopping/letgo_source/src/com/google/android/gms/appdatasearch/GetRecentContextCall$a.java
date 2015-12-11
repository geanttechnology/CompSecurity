// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.os.RemoteException;
import android.support.v7.uz;
import android.support.v7.vb;
import android.support.v7.vc;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            GetRecentContextCall, a

public static class b extends com.google.android.gms.common.api..a
{

    private final quest b;

    protected sponse a(Status status)
    {
        sponse sponse = new sponse();
        sponse.a = status;
        return sponse;
    }

    protected void a(vc vc1)
        throws RemoteException
    {
        vc1.a().a(b, new vb(this) {

            final GetRecentContextCall.a a;

            public void a(GetRecentContextCall.Response response)
            {
                b.a(response);
            }

            
            {
                a = GetRecentContextCall.a.this;
                super(b1);
            }
        });
    }

    protected volatile void a(com.google.android.gms.common.api..a a1)
        throws RemoteException
    {
        a((vc)a1);
    }

    protected g b(Status status)
    {
        return a(status);
    }

    public quest(quest quest, c c)
    {
        super(a.a, c);
        b = quest;
    }
}
