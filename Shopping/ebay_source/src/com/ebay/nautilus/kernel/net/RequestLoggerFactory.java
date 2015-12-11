// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            Request, IRequestLogger, Response

public abstract class RequestLoggerFactory
{
    private static final class ErrorLogger
        implements IRequestLogger
    {

        private final ArrayList loggers;

        public void logHostError(int i)
        {
            for (Iterator iterator = loggers.iterator(); iterator.hasNext(); ((IRequestLogger)iterator.next()).logHostError(i)) { }
        }

        public void setCompleteResponse(Response response)
        {
            for (Iterator iterator = loggers.iterator(); iterator.hasNext(); ((IRequestLogger)iterator.next()).setCompleteResponse(response)) { }
        }

        public void setRequestTime(long l)
        {
            for (Iterator iterator = loggers.iterator(); iterator.hasNext(); ((IRequestLogger)iterator.next()).setRequestTime(l)) { }
        }

        public void setResponseTime(long l)
        {
            for (Iterator iterator = loggers.iterator(); iterator.hasNext(); ((IRequestLogger)iterator.next()).setResponseTime(l)) { }
        }

        public ErrorLogger(ArrayList arraylist)
        {
            loggers = arraylist;
        }
    }


    private static ArrayList factories = null;

    public RequestLoggerFactory()
    {
    }

    public static void add(RequestLoggerFactory requestloggerfactory)
    {
        com/ebay/nautilus/kernel/net/RequestLoggerFactory;
        JVM INSTR monitorenter ;
        if (requestloggerfactory != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new NullPointerException("factory");
        requestloggerfactory;
        com/ebay/nautilus/kernel/net/RequestLoggerFactory;
        JVM INSTR monitorexit ;
        throw requestloggerfactory;
        if (factories == null)
        {
            factories = new ArrayList();
        }
        factories.add(requestloggerfactory);
        com/ebay/nautilus/kernel/net/RequestLoggerFactory;
        JVM INSTR monitorexit ;
    }

    public static IRequestLogger createLogger(Request request)
    {
        com/ebay/nautilus/kernel/net/RequestLoggerFactory;
        JVM INSTR monitorenter ;
        Object obj = factories;
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L8:
        com/ebay/nautilus/kernel/net/RequestLoggerFactory;
        JVM INSTR monitorexit ;
        return ((IRequestLogger) (obj));
_L2:
        ArrayList arraylist;
        arraylist = null;
        obj = null;
        Iterator iterator = factories.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        IRequestLogger irequestlogger = ((RequestLoggerFactory)iterator.next()).create(request);
        if (irequestlogger == null) goto _L6; else goto _L5
_L5:
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        arraylist.add(irequestlogger);
          goto _L6
        request;
        throw request;
label0:
        {
            if (obj != null)
            {
                break label0;
            }
            obj = irequestlogger;
        }
          goto _L6
        arraylist = new ArrayList();
        arraylist.add(obj);
        arraylist.add(irequestlogger);
        obj = null;
          goto _L6
_L4:
        if (arraylist == null) goto _L8; else goto _L7
_L7:
        obj = new ErrorLogger(arraylist);
          goto _L8
    }

    public static void remove(RequestLoggerFactory requestloggerfactory)
    {
        com/ebay/nautilus/kernel/net/RequestLoggerFactory;
        JVM INSTR monitorenter ;
        if (requestloggerfactory != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new NullPointerException("factory");
        requestloggerfactory;
        com/ebay/nautilus/kernel/net/RequestLoggerFactory;
        JVM INSTR monitorexit ;
        throw requestloggerfactory;
        ArrayList arraylist = factories;
        if (arraylist != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
_L1:
        com/ebay/nautilus/kernel/net/RequestLoggerFactory;
        JVM INSTR monitorexit ;
        return;
        Iterator iterator = factories.iterator();
        while (iterator.hasNext()) 
        {
            if (iterator.next() == requestloggerfactory)
            {
                iterator.remove();
            }
        }
          goto _L1
    }

    public abstract IRequestLogger create(Request request);

}
