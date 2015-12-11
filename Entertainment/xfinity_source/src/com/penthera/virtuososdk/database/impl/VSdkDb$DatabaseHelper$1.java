// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.database.impl;

import android.os.Handler;

// Referenced classes of package com.penthera.virtuososdk.database.impl:
//            VSdkDb

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
        if (cess._mth0(this._cls1.this))
        {
            oseDatabase();
            return;
        } else
        {
            cess._mth1(this._cls1.this).postDelayed(cess._mth2(this._cls1.this), 0x927c0L);
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
