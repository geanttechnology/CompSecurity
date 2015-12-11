// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;


// Referenced classes of package com.poshmark.ui.customviews:
//            PMProgressDialog

class this._cls1
    implements Runnable
{

    final smissListener.dialogDismissed this$1;

    public void run()
    {
        bAutoHide = false;
        dismiss();
        if (dismissListener != null)
        {
            dismissListener.dialogDismissed();
            dismissListener = null;
        }
    }

    smissListener()
    {
        this$1 = this._cls1.this;
        super();
    }
}
