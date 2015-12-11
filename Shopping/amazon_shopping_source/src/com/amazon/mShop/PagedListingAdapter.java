// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.ui.ObjectSubscriberDecorator;

// Referenced classes of package com.amazon.mShop:
//            ObjectSubscriberAdapter, AmazonActivity

public abstract class PagedListingAdapter extends ObjectSubscriberAdapter
{

    protected PagedListingBrowser browser;

    public PagedListingAdapter(AmazonActivity amazonactivity)
    {
        super(amazonactivity);
    }

    public PagedListingBrowser getBrowser()
    {
        return browser;
    }

    public int getCount()
    {
        if (browser == null)
        {
            return 0;
        } else
        {
            return browser.getReceivedCount();
        }
    }

    public void setBrowser(PagedListingBrowser pagedlistingbrowser)
    {
        browser = pagedlistingbrowser;
        pagedlistingbrowser.setPrimarySubscriber(new ObjectSubscriberDecorator(this));
        notifyDataSetChanged();
    }
}
