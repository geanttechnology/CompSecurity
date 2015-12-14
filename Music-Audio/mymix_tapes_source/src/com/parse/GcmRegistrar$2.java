// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            GcmRegistrar, Parse

class this._cls0
    implements Continuation
{

    final GcmRegistrar this$0;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
    {
        task = task.getError();
        if (task != null)
        {
            Parse.logE("com.parse.GcmRegistrar", "Got error when trying to register for GCM push", task);
        }
        synchronized (GcmRegistrar.access$000(GcmRegistrar.this))
        {
            GcmRegistrar.access$102(GcmRegistrar.this, null);
        }
        return null;
        exception;
        task;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = GcmRegistrar.this;
        super();
    }
}
