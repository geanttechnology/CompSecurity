// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.spi;

import java.io.Serializable;
import org.apache.log4j.Category;
import org.apache.log4j.DefaultThrowableRenderer;

// Referenced classes of package org.apache.log4j.spi:
//            ThrowableRendererSupport, ThrowableRenderer

public class ThrowableInformation
    implements Serializable
{

    private transient Category category;
    private String rep[];
    private transient Throwable throwable;

    public ThrowableInformation(Throwable throwable1, Category category1)
    {
        throwable = throwable1;
        category = category1;
    }

    public Throwable getThrowable()
    {
        return throwable;
    }

    public String[] getThrowableStrRep()
    {
        this;
        JVM INSTR monitorenter ;
        if (rep != null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        String as[];
        Object obj;
        obj = null;
        as = obj;
        LoggerRepository loggerrepository;
        if (category == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        loggerrepository = category.getLoggerRepository();
        as = obj;
        if (loggerrepository instanceof ThrowableRendererSupport)
        {
            as = ((ThrowableRendererSupport)loggerrepository).getThrowableRenderer();
        }
        if (as != null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        rep = DefaultThrowableRenderer.render(throwable);
_L1:
        as = (String[])(String[])rep.clone();
        this;
        JVM INSTR monitorexit ;
        return as;
        rep = as.doRender(throwable);
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }
}
