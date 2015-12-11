// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.View;
import android.widget.ToggleButton;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItPhotoCaptureView, ViewItActivity, CameraBgHelper

class this._cls0
    implements android.view.hotoCaptureView._cls2
{

    final ViewItPhotoCaptureView this$0;

    public void onClick(View view)
    {
        view = ViewItPhotoCaptureView.access$200(ViewItPhotoCaptureView.this);
        boolean flag;
        if (!ViewItPhotoCaptureView.access$200(ViewItPhotoCaptureView.this).isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setChecked(flag);
        ViewItPhotoCaptureView.access$100(ViewItPhotoCaptureView.this).getCameraBgHelper().switchCameraFlashMode();
    }

    ()
    {
        this$0 = ViewItPhotoCaptureView.this;
        super();
    }
}
