// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import com.groupon.models.drivingdirection.DrivingDirections;
import com.groupon.models.drivingdirection.DrivingDirectionsLeg;
import com.groupon.models.drivingdirection.DrivingDirectionsRoute;
import com.groupon.models.drivingdirection.DrivingDirectionsTextValue;
import com.groupon.util.Function1;
import java.util.List;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.view:
//            DrivingDirectionsView

protected class callback
    implements Function1
{

    protected final Function1 callback;
    final DrivingDirectionsView this$0;

    public void execute(DrivingDirections drivingdirections)
    {
        if (drivingdirections == null)
        {
            Ln.d("DETAILS: null directions", new Object[0]);
            callback.execute(null);
            return;
        }
        Ln.d("DETAILS: status = %s", new Object[] {
            drivingdirections.status
        });
        if (!drivingdirections.status.equals("OK"))
        {
            callback.execute(null);
            return;
        }
        drivingdirections = drivingdirections.routes;
        int i;
        if (drivingdirections != null)
        {
            i = drivingdirections.size();
        } else
        {
            i = 0;
        }
        Ln.d("DETAILS: routes = %s, count=%s", new Object[] {
            drivingdirections, Integer.valueOf(i)
        });
        if (drivingdirections == null || drivingdirections.isEmpty())
        {
            callback.execute(null);
            return;
        }
        drivingdirections = ((DrivingDirectionsRoute)drivingdirections.get(0)).legs;
        if (drivingdirections != null)
        {
            i = drivingdirections.size();
        } else
        {
            i = 0;
        }
        Ln.d("DETAILS: legs = %s, count=%s", new Object[] {
            drivingdirections, Integer.valueOf(i)
        });
        if (drivingdirections == null || drivingdirections.isEmpty())
        {
            callback.execute(null);
            return;
        }
        drivingdirections = ((DrivingDirectionsLeg)drivingdirections.get(0)).duration;
        Ln.d("DETAILS: duration = %s", new Object[] {
            drivingdirections
        });
        if (drivingdirections == null)
        {
            callback.execute(null);
            return;
        }
        int j = (int)((double)((DrivingDirectionsTextValue) (drivingdirections)).value / 60D + 0.5D);
        i = j / 60;
        j %= 60;
        drivingdirections = new StringBuilder();
        if (i > 0)
        {
            drivingdirections.append(i).append(" ").append(getContext().getString(0x7f08022a)).append(" ");
        }
        if (j > 0)
        {
            drivingdirections.append(j).append(" ").append(getContext().getString(0x7f08047b));
        }
        callback.execute(drivingdirections.toString());
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((DrivingDirections)obj);
    }

    public (Function1 function1)
    {
        this$0 = DrivingDirectionsView.this;
        super();
        callback = function1;
    }
}
