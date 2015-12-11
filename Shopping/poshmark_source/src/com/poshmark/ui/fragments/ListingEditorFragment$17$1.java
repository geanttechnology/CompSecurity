// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.view.View;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorFragment

class this._cls1
    implements android.content.ener
{

    final is._cls0 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            ListingEditorFragment.access$600(_fld0);
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/ListingEditorFragment$17

/* anonymous class */
    class ListingEditorFragment._cls17
        implements android.view.View.OnClickListener
    {

        final ListingEditorFragment this$0;

        public void onClick(View view)
        {
            showConfirmationMessage(getString(0x7f0600b8), getString(0x7f0600b9), new ListingEditorFragment._cls17._cls1());
        }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
    }

}
