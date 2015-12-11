// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.AbstractDeal;
import com.groupon.db.models.Deal;
import com.groupon.db.models.ExternalDealProvider;
import com.groupon.db.models.Option;
import com.groupon.db.models.Price;
import com.groupon.models.country.Country;
import com.groupon.models.nst.CSVEncodedNSTField;
import com.groupon.models.nst.ClickExtraInfo;
import com.groupon.service.ShoppingCartService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.EncodedNSTField;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedProvider;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            BookingUtil, UiTreatmentsUtil, Tracking, LoginUtil, 
//            IntlDateFormat, CurrencyFormatter

public class BuyUtils
{

    private ContextScopedProvider abTestServiceProvider;
    private BookingUtil bookingUtil;
    private ContextScopedProvider currencyFormatterProvider;
    private ContextScopedProvider currentCountryServiceProvider;
    private ContextScopedProvider intentFactoryProvider;
    private ContextScopedProvider loggerContextScopedProvider;
    private ContextScopedProvider loginUtil;
    private ContextScopedProvider tracking;
    private UiTreatmentsUtil uiTreatmentsUtil;

    public BuyUtils()
    {
    }

    public ArrayAdapter getAdapter(final Context final_context1, LayoutInflater layoutinflater, Collection collection, Deal deal)
    {
        return new ArrayAdapter(layoutinflater, deal, final_context1) {

            final BuyUtils this$0;
            final Context val$context;
            final Deal val$deal;
            final LayoutInflater val$inflater;

            public boolean areAllItemsEnabled()
            {
                return false;
            }

            public View getView(int i, View view, ViewGroup viewgroup)
            {
                View view1 = inflater.inflate(0x7f030169, null);
                Option option = (Option)getItem(i);
                String s1 = option.getTitle();
                TextView textview1 = (TextView)view1.findViewById(0x7f100330);
                TextView textview2 = (TextView)view1.findViewById(0x7f100419);
                TextView textview3 = (TextView)view1.findViewById(0x7f100334);
                TextView textview = (TextView)view1.findViewById(0x7f10041a);
                boolean flag1 = deal.getDisplayOption("quantity", true);
                boolean flag2 = deal.getDisplayOption("discount", true);
                Date date = option.getExpiresAt();
                boolean flag = option.isSoldOut();
                float f;
                String s;
                Resources resources;
                Integer integer;
                String s2;
                int j;
                int k;
                if (Strings.equalsIgnoreCase("closed", option.getStatus()) || date != null && date.before(new Date()))
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                if (flag || j != 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0)
                {
                    k = 1;
                } else
                {
                    k = option.getMinimumPurchaseQuantity();
                }
                if (((CurrentCountryManager)currentCountryServiceProvider.get(context)).getCurrentCountry().isUSACompatible())
                {
                    view = option.getValue();
                } else
                {
                    view = option.getDiscount();
                }
                if (view == null)
                {
                    viewgroup = "";
                } else
                {
                    viewgroup = ((CurrencyFormatter)currencyFormatterProvider.get(context)).formatWithQuantity(view, k);
                }
                if (flag)
                {
                    view = context.getString(0x7f08027b);
                } else
                if (j != 0)
                {
                    view = context.getString(0x7f08027a);
                } else
                if (option.getPrice() == null)
                {
                    view = "";
                } else
                {
                    view = ((CurrencyFormatter)currencyFormatterProvider.get(context)).formatWithQuantity(option.getPrice(), k);
                }
                integer = Integer.valueOf(option.getDiscountPercent());
                if (((CurrentCountryManager)currentCountryServiceProvider.get(context)).getCurrentCountry().isUSACompatible())
                {
                    s = option.getSoldQuantityMessage();
                } else
                {
                    s = Strings.toString(Integer.valueOf(option.getSoldQuantity()));
                }
                resources = context.getResources();
                if (((CurrentCountryManager)currentCountryServiceProvider.get(context)).getCurrentCountry().isUSACompatible())
                {
                    j = 0x7f080278;
                } else
                {
                    j = 0x7f080279;
                }
                s2 = resources.getString(j, new Object[] {
                    integer, viewgroup, s
                });
                s = resources.getQuantityString(0x7f0c0001, option.getSoldQuantity(), new Object[] {
                    s
                });
                viewgroup = resources.getString(0x7f080133, new Object[] {
                    integer, viewgroup
                });
                if (option.getDiscountPercent() > 0 && flag2)
                {
                    if (flag1)
                    {
                        viewgroup = (new StringBuilder()).append(s2).append(" ").append(resources.getQuantityString(0x7f0c0002, option.getSoldQuantity())).toString();
                    }
                } else
                {
                    viewgroup = s;
                }
                s = resources.getString(0x7f0801ae);
                textview1.setText(s1);
                if (i == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                textview1.setEnabled(flag);
                textview2.setText(viewgroup);
                if (i == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                textview2.setEnabled(flag);
                if (flag1 || flag2)
                {
                    j = 0;
                } else
                {
                    j = 8;
                }
                textview2.setVisibility(j);
                textview3.setText(view);
                if (i != 0)
                {
                    f = 20F;
                } else
                {
                    f = 25F;
                }
                textview3.setTextSize(1, f);
                if (i == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                textview3.setEnabled(flag);
                view = (IntlDateFormat)RoboGuice.getInjector(context).getInstance(com/groupon/util/IntlDateFormat);
                if (date != null)
                {
                    view = String.format(s, new Object[] {
                        view.format(date)
                    });
                } else
                {
                    view = "";
                }
                textview.setText(view);
                if (i == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                textview.setEnabled(flag);
                return view1;
            }

            public boolean isEnabled(int i)
            {
                Option option = (Option)getItem(i);
                Date date = option.getExpiresAt();
                return !option.isSoldOut() && !Strings.equalsIgnoreCase("closed", option.getStatus()) && (date == null || !date.before(new Date()));
            }

            
            {
                this$0 = BuyUtils.this;
                inflater = layoutinflater;
                deal = deal1;
                context = context2;
                super(final_context1, final_i, final_aoption);
            }
        };
    }

    protected ClickExtraInfo getClickExtraInfo(boolean flag)
    {
        ClickExtraInfo clickextrainfo = new ClickExtraInfo();
        if (flag)
        {
            clickextrainfo.bookableDeal = Boolean.valueOf(true);
        }
        clickextrainfo.buyAsGift = Boolean.valueOf(false);
        return clickextrainfo;
    }

    public android.view.View.OnClickListener getListener(final Context context, final boolean multiDeal, final Deal deal, final Channel channel, final String nstClickType, final String nstClickSpecifier, final EncodedNSTField nstClickMetadata, 
            final Date checkInDate, final Date checkOutDate, final boolean isMobileOnly, final boolean redirectToEnterCode, final boolean isThirdPartyLinkout1509, final boolean isDeepLinked)
    {
        return new android.view.View.OnClickListener() {

            final BuyUtils this$0;
            final Channel val$channel;
            final Date val$checkInDate;
            final Date val$checkOutDate;
            final Context val$context;
            final Deal val$deal;
            final boolean val$isDeepLinked;
            final boolean val$isMobileOnly;
            final boolean val$isThirdPartyLinkout1509;
            final boolean val$multiDeal;
            final EncodedNSTField val$nstClickMetadata;
            final String val$nstClickSpecifier;
            final String val$nstClickType;
            final boolean val$redirectToEnterCode;

            public void onClick(View view)
            {
                ((Tracking)tracking.get(context)).trackEvent("Purchase", "click_buy", context.getClass().getName(), 1);
                String s = ((Option)deal.getOptions().get(0)).externalUrl;
                boolean flag = deal.isTravelBookableDeal;
                Object obj = ((Option)deal.getOptions().get(0)).remoteId;
                boolean flag1 = bookingUtil.supportsPrePurchaseBooking(deal);
                Logger logger;
                String s1;
                ClickExtraInfo clickextrainfo;
                if (flag1)
                {
                    view = bookingUtil.createPrePurchaseSchedulerIntent(deal, ((String) (obj)), channel, isMobileOnly, redirectToEnterCode);
                } else
                {
                    view = null;
                }
                logger = (Logger)loggerContextScopedProvider.get(context);
                s1 = deal.remoteId;
                clickextrainfo = getClickExtraInfo(flag1);
                logger.logClick("", nstClickType, nstClickSpecifier, nstClickMetadata, clickextrainfo);
                if (multiDeal)
                {
                    if (view != null)
                    {
                        view.removeExtra("channel");
                    }
                    startNextActivity(context, ((IntentFactory)intentFactoryProvider.get(context)).newMultiOptionIntent(channel, s1, checkInDate, checkOutDate, isMobileOnly, redirectToEnterCode, view).putExtra("isDeepLinked", isDeepLinked), s1);
                    return;
                }
                if (Strings.notEmpty(s) && !deal.derivedIsGLiveDeal)
                {
                    if (isThirdPartyLinkout1509)
                    {
                        obj = (IntentFactory)intentFactoryProvider.get(context);
                        if (uiTreatmentsUtil.isThirdPartyLinkoutDeal(deal))
                        {
                            if (deal.externalDealProvider == null)
                            {
                                view = "";
                            } else
                            {
                                view = deal.externalDealProvider.name;
                            }
                            view = ((IntentFactory) (obj)).newLinkoutDealWebviewIntent(view, s);
                        } else
                        {
                            view = ((IntentFactory) (obj)).newGeneralThirdPartyDealWebViewIntent(s);
                        }
                        context.startActivity(view);
                        return;
                    } else
                    {
                        context.startActivity(((IntentFactory)intentFactoryProvider.get(context)).newExternalUrlIntent(s, s1, channel, ((String) (obj))));
                        return;
                    }
                }
                if (flag && !((CurrentCountryManager)currentCountryServiceProvider.get(context)).getCurrentCountry().isJapan())
                {
                    startNextActivity(context, ((IntentFactory)intentFactoryProvider.get(context)).newCalendarBookingIntent(deal, channel, ((String) (obj)), checkInDate, checkOutDate, redirectToEnterCode), s1);
                    return;
                }
                if (flag1)
                {
                    startNextActivity(context, view, s1);
                    return;
                }
                if (deal.derivedIsGLiveDeal)
                {
                    context.startActivity(((IntentFactory)intentFactoryProvider.get(context)).newGrouponInventoryWebAppIntent(s1));
                    return;
                } else
                {
                    ((LoginUtil)loginUtil.get(context)).startPurchaseActivity(deal, ((String) (obj)), null, channel, isMobileOnly, redirectToEnterCode, isDeepLinked);
                    return;
                }
            }

            
            {
                this$0 = BuyUtils.this;
                context = context1;
                deal = deal1;
                channel = channel1;
                isMobileOnly = flag;
                redirectToEnterCode = flag1;
                nstClickType = s;
                nstClickSpecifier = s1;
                nstClickMetadata = encodednstfield;
                multiDeal = flag2;
                checkInDate = date;
                checkOutDate = date1;
                isDeepLinked = flag3;
                isThirdPartyLinkout1509 = flag4;
                super();
            }
        };
    }

    public android.view.View.OnClickListener getListenerForOptions(final Context context, final Deal deal, final Option option, final String defaultOptionIdSelected, final Channel channel, final boolean isMobileOnly, final boolean redirectToEnterCode, 
            final String nstClickType, final String nstClickSpecifier, final EncodedNSTField nstClickMetadata, final ClickExtraInfo clickExtraInfo, final boolean isDeepLinked)
    {
        return new android.view.View.OnClickListener() {

            final BuyUtils this$0;
            final Channel val$channel;
            final ClickExtraInfo val$clickExtraInfo;
            final Context val$context;
            final Deal val$deal;
            final String val$defaultOptionIdSelected;
            final boolean val$isDeepLinked;
            final boolean val$isMobileOnly;
            final EncodedNSTField val$nstClickMetadata;
            final String val$nstClickSpecifier;
            final String val$nstClickType;
            final Option val$option;
            final boolean val$redirectToEnterCode;

            public void onClick(View view)
            {
                ((Logger)loggerContextScopedProvider.get(context)).logClick("", nstClickType, nstClickSpecifier, nstClickMetadata, clickExtraInfo);
                view = option.externalUrl;
                if (Strings.isEmpty(view) || !handleExternalUrlPerOption(context, view, deal, channel))
                {
                    ((LoginUtil)loginUtil.get(context)).startPurchaseActivity(deal, option.remoteId, defaultOptionIdSelected, channel, isMobileOnly, redirectToEnterCode, isDeepLinked);
                }
            }

            
            {
                this$0 = BuyUtils.this;
                context = context1;
                nstClickType = s;
                nstClickSpecifier = s1;
                nstClickMetadata = encodednstfield;
                clickExtraInfo = clickextrainfo;
                option = option1;
                deal = deal1;
                channel = channel1;
                defaultOptionIdSelected = s2;
                isMobileOnly = flag;
                redirectToEnterCode = flag1;
                isDeepLinked = flag2;
                super();
            }
        };
    }

    public Option getOptionWithMinimumPrice(Deal deal)
    {
        Object obj = null;
        Object obj1 = null;
        Option option1 = null;
        Option option = null;
        if (deal.getOptions().size() != 0)
        {
            int i = 0x7fffffff;
            Iterator iterator = deal.getOptions().iterator();
            deal = obj1;
            do
            {
                obj = deal;
                option1 = option;
                if (!iterator.hasNext())
                {
                    break;
                }
                option1 = (Option)iterator.next();
                if (option1.getPrice() != null)
                {
                    int j = option1.getPrice().amount * option1.getMinimumPurchaseQuantity();
                    boolean flag = option1.isSoldOut();
                    if (j < i)
                    {
                        obj = option1;
                        i = j;
                        deal = ((Deal) (obj));
                        if (!flag)
                        {
                            option = option1;
                            i = j;
                            deal = ((Deal) (obj));
                        }
                    }
                }
            } while (true);
        }
        if (option1 != null)
        {
            return option1;
        } else
        {
            return ((Option) (obj));
        }
    }

    protected boolean handleExternalUrlPerOption(Context context, String s, Deal deal, Channel channel)
    {
        try
        {
            String s1 = ((Option)deal.getOptions().get(0)).remoteId;
            context.startActivity(((IntentFactory)intentFactoryProvider.get(context)).newExternalUrlIntent(s, deal.remoteId, channel, s1));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Ln.e(context);
            return false;
        }
        return true;
    }

    public boolean isOptionExpired(Option option)
    {
        Date date = option.getExpiresAt();
        return Strings.equalsIgnoreCase("closed", option.getStatus()) || date != null && date.before(new Date());
    }

    public CSVEncodedNSTField nstClickMetadata(Logger logger, Deal deal)
    {
        return new CSVEncodedNSTField(logger, new String[] {
            deal.remoteId, deal.uuid
        });
    }

    public CSVEncodedNSTField nstClickMetadata(Logger logger, Deal deal, Option option)
    {
        return new CSVEncodedNSTField(logger, new String[] {
            deal.remoteId, deal.uuid, option.remoteId
        });
    }

    public CSVEncodedNSTField nstClickMetadata(Logger logger, ShoppingCartService shoppingcartservice, Deal deal, Option option)
    {
        String s = shoppingcartservice.getLastCachedCartUuid();
        String s1 = deal.remoteId;
        deal = deal.uuid;
        if (option != null)
        {
            shoppingcartservice = option.remoteId;
        } else
        {
            shoppingcartservice = "";
        }
        return new CSVEncodedNSTField(logger, new String[] {
            s, s1, deal, shoppingcartservice
        });
    }

    public String nstClickMetadata(Logger logger, HashMap hashmap)
    {
        return logger.encodeAsJsonObject(hashmap);
    }

    protected boolean showJapanOptionsWithImages(AbstractDeal abstractdeal, CurrentCountryManager currentcountrymanager)
    {
        return currentcountrymanager.getCurrentCountry().isJapan() && abstractdeal.hasImagesForOptions;
    }

    protected boolean showJapanOptionsWithImages(Deal deal, CurrentCountryManager currentcountrymanager)
    {
        return currentcountrymanager.getCurrentCountry().isJapan() && deal.hasImagesForOptions;
    }

    public boolean showOptionsWithImages(AbstractDeal abstractdeal, Context context)
    {
        return showOptionsWithImages(abstractdeal, (AbTestService)abTestServiceProvider.get(context), (CurrentCountryManager)currentCountryServiceProvider.get(context));
    }

    public boolean showOptionsWithImages(AbstractDeal abstractdeal, AbTestService abtestservice, CurrentCountryManager currentcountrymanager)
    {
        boolean flag1 = abtestservice.isVariantEnabled("multioptions1508INTL", "on");
        int i;
        boolean flag;
        if (!currentcountrymanager.getCurrentCountry().isJapan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = abstractdeal.optionDimensionsCount(flag, currentcountrymanager.getCurrentCountry().isUSACompatible());
        return (i == 1 || i == 2) && (currentcountrymanager.getCurrentCountry().isUSACompatible() || flag1 && (currentcountrymanager.getCurrentCountry().isCityDealCountry() || currentcountrymanager.getCurrentCountry().isLATAMCompatible()) || showJapanOptionsWithImages(abstractdeal, currentcountrymanager));
    }

    public boolean showOptionsWithImages(Deal deal, Context context)
    {
        AbTestService abtestservice = (AbTestService)abTestServiceProvider.get(context);
        context = (CurrentCountryManager)currentCountryServiceProvider.get(context);
        boolean flag1 = abtestservice.isVariantEnabled("multioptions1508INTL", "on");
        int i;
        boolean flag;
        if (!context.getCurrentCountry().isJapan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = deal.optionDimensionsCount(flag, context.getCurrentCountry().isUSACompatible());
        return (i == 1 || i == 2) && (context.getCurrentCountry().isUSACompatible() || flag1 && (context.getCurrentCountry().isCityDealCountry() || context.getCurrentCountry().isLATAMCompatible()) || showJapanOptionsWithImages(deal, context));
    }

    protected void startNextActivity(Context context, Intent intent, String s)
    {
        context.startActivity(intent.putExtra("comingFromCheckout", true).putExtra("dealId", s));
    }

    public boolean supportsPrePurchaseBooking(Deal deal)
    {
        return bookingUtil.supportsPrePurchaseBooking(deal);
    }








}
