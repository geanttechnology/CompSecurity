// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.ContainerLayout;

// Referenced classes of package com.ebay.mobile.sell:
//            ConditionSpokeFragment

private class <init>
    implements TextWatcher
{

    final ConditionSpokeFragment this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        draftDescriptionViewHeight = -1;
        ConditionSpokeFragment.access$102(ConditionSpokeFragment.this, charsequence.length());
        String s = getResources().getString(0x7f0709ab);
        i = 0;
        while (i < conditionList.getChildCount()) 
        {
            TextView textview = (TextView)conditionList.getChildAt(i).findViewById(0x7f100709);
            if (charsequence.length() > 0)
            {
                textview.setVisibility(0);
                textview.setText((new StringBuilder()).append(ConditionSpokeFragment.access$100(ConditionSpokeFragment.this)).append(s).toString());
            } else
            {
                textview.setVisibility(4);
            }
            i++;
        }
    }

    private ()
    {
        this$0 = ConditionSpokeFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
