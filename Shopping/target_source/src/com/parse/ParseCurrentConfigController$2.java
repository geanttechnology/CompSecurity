// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseCurrentConfigController, ParseConfig

class this._cls0
    implements Callable
{

    final ParseCurrentConfigController this$0;

    public ParseConfig call()
        throws Exception
    {
        Object obj = ParseCurrentConfigController.access$000(ParseCurrentConfigController.this);
        obj;
        JVM INSTR monitorenter ;
        if (currentConfig != null) goto _L2; else goto _L1
_L1:
        ParseConfig parseconfig;
        ParseCurrentConfigController parsecurrentconfigcontroller;
        parseconfig = getFromDisk();
        parsecurrentconfigcontroller = ParseCurrentConfigController.this;
        if (parseconfig == null) goto _L4; else goto _L3
_L3:
        parsecurrentconfigcontroller.currentConfig = parseconfig;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return currentConfig;
_L4:
        parseconfig = new ParseConfig();
        if (true) goto _L3; else goto _L5
_L5:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    ()
    {
        this$0 = ParseCurrentConfigController.this;
        super();
    }
}
