// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.IOException;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            GcmRegistrar, ManifestInfo, ParseFileUtils

class this._cls0
    implements Callable
{

    final GcmRegistrar this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        Object obj = GcmRegistrar.access$400(GcmRegistrar.this);
        obj;
        JVM INSTR monitorenter ;
        long l;
        GcmRegistrar.access$502(GcmRegistrar.this, ManifestInfo.getLastModified());
        l = GcmRegistrar.access$500(GcmRegistrar.this);
        Exception exception;
        try
        {
            ParseFileUtils.writeStringToFile(GcmRegistrar.getLocalDeviceTokenLastModifiedFile(), String.valueOf(l), "UTF-8");
        }
        catch (IOException ioexception) { }
        return null;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    able()
    {
        this$0 = GcmRegistrar.this;
        super();
    }
}
