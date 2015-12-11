// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.utils.ListingManager;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorShareFragment

class this._cls0
    implements android.view.eFragment._cls11
{

    final ListingEditorShareFragment this$0;

    public void onClick(View view)
    {
        if (ListingEditorShareFragment.access$000(ListingEditorShareFragment.this) != null)
        {
            ListingEditorShareFragment.access$000(ListingEditorShareFragment.this).postListing(ListingEditorShareFragment.this);
        }
    }

    ()
    {
        this$0 = ListingEditorShareFragment.this;
        super();
    }
}
