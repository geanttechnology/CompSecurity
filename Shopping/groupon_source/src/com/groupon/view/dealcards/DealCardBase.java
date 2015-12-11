// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.dealcards;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Html;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.db.models.AbstractDeal;
import com.groupon.db.models.Badge;
import com.groupon.db.models.BookableSegments;
import com.groupon.db.models.DealSummary;
import com.groupon.fragment.RapiSearchResultDomainModelFacade;
import com.groupon.models.Place;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.Dates;
import com.groupon.util.DealUtils;
import com.groupon.util.GeoPoint;
import com.groupon.util.GeoUtils;
import com.groupon.util.ImageUrl;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.LayoutUtil;
import com.groupon.util.LocationsUtil;
import com.groupon.util.UrgencyPricingUtils;
import com.groupon.v3.view.callbacks.DealCardBookingsViewHandler;
import com.groupon.v3.view.param.DealCardWithTimePillClickInfo;
import com.groupon.view.CircleRatingBar;
import com.groupon.view.HasImageView;
import com.groupon.view.UrlImageView;
import com.squareup.picasso.Callback;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view.dealcards:
//            DealCardView, PicassoCallback

public class DealCardBase extends FrameLayout
    implements HasImageView, DealCardView, PicassoCallback
{
    private static class PillClickListener
        implements android.view.View.OnClickListener
    {

        final View dealCardBase;
        final DealCardBookingsViewHandler dealCardBookingsViewHandler;
        final DealSummary dealSummary;

        public void onClick(View view)
        {
            dealCardBookingsViewHandler.onDealClick(dealCardBase, new DealCardWithTimePillClickInfo(dealSummary, view));
        }

        public PillClickListener(DealCardBase dealcardbase, DealCardBookingsViewHandler dealcardbookingsviewhandler, DealSummary dealsummary)
        {
            dealCardBase = dealcardbase;
            dealCardBookingsViewHandler = dealcardbookingsviewhandler;
            dealSummary = dealsummary;
        }
    }


    private AbTestService abTestService;
    protected LinearLayout badgesContainer;
    protected TextView badgesLargeDealCardTextView;
    protected TextView badgesSmallDealCardTextView;
    protected CurrencyFormatter currencyFormatter;
    protected CurrentCountryManager currentCountryManager;
    private DealCardBookingsViewHandler dealCardBookingsViewHandler;
    private String dealEndedText;
    protected UrlImageView dealImageView;
    protected TextView dealIncentiveTitle;
    protected TextView dealsBoughtView;
    private DateFormat dtfDateTime;
    protected TextView gbucksTextView;
    private GeoUtils geoUtils;
    protected TextView goodsConnectedMarketPlace;
    private IncentivesUtil incentivesUtil;
    private boolean isGoodsConnectedMarketPlace1504;
    protected boolean isGoodsShoppingChannel;
    private boolean isMobileOnly1403USCA;
    private boolean isUSACompatible;
    protected LayoutUtil layoutUtil;
    protected TextView locationTextView;
    protected TextView mobileOnly;
    private View newSoldOutBannerContainer;
    private TextView newSoldOutBannerText;
    protected TextView pitchTextView1;
    protected TextView pitchTextView2;
    protected TextView raoOfferDiscountTextView;
    protected TextView raoOfferTextView;
    protected CircleRatingBar ratingBar;
    private RapiSearchResultDomainModelFacade searchDomainModelFacade;
    private List showedTimePills;
    private String soldOutText;
    private List timePills;
    private LinearLayout timePillsContainer;
    protected TextView titleView;
    protected TextView urgencyPricingLabel;

    public DealCardBase(Context context)
    {
        this(context, ((AttributeSet) (null)));
    }

    public DealCardBase(Context context, int i)
    {
        super(context);
        timePills = new ArrayList();
        showedTimePills = new ArrayList();
        inflate(context, i, this);
        onFinishInflate();
    }

    public DealCardBase(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DealCardBase(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        timePills = new ArrayList();
        showedTimePills = new ArrayList();
    }

    private void displayView(View view, boolean flag)
    {
        if (view == null)
        {
            return;
        }
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    private boolean fillTimePillContent(DealSummary dealsummary)
    {
        boolean flag2 = false;
        boolean flag = false;
        boolean flag1 = flag2;
        if (timePillsContainer != null)
        {
            for (int i = 0; i < timePills.size(); i++)
            {
                ((TextView)timePills.get(i)).setVisibility(8);
            }

            flag1 = flag2;
            if (searchDomainModelFacade != null)
            {
                flag1 = flag2;
                if (searchDomainModelFacade.isMakeAReservationToggled())
                {
                    flag1 = flag2;
                    if (dealCardBookingsViewHandler != null)
                    {
                        SimpleDateFormat simpledateformat = new SimpleDateFormat("h:mm aa");
                        int k = Math.min(dealsummary.bookableSegments.size(), timePills.size());
                        showedTimePills = new ArrayList();
                        int j = 0;
                        do
                        {
                            flag1 = flag;
                            if (j >= k)
                            {
                                break;
                            }
                            BookableSegments bookablesegments = (BookableSegments)dealsummary.bookableSegments.get(j);
                            flag1 = flag;
                            if (bookablesegments != null)
                            {
                                flag1 = flag;
                                if (Dates.isSameDay(bookablesegments.startsAt, searchDomainModelFacade.getReservationDate()))
                                {
                                    ((TextView)timePills.get(j)).setText(simpledateformat.format(bookablesegments.startsAt));
                                    ((TextView)timePills.get(j)).setVisibility(0);
                                    ((TextView)timePills.get(j)).setTag(0x7f10002c, bookablesegments.uuid);
                                    ((TextView)timePills.get(j)).setTag(0x7f10002a, bookablesegments.startsAt);
                                    ((TextView)timePills.get(j)).setTag(0x7f10002b, new Integer(j));
                                    ((TextView)timePills.get(j)).setOnClickListener(new PillClickListener(this, dealCardBookingsViewHandler, dealsummary));
                                    showedTimePills.add(dtfDateTime.format(bookablesegments.startsAt));
                                    flag1 = true;
                                }
                            }
                            j++;
                            flag = flag1;
                        } while (true);
                    }
                }
            }
        }
        return flag1;
    }

    private String getLocation(boolean flag, AbstractDeal abstractdeal, List list, Resources resources, GeoUtils geoutils)
    {
        list = LocationsUtil.getLocation(flag, currentCountryManager.getCurrentCountry().isJapan(), abstractdeal, list, resources, geoutils, true);
        abstractdeal = list;
        if (list.contains("null"))
        {
            abstractdeal = "";
        }
        return abstractdeal;
    }

    private void setBadges(DealSummary dealsummary)
    {
        dealsummary = dealsummary.badges.iterator();
        do
        {
            if (!dealsummary.hasNext())
            {
                break;
            }
            Badge badge = (Badge)dealsummary.next();
            if (!DealUtils.isBadgeValid(badge))
            {
                continue;
            }
            setBadges(((CharSequence) (badge.text)), Color.parseColor(badge.secondaryColor), Color.parseColor(badge.primaryColor));
            break;
        } while (true);
    }

    private boolean shouldDisplayBadges(DealSummary dealsummary, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        boolean flag4;
        if (!dealsummary.badges.isEmpty() && dealsummary.getBooleanAttr("is_show_badge_ab_test_on").booleanValue() && !flag)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        flag = validateBadgeAttribute(dealsummary);
        if (badgesSmallDealCardTextView == null) goto _L2; else goto _L1
_L1:
        if (!flag4 || !flag || flag1 || flag2 || flag3) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (badgesLargeDealCardTextView != null)
        {
            if (!flag4 || !flag)
            {
                return false;
            }
        } else
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private boolean shouldDisplayBought(DealSummary dealsummary, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        if (badgesLargeDealCardTextView != null)
        {
            flag4 = false;
        }
        return dealsummary.getDisplayOption("quantity", true) && dealsummary.soldQuantity != 0 && (flag || !flag1 && !flag2 && !flag3 && !flag4);
    }

    private boolean shouldDisplayDiscount(DealSummary dealsummary)
    {
        return dealsummary.getDisplayOption("discount", true) && dealsummary.derivedDiscountPercent > 0;
    }

    private boolean shouldDisplayGoodsConnectedMarketplace(DealSummary dealsummary, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        if (badgesLargeDealCardTextView != null)
        {
            flag3 = false;
        }
        return isGoodsConnectedMarketPlace1504 && dealsummary.isConnectedMarketPlaceDeal && Strings.notEmpty(dealsummary.connectedMarketPlaceDisplayText) && !flag && !flag1 && !flag2 && !flag3;
    }

    private boolean shouldDisplayIncentive(DealSummary dealsummary, boolean flag, boolean flag1, boolean flag2)
    {
        return !flag1 && !flag2 && Strings.notEmpty(incentivesUtil.getIncentiveShortTitle(dealsummary, flag));
    }

    private boolean shouldDisplayMobileOnly(DealSummary dealsummary)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (isMobileOnly1403USCA)
        {
            flag = flag1;
            if (dealsummary.getDisplayOption("platformExclusive", false))
            {
                flag = true;
            }
        }
        return flag;
    }

    private boolean shouldDisplayUrgencyPricing(DealSummary dealsummary, boolean flag, boolean flag1)
    {
        return !flag1 && flag && isUSACompatible && UrgencyPricingUtils.getUrgencyPricingAvailability(dealsummary) != null;
    }

    private boolean validateBadgeAttribute(DealSummary dealsummary)
    {
        dealsummary = dealsummary.badges.iterator();
_L2:
        Badge badge;
        if (!dealsummary.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        badge = (Badge)dealsummary.next();
        if (!DealUtils.isBadgeValid(badge))
        {
            continue; /* Loop/switch isn't completed */
        }
        Color.parseColor(badge.primaryColor);
        Color.parseColor(badge.secondaryColor);
        return true;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
        return false;
    }

    public void alignViewsRtl()
    {
        layoutUtil.setStartViewEndView(locationTextView, pitchTextView2);
        layoutUtil.setStartViewEndView(urgencyPricingLabel, pitchTextView1);
        layoutUtil.setStartViewEndView(mobileOnly, pitchTextView1);
        layoutUtil.setStartViewEndView(dealIncentiveTitle, pitchTextView1);
        layoutUtil.setStartViewEndView(gbucksTextView, pitchTextView1);
        layoutUtil.setStartViewEndView(raoOfferTextView, pitchTextView1);
        layoutUtil.setStartViewEndView(goodsConnectedMarketPlace, pitchTextView1);
        layoutUtil.setDrawableStart(mobileOnly, 0x7f020286);
    }

    public void displayOption(DealCardView.DisplayOption displayoption, boolean flag)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[];

            static 
            {
                $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption = new int[DealCardView.DisplayOption.values().length];
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.LOCATION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.INCENTIVE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.PRICE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.REFERENCE_PRICE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.G_BUCKS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.RAO_OFFER.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.RAO_DISCOUNT.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.MOBILE_ONLY.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.URGENT_INFO.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.RATING.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.BOUGHTS.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.SOLD_OUT.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.GOODS_CONNECTED_MARKETPLACE.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.BADGES.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[DealCardView.DisplayOption.DATE_TIME_SEARCH_TIME_PILLS.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.groupon.view.dealcards.DealCardView.DisplayOption[displayoption.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            displayView(locationTextView, flag);
            return;

        case 2: // '\002'
            displayView(dealIncentiveTitle, flag);
            return;

        case 3: // '\003'
            displayView(pitchTextView1, flag);
            return;

        case 4: // '\004'
            displayView(pitchTextView2, flag);
            return;

        case 5: // '\005'
            displayView(gbucksTextView, flag);
            return;

        case 6: // '\006'
            displayView(raoOfferTextView, flag);
            return;

        case 7: // '\007'
            displayView(raoOfferDiscountTextView, flag);
            return;

        case 8: // '\b'
            displayView(mobileOnly, flag);
            return;

        case 9: // '\t'
            displayView(urgencyPricingLabel, flag);
            return;

        case 10: // '\n'
            displayView(ratingBar, flag);
            return;

        case 11: // '\013'
            displayView(dealsBoughtView, flag);
            return;

        case 12: // '\f'
            displayView(newSoldOutBannerContainer, flag);
            displayView(newSoldOutBannerText, flag);
            return;

        case 13: // '\r'
            displayView(goodsConnectedMarketPlace, flag);
            return;

        case 14: // '\016'
            if (badgesSmallDealCardTextView != null)
            {
                displayView(badgesSmallDealCardTextView, flag);
                displayView(badgesContainer, flag);
                return;
            } else
            {
                displayView(badgesLargeDealCardTextView, flag);
                displayView(badgesContainer, flag);
                return;
            }

        case 15: // '\017'
            displayView(timePillsContainer, flag);
            return;
        }
    }

    protected int getDefaultImageViewHeight()
    {
        return getResources().getDimensionPixelSize(0x7f0b00ca);
    }

    protected int getDefaultImageViewWidth()
    {
        return getResources().getDisplayMetrics().widthPixels - getResources().getDimensionPixelSize(0x7f0b0039) * 2;
    }

    public UrlImageView getImageView()
    {
        return dealImageView;
    }

    public com.groupon.util.ViewUtils.Size getImageViewSize()
    {
        int j = dealImageView.getWidth();
        int k = dealImageView.getHeight();
        int i = j;
        if (j == 0)
        {
            i = getDefaultImageViewWidth();
        }
        j = k;
        if (k == 0)
        {
            j = getDefaultImageViewHeight();
        }
        return new com.groupon.util.ViewUtils.Size(i, j);
    }

    public List getShowedTimePills()
    {
        return showedTimePills;
    }

    protected void onFinishInflate()
    {
        boolean flag1 = true;
        super.onFinishInflate();
        boolean flag;
        if (!isInEditMode())
        {
            RoboGuice.getInjector(getContext()).injectMembers(this);
            isUSACompatible = currentCountryManager.getCurrentCountry().isUSACompatible();
            if (currentCountryManager.getCurrentCountry().isUSACompatible() && abTestService.isVariantEnabled("mobileOnly1403USCA", "on"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isMobileOnly1403USCA = flag;
            if (currentCountryManager.getCurrentCountry().isUSACompatible() && abTestService.isVariantEnabled("goodsConnectedMarketplaceUSCA1504", "on"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isGoodsConnectedMarketPlace1504 = flag;
            soldOutText = getContext().getString(0x7f0803b3);
            dealEndedText = getContext().getString(0x7f080125);
        }
        dealImageView = (UrlImageView)findViewById(0x7f100121);
        titleView = (TextView)findViewById(0x7f10007a);
        pitchTextView1 = (TextView)findViewById(0x7f10021f);
        pitchTextView2 = (TextView)findViewById(0x7f10021e);
        locationTextView = (TextView)findViewById(0x7f100226);
        urgencyPricingLabel = (TextView)findViewById(0x7f100193);
        mobileOnly = (TextView)findViewById(0x7f100220);
        gbucksTextView = (TextView)findViewById(0x7f100229);
        raoOfferTextView = (TextView)findViewById(0x7f100235);
        raoOfferDiscountTextView = (TextView)findViewById(0x7f100236);
        dealsBoughtView = (TextView)findViewById(0x7f100227);
        newSoldOutBannerContainer = findViewById(0x7f100230);
        newSoldOutBannerText = (TextView)findViewById(0x7f100231);
        dealIncentiveTitle = (TextView)findViewById(0x7f10022a);
        badgesLargeDealCardTextView = (TextView)findViewById(0x7f100224);
        badgesSmallDealCardTextView = (TextView)findViewById(0x7f100239);
        goodsConnectedMarketPlace = (TextView)findViewById(0x7f100228);
        badgesContainer = (LinearLayout)findViewById(0x7f100223);
        ratingBar = (CircleRatingBar)findViewById(0x7f100234);
        timePillsContainer = (LinearLayout)findViewById(0x7f10022c);
        timePills.add((TextView)findViewById(0x7f10022d));
        timePills.add((TextView)findViewById(0x7f10022e));
        timePills.add((TextView)findViewById(0x7f10022f));
        if (!currentCountryManager.getCurrentCountry().isJapan())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        strikeReferencePrice(flag);
        alignViewsRtl();
    }

    public void setBadges(CharSequence charsequence, int i, int j)
    {
        TextView textview = null;
        if (badgesSmallDealCardTextView == null) goto _L2; else goto _L1
_L1:
        textview = badgesSmallDealCardTextView;
_L4:
        if (textview != null)
        {
            textview.setText(charsequence);
            textview.setTextColor(i);
            textview.setBackgroundColor(j);
        }
        return;
_L2:
        if (badgesLargeDealCardTextView != null)
        {
            textview = badgesLargeDealCardTextView;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setBoughts(CharSequence charsequence)
    {
        if (dealsBoughtView == null)
        {
            return;
        } else
        {
            dealsBoughtView.setText(charsequence);
            return;
        }
    }

    public void setCallback(Callback callback)
    {
        dealImageView.setCallback(callback);
    }

    public void setGBucks(CharSequence charsequence)
    {
        if (gbucksTextView == null)
        {
            return;
        } else
        {
            gbucksTextView.setText(charsequence);
            return;
        }
    }

    public void setGoodsConnectedMarketPlaceText(CharSequence charsequence)
    {
        if (goodsConnectedMarketPlace == null)
        {
            return;
        } else
        {
            goodsConnectedMarketPlace.setText(charsequence);
            return;
        }
    }

    public void setImage(ImageUrl imageurl)
    {
        dealImageView.setImageUrl(imageurl);
    }

    public void setIncentiveText(CharSequence charsequence)
    {
        if (dealIncentiveTitle == null)
        {
            return;
        } else
        {
            dealIncentiveTitle.setText(charsequence);
            return;
        }
    }

    public void setInfoWithPlace(DealSummary dealsummary, GeoPoint geopoint)
    {
        ArrayList arraylist = new ArrayList();
        if (geopoint != null)
        {
            arraylist.add(new Place("", geopoint.getLatitudeDegrees(), geopoint.getLongitudeDegrees()));
        }
        setInfoWithPlaces(dealsummary, arraylist);
    }

    public void setInfoWithPlaces(DealSummary dealsummary, List list)
    {
        isGoodsShoppingChannel = DealUtils.isGoodsShoppingDeal(dealsummary);
        boolean flag1 = shouldDisplayMobileOnly(dealsummary);
        boolean flag = shouldDisplayDiscount(dealsummary);
        boolean flag2 = shouldDisplayUrgencyPricing(dealsummary, flag, flag1);
        boolean flag3 = DealUtils.isSoldOutOrClosed(dealsummary);
        boolean flag4 = shouldDisplayIncentive(dealsummary, flag3, flag1, flag2);
        boolean flag6 = shouldDisplayBadges(dealsummary, flag3, flag1, flag2, flag4);
        boolean flag7 = shouldDisplayBought(dealsummary, isGoodsShoppingChannel, flag2, flag4, flag1, flag6);
        boolean flag5 = shouldDisplayGoodsConnectedMarketplace(dealsummary, flag2, flag4, flag1, flag6);
        Object obj;
        Object obj1;
        int i;
        if (Strings.notEmpty(dealsummary.announcementTitle))
        {
            obj = dealsummary.announcementTitle;
        } else
        {
            obj = dealsummary.title;
        }
        setTitle(((CharSequence) (obj)));
        if (Strings.notEmpty(dealsummary.derivedImageUrl))
        {
            obj = new ImageUrl(dealsummary.derivedImageUrl, true);
        } else
        {
            obj = new ImageUrl(dealsummary.largeImageUrl, false);
        }
        setImage(((ImageUrl) (obj)));
        if (dealsummary.isSoldOut)
        {
            obj = soldOutText;
        } else
        {
            obj = dealEndedText;
        }
        setSoldOutText(((CharSequence) (obj)));
        displayOption(DealCardView.DisplayOption.SOLD_OUT, flag3);
        if (flag7)
        {
            i = dealsummary.soldQuantity;
            obj = dealsummary.soldQuantityMessage;
            if (!currentCountryManager.getCurrentCountry().isJapan())
            {
                obj1 = getResources();
                if (i < 100 || !Strings.notEmpty(obj))
                {
                    obj = Integer.valueOf(i);
                }
                obj = ((Resources) (obj1)).getQuantityString(0x7f0c0001, i, new Object[] {
                    obj
                });
            }
            setBoughts(((CharSequence) (obj)));
        }
        displayOption(DealCardView.DisplayOption.BOUGHTS, flag7);
        if (flag6)
        {
            setBadges(dealsummary);
        }
        displayOption(DealCardView.DisplayOption.BADGES, flag6);
        i = dealsummary.derivedMinimumPurchaseQuantity;
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            obj = getContext().getString(0x7f080134, new Object[] {
                Integer.valueOf(dealsummary.derivedDiscountPercent)
            });
        } else
        {
            obj = currencyFormatter.formatWithQuantity(dealsummary.derivedValueAmount, dealsummary.derivedValueCurrencyCode, i, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
        }
        obj1 = currencyFormatter.formatWithQuantity(dealsummary.derivedPriceAmount, dealsummary.derivedPriceCurrencyCode, i, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
        if (dealsummary.isTravelBookableDeal && !currentCountryManager.getCurrentCountry().isJapan())
        {
            setPrice(Html.fromHtml(getContext().getString(0x7f080121, new Object[] {
                obj1
            })));
        } else
        {
            setPrice(((CharSequence) (obj1)));
        }
        obj1 = getResources();
        if (flag2)
        {
            i = 0x7f0e0144;
        } else
        {
            i = 0x7f0e019a;
        }
        setPriceColor(((Resources) (obj1)).getColor(i));
        setReferencePrice(((CharSequence) (obj)));
        displayOption(DealCardView.DisplayOption.REFERENCE_PRICE, flag);
        setLocation(getLocation(currentCountryManager.getCurrentCountry().usesMetricSystem(), dealsummary, list, getResources(), geoUtils));
        list = DealCardView.DisplayOption.LOCATION;
        if (!isGoodsShoppingChannel)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        displayOption(list, flag);
        setIncentiveText(incentivesUtil.getIncentiveShortTitle(dealsummary, flag3));
        displayOption(DealCardView.DisplayOption.INCENTIVE, flag4);
        setUrgentInfo(dealsummary.derivedPricingMetadataOfferLabelDescriptive);
        displayOption(DealCardView.DisplayOption.URGENT_INFO, flag2);
        displayOption(DealCardView.DisplayOption.MOBILE_ONLY, flag1);
        displayOption(DealCardView.DisplayOption.G_BUCKS, false);
        displayOption(DealCardView.DisplayOption.RAO_OFFER, false);
        displayOption(DealCardView.DisplayOption.GOODS_CONNECTED_MARKETPLACE, flag5);
        if (flag5)
        {
            list = dealsummary.connectedMarketPlaceDisplayText;
            setPriceColor(getResources().getColor(0x7f0e00ee));
            setGoodsConnectedMarketPlaceText(list);
        }
        flag = fillTimePillContent(dealsummary);
        displayOption(DealCardView.DisplayOption.DATE_TIME_SEARCH_TIME_PILLS, flag);
    }

    public void setLocation(CharSequence charsequence)
    {
        if (locationTextView == null)
        {
            return;
        } else
        {
            locationTextView.setText(charsequence);
            return;
        }
    }

    public void setPillsCallback(DealCardBookingsViewHandler dealcardbookingsviewhandler)
    {
        dealCardBookingsViewHandler = dealcardbookingsviewhandler;
    }

    public void setPrice(CharSequence charsequence)
    {
        pitchTextView1.setText(charsequence);
    }

    public void setPriceColor(int i)
    {
        pitchTextView1.setTextColor(i);
    }

    public void setRapiSearchResultDomainModelFacade(RapiSearchResultDomainModelFacade rapisearchresultdomainmodelfacade)
    {
        searchDomainModelFacade = rapisearchresultdomainmodelfacade;
    }

    public void setRating(double d)
    {
        if (ratingBar == null)
        {
            return;
        } else
        {
            ratingBar.setRating(d);
            return;
        }
    }

    public void setReferencePrice(CharSequence charsequence)
    {
        if (pitchTextView2 == null)
        {
            return;
        } else
        {
            pitchTextView2.setText(charsequence);
            return;
        }
    }

    public void setSoldOutText(CharSequence charsequence)
    {
        if (newSoldOutBannerText == null)
        {
            return;
        } else
        {
            newSoldOutBannerText.setText(charsequence);
            return;
        }
    }

    public void setTitle(CharSequence charsequence)
    {
        titleView.setText(charsequence);
    }

    public void setUrgentInfo(CharSequence charsequence)
    {
        if (urgencyPricingLabel == null)
        {
            return;
        } else
        {
            urgencyPricingLabel.setText(charsequence);
            return;
        }
    }

    public void strikePrice(boolean flag)
    {
        if (pitchTextView1 == null)
        {
            return;
        }
        if (flag)
        {
            pitchTextView1.setPaintFlags(pitchTextView1.getPaintFlags() | 0x10);
            return;
        } else
        {
            pitchTextView1.setPaintFlags(pitchTextView1.getPaintFlags() & 0xffffffef);
            return;
        }
    }

    public void strikeReferencePrice(boolean flag)
    {
        if (pitchTextView2 == null)
        {
            return;
        }
        if (flag)
        {
            pitchTextView2.setPaintFlags(pitchTextView2.getPaintFlags() | 0x10);
            return;
        } else
        {
            pitchTextView2.setPaintFlags(pitchTextView2.getPaintFlags() & 0xffffffef);
            return;
        }
    }
}
