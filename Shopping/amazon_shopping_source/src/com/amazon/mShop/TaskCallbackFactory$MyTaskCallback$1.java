// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.DialogInterface;
import com.amazon.mShop.control.Cancellable;

// Referenced classes of package com.amazon.mShop:
//            TaskCallbackFactory, AmazonActivity

class this._cls1
    implements android.content.
{

    final this._cls1 this$1;

    public void onCancel(DialogInterface dialoginterface)
    {
label0:
        {
            if (cess._mth300(this._cls1.this) != null)
            {
                cess._mth300(this._cls1.this).cancel();
            }
            if (cess._mth400(this._cls1.this) != null)
            {
                if (!cess._mth500(this._cls1.this))
                {
                    break label0;
                }
                cess._mth400(this._cls1.this).finish();
            }
            return;
        }
        cess._mth400(this._cls1.this).popView();
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
