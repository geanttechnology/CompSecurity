// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.httpCore;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.poshmark.http.httpCore:
//            PMHttpExecutor

class this._cls0 extends Handler
{

    final PMHttpExecutor this$0;

    public void handleMessage(Message message)
    {
        PMHttpExecutor.access$200(PMHttpExecutor.this, message);
    }

    ()
    {
        this$0 = PMHttpExecutor.this;
        super();
    }
}
