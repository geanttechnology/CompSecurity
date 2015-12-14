// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.content.Intent;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayAlarmManager

class val.intentToFire
    implements com.amazon.gallery.foundation.metrics.amazoninsights.aunchLoadedListener
{

    final ThisDayAlarmManager this$0;
    final armType val$alarmType;
    final Intent val$intentToFire;

    public void onLaunchLoaded(boolean flag)
    {
        if (flag)
        {
            ThisDayAlarmManager.access$000(ThisDayAlarmManager.this, val$alarmType, val$intentToFire);
            return;
        } else
        {
            GLogger.i(ThisDayAlarmManager.access$100(), "Not setting This Day notification alarm", new Object[0]);
            return;
        }
    }

    armType()
    {
        this$0 = final_thisdayalarmmanager;
        val$alarmType = armtype;
        val$intentToFire = Intent.this;
        super();
    }
}
