// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.request;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.arellomobile.android.push.request:
//            PushRequest

public class ApplicationEventRequest extends PushRequest
{

    private Integer count;
    private String goal;

    public ApplicationEventRequest(String s, Integer integer)
    {
        goal = s;
        count = integer;
    }

    protected void buildParams(Context context, Map map)
    {
        map.put("goal", goal);
        if (count != null)
        {
            map.put("count", count);
        }
    }

    public String getMethod()
    {
        return "applicationEvent";
    }
}
