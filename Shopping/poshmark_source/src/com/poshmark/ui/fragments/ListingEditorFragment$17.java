// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.view.View;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorFragment

class this._cls0
    implements android.view.rFragment._cls17
{

    final ListingEditorFragment this$0;

    public void onClick(View view)
    {
        showConfirmationMessage(getString(0x7f0600b8), getString(0x7f0600b9), new android.content.DialogInterface.OnClickListener() {

            final ListingEditorFragment._cls17 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (i == -1)
                {
                    ListingEditorFragment.access$600(this$0);
                }
            }

            
            {
                this$1 = ListingEditorFragment._cls17.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = ListingEditorFragment.this;
        super();
    }
}
