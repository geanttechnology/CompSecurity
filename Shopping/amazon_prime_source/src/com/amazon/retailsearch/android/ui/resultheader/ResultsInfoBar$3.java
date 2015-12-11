// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.resultheader;

import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.popup.PopupDialogFragment;

// Referenced classes of package com.amazon.retailsearch.android.ui.resultheader:
//            ResultsInfoBar

class val.dialog
    implements smissMenuListener
{

    final ResultsInfoBar this$0;
    final PopupDialogFragment val$dialog;

    public void dismiss()
    {
        try
        {
            val$dialog.dismiss();
            return;
        }
        catch (Exception exception)
        {
            ResultsInfoBar.access$200(ResultsInfoBar.this).error("Could not dismiss dialog", exception);
        }
    }

    smissMenuListener()
    {
        this$0 = final_resultsinfobar;
        val$dialog = PopupDialogFragment.this;
        super();
    }
}
