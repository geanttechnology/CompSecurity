// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.utils.view_holders.PinterestDialog;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorShareFragment

class val.dialog
    implements android.view.reFragment._cls1
{

    final ListingEditorShareFragment this$0;
    final PinterestDialog val$dialog;

    public void onClick(View view)
    {
        val$dialog.dismiss();
    }

    ()
    {
        this$0 = final_listingeditorsharefragment;
        val$dialog = PinterestDialog.this;
        super();
    }
}
