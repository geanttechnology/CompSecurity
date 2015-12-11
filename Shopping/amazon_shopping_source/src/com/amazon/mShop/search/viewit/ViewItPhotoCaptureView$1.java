// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.View;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItPhotoCaptureView, ViewItDialogHelper, ViewItActivity, CameraBgHelper

class this._cls0
    implements android.view.hotoCaptureView._cls1
{

    final ViewItPhotoCaptureView this$0;

    public void onClick(View view)
    {
        if (ViewItPhotoCaptureView.access$000(ViewItPhotoCaptureView.this).isPauseDialogShowing())
        {
            ViewItPhotoCaptureView.access$000(ViewItPhotoCaptureView.this).clearErrorWindow();
            return;
        } else
        {
            ViewItPhotoCaptureView.access$100(ViewItPhotoCaptureView.this).getCameraBgHelper().focusOnClick();
            return;
        }
    }

    ()
    {
        this$0 = ViewItPhotoCaptureView.this;
        super();
    }
}
