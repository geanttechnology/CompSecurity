// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.dialog;

import android.content.DialogInterface;

// Referenced classes of package com.amazon.gallery.framework.gallery.dialog:
//            DialogManager

class this._cls0
    implements android.content.OnClickListener
{

    final DialogManager this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        activeDialog = null;
    }

    A()
    {
        this$0 = DialogManager.this;
        super();
    }
}
