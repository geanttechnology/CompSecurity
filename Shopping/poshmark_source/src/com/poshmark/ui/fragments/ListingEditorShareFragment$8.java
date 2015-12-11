// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.widget.CompoundButton;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.utils.ListingManager;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorShareFragment

class this._cls0
    implements android.widget.eListener
{

    final ListingEditorShareFragment this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        PMApplicationSession.GetPMSession().setTwitterSharingFlag(Boolean.valueOf(flag));
        ListingEditorShareFragment.access$000(ListingEditorShareFragment.this).setTwitterShareFlag(flag);
    }

    ()
    {
        this$0 = ListingEditorShareFragment.this;
        super();
    }
}
