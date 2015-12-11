// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.request;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.arellomobile.android.push.request:
//            PushRequest

public class AppRemovedRequest extends PushRequest
{

    private String packageName;

    public AppRemovedRequest(String s)
    {
        packageName = s;
    }

    public void buildParams(Context context, Map map)
    {
        map.put("android_package", packageName);
    }

    public String getMethod()
    {
        return "androidPackageRemoved";
    }
}
