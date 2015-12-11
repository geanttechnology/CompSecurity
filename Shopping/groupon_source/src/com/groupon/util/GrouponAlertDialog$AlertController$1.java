// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.os.Handler;
import android.os.Message;
import android.view.View;

// Referenced classes of package com.groupon.util:
//            GrouponAlertDialog

class this._cls0
    implements android.view.r._cls1
{

    final this._cls0 this$0;

    public void onClick(View view)
    {
        Object obj = null;
        Message message;
        if (view == cess._mth100(this._cls0.this).positiveButton && cess._mth200(this._cls0.this) != null)
        {
            message = Message.obtain(cess._mth200(this._cls0.this));
        } else
        {
            message = obj;
            if (view == cess._mth100(this._cls0.this).negativeButton)
            {
                message = obj;
                if (cess._mth300(this._cls0.this) != null)
                {
                    message = Message.obtain(cess._mth300(this._cls0.this));
                }
            }
        }
        if (message != null)
        {
            message.sendToTarget();
        }
        if (view == cess._mth100(this._cls0.this).positiveButton && !ertParams.access._mth000(cess._mth100(this._cls0.this)))
        {
            return;
        } else
        {
            cess._mth500(this._cls0.this).obtainMessage(1, cess._mth400(this._cls0.this)).sendToTarget();
            return;
        }
    }

    ertParams()
    {
        this$0 = this._cls0.this;
        super();
    }
}
