// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;


// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, ViewItPhotoCaptureView, ViewItDialogHelper

class this._cls0
    implements Runnable
{

    final ViewItActivity this$0;

    public void run()
    {
        ViewItActivity.access$000(ViewItActivity.this).getViewItDialogHelper().showDialog(null, null, r.DialogType.ERROR_NO_OBJECT_FOUND);
    }

    r()
    {
        this$0 = ViewItActivity.this;
        super();
    }
}
