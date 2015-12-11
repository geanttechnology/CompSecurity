// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.poshmark.utils.PMSearchViewListener;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMCustomSearchWidget

class this._cls0
    implements TextWatcher
{

    final PMCustomSearchWidget this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (charsequence.length() > 0)
        {
            clearButton.setVisibility(0);
        } else
        {
            clearButton.setVisibility(4);
            if ((charsequence == null || charsequence.length() == 0) && parentListener != null)
            {
                parentListener.clearSearchString();
                return;
            }
        }
    }

    ()
    {
        this$0 = PMCustomSearchWidget.this;
        super();
    }
}
