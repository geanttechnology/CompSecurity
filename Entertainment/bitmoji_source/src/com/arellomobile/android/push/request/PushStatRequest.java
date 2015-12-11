// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.request;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.arellomobile.android.push.request:
//            PushRequest

public class PushStatRequest extends PushRequest
{

    private String hash;

    public PushStatRequest(String s)
    {
        hash = s;
    }

    protected void buildParams(Context context, Map map)
    {
        if (hash != null)
        {
            map.put("hash", hash);
        }
    }

    public String getMethod()
    {
        return "pushStat";
    }
}
