// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.google.tagmanager:
//            ServiceManagerImpl

class this._cls0
    implements android.os.agerImpl._cls2
{

    final ServiceManagerImpl this$0;

    public boolean handleMessage(Message message)
    {
        if (1 == message.what && ServiceManagerImpl.access$100().equals(message.obj))
        {
            dispatch();
            if (ServiceManagerImpl.access$200(ServiceManagerImpl.this) > 0 && !ServiceManagerImpl.access$300(ServiceManagerImpl.this))
            {
                ServiceManagerImpl.access$400(ServiceManagerImpl.this).sendMessageDelayed(ServiceManagerImpl.access$400(ServiceManagerImpl.this).obtainMessage(1, ServiceManagerImpl.access$100()), ServiceManagerImpl.access$200(ServiceManagerImpl.this) * 1000);
            }
        }
        return true;
    }

    ()
    {
        this$0 = ServiceManagerImpl.this;
        super();
    }
}
