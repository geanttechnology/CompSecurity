// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import com.adobe.mediacore.system.NetworkConfiguration;
import com.comcast.playerplatform.util.android.MoneyTrace;
import java.util.HashMap;
import java.util.Random;

public class AdobeMoneyTrace extends NetworkConfiguration
{

    HashMap customHeaders;
    MoneyTrace moneyTrace;
    Random random;

    public AdobeMoneyTrace(MoneyTrace moneytrace)
    {
        random = new Random();
        customHeaders = new HashMap();
        if (moneytrace != null)
        {
            moneyTrace = moneytrace;
            String as[] = new String[3];
            as[0] = moneytrace.getTraceId();
            customHeaders.put(moneytrace.getHttpHeader(), as);
            addCustomHeader(moneytrace.getHttpHeader(), as);
        }
    }

    public HashMap getCustomHeaders()
    {
        if (moneyTrace != null)
        {
            String as[] = (String[])customHeaders.get(moneyTrace.getHttpHeader());
            long l1 = random.nextLong();
            long l = l1;
            if (l1 < 0L)
            {
                l = -l1;
            }
            as[1] = String.valueOf(l);
            as[2] = as[1];
        }
        return customHeaders;
    }
}
