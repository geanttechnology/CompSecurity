// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.util;

import android.os.CountDownTimer;
import android.widget.Toast;

// Referenced classes of package com.bitstrips.imoji.util:
//            ToastUtils

static final class val.toast extends CountDownTimer
{

    final Toast val$toast;

    public void onFinish()
    {
        val$toast.show();
    }

    public void onTick(long l)
    {
        val$toast.show();
    }

    (long l, long l1, Toast toast1)
    {
        val$toast = toast1;
        super(l, l1);
    }
}
