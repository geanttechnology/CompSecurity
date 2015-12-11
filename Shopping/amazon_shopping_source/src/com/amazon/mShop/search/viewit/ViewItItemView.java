// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.mShop.ItemView;
import com.amazon.mShop.ObjectSubscriberAdapter;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.details.ItemViewUtils;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.ui.DrawableFactory;
import com.amazon.mShop.util.ImageUtil;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.io.ByteArrayOutputStream;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, ViewItSearchResultWrapper, ViewItUtil, ViewItSlidingDrawerBrowser, 
//            ViewItSlidingDrawerView, ViewItPhotoCaptureView, ViewItAllMatchedResultsView, ViewItMetricHelper

public class ViewItItemView extends ItemView
{
    static final class ItemShowType extends Enum
    {

        private static final ItemShowType $VALUES[];
        public static final ItemShowType ITEM_SHOW_IN_ALL_MATCHES;
        public static final ItemShowType ITME_SHOW_AS_GROUP;

        public static ItemShowType valueOf(String s)
        {
            return (ItemShowType)Enum.valueOf(com/amazon/mShop/search/viewit/ViewItItemView$ItemShowType, s);
        }

        public static ItemShowType[] values()
        {
            return (ItemShowType[])$VALUES.clone();
        }

        static 
        {
            ITME_SHOW_AS_GROUP = new ItemShowType("ITME_SHOW_AS_GROUP", 0);
            ITEM_SHOW_IN_ALL_MATCHES = new ItemShowType("ITEM_SHOW_IN_ALL_MATCHES", 1);
            $VALUES = (new ItemShowType[] {
                ITME_SHOW_AS_GROUP, ITEM_SHOW_IN_ALL_MATCHES
            });
        }

        private ItemShowType(String s, int i)
        {
            super(s, i);
        }
    }


    private ViewItActivity mActivity;
    private ViewItSlidingDrawerBrowser mBrowser;
    private View mButtonGroup;
    private Button mDeleteButton;
    private ViewGroup mItemProductInfoContent;
    private SearchResult mItemResult;
    private ImageView mItemRowImage;
    private ViewGroup mItemTextAndImageContent;
    private ItemShowType mItemType;
    private ViewItSearchResultWrapper mObject;
    private Button mSeeAllMatchedButton;
    private ViewGroup mUndoContent;

    public ViewItItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mItemType = ItemShowType.ITME_SHOW_AS_GROUP;
        mActivity = (ViewItActivity)context;
    }

    private ClickStreamTag getClickStreamTag(ViewItSearchResultWrapper viewitsearchresultwrapper, boolean flag, boolean flag1)
    {
        ClickStreamTag clickstreamtag;
        Object obj;
        obj = null;
        clickstreamtag = obj;
        if (viewitsearchresultwrapper == null) goto _L2; else goto _L1
_L1:
        if (!ResultWrapper.ResultType.BARCODE.equals(viewitsearchresultwrapper.getResultType())) goto _L4; else goto _L3
_L3:
        if (!flag) goto _L6; else goto _L5
_L5:
        clickstreamtag = ClickStreamTag.ORIGIN_VIEW_IT_FLOW_ALL_MATCHES_BARCODE;
_L2:
        return clickstreamtag;
_L6:
        if (flag1)
        {
            return ClickStreamTag.ORIGIN_VIEW_IT_FLOW_EXPANDED_TRAY_BARCODE;
        } else
        {
            return ClickStreamTag.ORIGIN_VIEW_IT_FLOW_MINI_TRAY_BARCODE;
        }
_L4:
        clickstreamtag = obj;
        if (ResultWrapper.ResultType.IMAGE.equals(viewitsearchresultwrapper.getResultType()))
        {
            if (flag)
            {
                return ClickStreamTag.ORIGIN_VIEW_IT_FLOW_ALL_MATCHES_IMAGE;
            }
            if (flag1)
            {
                return ClickStreamTag.ORIGIN_VIEW_IT_FLOW_EXPANDED_TRAY_IMAGE;
            } else
            {
                return ClickStreamTag.ORIGIN_VIEW_IT_FLOW_MINI_TRAY_IMAGE;
            }
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    protected void dispatchSetPressed(boolean flag)
    {
    }

    public int getDeleteButtonHeight()
    {
        if (mDeleteButton.getVisibility() == 0)
        {
            return mDeleteButton.getHeight();
        } else
        {
            return 0;
        }
    }

    public ViewItSearchResultWrapper getGroupObject()
    {
        return mObject;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mItemTextAndImageContent = (ViewGroup)findViewById(com.amazon.mShop.android.lib.R.id.item_image_and_text_content);
        mItemProductInfoContent = (ViewGroup)findViewById(com.amazon.mShop.android.lib.R.id.item_row_product_info_content);
        mUndoContent = (ViewGroup)findViewById(com.amazon.mShop.android.lib.R.id.item_undo_content);
        mItemRowImage = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.item_row_image);
        mButtonGroup = findViewById(com.amazon.mShop.android.lib.R.id.item_button_group);
        mDeleteButton = (Button)findViewById(com.amazon.mShop.android.lib.R.id.delete_button);
        mDeleteButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewItItemView this$0;

            public void onClick(View view)
            {
                showUndoButtonContent();
                mBrowser.updateUndoObject(mObject, mItemResult, mItemType);
                view = mActivity.getCurrentView();
                if (view != null)
                {
                    if (view instanceof ViewItPhotoCaptureView)
                    {
                        RefMarkerObserver.logRefMarker("fl_history_del_btn");
                    } else
                    if (view instanceof ViewItAllMatchedResultsView)
                    {
                        RefMarkerObserver.logRefMarker("fl_allmatch_del_btn");
                        return;
                    }
                }
            }

            
            {
                this$0 = ViewItItemView.this;
                super();
            }
        });
        ((Button)findViewById(com.amazon.mShop.android.lib.R.id.undo_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final ViewItItemView this$0;

            public void onClick(View view)
            {
                showItemContent();
                if (mBrowser != null)
                {
                    mBrowser.recoverUndo(mObject);
                }
            }

            
            {
                this$0 = ViewItItemView.this;
                super();
            }
        });
        mSeeAllMatchedButton = (Button)findViewById(com.amazon.mShop.android.lib.R.id.more_matched_items_button);
        mSeeAllMatchedButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewItItemView this$0;

            public void onClick(View view)
            {
                mActivity.getViewItMetricHelper().logCountMetricsPerSession("history-see-more-tap", 1);
                if (mActivity.getPhotoCaptureView().getViewItSlidingDrawerView().isOpened())
                {
                    RefMarkerObserver.logRefMarker("fl_max_all_btn");
                } else
                {
                    RefMarkerObserver.logRefMarker("fl_mini_all_btn");
                }
                view = (ViewItAllMatchedResultsView)LayoutInflater.from(mActivity).inflate(com.amazon.mShop.android.lib.R.layout.view_it_all_matched_items_view, null);
                view.updateAllMatchedResultsView(mObject, mBrowser);
                mActivity.pushView(view);
                mBrowser.deleteUndoObject();
            }

            
            {
                this$0 = ViewItItemView.this;
                super();
            }
        });
    }

    public void setItemClickAction(final ViewItSlidingDrawerView slidingDrawer, final SearchResult item, final ViewItSearchResultWrapper wrapper, final boolean isAllMatchesItem)
    {
        mItemTextAndImageContent.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewItItemView this$0;
            final boolean val$isAllMatchesItem;
            final SearchResult val$item;
            final ViewItSlidingDrawerView val$slidingDrawer;
            final ViewItSearchResultWrapper val$wrapper;

            public void onClick(View view)
            {
                Object obj;
                ProductController productcontroller;
                if (isAllMatchesItem)
                {
                    RefMarkerObserver.logRefMarker("fl_allmatch_dp");
                } else
                if (slidingDrawer.isOpened())
                {
                    mActivity.getViewItMetricHelper().logCountMetricsPerSession("history-maximized-item-tap", 1);
                    RefMarkerObserver.logRefMarker("fl_max_dp");
                } else
                {
                    mActivity.getViewItMetricHelper().logCountMetricsPerSession("history-minimized-item-tap", 1);
                    RefMarkerObserver.logRefMarker("fl_mini_dp");
                }
                productcontroller = new ProductController(item);
                productcontroller.setClickStreamTag(getClickStreamTag(wrapper, isAllMatchesItem, slidingDrawer.isOpened()));
                obj = (Bitmap)LRUCache.getValue(ImageUtil.getImageUrl(item.getBasicProduct().getImageUrl(), getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_item_thumbnail_picture_max_dimension)), android/graphics/Bitmap);
                view = ((View) (obj));
                if (obj == null)
                {
                    view = BitmapFactory.decodeResource(getResources(), com.amazon.mShop.android.lib.R.drawable.noimage);
                }
                obj = new ByteArrayOutputStream();
                if (view.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((java.io.OutputStream) (obj))))
                {
                    productcontroller.setThumbnail(((ByteArrayOutputStream) (obj)).toByteArray());
                }
                mActivity.forward(productcontroller);
                mBrowser.deleteUndoObject();
            }

            
            {
                this$0 = ViewItItemView.this;
                isAllMatchesItem = flag;
                slidingDrawer = viewitslidingdrawerview;
                item = searchresult;
                wrapper = viewitsearchresultwrapper;
                super();
            }
        });
    }

    public void setObject(ViewItSearchResultWrapper viewitsearchresultwrapper, SearchResult searchresult, ViewItSlidingDrawerBrowser viewitslidingdrawerbrowser, ItemShowType itemshowtype)
    {
        mObject = viewitsearchresultwrapper;
        mItemResult = searchresult;
        mBrowser = viewitslidingdrawerbrowser;
        mItemType = itemshowtype;
    }

    protected void showItemContent()
    {
        mItemTextAndImageContent.setVisibility(0);
        mButtonGroup.setVisibility(0);
        mUndoContent.setVisibility(8);
    }

    protected void showUndoButtonContent()
    {
        String s1 = mItemResult.getBasicProduct().getTitle();
        String s = s1;
        if (Util.isEmpty(s1))
        {
            s = s1;
            if (mObject != null)
            {
                s = s1;
                if (!Util.isEmpty(mObject.getSearchResults()))
                {
                    s = ((SearchResult)mObject.getSearchResults().get(0)).getBasicProduct().getAsin();
                }
            }
        }
        ((TextView)mUndoContent.findViewById(com.amazon.mShop.android.lib.R.id.removed_item_txt)).setText(getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_item_was_removed, new Object[] {
            s
        }));
        mItemTextAndImageContent.setVisibility(8);
        mButtonGroup.setVisibility(8);
        mUndoContent.setVisibility(0);
    }

    public void update(ObjectSubscriberAdapter objectsubscriberadapter, Object obj, byte abyte0[], int i)
    {
        mItemProductInfoContent.setVisibility(0);
        objectsubscriberadapter = (SearchResult)obj;
        com.amazon.rio.j2me.client.services.mShop.BasicOfferListing basicofferlisting = objectsubscriberadapter.getBasicOffer();
        BasicProductInfo basicproductinfo = objectsubscriberadapter.getBasicProduct();
        setImageRequester(obj);
        String s = ImageUtil.getImageUrl(basicproductinfo.getImageUrl(), getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_item_thumbnail_picture_max_dimension));
        obj = (Bitmap)LRUCache.getValue(s, android/graphics/Bitmap);
        objectsubscriberadapter = null;
        if (obj != null)
        {
            objectsubscriberadapter = new com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams(s, null);
            objectsubscriberadapter = DrawableFactory.getInstance().createDrawable(getResources(), ((Bitmap) (obj)), objectsubscriberadapter);
        }
        ItemViewUtils.updateImageWithDrawable(objectsubscriberadapter, mItemRowImage);
        if (objectsubscriberadapter == null && abyte0 == null && basicproductinfo != null && !Util.isEmpty(basicproductinfo.getImageUrl()))
        {
            getImageFromBackground(basicproductinfo.getImageUrl(), getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_item_thumbnail_picture_max_dimension));
        }
        updateItemView(i, basicofferlisting, basicproductinfo);
    }

    protected void updateButtonVisibility()
    {
        if (ItemShowType.ITME_SHOW_AS_GROUP.equals(mItemType) && ViewItUtil.hasMultipleResults(mObject))
        {
            mSeeAllMatchedButton.setVisibility(0);
        } else
        {
            mSeeAllMatchedButton.setVisibility(8);
            if (ItemShowType.ITEM_SHOW_IN_ALL_MATCHES.equals(mItemType))
            {
                mDeleteButton.setVisibility(8);
                return;
            }
        }
    }






}
