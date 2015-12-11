// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.resultheader;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;
import com.amazon.retailsearch.popup.PopupDialogFragment;
import com.amazon.retailsearch.popup.PopupDialogFragmentV4;

// Referenced classes of package com.amazon.retailsearch.android.ui.resultheader:
//            ResultsInfoBar

class this._cls0
    implements android.view.ner
{

    final ResultsInfoBar this$0;

    public void onClick(View view)
    {
        if (!(ResultsInfoBar.access$100(ResultsInfoBar.this).getContext() instanceof FragmentActivity)) goto _L2; else goto _L1
_L1:
        FragmentManager fragmentmanager;
        view = (FragmentActivity)ResultsInfoBar.access$100(ResultsInfoBar.this).getContext();
        fragmentmanager = view.getSupportFragmentManager();
        if (fragmentmanager == null || fragmentmanager.findFragmentByTag("popup_dialog_fragment") == null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        ResultsInfoBar.access$200(ResultsInfoBar.this, view, new PopupDialogFragmentV4());
        return;
_L2:
        view = (Activity)ResultsInfoBar.access$100(ResultsInfoBar.this).getContext();
        android.app.FragmentManager fragmentmanager1 = view.getFragmentManager();
        if (fragmentmanager1 == null || fragmentmanager1.findFragmentByTag("popup_dialog_fragment") == null)
        {
            ResultsInfoBar.access$300(ResultsInfoBar.this, view, new PopupDialogFragment());
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    ()
    {
        this$0 = ResultsInfoBar.this;
        super();
    }
}
