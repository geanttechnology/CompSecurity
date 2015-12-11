// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.record.android.activity;

import android.app.Activity;
import com.amazon.mcc.record.android.DeviceContext;
import java.util.HashMap;

public class ActivityContext extends DeviceContext
{

    public ActivityContext(Activity activity)
    {
        super(activity.getClass().getCanonicalName());
        HashMap hashmap = new HashMap();
        hashmap.put("application.name", activity.getApplication().getClass().getCanonicalName());
        hashmap.put("application.instance", Integer.valueOf(activity.getApplication().hashCode()));
        hashmap.put("activity.className", activity.getClass().getName());
        hashmap.put("activity.instance", Integer.valueOf(activity.hashCode()));
        addProperties(hashmap);
    }
}
