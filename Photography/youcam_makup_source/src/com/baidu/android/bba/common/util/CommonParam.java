// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.bba.common.util;

import android.content.Context;
import android.text.TextUtils;

// Referenced classes of package com.baidu.android.bba.common.util:
//            DeviceId

public class CommonParam
{

    private static final boolean DEBUG = false;
    private static final String TAG = com/baidu/android/bba/common/util/CommonParam.getSimpleName();

    public CommonParam()
    {
    }

    public static String getCUID(Context context)
    {
        String s1 = getDeviceId(context);
        String s = DeviceId.getIMEI(context);
        context = s;
        if (TextUtils.isEmpty(s))
        {
            context = "0";
        }
        context = (new StringBuffer(context)).reverse().toString();
        return (new StringBuilder()).append(s1).append("|").append(context).toString();
    }

    private static String getDeviceId(Context context)
    {
        return DeviceId.getDeviceID(context);
    }

}
