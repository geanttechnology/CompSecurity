// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.ebay.common.Preferences;
import com.ebay.common.model.AllBiddersData;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.fragments.ViewItemSpecificsFragment;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ItemViewCommonProgressAndError, ViewItemViewData, BiddingDataManager, 
//            ViewItemDataManager

public class ItemViewBiddingActivity extends ItemViewBaseActivity
    implements BiddingDataManager.Observer
{

    private static final String EXTRA_ALL_BIDDERS = "com.ebay.mobile.viewitem.ItemViewBiddingActivity.allBidders";
    private static final String EXTRA_SCROLL_Y = "com.ebay.mobile.viewitem.ItemViewBiddingActivity.scrollY";
    private static final SimpleDateFormat FORMATTER_12_HOUR = new SimpleDateFormat("hh:mm:ssaa");
    private static final SimpleDateFormat FORMATTER_24_HOUR = new SimpleDateFormat("kk:mm:ss");
    private static final String THUMB_URL = "thumb_url";
    private AllBiddersData _allBidders;
    private BiddingDataManager _biddingDataManager;
    private Bitmap _image;
    private ViewGroup bidsLayout;
    private boolean ignoreUpdates;
    private LayoutInflater inflater;
    private ScrollView scrollView;
    private int scrollY;
    private URL thumbnailUrl;
    private ViewItemDataManager viewItemDataManager;

    public ItemViewBiddingActivity()
    {
    }

    public static void StartActivity(Activity activity, ViewItemViewData viewitemviewdata, URL url)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewBiddingActivity);
        intent.putExtra("view_item_view_data", viewitemviewdata);
        if (url != null)
        {
            intent.putExtra("thumb_url", url);
        }
        activity.startActivity(intent);
    }

    private void appendBidLayout(ViewGroup viewgroup, com.ebay.common.model.AllBiddersData.Offer offer)
    {
        String s1 = EbayCurrencyUtil.formatDisplay(offer.highestBid, 2);
        String s2 = getDisplayDateTime(offer.timeBid, item.isAuctionEnded);
        String s = getResources().getString(0x7f07050c, new Object[] {
            offer.user.userId, Integer.valueOf(offer.user.feedbackScore)
        });
        if (showPrivateListing(offer.user.userId))
        {
            s = getResources().getString(0x7f0704da);
        }
        viewgroup.addView(Util.createViewItemStatRecentBid(inflater, viewgroup, s1, s2, s));
    }

    private void appendBids()
    {
        LinearLayout linearlayout = new LinearLayout(this, null);
        linearlayout.setOrientation(1);
        bidsLayout.removeAllViews();
        bidsLayout.addView(linearlayout);
        if (item.allBidders != null && item.allBidders.offers != null && !item.allBidders.offers.isEmpty())
        {
            for (Iterator iterator = item.allBidders.offers.iterator(); iterator.hasNext(); appendBidLayout(linearlayout, (com.ebay.common.model.AllBiddersData.Offer)iterator.next())) { }
        }
        if (item.startPrice != null)
        {
            appendStartBidLayout(linearlayout);
        }
    }

    private void appendStartBidLayout(ViewGroup viewgroup)
    {
        viewgroup.addView(Util.createViewItemStatRecentBid(inflater, viewgroup, EbayCurrencyUtil.formatDisplay(item.startPrice, 0), getDisplayDateTime(item.startDate, item.isAuctionEnded), getString(0x7f070505)));
    }

    private void createUI()
    {
label0:
        {
            ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
            headerStart(0x7f03012e);
            Object obj;
            LinearLayout linearlayout;
            com.ebay.common.model.AllBiddersData.Offer offer;
            int i;
            if (_allBidders != null)
            {
                i = _allBidders.countBidders();
            } else
            {
                i = 0;
            }
            obj = (ViewGroup)findViewById(0x7f1002fb);
            ((ViewGroup) (obj)).removeAllViews();
            linearlayout = new LinearLayout(this, null);
            linearlayout.setOrientation(1);
            ((ViewGroup) (obj)).addView(linearlayout);
            linearlayout.addView(Util.createViewItemStatCountDown(this, inflater, linearlayout, ViewItemSpecificsFragment.getTimeLeftLabel(this, item), item.endDate, true));
            linearlayout.addView(Util.createViewItemStat(inflater, linearlayout, getString(0x7f0704a2), (new StringBuilder()).append("").append(item.bidCount).toString()));
            linearlayout.addView(Util.createViewItemStat(inflater, linearlayout, getString(0x7f0704a0), (new StringBuilder()).append("").append(i).toString()));
            if (_allBidders == null || TextUtils.isEmpty(_allBidders.highBidder))
            {
                break label0;
            }
            obj = _allBidders.offers.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                offer = (com.ebay.common.model.AllBiddersData.Offer)((Iterator) (obj)).next();
            } while (!_allBidders.highBidder.equals(offer.user.userId));
            if (showPrivateListing(offer.user.userId))
            {
                obj = getString(0x7f0704da);
            } else
            {
                obj = getResources().getString(0x7f07050c, new Object[] {
                    offer.user.userId, Integer.valueOf(offer.user.feedbackScore)
                });
            }
            linearlayout.addView(Util.createViewItemStat(inflater, linearlayout, getString(0x7f070458), ((CharSequence) (obj))));
        }
        appendBids();
    }

    private String getDisplayDateTimeEnded(Date date)
    {
        Object obj = Calendar.getInstance();
        ((Calendar) (obj)).setTime(date);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(DateUtils.getDayOfWeekString(((Calendar) (obj)).get(7), 20)).append("  ");
        stringbuilder.append(DateFormat.getDateFormat(this).format(date)).append("  ");
        if (DateFormat.is24HourFormat(this))
        {
            obj = FORMATTER_24_HOUR;
        } else
        {
            obj = FORMATTER_12_HOUR;
        }
        stringbuilder.append(((SimpleDateFormat) (obj)).format(date));
        return stringbuilder.toString();
    }

    private boolean showPrivateListing(String s)
    {
        return item.privateListing && !item.isSeller && !TextUtils.equals(MyApp.getPrefs().getCurrentUser(), s);
    }

    public String getDisplayDateTime(Date date, boolean flag)
    {
        if (!flag)
        {
            long l = date.getTime();
            l = Math.abs(System.currentTimeMillis() - l);
            if (l >= 0x5265c00L)
            {
                int i = (int)(l / 0x5265c00L);
                return (new StringBuilder()).append(String.valueOf(i)).append(getString(0x7f070049)).toString();
            }
            if (l >= 0x36ee80L)
            {
                int j = (int)(l / 0x36ee80L);
                return (new StringBuilder()).append(String.valueOf(j)).append(getString(0x7f07004c)).toString();
            } else
            {
                int k = (int)(l / 60000L);
                return (new StringBuilder()).append(String.valueOf(k)).append(getString(0x7f07004f)).toString();
            }
        } else
        {
            return getDisplayDateTimeEnded(date);
        }
    }

    public String getTrackingEventName()
    {
        return "BiddingEnterBidAmount";
    }

    public void onBidderChanged(BiddingDataManager biddingdatamanager, BiddingDataManager.BidderContent biddercontent)
    {
        if (ignoreUpdates)
        {
            return;
        }
        biddingdatamanager = biddercontent.getStatus();
        if (biddingdatamanager.hasError())
        {
            ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.updateLayoutForLoaderError(this, biddingdatamanager));
            return;
        } else
        {
            _allBidders = (AllBiddersData)biddercontent.getData();
            createUI();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(getResources().getString(0x7f0704a1));
        setContentView(0x7f030132);
        scrollView = (ScrollView)findViewById(0x7f100016);
        bidsLayout = (ViewGroup)findViewById(0x7f1002fc);
        inflater = (LayoutInflater)getSystemService("layout_inflater");
        if (bundle != null)
        {
            _allBidders = (AllBiddersData)bundle.getParcelable("com.ebay.mobile.viewitem.ItemViewBiddingActivity.allBidders");
            scrollY = bundle.getInt("com.ebay.mobile.viewitem.ItemViewBiddingActivity.scrollY", 0);
            if (_allBidders != null)
            {
                ignoreUpdates = true;
                scrollView.post(new Runnable() {

                    final ItemViewBiddingActivity this$0;

                    public void run()
                    {
                        scrollView.scrollTo(0, scrollY);
                    }

            
            {
                this$0 = ItemViewBiddingActivity.this;
                super();
            }
                });
            }
        }
        viewData = (ViewItemViewData)getIntent().getParcelableExtra("view_item_view_data");
        thumbnailUrl = (URL)getIntent().getSerializableExtra("thumb_url");
        ((Button)findViewById(0x7f10013f)).setOnClickListener(new android.view.View.OnClickListener() {

            final ItemViewBiddingActivity this$0;

            public void onClick(View view)
            {
                refresh();
            }

            
            {
                this$0 = ItemViewBiddingActivity.this;
                super();
            }
        });
        initDataManagers();
        if (!ignoreUpdates)
        {
            ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.PROGRESS);
        }
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (isFinishing())
        {
            return;
        }
        super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
        if (!content.getStatus().hasError())
        {
            static class _cls3
            {

                static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

                static 
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[ViewItemDataManager.ActionHandled.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                }
            }

            switch (_cls3..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                _allBidders = item.allBidders;
                break;
            }
            if (_allBidders == null)
            {
                ignoreUpdates = true;
            }
            if (!ignoreUpdates)
            {
                _biddingDataManager.loadBidders(this, item);
            }
            createUI();
            return;
        } else
        {
            EbayErrorHandler.handleResultStatus(this, actionhandled.ordinal(), content.getStatus());
            return;
        }
    }

    public void onImageChanged(BiddingDataManager biddingdatamanager, BiddingDataManager.ImageContent imagecontent)
    {
        _image = (Bitmap)imagecontent.getData();
        headerSetThumbnail(_image);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        BiddingDataManager.KeyParams keyparams = new BiddingDataManager.KeyParams(viewData.keyParams.itemId, thumbnailUrl);
        _biddingDataManager = (BiddingDataManager)getDataManagerContainer().initialize(keyparams, this);
        viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this);
        viewItemDataManager.loadData(this, viewData);
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        while (isFinishing() || content == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        scrollY = scrollView.getScrollY();
        bundle.putInt("com.ebay.mobile.viewitem.ItemViewBiddingActivity.scrollY", scrollY);
        bundle.putParcelable("com.ebay.mobile.viewitem.ItemViewBiddingActivity.allBidders", _allBidders);
    }

    public void refresh()
    {
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.PROGRESS);
        _biddingDataManager.forceReloadData(item);
    }



}
