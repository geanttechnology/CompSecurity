// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.clickstream;

import com.amazon.client.metrics.DataPoint;
import com.amazon.client.metrics.DataPointType;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

// Referenced classes of package com.amazon.client.metrics.clickstream:
//            ClickStreamInfo

public class ClickStreamHelper
{

    public static void addDatapoint(List list, String s, String s1)
    {
        if (s1 == null || s1.isEmpty())
        {
            return;
        } else
        {
            list.add(new DataPoint(s, s1, 1, DataPointType.CK));
            return;
        }
    }

    public static void addDatapointsToList(List list, ClickStreamInfo clickstreaminfo)
    {
        if (clickstreaminfo != null)
        {
            clickstreaminfo = clickstreaminfo.getDataPoints().iterator();
            while (clickstreaminfo.hasNext()) 
            {
                list.add((DataPoint)clickstreaminfo.next());
            }
        }
    }

    public static String generateRequestId()
    {
        String s = UUID.randomUUID().toString().replace("-", "");
        Random random = new Random();
        random.setSeed((new Date()).getTime());
        int i = random.nextInt(s.length() - 20);
        return s.subSequence(i, i + 20).toString().toUpperCase();
    }
}
