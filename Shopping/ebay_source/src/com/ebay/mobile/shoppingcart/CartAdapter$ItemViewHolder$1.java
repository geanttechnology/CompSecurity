// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.ebay.mobile.ui_stuff.Util;

// Referenced classes of package com.ebay.mobile.shoppingcart:
//            CartAdapter

class this._cls0 extends CountDownTimer
{

    final this._cls0 this$0;

    public void onFinish()
    {
        cess._mth100(this._cls0.this, 0x7f070a82, 0x7f0d00e3, null);
    }

    public void onTick(long l)
    {
        String s = Util.formatDayHourMinSec(tle.getContext(), l);
        cess._mth100(this._cls0.this, 0x7f070a83, 0x7f0d00ee, s);
    }

    (long l, long l1)
    {
        this$0 = this._cls0.this;
        super(l, l1);
    }
}
