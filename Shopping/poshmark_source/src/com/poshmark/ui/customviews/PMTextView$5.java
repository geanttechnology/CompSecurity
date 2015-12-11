// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.os.Bundle;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.ListingDetailsFragment;
import com.poshmark.utils.TextClickListener;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMTextView

class this._cls0
    implements TextClickListener
{

    final PMTextView this$0;

    public void onClick(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("ID", s);
        ((PMActivity)getContext()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ListingDetailsFragment, null);
    }

    ragment()
    {
        this$0 = PMTextView.this;
        super();
    }
}
