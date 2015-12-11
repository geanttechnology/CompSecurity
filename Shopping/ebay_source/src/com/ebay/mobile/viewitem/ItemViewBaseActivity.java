// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.android.widget.ImageViewPager;
import com.ebay.mobile.ErrorDialogFragment;
import com.ebay.mobile.Item;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsString;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.VariationPictureSet;
import com.ebay.nautilus.domain.dcs.DcsNautilusString;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.image.ZoomImageId;
import com.ebay.nautilus.domain.net.image.ZoomUrlBuilder;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemViewData, ItemViewActivity, ViewItemDataManager

public abstract class ItemViewBaseActivity extends BaseActivity
    implements com.ebay.android.widget.ImageViewPager.OnImageLoadedListener, com.ebay.mobile.ErrorDialogFragment.OnDismissMessageListener, ViewItemDataManager.Observer, com.ebay.mobile.viewitem.fragments.ViewItemBaseFragment.ActivityRefreshListener, com.ebay.mobile.viewitem.fragments.ViewItemBaseFragment.ItemEndedListener, com.ebay.mobile.viewitem.fragments.ViewItemBaseFragment.ProgressIndicatorListener, com.ebay.nautilus.domain.content.dm.ImageDataManager.Observer
{

    public ImageDataManager imageDataManager;
    public ImageViewPager imageViewPager;
    public Item item;
    public ColorStateList textColorBlue;
    public ViewItemViewData viewData;
    public ViewItemDataManager viewItemDataManager;

    public ItemViewBaseActivity()
    {
    }

    private List buildPictureUrls()
    {
        Object obj = DeviceConfiguration.getAsync();
        if (ZoomUrlBuilder.isValid(((DeviceConfiguration) (obj)))) goto _L2; else goto _L1
_L1:
        obj = item.pictureUrls;
_L4:
        return ((List) (obj));
_L2:
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        ZoomUrlBuilder zoomurlbuilder = new ZoomUrlBuilder(((DeviceConfiguration) (obj)));
        ArrayList arraylist = new ArrayList(item.pictureUrls.size());
        int i = 0;
        do
        {
            obj = arraylist;
            if (i >= item.pictureUrls.size())
            {
                continue;
            }
            obj = (String)item.pictureUrls.get(i);
            ZoomImageId zoomimageid = (ZoomImageId)item.pictureZoomIds.get(i);
            if (zoomimageid != null)
            {
                obj = zoomurlbuilder.build(zoomimageid, displaymetrics.widthPixels, displaymetrics.widthPixels);
            }
            arraylist.add(obj);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getGspTermsAndConditionsUrl(Item item1)
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        if (item1.isSeller)
        {
            item1 = DcsString.GspSellerTAndC;
        } else
        {
            item1 = DcsString.GspBuyerTAndC;
        }
        return deviceconfiguration.get(item1);
    }

    public static void setTakeActionButtonEnabled(BaseActivity baseactivity, boolean flag)
    {
        baseactivity = (Button)baseactivity.findViewById(0x7f10030a);
        if (baseactivity != null)
        {
            baseactivity.setEnabled(flag);
        }
    }

    public void animateFinish()
    {
        finish();
        overridePendingTransition(0, 0x7f04000d);
    }

    public void animateFinishItemEnded()
    {
        setResult(20);
        animateFinish();
    }

    public void deleteCachedItem()
    {
    }

    protected String getActionTitle()
    {
        return null;
    }

    public List getGalleryPhotos(ViewItemViewData viewitemviewdata)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator;
        boolean flag;
        if (!item.hasAtLeastOneSelection(viewitemviewdata.nameValueList))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            arraylist.addAll(buildPictureUrls());
        }
        iterator = item.variationPictureSets.iterator();
label0:
        do
        {
            VariationPictureSet variationpictureset;
            boolean flag2;
label1:
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                variationpictureset = (VariationPictureSet)iterator.next();
                boolean flag1 = flag;
                flag2 = flag1;
                if (flag1)
                {
                    break label1;
                }
                Iterator iterator1 = viewitemviewdata.nameValueList.iterator();
                NameValue namevalue;
                do
                {
                    flag2 = flag1;
                    if (!iterator1.hasNext())
                    {
                        break label1;
                    }
                    namevalue = (NameValue)iterator1.next();
                } while (!namevalue.getName().equals(item.variationPicturesSpecificName) || !namevalue.getValue().equals(variationpictureset.specificName));
                flag2 = true;
            }
            if (flag2)
            {
                arraylist.addAll(variationpictureset.pictureUrls);
            }
        } while (true);
        if (!flag)
        {
            arraylist.addAll(buildPictureUrls());
        }
        return arraylist;
    }

    protected int getLayoutId()
    {
        return 0;
    }

    public void headerInnards(ViewGroup viewgroup, boolean flag)
    {
        headerInnards(viewgroup, flag, 1);
    }

    public void headerInnards(ViewGroup viewgroup, boolean flag, int i)
    {
label0:
        {
label1:
            {
                Object obj = (TextView)viewgroup.findViewById(0x7f1002ef);
                com.ebay.nautilus.domain.data.ItemCurrency itemcurrency;
                com.ebay.nautilus.domain.data.ItemCurrency itemcurrency2;
                TextView textview1;
                if (flag && !item.isBinOnly)
                {
                    ((TextView) (obj)).setText(item.displayCurrentPrice);
                } else
                if (item.isMultiSku && item.hasMultiSkuValues(viewData.nameValueList))
                {
                    com.ebay.nautilus.domain.data.ItemCurrency itemcurrency1 = item.currentPriceForType(getEbayContext(), viewData);
                    if (itemcurrency1 != null)
                    {
                        ((TextView) (obj)).setText(EbayCurrencyUtil.formatDisplay(itemcurrency1, 0));
                    }
                } else
                if (viewData.buyAnother)
                {
                    ((TextView) (obj)).setText(EbayCurrencyUtil.formatDisplay(item.buyItNowPrice, item.getCurrencyUtilFlag()));
                } else
                {
                    ((TextView) (obj)).setText(item.displayPrice);
                }
                obj = item;
                if (i > 1 && item.shippingInfoUpdated != null)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0)
                {
                    obj = new Item();
                    obj.isDisplayPriceCurrencyCode = item.isDisplayPriceCurrencyCode;
                    obj.shippingInfo = item.shippingInfoUpdated;
                    Item.setupShippingDisplayPrices(this, ((Item) (obj)));
                    Item.setupShippingDisplayPricesConverted(getEbayContext(), ((Item) (obj)));
                }
                if (!TextUtils.isEmpty(((Item) (obj)).displayPriceShippingTerse))
                {
                    TextView textview = (TextView)viewgroup.findViewById(0x7f1002f1);
                    textview.setText(((Item) (obj)).displayPriceShippingTerse);
                    textview.setVisibility(0);
                }
                if (!((Item) (obj)).isDisplayPriceCurrencyCode)
                {
                    break label0;
                }
                textview1 = (TextView)viewgroup.findViewById(0x7f1002f0);
                itemcurrency2 = ((Item) (obj)).convertedCurrentPrice;
                itemcurrency = itemcurrency2;
                if (((Item) (obj)).convertedBuyItNowPrice == null)
                {
                    break label1;
                }
                if (!((Item) (obj)).isBinOnly)
                {
                    itemcurrency = itemcurrency2;
                    if (flag)
                    {
                        break label1;
                    }
                }
                itemcurrency = ((Item) (obj)).convertedBuyItNowPrice;
            }
            textview1.setText(Item.getApproximateString(this, itemcurrency));
            textview1.setVisibility(0);
            if (((Item) (obj)).displayPriceShippingConvertedCurrency != null)
            {
                viewgroup = (TextView)viewgroup.findViewById(0x7f1002f2);
                viewgroup.setText(Item.getApproximateString(this, ((Item) (obj)).displayPriceShippingConvertedCurrency));
                viewgroup.setVisibility(0);
            }
        }
    }

    public void headerSetThumbnail(Bitmap bitmap)
    {
        headerSetThumbnail(bitmap, (ViewGroup)findViewById(0x7f1002ec));
    }

    public void headerSetThumbnail(Bitmap bitmap, ViewGroup viewgroup)
    {
label0:
        {
            if (viewgroup != null)
            {
                viewgroup = (ImageView)viewgroup.findViewById(0x7f1002ed);
                if (viewgroup != null)
                {
                    if (bitmap == null)
                    {
                        break label0;
                    }
                    viewgroup.setImageBitmap(bitmap);
                }
            }
            return;
        }
        viewgroup.setImageResource(0x7f0201f5);
    }

    public void headerStart(int i)
    {
        headerStart(i, false, 1);
    }

    public void headerStart(int i, ViewGroup viewgroup)
    {
        headerStart(i, viewgroup, false, 1);
    }

    public void headerStart(int i, ViewGroup viewgroup, boolean flag, int j)
    {
        if (viewgroup == null)
        {
            return;
        }
        Object obj = item.thumbnailImage;
        DeviceConfiguration deviceconfiguration;
        if (obj != null && imageDataManager != null)
        {
            imageDataManager.loadImage(this, ((URL) (obj)).toString());
        } else
        {
            ((ImageView)viewgroup.findViewById(0x7f1002ed)).setImageResource(0x7f0201f5);
        }
        obj = (TextView)viewgroup.findViewById(0x7f100108);
        deviceconfiguration = DeviceConfiguration.getAsync();
        ((TextView) (obj)).setText(item.title.getContent(deviceconfiguration.get(DcsBoolean.itemTitleTranslationEnabled)));
        ((TextView) (obj)).setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final ItemViewBaseActivity this$0;

            public boolean onLongClick(View view)
            {
                ((ClipboardManager)getSystemService("clipboard")).setText(item.title.getSourceContent());
                Toast.makeText(ItemViewBaseActivity.this, getString(0x7f070269), 0).show();
                return true;
            }

            
            {
                this$0 = ItemViewBaseActivity.this;
                super();
            }
        });
        switch (i)
        {
        default:
            return;

        case 2130903340: 
        case 2130903341: 
        case 2130903342: 
            headerInnards(viewgroup, flag, j);
            break;
        }
    }

    public void headerStart(int i, boolean flag)
    {
        headerStart(i, flag, 1);
    }

    public void headerStart(int i, boolean flag, int j)
    {
        headerStart(i, (ViewGroup)findViewById(0x7f1002ec), flag, j);
    }

    public void hideProgress()
    {
    }

    public void onBidUpdated(ViewItemDataManager viewitemdatamanager, Content content)
    {
    }

    public void onCartChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setActionBar(getLayoutId(), getActionTitle());
        textColorBlue = ThemeUtil.resolveThemeColorStateList(getResources(), getTheme(), 0x1010212);
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (viewItemDataManager == null)
        {
            viewItemDataManager = viewitemdatamanager;
        }
        if (!content.getStatus().hasError())
        {
            if (content.getData() == null && ItemViewActivity.logTag.isLoggable)
            {
                ItemViewActivity.logTag.log("ItemViewBaseActivity overwriting item with null!");
            }
            item = (Item)content.getData();
        }
        if (item != null && viewData != null)
        {
            item.displayPriceColor = Item.computeDisplayPriceColor(item, ThemeUtil.resolveThemeForegroundColorResId(getTheme(), 0x7f01004e), viewData.kind, item.isBidWithBin);
        }
    }

    public void onDismissMessage(int i, boolean flag)
    {
    }

    public void onGetOrdersCompleted(ViewItemDataManager viewitemdatamanager, Content content)
    {
    }

    public void onImageLoaded(String s, int i)
    {
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        imageDataManager = (ImageDataManager)datamanagercontainer.initialize(ImageDataManager.KEY, this);
    }

    public void onItemEnded()
    {
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
    }

    public void onPlaceOfferCompleted(ViewItemDataManager viewitemdatamanager, Content content)
    {
    }

    public void onRespondBestOfferCompleted(ViewItemDataManager viewitemdatamanager, Content content)
    {
    }

    public void reloadItemFromNetwork(Intent intent)
    {
    }

    public void scrollToTop()
    {
        ScrollView scrollview = (ScrollView)findViewById(0x7f100017);
        if (scrollview != null)
        {
            scrollview.fullScroll(33);
        }
    }

    public void sendAddToCartClickTracking()
    {
        TrackingData trackingdata = new TrackingData("AddToCart", TrackingType.EVENT);
        if (item != null)
        {
            trackingdata.addKeyValuePair("itm", item.getIdString());
        }
        trackingdata.send(this);
    }

    public void sendBuyItNowClickTracking()
    {
        TrackingData trackingdata = new TrackingData("BuyItNowTap", TrackingType.EVENT);
        if (item != null)
        {
            trackingdata.addKeyValuePair("itm", item.getIdString());
        }
        trackingdata.send(this);
    }

    protected ActionBar setActionBar(int i, String s)
    {
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null && i > 0)
        {
            actionbar.setDisplayShowTitleEnabled(false);
            actionbar.setDisplayShowHomeEnabled(true);
            actionbar.setCustomView(i);
            actionbar.setDisplayShowCustomEnabled(true);
            TextView textview = (TextView)findViewById(0x7f10030a);
            textview.setText(s);
            textview.setOnClickListener((android.view.View.OnClickListener)this);
        }
        return actionbar;
    }

    public void setupImageViewPager()
    {
        imageViewPager = (ImageViewPager)findViewById(0x7f1002f8);
        if (imageViewPager != null)
        {
            imageViewPager.setOnImageLoadedListener(this);
        }
    }

    public void showButterBarMessage(int i, String s, boolean flag)
    {
        Bundle bundle = new Bundle();
        bundle.putString("message", s);
        bundle.putBoolean("isError", true);
        if (i >= 0)
        {
            bundle.putInt("id", i);
        }
        if (flag)
        {
            bundle.putBoolean("allowRetry", true);
        }
        bundle.putBoolean("asMessageBar", true);
        FragmentManager fragmentmanager = getFragmentManager();
        Object obj = fragmentmanager.findFragmentByTag("messageDialog");
        s = ((String) (obj));
        if (obj instanceof DialogFragment)
        {
            obj = (DialogFragment)obj;
            s = null;
            ((DialogFragment) (obj)).dismiss();
        }
        FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();
        obj = fragmenttransaction;
        if (s != null)
        {
            fragmenttransaction.remove(s);
            fragmenttransaction.commit();
            obj = fragmentmanager.beginTransaction();
        }
        ((FragmentTransaction) (obj)).addToBackStack(null);
        s = new ErrorDialogFragment();
        s.setArguments(bundle);
        s.show(((FragmentTransaction) (obj)), "messageDialog");
    }

    public void showGspTermsAndConditions()
    {
        ShowWebViewActivity.start(this, getGspTermsAndConditionsUrl(item), getString(0x7f070093), "ViewItemGSPTermsAndConditions");
    }

    public void showProgress()
    {
    }

    public void trackBidEvent(String s)
    {
        s = new TrackingData(s, TrackingType.EVENT);
        if (item != null)
        {
            s.addKeyValuePair("itm", item.getIdString());
        }
        s.send(this);
    }

    public int updateGalleryPhotos(ViewItemViewData viewitemviewdata)
    {
        if (imageViewPager != null)
        {
            viewitemviewdata = getGalleryPhotos(viewitemviewdata);
            com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType urlrewritertype = com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType.from(DeviceConfiguration.getAsync().get(DcsNautilusString.ViewItemImageRewriterType));
            imageViewPager.setAdapter(new com.ebay.android.widget.ImageViewPager.ImageViewPagerAdapter(viewitemviewdata, urlrewritertype));
            return viewitemviewdata.size();
        } else
        {
            return 0;
        }
    }
}
