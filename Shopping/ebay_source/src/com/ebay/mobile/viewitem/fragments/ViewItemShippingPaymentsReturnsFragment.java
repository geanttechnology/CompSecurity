// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.LocationAddress;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ShowFileWebViewActivity;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.common.LocalUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.dcs.DcsString;
import com.ebay.mobile.givingworks.GivingWorksCharityActivity;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.PickupUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.viewitem.ItemViewBaseActivity;
import com.ebay.mobile.viewitem.ViewItemChooseVariationsActivity;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemShippingInfo;
import com.ebay.mobile.viewitem.ViewItemShippingPaymentsReturnsActivity;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.shell.app.FwActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemBaseFragment

public class ViewItemShippingPaymentsReturnsFragment extends ViewItemBaseFragment
    implements android.view.View.OnClickListener
{

    private static final int EXPANDED_NUM_SHIPPING_OPTIONS = 4;
    private Activity activity;
    private int backgroundColor;
    private int ebayPadding;
    private int ellipsizeLargeTextCharacterThreshold;
    private LinearLayout expandedLayout;
    private View expandedLayoutContainer;
    private boolean hasInventoryAvailabilities;
    private boolean isSearchRefinedEbn;
    private boolean isSearchRefinedPickup;
    private boolean isShowingBopis;
    private boolean isShowingEbn;
    private boolean needsToPopulateExpanded;
    private boolean needsToPopulateFull;
    private int primaryColor;
    private int secondaryColor;
    private boolean showBopis;
    private boolean showPudo;
    private android.view.View.OnClickListener sprActivityOnClickListener;
    private android.view.View.OnClickListener sprBuyerProtectionOnClickListner;
    private int tertiaryColor;

    public ViewItemShippingPaymentsReturnsFragment()
    {
        hasInventoryAvailabilities = false;
        showBopis = false;
        showPudo = false;
        isSearchRefinedEbn = false;
        isSearchRefinedPickup = false;
        needsToPopulateExpanded = true;
        needsToPopulateFull = true;
        isShowingBopis = false;
        isShowingEbn = false;
    }

    private void addLocalTermsOfService(ViewGroup viewgroup, boolean flag, boolean flag1)
    {
        Object obj = DeviceConfiguration.getAsync();
        String s = ((DeviceConfiguration) (obj)).get(DcsString.BopisTermsLink);
        String s1 = ((DeviceConfiguration) (obj)).get(DcsString.EbayNowTermsOfServiceUrl);
        if (flag && flag1)
        {
            String s2 = getString(SearchUtil.getInStorePickupResourceForCountry(MyApp.getPrefs().getCurrentCountry()));
            String s3 = getString(0x7f070383);
            obj = (new StringBuilder()).append(s2).append("/").append(s3).toString();
            if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
            {
                s = (new StringBuilder()).append(getString(0x7f070478, new Object[] {
                    s, s2
                })).append(" | ").append(getString(0x7f070478, new Object[] {
                    s1, s3
                })).toString();
            } else
            {
                s = (new StringBuilder()).append(s2).append(" | ").append(s3).toString();
            }
        } else
        if (flag)
        {
            obj = getString(SearchUtil.getInStorePickupResourceForCountry(MyApp.getPrefs().getCurrentCountry()));
            if (s != null)
            {
                s = getString(0x7f070478, new Object[] {
                    s, obj
                });
            } else
            {
                s = ((String) (obj));
            }
        } else
        {
            obj = getString(0x7f070383);
            if (s1 != null)
            {
                s = getString(0x7f070478, new Object[] {
                    s1, getString(0x7f070383)
                });
            } else
            {
                s = ((String) (obj));
            }
        }
        viewgroup.addView(Util.createViewItemStatHyperlink(inflater, viewgroup, ((String) (obj)), Html.fromHtml(getString(0x7f070921, new Object[] {
            s
        }))));
    }

    private View addPickupStore(ViewGroup viewgroup, String s)
    {
        ArrayList arraylist = new ArrayList();
        List list = item.inventoryInfo.getAvailabilities();
        Object obj1 = null;
        Object obj = obj1;
        if (list != null)
        {
            obj = obj1;
            if (list.size() > 0)
            {
                int j = Math.min(4, list.size());
                int i = 0;
                while (i < j) 
                {
                    obj = (StoreAvailability)list.get(i);
                    boolean flag;
                    if (i > 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    arraylist.add(getStoreView(viewgroup, ((StoreAvailability) (obj)), flag));
                    i++;
                }
                obj = Util.createViewItemStatList(inflater, viewgroup, s, arraylist);
                viewgroup.addView(((View) (obj)));
            }
        }
        return ((View) (obj));
    }

    private View addView(ViewGroup viewgroup, int i, CharSequence charsequence)
    {
        return addView(viewgroup, i, charsequence, null);
    }

    private View addView(ViewGroup viewgroup, int i, CharSequence charsequence, android.view.View.OnClickListener onclicklistener)
    {
        Object obj = null;
        if (!TextUtils.isEmpty(charsequence))
        {
            LayoutInflater layoutinflater = inflater;
            if (i > 0)
            {
                obj = getString(i);
            } else
            {
                obj = "";
            }
            obj = Util.createViewItemStat(layoutinflater, viewgroup, ((String) (obj)), charsequence, null, onclicklistener);
            viewgroup.addView(((View) (obj)));
        }
        return ((View) (obj));
    }

    private View addView(ViewGroup viewgroup, int i, List list)
    {
        LayoutInflater layoutinflater = inflater;
        String s;
        if (i > 0)
        {
            s = getString(i);
        } else
        {
            s = "";
        }
        list = Util.createViewItemStatList(layoutinflater, viewgroup, s, list);
        viewgroup.addView(list);
        return list;
    }

    private void appendHandlingTime(ViewGroup viewgroup)
    {
        addView(viewgroup, 0x7f0704c0, ViewItemShippingInfo.getHandlingTime(resources, item));
    }

    private void appendLocation(ViewGroup viewgroup)
    {
        addView(viewgroup, 0x7f070b03, item.location);
    }

    private android.view.View.OnClickListener appendPleaseLoginString(SpannableStringBuilder spannablestringbuilder)
    {
        SpannableStringBuilder spannablestringbuilder1 = new SpannableStringBuilder();
        spannablestringbuilder1.append(Util.RenderString(activity.getString(0x7f070501), tertiaryColor, 0));
        appendString(spannablestringbuilder, spannablestringbuilder1);
        return new android.view.View.OnClickListener() {

            final ViewItemShippingPaymentsReturnsFragment this$0;

            public void onClick(View view)
            {
                view = SignInModalActivity.getIntentForSignIn("ViewItem", activity);
                activity.startActivityForResult(view, 11);
            }

            
            {
                this$0 = ViewItemShippingPaymentsReturnsFragment.this;
                super();
            }
        };
    }

    private android.view.View.OnClickListener appendPleaseLoginString(List list)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        spannablestringbuilder.append(Util.RenderString(activity.getString(0x7f070501), tertiaryColor, 0));
        appendShippingView(spannablestringbuilder, list);
        return new android.view.View.OnClickListener() {

            final ViewItemShippingPaymentsReturnsFragment this$0;

            public void onClick(View view)
            {
                view = SignInModalActivity.getIntentForSignIn("ViewItem", activity);
                activity.startActivityForResult(view, 11);
            }

            
            {
                this$0 = ViewItemShippingPaymentsReturnsFragment.this;
                super();
            }
        };
    }

    private void appendPolicy(ViewGroup viewgroup)
    {
        Object obj = new StringBuilder();
        if (!TextUtils.isEmpty(item.rpDescription))
        {
            ((StringBuilder) (obj)).append(item.rpDescription);
        }
        if (!TextUtils.isEmpty(item.rpRestockingFee))
        {
            if (((StringBuilder) (obj)).length() > 0)
            {
                ((StringBuilder) (obj)).append("\n");
            }
            ((StringBuilder) (obj)).append(item.rpRestockingFee);
        }
        obj = Util.getCollapsibleStatValueTextViews(activity, ((StringBuilder) (obj)).toString(), ellipsizeLargeTextCharacterThreshold);
        viewgroup.addView(Util.createViewItemStatCollapsableList(activity, inflater, viewgroup, getString(0x7f0700a6), ((List) (obj))));
    }

    private void appendSalesTax(ViewGroup viewgroup, String s)
    {
        addView(viewgroup, 0x7f070af0, s);
    }

    private void appendShippingView(SpannableStringBuilder spannablestringbuilder, List list)
    {
        appendShippingView(spannablestringbuilder, list, false);
    }

    private void appendShippingView(SpannableStringBuilder spannablestringbuilder, List list, boolean flag)
    {
        TextView textview = new TextView(activity);
        textview.setText(spannablestringbuilder);
        if (flag)
        {
            textview.setPadding(0, ebayPadding, 0, 0);
        }
        list.add(textview);
    }

    private void appendShippingView(CharSequence charsequence, List list)
    {
        appendShippingView(charsequence, list, false);
    }

    private void appendShippingView(CharSequence charsequence, List list, boolean flag)
    {
        TextView textview = new TextView(activity);
        textview.setText(charsequence);
        textview.setIncludeFontPadding(false);
        if (flag)
        {
            textview.setPadding(0, ebayPadding, 0, 0);
        }
        list.add(textview);
    }

    private static boolean appendString(SpannableStringBuilder spannablestringbuilder, CharSequence charsequence)
    {
        boolean flag = false;
        if (!TextUtils.isEmpty(charsequence))
        {
            if (!TextUtils.isEmpty(spannablestringbuilder))
            {
                spannablestringbuilder.append("\n\n");
            }
            spannablestringbuilder.append(charsequence);
            flag = true;
        }
        return flag;
    }

    private View createEbayGuaranteeLayout(ViewGroup viewgroup)
    {
        Object aobj[] = getKeyAndValueForEbp();
        return Util.createViewItemStat(inflater, viewgroup, (String)aobj[0], (CharSequence)aobj[1]);
    }

    private String getAvailabilityTypeDisplayString(com.ebay.common.model.inventory.StoreAvailability.AvailabilityType availabilitytype)
    {
        Resources resources = getResources();
        static class _cls8
        {

            static final int $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[];
            static final int $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemBaseFragment$ExpandState[];
            static final int $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum[];

            static 
            {
                $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType = new int[com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.values().length];
                try
                {
                    $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.IN_STOCK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.OUT_OF_STOCK.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.SHIP_TO_STORE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum = new int[com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.SHIP_TO_HOME.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.GSP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.PUDO.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.ISPU.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.EBN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.LOCAL_PICKUP.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemBaseFragment$ExpandState = new int[ViewItemBaseFragment.ExpandState.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemBaseFragment$ExpandState[ViewItemBaseFragment.ExpandState.COLLAPSED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemBaseFragment$ExpandState[ViewItemBaseFragment.ExpandState.EXPANDED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls8..SwitchMap.com.ebay.common.model.inventory.StoreAvailability.AvailabilityType[availabilitytype.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return resources.getString(0x7f070b39);

        case 2: // '\002'
            return resources.getString(0x7f070b44);

        case 3: // '\003'
            return resources.getString(0x7f070b45);
        }
    }

    private String getBestPostalcode(ViewItemViewData viewitemviewdata, Item item)
    {
        if (viewitemviewdata != null && !TextUtils.isEmpty(viewitemviewdata.searchRefinedPostalCode))
        {
            return viewitemviewdata.searchRefinedPostalCode;
        }
        if (item.buyerPostalCodeSpec != null && !TextUtils.isEmpty(item.buyerPostalCodeSpec.postalCode))
        {
            return item.buyerPostalCodeSpec.postalCode;
        } else
        {
            return null;
        }
    }

    private android.view.View.OnClickListener getBuyerProtectionOnClickListner()
    {
        if (sprBuyerProtectionOnClickListner == null)
        {
            sprBuyerProtectionOnClickListner = new android.view.View.OnClickListener() {

                final ViewItemShippingPaymentsReturnsFragment this$0;

                public void onClick(View view)
                {
                    ShowFileWebViewActivity.startActivity(getActivity(), MyApp.getDeviceConfiguration().buyerProtectionUrl(item.topRatedListing), Integer.valueOf(EbayCountryManager.getBuyerProtectionPageTitle()), "");
                }

            
            {
                this$0 = ViewItemShippingPaymentsReturnsFragment.this;
                super();
            }
            };
        }
        return sprBuyerProtectionOnClickListner;
    }

    private View getDivider()
    {
        View view = new View(activity, null);
        view.setBackgroundColor(backgroundColor);
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, 1);
        layoutparams.setMargins(ebayPadding, 0, ebayPadding, ebayPadding);
        view.setLayoutParams(layoutparams);
        return view;
    }

    private int getETRSBadgeIcon()
    {
        switch (EbaySite.getInstanceFromId(MyApp.getCurrentSite()).idInt)
        {
        default:
            return 0x7f0201d3;

        case 77: // 'M'
            return 0x7f0201d1;
        }
    }

    private CharSequence getEbayNowDeliveryDisplay(boolean flag)
    {
        if (item.isShowEbayNow)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.SERVICE_NAME, primaryColor));
            arraylist.add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.COST, primaryColor));
            arraylist.add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.EDD, secondaryColor));
            return ViewItemShippingInfo.getFormattedEbnShippingOption(getFwActivity().getEbayContext(), item, secondaryColor, arraylist, flag);
        }
        if (isSearchRefinedEbn || !item.isBopisable && ViewItemShippingInfo.getCarrierShippingOptions(item).isEmpty())
        {
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            spannablestringbuilder.append(Util.RenderString(activity.getString(0x7f0704f4), primaryColor, 0)).append('\n');
            spannablestringbuilder.append(Util.RenderString(activity.getString(0x7f0704b6), secondaryColor, 0));
            return spannablestringbuilder;
        } else
        {
            return null;
        }
    }

    private android.view.View.OnClickListener getEbayPlusReturnsClickListener()
    {
        return new android.view.View.OnClickListener() {

            final ViewItemShippingPaymentsReturnsFragment this$0;

            public void onClick(View view)
            {
                ShowWebViewActivity.start(getActivity(), DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.ViewItem.S.ebayPlusReturnsLearnMore), "", null);
            }

            
            {
                this$0 = ViewItemShippingPaymentsReturnsFragment.this;
                super();
            }
        };
    }

    private View getFastAndFree(ViewGroup viewgroup)
    {
        View view = null;
        if (isFastAndFree())
        {
            view = inflater.inflate(0x7f03013a, viewgroup, false);
            ((TextView)view.findViewById(0x7f100317)).setText(Item.getFastAndFreeText());
        }
        return view;
    }

    private View getImportChargeLayout(ViewGroup viewgroup, String s, String s1, boolean flag)
    {
        ViewGroup viewgroup1 = null;
        if (!TextUtils.isEmpty(s))
        {
            viewgroup1 = (ViewGroup)inflater.inflate(0x7f030148, viewgroup, false);
            ((TextView)viewgroup1.findViewById(0x7f10031f)).setText(s, android.widget.TextView.BufferType.SPANNABLE);
            if (!TextUtils.isEmpty(s1))
            {
                viewgroup = (TextView)viewgroup1.findViewById(0x7f100339);
                viewgroup.setText(s1, android.widget.TextView.BufferType.SPANNABLE);
                viewgroup.setVisibility(0);
            }
            if (item.isGspItem && !flag)
            {
                viewgroup1.findViewById(0x7f100338).setVisibility(0);
            }
            viewgroup1.findViewById(0x7f10031e).setOnClickListener(new android.view.View.OnClickListener() {

                final ViewItemShippingPaymentsReturnsFragment this$0;

                public void onClick(View view)
                {
                    ((ItemViewBaseActivity)activity).showGspTermsAndConditions();
                }

            
            {
                this$0 = ViewItemShippingPaymentsReturnsFragment.this;
                super();
            }
            });
            s1 = (TextView)viewgroup1.findViewById(0x7f10033a);
            s = getString(0x7f07008c);
            viewgroup = s;
            if (!flag)
            {
                viewgroup = (new StringBuilder()).append(s).append("\n").append(getString(0x7f07008e)).toString();
            }
            s1.setText(viewgroup);
            if (flag)
            {
                s1.setTextColor(secondaryColor);
            }
        }
        return viewgroup1;
    }

    private View getImportCharges(ViewGroup viewgroup, boolean flag)
    {
        Object obj = null;
        if (!TextUtils.isEmpty(item.displayPriceImportCharges))
        {
            String s = item.displayPriceImportCharges;
            Object obj1 = null;
            obj = obj1;
            if (item.isDisplayPriceCurrencyCode)
            {
                obj = obj1;
                if (item.displayPriceImportChargesCurrency != null)
                {
                    com.ebay.nautilus.domain.data.ItemCurrency itemcurrency = Item.convertCurrency(getFwActivity().getEbayContext(), item.displayPriceImportChargesCurrency);
                    obj = obj1;
                    if (itemcurrency != null)
                    {
                        obj = Item.getApproximateString(activity, itemcurrency).toString();
                    }
                }
            }
            obj = getImportChargeLayout(viewgroup, s, ((String) (obj)), flag);
        }
        return ((View) (obj));
    }

    private CharSequence getInStorePickupDisplay()
    {
        if (showBopis)
        {
            return ViewItemShippingInfo.getBopisSynopsis(activity, primaryColor, secondaryColor);
        }
        if (isSearchRefinedPickup && item.isBopisable || !item.isEbayNowAvailable && ViewItemShippingInfo.getCarrierShippingOptions(item).isEmpty())
        {
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            spannablestringbuilder.append(Util.RenderString(activity.getString(SearchUtil.getInStorePickupResourceForCountry(MyApp.getPrefs().getCurrentCountry())), primaryColor, 0)).append('\n');
            int i = 0x7f0704b6;
            if (item.needsToSelectMultiSku(viewData.nameValueList))
            {
                i = 0x7f07079f;
            }
            spannablestringbuilder.append(Util.RenderString(activity.getString(i), secondaryColor, 0));
            return spannablestringbuilder;
        } else
        {
            return null;
        }
    }

    private Object[] getKeyAndValueForEbp()
    {
        EbaySite.getInstanceFromId(MyApp.getCurrentSite()).idInt;
        JVM INSTR lookupswitch 2: default 36
    //                   3: 149
    //                   77: 65;
           goto _L1 _L2 _L3
_L1:
        Object obj;
        String s;
        s = getString(0x7f070b06);
        obj = getString(0x7f070b04);
_L5:
        return (new Object[] {
            s, obj
        });
_L3:
        if (item.topRatedListing)
        {
            s = getString(0x7f0700d5);
            obj = ViewItemShippingInfo.getFormattedMoneyBackGuaranteeString(getString(0x7f0700d2), getString(0x7f0700d3), primaryColor, secondaryColor);
        } else
        {
            s = getString(0x7f0700d5);
            obj = ViewItemShippingInfo.getFormattedMoneyBackGuaranteeString(getString(0x7f0700d1), getString(0x7f0700d4), primaryColor, secondaryColor);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        s = getString(0x7f0700d6);
        obj = getString(0x7f070b04);
        if (true) goto _L5; else goto _L4
_L4:
    }

    private String getLocalPickupCost()
    {
        Object obj = null;
        String s = obj;
        if (item.shippingInfo.orderedOptions != null)
        {
            s = obj;
            if (item.shippingInfo.orderedOptions.size() > 0)
            {
                Object obj1 = (ShippingCostsShippingOption)item.shippingInfo.orderedOptions.get(0);
                s = obj;
                if (obj1 != null)
                {
                    s = obj;
                    if (((ShippingCostsShippingOption) (obj1)).shippingServiceCost != null)
                    {
                        s = obj;
                        if ((new CurrencyAmount(((ShippingCostsShippingOption) (obj1)).shippingServiceCost)).isGreaterThanZero())
                        {
                            String s1 = EbayCurrencyUtil.formatDisplay(((ShippingCostsShippingOption) (obj1)).shippingServiceCost, 0);
                            s = s1;
                            if (item.isDisplayPriceCurrencyCode)
                            {
                                obj1 = Item.convertCurrency(getFwActivity().getEbayContext(), ((ShippingCostsShippingOption) (obj1)).shippingServiceCost);
                                s = s1;
                                if (obj1 != null)
                                {
                                    s = (new StringBuilder()).append(s1).append("\n").append(EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.ItemCurrency) (obj1)), item.getCurrencyUtilFlag())).toString();
                                }
                            }
                        }
                    }
                }
            }
        }
        return s;
    }

    public static int getPaymentLogoResourceId(EbaySite ebaysite)
    {
        int i = -1;
        EbayCountry ebaycountry = MyApp.getPrefs().getCurrentCountry();
        if (ebaycountry != null && EbaySite.RU.localeCountry.equals(ebaycountry.getCountryCode()))
        {
            i = 0x7f020298;
        } else
        if (ebaysite != null)
        {
            switch (ebaysite.idInt)
            {
            default:
                return -1;

            case 0: // '\0'
                return 0x7f02029a;

            case 71: // 'G'
                return 0x7f020295;

            case 101: // 'e'
                return 0x7f020296;

            case 186: 
                return 0x7f020294;

            case 16: // '\020'
            case 23: // '\027'
            case 123: // '{'
            case 193: 
                return 0x7f020292;

            case 212: 
                return 0x7f020297;

            case 2: // '\002'
            case 210: 
                return 0x7f020293;

            case 3: // '\003'
                return 0x7f020299;
            }
        }
        return i;
    }

    private CharSequence getPickupAndDropoffDisplay(Date date)
    {
        if (showPudo)
        {
            return ViewItemShippingInfo.getPudoSynopsis(activity, primaryColor, secondaryColor, date);
        }
        if (isSearchRefinedPickup && item.isPudoable || !item.isEbayNowAvailable && ViewItemShippingInfo.getCarrierShippingOptions(item).isEmpty())
        {
            date = MyApp.getPrefs().getCurrentCountry();
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            spannablestringbuilder.append(Util.RenderString(activity.getString(LocalUtil.getPudoResourceForCountry(date)), primaryColor, 0)).append('\n');
            int i = 0x7f0704b6;
            if (item.needsToSelectMultiSku(viewData.nameValueList))
            {
                i = 0x7f07079f;
            }
            spannablestringbuilder.append(Util.RenderString(activity.getString(i), secondaryColor, 0));
            return spannablestringbuilder;
        } else
        {
            return null;
        }
    }

    private String getReturnsValueBrief()
    {
        String s;
        EbaySite ebaysite;
        s = item.rpReturnsAccepted;
        ebaysite = MyApp.getPrefs().getCurrentSite();
        if (!isShowHolidayReturns(ebaysite)) goto _L2; else goto _L1
_L1:
        if (!fullExpansion) goto _L4; else goto _L3
_L3:
        s = DateFormat.getMediumDateFormat(activity).format(item.holidayReturnsDate);
_L6:
        return s;
_L4:
        SimpleDateFormat simpledateformat = new SimpleDateFormat("MMM d", Locale.getDefault());
        int i;
        if (ebaysite.equals(EbaySite.US))
        {
            i = 0x7f0703ee;
        } else
        {
            i = 0x7f0703ed;
        }
        return getString(i, new Object[] {
            simpledateformat.format(item.holidayReturnsDate)
        });
_L2:
        if (item.isReturnsNotAccepted)
        {
            return getString(0x7f07068d);
        }
        if (item.isReturnsAccepted)
        {
            if (!TextUtils.isEmpty(item.rpReturnsWithin) && expandState == ViewItemBaseFragment.ExpandState.EXPANDED_ALL)
            {
                return getString(0x7f07011e, new Object[] {
                    item.rpReturnsWithin
                });
            } else
            {
                return getString(0x7f07011d);
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private String getSalesTax()
    {
label0:
        {
            Object obj = null;
            EbayCountry ebaycountry = MyApp.getPrefs().getCurrentCountry();
            String s = obj;
            if (TextUtils.isEmpty(item.salesTaxPercent))
            {
                break label0;
            }
            if (ebaycountry != null)
            {
                s = obj;
                if ("DE".equals(ebaycountry.getCountryCode()))
                {
                    break label0;
                }
            }
            if (item.buyerPostalCodeSpec.stateOrProvince != null)
            {
                s = item.buyerPostalCodeSpec.stateOrProvince;
            } else
            {
                s = "";
            }
            s = getString(0x7f070aef, new Object[] {
                s, item.salesTaxPercent
            });
        }
        return s;
    }

    private View getShippingDiscounts(ViewGroup viewgroup)
    {
        Object obj;
        View view;
        String s;
        view = null;
        s = item.shippingDiscountDesc;
        obj = s;
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        Object obj1;
        if (!item.internationalShippingDiscountProfiles.isEmpty())
        {
            obj = (com.ebay.mobile.Item.ShippingDiscountProfile)item.internationalShippingDiscountProfiles.get(0);
        } else
        {
            obj = null;
        }
        obj1 = item.internationalShippingDiscountName;
        if (ViewItemShippingInfo.areShippingOptionsDomestic(item))
        {
            if (!item.shippingDiscountProfiles.isEmpty())
            {
                obj = (com.ebay.mobile.Item.ShippingDiscountProfile)item.shippingDiscountProfiles.get(0);
            } else
            {
                obj = null;
            }
            obj1 = item.shippingDiscountName;
        }
        if (!"EachAdditionalAmount".equals(obj1) || obj == null || ((com.ebay.mobile.Item.ShippingDiscountProfile) (obj)).eachAdditionalAmount == null) goto _L4; else goto _L3
_L3:
        obj = new CurrencyAmount(((com.ebay.mobile.Item.ShippingDiscountProfile) (obj)).eachAdditionalAmount);
        if (((CurrencyAmount) (obj)).isZero())
        {
            obj = getString(0x7f070b00);
        } else
        {
            obj = getString(0x7f070afd, new Object[] {
                EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj)), 0)
            });
        }
_L2:
        s = item.promotionalShippingDiscountDesc;
        obj1 = s;
        if (TextUtils.isEmpty(s))
        {
            if ("MaximumShippingCostPerOrder".equals(item.psddDiscountName))
            {
                obj1 = getString(0x7f070b0d, new Object[] {
                    EbayCurrencyUtil.formatDisplay(item.psddShippingCost, 0)
                });
            } else
            if ("ShippingCostXForAmountY".equals(item.psddDiscountName) && item.psddShippingCost != null)
            {
                obj1 = new CurrencyAmount(item.psddShippingCost);
                if (((CurrencyAmount) (obj1)).isZero())
                {
                    obj1 = getString(0x7f070b0e, new Object[] {
                        EbayCurrencyUtil.formatDisplay(item.psddOrderAmount, 0)
                    });
                } else
                {
                    obj1 = getString(0x7f070b10, new Object[] {
                        EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj1)), 0), EbayCurrencyUtil.formatDisplay(item.psddOrderAmount, 0)
                    });
                }
            } else
            {
                obj1 = s;
                if ("ShippingCostXForItemCountN".equals(item.psddDiscountName))
                {
                    obj1 = new CurrencyAmount(item.psddShippingCost);
                    if (((CurrencyAmount) (obj1)).isZero())
                    {
                        obj1 = getString(0x7f070b0f, new Object[] {
                            Integer.valueOf(item.psddItemCount)
                        });
                    } else
                    {
                        obj1 = getString(0x7f070b11, new Object[] {
                            EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj1)), 0), Integer.valueOf(item.psddItemCount)
                        });
                    }
                }
            }
        }
        if (TextUtils.isEmpty(((CharSequence) (obj))) || TextUtils.isEmpty(((CharSequence) (obj1)))) goto _L6; else goto _L5
_L5:
        view = inflater.inflate(0x7f030147, viewgroup, false);
        ((TextView)view.findViewById(0x7f100135)).setText(((CharSequence) (obj)));
        ((TextView)view.findViewById(0x7f100137)).setText(((CharSequence) (obj1)));
        obj = new ArrayList();
        ((List) (obj)).add(view);
        obj = Util.createViewItemStatList(inflater, viewgroup, getString(0x7f070a73), ((List) (obj)));
_L8:
        return ((View) (obj));
_L4:
        if ("EachAdditionalAmountOff".equals(obj1) && obj != null && ((com.ebay.mobile.Item.ShippingDiscountProfile) (obj)).eachAdditionalAmountOff != null)
        {
            obj = getString(0x7f070afe, new Object[] {
                EbayCurrencyUtil.formatDisplay(((com.ebay.mobile.Item.ShippingDiscountProfile) (obj)).eachAdditionalAmountOff, 0)
            });
            continue; /* Loop/switch isn't completed */
        }
        if ("EachAdditionalPercentOff".equals(obj1) && obj != null && ((com.ebay.mobile.Item.ShippingDiscountProfile) (obj)).eachAdditionalPercentOff != null)
        {
            obj = getString(0x7f070aff, new Object[] {
                String.format("%3.0f", new Object[] {
                    ((com.ebay.mobile.Item.ShippingDiscountProfile) (obj)).eachAdditionalPercentOff
                })
            });
            continue; /* Loop/switch isn't completed */
        }
        if (!"CombinedItemWeight".equals(obj1) && !"IndividualItemWeight".equals(obj1))
        {
            obj = s;
            if (!"WeightOff".equals(obj1))
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        obj = getString(0x7f070aeb);
        continue; /* Loop/switch isn't completed */
_L6:
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return Util.createViewItemStat(inflater, viewgroup, getString(0x7f070a73), ((CharSequence) (obj)));
        }
        obj = view;
        if (TextUtils.isEmpty(((CharSequence) (obj1)))) goto _L8; else goto _L7
_L7:
        return Util.createViewItemStat(inflater, viewgroup, getString(0x7f070a73), ((CharSequence) (obj1)));
        if (true) goto _L2; else goto _L9
_L9:
    }

    private String getShippingKey()
    {
        if (!item.isEbayNowAvailable && !item.isBopisable && !item.isPudoable) goto _L2; else goto _L1
_L1:
        String s;
        boolean flag1;
        boolean flag2;
        boolean flag;
        if (item.isShowEbayNow || isSearchRefinedEbn)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (showBopis || item.isBopisable && isSearchRefinedPickup)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (showPudo || item.isPudoable && isSearchRefinedPickup)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!ViewItemShippingInfo.getCarrierShippingOptions(item).isEmpty() && !item.isLocalPickupOnly) goto _L4; else goto _L3
_L3:
        if (!flag || !flag1) goto _L6; else goto _L5
_L5:
        s = getString(0x7f070ae8);
_L8:
        return s;
_L6:
        if (flag1)
        {
            return getString(0x7f070b0c);
        } else
        {
            return getString(0x7f070aed);
        }
_L4:
        s = getBestPostalcode(viewData, item);
        if (flag1)
        {
            return getString(0x7f070ae8);
        }
        if (flag2)
        {
            if (s != null)
            {
                return String.format(getString(0x7f070799), new Object[] {
                    s
                });
            } else
            {
                return getString(0x7f070798);
            }
        }
        if (s != null)
        {
            return String.format(getString(0x7f07028c), new Object[] {
                s
            });
        } else
        {
            return getString(0x7f070b1d);
        }
_L2:
        if (item.isLocalPickupOnly)
        {
            return getString(0x7f070b0c);
        }
        String s1 = getString(0x7f0703d8);
        s = s1;
        if (item.isTransacted)
        {
            s = s1;
            if (item.isDelivered)
            {
                return getString(0x7f070288);
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private View getStoreView(ViewGroup viewgroup, StoreAvailability storeavailability, boolean flag)
    {
        viewgroup = inflater.inflate(0x7f03014f, viewgroup, false);
        boolean flag1 = com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.OUT_OF_STOCK.equals(storeavailability.availability);
        TextView textview = (TextView)viewgroup.findViewById(0x7f100352);
        if (flag)
        {
            textview.setText((new StringBuilder()).append("\n").append(storeavailability.address.address1).toString());
        } else
        {
            textview.setText(storeavailability.address.address1);
        }
        textview = (TextView)viewgroup.findViewById(0x7f100353);
        textview.setText(getAvailabilityTypeDisplayString(storeavailability.availability));
        if (flag1)
        {
            textview.setTextColor(viewgroup.getResources().getColor(0x7f0d00f0));
        } else
        {
            textview.setTextColor(viewgroup.getResources().getColor(0x7f0d0063));
        }
        textview = (TextView)viewgroup.findViewById(0x7f100354);
        if (flag1)
        {
            textview.setVisibility(8);
            return viewgroup;
        } else
        {
            textview.setText(PickupUtil.formatFulfillmentTime(activity, storeavailability.fulfillmentTime));
            return viewgroup;
        }
    }

    private android.view.View.OnClickListener getToSprActivityOnClickListener()
    {
        if (sprActivityOnClickListener == null)
        {
            sprActivityOnClickListener = new android.view.View.OnClickListener() {

                final ViewItemShippingPaymentsReturnsFragment this$0;

                public void onClick(View view)
                {
                    if (item.isMultiSku && (item.isPudoable || item.isBopisable || item.isEbayNowAvailable) && !item.hasMultiSkuValues(viewData.nameValueList))
                    {
                        ViewItemChooseVariationsActivity.startActivity(activity, viewData, com.ebay.mobile.viewitem.ViewItemChooseVariationsActivity.IntendedAction.SPR);
                        return;
                    } else
                    {
                        ViewItemShippingPaymentsReturnsActivity.StartActivity(activity, viewData, 19);
                        return;
                    }
                }

            
            {
                this$0 = ViewItemShippingPaymentsReturnsFragment.this;
                super();
            }
            };
        }
        return sprActivityOnClickListener;
    }

    private void handleCharityClick()
    {
        com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit = new com.ebay.common.model.givingworks.NonprofitData.Nonprofit();
        nonprofit.externalId = item.charity.charityNumber;
        nonprofit.name = item.charity.name.decode();
        nonprofit.logoUrl = item.charity.logoURL;
        nonprofit.mission = item.charity.missionStatement.decode();
        Intent intent = new Intent(activity, com/ebay/mobile/givingworks/GivingWorksCharityActivity);
        intent.putExtra("charity_nonprofit", nonprofit);
        activity.startActivity(intent);
    }

    private boolean isDeliveryIndicated()
    {
        return !item.isLocalPickupOnly && !item.isIspuOnly;
    }

    private boolean isFastAndFree()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (item.isShowItemCard)
            {
                break label0;
            }
            Object obj = ViewItemShippingInfo.getCarrierShippingOptions(item);
            flag = flag1;
            if (obj == null)
            {
                break label0;
            }
            obj = ((List) (obj)).iterator();
            do
            {
                flag = flag1;
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!((ShippingCostsShippingOption)((Iterator) (obj)).next()).fastAndFree);
            flag = true;
        }
        return flag;
    }

    private boolean isShowHolidayReturns(EbaySite ebaysite)
    {
        return item.isHolidayReturns && item.holidayReturnsDate != null && (ebaysite.equals(EbaySite.US) || ebaysite.equals(EbaySite.UK));
    }

    private void populateExpandedLayout()
    {
        Object obj;
        Object obj1;
        String s;
        ArrayList arraylist;
        boolean flag;
        expandedLayout.removeAllViews();
        view.findViewById(0x7f1008db).setVisibility(0);
        obj = (TextView)view.findViewById(0x7f1008dc);
        ((TextView) (obj)).setText(0x7f070a75);
        ((TextView) (obj)).setVisibility(0);
        s = getShippingKey();
        arraylist = new ArrayList();
        obj1 = null;
        if (!ViewItemShippingInfo.getCarrierShippingOptions(item).isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!showPleaseSignInValue()) goto _L2; else goto _L1
_L1:
        obj = appendPleaseLoginString(arraylist);
_L4:
        if (arraylist.isEmpty())
        {
            setShippingValueAccretive(arraylist);
        }
        obj = Util.createViewItemStatList(inflater, expandedLayout, s, arraylist, ((android.view.View.OnClickListener) (obj)));
        expandedLayout.addView(((View) (obj)));
        renderAdditionalInfo(expandedLayout);
        return;
_L2:
        if (item.isEbayNowAvailable || item.isBopisable || item.isPudoable)
        {
            if (flag)
            {
                obj = new ArrayList();
                ((List) (obj)).add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.SERVICE_NAME, primaryColor));
                ((List) (obj)).add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.COST, primaryColor, false));
                ((List) (obj)).add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.EDD, primaryColor, false, true));
                ((List) (obj)).add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.LOCATION, secondaryColor));
                appendShippingView(ViewItemShippingInfo.getUpToEnFormattedShippingOptions(getFwActivity().getEbayContext(), item, 1, secondaryColor, ((List) (obj))), arraylist);
            }
            boolean flag1;
            if (item.isEbayNowAvailable)
            {
                obj = getEbayNowDeliveryDisplay(false);
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    if (!arraylist.isEmpty())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    appendShippingView(((CharSequence) (obj)), arraylist, flag1);
                }
            }
            if (item.isPudoable)
            {
                obj = ViewItemDataManager.getLogisticsPlanTypeAndEstimatedDeliveryDate(item);
                if (!item.ignoreQuantity && flag)
                {
                    obj = getPickupAndDropoffDisplay((Date)((Pair) (obj)).second);
                    if (!arraylist.isEmpty())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    appendShippingView(((CharSequence) (obj)), arraylist, flag1);
                    obj = obj1;
                } else
                if (showPudo)
                {
                    obj = MyApp.getPrefs().getCurrentCountry();
                    arraylist.add(Util.createViewItemStat(inflater, expandedLayout, s, getString(LocalUtil.getPudoResourceForCountry(((EbayCountry) (obj)))), "Debug Est. pickup Oct 4", null));
                    obj = obj1;
                } else
                {
                    obj = obj1;
                    if (item.isMultiSku)
                    {
                        obj = getString(0x7f07079f);
                        boolean flag2;
                        if (!arraylist.isEmpty())
                        {
                            flag2 = true;
                        } else
                        {
                            flag2 = false;
                        }
                        appendShippingView(((CharSequence) (obj)), arraylist, flag2);
                        obj = obj1;
                    }
                }
            } else
            {
                obj = obj1;
                if (item.isBopisable)
                {
                    if (!item.ignoreQuantity && flag)
                    {
                        CharSequence charsequence = getInStorePickupDisplay();
                        obj = obj1;
                        if (!TextUtils.isEmpty(charsequence))
                        {
                            boolean flag3;
                            if (!arraylist.isEmpty())
                            {
                                flag3 = true;
                            } else
                            {
                                flag3 = false;
                            }
                            appendShippingView(charsequence, arraylist, flag3);
                            obj = obj1;
                        }
                    } else
                    if (showBopis)
                    {
                        obj = getString(0x7f070423);
                        boolean flag4;
                        if (!arraylist.isEmpty())
                        {
                            flag4 = true;
                        } else
                        {
                            flag4 = false;
                        }
                        appendShippingView(((CharSequence) (obj)), arraylist, flag4);
                        obj = obj1;
                    } else
                    {
                        obj = obj1;
                        if (item.isMultiSku)
                        {
                            obj = getString(0x7f07079f);
                            boolean flag5;
                            if (!arraylist.isEmpty())
                            {
                                flag5 = true;
                            } else
                            {
                                flag5 = false;
                            }
                            appendShippingView(((CharSequence) (obj)), arraylist, flag5);
                            obj = obj1;
                        }
                    }
                }
            }
        } else
        if (!item.ignoreQuantity && item.isLocalPickupOnly)
        {
            obj = new SpannableStringBuilder(getString(0x7f0700b7));
            if (!item.isShowItemCard)
            {
                String s1 = getLocalPickupCost();
                if (!TextUtils.isEmpty(s1))
                {
                    ((SpannableStringBuilder) (obj)).append("\n").append(s1);
                }
            }
            if (!TextUtils.isEmpty(item.location))
            {
                ((SpannableStringBuilder) (obj)).append("\n").append(ViewItemShippingInfo.getLocationAsFrom(activity, item, secondaryColor));
            }
            boolean flag6;
            if (!arraylist.isEmpty())
            {
                flag6 = true;
            } else
            {
                flag6 = false;
            }
            appendShippingView(((SpannableStringBuilder) (obj)), arraylist, flag6);
            obj = obj1;
        } else
        if (item.isTransacted)
        {
            obj = ViewItemShippingInfo.getEstimatedDeliveryDates(activity, item);
            if (obj[1] != null)
            {
                obj = obj[1];
                boolean flag7;
                if (!arraylist.isEmpty())
                {
                    flag7 = true;
                } else
                {
                    flag7 = false;
                }
                appendShippingView(((CharSequence) (obj)), arraylist, flag7);
                obj = obj1;
            } else
            if (item.isLocalPickupOnly)
            {
                obj = getString(0x7f0700b7);
                boolean flag8;
                if (!arraylist.isEmpty())
                {
                    flag8 = true;
                } else
                {
                    flag8 = false;
                }
                appendShippingView(((CharSequence) (obj)), arraylist, flag8);
                obj = obj1;
            } else
            {
                Object obj2 = ViewItemShippingInfo.getAllShippingOptions(item);
                obj = obj1;
                if (obj2 != null)
                {
                    obj = obj1;
                    if (((List) (obj2)).size() > 0)
                    {
                        obj2 = (ShippingCostsShippingOption)((List) (obj2)).get(0);
                        obj = obj1;
                        if (((ShippingCostsShippingOption) (obj2)).shippingServiceCost != null)
                        {
                            obj = EbayCurrencyUtil.formatDisplay(((ShippingCostsShippingOption) (obj2)).shippingServiceCost, item.getCurrencyUtilFlag());
                            boolean flag9;
                            if (!arraylist.isEmpty())
                            {
                                flag9 = true;
                            } else
                            {
                                flag9 = false;
                            }
                            appendShippingView(((CharSequence) (obj)), arraylist, flag9);
                            obj = obj1;
                        }
                    }
                }
            }
        } else
        {
            obj = obj1;
            if (flag)
            {
                obj = new ArrayList();
                ((List) (obj)).add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.EDD, primaryColor, true, true));
                ((List) (obj)).add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.LOCATION, secondaryColor));
                obj = ViewItemShippingInfo.getUpToEnFormattedShippingOptions(getFwActivity().getEbayContext(), item, 1, secondaryColor, ((List) (obj)));
                boolean flag10;
                if (!arraylist.isEmpty())
                {
                    flag10 = true;
                } else
                {
                    flag10 = false;
                }
                appendShippingView(((CharSequence) (obj)), arraylist, flag10);
                obj = obj1;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void populateFullLayout()
    {
        String s = getBestPostalcode(viewData, item);
        renderPickupFull(s);
        renderDeliveryFull(s);
        renderReturnsFull();
        renderPaymentsFull();
    }

    private void populateLayout()
    {
        Object obj1;
        String s3;
        ArrayList arraylist;
        expandedLayout.removeAllViews();
        view.findViewById(0x7f1008db).setVisibility(0);
        TextView textview = (TextView)view.findViewById(0x7f1008dc);
        textview.setText(0x7f070a75);
        textview.setVisibility(0);
        s3 = getShippingKey();
        obj1 = null;
        arraylist = new ArrayList();
        if (!showPleaseSignInValue()) goto _L2; else goto _L1
_L1:
        Object obj = appendPleaseLoginString(arraylist);
_L4:
        if (arraylist.isEmpty())
        {
            setShippingValueAccretive(arraylist);
        }
        obj = Util.createViewItemStatList(inflater, expandedLayout, s3, arraylist, ((android.view.View.OnClickListener) (obj)));
        expandedLayout.addView(((View) (obj)));
        renderAdditionalInfo(expandedLayout);
        return;
_L2:
        Object obj2;
        boolean flag7;
        obj2 = item.shippingInfo.getOrderedOptions();
        flag7 = item.shippingInfo.isShipToHomeAvailable;
        obj = obj1;
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        obj2 = ((List) (obj2)).iterator();
_L7:
        obj = obj1;
        if (!((Iterator) (obj2)).hasNext()) goto _L4; else goto _L5
_L5:
        obj = (ShippingCostsShippingOption)((Iterator) (obj2)).next();
        if (((ShippingCostsShippingOption) (obj)).logisticsPlanType == null) goto _L7; else goto _L6
_L6:
        switch (_cls8..SwitchMap.com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum[((ShippingCostsShippingOption) (obj)).logisticsPlanType.ordinal()])
        {
        case 1: // '\001'
        case 2: // '\002'
            renderShipToHome(arraylist, ((ShippingCostsShippingOption) (obj)));
            break;

        case 3: // '\003'
            if (item.isPudoable)
            {
                obj = ViewItemShippingInfo.getLogisticsPlanTypeAndEstimatedDeliveryDate(item, ((ShippingCostsShippingOption) (obj)));
                if (!item.ignoreQuantity && flag7)
                {
                    obj = getPickupAndDropoffDisplay((Date)((Pair) (obj)).second);
                    boolean flag;
                    if (!arraylist.isEmpty())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    appendShippingView(((CharSequence) (obj)), arraylist, flag);
                } else
                if (!showPudo && item.isMultiSku)
                {
                    String s = getString(0x7f07079f);
                    boolean flag1;
                    if (!arraylist.isEmpty())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    appendShippingView(s, arraylist, flag1);
                }
            }
            break;

        case 4: // '\004'
            if (item.isBopisable && !item.ignoreQuantity && flag7)
            {
                CharSequence charsequence = getInStorePickupDisplay();
                if (!TextUtils.isEmpty(charsequence))
                {
                    boolean flag2;
                    if (!arraylist.isEmpty())
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    appendShippingView(charsequence, arraylist, flag2);
                }
            } else
            if (showBopis)
            {
                String s1 = getString(0x7f070423);
                boolean flag3;
                if (!arraylist.isEmpty())
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                appendShippingView(s1, arraylist, flag3);
            } else
            if (item.isMultiSku)
            {
                String s2 = getString(0x7f07079f);
                boolean flag4;
                if (!arraylist.isEmpty())
                {
                    flag4 = true;
                } else
                {
                    flag4 = false;
                }
                appendShippingView(s2, arraylist, flag4);
            }
            break;

        case 5: // '\005'
            if (item.isEbayNowAvailable)
            {
                CharSequence charsequence1 = getEbayNowDeliveryDisplay(false);
                if (!TextUtils.isEmpty(charsequence1))
                {
                    boolean flag5;
                    if (!arraylist.isEmpty())
                    {
                        flag5 = true;
                    } else
                    {
                        flag5 = false;
                    }
                    appendShippingView(charsequence1, arraylist, flag5);
                }
            }
            break;

        case 6: // '\006'
            if (!item.ignoreQuantity && item.isLocalPickupOnly)
            {
                SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(getString(0x7f0700b7));
                if (!item.isShowItemCard)
                {
                    String s4 = getLocalPickupCost();
                    if (!TextUtils.isEmpty(s4))
                    {
                        spannablestringbuilder.append("\n").append(s4);
                    }
                }
                if (!TextUtils.isEmpty(item.location))
                {
                    spannablestringbuilder.append("\n").append(ViewItemShippingInfo.getLocationAsFrom(activity, item, secondaryColor));
                }
                boolean flag6;
                if (!arraylist.isEmpty())
                {
                    flag6 = true;
                } else
                {
                    flag6 = false;
                }
                appendShippingView(spannablestringbuilder, arraylist, flag6);
            }
            break;
        }
        if (true) goto _L7; else goto _L8
_L8:
    }

    private void renderAdditionalInfo(LinearLayout linearlayout)
    {
        showFastAndFree(linearlayout);
        Object obj = getReturnsValueBrief();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            linearlayout.addView(Util.createViewItemStat(inflater, linearlayout, getString(0x7f070b13), ((CharSequence) (obj))));
        }
        if (MyApp.getPrefs().getCurrentSite().idInt == EbaySite.DE.idInt && item.paymentMethods != null && !item.paymentMethods.isEmpty())
        {
            obj = Util.getPaymentMethodsAsLocalizedString(item.paymentMethods, false);
            linearlayout.addView(Util.createViewItemStat(inflater, linearlayout, getString(0x7f070b09), ((CharSequence) (obj))));
        }
        setupPrograms(linearlayout);
        setupCoupons(linearlayout);
        view.findViewById(0x7f1008de).setOnClickListener(getToSprActivityOnClickListener());
        if (item.isBuyerProtectionEligible)
        {
            obj = view.findViewById(0x7f1008e1);
            Object aobj[] = getKeyAndValueForEbp();
            ((View) (obj)).setOnClickListener(getBuyerProtectionOnClickListner());
            ((TextView)((View) (obj)).findViewById(0x7f1008e2)).setText((String)aobj[0]);
            ((TextView)((View) (obj)).findViewById(0x7f1008e3)).setText((CharSequence)aobj[1]);
            ((View) (obj)).setVisibility(0);
        }
        obj = getImportCharges(linearlayout, true);
        if (obj != null)
        {
            linearlayout.addView(((View) (obj)));
        }
        if (linearlayout.getChildCount() > 0)
        {
            linearlayout = linearlayout.getChildAt(0);
            int i = getResources().getDimensionPixelSize(0x7f090141);
            linearlayout.setPadding(i, i, i, i);
        }
    }

    private void renderDeliveryFull(String s)
    {
        if (isDeliveryIndicated())
        {
            Object obj = (TextView)this.view.findViewById(0x7f1008e7);
            ViewGroup viewgroup;
            View view;
            boolean flag;
            if (s != null)
            {
                s = String.format(getString(0x7f07028b), new Object[] {
                    s
                });
            } else
            {
                s = getString(0x7f070289);
            }
            ((TextView) (obj)).setText(s);
            ((TextView) (obj)).setVisibility(0);
            viewgroup = (ViewGroup)this.view.findViewById(0x7f1008e8);
            viewgroup.removeAllViews();
            viewgroup.setVisibility(0);
            obj = null;
            if (showPleaseSignInValue())
            {
                s = new SpannableStringBuilder();
                obj = appendPleaseLoginString(s);
            } else
            {
                s = new ArrayList();
                s.add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.EDD, primaryColor));
                s.add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.COST, primaryColor, true));
                s.add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.SERVICE_NAME, secondaryColor));
                s = ViewItemShippingInfo.getUpToEnFormattedShippingOptions(getFwActivity().getEbayContext(), item, 4, secondaryColor, s);
            }
            view = getShippingDiscounts(viewgroup);
            if (view != null)
            {
                LinearLayout linearlayout = new LinearLayout(activity, null);
                linearlayout.setOrientation(1);
                linearlayout.setPadding(0, 0, 0, 0);
                viewgroup.addView(linearlayout);
                linearlayout.addView(view);
            }
            if (!TextUtils.isEmpty(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (isFastAndFree())
                {
                    obj = new ArrayList();
                    View view1 = inflater.inflate(0x7f030294, viewgroup, false);
                    ((TextView)view1.findViewById(0x7f1008cc)).setText(s);
                    ((List) (obj)).add(view1);
                    s = getFastAndFree(viewgroup);
                    s.setPadding(s.getPaddingLeft(), ebayPadding, s.getPaddingRight(), s.getPaddingBottom());
                    ((List) (obj)).add(s);
                    s = addView(viewgroup, 0x7f070b1d, ((List) (obj)));
                } else
                {
                    s = addView(viewgroup, 0x7f070b1d, s, ((android.view.View.OnClickListener) (obj)));
                }
                if (view != null && s != null)
                {
                    s.setPadding(s.getPaddingLeft(), ebayPadding, s.getPaddingRight(), s.getPaddingBottom());
                }
                s = getImportCharges(viewgroup, false);
                if (s != null)
                {
                    viewgroup.addView(s);
                }
                if (item.isEbayNowAvailable)
                {
                    s = addView(viewgroup, 0x7f070aed, getEbayNowDeliveryDisplay(true));
                    boolean flag1;
                    if (s != null)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    isShowingEbn = flag1;
                    if (isShowingEbn && flag)
                    {
                        s.setPadding(s.getPaddingLeft(), ebayPadding, s.getPaddingRight(), s.getPaddingBottom());
                    }
                }
            }
            s = new LinearLayout(activity, null);
            s.setPadding(0, ebayPadding, 0, 0);
            s.setOrientation(1);
            viewgroup.addView(s);
            appendLocation(s);
            if (!item.ignoreQuantity)
            {
                obj = ViewItemShippingInfo.getShipToLocationsAsLocalizedString(resources, item);
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    obj = Util.getCollapsibleStatValueTextViews(activity, ((String) (obj)), ellipsizeLargeTextCharacterThreshold);
                    s.addView(Util.createViewItemStatCollapsableList(activity, inflater, s, getString(0x7f070a7a), ((List) (obj))));
                }
                obj = ViewItemShippingInfo.getExcludedShipLocationsAsLocalizedString(resources, item);
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    obj = Util.getCollapsibleStatValueTextViews(activity, ((String) (obj)), ellipsizeLargeTextCharacterThreshold);
                    s.addView(Util.createViewItemStatCollapsableList(activity, inflater, s, getString(0x7f0703ea), ((List) (obj))));
                }
            }
            appendHandlingTime(s);
            obj = getSalesTax();
            if (obj != null)
            {
                appendSalesTax(s, ((String) (obj)));
            }
        }
    }

    private void renderPaymentsFull()
    {
        if (item.paymentMethods != null && !item.paymentMethods.isEmpty())
        {
            ViewGroup viewgroup = (ViewGroup)view.findViewById(0x7f1008ec);
            viewgroup.removeAllViews();
            LinearLayout linearlayout = new LinearLayout(activity, null);
            linearlayout.setOrientation(1);
            viewgroup.addView(linearlayout);
            Object obj = (LinearLayout)inflater.inflate(0x7f030299, linearlayout, false);
            boolean flag = DeviceConfiguration.getAsync().get(DcsBoolean.featureViewItemPaymentLogos);
            String s1 = setupPaymentMethods(((LinearLayout) (obj)), flag);
            view.findViewById(0x7f1008eb).setVisibility(0);
            ArrayList arraylist = new ArrayList();
            arraylist.add(obj);
            if (flag)
            {
                linearlayout.addView(Util.createViewItemStatFullWidth(inflater, linearlayout, arraylist));
            } else
            {
                addView(linearlayout, 0x7f070b09, arraylist);
            }
            if (!TextUtils.isEmpty(s1))
            {
                addView(linearlayout, 0x7f070752, s1);
            }
            if (item.isEbayPlusEligible && item.isEbayPlusMember)
            {
                addView(linearlayout, 0x7f070375, getString(0x7f07037a));
            }
            if (!TextUtils.isEmpty(item.paymentInstructions))
            {
                obj = Util.getCollapsibleStatValueTextViews(activity, item.paymentInstructions, ellipsizeLargeTextCharacterThreshold);
                linearlayout.addView(Util.createViewItemStatCollapsableList(activity, inflater, linearlayout, getString(0x7f070b08), ((List) (obj))));
            }
            setupPrograms(linearlayout);
            setupCoupons(linearlayout);
            obj = MyApp.getPrefs().getCurrentCountry();
            if ((obj == null || !"DE".equals(((EbayCountry) (obj)).getCountryCode())) && !TextUtils.isEmpty(item.salesTaxPercent))
            {
                String s2 = getString(0x7f070aef);
                String s;
                if (item.buyerPostalCodeSpec.stateOrProvince != null)
                {
                    s = item.buyerPostalCodeSpec.stateOrProvince;
                } else
                {
                    s = "";
                }
                s = String.format(s2, new Object[] {
                    s, item.salesTaxPercent
                });
                linearlayout.addView(Util.createViewItemStat(inflater, linearlayout, getString(0x7f070b1f), s));
            }
            viewgroup.setVisibility(0);
        }
    }

    private void renderPickupFull(String s)
    {
        if (!showBopis && !showPudo && !item.isLocalPickupOnly) goto _L2; else goto _L1
_L1:
        Object obj = (TextView)view.findViewById(0x7f1008e5);
        com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum shippingdisplayorderenum;
        if (s != null)
        {
            s = String.format(getString(0x7f070797), new Object[] {
                s
            });
        } else
        {
            s = getString(0x7f070793);
        }
        ((TextView) (obj)).setText(s);
        ((TextView) (obj)).setVisibility(0);
        s = (ViewGroup)view.findViewById(0x7f1008e6);
        s.removeAllViews();
        s.setVisibility(0);
        if (!item.isLocalPickupOnly) goto _L4; else goto _L3
_L3:
        obj = new ArrayList();
        int i;
        if (!TextUtils.isEmpty(getLocalPickupCost()))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            ((List) (obj)).add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.COST, primaryColor, true));
        }
        shippingdisplayorderenum = com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.SERVICE_NAME;
        if (i != 0)
        {
            i = secondaryColor;
        } else
        {
            i = primaryColor;
        }
        ((List) (obj)).add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(shippingdisplayorderenum, i));
        addView(s, 0x7f070b1d, ViewItemShippingInfo.getUpToEnFormattedShippingOptions(getFwActivity().getEbayContext(), item, 4, secondaryColor, ((List) (obj))));
_L6:
        if (!isDeliveryIndicated())
        {
            s.addView(getDivider());
            appendLocation(s);
            appendHandlingTime(s);
            obj = getSalesTax();
            if (obj != null)
            {
                appendSalesTax(s, ((String) (obj)));
            }
        }
_L2:
        return;
_L4:
        if (item.isBopisable)
        {
            if (showBopis)
            {
                if (hasInventoryAvailabilities)
                {
                    addPickupStore(s, getString(0x7f070b0c));
                } else
                {
                    addView(s, SearchUtil.getInStorePickupResourceForCountry(MyApp.getPrefs().getCurrentCountry()), activity.getString(0x7f070527));
                }
                isShowingBopis = true;
            } else
            if (isSearchRefinedPickup || ViewItemShippingInfo.getCarrierShippingOptions(item).isEmpty())
            {
                CharSequence charsequence = getInStorePickupDisplay();
                addView(s, SearchUtil.getInStorePickupResourceForCountry(MyApp.getPrefs().getCurrentCountry()), charsequence);
                isShowingBopis = true;
            }
        } else
        if (item.isPudoable)
        {
            if (showPudo)
            {
                Object obj1 = MyApp.getPrefs().getCurrentCountry();
                StringBuilder stringbuilder = new StringBuilder();
                if (hasInventoryAvailabilities)
                {
                    Object obj2 = item.inventoryInfo.getAvailabilities();
                    int j = ((List) (obj2)).size();
                    if (j > 0)
                    {
                        stringbuilder.append(activity.getResources().getQuantityString(LocalUtil.getPudoAvailabilitiesResourceForCountry(((EbayCountry) (obj1))), j, new Object[] {
                            Integer.valueOf(j)
                        }));
                        obj2 = (StoreAvailability)((List) (obj2)).get(j - 1);
                        if (obj2 != null)
                        {
                            stringbuilder.append(" ");
                            stringbuilder.append(LocalUtil.getPudoWithinDistanceStringForCountry(activity, ((EbayCountry) (obj1)), ((StoreAvailability) (obj2)).distance));
                        } else
                        {
                            stringbuilder.append(".");
                        }
                        stringbuilder.append(' ');
                    }
                    stringbuilder.append(activity.getString(0x7f07099d));
                    addView(s, LocalUtil.getPudoResourceForCountry(((EbayCountry) (obj1))), stringbuilder.toString());
                    obj1 = ViewItemDataManager.getLogisticsPlanTypeAndEstimatedDeliveryDate(item);
                    if (((Pair) (obj1)).second != null)
                    {
                        addView(s, 0x7f070793, Util.getEstimatedPickupDateString(activity, (Date)((Pair) (obj1)).second, true));
                    }
                } else
                {
                    addView(s, LocalUtil.getPudoResourceForCountry(((EbayCountry) (obj1))), activity.getString(0x7f070527));
                }
            } else
            if (isSearchRefinedPickup || !ViewItemShippingInfo.getCarrierShippingOptions(item).isEmpty());
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void renderReturnsFull()
    {
        String s = getReturnsValueBrief();
        if (!TextUtils.isEmpty(s))
        {
            this.view.findViewById(0x7f1008e9).setVisibility(0);
            ViewGroup viewgroup = (ViewGroup)this.view.findViewById(0x7f1008ea);
            viewgroup.removeAllViews();
            viewgroup.setVisibility(0);
            LinearLayout linearlayout = new LinearLayout(activity, null);
            linearlayout.setOrientation(1);
            viewgroup.addView(linearlayout);
            int i = 0x7f070b13;
            if (isShowHolidayReturns(MyApp.getPrefs().getCurrentSite()))
            {
                i = 0x7f070b24;
            }
            addView(linearlayout, i, s);
            if (!item.ignoreQuantity && !TextUtils.isEmpty(item.rpShippingCostPaidBy))
            {
                addView(linearlayout, 0x7f070b12, item.rpShippingCostPaidBy);
            }
            if (!TextUtils.isEmpty(item.rpRefund))
            {
                addView(linearlayout, 0x7f070b16, item.rpRefund);
            }
            if (!TextUtils.isEmpty(item.rpDescription) || !TextUtils.isEmpty(item.rpRestockingFee))
            {
                appendPolicy(linearlayout);
            }
            if (item.isBuyerProtectionEligible)
            {
                View view = createEbayGuaranteeLayout(linearlayout);
                view.setOnClickListener(getBuyerProtectionOnClickListner());
                linearlayout.addView(view);
            }
            if (item.isEbayPlusEligible && item.isEbayPlusMember)
            {
                View view1 = inflater.inflate(0x7f030289, linearlayout, false);
                view1.findViewById(0x7f1008a4).setOnClickListener(getEbayPlusReturnsClickListener());
                linearlayout.addView(view1);
            }
            if (isShowingBopis || isShowingEbn)
            {
                addLocalTermsOfService(linearlayout, isShowingBopis, isShowingEbn);
            }
        }
    }

    private void renderShipToHome(List list, ShippingCostsShippingOption shippingcostsshippingoption)
    {
        boolean flag5 = true;
        boolean flag6 = true;
        boolean flag7 = true;
        boolean flag8 = true;
        boolean flag = true;
        if (item.isEbayNowAvailable || item.isBopisable || item.isPudoable)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.SERVICE_NAME, primaryColor));
            arraylist.add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.COST, primaryColor, false));
            arraylist.add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.EDD, primaryColor, false, true));
            arraylist.add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.LOCATION, secondaryColor));
            shippingcostsshippingoption = ViewItemShippingInfo.getFormattedShippingNode(getFwActivity().getEbayContext(), item, shippingcostsshippingoption, secondaryColor, arraylist);
            if (list.isEmpty())
            {
                flag = false;
            }
            appendShippingView(shippingcostsshippingoption, list, flag);
        } else
        if (item.isTransacted)
        {
            shippingcostsshippingoption = ViewItemShippingInfo.getEstimatedDeliveryDates(activity, item);
            if (shippingcostsshippingoption[1] != null)
            {
                shippingcostsshippingoption = shippingcostsshippingoption[1];
                boolean flag1;
                if (!list.isEmpty())
                {
                    flag1 = flag5;
                } else
                {
                    flag1 = false;
                }
                appendShippingView(shippingcostsshippingoption, list, flag1);
                return;
            }
            if (item.isLocalPickupOnly)
            {
                shippingcostsshippingoption = getString(0x7f0700b7);
                boolean flag2;
                if (!list.isEmpty())
                {
                    flag2 = flag6;
                } else
                {
                    flag2 = false;
                }
                appendShippingView(shippingcostsshippingoption, list, flag2);
                return;
            }
            shippingcostsshippingoption = ViewItemShippingInfo.getAllShippingOptions(item);
            if (shippingcostsshippingoption != null && shippingcostsshippingoption.size() > 0)
            {
                shippingcostsshippingoption = (ShippingCostsShippingOption)shippingcostsshippingoption.get(0);
                if (shippingcostsshippingoption.shippingServiceCost != null)
                {
                    shippingcostsshippingoption = EbayCurrencyUtil.formatDisplay(shippingcostsshippingoption.shippingServiceCost, item.getCurrencyUtilFlag());
                    boolean flag3;
                    if (!list.isEmpty())
                    {
                        flag3 = flag7;
                    } else
                    {
                        flag3 = false;
                    }
                    appendShippingView(shippingcostsshippingoption, list, flag3);
                    return;
                }
            }
        } else
        {
            ArrayList arraylist1 = new ArrayList();
            arraylist1.add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.EDD, primaryColor, true, true));
            arraylist1.add(new com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder(com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.LOCATION, secondaryColor));
            shippingcostsshippingoption = ViewItemShippingInfo.getFormattedShippingNode(getFwActivity().getEbayContext(), item, shippingcostsshippingoption, secondaryColor, arraylist1);
            boolean flag4;
            if (!list.isEmpty())
            {
                flag4 = flag8;
            } else
            {
                flag4 = false;
            }
            appendShippingView(shippingcostsshippingoption, list, flag4);
            return;
        }
    }

    private void setShippingValueAccretive(List list)
    {
        appendShippingView(item.getShippingMessage(activity, secondaryColor), list);
    }

    private boolean setupCoupons(LinearLayout linearlayout)
    {
        boolean flag2 = false;
        boolean flag1 = flag2;
        if (!item.isAuctionEnded)
        {
            boolean flag;
            if (!TextUtils.isEmpty(item.coupons))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag2;
            if (flag)
            {
                linearlayout.addView(Util.createViewItemStat(inflater, linearlayout, getString(0x7f070493), item.coupons));
                flag1 = true;
            }
        }
        return flag1;
    }

    private String setupPaymentMethods(LinearLayout linearlayout, boolean flag)
    {
        String s;
        String s1;
        Object obj;
        boolean flag1;
        boolean flag2;
        s = null;
        flag2 = false;
        s1 = Util.getPaymentMethodsAsLocalizedString(item.paymentMethods, false);
        obj = MyApp.getPrefs().getCurrentSite();
        flag1 = flag2;
        if (TextUtils.isEmpty(item.availablePaymentMethods)) goto _L2; else goto _L1
_L1:
        flag1 = flag2;
        if (!item.availablePaymentMethods.toLowerCase().contains("paypal")) goto _L2; else goto _L3
_L3:
        int i = -1;
        if (!flag) goto _L5; else goto _L4
_L4:
        i = getPaymentLogoResourceId(((EbaySite) (obj)));
_L7:
        flag1 = flag2;
        if (i != -1)
        {
            obj = (ImageView)linearlayout.findViewById(0x7f1008ed);
            flag1 = flag2;
            if (obj != null)
            {
                ((ImageView) (obj)).setImageResource(i);
                ((ImageView) (obj)).setVisibility(0);
                flag1 = true;
            }
        }
_L2:
        obj = (TextView)linearlayout.findViewById(0x7f1008ee);
        if (flag && flag1)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((TextView) (obj)).setVisibility(i);
        if (flag1)
        {
            s = getString(0x7f070770);
            s = s1.replace((new StringBuilder()).append(s).append(", ").toString(), "").replace(s, "");
        } else
        {
            TextView textview = (TextView)linearlayout.findViewById(0x7f1008ef);
            textview.setText(s1);
            textview.setVisibility(0);
        }
        if (item.autoPay)
        {
            linearlayout = (TextView)linearlayout.findViewById(0x7f1008f0);
            linearlayout.setText(getString(0x7f070763));
            linearlayout.setVisibility(0);
        }
        return s;
_L5:
        if (EbaySite.US.equals(obj) || EbaySite.DE.equals(obj))
        {
            if (EbaySite.DE.equals(obj))
            {
                i = 0x7f02028f;
            } else
            {
                i = 0x7f020290;
            }
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    private boolean setupPrograms(LinearLayout linearlayout)
    {
        boolean flag1;
        boolean flag2;
        flag2 = false;
        Object obj;
        ArrayList arraylist;
        String s;
        String s1;
        SpannableStringBuilder spannablestringbuilder;
        int i;
        boolean flag;
        if (!item.isAuctionEnded && !TextUtils.isEmpty(item.bucksRewards))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (!item.isAuctionEnded && !TextUtils.isEmpty(item.nectarRewards))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i != 0)
        {
            linearlayout.addView(Util.createViewItemStat(inflater, linearlayout, getString(0x7f07019b), Html.fromHtml(getString(0x7f0702a9, new Object[] {
                (new StringBuilder()).append("<b>").append(item.bucksRewards).append("</b>").toString()
            }))));
            flag2 = true;
        }
        flag1 = flag2;
        if (item.charity == null) goto _L2; else goto _L1
_L1:
        flag1 = flag2;
        if (item.charity.name == null) goto _L2; else goto _L3
_L3:
        flag1 = flag2;
        if (item.charity.donationPercentage.doubleValue() <= 0.0D) goto _L2; else goto _L4
_L4:
        if (expandState != ViewItemBaseFragment.ExpandState.EXPANDED_ALL) goto _L6; else goto _L5
_L5:
        flag1 = flag2;
        if (!TextUtils.isEmpty(item.charity.charityWebsite))
        {
            obj = new TextView(activity);
            arraylist = new ArrayList();
            s = item.charity.name.decode();
            s1 = String.format(getString(0x7f070475), new Object[] {
                Integer.valueOf((int)item.charity.donationPercentage.floatValue()), s
            });
            spannablestringbuilder = new SpannableStringBuilder(s1);
            i = s1.indexOf(s);
            if (i != -1)
            {
                spannablestringbuilder.setSpan(new ForegroundColorSpan(tertiaryColor), i, s1.length(), 33);
            }
            ((TextView) (obj)).setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
            ((TextView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                final ViewItemShippingPaymentsReturnsFragment this$0;

                public void onClick(View view)
                {
                    handleCharityClick();
                }

            
            {
                this$0 = ViewItemShippingPaymentsReturnsFragment.this;
                super();
            }
            });
            arraylist.add(obj);
            addView(linearlayout, 0x7f07022d, arraylist);
            flag1 = true;
        }
_L2:
        if (flag)
        {
            obj = inflater.inflate(0x7f03029f, linearlayout, false);
            ((TextView)((View) (obj)).findViewById(0x7f1008f3)).setText(getString(0x7f07064c));
            ((TextView)((View) (obj)).findViewById(0x7f1008f5)).setText(Html.fromHtml(item.nectarRewards));
            linearlayout.addView(((View) (obj)));
            flag1 = true;
        }
        return flag1;
_L6:
        flag1 = flag2;
        if (!item.isHotnessCharity)
        {
            addView(linearlayout, 0x7f07022d, String.format(getString(0x7f070475), new Object[] {
                Integer.valueOf((int)item.charity.donationPercentage.floatValue()), item.charity.name.decode()
            }));
            flag1 = true;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    private void showFastAndFree(ViewGroup viewgroup)
    {
        if (!item.isShowItemCard)
        {
            View view = getFastAndFree(viewgroup);
            if (view != null)
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add(view);
                viewgroup.addView(Util.createViewItemStatList(inflater, viewgroup, "", arraylist));
            }
        }
    }

    private boolean showPleaseSignInValue()
    {
        PostalCodeSpecification postalcodespecification;
        if (!MyApp.getPrefs().isSignedIn())
        {
            if ((postalcodespecification = MyApp.getPrefs().getShipToPostalCode()) == null || TextUtils.isEmpty(postalcodespecification.postalCode))
            {
                return true;
            }
        }
        return false;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setRetainInstance(true);
        activity = getActivity();
        bundle = activity.getTheme();
        int i = ThemeUtil.resolveThemeForegroundColorResId(bundle, 0x1010036);
        int j = ThemeUtil.resolveThemeSecondaryColorResId(bundle, 0x1010038);
        int k = ThemeUtil.resolveThemeSecondaryColorResId(bundle, 0x1010212);
        Resources resources = activity.getResources();
        primaryColor = resources.getColor(i);
        secondaryColor = resources.getColor(j);
        tertiaryColor = resources.getColor(k);
        ellipsizeLargeTextCharacterThreshold = 400;
        if (resources.getBoolean(0x7f0b0006))
        {
            ellipsizeLargeTextCharacterThreshold = 1000;
        }
        ebayPadding = (int)resources.getDimension(0x7f090141);
        backgroundColor = resources.getColor(ThemeUtil.resolveThemeForegroundColorResId(bundle, 0x7f010058));
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131757300 2131757300: default 24
    //                   2131757300 30;
           goto _L1 _L2
_L1:
        super.onClick(view);
_L4:
        return;
_L2:
        if (activity instanceof ItemViewBaseActivity)
        {
            ((ItemViewBaseActivity)activity).showGspTermsAndConditions();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        view = layoutinflater.inflate(0x7f030298, viewgroup, false);
        expandedLayoutContainer = view.findViewById(0x7f1008df);
        expandedLayout = (LinearLayout)view.findViewById(0x7f1008e0);
        setupFragment(view);
        return view;
    }

    protected void render(Item item, ViewItemViewData viewitemviewdata, ViewItemBaseFragment.ExpandState expandstate)
    {
        boolean flag1 = true;
        super.render(item, viewitemviewdata, expandstate);
        boolean flag;
        if (item.inventoryInfo != null && item.inventoryInfo.getAvailabilities() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasInventoryAvailabilities = flag;
        if ((hasInventoryAvailabilities || item.isMultiSku && !item.hasMultiSkuValues(viewitemviewdata.nameValueList)) && item.isBopisable || item.isBopisableAndPurchasedViaBopis)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        showBopis = flag;
        if ((hasInventoryAvailabilities || item.isMultiSku && !item.hasMultiSkuValues(viewitemviewdata.nameValueList)) && item.isPudoable || item.isPudoableAndPurchasedViaPudo)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        showPudo = flag;
        if (viewitemviewdata.searchRefinedShopLocallyFlag == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isSearchRefinedEbn = flag;
        if (viewitemviewdata.searchRefinedShopLocallyFlag == 2)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isSearchRefinedPickup = flag;
        if (item.isShowTopRatedListing && MyApp.getDeviceConfiguration().isTopRatedSellerEnabled() && (expandstate == ViewItemBaseFragment.ExpandState.COLLAPSED || expandstate == ViewItemBaseFragment.ExpandState.EXPANDED))
        {
            item = (ImageView)view.findViewById(0x7f1008dd);
            item.setImageResource(getETRSBadgeIcon());
            item.setVisibility(0);
        }
        switch (_cls8..SwitchMap.com.ebay.mobile.viewitem.fragments.ViewItemBaseFragment.ExpandState[expandstate.ordinal()])
        {
        default:
            if (needsToPopulateFull)
            {
                populateFullLayout();
                needsToPopulateFull = false;
            }
            view.findViewById(0x7f1008de).setVisibility(8);
            view.findViewById(0x7f1008e4).setVisibility(0);
            return;

        case 1: // '\001'
        case 2: // '\002'
            break;
        }
        if (needsToPopulateExpanded)
        {
            populateLayout();
            needsToPopulateExpanded = false;
        }
        view.findViewById(0x7f1008de).setVisibility(0);
        expandedLayoutContainer.setVisibility(0);
    }

    public void setForceReRender()
    {
        needsToPopulateExpanded = true;
        needsToPopulateFull = true;
    }


}
