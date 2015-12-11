// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.commonsware.cwac.wakeful;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;

// Referenced classes of package com.commonsware.cwac.wakeful:
//            WakefulIntentService

public static interface 
{

    public abstract long getMaxAge();

    public abstract void scheduleAlarms(AlarmManager alarmmanager, PendingIntent pendingintent, Context context);

    public abstract void sendWakefulWork(Context context);
}
