// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

// Referenced classes of package com.pointinside.internal.utils:
//            BuildUtils

public class UserAgentUtils
{

    public UserAgentUtils()
    {
    }

    public static String getUserAgent(Context context)
    {
        return getUserAgent(BuildUtils.getTidyAppName(context), BuildUtils.getAppVersionLabel(context));
    }

    public static String getUserAgent(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s);
        stringbuilder.append('/');
        stringbuilder.append(s1);
        stringbuilder.append("; PIMapsLib/4.2.10");
        stringbuilder.append("; Android/").append(android.os.Build.VERSION.RELEASE);
        if ("REL".equals(android.os.Build.VERSION.CODENAME))
        {
            s = Build.MODEL;
            if (!TextUtils.isEmpty(s))
            {
                stringbuilder.append("; ");
                stringbuilder.append(s);
            }
        }
        s = Build.ID;
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append("/");
            stringbuilder.append(s);
        }
        return stringbuilder.toString();
    }
}
