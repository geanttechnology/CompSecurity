// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dl;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateManager

static final class <init> extends <init>
{

    final int vc;

    protected volatile void a(com.google.android.gms.common.api.nit> nit>)
        throws RemoteException
    {
        a((dl)nit>);
    }

    protected void a(dl dl1)
    {
        dl1.a(this, vc);
    }

    public ateDeletedResult c(Status status)
    {
        return new AppStateManager.StateDeletedResult(status) {

            final Status vb;
            final AppStateManager._cls5 ve;

            public int getStateKey()
            {
                return ve.vc;
            }

            public Status getStatus()
            {
                return vb;
            }

            
            {
                ve = AppStateManager._cls5.this;
                vb = status;
                super();
            }
        };
    }

    public Result d(Status status)
    {
        return c(status);
    }

    _cls1.vb(int i)
    {
        vc = i;
        super(null);
    }
}
