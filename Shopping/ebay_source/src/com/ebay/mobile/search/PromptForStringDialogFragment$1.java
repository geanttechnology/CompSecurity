// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import com.ebay.mobile.ui_stuff.Util;

// Referenced classes of package com.ebay.mobile.search:
//            PromptForStringDialogFragment

class this._cls0
    implements android.content.ment._cls1
{

    final PromptForStringDialogFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        Object obj = PromptForStringDialogFragment.access$000(PromptForStringDialogFragment.this).getText();
        omptForStringCompletedListener omptforstringcompletedlistener;
        if (obj != null)
        {
            obj = ((CharSequence) (obj)).toString();
        } else
        {
            obj = "";
        }
        omptforstringcompletedlistener = PromptForStringDialogFragment.access$100(PromptForStringDialogFragment.this);
        if (omptforstringcompletedlistener != null)
        {
            Bundle bundle = getArguments();
            omptforstringcompletedlistener.onPromptForStringCompleted(((String) (obj)), false, bundle.getString("reason"), bundle.getBundle("extras"));
        }
        Util.hideSoftInput(getActivity(), PromptForStringDialogFragment.access$000(PromptForStringDialogFragment.this));
        dialoginterface.dismiss();
    }

    omptForStringCompletedListener()
    {
        this$0 = PromptForStringDialogFragment.this;
        super();
    }
}
