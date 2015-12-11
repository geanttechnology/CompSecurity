// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.xfinity.playerlib.view.common:
//            UpsellDialog

class this._cls0
    implements android.content..OnClickListener
{

    final UpsellDialog this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.intent.action.VIEW", UpsellDialog.access$000(UpsellDialog.this));
        getActivity().startActivity(dialoginterface);
    }

    ()
    {
        this$0 = UpsellDialog.this;
        super();
    }
}
