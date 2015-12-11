// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.view.View;
import com.poshmark.utils.RemoveEditListingImageListener;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMEditListingImageSelectorView

class this._cls0
    implements android.view.SelectorView._cls1
{

    final PMEditListingImageSelectorView this$0;

    public void onClick(View view)
    {
        if (PMEditListingImageSelectorView.access$000(PMEditListingImageSelectorView.this) != null)
        {
            PMEditListingImageSelectorView.access$000(PMEditListingImageSelectorView.this).onDeleteButtonClick((PMEditListingImageSelectorView)view.getParent());
        }
    }

    ()
    {
        this$0 = PMEditListingImageSelectorView.this;
        super();
    }
}
