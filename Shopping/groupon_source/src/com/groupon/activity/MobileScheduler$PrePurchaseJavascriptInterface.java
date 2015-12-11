// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.SchedulerReservationDetails;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            MobileScheduler

private class <init>
{

    final MobileScheduler this$0;

    public void getData(String s)
    {
        android.content.Intent intent;
        s = (SchedulerReservationDetails)MobileScheduler.access$1400(MobileScheduler.this).readValue(s, com/groupon/models/SchedulerReservationDetails);
        reservationId = ((SchedulerReservationDetails) (s)).id;
        intent = MobileScheduler.access$1100(MobileScheduler.this);
        if (intent != null)
        {
            try
            {
                MobileScheduler.access$1500(MobileScheduler.this, intent, s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Ln.e(s, "Impossible to read reservation details.", new Object[0]);
            }
        }
        startActivity(MobileScheduler.access$1200(MobileScheduler.this));
        return;
    }

    private I()
    {
        this$0 = MobileScheduler.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
