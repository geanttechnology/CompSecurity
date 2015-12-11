// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.animation.Animator;
import android.app.LoaderManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.db.models.Business;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Special;
import com.groupon.db.models.Tip;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.loader.BusinessDetailLoaderCallbacks;
import com.groupon.manager.BusinessDetailSyncManager;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.nst.MerchantPageMerchantIdMetadata;
import com.groupon.models.nst.MerchantPageSpecialIdMetadata;
import com.groupon.models.nst.MerchantPageTipsMetadata;
import com.groupon.models.nst.MerchantPageUGCMetadata;
import com.groupon.service.LoginService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.AbstractRetryAsyncTask;
import com.groupon.util.CountryUtil;
import com.groupon.util.Dates;
import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.ImageUrl;
import com.groupon.util.LoaderCallbacksUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ShareHelper;
import com.groupon.util.TimeUtil;
import com.groupon.view.BusinessMapDetailedSlice;
import com.groupon.view.ObservableScrollView;
import com.groupon.view.SpinnerButton;
import com.groupon.view.Transformation.BlurImageTransformation;
import com.groupon.view.UrlImageView;
import java.io.InputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory, BusinessSpecialPage

public class BusinessDetailPage extends GrouponActivity
    implements GrouponDialogListener, commonlib.manager.SyncManager.SyncUiCallbacks
{
    private class RatingButtonTouchListener
        implements android.view.View.OnTouchListener
    {

        private boolean isThumbUp;
        final BusinessDetailPage this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            motionevent.getAction();
            JVM INSTR tableswitch 0 1: default 28
        //                       0 30
        //                       1 62;
               goto _L1 _L2 _L3
_L1:
            return false;
_L2:
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                ((ViewGroup)view).getChildAt(0).getBackground().setHotspot(motionevent.getX(), motionevent.getY());
                return false;
            }
              goto _L1
_L3:
            onButtonUp(isThumbUp);
            return false;
        }

        public RatingButtonTouchListener(boolean flag)
        {
            this$0 = BusinessDetailPage.this;
            super();
            isThumbUp = flag;
        }
    }


    private static final int DATA_STATE_FIRST_LOAD_COMPLETED = 1;
    private static final int DATA_STATE_UNLOADED = 0;
    private static final SimpleDateFormat FORMAT_OPENING_HOURS_AM_PM = new SimpleDateFormat("h:mm a");
    private final String DATA_STATE = "data_state";
    private final String IS_BUSINESS_SPECIALS_CLICKED = "is_business_specials_clicked";
    private final String NO = "no";
    private final String YES = "yes";
    private AbTestService abTestService;
    RelativeLayout businessContent;
    private BusinessDetailSyncManager businessDetailSyncManager;
    LinearLayout businessHeaderContainer;
    RelativeLayout businessHeaderParentContainer;
    String businessId;
    UrlImageView businessImage;
    private Business businessObj;
    TextView businessTitle;
    TextView categorizations;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    TextView customerRatingRecommend;
    LinearLayout customerRecommend;
    private int dataState;
    private DialogManager dialogManager;
    WebView editors;
    LinearLayout editorsContainer;
    LinearLayout hoursContainer;
    private IntentFactory intentFactory;
    private boolean isBusinessSpecialsClicked;
    private boolean isFirstScroll;
    boolean isFromRequestADeal;
    boolean isListOffers;
    private boolean isOnPause;
    String isRatingsClicked;
    private LoggingUtils loggingUtils;
    private LoginService loginService;
    BusinessMapDetailedSlice mapSlice;
    LinearLayout offersContainer;
    TextView offersHeader;
    TextView openCloseTextView;
    private final SimpleDateFormat openHoursFormat = new SimpleDateFormat("HH:mm:ss");
    TextView percentPeopleRatedTextView;
    ProgressBar progressBar;
    LinearLayout ratingsContainer;
    SpinnerButton requestDealButton;
    LinearLayout requestDealCompletedContainer;
    LinearLayout requestDealCompletedFeedbackContainer;
    LinearLayout requestDealContainer;
    LinearLayout requestDealRequestedContainer;
    ObservableScrollView scrollView;
    FrameLayout thumbDown;
    FrameLayout thumbUp;
    private TimeUtil timeUtil;
    LinearLayout tipsContainer;
    TextView totalPeopleRatedTextView;
    TextView wouldYouRecommend;
    TextView xPeopleSignedUpCompletedTextView;
    TextView xPeopleSignedUpRequestedTextView;
    TextView xPeopleSignedUpTextView;

    public BusinessDetailPage()
    {
        dataState = 0;
        isOnPause = false;
    }

    private void addDealItem(final Deal deal, boolean flag, boolean flag1, int i)
    {
        Object obj;
        View view = getLayoutInflater().inflate(0x7f030048, offersContainer, false);
        obj = (TextView)view.findViewById(0x7f100123);
        if (obj != null && deal.announcementTitle != null)
        {
            ((TextView) (obj)).setText(deal.announcementTitle);
            ((TextView) (obj)).setEllipsize(android.text.TextUtils.TruncateAt.MIDDLE);
            ((TextView) (obj)).setVisibility(0);
        }
        TextView textview = (TextView)view.findViewById(0x7f100124);
        obj = deal.getSoldQuantityMessage();
        if (textview != null && Strings.notEmpty(obj))
        {
            int j = deal.getSoldQuantity();
            Resources resources = getResources();
            if (j < 100)
            {
                obj = Integer.valueOf(j);
            }
            textview.setText(resources.getQuantityString(0x7f0c0001, j, new Object[] {
                obj
            }));
            textview.setVisibility(0);
        }
        obj = (TextView)view.findViewById(0x7f100125);
        if (obj != null && !Strings.isEmpty(deal.derivedPriceFormattedAmount))
        {
            ((TextView) (obj)).setText(deal.derivedPriceFormattedAmount);
            ((TextView) (obj)).setVisibility(0);
        }
        obj = (UrlImageView)view.findViewById(0x7f100121);
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!Strings.notEmpty(deal.derivedImageUrl)) goto _L4; else goto _L3
_L3:
        ((UrlImageView) (obj)).setImageUrl(new ImageUrl(deal.derivedImageUrl, true));
_L2:
        if (flag)
        {
            view.findViewById(0x7f100127).setVisibility(8);
        }
        if (flag1)
        {
            view.findViewById(0x7f100126).setVisibility(8);
        }
        view.setTag(deal);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final BusinessDetailPage this$0;
            final Deal val$deal;

            public void onClick(View view1)
            {
                Deal deal1 = (Deal)view1.getTag();
                LoggingUtils loggingutils = loggingUtils;
                if (isListOffers)
                {
                    view1 = "offer_screen_deal_click";
                } else
                {
                    view1 = "deal_click";
                }
                loggingutils.logClick("", view1, deal.remoteId, "");
                view1 = intentFactory.newDealIntent(deal1, Channel.MERCHANT_PAGE);
                startActivity(view1);
            }

            
            {
                this$0 = BusinessDetailPage.this;
                deal = deal1;
                super();
            }
        });
        logDealImpression(deal, i);
        offersContainer.addView(view);
        return;
_L4:
        if (Strings.notEmpty(deal.sidebarImageUrl))
        {
            ((UrlImageView) (obj)).setImageUrl(new ImageUrl(deal.sidebarImageUrl, false));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private View addHour(String s, String s1, int i, int j)
    {
        View view;
        TextView textview;
        TextView textview1;
        view = getLayoutInflater().inflate(0x7f03004e, hoursContainer, false);
        textview = (TextView)view.findViewById(0x7f100163);
        textview1 = (TextView)view.findViewById(0x7f100164);
        if (j != i) goto _L2; else goto _L1
_L1:
        textview.setText(getResources().getString(0x7f0803e0));
        textview.setTypeface(null, 1);
        textview1.setTypeface(null, 1);
_L4:
        if (textview1 != null)
        {
            textview1.setText(s1);
        }
        loggingUtils.logImpression("", "mp_ugc_hours", businessId, (new StringBuilder()).append(i).append("").toString(), JsonEncodedNSTField.NULL_JSON_NST_FIELD);
        hoursContainer.addView(view);
        return view;
_L2:
        if (textview != null)
        {
            textview.setText(s);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private View addHoursHeader()
    {
        View view = getLayoutInflater().inflate(0x7f03004d, hoursContainer, false);
        ((TextView)view.findViewById(0x7f100162)).setText(0x7f080229);
        hoursContainer.addView(view);
        return view;
    }

    private View addMoreInfo(String s, ViewGroup viewgroup)
    {
        View view = getLayoutInflater().inflate(0x7f030053, viewgroup, false);
        TextView textview = (TextView)view.findViewById(0x7f10016e);
        if (textview != null)
        {
            textview.setText(s);
        }
        viewgroup.addView(view);
        return view;
    }

    private void addSpecialItem(final Special special, boolean flag, boolean flag1, int i)
    {
        View view = getLayoutInflater().inflate(0x7f030054, offersContainer, false);
        TextView textview = (TextView)view.findViewById(0x7f10014b);
        if (textview != null && special.name != null)
        {
            textview.setText(special.name);
        }
        textview = (TextView)view.findViewById(0x7f10014c);
        if (textview != null && !Strings.isEmpty(special.shortRecurringText))
        {
            textview.setText(special.shortRecurringText);
            textview.setVisibility(0);
        }
        if (special.claimed)
        {
            ((ImageView)view.findViewById(0x7f10016f)).setImageResource(0x7f02028a);
        }
        if (flag)
        {
            view.findViewById(0x7f100127).setVisibility(8);
        }
        if (flag1)
        {
            View view1 = view.findViewById(0x7f100170);
            view1.setVisibility(0);
            view1.setOnClickListener(new android.view.View.OnClickListener() {

                final BusinessDetailPage this$0;
                final Special val$special;

                public void onClick(View view2)
                {
                    loggingUtils.logClick("", "special_click", special.remoteId, loggingUtils.encodeAsJson(new MerchantPageMerchantIdMetadata(businessId)));
                    startActivity((new Intent(BusinessDetailPage.this, com/groupon/activity/BusinessSpecialPage)).putExtra("special_id", special.remoteId).putExtra("isDeepLinked", false).putExtra("business_id", businessId));
                }

            
            {
                this$0 = BusinessDetailPage.this;
                special = special1;
                super();
            }
            });
            view.findViewById(0x7f100126).setVisibility(8);
        } else
        {
            view.setTag(special);
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final BusinessDetailPage this$0;
                final Special val$special;

                public void onClick(View view2)
                {
                    Special special1 = (Special)view2.getTag();
                    LoggingUtils loggingutils = loggingUtils;
                    if (isListOffers)
                    {
                        view2 = "offer_screen_special_click";
                    } else
                    {
                        view2 = "special_click";
                    }
                    loggingutils.logClick("", view2, special.remoteId, loggingUtils.encodeAsJson(new MerchantPageMerchantIdMetadata(businessId)));
                    startActivity((new Intent(BusinessDetailPage.this, com/groupon/activity/BusinessSpecialPage)).putExtra("special_id", special1.remoteId).putExtra("isDeepLinked", false).putExtra("business_id", businessId));
                }

            
            {
                this$0 = BusinessDetailPage.this;
                special = special1;
                super();
            }
            });
        }
        logSpecialImpression(special, i);
        offersContainer.addView(view);
    }

    private View addTip(Tip tip)
    {
        View view = getLayoutInflater().inflate(0x7f030051, tipsContainer, false);
        TextView textview = (TextView)view.findViewById(0x7f10016b);
        if (textview != null)
        {
            textview.setText(tip.maskedName);
        }
        textview = (TextView)view.findViewById(0x7f10016a);
        if (textview != null)
        {
            textview.setText(tip.text.trim());
        }
        textview = (TextView)view.findViewById(0x7f10016c);
        if (textview != null)
        {
            textview.setText(Dates.getTimeStampStringExtended(this, tip.updatedAt.getTime()));
        }
        tipsContainer.addView(view);
        return view;
    }

    private boolean checkIfStoreIsOpen(String as[])
    {
        String as1[];
        Date date1;
        int i;
        int j;
        int k;
        int l;
        i = Calendar.getInstance().get(7);
        as1 = as[(new int[] {
            6, 0, 1, 2, 3, 4, 5
        })[i - 1]].split(",");
        date1 = new Date();
        as = Calendar.getInstance();
        j = as.get(1);
        k = as.get(2);
        l = as.get(5);
        as.setTime(date1);
        i = 0;
_L7:
        if (i >= as1.length) goto _L2; else goto _L1
_L1:
        as = as1[i].split("/");
        if (as.length != 2) goto _L4; else goto _L3
_L3:
        Date date;
        Date date2;
        date2 = timeUtil.createDateFromTimeAndDate(openHoursFormat.parse(as[0].split("-")[0]).getTime(), j, k, l);
        date = timeUtil.createDateFromTimeAndDate(openHoursFormat.parse(as[1].split("-")[0]).getTime(), j, k, l);
        as = date;
        long l1;
        long l2;
        if (date.before(date2))
        {
            as = Calendar.getInstance();
            as.setTime(date);
            as.add(5, 1);
            as = as.getTime();
        }
        if (date2.getTime() > date1.getTime())
        {
            break MISSING_BLOCK_LABEL_270;
        }
        l1 = date1.getTime();
        l2 = as.getTime();
        if (l1 <= l2)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_270;
        as;
        Ln.e(as);
_L5:
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        Ln.d("Bad interval format: %s", new Object[] {
            as
        });
        if (true) goto _L5; else goto _L2
_L2:
        return false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private int findPositionInArray(String as[], String s)
    {
        for (int i = 0; i < as.length; i++)
        {
            if (as[i].equalsIgnoreCase(s))
            {
                return i;
            }
        }

        return -1;
    }

    private String formatInt(int i)
    {
        return NumberFormat.getIntegerInstance().format(i);
    }

    private String getIntervals(String s)
        throws Exception
    {
        StringBuffer stringbuffer = new StringBuffer();
        s = s.split(",");
        int i = 0;
        while (i < s.length) 
        {
            Object obj = s[i].split("/");
            if (obj.length == 2)
            {
                String s1 = FORMAT_OPENING_HOURS_AM_PM.format(openHoursFormat.parse(obj[0].split("-")[0]));
                obj = FORMAT_OPENING_HOURS_AM_PM.format(openHoursFormat.parse(obj[1].split("-")[0]));
                stringbuffer.append(s1);
                stringbuffer.append(" - ");
                stringbuffer.append(((String) (obj)));
            } else
            if (obj.length == 1)
            {
                stringbuffer.append(obj[0]);
            }
            if (i != s.length - 1)
            {
                if (i % 2 == 1)
                {
                    stringbuffer.append("\n");
                } else
                {
                    stringbuffer.append(", ");
                }
            }
            i++;
        }
        return stringbuffer.toString();
    }

    private void handleRatings(Business business)
    {
        int i = -1;
        int j = Integer.parseInt(business.totalMessage);
        i = j;
_L2:
        loggingUtils.logImpression("", "mp_ugc_rating", businessId, "", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
        wouldYouRecommend.setText(String.format(getString(0x7f080421), new Object[] {
            business.name
        }));
        String s = business.percentMessage;
        String s1 = business.totalMessage;
        if (!Strings.isEmpty(s) && !Strings.isEmpty(s1) && i > 0)
        {
            customerRatingRecommend.setText(String.format(getString(0x7f08011d), new Object[] {
                business.percentMessage, business.totalMessage
            }));
        } else
        {
            customerRatingRecommend.setVisibility(8);
        }
        thumbUp.setSelected(Strings.equalsIgnoreCase(business.getRecommend(), "yes"));
        thumbDown.setSelected(Strings.equalsIgnoreCase(business.getRecommend(), "no"));
        thumbUp.setOnTouchListener(new RatingButtonTouchListener(true));
        thumbDown.setOnTouchListener(new RatingButtonTouchListener(false));
        if (!Strings.isEmpty(isRatingsClicked))
        {
            ratingsContainer.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final BusinessDetailPage this$0;

                public void onGlobalLayout()
                {
                    Handler handler = new Handler(getApplicationContext().getMainLooper());
                    handler.postDelayed(new Runnable() {

                        final _cls4 this$1;

                        public void run()
                        {
                            scrollView.smoothScrollTo(0, (int)ratingsContainer.getY());
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    }, 500L);
                    handler.postDelayed(new Runnable() {

                        final _cls4 this$1;

                        public void run()
                        {
                            progressBar.setVisibility(8);
                            businessContent.setVisibility(0);
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    }, 1000L);
                    ratingsContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

            
            {
                this$0 = BusinessDetailPage.this;
                super();
            }
            });
            onButtonUp(Strings.equalsIgnoreCase(isRatingsClicked, "yes"));
            isRatingsClicked = null;
            getIntent().putExtra("is_ratings_clicked", "");
        }
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void handleRequestDealAndSetOffers(final Business business)
    {
        final int messageLengthFinal = -1;
        int i = Integer.parseInt(business.requestedDealMessage);
        messageLengthFinal = i;
_L2:
        if (isBusinessSpecialsClicked && !isListOffers)
        {
            TextView textview = xPeopleSignedUpCompletedTextView;
            if (messageLengthFinal > 1)
            {
                business = String.format(getResources().getQuantityString(0x7f0c0021, messageLengthFinal), new Object[] {
                    formatInt(messageLengthFinal)
                });
            } else
            {
                business = getString(0x7f080324);
            }
            textview.setText(business);
            xPeopleSignedUpCompletedTextView.setVisibility(0);
            logRequestADealImpression();
            showRequestDealActionCompleteView();
            return;
        }
        if (businessObj.getDeals().isEmpty() && businessObj.getSpecials().isEmpty())
        {
            requestDealButton.setOnClickListener(new android.view.View.OnClickListener() {

                final BusinessDetailPage this$0;
                final Business val$business;
                final int val$messageLengthFinal;

                public void onClick(View view)
                {
                    LoggingUtils loggingutils = loggingUtils;
                    String s = business.remoteId;
                    if (messageLengthFinal >= 0)
                    {
                        view = formatInt(messageLengthFinal);
                    } else
                    {
                        view = "0";
                    }
                    loggingutils.logClick("", "rad_click", s, view);
                    if (loginService.isLoggedIn())
                    {
                        requestDeal(messageLengthFinal);
                        return;
                    } else
                    {
                        startActivity(intentFactory.newLoginIntent(getApplicationContext(), intentFactory.newMerchantPageIntent(businessId).putExtra("is_request_deal_clicked", true)));
                        finish();
                        return;
                    }
                }

            
            {
                this$0 = BusinessDetailPage.this;
                business = business1;
                messageLengthFinal = i;
                super();
            }
            });
            if (business.requestedDeal)
            {
                TextView textview1 = xPeopleSignedUpRequestedTextView;
                if (messageLengthFinal > 1)
                {
                    business = String.format(getResources().getQuantityString(0x7f0c0021, messageLengthFinal - 1), new Object[] {
                        formatInt(messageLengthFinal - 1)
                    });
                } else
                {
                    business = getString(0x7f080324);
                }
                textview1.setText(business);
                xPeopleSignedUpRequestedTextView.setVisibility(0);
                showRequestDealRequestedView();
            } else
            if (isFromRequestADeal)
            {
                showRequestDealView();
                requestDeal(messageLengthFinal);
            } else
            {
                TextView textview2 = xPeopleSignedUpTextView;
                if (messageLengthFinal > 0)
                {
                    business = String.format(getResources().getQuantityString(0x7f0c001e, messageLengthFinal), new Object[] {
                        formatInt(messageLengthFinal)
                    });
                } else
                {
                    business = getString(0x7f080325);
                }
                textview2.setText(business);
                xPeopleSignedUpTextView.setVisibility(0);
                showRequestDealView();
            }
            logRequestADealImpression();
            return;
        } else
        {
            requestDealContainer.setVisibility(8);
            setOffersSection(businessObj.getDeals(), businessObj.getSpecials(), businessObj.orderingListString);
            return;
        }
        NumberFormatException numberformatexception;
        numberformatexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void hideHoursSection()
    {
        hoursContainer.setVisibility(8);
        openCloseTextView.setVisibility(8);
    }

    private void initLoader()
    {
        getLoaderManager().initLoader(0, null, new BusinessDetailLoaderCallbacks(this, businessId) {

            final BusinessDetailPage this$0;

            public void onMerchantDetailLoaded(Business business)
            {
                if (dataState == 0)
                {
                    dataState = 1;
                } else
                if (business != null)
                {
                    businessObj = business;
                    if (Strings.isEmpty(isRatingsClicked))
                    {
                        progressBar.setVisibility(8);
                        businessContent.setVisibility(0);
                        scrollView.post(new Runnable() {

                            final _cls1 this$1;

                            public void run()
                            {
                                if (isFirstScroll)
                                {
                                    scrollView.smoothScrollTo(0, 0);
                                    isFirstScroll = false;
                                }
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                    }
                    populateViewOnDataLoaded(business);
                    initActionBar(null);
                    return;
                }
            }

            
            {
                this$0 = BusinessDetailPage.this;
                super(context, s);
            }
        });
    }

    private void logDealImpression(Deal deal, int i)
    {
        DealSummary dealsummary = new DealSummary(deal, Channel.MERCHANT_PAGE);
        loggingUtils.logDealImpressionV1(Channel.MERCHANT_PAGE.toString(), "", dealsummary, i, JsonEncodedNSTField.NULL_JSON_NST_FIELD, deal.uuid, abTestService, false, false, false);
    }

    private void logOpenCloseImpression(String s)
    {
        loggingUtils.logImpression("", s, businessId, "mp_header", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
    }

    private void logRequestADealImpression()
    {
        loggingUtils.logImpression("", "mp_rad", businessId, "0", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
    }

    private void logSpecialImpression(Special special, int i)
    {
        LoggingUtils loggingutils = loggingUtils;
        String s;
        if (isListOffers)
        {
            s = "offer_screen_special";
        } else
        {
            s = "mp_special";
        }
        loggingutils.logImpression("", s, businessId, (new StringBuilder()).append(i).append("").toString(), new MerchantPageSpecialIdMetadata(special.remoteId));
    }

    private void openShareDialog()
    {
        if (businessObj != null)
        {
            loggingUtils.logClick("", "share_medium_click", "share_merchant", loggingUtils.encodeAsJson(new MerchantPageMerchantIdMetadata(businessId)));
            String s;
            String s1;
            if (Strings.notEmpty(businessObj.name))
            {
                s = businessObj.name;
            } else
            {
                s = "";
            }
            if (Strings.notEmpty(businessObj.businessUrl))
            {
                s1 = businessObj.businessUrl;
            } else
            {
                s1 = "";
            }
            (new ShareHelper(this, s, s1)).shareAndLog(s, s1);
        }
    }

    private void populateViewOnDataLoaded(final Business business)
    {
        businessTitle.setText(business.name);
        offersContainer.removeAllViews();
        tipsContainer.removeAllViews();
        hoursContainer.removeAllViews();
        final Object tips = business.percentMessage;
        String s = business.totalMessage;
        if (!Strings.isEmpty(tips) && !Strings.isEmpty(s))
        {
            percentPeopleRatedTextView.setText((new StringBuilder()).append(business.percentMessage).append("%").toString());
            totalPeopleRatedTextView.setText(String.format(getString(0x7f080423), new Object[] {
                business.totalMessage
            }));
            customerRecommend.setVisibility(0);
            loggingUtils.logImpression("", "mp_ugc", businessId, "mp_header", new MerchantPageUGCMetadata((new StringBuilder()).append(business.percentMessage).append("% ").append(String.format(getString(0x7f080423), new Object[] {
                business.totalMessage
            })).toString()));
        } else
        {
            loggingUtils.logImpression("", "mp_ugc", businessId, "mp_header", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
            customerRecommend.setVisibility(8);
        }
        if (!Strings.isEmpty(business.heroImageUrl))
        {
            businessImage.setImageUrl((new StringBuilder()).append(business.heroImageUrl).append("t670x147.jpg").toString(), new BlurImageTransformation());
        }
        if (!Strings.isEmpty(business.categorizationFriendlyName))
        {
            categorizations.setText(business.categorizationFriendlyName);
        } else
        {
            categorizations.setVisibility(8);
        }
        businessHeaderParentContainer.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final BusinessDetailPage this$0;

            public void onGlobalLayout()
            {
                float f = TypedValue.applyDimension(1, 2.0F, getResources().getDisplayMetrics());
                if (customerRecommend.getVisibility() == 8 && categorizations.getVisibility() == 8 && businessTitle.getX() + (float)businessTitle.getWidth() > openCloseTextView.getX())
                {
                    android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)businessTitle.getLayoutParams();
                    layoutparams.setMargins(layoutparams.leftMargin, layoutparams.topMargin, (int)(((float)businessTitle.getWidth() - openCloseTextView.getX()) + f), layoutparams.bottomMargin);
                    businessTitle.setLayoutParams(layoutparams);
                }
                if (categorizations.getVisibility() == 0 && categorizations.getX() + (float)categorizations.getWidth() > openCloseTextView.getX())
                {
                    android.widget.LinearLayout.LayoutParams layoutparams1 = (android.widget.LinearLayout.LayoutParams)categorizations.getLayoutParams();
                    layoutparams1.setMargins(layoutparams1.leftMargin, layoutparams1.topMargin, (int)(((float)categorizations.getWidth() - openCloseTextView.getX()) + f), layoutparams1.bottomMargin);
                    businessTitle.setLayoutParams(layoutparams1);
                }
                businessHeaderContainer.setVisibility(0);
                businessHeaderParentContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }

            
            {
                this$0 = BusinessDetailPage.this;
                super();
            }
        });
        if (isListOffers)
        {
            tipsContainer.setVisibility(8);
            hoursContainer.setVisibility(8);
            editorsContainer.setVisibility(8);
            ratingsContainer.setVisibility(8);
            loggingUtils.logPageView("", "merchant_offers_page", new MerchantPageMerchantIdMetadata(businessId));
            handleRequestDealAndSetOffers(business);
            return;
        }
        handleRequestDealAndSetOffers(business);
        try
        {
            processDateTime(business);
        }
        // Misplaced declaration of an exception variable
        catch (final Object tips)
        {
            hideHoursSection();
        }
        if (Strings.notEmpty(business.descriptionHtml))
        {
            editorsContainer.setVisibility(0);
            editors.loadDataWithBaseURL(null, (new StringBuilder()).append("<style type=text/css>p{color:#75787b;}</style>").append(business.descriptionHtml).toString(), "text/html", "utf-8", null);
        } else
        {
            editorsContainer.setVisibility(8);
        }
        mapSlice.setMapLocationsContainerForBusiness(business, business.getLocations());
        tips = business.getTips();
        if (((List) (tips)).size() > 0)
        {
            addTipHeader();
            tipsContainer.setVisibility(0);
            for (int i = 0; i < ((List) (tips)).size(); i++)
            {
                addTip((Tip)((List) (tips)).get(i));
            }

            View view = addMoreInfo(String.format(getString(0x7f080351), new Object[] {
                Integer.valueOf(business.tipCount)
            }), tipsContainer);
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final BusinessDetailPage this$0;
                final Business val$business;
                final List val$tips;

                public void onClick(View view1)
                {
                    view1 = intentFactory.newBusinessTipsIntent(businessId);
                    loggingUtils.logClick("", "mp_tips_see_all", business.remoteId, loggingUtils.encodeAsJson(new MerchantPageTipsMetadata(Integer.toString(tips.size()), Integer.toString(business.tipCount))));
                    startActivity(view1);
                }

            
            {
                this$0 = BusinessDetailPage.this;
                business = business1;
                tips = list;
                super();
            }
            });
            if (business.tipCount == ((List) (tips)).size())
            {
                view.setVisibility(8);
            } else
            {
                view.setVisibility(0);
            }
            loggingUtils.logImpression("", "mp_ugc_tips", businessId, "", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
        } else
        {
            tipsContainer.setVisibility(8);
        }
        handleRatings(business);
    }

    private void processDateTime(Business business)
    {
        HashMap hashmap = business.openHoursMap;
        if (!hashmap.keySet().isEmpty()) goto _L2; else goto _L1
_L1:
        hideHoursSection();
_L8:
        return;
_L2:
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        Object obj;
        String as[];
        int i;
        boolean flag;
        int j;
        obj = getResources();
        business = new String[7];
        business[0] = "Mon";
        business[1] = "Tue";
        business[2] = "Wed";
        business[3] = "Thu";
        business[4] = "Fri";
        business[5] = "Sat";
        business[6] = "Sun";
        s = ((Resources) (obj)).getString(0x7f08026d);
        s1 = ((Resources) (obj)).getString(0x7f0803f1);
        s2 = ((Resources) (obj)).getString(0x7f080417);
        s3 = ((Resources) (obj)).getString(0x7f0803da);
        s4 = ((Resources) (obj)).getString(0x7f0801d6);
        s5 = ((Resources) (obj)).getString(0x7f08033d);
        obj = ((Resources) (obj)).getString(0x7f0803c7);
        as = extractDayIntervals(hashmap, business);
        addHoursHeader();
        j = Calendar.getInstance().get(7);
        flag = false;
        i = 0;
_L4:
        if (i >= business.length)
        {
            break; /* Loop/switch isn't completed */
        }
        addHour((new String[] {
            s, s1, s2, s3, s4, s5, obj
        })[i], getIntervals(as[i]), i, (j + 5) % 7);
        flag = true;
_L11:
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (!checkIfStoreIsOpen(as)) goto _L6; else goto _L5
_L5:
        openCloseTextView.setCompoundDrawablesWithIntrinsicBounds(0x7f0201ac, 0, 0, 0);
        openCloseTextView.setText(getString(0x7f0802c7));
        logOpenCloseImpression("open");
_L9:
        openCloseTextView.setVisibility(0);
_L10:
        if (!flag) goto _L8; else goto _L7
_L7:
        hoursContainer.setVisibility(0);
        return;
_L6:
        openCloseTextView.setCompoundDrawablesWithIntrinsicBounds(0x7f0202c9, 0, 0, 0);
        openCloseTextView.setText(getString(0x7f0800bc));
        logOpenCloseImpression("closed");
          goto _L9
        business;
          goto _L10
        Exception exception;
        exception;
          goto _L11
    }

    private void rateBusiness(final boolean isThumbUp)
    {
        if (Strings.isEmpty(businessId))
        {
            return;
        }
        String s1 = businessObj.getRecommend();
        Business business = businessObj;
        String s;
        if (isThumbUp)
        {
            s = "yes";
        } else
        {
            s = "no";
        }
        business.recommend = s;
        (new AbstractRetryAsyncTask(s1) {

            final BusinessDetailPage this$0;
            final boolean val$isThumbUp;
            final String val$oldRecommend;

            public InputStream call()
                throws Exception
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add("recommend");
                String s2;
                if (isThumbUp)
                {
                    s2 = "yes";
                } else
                {
                    s2 = "no";
                }
                arraylist.add(s2);
                s2 = String.format("https:/businesses/%s/recommendations", new Object[] {
                    businessId
                });
                return (InputStream)(new SyncHttp(getApplicationContext(), java/io/InputStream, s2)).nvps(arraylist.toArray()).method("POST").call();
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            protected void onException(Exception exception)
            {
                super.onException(exception);
            }

            protected void onPreExecute()
                throws Exception
            {
                super.onPreExecute();
            }

            protected void onSuccess(InputStream inputstream)
                throws Exception
            {
                super.onSuccess(inputstream);
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((InputStream)obj);
            }

            public void onUserCancelRetry()
            {
                boolean flag = false;
                if (Strings.isEmpty(oldRecommend))
                {
                    thumbUp.setSelected(false);
                    thumbDown.setSelected(false);
                    businessObj.recommend = oldRecommend;
                    return;
                }
                Object obj = thumbUp;
                if (!isThumbUp)
                {
                    flag = true;
                }
                ((FrameLayout) (obj)).setSelected(flag);
                thumbDown.setSelected(isThumbUp);
                Business business1 = businessObj;
                if (!isThumbUp)
                {
                    obj = "yes";
                } else
                {
                    obj = "no";
                }
                business1.recommend = ((String) (obj));
            }

            
            {
                this$0 = BusinessDetailPage.this;
                isThumbUp = flag;
                oldRecommend = s;
                super(final_context);
            }
        }).execute();
    }

    private void requestDeal(int i)
    {
        if (Strings.isEmpty(businessId))
        {
            return;
        } else
        {
            requestDealButton.startSpinning();
            (new AbstractRetryAsyncTask(i) {

                final BusinessDetailPage this$0;
                final int val$messageLength;

                public InputStream call()
                    throws Exception
                {
                    ArrayList arraylist = new ArrayList();
                    arraylist.add("request_deal");
                    arraylist.add(Boolean.valueOf(true));
                    arraylist.add("business_id");
                    arraylist.add(businessId);
                    String s = String.format("https:/users/%s/followed_businesses", new Object[] {
                        loginService.getConsumerId()
                    });
                    return (InputStream)(new SyncHttp(getApplicationContext(), java/io/InputStream, s)).nvps(arraylist.toArray()).method("POST").call();
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

                protected void onPreExecute()
                    throws Exception
                {
                    super.onPreExecute();
                }

                protected void onSuccess(InputStream inputstream)
                    throws Exception
                {
                    requestDealButton.stopSpinning();
                    if (messageLength > 0)
                    {
                        xPeopleSignedUpCompletedTextView.setText(String.format(getResources().getQuantityString(0x7f0c0021, messageLength), new Object[] {
                            formatInt(messageLength)
                        }));
                        xPeopleSignedUpCompletedTextView.setVisibility(0);
                    } else
                    {
                        xPeopleSignedUpCompletedTextView.setVisibility(8);
                    }
                    showRequestDealActionCompleteView();
                    isBusinessSpecialsClicked = true;
                    super.onSuccess(inputstream);
                }

                protected volatile void onSuccess(Object obj)
                    throws Exception
                {
                    onSuccess((InputStream)obj);
                }

                public void onUserCancelRetry()
                {
                    requestDealButton.stopSpinning();
                }

            
            {
                this$0 = BusinessDetailPage.this;
                messageLength = i;
                super(final_context);
            }
            }).execute();
            return;
        }
    }

    private void setDeals(List list, List list1, boolean flag, boolean flag1)
    {
        if (list.size() == 1 && list1.isEmpty())
        {
            addDealItem((Deal)list.get(0), true, true, 0);
        } else
        {
            int i = 0;
            while (i < list.size() && (i != 3 || isListOffers)) 
            {
                if (isListOffers)
                {
                    Deal deal = (Deal)list.get(i);
                    int j;
                    boolean flag2;
                    if (i == list.size() - 1 && flag)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    if (flag1)
                    {
                        j = i;
                    } else
                    {
                        j = list1.size() + i;
                    }
                    addDealItem(deal, flag2, false, j);
                } else
                {
                    Deal deal1 = (Deal)list.get(i);
                    int k;
                    boolean flag3;
                    if ((i == list.size() - 1 || i == 2) && flag)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    if (flag1)
                    {
                        k = i;
                    } else
                    {
                        k = list1.size() + i;
                    }
                    addDealItem(deal1, flag3, false, k);
                }
                i++;
            }
        }
    }

    private void setOffersSection(List list, List list1, String s)
    {
        if (!list.isEmpty() || !list1.isEmpty()) goto _L2; else goto _L1
_L1:
        offersHeader.setVisibility(8);
_L5:
        return;
_L2:
        offersContainer.setVisibility(0);
        boolean flag = false;
        boolean flag1 = false;
        Object obj = null;
        int i;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        try
        {
            s = s.split("\\s+");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = obj;
        }
        if (s != null) goto _L4; else goto _L3
_L3:
        setDeals(list, list1, false, true);
        setSpecials(list, list1, true, false);
        flag2 = true;
        i = 1;
_L6:
        if ((list.size() > 3 && flag2 || list1.size() > 3 && i != 0) && !isListOffers)
        {
            if (flag2 && i == 0)
            {
                list = addMoreInfo(String.format(getString(0x7f080350), new Object[] {
                    Integer.valueOf(list.size())
                }), offersContainer);
            } else
            if (!flag2 && i != 0)
            {
                list = addMoreInfo(String.format(getString(0x7f080350), new Object[] {
                    Integer.valueOf(list1.size())
                }), offersContainer);
            } else
            {
                list = addMoreInfo(String.format(getString(0x7f080350), new Object[] {
                    Integer.valueOf(list.size() + list1.size())
                }), offersContainer);
            }
            list.setOnClickListener(new android.view.View.OnClickListener() {

                final BusinessDetailPage this$0;

                public void onClick(View view)
                {
                    loggingUtils.logClick("", "mp_offers_see_all", businessId, "");
                    startActivity((new Intent(BusinessDetailPage.this, com/groupon/activity/BusinessDetailPage)).putExtra("business_id", businessId).putExtra("is_list_offers", true));
                }

            
            {
                this$0 = BusinessDetailPage.this;
                super();
            }
            });
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
        i = 0;
        while (i < s.length) 
        {
            if (s[i].equals("deals"))
            {
                flag2 = true;
                if (i == s.length - 1)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                if (!flag1)
                {
                    flag4 = true;
                } else
                {
                    flag4 = false;
                }
                setDeals(list, list1, flag3, flag4);
            } else
            {
                flag2 = flag;
                if (s[i].equals("specials"))
                {
                    flag1 = true;
                    if (i == s.length - 1)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    if (!flag)
                    {
                        flag4 = true;
                    } else
                    {
                        flag4 = false;
                    }
                    setSpecials(list, list1, flag3, flag4);
                    flag2 = flag;
                }
            }
            i++;
            flag = flag2;
        }
        if (!flag && !flag1)
        {
            offersHeader.setVisibility(8);
            flag2 = flag;
            i = ((flag1) ? 1 : 0);
        } else
        if (!flag && flag1 && list1.isEmpty())
        {
            offersHeader.setVisibility(8);
            flag2 = flag;
            i = ((flag1) ? 1 : 0);
        } else
        {
            flag2 = flag;
            i = ((flag1) ? 1 : 0);
            if (!flag1)
            {
                flag2 = flag;
                i = ((flag1) ? 1 : 0);
                if (flag)
                {
                    flag2 = flag;
                    i = ((flag1) ? 1 : 0);
                    if (list.isEmpty())
                    {
                        offersHeader.setVisibility(8);
                        flag2 = flag;
                        i = ((flag1) ? 1 : 0);
                    }
                }
            }
        }
          goto _L6
    }

    private void setSpecials(List list, List list1, boolean flag, boolean flag1)
    {
        if (list1.size() == 1 && list.isEmpty())
        {
            addSpecialItem((Special)list1.get(0), true, true, list.size());
        } else
        {
            int i = 0;
            while (i < list1.size() && (i != 3 || isListOffers)) 
            {
                if (isListOffers)
                {
                    Special special = (Special)list1.get(i);
                    int j;
                    boolean flag2;
                    if (i == list1.size() - 1 && flag)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    if (flag1)
                    {
                        j = i;
                    } else
                    {
                        j = list.size() + i;
                    }
                    addSpecialItem(special, flag2, false, j);
                } else
                {
                    Special special1 = (Special)list1.get(i);
                    int k;
                    boolean flag3;
                    if ((i == list1.size() - 1 || i == 2) && flag)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    if (flag1)
                    {
                        k = i;
                    } else
                    {
                        k = list.size() + i;
                    }
                    addSpecialItem(special1, flag3, false, k);
                }
                i++;
            }
        }
    }

    private void showRequestDealActionCompleteView()
    {
        requestDealContainer.setVisibility(8);
        requestDealCompletedContainer.setVisibility(0);
        requestDealCompletedFeedbackContainer.setVisibility(0);
        requestDealRequestedContainer.setVisibility(8);
    }

    private void showRequestDealRequestedView()
    {
        requestDealContainer.setVisibility(8);
        requestDealCompletedContainer.setVisibility(0);
        requestDealCompletedFeedbackContainer.setVisibility(8);
        requestDealRequestedContainer.setVisibility(0);
    }

    private void showRequestDealView()
    {
        requestDealContainer.setVisibility(0);
        requestDealCompletedContainer.setVisibility(8);
    }

    protected View addTipHeader()
    {
        View view = getLayoutInflater().inflate(0x7f030052, tipsContainer, false);
        tipsContainer.addView(view);
        return view;
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
    }

    protected String[] extractDayIntervals(HashMap hashmap, String as[])
    {
        String as1[] = new String[as.length];
        Iterator iterator = hashmap.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            String as2[] = s.split("-");
            if (as2.length == 2)
            {
                int i = findPositionInArray(as, as2[0]);
                int k = findPositionInArray(as, as2[1]);
                if (i == k)
                {
                    as1[i] = (String)hashmap.get(s);
                } else
                if (i >= 0 && k >= 0 && i < as.length && k < as.length)
                {
                    while (i != k) 
                    {
                        if (i >= as.length)
                        {
                            i = 0;
                        } else
                        {
                            as1[i] = (String)hashmap.get(s);
                            i++;
                        }
                    }
                    as1[i] = (String)hashmap.get(s);
                }
            } else
            if (as2.length == 1)
            {
                as1[findPositionInArray(as, as2[0])] = (String)hashmap.get(s);
            }
        } while (true);
        hashmap = getResources().getString(0x7f0800bc);
        for (int j = 0; j < as1.length; j++)
        {
            if (Strings.isEmpty(as1[j]))
            {
                as1[j] = hashmap;
            }
        }

        return as1;
    }

    public String getBusinessId()
    {
        return businessId;
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        LoaderCallbacksUtil.handleSyncError(runnable, exception, this, loginService, countryUtil, currentCountryManager.getCurrentCountry(), businessDetailSyncManager, intentFactory, new Function2() {

            final BusinessDetailPage this$0;

            public volatile void execute(Object obj, Object obj1)
                throws Exception
            {
                execute((Runnable)obj, (Exception)obj1);
            }

            public void execute(Runnable runnable1, Exception exception1)
            {
                if (!isOnPause)
                {
                    runnable1 = dialogManager.getDialogFragment(Integer.valueOf(0x7f080165));
                    runnable1.setCancelable(false);
                    GrouponDialogFragment.show(getFragmentManager(), runnable1, "http_error_dialog");
                }
            }

            
            {
                this$0 = BusinessDetailPage.this;
                super();
            }
        });
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        if (businessObj != null)
        {
            bundle = businessObj.name;
        } else
        {
            bundle = "";
        }
        setToolbarTitle(bundle);
    }

    protected void onButtonUp(boolean flag)
    {
        boolean flag1 = true;
        if (flag)
        {
            loggingUtils.logClick("", "mp_ugc_rating_up", businessObj.remoteId, String.format(getString(0x7f08011d), new Object[] {
                businessObj.percentMessage, businessObj.totalMessage
            }));
        } else
        {
            loggingUtils.logClick("", "mp_ugc_rating_down", businessObj.remoteId, String.format(getString(0x7f08011d), new Object[] {
                businessObj.percentMessage, businessObj.totalMessage
            }));
        }
        if (loginService.isLoggedIn())
        {
            if (businessObj.getRecommend().equalsIgnoreCase("yes") && flag || businessObj.getRecommend().equalsIgnoreCase("no") && !flag)
            {
                return;
            }
            thumbUp.setSelected(flag);
            FrameLayout framelayout = thumbDown;
            if (flag)
            {
                flag1 = false;
            }
            framelayout.setSelected(flag1);
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                FrameLayout framelayout1;
                if (flag)
                {
                    framelayout1 = thumbUp;
                } else
                {
                    framelayout1 = thumbDown;
                }
                ViewAnimationUtils.createCircularReveal(framelayout1, framelayout1.getWidth() / 2, framelayout1.getHeight() / 2, 0.0F, framelayout1.getHeight()).start();
            }
            rateBusiness(flag);
            return;
        }
        IntentFactory intentfactory = intentFactory;
        Context context = getApplicationContext();
        Intent intent = intentFactory.newMerchantPageIntent(businessId);
        String s;
        if (flag)
        {
            s = "yes";
        } else
        {
            s = "no";
        }
        startActivity(intentfactory.newLoginIntent(context, intent.putExtra("is_ratings_clicked", s)));
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030049);
        businessDetailSyncManager.setMerchantId(businessId);
        initLoader();
        isFirstScroll = true;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 0x7f10001d, 0, 0x7f080370).setIcon(0x7f0201f5).setShowAsAction(2);
        return super.onCreateOptionsMenu(menu);
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        finish();
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131755037 2131755037: default 24
    //                   2131755037 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        openShareDialog();
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onPause()
    {
        super.onPause();
        isOnPause = true;
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (bundle != null)
        {
            isBusinessSpecialsClicked = bundle.getBoolean("is_business_specials_clicked", false);
            dataState = bundle.getInt("data_state");
        }
    }

    protected void onResume()
    {
        super.onResume();
        isOnPause = false;
        loggingUtils.logPageView("", Channel.MERCHANT_PAGE.toString(), new MerchantPageMerchantIdMetadata(businessId));
        businessDetailSyncManager.requestSync(this, null);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_business_specials_clicked", isBusinessSpecialsClicked);
        bundle.putInt("data_state", dataState);
        super.onSaveInstanceState(bundle);
    }




/*
    static int access$002(BusinessDetailPage businessdetailpage, int i)
    {
        businessdetailpage.dataState = i;
        return i;
    }

*/




/*
    static Business access$102(BusinessDetailPage businessdetailpage, Business business)
    {
        businessdetailpage.businessObj = business;
        return business;
    }

*/



/*
    static boolean access$1202(BusinessDetailPage businessdetailpage, boolean flag)
    {
        businessdetailpage.isBusinessSpecialsClicked = flag;
        return flag;
    }

*/



/*
    static boolean access$202(BusinessDetailPage businessdetailpage, boolean flag)
    {
        businessdetailpage.isFirstScroll = flag;
        return flag;
    }

*/







}
