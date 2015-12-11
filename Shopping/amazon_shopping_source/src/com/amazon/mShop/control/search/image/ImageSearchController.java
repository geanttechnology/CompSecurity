// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.search.image;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.ImageSearchResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.PhotoSearchRequest;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.search.image:
//            ImageSearchSubscriber

public class ImageSearchController extends BaseController
    implements ImageSearchResponseListener
{

    private boolean mIsCompleted;
    private List mItems;
    private final ImageSearchSubscriber mSubscriber;

    public ImageSearchController(ImageSearchSubscriber imagesearchsubscriber)
    {
        mItems = new ArrayList();
        mIsCompleted = false;
        mSubscriber = imagesearchsubscriber;
    }

    public void completed(final List value, ServiceCall servicecall)
    {
        mIsCompleted = true;
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ImageSearchController this$0;
            final List val$value;

            public void run()
            {
                serviceCallCompleted();
                int i = 0;
                for (int j = value.size(); i < j; i++)
                {
                    mItems.add(value.get(i));
                }

                mSubscriber.onCompleted();
            }

            
            {
                this$0 = ImageSearchController.this;
                value = list;
                super();
            }
        });
    }

    public int count()
    {
        return mItems.size();
    }

    public void doImageSearch(byte abyte0[])
    {
        PhotoSearchRequest photosearchrequest = new PhotoSearchRequest();
        photosearchrequest.setImage(abyte0);
        photosearchrequest.setIncludeAddOnItems(Boolean.TRUE);
        serviceCallStarted(ServiceController.getMShopService().imageSearch(photosearchrequest, this), null);
    }

    public SearchResult getSearchResult(int i)
    {
        return (SearchResult)mItems.get(i);
    }

    protected volatile GenericSubscriber getSubscriber()
    {
        return getSubscriber();
    }

    protected ImageSearchSubscriber getSubscriber()
    {
        return mSubscriber;
    }

    public boolean isCompleted()
    {
        return mIsCompleted;
    }

    public void setCompleted(boolean flag)
    {
        mIsCompleted = flag;
    }



}
