// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorFragment

class this._cls0
    implements android.content.istener
{

    final ListingEditorFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        finishActivity();
    }

    ()
    {
        this$0 = ListingEditorFragment.this;
        super();
    }
}
