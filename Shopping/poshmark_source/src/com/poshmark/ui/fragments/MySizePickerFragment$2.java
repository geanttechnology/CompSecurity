// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            MySizePickerFragment, MySizeFragment

class this._cls0
    implements android.view.erFragment._cls2
{

    final MySizePickerFragment this$0;

    public void onClick(View view)
    {
        ((PMActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/MySizeFragment, null);
    }

    ()
    {
        this$0 = MySizePickerFragment.this;
        super();
    }
}
