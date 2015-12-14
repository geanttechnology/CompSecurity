// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.delivery;

import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.configuration.Configuration;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.delivery.policy.DeliveryPolicy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.insights.delivery:
//            DefaultDeliveryClient, EventStore

class val.submitWaitLatch
    implements Runnable
{

    final DefaultDeliveryClient this$0;
    final List val$policies;
    final CountDownLatch val$submitWaitLatch;

    public void run()
    {
        long l3 = System.currentTimeMillis();
        for (Iterator iterator = val$policies.iterator(); iterator.hasNext();)
        {
            if (!((DeliveryPolicy)iterator.next()).isAllowed())
            {
                return;
            }
        }

        JSONArray jsonarray;
        JSONException jsonexception;
        JSONArray jsonarray1;
         ;
        int i;
        int j;
        int k;
        long l;
        long l1;
        long l2;
        long l4;
        boolean flag;
        boolean flag1;
        try
        {
            val$submitWaitLatch.await(DefaultDeliveryClient.access$400(DefaultDeliveryClient.this), TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException interruptedexception) { }
        flag = true;
        l4 = DefaultDeliveryClient.access$500(DefaultDeliveryClient.this).getConfiguration().optLong("maxSubmissionSize", Long.valueOf(0x19000L)).longValue();
        jsonarray = new JSONArray();
         = DefaultDeliveryClient.access$100(DefaultDeliveryClient.this).iterator();
        l = 0L;
        i = 0;
        k = DefaultDeliveryClient.access$500(DefaultDeliveryClient.this).getConfiguration().optInt("maxSubmissionAllowed", Integer.valueOf(3)).intValue();
        flag1 = flag;
        if (!.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = l;
        j = i;
        flag1 = flag;
        if (.peek() == null) goto _L2; else goto _L1
_L1:
        l1 = l;
        j = i;
        flag1 = flag;
        l2 = .peek().length();
        l1 = l2;
_L4:
        if (l + l1 > l4)
        {
            break; /* Loop/switch isn't completed */
        }
        l += l1;
        l1 = l;
        j = i;
        flag1 = flag;
        try
        {
            jsonarray.put(new JSONObject((String).next()));
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception)
        {
            DefaultDeliveryClient.access$200().e("Could not convert stored event into json", jsonexception);
            l = l1;
            i = j;
            flag = flag1;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        l1 = 0L;
        if (true) goto _L4; else goto _L3
_L3:
        l1 = l;
        j = i;
        flag1 = flag;
        flag = DefaultDeliveryClient.access$600(DefaultDeliveryClient.this, jsonarray, val$policies);
        flag1 = flag;
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i++;
        l1 = l;
        j = i;
        flag1 = flag;
        .removeReadEvents();
        l1 = l;
        j = i;
        flag1 = flag;
        jsonarray1 = new JSONArray();
        l = 0L;
        jsonarray = jsonarray1;
        if (true) goto _L6; else goto _L5
_L6:
        break MISSING_BLOCK_LABEL_148;
_L5:
        if (flag1 && jsonarray.length() > 0 && DefaultDeliveryClient.access$600(DefaultDeliveryClient.this, jsonarray, val$policies))
        {
            .removeReadEvents();
        }
        DefaultDeliveryClient.access$200().v(String.format("Time of attemptDelivery: %d", new Object[] {
            Long.valueOf(System.currentTimeMillis() - l3)
        }));
        return;
    }

    ()
    {
        this$0 = final_defaultdeliveryclient;
        val$policies = list;
        val$submitWaitLatch = CountDownLatch.this;
        super();
    }
}
