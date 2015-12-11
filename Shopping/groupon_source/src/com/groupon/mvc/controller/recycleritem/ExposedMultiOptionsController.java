// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.callbacks.DefaultOnExposedOptionsEventListener;
import com.groupon.callbacks.OnExposedOptionsEventListener;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.db.models.PricingMetadata;
import com.groupon.models.DateTimeFinderReservationDetails;
import com.groupon.models.country.Country;
import com.groupon.models.nst.ClickExtraInfo;
import com.groupon.models.nst.MultiOptionClickExtraInfo;
import com.groupon.models.nst.MultiOptionImpressionExtraInfo;
import com.groupon.mvc.model.ExposedMultiOptions;
import com.groupon.mvc.model.OptionCardData;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BookingUtil;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.DealUtils;
import com.groupon.util.LoggingUtils;
import com.groupon.util.UrgencyPricingUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class ExposedMultiOptionsController extends RecyclerItemViewController
{
    private class OnOptionsEventListener extends DefaultOnExposedOptionsEventListener
    {

        final ExposedMultiOptionsController this$0;

        public void onAllOptionsButtonClick(View view)
        {
            ClickExtraInfo clickextrainfo = new ClickExtraInfo();
            view = null;
            if (shouldEnableDateTimeFinder())
            {
                view = bookingUtil.createDateTimeFinderSchedulerIntent(dateTimeFinderReservationDetails, deal, option.remoteId, defaultOptionIdForExposedMultiOptions, channel, false, false);
                view.removeExtra("channel");
            }
            clickextrainfo.pageId = pageViewId;
            logger.logClick("", "view_all_options_click", channel.toString(), Logger.NULL_NST_FIELD, clickextrainfo);
            view = intentFactory.newMultiOptionIntent(channel, deal.remoteId, view).putExtra("multi_option_selection", true).putExtra("defaultOptionId", defaultOptionIdForExposedMultiOptions).putExtra("isDeepLinked", isDeepLinked);
            context.startActivity(view);
        }

        public void onOptionSelectionChange(String s)
        {
            if (onExposedOptionsEventListener != null)
            {
                onExposedOptionsEventListener.onOptionSelectionChange(s);
            }
            logger.logClick("", "deal_option_click", channel.toString(), Logger.NULL_NST_FIELD, new MultiOptionClickExtraInfo(pageViewId, defaultOptionIdForExposedMultiOptions, s));
            String s1;
            ArrayList arraylist;
            if (gdt1503USCAEnabled)
            {
                if (option.specificAttributeDelivery || option.specificAttributeTakeout)
                {
                    s1 = "on";
                } else
                {
                    s1 = "off";
                }
            } else
            {
                s1 = "";
            }
            arraylist = deal.getOptions();
            logger.logMultiOption("", deal.remoteId, s, arraylist.size(), arraylist.indexOf(option), loggingUtils.getMultiOptionExtraInfoString(s1, pageViewId));
        }

        private OnOptionsEventListener()
        {
            this$0 = ExposedMultiOptionsController.this;
            super();
        }

    }


    private static final String DEAL_OPTIONS_IMPRESSION_TYPE = "deal_options";
    private static final int FIRST_OPTION_INDEX = 0;
    private static final int MAX_VERTICAL_OPTIONS_DISPLAYED = 2;
    private static final int SECOND_OPTION_INDEX = 1;
    private static final String VIEW_ALL_OPTIONS_CLICK_TYPE = "view_all_options_click";
    private static final String VIEW_ALL_OPTIONS_IMPRESSION_TYPE = "view_all_options";
    private BookingUtil bookingUtil;
    private boolean canDisplayExposedMultiOptions;
    private Channel channel;
    private boolean comingFromMyGroupons;
    private CurrencyFormatter currencyFormatter;
    private CurrentCountryManager currentCountryManager;
    private DateTimeFinderReservationDetails dateTimeFinderReservationDetails;
    private Deal deal;
    private String defaultOptionIdForExposedMultiOptions;
    private String exposedOptionsIds[];
    private boolean gdt1503USCAEnabled;
    private IntentFactory intentFactory;
    private boolean isDeepLinked;
    private Logger logger;
    protected LoggingUtils loggingUtils;
    private OnExposedOptionsEventListener onExposedOptionsEventListener;
    private Option option;
    private String pageViewId;

    public ExposedMultiOptionsController(Context context)
    {
        super(context);
    }

    private String createOldPriceString(Option option1)
    {
        Object obj = null;
        String s = obj;
        if (option1 != null)
        {
            com.groupon.db.models.Price price = option1.getValue();
            s = obj;
            if (price != null)
            {
                s = currencyFormatter.formatWithQuantity(price, option1.getMinimumPurchaseQuantity(), true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
            }
        }
        return s;
    }

    private String formatDiscountBoughtString(String s, String s1)
    {
        return String.format("%s %s", new Object[] {
            s, s1
        });
    }

    private List getExposedOptions()
    {
        ArrayList arraylist = new ArrayList(2);
        Map map = DealUtils.createOptionsByIdMap(deal);
        arraylist.add(map.get(exposedOptionsIds[0]));
        arraylist.add(map.get(exposedOptionsIds[1]));
        return arraylist;
    }

    private boolean shouldEnableDateTimeFinder()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (dateTimeFinderReservationDetails != null)
        {
            flag = flag1;
            if (DealUtils.isBookingEngineDeal(deal, false))
            {
                flag = true;
            }
        }
        return flag;
    }

    public OnExposedOptionsEventListener getCallback()
    {
        return new OnOptionsEventListener();
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public void processData()
    {
        if (!canDisplayExposedMultiOptions || comingFromMyGroupons)
        {
            setState(0);
            return;
        }
        List list = getExposedOptions();
        ArrayList arraylist1 = new ArrayList(2);
        Object obj = null;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            Option option1 = (Option)iterator.next();
            if (option1 != null)
            {
                OptionCardData optioncarddata = new OptionCardData();
                boolean flag5 = deal.getDisplayOption("quantity", true);
                boolean flag4 = deal.getDisplayOption("discount", true);
                boolean flag6 = option1.isSoldOut();
                boolean flag7 = option1.isExpired();
                String s;
                int i;
                boolean flag;
                boolean flag1;
                boolean flag2;
                if (flag6 || flag7)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (flag2)
                {
                    i = 1;
                } else
                {
                    i = option1.getMinimumPurchaseQuantity();
                }
                if (flag4 && Strings.notEmpty(UrgencyPricingUtils.getUrgencyPricingAvailability(option1.regularPrice, option1.pricingMetadata)) && Strings.notEmpty(option1.pricingMetadata.offerLabelDescriptive))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag5 && option1.isLimitedQuantity && !currentCountryManager.getCurrentCountry().isJapan() && !deal.isSoldOut() && !Strings.equalsIgnoreCase("closed", deal.getStatus()) && !flag)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag6)
                {
                    obj = context.getString(0x7f0803b3);
                } else
                if (flag7)
                {
                    obj = context.getString(0x7f0802b6);
                } else
                {
                    obj = option1.getPrice();
                    obj = currencyFormatter.formatWithQuantity(((com.groupon.db.models.Price) (obj)), i);
                }
                optioncarddata.optionId = option1.remoteId;
                optioncarddata.title = option1.getTitle();
                optioncarddata.price = ((String) (obj));
                if (flag)
                {
                    i = 0x7f0e0144;
                } else
                if (flag2)
                {
                    i = 0x7f0e00d7;
                } else
                {
                    i = 0x7f0e00c2;
                }
                optioncarddata.priceColor = context.getResources().getColor(i);
                optioncarddata.soldOutOrExpired = flag2;
                i = option1.getDiscountPercent();
                if (i > 0 && flag4 && !flag)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (flag2)
                {
                    optioncarddata.discount = formatDiscountBoughtString(context.getString(0x7f080132), String.format(context.getString(0x7f0804d5), new Object[] {
                        Integer.valueOf(i)
                    }));
                }
                optioncarddata.displayDiscount = flag2;
                if (flag && !Strings.isEmpty(option1.pricingMetadata.offerLabel))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (flag2)
                {
                    optioncarddata.urgencyPricingLabel = option1.pricingMetadata.offerLabel;
                }
                optioncarddata.displayUrgencyPricing = flag2;
                if (!flag && flag1)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                optioncarddata.displayLimitedAvailability = flag2;
                i = option1.getSoldQuantity();
                s = option1.getSoldQuantityMessage();
                if (i > 0 && flag5)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (flag2)
                {
                    String s2 = Strings.capitalize(context.getResources().getQuantityString(0x7f0c0002, i));
                    if (!Strings.notEmpty(s))
                    {
                        s = String.valueOf(i);
                    }
                    optioncarddata.bought = formatDiscountBoughtString(s2, s);
                }
                optioncarddata.displayBought = flag2;
                s = createOldPriceString(option1);
                if (flag4 && s != null && !Strings.equalsIgnoreCase(s, obj))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (flag2)
                {
                    optioncarddata.oldPrice = s;
                }
                optioncarddata.displayOldPrice = flag2;
                obj = optioncarddata;
            }
            arraylist1.add(obj);
        }
        ((OptionCardData)arraylist1.get(0)).checked = true;
        obj = new MultiOptionImpressionExtraInfo(pageViewId);
        ArrayList arraylist = deal.getOptions();
        String s1 = String.format("%d, %d", new Object[] {
            Integer.valueOf(arraylist.indexOf(list.get(0))), Integer.valueOf(arraylist.indexOf(list.get(1)))
        });
        logger.logImpression("", "deal_options", channel.toString(), s1, ((com.groupon.tracking.mobile.EncodedNSTField) (obj)));
        int j = arraylist.size();
        boolean flag3;
        if (j > 2)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag3)
        {
            logger.logImpression("", "view_all_options", channel.toString(), "", ((com.groupon.tracking.mobile.EncodedNSTField) (obj)));
        }
        model = new ExposedMultiOptions();
        ((ExposedMultiOptions)model).optionsCount = j;
        ((ExposedMultiOptions)model).displayAllOptionsButton = flag3;
        ((ExposedMultiOptions)model).firstOptionCardData = (OptionCardData)arraylist1.get(0);
        ((ExposedMultiOptions)model).secondOptionCardData = (OptionCardData)arraylist1.get(1);
        setState(2);
    }

    public void setCanDisplayExposedMultiOptions(boolean flag)
    {
        setState(1);
        canDisplayExposedMultiOptions = flag;
    }

    public void setChannel(Channel channel1)
    {
        setState(1);
        channel = channel1;
    }

    public void setComingFromMyGroupons(boolean flag)
    {
        setState(1);
        comingFromMyGroupons = flag;
    }

    public void setDateTimeFinderReservationDetails(DateTimeFinderReservationDetails datetimefinderreservationdetails)
    {
        setState(1);
        dateTimeFinderReservationDetails = datetimefinderreservationdetails;
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setDefaultOptionIdForExposedMultiOptions(String s)
    {
        setState(1);
        defaultOptionIdForExposedMultiOptions = s;
    }

    public void setExposedOptionsIds(String as[])
    {
        setState(1);
        exposedOptionsIds = as;
    }

    public void setGdt1503USCAEnabled(boolean flag)
    {
        setState(1);
        gdt1503USCAEnabled = flag;
    }

    public void setIsDeepLinked(boolean flag)
    {
        setState(1);
        isDeepLinked = flag;
    }

    public void setOnExposedOptionsEventListener(OnExposedOptionsEventListener onexposedoptionseventlistener)
    {
        setState(1);
        onExposedOptionsEventListener = onexposedoptionseventlistener;
    }

    public void setOption(Option option1)
    {
        setState(1);
        option = option1;
    }

    public void setPageViewId(String s)
    {
        setState(1);
        pageViewId = s;
    }













}
