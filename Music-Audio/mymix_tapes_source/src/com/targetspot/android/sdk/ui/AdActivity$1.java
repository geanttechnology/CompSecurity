// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.ui;

import android.os.Handler;
import android.os.Message;
import com.targetspot.android.sdk.service.AdBreak;

// Referenced classes of package com.targetspot.android.sdk.ui:
//            AdActivity

class this._cls0 extends Handler
{

    final AdActivity this$0;

    public void handleMessage(Message message)
    {
        if (message.obj instanceof AdBreak)
        {
            onAdShow((AdBreak)message.obj);
        }
    }

    ()
    {
        this$0 = AdActivity.this;
        super();
    }
}
