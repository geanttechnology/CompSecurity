// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.DialogInterface;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItDialogHelper

class this._cls0
    implements android.content.celListener
{

    final ViewItDialogHelper this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        ViewItDialogHelper.access$400(ViewItDialogHelper.this);
        clearErrorWindow();
    }

    _cls9()
    {
        this$0 = ViewItDialogHelper.this;
        super();
    }
}
