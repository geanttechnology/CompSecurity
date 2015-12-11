// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.util.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.comcast.playerplatform.util.android:
//            ConfigurationManager

class this._cls0 extends BroadcastReceiver
{

    final ConfigurationManager this$0;

    public void onReceive(Context context, Intent intent)
    {
        ConfigurationManager.access$202(ConfigurationManager.this, true);
        context.unregisterReceiver(this);
    }

    ()
    {
        this$0 = ConfigurationManager.this;
        super();
    }
}
