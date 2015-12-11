// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.app;

import android.content.DialogInterface;

// Referenced classes of package com.ebay.app:
//            AlertDialogFragment

class this._cls0
    implements android.content.iChoiceClickListener
{

    final AlertDialogFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i, boolean flag)
    {
        elds.access._mth700(AlertDialogFragment.access$800(AlertDialogFragment.this))[i] = flag;
    }

    elds()
    {
        this$0 = AlertDialogFragment.this;
        super();
    }
}
