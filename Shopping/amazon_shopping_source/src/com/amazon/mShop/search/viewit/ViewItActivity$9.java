// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;


// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, ViewItPhotoCaptureView, ViewItDialogHelper

class r.DialogType
    implements Runnable
{

    final ViewItActivity this$0;
    final r.DialogType val$errorDialogType;
    final String val$errorMsg;

    public void run()
    {
        ViewItActivity.access$000(ViewItActivity.this).getViewItDialogHelper().showDialog(null, val$errorMsg, val$errorDialogType);
    }

    r.DialogType()
    {
        this$0 = final_viewitactivity;
        val$errorMsg = s;
        val$errorDialogType = r.DialogType.this;
        super();
    }
}
