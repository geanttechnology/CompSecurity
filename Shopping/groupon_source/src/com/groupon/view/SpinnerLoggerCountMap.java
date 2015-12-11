// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.view.View;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.inject.ContextScopedProvider;

// Referenced classes of package com.groupon.view:
//            ReferenceCountMap

public class SpinnerLoggerCountMap extends ReferenceCountMap
{

    private static final String START = "start";
    private static final String STOP = "stop";
    private ContextScopedProvider loggerProvider;

    public SpinnerLoggerCountMap()
    {
    }

    public int decrement(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (obj != null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        int j = super.decrement(obj);
        i = j;
        if (j != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = j;
        if (!(obj instanceof View))
        {
            continue; /* Loop/switch isn't completed */
        }
        logSpinner(((View)obj).getContext(), "stop");
        i = j;
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public int increment(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (obj != null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        if (obj instanceof View)
        {
            logSpinner(((View)obj).getContext(), "start");
        }
        i = super.increment(obj);
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw obj;
    }

    protected void logSpinner(Context context, String s)
    {
        ((Logger)loggerProvider.get(context)).logSpinner("", s, System.currentTimeMillis(), context.getClass().getSimpleName(), Logger.NULL_NST_FIELD);
    }
}
