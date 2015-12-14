// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import com.inmobi.commons.core.utilities.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.inmobi.ads:
//            i, AdUnit

class nit>
    implements Runnable
{

    final i a;

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, i.d(), "Flushing ad unit cache due to low memory.");
        for (Iterator iterator = i.e().entrySet().iterator(); iterator.hasNext(); iterator.remove())
        {
            ((AdUnit)((java.util.Entry)iterator.next()).getValue()).t();
        }

        break MISSING_BLOCK_LABEL_70;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    it(i j)
    {
        a = j;
        super();
    }
}
