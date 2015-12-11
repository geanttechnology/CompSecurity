// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.widget.TextView;
import com.groupon.util.Function1;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.view:
//            DrivingDirectionsView

protected class this._cls0
    implements Function1
{

    final DrivingDirectionsView this$0;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((String)obj);
    }

    public void execute(String s)
    {
        Ln.d("DETAILS: getDirections: drivingResult = %s", new Object[] {
            s
        });
        DrivingDirectionsView.access$100(DrivingDirectionsView.this).setVisibility(8);
        setDrivingTime(s);
    }

    protected ()
    {
        this$0 = DrivingDirectionsView.this;
        super();
    }
}
