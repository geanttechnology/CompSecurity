// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.content.DialogInterface;

// Referenced classes of package com.ebay.mobile:
//            ErrorDialogFragment

private final class <init>
    implements android.content.er
{

    final ErrorDialogFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = ErrorDialogFragment.this;
        boolean flag;
        if (i == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dialoginterface.dismissMessage(flag);
    }

    private er()
    {
        this$0 = ErrorDialogFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
