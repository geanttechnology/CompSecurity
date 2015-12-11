// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.view.View;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.ListingDraft;

// Referenced classes of package com.ebay.mobile.sell:
//            ReviewDialogFragment, PreviewListingActivity

class this._cls0
    implements android.view.gment._cls3
{

    final ReviewDialogFragment this$0;

    public void onClick(View view)
    {
        if (MyApp.getPrefs().getUserIsPpa())
        {
            getActivity().showDialog(0x7f0707aa);
            return;
        } else
        {
            view = (new StringBuilder()).append("http://previewitem.").append(EbaySite.getInstanceFromId(ReviewDialogFragment.access$100(ReviewDialogFragment.this).siteId).getDomain()).append("/").append("ws/eBayISAPI.dll?PreviewItemV4&md=1&noPreviewHeader=1&SessionId=").append(ReviewDialogFragment.access$100(ReviewDialogFragment.this).id).toString();
            PreviewListingActivity.start(getActivity(), view, getString(0x7f0707b0));
            return;
        }
    }

    ()
    {
        this$0 = ReviewDialogFragment.this;
        super();
    }
}
