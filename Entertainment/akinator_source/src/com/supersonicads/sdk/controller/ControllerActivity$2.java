// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.view.Window;

// Referenced classes of package com.supersonicads.sdk.controller:
//            ControllerActivity

class this._cls0
    implements Runnable
{

    final ControllerActivity this$0;

    public void run()
    {
        getWindow().clearFlags(128);
    }

    ()
    {
        this$0 = ControllerActivity.this;
        super();
    }
}
