// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal.utils;

import com.google.b.t;
import com.pointinside.analytics.BaseAnalyticsData;
import com.pointinside.internal.LongSerializer;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.pointinside.internal.utils:
//            IOUtils

public static class data
{

    public List data;

    public String getJSONString()
    {
        return IOUtils.serializeToJSONString(this, new t[] {
            new LongSerializer()
        });
    }

    public transient (BaseAnalyticsData abaseanalyticsdata[])
    {
        data = Arrays.asList(abaseanalyticsdata);
    }
}
