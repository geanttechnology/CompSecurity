// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.view.View;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.meta_data.MySizePickerInfo;

// Referenced classes of package com.poshmark.ui.fragments:
//            MySizePickerFragment, MySizeFragment

class this._cls0
    implements android.view.erFragment._cls3
{

    final MySizePickerFragment this$0;

    public void onClick(View view)
    {
        if (!bIsMySizeSet)
        {
            ((PMActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/MySizeFragment, null);
            return;
        }
        mySizeSwitchChanged = true;
        if (info.bIsMySizeEnabled)
        {
            info.bIsMySizeEnabled = false;
            mySizeToggleButton.setTextColor(getResources().getColor(0x7f090035));
            mySizeToggleButton.setTypeface(null, 0);
            mySizeToggleButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            return;
        } else
        {
            info.bIsMySizeEnabled = true;
            mySizeToggleButton.setTextColor(getResources().getColor(0x7f09003c));
            mySizeToggleButton.setTypeface(null, 1);
            mySizeToggleButton.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(0x7f02007e), null);
            return;
        }
    }

    ()
    {
        this$0 = MySizePickerFragment.this;
        super();
    }
}
