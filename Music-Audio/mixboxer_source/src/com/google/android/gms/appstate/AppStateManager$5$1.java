// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dc;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateManager

class jP
    implements eDeletedResult
{

    final Status jP;
    final jP jS;

    public int getStateKey()
    {
        return jS.;
    }

    public Status getStatus()
    {
        return jP;
    }

    nit>(nit> nit>, Status status)
    {
        jS = nit>;
        jP = status;
        super();
    }

    // Unreferenced inner class com/google/android/gms/appstate/AppStateManager$5

/* anonymous class */
    static final class AppStateManager._cls5 extends AppStateManager.b
    {

        final int jQ;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((dc)a1);
        }

        protected void a(dc dc1)
        {
            dc1.a(this, jQ);
        }

        public AppStateManager.StateDeletedResult d(Status status)
        {
            return new AppStateManager._cls5._cls1(this, status);
        }

        public Result e(Status status)
        {
            return d(status);
        }

            
            {
                jQ = i;
                super(null);
            }
    }

}
