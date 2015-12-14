// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import com.crashlytics.android.Crashlytics;
import jj;

// Referenced classes of package com.pipcamera.activity:
//            PIPCameraActivity

class a
    implements Runnable
{

    final PIPCameraActivity a;

    public void run()
    {
        try
        {
            jj.a().a(a, a, "847715203438");
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return;
        }
    }

    (PIPCameraActivity pipcameraactivity)
    {
        a = pipcameraactivity;
        super();
    }
}
