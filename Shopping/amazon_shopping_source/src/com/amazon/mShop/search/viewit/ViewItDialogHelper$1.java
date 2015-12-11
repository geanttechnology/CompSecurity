// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItDialogHelper, ViewItActivity

class this._cls0 extends Handler
{

    final ViewItDialogHelper this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            if (isStillNoObjectFoundDialogShowing())
            {
                ViewItDialogHelper.access$200(ViewItDialogHelper.this).setVisibility(8);
                return;
            } else
            {
                ViewItDialogHelper.access$300(ViewItDialogHelper.this);
                return;
            }

        case 3: // '\003'
            clearErrorWindow();
            ViewItDialogHelper.access$000(ViewItDialogHelper.this).finish();
            return;

        case 4: // '\004'
            ViewItDialogHelper.access$100(ViewItDialogHelper.this);
            return;

        case 5: // '\005'
            ViewItDialogHelper.access$000(ViewItDialogHelper.this).stopScanning();
            return;
        }
    }

    _cls9()
    {
        this$0 = ViewItDialogHelper.this;
        super();
    }
}
