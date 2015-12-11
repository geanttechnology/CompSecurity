// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.fb_tmblr_twitter.FbHelper;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorShareFragment

class this._cls0
    implements android.view.reFragment._cls3
{

    final ListingEditorShareFragment this$0;

    public void onClick(View view)
    {
        FbHelper.getInstance().link(ListingEditorShareFragment.this, 8, 8, FbHelper.FB_CONNECT_READ_REQUEST);
    }

    ()
    {
        this$0 = ListingEditorShareFragment.this;
        super();
    }
}
