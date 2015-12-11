// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.creditcardreaderlibrary.helpers;

import android.content.Context;
import com.a9.creditcardreaderlibrary.utils.PreferenceUtil;

public class MetricsHelper
{

    public MetricsHelper()
    {
    }

    public static String getServiceName(Context context)
    {
        return PreferenceUtil.getPreference(context, "SERVICE_NAME");
    }
}
