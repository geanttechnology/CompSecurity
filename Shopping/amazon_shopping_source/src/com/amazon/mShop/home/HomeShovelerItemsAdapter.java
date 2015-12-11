// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amazon.mShop.control.home.BasicProductsController;
import com.amazon.mShop.control.home.BasicProductsSubscriber;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.net.BitmapFetcher;
import com.amazon.mShop.net.PageMetricsObserver;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.DataUtil;
import com.amazon.mShop.util.TextUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponse;
import com.amazon.rio.j2me.client.services.mShop.HomeItem;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.home:
//            ShovelerItemView, HomeShovelerView, HomeView

public class HomeShovelerItemsAdapter extends com.amazon.mShop.ui.HorizontalListView.HorizontalListViewAdapter
    implements BasicProductsSubscriber, com.amazon.mShop.net.HttpFetcher.Subscriber
{
    private class HomeShovelerItem
    {

        private HomeItem mHomeItem;
        private int mRetryCounts;
        final HomeShovelerItemsAdapter this$0;

        public HomeItem getHomeShoveler()
        {
            return mHomeItem;
        }

        public int getRetryCounts()
        {
            return mRetryCounts;
        }

        public void setRetryCounts(int i)
        {
            mRetryCounts = i;
        }

        public HomeShovelerItem(HomeItem homeitem, int i)
        {
            this$0 = HomeShovelerItemsAdapter.this;
            super();
            mRetryCounts = 0;
            mHomeItem = homeitem;
            mRetryCounts = i;
        }
    }

    public static interface HomeShovelerItemsShownSubscriber
    {

        public abstract void onHomeShovelerItemsShown();

        public abstract void onMostLeftItemFocused(boolean flag);

        public abstract void onMostRightItemFocused(boolean flag);
    }


    private BasicProductsController mBasicProductsController;
    private Context mContext;
    private Integer mDisplayType;
    private boolean mFetchingBasicProduct;
    private List mFetchingFullInfoItems;
    private List mFetchingOOBImageItems;
    private List mFullItems;
    private HomeShovelerItemsShownSubscriber mHomeShovelerItemsShownSubscriber;
    private boolean mPageMetricsAlreadyFinished;
    private PageMetricsObserver mPageMetricsCriticalFeatureObserver;
    private PageMetricsObserver mPageMetricsObserver;
    private PageMetricsObserver mPageMetricsRefreshCriticalFeatureObserver;
    private List mRawItems;
    private String mRefMarkerArg;
    private String mRequestId;
    private String mShovelerClickStreamOrigin;
    private String mShovelerSlotToken;
    private List mShownItems;
    private List mStubItems;

    public HomeShovelerItemsAdapter(Context context, String s, String s1, String s2, PageMetricsObserver pagemetricsobserver, PageMetricsObserver pagemetricsobserver1, PageMetricsObserver pagemetricsobserver2, 
            HomeShovelerItemsShownSubscriber homeshoveleritemsshownsubscriber, String s3, Integer integer)
    {
        mFullItems = new ArrayList();
        mStubItems = new ArrayList();
        mShownItems = new ArrayList();
        mFetchingOOBImageItems = new ArrayList();
        mFetchingFullInfoItems = new ArrayList();
        mFetchingBasicProduct = false;
        mShovelerSlotToken = null;
        mShovelerClickStreamOrigin = null;
        mRefMarkerArg = null;
        mRequestId = null;
        mBasicProductsController = new BasicProductsController(this);
        mDisplayType = null;
        mPageMetricsAlreadyFinished = false;
        mContext = context;
        mShovelerSlotToken = s;
        mShovelerClickStreamOrigin = s1;
        mRefMarkerArg = s2;
        mPageMetricsObserver = pagemetricsobserver;
        mPageMetricsCriticalFeatureObserver = pagemetricsobserver1;
        mPageMetricsRefreshCriticalFeatureObserver = pagemetricsobserver2;
        mHomeShovelerItemsShownSubscriber = homeshoveleritemsshownsubscriber;
        mRequestId = s3;
        mDisplayType = integer;
    }

    private void cancelMetrics(PageMetricsObserver pagemetricsobserver)
    {
        if (pagemetricsobserver != null && !pagemetricsobserver.isFinished())
        {
            pagemetricsobserver.onCancelled();
        }
    }

    private void fetchBasicProducts()
    {
        if (Util.isEmpty(mStubItems))
        {
            return;
        }
        ArrayList arraylist = new ArrayList();
        int j = mStubItems.size();
        for (int i = 0; i < j && i < 6; i++)
        {
            arraylist.add(((HomeShovelerItem)mStubItems.get(i)).getHomeShoveler().getAsin());
            mFetchingFullInfoItems.add(mStubItems.get(i));
        }

        mStubItems.removeAll(mFetchingFullInfoItems);
        mBasicProductsController.requestBasicProducts(arraylist, mRequestId);
        mFetchingBasicProduct = true;
    }

    private View getShovelerItemView(final int position, ShovelerItemView shoveleritemview)
    {
        Object obj;
        BasicProductInfo basicproductinfo;
        BasicOfferListing basicofferlisting;
        TextView textview;
        obj = null;
        HomeItem homeitem = (HomeItem)mShownItems.get(position);
        basicproductinfo = homeitem.getBasicProduct();
        basicofferlisting = homeitem.getBasicOffer();
        if (basicproductinfo != null)
        {
            obj = basicproductinfo.getImageUrl();
        }
        final ShovelerItemView shovelerItemView = LayoutInflater.from(mContext);
        if (shoveleritemview == null)
        {
            shovelerItemView = (ShovelerItemView)shovelerItemView.inflate(com.amazon.mShop.android.lib.R.layout.home_shoveler_item_view, null);
        } else
        {
            shovelerItemView = shoveleritemview;
        }
        shovelerItemView.update(((String) (obj)));
        obj = (TextView)shovelerItemView.findViewById(com.amazon.mShop.android.lib.R.id.home_shoveler_item_title);
        textview = (TextView)shovelerItemView.findViewById(com.amazon.mShop.android.lib.R.id.home_shoveler_item_item_price);
        if (!DataUtil.isEqual(mDisplayType, 1)) goto _L2; else goto _L1
_L1:
        ((TextView) (obj)).setVisibility(8);
        textview.setVisibility(8);
_L5:
        shovelerItemView.setTag(homeitem);
        shovelerItemView.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeShovelerItemsAdapter this$0;
            final int val$position;
            final ShovelerItemView val$shovelerItemView;

            public void onClick(View view)
            {
                Object obj1 = view.getTag();
                if (!(obj1 instanceof HomeItem)) goto _L2; else goto _L1
_L1:
                view = null;
                if (Util.isEmpty(((HomeItem)obj1).getClickStreamOrigin())) goto _L4; else goto _L3
_L3:
                view = ((HomeItem)obj1).getClickStreamOrigin();
_L6:
                view = new ClickStreamTag(view);
                HomeView.forwardProductDetailsView(mContext, (HomeItem)obj1, view, shovelerItemView.getEncodedImage());
                if (!Util.isEmpty(mShovelerSlotToken))
                {
                    HomeView.postClickedSlotToken(mShovelerSlotToken);
                }
                if (!Util.isEmpty(mRefMarkerArg))
                {
                    RefMarkerObserver.logRefMarker(String.format(mRefMarkerArg, new Object[] {
                        Integer.valueOf(position + 1)
                    }));
                }
_L2:
                return;
_L4:
                if (!Util.isEmpty(mShovelerClickStreamOrigin))
                {
                    view = mShovelerClickStreamOrigin;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                this$0 = HomeShovelerItemsAdapter.this;
                shovelerItemView = shoveleritemview;
                position = i;
                super();
            }
        });
        shovelerItemView.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final HomeShovelerItemsAdapter this$0;

            public void onFocusChange(View view, boolean flag1)
            {
                ((ViewGroup)view.getParent()).getOnFocusChangeListener().onFocusChange(view, flag1);
            }

            
            {
                this$0 = HomeShovelerItemsAdapter.this;
                super();
            }
        });
        return shovelerItemView;
_L2:
        boolean flag;
        if (basicproductinfo == null)
        {
            shoveleritemview = null;
        } else
        {
            shoveleritemview = basicproductinfo.getTitle();
        }
        if (!Util.isEmpty(shoveleritemview))
        {
            ((TextView) (obj)).setText(shoveleritemview);
            ((TextView) (obj)).setVisibility(0);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        obj = null;
        if (basicofferlisting != null) goto _L4; else goto _L3
_L3:
        shoveleritemview = ((ShovelerItemView) (obj));
        if (basicproductinfo != null)
        {
            shoveleritemview = ((ShovelerItemView) (obj));
            if (basicproductinfo.getVariationPriceRange() != null)
            {
                shoveleritemview = basicproductinfo.getVariationPriceRange();
            }
        }
_L6:
        obj = new Paint();
        ((Paint) (obj)).setTextSize(mContext.getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.home_shoveler_item_text_size));
        flag = TextUtils.isTextExceedMaxWidth(shoveleritemview, ((Paint) (obj)), (int)mContext.getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.home_view_shoveler_view_thumbnail_max_dimension));
        if (!Util.isEmpty(shoveleritemview) && !flag)
        {
            textview.setText(UIUtils.convertUnsupportedCharacter(mContext, shoveleritemview, com.amazon.mShop.util.UIUtils.CharacterColor.RED));
            textview.setVisibility(0);
        } else
        {
            textview.setVisibility(8);
        }
        if (true) goto _L5; else goto _L4
_L4:
        shoveleritemview = ((ShovelerItemView) (obj));
        if (!basicofferlisting.getPriceViolatesMap())
        {
            if (basicproductinfo != null && basicproductinfo.getVariationPriceRange() != null)
            {
                shoveleritemview = basicproductinfo.getVariationPriceRange();
            } else
            {
                shoveleritemview = ((ShovelerItemView) (obj));
                if (basicofferlisting.getPrice() != null)
                {
                    shoveleritemview = basicofferlisting.getPrice();
                }
            }
        }
          goto _L6
    }

    private void initItems()
    {
        if (!Util.isEmpty(mRawItems))
        {
            Iterator iterator = mRawItems.iterator();
            while (iterator.hasNext()) 
            {
                HomeItem homeitem = (HomeItem)iterator.next();
                if (homeitem.getBasicOffer() == null && homeitem.getBasicProduct() == null)
                {
                    mStubItems.add(new HomeShovelerItem(homeitem, 0));
                } else
                {
                    mFullItems.add(new HomeShovelerItem(homeitem, 0));
                }
            }
        }
    }

    private static void removeItems(List list, String s)
    {
_L2:
        return;
        if (Util.isEmpty(list) || Util.isEmpty(s)) goto _L2; else goto _L1
_L1:
        HomeShovelerItem homeshoveleritem;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            homeshoveleritem = (HomeShovelerItem)iterator.next();
        } while (!s.equalsIgnoreCase(homeshoveleritem.getHomeShoveler().getAsin()));
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L3
_L3:
        list.remove(homeshoveleritem);
        return;
    }

    private void startFetchOOB()
    {
        if (!Util.isEmpty(mFullItems))
        {
            Iterator iterator;
            if (mFullItems.size() <= 6)
            {
                mFetchingOOBImageItems.addAll(mFullItems);
                mFullItems.clear();
            } else
            {
                int i = 0;
                while (i < 6) 
                {
                    mFetchingOOBImageItems.add(mFullItems.get(0));
                    mFullItems.remove(0);
                    i++;
                }
            }
            iterator = mFetchingOOBImageItems.iterator();
            while (iterator.hasNext()) 
            {
                HomeShovelerItem homeshoveleritem = (HomeShovelerItem)iterator.next();
                String s;
                if (homeshoveleritem.getHomeShoveler().getBasicProduct() == null)
                {
                    s = null;
                } else
                {
                    s = homeshoveleritem.getHomeShoveler().getBasicProduct().getImageUrl();
                }
                if (!Util.isEmpty(s))
                {
                    (new BitmapFetcher(s, Integer.valueOf(mContext.getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.home_view_shoveler_view_thumbnail_max_dimension)), homeshoveleritem, this, true, com.amazon.mShop.net.MShopDiskCachePolicy.ResidencePriority.RESIDENCE_PRIORITY_0)).fetch();
                }
            }
        }
    }

    public int getCount()
    {
        return mShownItems.size();
    }

    public HomeShovelerItemsShownSubscriber getHomeShovelerItemsShownSubscriber()
    {
        return mHomeShovelerItemsShownSubscriber;
    }

    public Object getItem(int i)
    {
        return mShownItems.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getTotalCount()
    {
        return mRawItems.size();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if ((i + 1 == 3 || i + 1 == mRawItems.size()) && !mPageMetricsAlreadyFinished)
        {
            if (mPageMetricsObserver != null)
            {
                mPageMetricsObserver.completeForObject(com/amazon/mShop/home/HomeShovelerView.getSimpleName());
            }
            if (mPageMetricsCriticalFeatureObserver != null)
            {
                mPageMetricsCriticalFeatureObserver.completeForObject(com/amazon/mShop/home/HomeShovelerView.getSimpleName());
            }
            if (mPageMetricsRefreshCriticalFeatureObserver != null)
            {
                mPageMetricsRefreshCriticalFeatureObserver.completeForObject(com/amazon/mShop/home/HomeShovelerView.getSimpleName());
            }
            mPageMetricsAlreadyFinished = true;
        }
        if (i > mShownItems.size() - 6 && mFullItems.size() < 6 && !mFetchingBasicProduct && mStubItems.size() > 0)
        {
            fetchBasicProducts();
        }
        if (i > mShownItems.size() - 6 && mFullItems.size() > 0 && Util.isEmpty(mFetchingOOBImageItems))
        {
            startFetchOOB();
        }
        if (view instanceof ShovelerItemView)
        {
            return getShovelerItemView(i, (ShovelerItemView)view);
        } else
        {
            return getShovelerItemView(i, null);
        }
    }

    public void onBasicProductsReceived(BasicProductsResponse basicproductsresponse)
    {
        SearchResult searchresult;
        for (basicproductsresponse = basicproductsresponse.getProducts().iterator(); basicproductsresponse.hasNext(); removeItems(mFetchingFullInfoItems, searchresult.getBasicProduct().getAsin()))
        {
            searchresult = (SearchResult)basicproductsresponse.next();
            HomeItem homeitem = new HomeItem();
            homeitem.setAsin(searchresult.getBasicProduct().getAsin());
            homeitem.setBasicOffer(searchresult.getBasicOffer());
            homeitem.setBasicProduct(searchresult.getBasicProduct());
            homeitem.setImageUrl(searchresult.getBasicProduct().getImageUrl());
            mFullItems.add(new HomeShovelerItem(homeitem, 0));
        }

        if (!Util.isEmpty(mFetchingFullInfoItems))
        {
            mStubItems.addAll(mFetchingFullInfoItems);
            mFetchingFullInfoItems.clear();
        }
        mFetchingBasicProduct = false;
        if (Util.isEmpty(mShownItems) && Util.isEmpty(mFetchingOOBImageItems))
        {
            startFetchOOB();
            return;
        } else
        {
            notifyDataSetChanged();
            return;
        }
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        mFetchingBasicProduct = false;
        cancelMetrics(mPageMetricsObserver);
        exception = mFetchingFullInfoItems.iterator();
        do
        {
            if (!exception.hasNext())
            {
                break;
            }
            servicecall = (HomeShovelerItem)exception.next();
            int i = servicecall.getRetryCounts();
            if (i < 1)
            {
                servicecall.setRetryCounts(i + 1);
                mStubItems.add(servicecall);
            }
        } while (true);
        mFetchingFullInfoItems.clear();
    }

    public void onHttpRequestFailed(com.amazon.mShop.net.HttpFetcher.Params params)
    {
        params = (HomeShovelerItem)params.getTag();
        if (mFetchingOOBImageItems.contains(params))
        {
            mFetchingOOBImageItems.remove(params);
            int i = params.getRetryCounts();
            if (i < 1)
            {
                params.setRetryCounts(i + 1);
                mFullItems.add(params);
            }
            cancelMetrics(mPageMetricsObserver);
            if (Util.isEmpty(mFetchingOOBImageItems))
            {
                notifyDataSetChanged();
            }
        }
    }

    public void onHttpResponseReceived(Bitmap bitmap, com.amazon.mShop.net.HttpFetcher.Params params)
    {
        bitmap = (HomeShovelerItem)params.getTag();
        if (mFetchingOOBImageItems.contains(bitmap))
        {
            mFetchingOOBImageItems.remove(bitmap);
            mShownItems.add(bitmap.getHomeShoveler());
            if (mShownItems.size() == 1 && mHomeShovelerItemsShownSubscriber != null)
            {
                mHomeShovelerItemsShownSubscriber.onHomeShovelerItemsShown();
            }
            notifyDataSetChanged();
        }
    }

    public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.HttpFetcher.Params params)
    {
        onHttpResponseReceived((Bitmap)obj, params);
    }

    public void reset()
    {
        mRawItems.clear();
        mFullItems.clear();
        mStubItems.clear();
        mFetchingFullInfoItems.clear();
        mShownItems.clear();
        mFetchingOOBImageItems.clear();
        notifyDataSetChanged();
    }

    public void setRawItems(List list)
    {
        mRawItems = list;
        initItems();
        startFetchOOB();
        if (Util.isEmpty(mFullItems) && !Util.isEmpty(mStubItems))
        {
            fetchBasicProducts();
        }
    }




}
