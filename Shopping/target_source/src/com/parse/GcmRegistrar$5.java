// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.IOException;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            GcmRegistrar, ParseFileUtils

class this._cls0
    implements Callable
{

    final GcmRegistrar this$0;

    public Long call()
        throws Exception
    {
        Object obj = GcmRegistrar.access$400(GcmRegistrar.this);
        obj;
        JVM INSTR monitorenter ;
        long l = GcmRegistrar.access$500(GcmRegistrar.this);
        if (l != 0L)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        String s = ParseFileUtils.readFileToString(GcmRegistrar.getLocalDeviceTokenLastModifiedFile(), "UTF-8");
        GcmRegistrar.access$502(GcmRegistrar.this, Long.valueOf(s).longValue());
_L1:
        l = GcmRegistrar.access$500(GcmRegistrar.this);
        obj;
        JVM INSTR monitorexit ;
        return Long.valueOf(l);
        Object obj1;
        obj1;
        GcmRegistrar.access$502(GcmRegistrar.this, 0L);
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    able()
    {
        this$0 = GcmRegistrar.this;
        super();
    }
}
