// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.view.View;
import com.poshmark.ui.fragments.ListingDetailsFragment;

// Referenced classes of package com.poshmark.data_model.adapters:
//            ListingDetailsAdapter

class this._cls0
    implements android.view.ingDetailsAdapter._cls1
{

    final ListingDetailsAdapter this$0;

    public void onClick(View view)
    {
        parentFragment.replyToComment((String)view.getTag());
    }

    ()
    {
        this$0 = ListingDetailsAdapter.this;
        super();
    }
}
