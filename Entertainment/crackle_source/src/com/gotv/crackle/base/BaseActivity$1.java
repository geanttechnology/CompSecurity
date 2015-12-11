// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.base;

import android.content.DialogInterface;

// Referenced classes of package com.gotv.crackle.base:
//            BaseActivity

class this._cls0
    implements android.content..OnClickListener
{

    final BaseActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        exitApp();
    }

    ckListener()
    {
        this$0 = BaseActivity.this;
        super();
    }
}
