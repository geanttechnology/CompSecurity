// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.ui.customviews.PMEditListingImageSelectorView;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorFragment

class this._cls0
    implements android.view.rFragment._cls11
{

    final ListingEditorFragment this$0;

    public void onClick(View view)
    {
label0:
        {
            if (!handlingUserTap)
            {
                handlingUserTap = true;
                hideKeyboard();
                view = (PMEditListingImageSelectorView)view;
                if (view.isNextSelector() || view.isImageSet())
                {
                    break label0;
                }
                handlingUserTap = false;
            }
            return;
        }
        currentActiveImageView = view;
        currentActiveImageIndex = ((Integer)currentActiveImageView.getTag()).intValue();
        ListingEditorFragment.access$100(ListingEditorFragment.this, null);
    }

    torView()
    {
        this$0 = ListingEditorFragment.this;
        super();
    }
}
