// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control;

import com.amazon.rio.j2me.client.services.ServiceCall;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control:
//            PagedListingBrowser, ObjectSubscriber

class val.error
    implements Runnable
{

    final PagedListingBrowser this$0;
    final Exception val$error;
    final int val$finishState;
    final ServiceCall val$sc;

    public void run()
    {
        if (val$sc == currentRequest)
        {
            if (PagedListingBrowser.access$000(PagedListingBrowser.this))
            {
                PagedListingBrowser.access$002(PagedListingBrowser.this, false);
                onPrefetchCancelled();
                if (secondarySubscriber != null)
                {
                    secondarySubscriber.onCancelled();
                }
                if (primarySubscriber != null)
                {
                    primarySubscriber.onCancelled();
                }
                listingObjects.clear();
                listingImages.clear();
                listingIndices.clear();
            }
            if (val$finishState == 0)
            {
                lastRequestPageIndex = currentRequestPageIndex;
            }
            currentRequestPageIndex = -1;
            currentRequest = null;
            if (pendingRequestPageIndex >= 0)
            {
                if (val$finishState != 1)
                {
                    currentRequestPageIndex = pendingRequestPageIndex;
                    currentRequest = startPageRequest(currentRequestPageIndex);
                }
                pendingRequestPageIndex = -1;
            }
            if (val$finishState == 1)
            {
                notifyError(val$error, val$sc);
                return;
            }
            if (val$finishState == 0)
            {
                onPrefetchSuccess();
                if (secondarySubscriber != null)
                {
                    secondarySubscriber.onPageComplete();
                }
                if (primarySubscriber != null)
                {
                    primarySubscriber.onPageComplete();
                    return;
                }
            }
        }
    }

    ()
    {
        this$0 = final_pagedlistingbrowser;
        val$sc = servicecall;
        val$finishState = i;
        val$error = Exception.this;
        super();
    }
}
