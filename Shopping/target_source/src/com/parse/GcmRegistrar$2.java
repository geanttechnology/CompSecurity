// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            GcmRegistrar, PLog

class this._cls0
    implements i
{

    final GcmRegistrar this$0;

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    public Void then(j j1)
    {
        j1 = j1.f();
        if (j1 != null)
        {
            PLog.e("com.parse.GcmRegistrar", "Got error when trying to register for GCM push", j1);
        }
        synchronized (GcmRegistrar.access$100(GcmRegistrar.this))
        {
            GcmRegistrar.access$202(GcmRegistrar.this, null);
        }
        return null;
        exception;
        j1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = GcmRegistrar.this;
        super();
    }
}
