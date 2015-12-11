// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.StyleSpan;
import android.text.util.Linkify;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.EbayTimer;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.RemindersList;
import com.ebay.common.model.cart.Incentive;
import com.ebay.common.model.cart.UserIncentives;
import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.common.net.api.aps.ApplicationProcessServiceApi;
import com.ebay.common.net.api.cart.GetUserIncentivesNetLoader;
import com.ebay.common.net.api.currency.CurrencyConversionDataManager;
import com.ebay.common.util.EbayAsyncTask;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.DefaultItemAdapter;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.common.view.SearchResultListAdapter;
import com.ebay.common.view.ViewCache;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.activities.BaseListActivity;
import com.ebay.mobile.activities.ErrorDialogActivity;
import com.ebay.mobile.activities.OrderSummaryActivity;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.bestoffer.BestOfferStatusLocale;
import com.ebay.mobile.bestoffer.BestOfferViewHelper;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ReminderItemsActivity extends BaseListActivity
    implements com.ebay.common.net.api.currency.CurrencyConversionDataManager.Observer, com.ebay.common.util.EbayAsyncTask.TaskHandler, com.ebay.mobile.util.ContentSyncManager.ContentSync
{
    protected class CouponAdapter extends ArrayAdapter
    {

        private final int colorTextDefault;
        private final String conditions;
        private final int id;
        private final LayoutInflater inflater;
        private final int redColor;
        private final StringBuffer redemptionCode;
        private final int spanStart;
        final ReminderItemsActivity this$0;

        public int getCount()
        {
            if (coupons == null)
            {
                return 0;
            } else
            {
                return coupons.size();
            }
        }

        public Incentive getItem(int i)
        {
            return (Incentive)coupons.get(i);
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            Incentive incentive = (Incentive)coupons.get(i);
            View view1 = inflater.inflate(id, viewgroup, false);
            ((TextView)view1.findViewById(0x7f100160)).setText(incentive.displayMsg);
            view = (TextView)view1.findViewById(0x7f100161);
            viewgroup = new StringBuffer(redemptionCode);
            viewgroup.append(Incentive.obfuscateIncentiveCode(incentive.redemptionCode));
            i = viewgroup.length();
            viewgroup = new SpannableString(new StringBuilder(viewgroup));
            viewgroup.setSpan(new StyleSpan(1), spanStart, i, 33);
            view.setText(viewgroup);
            TextView textview = (TextView)view1.findViewById(0x7f100162);
            textview.setTextColor(colorTextDefault);
            view = "";
            Date date = incentive.expiration;
            if (date != null)
            {
                viewgroup = java.text.DateFormat.getDateInstance(3).format(date);
                view = viewgroup;
                if (date.getTime() - System.currentTimeMillis() <= 0x240c8400L)
                {
                    textview.setTextColor(redColor);
                    view = viewgroup;
                }
            }
            if (view.length() > 0)
            {
                textview.setText(getString(0x7f0703ec, new Object[] {
                    view
                }));
            } else
            {
                textview.setText("");
            }
            view = (TextView)view1.findViewById(0x7f100163);
            if (incentive.campaign != null && !TextUtils.isEmpty(incentive.campaign.FAQUrl))
            {
                view.setTextColor(colorTextDefault);
                view.setText(Html.fromHtml((new StringBuilder()).append("<a href='#'>").append(conditions).append("</a>").toString()));
                view.setVisibility(0);
                Linkify.addLinks(view, 1);
                view.setOnClickListener(incentive. new android.view.View.OnClickListener() {

                    final CouponAdapter this$1;
                    final Incentive val$incentive;

                    public void onClick(View view)
                    {
                        ShowWebViewActivity.start(_fld0, incentive.campaign.FAQUrl, conditions, "IncentiveFaqInfo");
                    }

            
            {
                this$1 = final_couponadapter;
                incentive = Incentive.this;
                super();
            }
                });
            } else
            {
                view.setVisibility(8);
            }
            view1.setTag(incentive);
            return view1;
        }


        public CouponAdapter(Context context, int i)
        {
            this$0 = ReminderItemsActivity.this;
            super(context, i);
            id = i;
            redColor = getResources().getColor(0x7f0d0064);
            colorTextDefault = ThemeUtil.resolveThemeForegroundColor(getResources(), getTheme(), 0x1010036);
            inflater = (LayoutInflater)getSystemService("layout_inflater");
            redemptionCode = (new StringBuffer(getString(0x7f0708df))).append(" ");
            spanStart = redemptionCode.length();
            conditions = getString(0x7f070997);
        }
    }

    protected static class CustomItemAdapter extends DefaultItemAdapter
    {

        private final int reminderType;

        public volatile void setItem(ViewCache viewcache, EbaySearchListItem ebaysearchlistitem, int i)
        {
            setItem(viewcache, (MyEbayListItem)ebaysearchlistitem, i);
        }

        public void setItem(ViewCache viewcache, MyEbayListItem myebaylistitem, int i)
        {
            viewcache.image.setRemoteImageUrl(myebaylistitem.imageUrl);
            String s = myebaylistitem.title;
            viewcache.text.setText(s);
            setTimeLeft(viewcache.rightColumnText4, myebaylistitem.endDate, EbayResponse.currentHostTime());
            myebaylistitem.sellingState;
            JVM INSTR tableswitch 4 5: default 68
        //                       4 430
        //                       5 444;
               goto _L1 _L2 _L3
_L1:
            reminderType;
            JVM INSTR tableswitch 10 12: default 100
        //                       10 458
        //                       11 458
        //                       12 458;
               goto _L4 _L5 _L5 _L5
_L4:
            viewcache.rightColumnText3.setMaxLines(2);
            viewcache.rightColumnText3.setSingleLine(false);
_L16:
            double d;
            Object obj;
            ItemCurrency itemcurrency;
            int j;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            j = 0;
            i = 0;
            flag2 = false;
            flag3 = false;
            obj = null;
            if (myebaylistitem.transaction != null && myebaylistitem.transaction.totalTransactionPrice != null)
            {
                itemcurrency = myebaylistitem.transaction.totalTransactionPrice;
            } else
            {
                itemcurrency = myebaylistitem.currentPrice;
                obj = myebaylistitem.convertedCurrentPrice;
            }
            myebaylistitem.listingType;
            JVM INSTR tableswitch 2 6: default 196
        //                       2 555
        //                       3 492
        //                       4 196
        //                       5 609
        //                       6 609;
               goto _L6 _L7 _L8 _L6 _L9 _L9
_L6:
            if (myebaylistitem.transaction != null && myebaylistitem.transaction.totalTransactionPrice != null)
            {
                itemcurrency = myebaylistitem.transaction.totalTransactionPrice;
            } else
            if (myebaylistitem.transaction != null && myebaylistitem.currentPrice != null)
            {
                itemcurrency = myebaylistitem.currentPrice;
                (new CurrencyAmount(itemcurrency)).multiplyBy(myebaylistitem.transaction.quantityPurchased);
                obj = myebaylistitem.convertedCurrentPrice;
            } else
            {
                itemcurrency = myebaylistitem.currentPrice;
                obj = myebaylistitem.convertedCurrentPrice;
            }
            flag2 = setCurrency(viewcache.rightColumnText1, itemcurrency, ((ItemCurrency) (obj)));
            viewcache.rightColumnText3.setText("");
            j = i;
            if (myebaylistitem.bestOfferAmount != null)
            {
                setCurrency(viewcache.rightColumnText1, myebaylistitem.bestOfferAmount, null);
            }
            if (flag2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (flag3)
            {
                viewcache.rightColumnText1.setText(0x7f0705ab);
            }
            if (j != 0)
            {
                setCurrency(viewcache.rightColumnText5, myebaylistitem.originalRetailPrice, null);
                viewcache.rightColumnText5.setVisibility(0);
            } else
            {
                viewcache.rightColumnText5.setVisibility(8);
            }
            if (!showShipping || myebaylistitem.shippingCost == null || myebaylistitem.shippingCost.code == null || myebaylistitem.shippingCost.value == null) goto _L11; else goto _L10
_L10:
            j = colorSecondary;
            flag1 = false;
            flag = false;
            d = Double.parseDouble(myebaylistitem.shippingCost.value);
            if (d >= 0.01D) goto _L13; else goto _L12
_L12:
            if (!showFreeShipping) goto _L15; else goto _L14
_L14:
            j = colorShippingFree;
            viewcache.rightColumnText2.setText(0x7f070422);
            i = ((flag) ? 1 : 0);
            break MISSING_BLOCK_LABEL_409;
_L2:
            viewcache.rightColumnText1.setTextColor(colorPriceSold);
            continue; /* Loop/switch isn't completed */
_L3:
            viewcache.rightColumnText1.setTextColor(colorPriceUnsold);
            continue; /* Loop/switch isn't completed */
_L5:
            viewcache.rightColumnText3.setMaxLines(1);
            viewcache.rightColumnText3.setSingleLine(true);
              goto _L16
_L8:
            if (myebaylistitem.buyItNowAvailable && (myebaylistitem.buyItNowPrice != null || myebaylistitem.convertedBuyItNowPrice != null) && (buyingFormat & 1) == 0)
            {
                flag2 = setCurrency(viewcache.rightColumnText1, myebaylistitem.buyItNowPrice, myebaylistitem.convertedBuyItNowPrice);
                viewcache.rightColumnText3.setText(0x7f070529);
                j = i;
                break MISSING_BLOCK_LABEL_248;
            }
_L7:
            flag2 = setCurrency(viewcache.rightColumnText1, itemcurrency, ((ItemCurrency) (obj)));
            viewcache.rightColumnText3.setText(resources.getQuantityString(0x7f080013, myebaylistitem.bidCount, new Object[] {
                Integer.valueOf(myebaylistitem.bidCount)
            }));
            j = i;
            break MISSING_BLOCK_LABEL_248;
_L9:
            flag3 = flag2;
            i = j;
            if (myebaylistitem.originalRetailPrice != null)
            {
                flag3 = flag2;
                i = j;
                if (myebaylistitem.originalRetailPrice.code != null)
                {
                    flag3 = flag2;
                    i = j;
                    if (myebaylistitem.originalRetailPrice.value != null)
                    {
                        flag3 = "MAP".equals(myebaylistitem.pricingTreatment);
                        if (flag3 || "STP".equals(myebaylistitem.pricingTreatment))
                        {
                            i = 1;
                        } else
                        {
                            i = 0;
                        }
                    }
                }
            }
            flag2 = setCurrency(viewcache.rightColumnText1, itemcurrency, ((ItemCurrency) (obj)));
            viewcache.rightColumnText3.setText(0x7f070529);
            j = i;
            break MISSING_BLOCK_LABEL_248;
_L15:
            viewcache.rightColumnText2.setText("");
            i = ((flag) ? 1 : 0);
_L19:
            try
            {
                viewcache.rightColumnText2.setTypeface(Typeface.DEFAULT, i);
                viewcache.rightColumnText2.setTextColor(j);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (MyEbayListItem myebaylistitem)
            {
                viewcache.rightColumnText2.setText("");
            }
            return;
_L13:
            obj = formatCurrency(d, myebaylistitem.shippingCost.code, i | 2);
            i = ((flag1) ? 1 : 0);
            myebaylistitem = ((MyEbayListItem) (obj));
            if (!flag2) goto _L18; else goto _L17
_L17:
            i = 2;
            myebaylistitem = (new StringBuilder()).append(((String) (obj))).append(" ").toString();
_L18:
            viewcache.rightColumnText2.setText(myebaylistitem);
            if (true) goto _L19; else goto _L11
_L11:
            viewcache.rightColumnText2.setText("");
            return;
            if (true) goto _L1; else goto _L20
_L20:
        }

        public volatile void setItem(ViewCache viewcache, Object obj, int i)
        {
            setItem(viewcache, (MyEbayListItem)obj, i);
        }

        protected void setTimeLeft(TextView textview, Date date, long l)
        {
            int i;
            if (date != null)
            {
                l = date.getTime() - l;
            } else
            {
                l = 0L;
            }
            if (l > 0L && l < 0x5265c00L)
            {
                i = colorTimeWarning;
            } else
            {
                i = colorSecondary;
            }
            textview.setTextColor(i);
            if (l >= 0x757b12c00L)
            {
                textview.setText(null);
                return;
            }
            if (l > 0L)
            {
                l /= 1000L;
                int j = (int)(l % 60L);
                l /= 60L;
                int k = (int)(l % 60L);
                l /= 60L;
                int i1 = (int)(l % 24L);
                int j1 = (int)(l / 24L);
                date = new StringBuilder();
                if (j1 > 0)
                {
                    date.append(j1).append(strDays).append(' ').append(i1).append(strHours);
                } else
                if (i1 > 0)
                {
                    date.append(i1).append(strHours).append(' ').append(k).append(strMinutes);
                } else
                if (k > 0)
                {
                    date.append(k).append(strMinutes).append(' ').append(j).append(strSeconds);
                } else
                {
                    date.append(j).append(strSeconds);
                }
                textview.setText(date.toString());
                return;
            } else
            {
                textview.setText(0x7f0703c3);
                return;
            }
        }

        public CustomItemAdapter(Activity activity, boolean flag, boolean flag1, int i)
        {
            super(activity, flag, flag1, false, 7, false);
            reminderType = i;
        }
    }

    private class NotificationListAdapter extends SearchResultListAdapter
    {

        private final int colorTextDefault;
        private final int colorTextOutbid;
        private final Resources resources;
        final ReminderItemsActivity this$0;

        private String generateKey(String s, String s1)
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(s);
            stringbuilder.append(':');
            stringbuilder.append(s1);
            return stringbuilder.toString();
        }

        private boolean isPaid(MyEbayListItem myebaylistitem)
        {
            while (ItemTransaction.isPaidFor(myebaylistitem.transaction.paidStatus) || ItemTransaction.isPaidUsingTradingQuirk(myebaylistitem.transaction.paidStatus, myebaylistitem.transaction.paidTime)) 
            {
                return true;
            }
            return isPaidUserCache(String.valueOf(myebaylistitem.id), myebaylistitem.transaction.transactionId);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (i == itemList.size() - 1)
            {
                loadPage();
            }
            view = super.getView(i, view, viewgroup);
            viewgroup = (ViewCache)view.getTag();
            MyEbayListItem myebaylistitem = (MyEbayListItem)getItem(i);
            if (myebaylistitem.transaction != null && myebaylistitem.transaction.transactionId != null)
            {
                Object obj = String.valueOf(myebaylistitem.id);
                Object obj1;
                boolean flag;
                if (myebaylistitem.transaction.feedbackLeft || userCache.hasLeftFeedback(((String) (obj)), myebaylistitem.transaction.transactionId))
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0 && !myebaylistitem.transaction.feedbackLeft)
                {
                    myebaylistitem.transaction.feedbackLeft = true;
                }
                obj1 = ((ViewCache) (viewgroup)).imageLeaveFeedback;
                if (i != 0)
                {
                    i = 0x7f0201d4;
                } else
                {
                    i = 0x7f0201d5;
                }
                ((ImageView) (obj1)).setImageResource(i);
                ((ViewCache) (viewgroup)).imageLeaveFeedback.setVisibility(0);
                flag = isPaid(myebaylistitem);
                obj1 = ((ViewCache) (viewgroup)).imageStampPaid;
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                ((ImageView) (obj1)).setVisibility(i);
                obj1 = ((ViewCache) (viewgroup)).imageStampOutbid;
                if (remindersType == 4)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                ((ImageView) (obj1)).setVisibility(i);
                obj1 = generateKey(((String) (obj)), myebaylistitem.transaction.transactionId);
                if (userCache.isShipped(((String) (obj)), myebaylistitem.transaction.transactionId) && !myebaylistitem.transaction.shipped)
                {
                    myebaylistitem.transaction.shipped = true;
                    shipCache.add(obj1);
                } else
                if (shipCache.contains(obj1))
                {
                    myebaylistitem.transaction.shipped = userCache.isShipped(((String) (obj)), myebaylistitem.transaction.transactionId);
                }
                if (myebaylistitem.transaction.shipped || userCache.isShipped(((String) (obj)), myebaylistitem.transaction.transactionId))
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                obj = ((ViewCache) (viewgroup)).imageItemShipped;
                if (i != 0)
                {
                    i = 0x7f0201ea;
                } else
                {
                    i = 0x7f0201e9;
                }
                ((ImageView) (obj)).setImageResource(i);
                ((ViewCache) (viewgroup)).imageItemShipped.setVisibility(0);
            }
            if (remindersType == 4)
            {
                ((ViewCache) (viewgroup)).rightColumnText1.setTextColor(colorTextOutbid);
            }
            if (remindersType == 13 || remindersType == 14)
            {
                ((ViewCache) (viewgroup)).rightColumnText2.setTypeface(Typeface.DEFAULT, 0);
                ((ViewCache) (viewgroup)).rightColumnText2.setText(resources.getQuantityString(0x7f08003b, myebaylistitem.watchCount, new Object[] {
                    Integer.valueOf(myebaylistitem.watchCount)
                }));
                ((ViewCache) (viewgroup)).rightColumnText2.setTextColor(colorTextDefault);
            }
            if (remindersType == 10 || remindersType == 11 || remindersType == 12)
            {
                ((ViewCache) (viewgroup)).rightColumnText3.setText(myebaylistitem.highBidderId);
                ((ViewCache) (viewgroup)).rightColumnText3.setEllipsize(android.text.TextUtils.TruncateAt.MIDDLE);
            }
            if (remindersType == 14)
            {
                if (myebaylistitem.bestOfferPendingCount > 0)
                {
                    ((ViewCache) (viewgroup)).rightColumnText3.setText(BestOfferStatusLocale.getCaption(ReminderItemsActivity.this, "Pending"));
                    ((ViewCache) (viewgroup)).rightColumnText3.setTextColor(BestOfferViewHelper.getStatusColor(getResources(), "Pending"));
                } else
                {
                    ((ViewCache) (viewgroup)).rightColumnText3.setText("");
                }
            }
            if (remindersType == 5)
            {
                ((ViewCache) (viewgroup)).rightColumnText3.setText(BestOfferStatusLocale.getCaption(ReminderItemsActivity.this, myebaylistitem.bestOfferStatus));
                ((ViewCache) (viewgroup)).rightColumnText3.setTextColor(BestOfferViewHelper.getStatusColor(getResources(), myebaylistitem.bestOfferStatus));
            }
            ((ViewCache) (viewgroup)).rightColumnText4.setTextSize(16F);
            ((ViewCache) (viewgroup)).rightColumnText4.setSingleLine(true);
            if (myebaylistitem.transaction.createdDate != null)
            {
                ((ViewCache) (viewgroup)).rightColumnText4.setText(dateFormat.format(myebaylistitem.transaction.createdDate));
                ((ViewCache) (viewgroup)).rightColumnText4.setTextColor(colorTextDefault);
            } else
            if (((ViewCache) (viewgroup)).rightColumnText4.getText().equals(endedText) && myebaylistitem.endDate != null)
            {
                ((ViewCache) (viewgroup)).rightColumnText4.setText(dateFormat.format(myebaylistitem.endDate));
                ((ViewCache) (viewgroup)).rightColumnText4.setTextColor(colorTextDefault);
                return view;
            }
            return view;
        }

        public NotificationListAdapter(Activity activity, boolean flag, boolean flag1, List list, int i)
        {
            this$0 = ReminderItemsActivity.this;
            super(activity, new CustomItemAdapter(activity, flag, flag1, i), list, Integer.valueOf(0x7f03016d));
            resources = activity.getResources();
            colorTextDefault = resources.getColor(0x106000c);
            colorTextOutbid = resources.getColor(0x7f0d0064);
        }
    }

    private final class RemindersListAsyncTask extends EbayAsyncTask
        implements com.ebay.common.util.EbayAsyncTask.TaskHandler
    {

        private final ApplicationProcessServiceApi api;
        private final String iafToken;
        private final int myType;
        private final String pageLocator;
        final ReminderItemsActivity this$0;
        private final String userId;

        protected RemindersList doInBackgroundInternal(Object obj)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            if (!Util.hasNetwork())
            {
                throw new IOException();
            } else
            {
                return api.getReminderItems(iafToken, userId, myType, 25, pageLocator);
            }
        }

        protected volatile Object doInBackgroundInternal(Object obj)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            return doInBackgroundInternal(obj);
        }

        public void onError(int i, List list)
        {
            userCache.clearSavedSearchList();
            if (!isFinishing() && i == -1 && EbayErrorUtil.userNotLoggedIn(list) && MyApp.getPrefs().isSignedIn())
            {
                getFwLoaderManager().cancelAll(true);
                MyApp.signOutForIafTokenFailure(ReminderItemsActivity.this);
            } else
            {
                (new EbayErrorHandler(ReminderItemsActivity.this, true)).handleEbayError(i, list);
                if (i == -2 && !isFinishing())
                {
                    finish();
                    return;
                }
            }
        }

        protected void onPostExecute(RemindersList reminderslist)
        {
            super.onPostExecute(reminderslist);
            if (reminderslist == null)
            {
                setProgressOff();
            } else
            {
                hasMore = reminderslist.hasMore;
                nextPageLocator = reminderslist.nextPageLocator;
                reminderslist = reminderslist.list;
                if (myType == 1 && reminderslist != null)
                {
                    for (int i = 0; i < reminderslist.size(); i++)
                    {
                        MyEbayListItem myebaylistitem = (MyEbayListItem)reminderslist.get(i);
                        if (myebaylistitem != null && myebaylistitem.transaction != null && myebaylistitem.transaction.paidStatus != null && myebaylistitem.transaction.paidStatus.equalsIgnoreCase("Refunded"))
                        {
                            reminderslist.remove(i);
                        }
                    }

                }
                if (myType == 14 && reminderslist != null)
                {
                    for (Iterator iterator = reminderslist.iterator(); iterator.hasNext();)
                    {
                        ((MyEbayListItem)iterator.next()).bestOfferPendingCount = 1;
                    }

                }
                if (myType == 5 && reminderslist != null)
                {
                    for (Iterator iterator1 = reminderslist.iterator(); iterator1.hasNext();)
                    {
                        ((MyEbayListItem)iterator1.next()).bestOfferStatus = "Pending";
                    }

                }
                itemList.addAll(reminderslist);
                adapter.notifyDataSetChanged();
                adapter.refresh(getListView());
                setProgressOff();
                if (isActiveReminderItems())
                {
                    timer.start();
                    return;
                }
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((RemindersList)obj);
        }

        protected void onPreExecute()
        {
            if (isActiveReminderItems())
            {
                timer.stop();
            }
            super.onPreExecute();
        }

        public void onTaskComplete(RemindersList reminderslist)
        {
            findViewById(0x102000a).setEnabled(true);
        }

        public volatile void onTaskComplete(Object obj)
        {
            onTaskComplete((RemindersList)obj);
        }

        protected RemindersListAsyncTask(EbayContext ebaycontext, String s, String s1, int i, String s2)
        {
            this$0 = ReminderItemsActivity.this;
            super();
            api = EbayApiUtil.getApsApi(ebaycontext);
            iafToken = s;
            userId = s1;
            myType = i;
            pageLocator = s2;
            setHandler(this);
        }
    }


    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logMethod = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("RemindersMethod", 3, "Log Method");
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Reminders", 3, "Log Method");
    private NotificationListAdapter adapter;
    private List coupons;
    private java.text.DateFormat dateFormat;
    private String endedText;
    private boolean hasMore;
    private boolean icsCrashHackIgnoreBack;
    private boolean isCoupon;
    public List itemList;
    private boolean loadingPage;
    private String nextPageLocator;
    private int remindersType;
    private final HashSet shipCache = new HashSet();
    private final EbayTimer timer = new EbayTimer(1000L);
    private final UserCache userCache = new UserCache(this);
    private boolean userRequestedRefresh;

    public ReminderItemsActivity()
    {
        remindersType = 0;
        itemList = new ArrayList();
        hasMore = true;
        nextPageLocator = null;
        loadingPage = false;
        userRequestedRefresh = false;
    }

    private String getReminderTypeMfls()
    {
        switch (remindersType)
        {
        case 8: // '\b'
        case 9: // '\t'
        default:
            return null;

        case 0: // '\0'
            return "RBF";

        case 1: // '\001'
            return "RBP";

        case 2: // '\002'
            return "RBWE";

        case 3: // '\003'
            return "RBBE";

        case 4: // '\004'
            return "RBO";

        case 5: // '\005'
            return "RBBO";

        case 6: // '\006'
            return "RBSC";

        case 10: // '\n'
            return "RSF";

        case 11: // '\013'
            return "RSP";

        case 12: // '\f'
            return "RSS";

        case 13: // '\r'
            return "RSE";

        case 14: // '\016'
            return "RSBO";

        case 7: // '\007'
            return "RBPU";
        }
    }

    private boolean isActiveReminderItems()
    {
        switch (remindersType)
        {
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        default:
            return false;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 13: // '\r'
        case 14: // '\016'
            return true;
        }
    }

    private boolean isPaidUserCache(String s, String s1)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            s = userCache.getPaidStatusAndTime(s, s1);
            flag = flag1;
            if (s == null)
            {
                break label0;
            }
            if (!ItemTransaction.isPaidFor(((com.ebay.common.UserCache.PaidStatusAndTime) (s)).status))
            {
                flag = flag1;
                if (!ItemTransaction.isPaidUsingTradingQuirk(((com.ebay.common.UserCache.PaidStatusAndTime) (s)).status, ((com.ebay.common.UserCache.PaidStatusAndTime) (s)).apiTime))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    private void loadPage()
    {
        if (!loadingPage) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (userRequestedRefresh)
        {
            break; /* Loop/switch isn't completed */
        }
        adapter.notifyDataSetChanged();
        if (!hasMore) goto _L1; else goto _L3
_L3:
        setProgressOn();
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null)
        {
            loadingPage = true;
            DcsHelper dcshelper = MyApp.getDeviceConfiguration();
            DeviceConfiguration deviceconfiguration = dcshelper.getConfig();
            if (isCoupon && deviceconfiguration.get(DcsBoolean.Coupons) && dcshelper.isMecOrMec2Enabled(null))
            {
                getCoupons();
                return;
            } else
            {
                (new RemindersListAsyncTask(getEbayContext(), authentication.iafToken, authentication.user, remindersType, nextPageLocator)).execute(new Object[0]);
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void onGetUserIncentives(GetUserIncentivesNetLoader getuserincentivesnetloader)
    {
        boolean flag2 = true;
        boolean flag = true;
        boolean flag1 = flag2;
        if (!getuserincentivesnetloader.isError())
        {
            getuserincentivesnetloader = (com.ebay.common.net.api.cart.GetUserIncentives.GetUserIncentivesResponse)getuserincentivesnetloader.getResponse();
            flag1 = flag2;
            if (getuserincentivesnetloader != null)
            {
                flag1 = flag2;
                if (getuserincentivesnetloader.getUserIncentives() != null)
                {
                    getuserincentivesnetloader = getuserincentivesnetloader.getUserIncentives().incentives;
                    flag1 = flag2;
                    if (getuserincentivesnetloader != null)
                    {
                        flag1 = flag2;
                        if (getuserincentivesnetloader.size() > 0)
                        {
                            coupons.clear();
                            getuserincentivesnetloader = getuserincentivesnetloader.iterator();
                            do
                            {
                                flag1 = flag;
                                if (!getuserincentivesnetloader.hasNext())
                                {
                                    break;
                                }
                                Incentive incentive = (Incentive)getuserincentivesnetloader.next();
                                if (incentive.incentiveType.equals("coupon"))
                                {
                                    flag = false;
                                    coupons.add(incentive);
                                }
                            } while (true);
                        }
                    }
                }
            }
        }
        if (flag1)
        {
            setEmptyRemindersText();
            return;
        } else
        {
            findViewById(0x7f100164).setVisibility(8);
            setListAdapter(new CouponAdapter(this, 0x7f030083));
            findViewById(0x102000a).setEnabled(true);
            return;
        }
    }

    private void refreshItem(Item item)
    {
        boolean flag2 = false;
        boolean flag1 = false;
        Iterator iterator = itemList.iterator();
        do
        {
            boolean flag = flag2;
            if (!iterator.hasNext())
            {
                break;
            }
            MyEbayListItem myebaylistitem = (MyEbayListItem)iterator.next();
            if (item.id != myebaylistitem.id)
            {
                continue;
            }
            if (myebaylistitem.transaction != null)
            {
                myebaylistitem.transaction.feedbackLeft = item.feedbackLeft;
                if (item.transactionId != null)
                {
                    myebaylistitem.transaction.shipped = userCache.isShipped(item.getIdString(), Long.toString(item.transactionId.longValue()));
                } else
                {
                    myebaylistitem.transaction.shipped = false;
                }
                flag1 = true;
            }
            flag = flag1;
            if (!TextUtils.isEmpty(myebaylistitem.bestOfferStatus))
            {
                flag = flag1;
                if (!myebaylistitem.bestOfferStatus.equals(item.bestOfferStatus))
                {
                    myebaylistitem.bestOfferStatus = item.bestOfferStatus;
                    flag = true;
                }
            }
            flag1 = flag;
            if (myebaylistitem.bestOfferPendingCount > 0)
            {
                flag1 = flag;
                if (item.bestOfferCount == 0)
                {
                    myebaylistitem.bestOfferPendingCount = 0;
                    flag1 = true;
                }
            }
            flag = flag1;
            if (shouldRemoveItem(item))
            {
                adapter.remove(myebaylistitem);
                itemList.remove(myebaylistitem);
                flag = true;
            }
            break;
        } while (true);
        if (flag)
        {
            adapter.notifyDataSetChanged();
        }
        if (itemList.isEmpty())
        {
            setEmptyRemindersText();
        }
    }

    private void setEmptyRemindersText()
    {
        TextView textview = (TextView)findViewById(0x7f100164);
        if (!isCoupon) goto _L2; else goto _L1
_L1:
        textview.setText(0x7f070658);
_L4:
        textview.setVisibility(0);
        return;
_L2:
        if (remindersType == 2)
        {
            textview.setText(0x7f07066c);
        } else
        if (remindersType == 3)
        {
            textview.setText(0x7f070667);
        } else
        if (remindersType == 0 || remindersType == 10)
        {
            textview.setText(0x7f070668);
        } else
        if (remindersType == 1 || remindersType == 11)
        {
            textview.setText(0x7f070669);
        } else
        if (remindersType == 13)
        {
            textview.setText(0x7f07066a);
        } else
        if (remindersType == 12)
        {
            textview.setText(0x7f07066b);
        } else
        if (remindersType == 7)
        {
            textview.setText(0x7f070664);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setProgressOff()
    {
        findViewById(0x7f100120).setVisibility(8);
        if (!isCoupon && itemList.isEmpty())
        {
            setEmptyRemindersText();
            findViewById(0x7f100164).setVisibility(0);
        }
        loadingPage = false;
    }

    private void setProgressOn()
    {
        findViewById(0x7f100120).setVisibility(0);
        findViewById(0x7f100164).setVisibility(8);
    }

    private void setupTimer()
    {
        timer.setOnTimerEvent(new com.ebay.common.EbayTimer.OnTimerEvent() {

            final ReminderItemsActivity this$0;

            public void OnTimer()
            {
                ListAdapter listadapter = getListAdapter();
                if (listadapter != null)
                {
                    ((NotificationListAdapter)listadapter).refresh(getListView());
                }
            }

            
            {
                this$0 = ReminderItemsActivity.this;
                super();
            }
        });
    }

    private boolean shouldRemoveItem(Item item)
    {
        remindersType;
        JVM INSTR lookupswitch 4: default 48
    //                   0: 50
    //                   1: 85
    //                   10: 50
    //                   12: 59;
           goto _L1 _L2 _L3 _L2 _L4
_L1:
        return false;
_L2:
        if (item.feedbackLeft)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (userCache.isShipped(item.getIdString(), Long.toString(item.transactionId.longValue())))
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        return isPaidUserCache(item.getIdString(), Long.toString(item.transactionId.longValue()));
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (icsCrashHackIgnoreBack)
        {
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    protected void getCoupons()
    {
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        DeviceConfiguration deviceconfiguration = dcshelper.getConfig();
        if (Util.hasNetwork() && deviceconfiguration.get(DcsBoolean.Coupons) && dcshelper.isMecOrMec2Enabled(null))
        {
            Object obj = EbayApiUtil.getCartApi(this, MyApp.getPrefs().getAuthentication());
            obj = new GetUserIncentivesNetLoader(getEbayContext(), ((com.ebay.common.net.api.cart.EbayCartApi) (obj)), com.ebay.common.net.api.cart.GetUserIncentives.UserIncentiveType.COUPON);
            getFwLoaderManager().start(1, ((FwLoader) (obj)), true);
        }
    }

    public String getTrackingEventName()
    {
        return "RemindersItems";
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301c0);
        userCache.clearLeftFeedback();
        Intent intent = getIntent();
        int i;
        if (bundle != null)
        {
            i = bundle.getInt("reminders_type", remindersType);
        } else
        {
            i = intent.getIntExtra("reminders_type", remindersType);
        }
        remindersType = i;
        if (intent.getIntExtra("noti_type_id", -1) != -1)
        {
            ServiceStarter.startUpdateNotificationCacheService(this, com.ebay.common.model.mdns.NotificationPreference.EventType.COUPONAVLBL.name(), null);
        }
        if (remindersType == -1)
        {
            isCoupon = true;
            coupons = new ArrayList();
        }
        bundle = intent.getStringExtra("reminders_type_text");
        if (bundle != null)
        {
            Util.setAppStatus(this, bundle);
        }
        dateFormat = DateFormat.getDateFormat(this);
        endedText = getString(0x7f0703c3);
        adapter = new NotificationListAdapter(this, SearchUtil.showShippingCosts(), false, itemList, remindersType);
        setListAdapter(adapter);
        ContentSyncManager.register(this, new String[] {
            com/ebay/mobile/Item.getName()
        });
        loadPage();
        setupTimer();
        initDataManagers();
    }

    public void onDestroy()
    {
        ContentSyncManager.unregister(this, new String[] {
            com/ebay/mobile/Item.getName()
        });
        super.onDestroy();
    }

    public void onError(int i, List list)
    {
        userCache.clearSavedSearchList();
        if (!isFinishing() && i == -1 && EbayErrorUtil.userNotLoggedIn(list) && MyApp.getPrefs().isSignedIn())
        {
            getFwLoaderManager().cancelAll(true);
            handleIafTokenExpiration();
            return;
        } else
        {
            (new EbayErrorHandler(this, true)).handleEbayError(i, list);
            return;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        datamanagercontainer.initialize(CurrencyConversionDataManager.KEY, this);
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        if (isCoupon)
        {
            Toast.makeText(this, getString(0x7f0708de), 1).show();
        } else
        {
            view = (MyEbayListItem)getListAdapter().getItem(i);
            if (view != null)
            {
                if (((MyEbayListItem) (view)).transaction != null)
                {
                    userCache.setShipped((new StringBuilder()).append("").append(((MyEbayListItem) (view)).id).toString(), ((MyEbayListItem) (view)).transaction.transactionId, ((MyEbayListItem) (view)).transaction.shipped);
                    userCache.addToPaidStatus((new StringBuilder()).append("").append(((MyEbayListItem) (view)).id).toString(), ((MyEbayListItem) (view)).transaction.transactionId, ((MyEbayListItem) (view)).transaction.paidStatus, ((MyEbayListItem) (view)).transaction.paidTime);
                }
                icsCrashHackIgnoreBack = true;
                if (remindersType == 1)
                {
                    boolean flag;
                    if (listview.getCount() == 1)
                    {
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                    ItemViewActivity.StartActivity(this, view, com.ebay.common.ConstantsCommon.ItemKind.Won, flag);
                    return;
                }
                if (remindersType == 0)
                {
                    ItemViewActivity.StartActivity(this, view, com.ebay.common.ConstantsCommon.ItemKind.Won, true, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.LEAVE_FEEDBACK);
                    return;
                }
                if (remindersType == 5 || remindersType == 3 || remindersType == 4 || remindersType == 14)
                {
                    ItemViewActivity.StartActivity(this, view, com.ebay.common.ConstantsCommon.ItemKind.Bidding, null, null);
                    return;
                }
                if (remindersType == 6)
                {
                    ItemViewActivity.StartActivity(this, com.ebay.common.ConstantsCommon.ItemKind.Found, ((MyEbayListItem) (view)).id, null, null);
                    return;
                }
                if (remindersType == 2)
                {
                    ItemViewActivity.StartActivity(this, view, com.ebay.common.ConstantsCommon.ItemKind.Watched, null, null);
                    return;
                }
                if (remindersType == 10 || remindersType == 12 || remindersType == 11)
                {
                    com.ebay.common.ConstantsCommon.ItemKind itemkind = com.ebay.common.ConstantsCommon.ItemKind.Sold;
                    if (remindersType == 10)
                    {
                        listview = com.ebay.mobile.viewitem.ItemViewActivity.UserAction.LEAVE_FEEDBACK;
                    } else
                    {
                        listview = null;
                    }
                    ItemViewActivity.StartActivity(this, view, itemkind, null, null, listview);
                    return;
                }
                if (remindersType == 13)
                {
                    ItemViewActivity.StartActivity(this, view, com.ebay.common.ConstantsCommon.ItemKind.Selling, null, null);
                    return;
                }
                if (remindersType == 7)
                {
                    if (((MyEbayListItem) (view)).id > 0L && ((MyEbayListItem) (view)).transaction != null && !TextUtils.isEmpty(((MyEbayListItem) (view)).transaction.transactionId))
                    {
                        listview = new StringBuffer();
                        listview.append(((MyEbayListItem) (view)).id).append("-").append(((MyEbayListItem) (view)).transaction.transactionId);
                        OrderSummaryActivity.StartActivity(this, listview.toString(), new SourceIdentification(getTrackingEventName()));
                        return;
                    }
                } else
                {
                    ItemViewActivity.StartActivity(this, com.ebay.common.ConstantsCommon.ItemKind.Found, ((MyEbayListItem) (view)).id, null, null);
                    return;
                }
            }
        }
    }

    public void onPause()
    {
        super.onPause();
        if (isActiveReminderItems())
        {
            timer.stop();
        }
    }

    public void onRateChanged(CurrencyConversionDataManager currencyconversiondatamanager, CurrencyConversionRate currencyconversionrate)
    {
        adapter.notifyDataSetChanged();
    }

    public void onRateLoadComplete(CurrencyConversionDataManager currencyconversiondatamanager, ResultStatus resultstatus, CurrencyConversionRate currencyconversionrate, com.ebay.common.net.api.currency.CurrencyConversionRequest.ConversionRequestParams conversionrequestparams)
    {
    }

    public void onResume()
    {
        super.onResume();
        icsCrashHackIgnoreBack = false;
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        String s = getReminderTypeMfls();
        if (s != null)
        {
            trackingdata.addKeyValuePair("mfls", s);
            NotificationTrackingUtil.addNotificationTracking(this, trackingdata, getIntent(), com.ebay.common.model.mdns.NotificationPreference.EventType.COUPONAVLBL.name());
        }
        trackingdata.send(this);
        if (!loadingPage && isActiveReminderItems())
        {
            timer.start();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("reminders_type", remindersType);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        FwNetLoader fwnetloader;
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[] {
                Integer.valueOf(i)
            });
        }
        fwnetloader = (FwNetLoader)fwloader;
        if (!fwnetloader.isError() || fwnetloader.isCanceled())
        {
            break MISSING_BLOCK_LABEL_167;
        }
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("onTaskComplete: loader reports service error for id=").append(i).toString());
        }
        boolean flag;
        flag = false;
        i = ((flag) ? 1 : 0);
        if (!(fwnetloader instanceof EbaySimpleNetLoader))
        {
            break MISSING_BLOCK_LABEL_154;
        }
        if (!Util.checkForIAFTokenError((EbaySimpleNetLoader)fwnetloader))
        {
            break MISSING_BLOCK_LABEL_120;
        }
        getFwLoaderManager().cancelAll(true);
        MyApp.signOutForIafTokenFailure(this);
        setProgressOff();
        return;
        fwloader = MyApp.getDisplayableServiceError(getEbayContext(), (EbaySimpleNetLoader)fwnetloader);
        i = ((flag) ? 1 : 0);
        if (TextUtils.isEmpty(fwloader))
        {
            break MISSING_BLOCK_LABEL_154;
        }
        i = 1;
        ErrorDialogActivity.StartActivity(this, MyApp.getMaintenanceTitle(this), fwloader, false);
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        showNetworkErrorToast();
        setProgressOff();
        return;
        boolean flag1;
        if (isFinishing())
        {
            break MISSING_BLOCK_LABEL_204;
        }
        flag1 = fwloader.isCanceled();
        if (!flag1)
        {
            switch (i)
            {
            case 1: // '\001'
                break MISSING_BLOCK_LABEL_209;
            }
        }
_L2:
        setProgressOff();
        return;
        onGetUserIncentives((GetUserIncentivesNetLoader)fwloader);
        if (true) goto _L2; else goto _L1
_L1:
        fwloader;
        setProgressOff();
        throw fwloader;
    }

    public void onTaskComplete(Object obj)
    {
        findViewById(0x102000a).setEnabled(true);
    }

    public void updateContent(String s, Object obj)
    {
        if (com/ebay/mobile/Item.getName().equals(s))
        {
            refreshItem((Item)obj);
        }
    }











/*
    static boolean access$302(ReminderItemsActivity reminderitemsactivity, boolean flag)
    {
        reminderitemsactivity.hasMore = flag;
        return flag;
    }

*/


/*
    static String access$402(ReminderItemsActivity reminderitemsactivity, String s)
    {
        reminderitemsactivity.nextPageLocator = s;
        return s;
    }

*/





}
