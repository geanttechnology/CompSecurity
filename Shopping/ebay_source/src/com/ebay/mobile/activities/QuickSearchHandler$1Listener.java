// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.DialogInterface;

// Referenced classes of package com.ebay.mobile.activities:
//            QuickSearchHandler

class this._cls0
    implements android.content.ner, android.content.er
{

    final QuickSearchHandler this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        finish();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }

    ()
    {
        this$0 = QuickSearchHandler.this;
        super();
    }
}
