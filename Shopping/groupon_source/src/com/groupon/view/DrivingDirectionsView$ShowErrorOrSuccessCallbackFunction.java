// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import com.groupon.util.Function0;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.view:
//            DrivingDirectionsView

protected class callback
    implements Function0
{

    protected final Function1 callback;
    final DrivingDirectionsView this$0;

    public void execute()
    {
        if (DrivingDirectionsView.access$006(DrivingDirectionsView.this) <= 0)
        {
            showProgress(false);
            if (callback != null)
            {
                boolean flag = hasDirections();
                if (!flag)
                {
                    showError();
                }
                callback.execute(Boolean.valueOf(flag));
                return;
            }
        }
    }

    public (Function1 function1)
    {
        this$0 = DrivingDirectionsView.this;
        super();
        callback = function1;
    }
}
