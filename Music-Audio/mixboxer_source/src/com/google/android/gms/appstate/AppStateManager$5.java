// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dc;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateManager

static final class <init> extends <init>
{

    final int jQ;

    protected volatile void a(com.google.android.gms.common.api.nit> nit>)
    {
        a((dc)nit>);
    }

    protected void a(dc dc1)
    {
        dc1.a(this, jQ);
    }

    public ateDeletedResult d(Status status)
    {
        return new AppStateManager.StateDeletedResult(status) {

            final Status jP;
            final AppStateManager._cls5 jS;

            public int getStateKey()
            {
                return jS.jQ;
            }

            public Status getStatus()
            {
                return jP;
            }

            
            {
                jS = AppStateManager._cls5.this;
                jP = status;
                super();
            }
        };
    }

    public Result e(Status status)
    {
        return d(status);
    }

    _cls1.jP(int i)
    {
        jQ = i;
        super(null);
    }
}
