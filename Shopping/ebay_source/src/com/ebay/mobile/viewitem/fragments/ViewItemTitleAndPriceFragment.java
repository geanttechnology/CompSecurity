// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.common.UserCache;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.Item;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.common.eBayRating;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ItemViewDescriptionActivity;
import com.ebay.mobile.viewitem.ProductReviewsActivity;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.FwActivity;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemBaseFragment

public class ViewItemTitleAndPriceFragment extends ViewItemBaseFragment
    implements android.view.View.OnClickListener
{
    private static final class EbayLayoutType extends Enum
    {

        private static final EbayLayoutType $VALUES[];
        public static final EbayLayoutType BID;
        public static final EbayLayoutType BIN;
        public static final EbayLayoutType LISTING_TYPE;

        public static EbayLayoutType valueOf(String s)
        {
            return (EbayLayoutType)Enum.valueOf(com/ebay/mobile/viewitem/fragments/ViewItemTitleAndPriceFragment$EbayLayoutType, s);
        }

        public static EbayLayoutType[] values()
        {
            return (EbayLayoutType[])$VALUES.clone();
        }

        static 
        {
            LISTING_TYPE = new EbayLayoutType("LISTING_TYPE", 0);
            BIN = new EbayLayoutType("BIN", 1);
            BID = new EbayLayoutType("BID", 2);
            $VALUES = (new EbayLayoutType[] {
                LISTING_TYPE, BIN, BID
            });
        }

        private EbayLayoutType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final long hightLightLengthMs = 2000L;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("VIP", 3, "Log VIP");
    private boolean isMAPPriceRevealed;
    private View itemCardLayout;
    private View itemCardRightLayout;
    private View itemCardSeparator;
    private View priceLayoutOne;
    private View priceLayoutTwo;
    private View productReviewLayout;
    private UserCache userCache;

    public ViewItemTitleAndPriceFragment()
    {
    }

    private void checkHighlight()
    {
        ((TextView)priceLayoutOne.findViewById(0x7f1002ef)).setBackgroundResource(0);
    }

    private String getApproximatelyString(int i, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append(s);
        }
        return String.format(getString(i), new Object[] {
            stringbuilder.toString()
        });
    }

    private String getApproximatelyString(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append(s);
        }
        s = getConvertedShippingAmount();
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append(" ").append(s);
        }
        return String.format(getString(0x7f070170), new Object[] {
            stringbuilder.toString()
        });
    }

    private String getConvertedShippingAmount()
    {
        String s = null;
        if (item.isDisplayPriceCurrencyCode)
        {
            s = item.displayPriceShippingConverted;
        }
        return s;
    }

    private void renderBidCount(View view)
    {
        TextView textview = (TextView)view.findViewById(0x7f100895);
        if (item.bidCount > 0 || !item.isBinOnly)
        {
            if (item.bidCount > 0)
            {
                view = resources.getQuantityString(0x7f08001b, item.bidCount, new Object[] {
                    Integer.valueOf(item.bidCount)
                });
            } else
            {
                view = getString(0x7f070b2c);
            }
            view = new StringBuilder(view);
            if (!item.isReserveMet)
            {
                if (view.length() > 0)
                {
                    view.append(" ");
                }
                view.append(resources.getString(0x7f07091c));
            }
            textview.setText(view.toString());
            textview.setVisibility(0);
            return;
        } else
        {
            textview.setVisibility(8);
            return;
        }
    }

    private void renderItemCard()
    {
        boolean flag = false;
        int i;
        if (item.isShowItemCard)
        {
            boolean flag2 = item.isShowItemCardSingle;
            View view;
            boolean flag1;
            if (!TextUtils.isEmpty(item.displayEbayPlusItemCardWithEndTime) || !TextUtils.isEmpty(item.displayEbayPlusItemCard))
            {
                renderItemCardEbayPlus(this.view);
                flag1 = flag2;
            } else
            {
                renderItemCardShipping(this.view, item.displayShippingAmountItemCard, item.displayShippingAmountConvertedItemCard, item.displayShippingLabelItemCard);
                flag1 = flag2;
                if (!flag2)
                {
                    if (!TextUtils.isEmpty(item.displayShippingEstimateItemCard))
                    {
                        renderItemCardRight(this.view, item.displayShippingEstimateItemCard);
                        flag1 = flag2;
                    } else
                    {
                        flag1 = true;
                    }
                }
            }
            view = itemCardRightLayout;
            if (flag1)
            {
                i = 8;
            } else
            {
                i = 0;
            }
            view.setVisibility(i);
            view = itemCardSeparator;
            if (flag1)
            {
                i = 8;
            } else
            {
                i = 0;
            }
            view.setVisibility(i);
        }
        view = itemCardLayout;
        if (item.isShowItemCard)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view = this.view.findViewById(0x7f100903);
        if (item.isShowItemCard)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void renderItemCardEbayPlus(View view)
    {
        view.findViewById(0x7f100906).setVisibility(0);
        view.findViewById(0x7f100908).setVisibility(8);
        view = (TextView)view.findViewById(0x7f100907);
        if (item.displayEbayPlusItemCardWithEndTime != null)
        {
            Util.addCountDownToTextView(item.eBayPlusOrderTodayEndTime, view, item.displayEbayPlusItemCardWithEndTime, false);
            return;
        } else
        {
            view.setText(Html.fromHtml(item.displayEbayPlusItemCard), android.widget.TextView.BufferType.SPANNABLE);
            return;
        }
    }

    private void renderItemCardRight(View view, String s)
    {
        TextView textview = (TextView)view.findViewById(0x7f10090e);
        if (!TextUtils.isEmpty(s))
        {
            textview.setText(s);
            textview.setVisibility(0);
        } else
        {
            textview.setVisibility(8);
        }
        ((TextView)view.findViewById(0x7f10090f)).setText(getString(0x7f0703d8));
    }

    private void renderItemCardShipping(View view, String s, String s1, String s2)
    {
        TextView textview = (TextView)view.findViewById(0x7f100909);
        if (!TextUtils.isEmpty(s))
        {
            textview.setText(s);
            textview.setVisibility(0);
        } else
        {
            textview.setVisibility(8);
        }
        if (!TextUtils.isEmpty(s1))
        {
            s = (TextView)view.findViewById(0x7f10090a);
            s.setText(s1);
            s.setVisibility(0);
        }
        ((TextView)view.findViewById(0x7f10090b)).setText(s2);
    }

    private void renderMeanPrice()
    {
        if (item.isHotnessAutoIdentified && item.hotnessMeanPrice != null)
        {
            TextView textview = (TextView)view.findViewById(0x7f1008b4);
            Resources resources = this.resources;
            com.ebay.nautilus.domain.data.ItemCurrency itemcurrency;
            if (item.hotnessMeanPriceConverted != null)
            {
                itemcurrency = item.hotnessMeanPriceConverted;
            } else
            {
                itemcurrency = item.hotnessMeanPrice;
            }
            textview.setText(resources.getString(0x7f070b85, new Object[] {
                EbayCurrencyUtil.formatDisplay(itemcurrency, item.getCurrencyUtilFlag())
            }));
            textview.setVisibility(0);
        }
    }

    private void renderPrice()
    {
        int i = 1;
        Object obj = getBaseActivity();
        if (obj != null)
        {
            obj = (ViewItemDataManager)DataManager.get(((BaseActivity) (obj)).getEbayContext(), viewData.keyParams);
        } else
        {
            obj = null;
        }
        if (item.isBidWithBin && obj != null && !((ViewItemDataManager) (obj)).isInMyEbayBidList(item.id, viewData.nameValueList))
        {
            renderPrice(priceLayoutOne, EbayLayoutType.BID);
            renderPrice(priceLayoutTwo, EbayLayoutType.BIN);
        } else
        {
            renderPrice(priceLayoutOne, EbayLayoutType.LISTING_TYPE);
            i = 0;
        }
        obj = priceLayoutTwo;
        if (i != 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }

    private void renderPrice(View view, EbayLayoutType ebaylayouttype)
    {
        BaseActivity baseactivity = getBaseActivity();
        if (baseactivity != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        com.ebay.nautilus.kernel.content.EbayContext ebaycontext = baseactivity.getEbayContext();
        TextView textview = (TextView)view.findViewById(0x7f1002ef);
        TextView textview1 = (TextView)view.findViewById(0x7f1008b3);
        View view1 = view.findViewById(0x7f1008b8);
        TextView textview2 = (TextView)view.findViewById(0x7f1008b7);
        Object obj = null;
        String s3 = null;
        static class _cls2
        {

            static final int $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemTitleAndPriceFragment$EbayLayoutType[];

            static 
            {
                $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemTitleAndPriceFragment$EbayLayoutType = new int[EbayLayoutType.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemTitleAndPriceFragment$EbayLayoutType[EbayLayoutType.BIN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemTitleAndPriceFragment$EbayLayoutType[EbayLayoutType.BID.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.ebay.mobile.viewitem.fragments.ViewItemTitleAndPriceFragment.EbayLayoutType[ebaylayouttype.ordinal()])
        {
        default:
            if (item.isMultiSku)
            {
                String s;
                if (item.needsToSelectMultiSku(viewData.nameValueList))
                {
                    s = item.displayPrice;
                } else
                {
                    s = item.addBsfVat(resources, EbayCurrencyUtil.formatDisplay(item.currentPriceForType(ebaycontext, viewData, false), 0));
                }
                ebaylayouttype = s3;
                s3 = s;
                if (item.isDisplayPriceCurrencyCode)
                {
                    if (item.needsToSelectMultiSku(viewData.nameValueList))
                    {
                        ebaylayouttype = item.displayPriceConverted;
                        s3 = s;
                    } else
                    {
                        ebaylayouttype = EbayCurrencyUtil.formatDisplay(item.currentPriceForType(ebaycontext, viewData, item.isDisplayPriceCurrencyCode), item.getCurrencyUtilFlag());
                        s3 = s;
                    }
                }
            } else
            if (item.isBinOnly)
            {
                String s1 = item.displayPrice;
                ebaylayouttype = s3;
                s3 = s1;
                if (item.isDisplayPriceCurrencyCode)
                {
                    ebaylayouttype = item.displayPriceConverted;
                    s3 = s1;
                }
            } else
            {
                String s2 = item.displayCurrentPrice;
                ebaylayouttype = s3;
                s3 = s2;
                if (item.isDisplayPriceCurrencyCode)
                {
                    ebaylayouttype = item.displayCurrentPriceConverted;
                    s3 = s2;
                }
            }
            if (item.isMap && !isMAPPriceRevealed)
            {
                textview.setVisibility(8);
            } else
            {
                if (!TextUtils.isEmpty(s3))
                {
                    textview.setText(s3);
                    textview.setTextColor(resources.getColor(item.displayPriceColor));
                    textview.setVisibility(0);
                    setupUnitPrice(view);
                }
                if (!TextUtils.isEmpty(ebaylayouttype))
                {
                    if (item.isShowItemCard)
                    {
                        textview1.setText(getApproximatelyString(0x7f070170, ebaylayouttype));
                    } else
                    {
                        textview1.setText(getApproximatelyString(ebaylayouttype));
                    }
                    textview1.setVisibility(0);
                }
            }
            if (!item.isClassifiedItem())
            {
                renderBidCount(view);
                if (item.bestOfferEnabled && !item.isTransacted)
                {
                    showPriceType(textview2, 0x7f070ba8);
                }
            }
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */
        }
        if (!item.isShowItemCard)
        {
            renderShipping(view);
        }
        renderItemCard();
        renderSTPMAP(view, view1);
        renderSavings(view1);
        renderMeanPrice();
        if (item.depositAmount != null)
        {
            view = (TextView)this.view.findViewById(0x7f1008b5);
            view.setText(String.format(getString(0x7f07047a), new Object[] {
                EbayCurrencyUtil.formatDisplay(item.depositAmount, item.getCurrencyUtilFlag())
            }));
            view.setVisibility(0);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        view.findViewById(0x7f100895).setVisibility(8);
        if (item.isMultiSku)
        {
            if (item.needsToSelectMultiSku(viewData.nameValueList))
            {
                s = item.displayPrice;
            } else
            {
                s = item.addBsfVat(resources, EbayCurrencyUtil.formatDisplay(item.currentPriceForType(ebaycontext, viewData, false), 0));
            }
            ebaylayouttype = obj;
            s3 = s;
            if (item.isDisplayPriceCurrencyCode)
            {
                if (item.needsToSelectMultiSku(viewData.nameValueList))
                {
                    ebaylayouttype = item.displayPriceConverted;
                    s3 = s;
                } else
                {
                    ebaylayouttype = EbayCurrencyUtil.formatDisplay(item.currentPriceForType(ebaycontext, viewData, item.isDisplayPriceCurrencyCode), item.getCurrencyUtilFlag());
                    s3 = s;
                }
            }
        } else
        {
            s = item.displayPrice;
            ebaylayouttype = obj;
            s3 = s;
            if (item.isDisplayPriceCurrencyCode)
            {
                ebaylayouttype = item.displayPriceConverted;
                s3 = s;
            }
        }
        if (!TextUtils.isEmpty(s3))
        {
            textview.setText(s3);
            textview.setTextColor(resources.getColor(item.displayPriceColor));
            textview.setVisibility(0);
        }
        if (!TextUtils.isEmpty(ebaylayouttype))
        {
            if (item.isShowItemCard)
            {
                textview1.setText(getApproximatelyString(0x7f070170, ebaylayouttype));
            } else
            {
                textview1.setText(getApproximatelyString(ebaylayouttype));
            }
            textview1.setVisibility(0);
        }
        showPriceType(textview2, 0x7f0701b7);
        setupUnitPrice(view);
        break MISSING_BLOCK_LABEL_239;
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void renderReviews()
    {
        Object obj = (eBayRating)productReviewLayout.findViewById(0x7f1004f6);
        ((eBayRating) (obj)).setFeedbackStarResources(0x7f02022b, 0x7f02022d, 0x7f02022b, 0x7f02022c);
        ((eBayRating) (obj)).setOnTouchListener(null);
        ((eBayRating) (obj)).setValue(item.productReviewAverageRating);
        ((eBayRating) (obj)).setContentDescription(String.format(getString(0x7f07011f), new Object[] {
            String.valueOf(item.productReviewAverageRating)
        }));
        obj = (TextView)productReviewLayout.findViewById(0x7f1004f7);
        ((TextView) (obj)).setText(getString(0x7f0708d2, new Object[] {
            Long.valueOf(item.productReviewCount)
        }));
        ((TextView) (obj)).setContentDescription(resources.getQuantityString(0x7f080004, (int)item.productReviewCount, new Object[] {
            Integer.valueOf((int)item.productReviewCount)
        }));
        productReviewLayout.setOnClickListener(this);
        productReviewLayout.setVisibility(0);
    }

    private void renderSTPMAP(View view, View view1)
    {
        if (item.displayPriceOriginal != null)
        {
            TextView textview1 = (TextView)view1.findViewById(0x7f1008b9);
            TextView textview = (TextView)view1.findViewById(0x7f1008ba);
            if (item.isMap)
            {
                View view2 = view.findViewById(0x7f1002ef);
                View view3 = view.findViewById(0x7f1008b2);
                view = view.findViewById(0x7f1008b1);
                if (isMAPPriceRevealed)
                {
                    view2.setVisibility(0);
                    view.setVisibility(8);
                    view3.setVisibility(8);
                    view3.setOnClickListener(null);
                    view.setOnClickListener(null);
                } else
                {
                    view2.setVisibility(8);
                    view.setVisibility(0);
                    view3.setVisibility(0);
                    view3.setClickable(true);
                    view3.setOnClickListener(this);
                    view.setOnClickListener(this);
                }
                textview1.setText(getString(0x7f0704dc));
                textview1.setVisibility(0);
            } else
            if (item.isStp || item.promotionalSaleOriginalPrice != null)
            {
                textview1.setText(item.stpSavingsWasLabel);
                textview1.setVisibility(0);
            }
            if (textview != null)
            {
                view1.setVisibility(0);
                textview.setVisibility(0);
                if (item.isDisplayPriceCurrencyCode)
                {
                    view = item.displayPriceOriginalConverted;
                } else
                {
                    view = item.displayPriceOriginal;
                }
                textview.setText(view);
                textview.setPaintFlags(textview.getPaintFlags() | 0x10);
            }
        }
    }

    private void renderSavings(View view)
    {
        boolean flag = false;
        int i = 0;
        if (!TextUtils.isEmpty(item.displayPricePercentOff))
        {
            TextView textview = (TextView)view.findViewById(0x7f1008bb);
            textview.setText(item.displayPricePercentOff);
            textview.setVisibility(0);
            if (item.isStp || item.isTransacted || item.isMap && isMAPPriceRevealed || item.promotionalSaleOriginalPrice != null)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        }
        if (i != 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void renderShipping(View view)
    {
        view = (TextView)view.findViewById(0x7f1002f1);
        String s = item.displayPriceShipping;
        if (!TextUtils.isEmpty(s))
        {
            view.setText(s);
            view.setVisibility(0);
            return;
        } else
        {
            view.setVisibility(8);
            return;
        }
    }

    private void renderTitle()
    {
        boolean flag = false;
        TextView textview = (TextView)view.findViewById(0x7f1008fe);
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        textview.setText(item.title.getContent(deviceconfiguration.get(DcsBoolean.itemTitleTranslationEnabled)));
        textview.setContentDescription(textview.getText());
        textview.setOnClickListener(this);
        textview = (TextView)view.findViewById(0x7f1008ff);
        int i;
        if (item.subTitle != null && !TextUtils.isEmpty(item.subTitle.getContent(deviceconfiguration.get(DcsBoolean.itemTitleTranslationEnabled))))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            textview.setText(item.subTitle.getContent(deviceconfiguration.get(DcsBoolean.itemTitleTranslationEnabled)));
            textview.setContentDescription(textview.getText());
            textview.setOnClickListener(this);
        }
        if (i != 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
    }

    private void setupUnitPrice(View view)
    {
        if (!TextUtils.isEmpty(item.displayPricePerUnit) || !TextUtils.isEmpty(item.displayPricePerUnitConverted))
        {
            String s;
            if (!TextUtils.isEmpty(item.displayPricePerUnitConverted))
            {
                s = item.displayPricePerUnitConverted;
            } else
            {
                s = item.displayPricePerUnit;
            }
            view = (TextView)view.findViewById(0x7f1008b6);
            view.setText(s);
            view.setVisibility(0);
        }
    }

    private void showPriceType(TextView textview, int i)
    {
        textview.setText(getString(i));
        textview.setVisibility(0);
    }

    public void highlightPrice()
    {
        Object obj = priceLayoutOne;
        if (obj != null)
        {
            obj = (TextView)((View) (obj)).findViewById(0x7f1002ef);
            ((TextView) (obj)).setBackgroundResource(0x7f0d0100);
            ((TextView) (obj)).postDelayed(new Runnable() {

                final ViewItemTitleAndPriceFragment this$0;

                public void run()
                {
                    checkHighlight();
                }

            
            {
                this$0 = ViewItemTitleAndPriceFragment.this;
                super();
            }
            }, 2000L);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        userCache = new UserCache(getActivity(), getFwActivity().getEbayContext());
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            super.onClick(view);
            return;

        case 2131757310: 
        case 2131757311: 
            ItemViewDescriptionActivity.StartActivity(getActivity(), viewData, com.ebay.mobile.viewitem.ItemViewDescriptionActivity.What.DESCRIPTION);
            return;

        case 2131757234: 
            DialogManager.createAlertDialog(getActivity(), 0x7f0705d6, 0x7f0704ca).show();
            return;

        case 2131757233: 
            isMAPPriceRevealed = true;
            userCache.setPriceRevealed(item.getIdString());
            render(item, viewData);
            return;

        case 2131757312: 
            ProductReviewsActivity.StartActivity(getActivity(), viewData);
            break;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        view = layoutinflater.inflate(0x7f0302a5, viewgroup, false);
        priceLayoutOne = view.findViewById(0x7f100901);
        priceLayoutTwo = view.findViewById(0x7f100902);
        itemCardLayout = view.findViewById(0x7f100904);
        itemCardRightLayout = view.findViewById(0x7f10090d);
        itemCardSeparator = view.findViewById(0x7f10090c);
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.ViewItem.B.productReviewStarsInTitleSection))
        {
            productReviewLayout = view.findViewById(0x7f100900);
        }
        return view;
    }

    protected void render(Item item, ViewItemViewData viewitemviewdata, ViewItemBaseFragment.ExpandState expandstate)
    {
        super.render(item, viewitemviewdata, expandstate);
        if (item.isMap && !isMAPPriceRevealed)
        {
            isMAPPriceRevealed = userCache.isPriceRevealed(item.getIdString());
        }
        renderTitle();
        if (productReviewLayout != null && item.isProductReviewsAvailable)
        {
            renderReviews();
        }
        renderPrice();
    }


}
