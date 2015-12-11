// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.ui.customviews.PMEditListingImageSelectorView;
import com.poshmark.utils.RemoveEditListingImageListener;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorFragment

class this._cls0
    implements RemoveEditListingImageListener
{

    final ListingEditorFragment this$0;

    public void onDeleteButtonClick(PMEditListingImageSelectorView pmeditlistingimageselectorview)
    {
        pmeditlistingimageselectorview.resetImageView();
        int i = ((Integer)pmeditlistingimageselectorview.getTag()).intValue();
        imageList.remove(i);
        ListingEditorFragment.access$400(ListingEditorFragment.this);
    }

    torView()
    {
        this$0 = ListingEditorFragment.this;
        super();
    }
}
