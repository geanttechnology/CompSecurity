// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.db.models.mygroupons.AbstractMyGrouponItem;
import com.groupon.db.models.mygroupons.MyGrouponItemSummary;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.DivisionTimeZone;
import com.groupon.util.ExpirationFormat;
import com.groupon.util.ImageServiceUtil;
import com.groupon.util.MarketRateUtil;
import com.groupon.util.TimeZoneUSFriendlyDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            UrlImageView

public class MyGrouponItem extends FrameLayout
{

    private static final long MAX_DAYS_FROM_LAST_PURCHASE = 30L;
    private AbTestService abTestService;
    private String availableLabel;
    private TextView bookNowRequestAppLink;
    private CurrentCountryManager currentCountryManager;
    private ExpirationFormat expirationFormat;
    private TimeZoneUSFriendlyDateFormat friendlyDateFormatter;
    private UrlImageView imageView;
    private boolean isBookingUpdatePreBook1506USCA;
    private boolean isBookingUpdates1408USCA;
    private boolean isGoodsTrackPackage1510USCA;
    private RelativeLayout myGrouponItemContent;
    private TextView statusView;
    private TextView subtitleView;
    private TextView titleView;
    private TextView trackPackageButton;
    private View trackPackageDiv;

    public MyGrouponItem(Context context)
    {
        this(context, null, 0);
    }

    public MyGrouponItem(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public MyGrouponItem(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(context, 0x7f03016e, this);
        RoboGuice.getInjector(context).injectMembers(this);
        isBookingUpdates1408USCA = abTestService.isVariantEnabledAndUSCA("bookingUpdates1408USCA", "on");
        isBookingUpdatePreBook1506USCA = abTestService.isVariantEnabledAndUSCA("bookingUpdatesPreBook1506USCA", "on");
        isGoodsTrackPackage1510USCA = abTestService.isVariantEnabledAndUSCA("goodsTrackPackage1510USCA", "on");
        imageView = (UrlImageView)findViewById(0x7f100121);
        titleView = (TextView)findViewById(0x7f10007a);
        statusView = (TextView)findViewById(0x7f100238);
        subtitleView = (TextView)findViewById(0x7f100442);
        myGrouponItemContent = (RelativeLayout)findViewById(0x7f10037a);
        bookNowRequestAppLink = (TextView)findViewById(0x7f100237);
        trackPackageDiv = findViewById(0x7f100443);
        trackPackageButton = (TextView)findViewById(0x7f100444);
        friendlyDateFormatter.setOutputType(com.groupon.util.TimeZoneUSFriendlyDateFormat.OutputType.shortDate);
        availableLabel = context.getString(0x7f08006b);
    }

    public static String generateSentGiftText(AbstractMyGrouponItem abstractmygrouponitem, Resources resources)
    {
        String s = abstractmygrouponitem.giftRecipientName;
        if (Strings.notEmpty(s))
        {
            return String.format(resources.getString(0x7f0801f4), new Object[] {
                s
            });
        }
        abstractmygrouponitem = abstractmygrouponitem.giftRecipientEmail;
        if (Strings.notEmpty(abstractmygrouponitem))
        {
            return String.format(resources.getString(0x7f0801f4), new Object[] {
                abstractmygrouponitem
            });
        } else
        {
            return resources.getString(0x7f08036e);
        }
    }

    protected String getBookingUpdatesLabelOrAvailable(MyGrouponItemSummary mygrouponitemsummary)
    {
        boolean flag = mygrouponitemsummary.bookable;
        String s = mygrouponitemsummary.bookingType;
        String s1 = mygrouponitemsummary.localBookingInfoStatus;
        if (isBookingUpdates1408USCA && !flag && Strings.equals(s, "booking_engine"))
        {
            if (Strings.isEmpty(s1))
            {
                return getContext().getString(0x7f080327);
            }
            if (Strings.equalsIgnoreCase(s1, "pending"))
            {
                return getContext().getString(0x7f08040b);
            }
            if (Strings.equalsIgnoreCase(s1, "booked"))
            {
                return getContext().getString(0x7f08040c);
            }
            if (Strings.equalsIgnoreCase(s1, "unbooked"))
            {
                return getDealEndsLabel(mygrouponitemsummary, 0x7f080126);
            } else
            {
                return availableLabel;
            }
        }
        if (currentCountryManager.getCurrentCountry().isUSACompatible() && flag && Strings.equals(s, "booking_engine"))
        {
            if (Strings.isEmpty(s1))
            {
                return getContext().getString(0x7f080075);
            }
            if (Strings.equalsIgnoreCase(s1, "unbooked"))
            {
                return getDealEndsLabel(mygrouponitemsummary, 0x7f080073);
            }
            if (Strings.equalsIgnoreCase(s1, "booked"))
            {
                return getContext().getString(0x7f08040c);
            } else
            {
                return availableLabel;
            }
        } else
        {
            return getDealEndsLabel(mygrouponitemsummary, 0x7f080126);
        }
    }

    protected String getDealEndsLabel(MyGrouponItemSummary mygrouponitemsummary, int i)
    {
        Date date = mygrouponitemsummary.expiresAt;
        String s = mygrouponitemsummary.timezoneIdentifier;
        int j = mygrouponitemsummary.timezoneOffsetInSeconds;
        if (date != null)
        {
            expirationFormat.shouldDisplayTime(true);
            mygrouponitemsummary = expirationFormat.format(date, s, Integer.valueOf(j), null, null);
            if (Strings.notEmpty(mygrouponitemsummary))
            {
                availableLabel = getContext().getString(i, new Object[] {
                    mygrouponitemsummary
                });
            }
        } else
        {
            availableLabel = getContext().getString(0x7f08006b);
        }
        return availableLabel;
    }

    protected String setDealEndedLabel(MyGrouponItemSummary mygrouponitemsummary)
    {
        Date date = mygrouponitemsummary.expiresAt;
        String s = mygrouponitemsummary.timezoneIdentifier;
        int i = mygrouponitemsummary.timezoneOffsetInSeconds;
        if (date != null)
        {
            expirationFormat.shouldDisplayTime(true);
            mygrouponitemsummary = expirationFormat.format(date, s, Integer.valueOf(i), null, null);
            if (Strings.notEmpty(mygrouponitemsummary))
            {
                availableLabel = getContext().getString(0x7f08012e, new Object[] {
                    mygrouponitemsummary
                });
            }
        } else
        {
            availableLabel = getContext().getString(0x7f08006b);
        }
        return availableLabel;
    }

    public void setGroupon(MyGrouponItemSummary mygrouponitemsummary)
    {
        boolean flag1 = mygrouponitemsummary.isMarketRate;
        Object obj;
        Object obj4;
        String s1;
        String s2;
        Object obj6;
        String s3;
        String s4;
        String s5;
        Object obj7;
        String s6;
        String s7;
        String s8;
        String s9;
        Integer integer;
        int i;
        int j;
        boolean flag;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        if (flag1)
        {
            obj = mygrouponitemsummary.purchaseStatusMarketRate;
        } else
        {
            obj = mygrouponitemsummary.purchaseStatus;
        }
        obj4 = mygrouponitemsummary.availability;
        s1 = ((String) (obj4));
        if (Strings.isEmpty(obj4))
        {
            s1 = ((String) (obj));
        }
        obj4 = mygrouponitemsummary.status;
        s2 = ((String) (obj4));
        if (Strings.isEmpty(obj4))
        {
            s2 = Strings.capitalize(((String) (obj)));
        }
        obj6 = mygrouponitemsummary.checkInDate;
        obj4 = null;
        if (flag1)
        {
            obj4 = mygrouponitemsummary.hotelTimezoneIdentifier;
            if (Strings.notEmpty(obj4))
            {
                friendlyDateFormatter.setTimeZoneByIdentifier(((String) (obj4)));
            }
            obj4 = MarketRateUtil.getFormattedDate(((Date) (obj6)), friendlyDateFormatter, null);
        }
        if (!flag1)
        {
            obj4 = DivisionTimeZone.getDateToDisplay(((Date) (obj6)), getContext());
        }
        flag2 = Strings.equalsIgnoreCase(s2, "pending");
        flag3 = Strings.equalsIgnoreCase(s2, "failed");
        flag4 = Strings.equalsIgnoreCase(s2, "succeeded");
        flag5 = Strings.equalsIgnoreCase(s1, "refund_pending");
        obj7 = getContext();
        s4 = ((Context) (obj7)).getString(0x7f080280);
        s6 = ((Context) (obj7)).getString(0x7f08012e);
        s3 = ((Context) (obj7)).getString(0x7f0802ce);
        s5 = ((Context) (obj7)).getString(0x7f080312);
        obj6 = ((Context) (obj7)).getString(0x7f080311);
        s7 = ((Context) (obj7)).getString(0x7f08027f);
        s8 = ((Context) (obj7)).getString(0x7f080281);
        obj7 = ((Context) (obj7)).getString(0x7f0800b0, new Object[] {
            obj4
        });
        s9 = mygrouponitemsummary.timezoneIdentifier;
        integer = Integer.valueOf(mygrouponitemsummary.timezoneOffsetInSeconds);
        j = 0;
        flag = Strings.equals(mygrouponitemsummary.localBookingInfoStatus, "pending");
        if (shouldShowBookingLabel(mygrouponitemsummary, s2, s1))
        {
            obj4 = bookNowRequestAppLink;
            TextView textview1;
            if (flag)
            {
                i = 0x7f08032c;
            } else
            {
                i = 0x7f080076;
            }
            ((TextView) (obj4)).setText(i);
            subtitleView.setVisibility(8);
            bookNowRequestAppLink.setVisibility(0);
        } else
        {
            subtitleView.setVisibility(0);
            bookNowRequestAppLink.setVisibility(8);
        }
        flag = shouldShowTrackPackage(mygrouponitemsummary);
        obj4 = trackPackageDiv;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj4)).setVisibility(i);
        obj4 = trackPackageButton;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((TextView) (obj4)).setVisibility(i);
        textview1 = titleView;
        if (flag1)
        {
            obj4 = mygrouponitemsummary.hotelName;
        } else
        {
            obj4 = mygrouponitemsummary.subTitle;
        }
        textview1.setText(((CharSequence) (obj4)));
        textview1 = subtitleView;
        if (flag1)
        {
            obj4 = obj7;
        } else
        {
            obj4 = mygrouponitemsummary.title;
        }
        textview1.setText(((CharSequence) (obj4)));
        expirationFormat.shouldDisplayTime(false);
        obj4 = expirationFormat;
        if (!currentCountryManager.getCurrentCountry().isJapan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((ExpirationFormat) (obj4)).shouldDisplayUSFriendlyDateFormat(flag);
        statusView.setVisibility(0);
        statusView.setCompoundDrawablePadding(0);
        if (flag1)
        {
            statusView.setText(Strings.capitalize(((String) (obj))));
            i = j;
        } else
        if (flag3)
        {
            Object obj5 = mygrouponitemsummary.statusMessage;
            Object obj1 = obj5;
            if (Strings.isEmpty(obj5))
            {
                obj1 = s3;
            }
            obj5 = statusView;
            if (flag5)
            {
                obj1 = obj6;
            }
            ((TextView) (obj5)).setText(((CharSequence) (obj1)));
            i = j;
        } else
        if (flag2)
        {
            TextView textview = statusView;
            String s;
            if (flag5)
            {
                s = s5;
            } else
            {
                s = s4;
            }
            textview.setText(s);
            i = j;
        } else
        if (flag4)
        {
            if (flag5)
            {
                statusView.setText(s5);
                i = j;
            } else
            if (Strings.equalsIgnoreCase(s1, "refunded"))
            {
                statusView.setText(s8);
                i = j;
            } else
            if (mygrouponitemsummary.isGift && mygrouponitemsummary.isSentGift())
            {
                statusView.setText(generateSentGiftText(mygrouponitemsummary, getResources()));
                i = 0x7f020213;
                statusView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(0x7f0b0196));
            } else
            if (Strings.equalsIgnoreCase(s1, "expired"))
            {
                if (!mygrouponitemsummary.hasRetainedValue)
                {
                    statusView.setText(s7);
                    i = j;
                } else
                {
                    statusView.setText(setDealEndedLabel(mygrouponitemsummary));
                    i = j;
                }
            } else
            if (Strings.equalsIgnoreCase(s1, "refund_pending"))
            {
                statusView.setText(s5);
                i = j;
            } else
            if (Strings.equalsIgnoreCase(s1, "refunded"))
            {
                statusView.setText(s8);
                i = j;
            } else
            if (Strings.equalsIgnoreCase(s1, "redeemed"))
            {
                Object obj2 = mygrouponitemsummary.customerRedeemedAt;
                if (obj2 != null)
                {
                    expirationFormat.shouldDisplayTime(true);
                    obj2 = expirationFormat.format(((Date) (obj2)), s9, integer, null, null);
                    i = j;
                    if (Strings.notEmpty(obj2))
                    {
                        statusView.setText(String.format(s6, new Object[] {
                            obj2
                        }));
                        i = j;
                    }
                } else
                {
                    statusView.setVisibility(8);
                    i = j;
                }
            } else
            if (Strings.equalsIgnoreCase(s1, "available"))
            {
                statusView.setText(getBookingUpdatesLabelOrAvailable(mygrouponitemsummary));
                i = j;
            } else
            if (Strings.equalsIgnoreCase(s1, "purchased"))
            {
                Object obj3 = mygrouponitemsummary.voucherReleaseAt;
                expirationFormat.shouldDisplayTime(true);
                if (obj3 != null)
                {
                    obj3 = String.format(getResources().getString(0x7f08006c), new Object[] {
                        expirationFormat.format(((Date) (obj3)), s9, integer, null, null)
                    });
                } else
                {
                    obj3 = getBookingUpdatesLabelOrAvailable(mygrouponitemsummary);
                }
                statusView.setText(((CharSequence) (obj3)));
                i = j;
            } else
            {
                statusView.setVisibility(8);
                i = j;
            }
        } else
        {
            statusView.setVisibility(8);
            i = j;
        }
        obj = statusView;
        obj4 = getResources();
        if (flag3)
        {
            j = 0x7f0e018e;
        } else
        {
            j = 0x7f0e0031;
        }
        ((TextView) (obj)).setTextColor(((Resources) (obj4)).getColor(j));
        statusView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        if (flag1)
        {
            mygrouponitemsummary = ImageServiceUtil.getLargeImageUrl(mygrouponitemsummary.url);
        } else
        {
            mygrouponitemsummary = mygrouponitemsummary.sidebarImageUrl;
        }
        imageView.setImageUrl(mygrouponitemsummary);
    }

    public void setGrouponItemMargins(int i, boolean flag)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutparams.leftMargin = i;
        layoutparams.topMargin = i;
        layoutparams.rightMargin = i;
        if (!flag)
        {
            i = 0;
        }
        layoutparams.bottomMargin = i;
        myGrouponItemContent.setLayoutParams(layoutparams);
    }

    protected boolean shouldShowBookingLabel(MyGrouponItemSummary mygrouponitemsummary, String s, String s1)
    {
        boolean flag2 = mygrouponitemsummary.bookable;
        String s2 = mygrouponitemsummary.bookingType;
        mygrouponitemsummary = mygrouponitemsummary.localBookingInfoStatus;
        boolean flag3 = Strings.equalsIgnoreCase(s, "succeeded");
        boolean flag4 = Strings.equalsIgnoreCase(s1, "purchased");
        boolean flag5 = Strings.equalsIgnoreCase(s1, "available");
        boolean flag;
        boolean flag1;
        if ((currentCountryManager.getCurrentCountry().isUSACompatible() || isBookingUpdatePreBook1506USCA) && flag2 && Strings.equals(s2, "booking_engine"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (isBookingUpdates1408USCA && !flag2 && Strings.equals(s2, "booking_engine"))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return (flag || flag1) && (Strings.equalsIgnoreCase(mygrouponitemsummary, "unbooked") || Strings.equalsIgnoreCase(mygrouponitemsummary, "pending")) && flag3 && (flag5 || flag4);
    }

    protected boolean shouldShowTrackPackage(MyGrouponItemSummary mygrouponitemsummary)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (mygrouponitemsummary.purchasedAt != null)
        {
            flag = flag1;
            if (mygrouponitemsummary.shipmentsListTrackUrl != null)
            {
                long l = (Calendar.getInstance().getTimeInMillis() - mygrouponitemsummary.purchasedAt.getTime()) / TimeUnit.DAYS.toMillis(1L);
                flag = flag1;
                if (isGoodsTrackPackage1510USCA)
                {
                    flag = flag1;
                    if (mygrouponitemsummary.hasTrackableShipments)
                    {
                        flag = flag1;
                        if (l < 30L)
                        {
                            flag = flag1;
                            if (!mygrouponitemsummary.shipmentsListTrackUrl.isEmpty())
                            {
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }
}
