// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui;

import android.os.Bundle;
import com.poshmark.ui.customviews.PMTabButton;
import com.poshmark.ui.fragments.ListingEditorFragment;

// Referenced classes of package com.poshmark.ui:
//            MainActivity

class this._cls0
    implements com.poshmark.ui.customviews.istener
{

    final MainActivity this$0;

    public void onTabSelected(PMTabButton pmtabbutton)
    {
        pmtabbutton = new Bundle();
        pmtabbutton.putBoolean("NEW_LISTING", true);
        launchFragment(pmtabbutton, com/poshmark/ui/fragments/ListingEditorFragment, null);
    }

    public void onTabUnselected(PMTabButton pmtabbutton)
    {
    }

    abButton()
    {
        this$0 = MainActivity.this;
        super();
    }
}
