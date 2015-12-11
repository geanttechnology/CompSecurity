// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.common.Preferences;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseListActivity;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.viewitem.ItemViewCommonProgressAndError;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.data.BestOffer;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.bestoffer:
//            BestOfferAdapter, BestOfferTracking, SellerRespondToOfferActivity

public class SellerReviewOffersActivity extends BaseListActivity
    implements android.widget.AdapterView.OnItemClickListener, com.ebay.nautilus.domain.content.dm.ImageDataManager.Observer
{
    private class ViewItemDataManagerObserver extends com.ebay.mobile.viewitem.ViewItemDataManager.SimpleViewItemDataManagerObserver
    {

        final SellerReviewOffersActivity this$0;

        public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled actionhandled, boolean flag)
        {
            if (isFinishing())
            {
                return;
            }
            if (viewItemDataManager == null)
            {
                viewItemDataManager = viewitemdatamanager;
            }
            ItemViewCommonProgressAndError.showLayouts(SellerReviewOffersActivity.this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.NORMAL);
            if (!content.getStatus().hasError())
            {
                item = (Item)content.getData();
                static class _cls2
                {

                    static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

                    static 
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled.values().length];
                        try
                        {
                            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled.GET_BEST_OFFERS.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls2..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                    headerStart(0x7f03012c, (ViewGroup)findViewById(0x7f1002ec));
                    setListAdapter(new BestOfferAdapter(SellerReviewOffersActivity.this, item.offers));
                    return;

                case 2: // '\002'
                    setListAdapter(new BestOfferAdapter(SellerReviewOffersActivity.this, item.offers));
                    break;
                }
                return;
            } else
            {
                EbayErrorHandler.handleResultStatus(SellerReviewOffersActivity.this, 0, content.getStatus());
                return;
            }
        }

        private ViewItemDataManagerObserver()
        {
            this$0 = SellerReviewOffersActivity.this;
            super();
        }

    }


    public static final String EXTRA_HAS_PENDING = "pending";
    private ViewItemDataManagerObserver dmObserver;
    private ImageDataManager imageDataManager;
    private Item item;
    private ViewItemViewData viewData;
    private ViewItemDataManager viewItemDataManager;

    public SellerReviewOffersActivity()
    {
    }

    public static void StartActivity(Activity activity, ViewItemViewData viewitemviewdata, int i)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/bestoffer/SellerReviewOffersActivity);
        intent.putExtra("view_item_view_data", viewitemviewdata);
        activity.startActivityForResult(intent, i);
    }

    private void issueRefresh()
    {
        ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
        viewItemDataManager.getBestOffers(EbayApiUtil.getTradingApi(this, MyApp.getPrefs().getAuthentication()), item.id, viewData);
    }

    public String getTrackingEventName()
    {
        return "BestOfferSellerReview";
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

    public void headerStart(int i, ViewGroup viewgroup)
    {
        if (viewgroup != null)
        {
            Object obj = item.thumbnailImage;
            Object obj1;
            if (obj != null && imageDataManager != null)
            {
                imageDataManager.loadImage(this, ((URL) (obj)).toString());
            } else
            {
                ((ImageView)viewgroup.findViewById(0x7f1002ed)).setImageResource(0x7f0201f5);
            }
            obj = (TextView)viewgroup.findViewById(0x7f100108);
            obj1 = DeviceConfiguration.getAsync();
            ((TextView) (obj)).setText(item.title.getContent(((DeviceConfiguration) (obj1)).get(DcsBoolean.itemTitleTranslationEnabled)));
            ((TextView) (obj)).setOnLongClickListener(new android.view.View.OnLongClickListener() {

                final SellerReviewOffersActivity this$0;

                public boolean onLongClick(View view)
                {
                    ((ClipboardManager)getSystemService("clipboard")).setText(item.title.getSourceContent());
                    Toast.makeText(SellerReviewOffersActivity.this, getString(0x7f070269), 0).show();
                    return true;
                }

            
            {
                this$0 = SellerReviewOffersActivity.this;
                super();
            }
            });
            switch (i)
            {
            default:
                return;

            case 2130903340: 
                obj = (TextView)viewgroup.findViewById(0x7f1002ef);
                break;
            }
            obj1 = (TextView)viewgroup.findViewById(0x7f1002f1);
            ((TextView) (obj)).setText(item.displayPrice);
            ((TextView) (obj1)).setText(item.displayPriceShipping);
            if (item.isDisplayPriceCurrencyCode)
            {
                TextView textview = (TextView)viewgroup.findViewById(0x7f1002f0);
                viewgroup = (TextView)viewgroup.findViewById(0x7f1002f2);
                textview.setText(Item.getApproximateString(getApplicationContext(), item.displayPriceConvertedCurrency));
                textview.setVisibility(0);
                viewgroup.setText(Item.getApproximateString(this, item.displayPriceShippingConvertedCurrency));
                viewgroup.setVisibility(0);
                return;
            }
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
label0:
        {
label1:
            {
                if (j != -1)
                {
                    break label0;
                }
                if (!intent.hasExtra("offer") || item == null)
                {
                    break label1;
                }
                Object obj = (BestOffer)intent.getParcelableExtra("offer");
                Iterator iterator = item.offers.iterator();
                BestOffer bestoffer;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label1;
                    }
                    bestoffer = (BestOffer)iterator.next();
                } while (!bestoffer.id.equals(((BestOffer) (obj)).id) || bestoffer.status.equals(((BestOffer) (obj)).status));
                bestoffer.status = ((BestOffer) (obj)).status;
                if (bestoffer.status.equals("Countered"))
                {
                    issueRefresh();
                } else
                {
                    setListAdapter(new BestOfferAdapter(this, item.offers));
                }
            }
            obj = new Intent();
            if (item != null)
            {
                ((Intent) (obj)).putExtra("pending", item.bestOfferPending(MyApp.getPrefs().getCurrentUser()));
            }
            ((Intent) (obj)).putExtra("offer", intent.getParcelableExtra("offer"));
            setResult(-1, ((Intent) (obj)));
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03018f);
        if (bundle == null)
        {
            viewData = (ViewItemViewData)getIntent().getExtras().getParcelable("view_item_view_data");
            BestOfferTracking.trackPage(this, getTrackingEventName());
        } else
        {
            viewData = (ViewItemViewData)bundle.getParcelable("view_item_view_data");
        }
        dmObserver = new ViewItemDataManagerObserver();
        initDataManagers();
        getListView().setOnItemClickListener(this);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        imageDataManager = (ImageDataManager)datamanagercontainer.initialize(ImageDataManager.KEY, this);
        viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, dmObserver);
        viewItemDataManager.loadData(dmObserver, viewData);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        SellerRespondToOfferActivity.StartActivity(this, viewData, ((BestOfferAdapter.BestOfferListItem)getListAdapter().getItem(i)).offer, 0);
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        while (isFinishing() || content == null || content.getData() == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image, (ViewGroup)findViewById(0x7f1002ec));
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("view_item_view_data", viewData);
        super.onSaveInstanceState(bundle);
    }



/*
    static ViewItemDataManager access$002(SellerReviewOffersActivity sellerreviewoffersactivity, ViewItemDataManager viewitemdatamanager)
    {
        sellerreviewoffersactivity.viewItemDataManager = viewitemdatamanager;
        return viewitemdatamanager;
    }

*/



/*
    static Item access$102(SellerReviewOffersActivity sellerreviewoffersactivity, Item item1)
    {
        sellerreviewoffersactivity.item = item1;
        return item1;
    }

*/
}
