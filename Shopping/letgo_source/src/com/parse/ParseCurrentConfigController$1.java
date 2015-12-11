// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseCurrentConfigController, ParseConfig

class val.config
    implements Callable
{

    final ParseCurrentConfigController this$0;
    final ParseConfig val$config;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        synchronized (ParseCurrentConfigController.access$000(ParseCurrentConfigController.this))
        {
            currentConfig = val$config;
            saveToDisk(val$config);
        }
        return null;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = final_parsecurrentconfigcontroller;
        val$config = ParseConfig.this;
        super();
    }
}
