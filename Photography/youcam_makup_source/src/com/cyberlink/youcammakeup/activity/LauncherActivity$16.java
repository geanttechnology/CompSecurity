// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

final class  extends Handler
{

    public void handleMessage(Message message)
    {
        m.b("Kochava", message.getData().getString("attributionData"));
    }

    ()
    {
    }
}
