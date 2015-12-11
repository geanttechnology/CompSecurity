// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.common.model.AllBiddersData;
import com.ebay.common.net.api.trading.GetAllBiddersRequest;
import com.ebay.common.net.api.trading.GetAllBiddersResponse;
import com.ebay.mobile.Item;
import com.ebay.mobile.dcs.DcsInteger;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.CacheLock;
import com.ebay.nautilus.kernel.util.TimedCache;
import com.ebay.nautilus.kernel.util.TimedCacheWallClock;
import java.net.URL;

public final class BiddingDataManager extends UserContextObservingDataManager
{
    public static final class BidderContent extends Content
    {

        final Item item;

        public BidderContent(AllBiddersData allbiddersdata, ResultStatus resultstatus, Item item1)
        {
            super(allbiddersdata, resultstatus);
            item = item1;
        }
    }

    protected static class BidderMeta extends CacheLock
    {

        protected int bidCount;

        protected BidderMeta()
        {
            bidCount = -1;
        }
    }

    private final class BidderTask extends AsyncTask
    {

        public final long auctionEndsAt;
        public final int bidCount;
        public final Item item;
        public final com.ebay.common.net.api.trading.GetAllBiddersRequest.RequestParams requestParams;
        final BiddingDataManager this$0;

        protected transient BidderContent doInBackground(Void avoid[])
        {
            if (BiddingDataManager.logger.isLoggable)
            {
                BiddingDataManager.logger.log((new StringBuilder()).append("Calling GetAllBidders API for: ").append(requestParams).toString());
            }
            Object obj = new ResultStatusOwner();
            avoid = (GetAllBiddersResponse)safeSendRequest(new GetAllBiddersRequest(requestParams), ((ResultStatusOwner) (obj)));
            obj = ((ResultStatusOwner) (obj)).getResultStatus();
            if (obj == ResultStatus.CANCELED)
            {
                return null;
            }
            if (((ResultStatus) (obj)).hasError())
            {
                return new BidderContent(null, ((ResultStatus) (obj)), item);
            }
            avoid = ((GetAllBiddersResponse) (avoid)).allBidders;
            if (avoid == null || ((AllBiddersData) (avoid)).listingStatus == null)
            {
                return new BidderContent(null, ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    InternalDomainError.getServerResponseNotValidMessage()
                }), item);
            } else
            {
                return new BidderContent(avoid, ((ResultStatus) (obj)), item);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleBidderLoadComplete(this, null);
        }

        protected void onPostExecute(BidderContent biddercontent)
        {
            super.onPostExecute(biddercontent);
            handleBidderLoadComplete(this, biddercontent);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((BidderContent)obj);
        }

        public String toString()
        {
            return (new StringBuilder()).append("BidderTask [bidCount=").append(bidCount).append(", auctionEndsAt=").append(auctionEndsAt).append(", requestParams=").append(requestParams).append("]").toString();
        }

        public BidderTask(int i, long l, com.ebay.common.net.api.trading.GetAllBiddersRequest.RequestParams requestparams, Item item1)
        {
            this$0 = BiddingDataManager.this;
            super();
            bidCount = i;
            auctionEndsAt = l;
            requestParams = requestparams;
            item = item1;
        }
    }

    public static final class ImageContent extends Content
    {

        public ImageContent(Bitmap bitmap, ResultStatus resultstatus)
        {
            super(bitmap, resultstatus);
        }
    }

    protected static class ImageMeta extends CacheLock
    {

        protected ImageMeta()
        {
        }
    }

    protected static final class ImageRequestParams
    {

        public final int lruSize;
        public final String url;

        public String toString()
        {
            return (new StringBuilder()).append("ImageRequestParams [lruSize=").append(lruSize).append(", url=").append(url).append("]").toString();
        }

        public ImageRequestParams(int i, String s)
        {
            if (BiddingDataManager._unitTest)
            {
                lruSize = 0;
            } else
            {
                lruSize = i;
            }
            url = s;
        }
    }

    private final class ImageTask extends AsyncTask
    {

        public final ImageRequestParams requestParams;
        final BiddingDataManager this$0;

        protected transient ImageContent doInBackground(Void avoid[])
        {
            if (BiddingDataManager.logger.isLoggable)
            {
                BiddingDataManager.logger.log((new StringBuilder()).append("Calling GetPhotoNetLoader API for: ").append(requestParams).toString());
            }
            avoid = new com.ebay.mobile.common.PhotoGalleryWidget.GetPhotoNetLoader(requestParams.url, com.ebay.mobile.common.PhotoGalleryWidget.PhotoResolution.Standard, -1, getEbayContext(), requestParams.lruSize);
            avoid.executeImmediate();
            if (avoid.isInterrupted())
            {
                return null;
            }
            ResultStatus resultstatus = avoid.getResultStatus();
            if (resultstatus.hasError())
            {
                return new ImageContent(null, resultstatus);
            } else
            {
                return new ImageContent(avoid.getBitmap(), resultstatus);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleImageLoadComplete(this, null);
        }

        protected void onPostExecute(ImageContent imagecontent)
        {
            super.onPostExecute(imagecontent);
            handleImageLoadComplete(this, imagecontent);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ImageContent)obj);
        }

        public String toString()
        {
            return (new StringBuilder()).append("ImageTask [requestParams=").append(requestParams).append("]").toString();
        }

        public ImageTask(ImageRequestParams imagerequestparams)
        {
            this$0 = BiddingDataManager.this;
            super();
            requestParams = imagerequestparams;
        }
    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                long l = parcel.readLong();
                return new KeyParams(parcel.readString(), l);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final String imageUrl;
        public final long itemId;

        protected BiddingDataManager create(EbayContext ebaycontext)
        {
            return new BiddingDataManager(ebaycontext, this);
        }

        protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (obj instanceof KeyParams)
                {
                    if (itemId != ((KeyParams) (obj = (KeyParams)obj)).itemId || !TextUtils.equals(imageUrl, ((KeyParams) (obj)).imageUrl))
                    {
                        return false;
                    }
                } else
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            int j = super.hashCode();
            int k = (int)(itemId ^ itemId >>> 32);
            int i;
            if (imageUrl == null)
            {
                i = 33;
            } else
            {
                i = imageUrl.hashCode();
            }
            return (j * 31 + k) * 31 + i;
        }

        public String toString()
        {
            return (new StringBuilder()).append("ItemId: ").append(itemId).append(", imageUrl: ").append(imageUrl).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeLong(itemId);
            parcel.writeString(imageUrl);
        }


        public KeyParams(long l, URL url)
        {
            itemId = l;
            imageUrl = BiddingDataManager.urlAsString(url);
        }

        protected KeyParams(String s, long l)
        {
            itemId = l;
            imageUrl = s;
        }
    }

    public static interface Observer
    {

        public abstract void onBidderChanged(BiddingDataManager biddingdatamanager, BidderContent biddercontent);

        public abstract void onImageChanged(BiddingDataManager biddingdatamanager, ImageContent imagecontent);
    }


    private static final int BIDDING_ENTRIES = 5;
    private static long BIDDING_TTL = 0L;
    private static final int IMAGE_ENTRIES = 3;
    private static long IMAGE_NULL_HOLD_TTL = 5000L;
    private static long IMAGE_TTL;
    protected static final TimedCacheWallClock _bidderCache;
    protected static final TimedCache _imageCache;
    private static boolean _unitTest = false;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("BiddingDataManager", 3, "Log bidding data manager usage");
    private BidderTask _bidderTask;
    private ImageTask _imageTask;

    private BiddingDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/mobile/viewitem/BiddingDataManager$Observer, keyparams);
    }


    private long bidderCacheTtl(long l)
    {
        long l1 = System.currentTimeMillis();
        if (l <= l1)
        {
            return BIDDING_TTL;
        } else
        {
            return Math.min(l - l1, BIDDING_TTL);
        }
    }

    private void cancelBidderTask()
    {
        BidderTask biddertask = _bidderTask;
        _bidderTask = null;
        cancelTask(biddertask);
    }

    private void cancelImageTask()
    {
        ImageTask imagetask = _imageTask;
        _imageTask = null;
        cancelTask(imagetask);
    }

    private void cancelTask(AsyncTask asynctask)
    {
        if (asynctask != null)
        {
            asynctask.cancel(true);
        }
    }

    private void executeBidderTask(Item item, EbayTradingApi ebaytradingapi)
    {
        cancelBidderTask();
        ebaytradingapi = new com.ebay.common.net.api.trading.GetAllBiddersRequest.RequestParams(((KeyParams)getParams()).itemId, ebaytradingapi);
        _bidderTask = new BidderTask(item.bidCount, getAuctionEndsAt(item), ebaytradingapi, item);
        executeOnThreadPool(_bidderTask, new Void[0]);
    }

    private void executeImageTask()
    {
        cancelImageTask();
        _imageTask = new ImageTask(new ImageRequestParams(DeviceConfiguration.getAsync().get(DcsInteger.PhotoGalleryLruCacheSize), getImageKey()));
        executeOnThreadPool(_imageTask, new Void[0]);
    }

    private long getAuctionEndsAt(Item item)
    {
        long l;
        if (item.isAuctionEnded)
        {
            l = -1L;
        } else
        {
            long l1 = item.getAuctionTimeRemainingMs();
            l = l1;
            if (l1 >= 0L)
            {
                return l1 + System.currentTimeMillis();
            }
        }
        return l;
    }

    private long getBidderKey()
    {
        return ((KeyParams)getParams()).itemId;
    }

    private BidderMeta getBidderMeta()
    {
        return (BidderMeta)_bidderCache.get(Long.valueOf(getBidderKey()));
    }

    private ImageMeta getImageMeta()
    {
        return (ImageMeta)_imageCache.get(getImageKey());
    }

    private EbayTradingApi getTradingApi(ResultStatusOwner resultstatusowner)
    {
        com.ebay.nautilus.domain.app.Authentication authentication = getCurrentUser();
        if (authentication == null)
        {
            resultstatusowner.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                InternalDomainError.getPleaseSignInMessage()
            });
        }
        if (authentication == null)
        {
            return null;
        } else
        {
            return EbayApiUtil.getTradingApi(getContext(), authentication);
        }
    }

    private ImageContent loadImageTask()
    {
        ImageMeta imagemeta1 = getImageMeta();
        String s = getImageKey();
        if (TextUtils.isEmpty(s))
        {
            ImageMeta imagemeta = imagemeta1;
            if (imagemeta1 == null)
            {
                imagemeta = new ImageMeta();
                imagemeta.setData(new ImageContent(null, ResultStatus.SUCCESS));
                _imageCache.put(s, imagemeta, IMAGE_TTL);
            }
            return (ImageContent)imagemeta.getData();
        }
        s = null;
        ImageContent imagecontent = s;
        if (imagemeta1 != null)
        {
            imagecontent = s;
            if (_imageTask == null)
            {
                imagecontent = (ImageContent)imagemeta1.getData();
            }
        }
        if (_imageTask == null && imagecontent == null)
        {
            executeImageTask();
        }
        return imagecontent;
    }

    private static String urlAsString(URL url)
    {
        if (url != null)
        {
            return url.toString();
        } else
        {
            return "";
        }
    }

    public void flush()
    {
        _bidderCache.remove(Long.valueOf(getBidderKey()));
        _imageCache.remove(getImageKey());
    }

    public void forceReloadData(Item item)
    {
        NautilusKernel.verifyMain();
        flush();
        loadBidders(null, item);
        loadImageTask();
    }

    public BidderContent getBidderContent()
    {
        BidderMeta biddermeta = getBidderMeta();
        if (biddermeta != null)
        {
            return (BidderContent)biddermeta.getData();
        } else
        {
            return null;
        }
    }

    public ImageContent getImageContent()
    {
        ImageMeta imagemeta = getImageMeta();
        if (imagemeta != null)
        {
            return (ImageContent)imagemeta.getData();
        } else
        {
            return null;
        }
    }

    public String getImageKey()
    {
        return ((KeyParams)getParams()).imageUrl;
    }

    void handleBidderLoadComplete(BidderTask biddertask, BidderContent biddercontent)
    {
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("handleBidderLoadComplete: ").append(biddertask).append(" content: ").append(biddercontent).toString());
        }
        if (biddertask == _bidderTask)
        {
            _bidderTask = null;
            if (biddercontent != null)
            {
                if (!biddercontent.getStatus().hasError())
                {
                    BidderMeta biddermeta = new BidderMeta();
                    biddermeta.bidCount = biddertask.bidCount;
                    biddermeta.setData(biddercontent);
                    _bidderCache.put(Long.valueOf(getBidderKey()), biddermeta, bidderCacheTtl(biddertask.auctionEndsAt));
                }
                ((Observer)dispatcher).onBidderChanged(this, biddercontent);
                return;
            }
        }
    }

    void handleImageLoadComplete(ImageTask imagetask, ImageContent imagecontent)
    {
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("handleImageLoadComplete: ").append(imagetask).append(" content: ").append(imagecontent).toString());
        }
        if (imagetask == _imageTask)
        {
            _imageTask = null;
            if (imagecontent != null)
            {
                imagetask = new ImageMeta();
                long l;
                if (imagecontent.getData() == null)
                {
                    l = IMAGE_NULL_HOLD_TTL;
                } else
                {
                    l = IMAGE_TTL;
                }
                imagetask.setData(imagecontent);
                _imageCache.put(getImageKey(), imagetask, l);
                ((Observer)dispatcher).onImageChanged(this, imagecontent);
                return;
            }
        }
    }

    public boolean loadBidders(Observer observer, Item item)
    {
        NautilusKernel.verifyMain();
        Observer observer1 = (Observer)getSafeCallback(observer);
        if (_bidderTask != null && _bidderTask.bidCount == item.bidCount)
        {
            return true;
        }
        Object obj = getBidderMeta();
        if (obj == null || ((BidderMeta) (obj)).bidCount != item.bidCount)
        {
            Object obj1 = new ResultStatusOwner();
            obj = getTradingApi(((ResultStatusOwner) (obj1)));
            obj1 = ((ResultStatusOwner) (obj1)).getResultStatus();
            if (((ResultStatus) (obj1)).hasError())
            {
                cancelBidderTask();
                if (observer1 != null)
                {
                    observer.onBidderChanged(this, new BidderContent(null, ((ResultStatus) (obj1)), item));
                }
                return false;
            } else
            {
                executeBidderTask(item, ((EbayTradingApi) (obj)));
                return true;
            }
        }
        if (observer1 != null)
        {
            item = (BidderContent)((BidderMeta) (obj)).getData();
            if (item != null)
            {
                observer.onBidderChanged(this, item);
            }
        }
        return false;
    }

    public void loadData(Observer observer)
    {
        NautilusKernel.verifyMain();
        ImageContent imagecontent = loadImageTask();
        if (observer != null && imagecontent != null)
        {
            observer.onImageChanged(this, imagecontent);
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    protected void onLastObserverUnregistered()
    {
        cancelBidderTask();
        cancelImageTask();
    }

    static 
    {
        BIDDING_TTL = 0x1b7740L;
        IMAGE_TTL = 0x927c0L;
        _bidderCache = new TimedCacheWallClock(5, BIDDING_TTL);
        _imageCache = new TimedCache(3, IMAGE_TTL);
    }



}
