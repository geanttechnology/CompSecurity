// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            GcmRegistrar, PLog

class this._cls0
    implements ct
{

    final GcmRegistrar this$0;

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    public Void then(cu cu1)
    {
        cu1 = cu1.f();
        if (cu1 != null)
        {
            PLog.e("com.parse.GcmRegistrar", "Got error when trying to register for GCM push", cu1);
        }
        synchronized (GcmRegistrar.access$100(GcmRegistrar.this))
        {
            GcmRegistrar.access$202(GcmRegistrar.this, null);
        }
        return null;
        exception;
        cu1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = GcmRegistrar.this;
        super();
    }
}
