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

class vb
    implements eDeletedResult
{

    final Status vb;
    final vb ve;

    public int getStateKey()
    {
        return ve.;
    }

    public Status getStatus()
    {
        return vb;
    }

    nit>(nit> nit>, Status status)
    {
        ve = nit>;
        vb = status;
        super();
    }

    // Unreferenced inner class com/google/android/gms/appstate/AppStateManager$5

/* anonymous class */
    static final class AppStateManager._cls5 extends AppStateManager.b
    {

        final int vc;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            throws RemoteException
        {
            a((dl)a1);
        }

        protected void a(dl dl1)
        {
            dl1.a(this, vc);
        }

        public AppStateManager.StateDeletedResult c(Status status)
        {
            return new AppStateManager._cls5._cls1(this, status);
        }

        public Result d(Status status)
        {
            return c(status);
        }

            
            {
                vc = i;
                super(null);
            }
    }

}
