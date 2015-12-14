// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.widget.ListView;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            IAPDialogList

class this._cls0
    implements Runnable
{

    final IAPDialogList this$0;

    public void run()
    {
        if (IAPDialogList.access$200(IAPDialogList.this) != null)
        {
            IAPDialogList.access$200(IAPDialogList.this).clearFocus();
            IAPDialogList.access$200(IAPDialogList.this).clearChoices();
            IAPDialogList.access$200(IAPDialogList.this).invalidateViews();
        }
    }

    ()
    {
        this$0 = IAPDialogList.this;
        super();
    }
}
