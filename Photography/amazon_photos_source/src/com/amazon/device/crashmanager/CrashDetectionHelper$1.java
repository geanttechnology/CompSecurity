// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import android.util.Log;

// Referenced classes of package com.amazon.device.crashmanager:
//            CrashDetectionHelper

class this._cls0
    implements Runnable
{

    final CrashDetectionHelper this$0;

    public void run()
    {
        try
        {
            uploadCrashReport();
            return;
        }
        catch (Exception exception)
        {
            Log.e(CrashDetectionHelper.access$000(), "Failed to upload crash.", exception);
        }
    }

    ()
    {
        this$0 = CrashDetectionHelper.this;
        super();
    }
}
