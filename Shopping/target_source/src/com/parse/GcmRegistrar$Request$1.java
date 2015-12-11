// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.parse:
//            GcmRegistrar

class  extends BroadcastReceiver
{

    final this._cls0 this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (intent != null && intent.getIntExtra("random", 0) == cess._mth300(this._cls0.this))
        {
            cess._mth600(this._cls0.this);
        }
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
