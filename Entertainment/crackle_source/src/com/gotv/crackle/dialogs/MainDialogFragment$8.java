// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.dialogs;

import android.content.DialogInterface;

// Referenced classes of package com.gotv.crackle.dialogs:
//            MainDialogFragment

class this._cls0
    implements android.content.ckListener
{

    final MainDialogFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (MainDialogFragment.access$000(MainDialogFragment.this) != null)
        {
            MainDialogFragment.access$000(MainDialogFragment.this).onCancel(dialoginterface);
        }
        dialoginterface.dismiss();
    }

    er()
    {
        this$0 = MainDialogFragment.this;
        super();
    }
}
