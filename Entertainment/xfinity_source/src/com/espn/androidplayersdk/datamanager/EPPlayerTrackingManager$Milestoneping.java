// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.utilities.Utils;
import java.util.TimerTask;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPPlayerTrackingManager

private class <init> extends TimerTask
{

    final EPPlayerTrackingManager this$0;

    public void run()
    {
        try
        {
            EPPlayerTrackingManager.access$13(EPPlayerTrackingManager.this);
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Unable to send tracking ping", 2, exception);
        }
    }

    private Q()
    {
        this$0 = EPPlayerTrackingManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
