// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.device.framework.MAPInitTasks;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPInit

class this._cls0
    implements Runnable
{

    final MAPInit this$0;

    public void run()
    {
        (new MAPInitTasks(MAPInit.access$100(MAPInit.this))).performInitOperations();
    }

    nitTasks()
    {
        this$0 = MAPInit.this;
        super();
    }
}
