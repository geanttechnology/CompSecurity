// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.app.AlarmManager;
import android.content.Context;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            PendingIntentWrapper

public class AlarmManagerWrapper
{

    private final Context mContext;
    private final AlarmManager mInner;

    public AlarmManagerWrapper()
    {
        mInner = null;
        mContext = null;
    }

    public AlarmManagerWrapper(Context context)
    {
        mInner = (AlarmManager)context.getSystemService("alarm");
        mContext = context;
    }

    public void cancel(PendingIntentWrapper pendingintentwrapper)
    {
        AlarmManager alarmmanager = mInner;
        if (pendingintentwrapper != null)
        {
            pendingintentwrapper = pendingintentwrapper.pendingIntent;
        } else
        {
            pendingintentwrapper = null;
        }
        alarmmanager.cancel(pendingintentwrapper);
    }

    public void set$6d261ae(long l, PendingIntentWrapper pendingintentwrapper)
    {
        AlarmManager alarmmanager = mInner;
        if (pendingintentwrapper != null)
        {
            pendingintentwrapper = pendingintentwrapper.pendingIntent;
        } else
        {
            pendingintentwrapper = null;
        }
        alarmmanager.set(1, l, pendingintentwrapper);
    }
}
