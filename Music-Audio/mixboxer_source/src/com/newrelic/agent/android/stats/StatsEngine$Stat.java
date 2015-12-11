// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.stats;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.newrelic.agent.android.stats:
//            StatsEngine

private class <init>
{

    public long callCount;
    public boolean haveTime;
    public float maxTime;
    public float minTime;
    public float sumOfSquares;
    final StatsEngine this$0;
    public float totalTime;

    public JSONObject toJSONObject()
        throws JSONException
    {
        float f1 = 0.0F;
        this;
        JVM INSTR monitorenter ;
        float f;
        Object obj;
        obj = new HashMap();
        ((HashMap) (obj)).put("count", Long.valueOf(callCount));
        ((HashMap) (obj)).put("total", Float.valueOf(totalTime));
        if (!haveTime)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        f = minTime;
_L1:
        ((HashMap) (obj)).put("min", Float.valueOf(f));
        f = f1;
        if (haveTime)
        {
            f = maxTime;
        }
        ((HashMap) (obj)).put("max", Float.valueOf(f));
        ((HashMap) (obj)).put("sum_of_squares", Float.valueOf(sumOfSquares));
        obj = new JSONObject(((java.util.Map) (obj)));
        this;
        JVM INSTR monitorexit ;
        return ((JSONObject) (obj));
        f = 0.0F;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    private ()
    {
        this$0 = StatsEngine.this;
        super();
        callCount = 0L;
        totalTime = 0.0F;
        minTime = 3.402823E+38F;
        maxTime = 1.401298E-45F;
        sumOfSquares = 0.0F;
        haveTime = false;
    }

    haveTime(haveTime havetime)
    {
        this();
    }
}
