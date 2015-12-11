// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.groupon.Channel;
import com.groupon.cookies.CookieFactory;
import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.http.NameValuePair;
import com.groupon.models.DateTimeFinderReservationDetails;
import com.groupon.models.SchedulerReservationDetails;
import com.groupon.models.mobilescheduler.Deal;
import com.groupon.models.mobilescheduler.DealOption;
import com.groupon.models.mobilescheduler.LocalBookingInfo;
import com.groupon.models.mobilescheduler.Location;
import com.groupon.models.mobilescheduler.Merchant;
import com.groupon.models.mobilescheduler.MobileSchedulerData;
import com.groupon.models.mobilescheduler.Reservation;
import com.groupon.service.LoginService;
import com.groupon.service.core.AbTestService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BuyUtils;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.HttpUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.WebViewHelper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory, MobileJSBridge

public class MobileScheduler extends GrouponActivity
    implements GrouponDialogListener
{
    private class MobileSchedulerWebChromeClient extends WebChromeClient
    {

        final MobileScheduler this$0;

        public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
        {
            (new com.groupon.util.GrouponAlertDialog.Builder(MobileScheduler.this)).setTitle("Alert").setMessage(s1).setPositiveButton(0x104000a, jsresult. new android.content.DialogInterface.OnClickListener() {

                final MobileSchedulerWebChromeClient this$1;
                final JsResult val$result;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    result.confirm();
                }

            
            {
                this$1 = final_mobileschedulerwebchromeclient;
                result = JsResult.this;
                super();
            }
            }).create().show();
            return true;
        }

        public void onReceivedTitle(WebView webview, String s)
        {
            if (isGdt)
            {
                updateActionBarTitle(s);
            }
            super.onReceivedTitle(webview, s);
        }

        private MobileSchedulerWebChromeClient()
        {
            this$0 = MobileScheduler.this;
            super();
        }

    }

    private class MobileSchedulerWebViewClient extends WebViewClient
    {

        final MobileScheduler this$0;

        private void showErrorDialog()
        {
            Object obj = dialogManager;
            Object obj1 = MobileScheduler.this;
            int i;
            if (isGdt)
            {
                i = 0x7f0801e1;
            } else
            {
                i = 0x7f080342;
            }
            obj1 = ((MobileScheduler) (obj1)).getString(i);
            if (isGdt)
            {
                i = 0x7f08045b;
            } else
            {
                i = 0x7f080139;
            }
            obj = ((DialogManager) (obj)).getDialogFragment(null, obj1, Integer.valueOf(i), false);
            GrouponDialogFragment.show(getFragmentManager(), ((GrouponDialogFragment) (obj)), "scheduler_error_dialog");
        }

        public void onPageFinished(WebView webview, String s)
        {
            loading.setVisibility(8);
            if (isGdt && s.contains("#/order"))
            {
                gdtThanksPageReached = true;
            }
            if (!s.endsWith("#reserved")) goto _L2; else goto _L1
_L1:
            MobileScheduler mobilescheduler = MobileScheduler.this;
            String s1;
            if (isBookableDeal())
            {
                s1 = "booked";
            } else
            {
                s1 = "pending";
            }
            mobilescheduler.updateBookingStatus(s1);
            updateActionBarTitle();
            if (isPrePurchaseBooking || dateTimeFinderReservationDetails != null)
            {
                scheduleWebView.loadUrl(MobileScheduler.PREPURCHASE_BOOKING_SCRIPT);
                loggingUtils.logPrePurchaseBookingClick("w_schedule_action", "w_schedule_step", mobileSchedulerData.deal.id, Channel.safeValueOf(mobileSchedulerData.channel), MobileScheduler.PREPURCHASE_BOOKING_PAGE_ID);
            }
_L4:
            super.onPageFinished(webview, s);
            return;
_L2:
            if (s.endsWith("#skip") && (isPrePurchaseBooking || dateTimeFinderReservationDetails != null))
            {
                Intent intent = getPurchaseIntent();
                if (intent != null)
                {
                    if (intent.getExtras().containsKey("reservation_bundle"))
                    {
                        intent.removeExtra("reservation_bundle");
                    }
                    if (Strings.notEmpty(selectedOptionId))
                    {
                        intent.putExtra("optionId", selectedOptionId);
                    }
                }
                startActivity(getNextIntent());
                loggingUtils.logPrePurchaseBookingClick("w_skip_action", "w_skip_step", mobileSchedulerData.deal.id, Channel.safeValueOf(mobileSchedulerData.channel), MobileScheduler.PREPURCHASE_BOOKING_PAGE_ID);
            } else
            if (s.endsWith("#cancelled"))
            {
                updateBookingStatus("unbooked");
                updateActionBarTitle(getString(0x7f080328));
            } else
            if (s.endsWith("#"))
            {
                updateActionBarTitle();
            } else
            if (s.endsWith("#error"))
            {
                showErrorDialog();
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            if (!isGdt)
            {
                loading.setVisibility(8);
            }
            super.onPageStarted(webview, s, bitmap);
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            loading.setVisibility(8);
            super.onReceivedError(webview, i, s, s1);
            webview.loadUrl("about:blank");
            showErrorDialog();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }

        private MobileSchedulerWebViewClient()
        {
            this$0 = MobileScheduler.this;
            super();
        }

    }

    private class PrePurchaseJavascriptInterface
    {

        final MobileScheduler this$0;

        public void getData(String s)
        {
            Intent intent;
            s = (SchedulerReservationDetails)objectMapper.readValue(s, com/groupon/models/SchedulerReservationDetails);
            reservationId = ((SchedulerReservationDetails) (s)).id;
            intent = getPurchaseIntent();
            if (intent != null)
            {
                try
                {
                    setPrePurchaseExtra(intent, s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Ln.e(s, "Impossible to read reservation details.", new Object[0]);
                }
            }
            startActivity(getNextIntent());
            return;
        }

        private PrePurchaseJavascriptInterface()
        {
            this$0 = MobileScheduler.this;
            super();
        }

    }


    private static final String ACTION = "action";
    private static final String APPOINTMENT_URL_NO_STATUS = "#";
    private static final String APPOINTMENT_URL_STATUS_CANCELLED = "#cancelled";
    private static final String APPOINTMENT_URL_STATUS_ERROR = "#error";
    private static final String APPOINTMENT_URL_STATUS_RESERVED = "#reserved";
    private static final String APPOINTMENT_URL_STATUS_SKIP = "#skip";
    private static final String BOOKING_ENGINE_TIME_FORMAT = "HH:mm:ss";
    private static final String DATE = "date";
    private static final String GDT_BOOK_NOW_URL = "/biz/locations/delivery-takeout";
    private static final String GDT_COOKIES = "s=%1$s;b=%2$s;division=%3$s";
    private static final String GDT_THANKS_PAGE_HASH = "#/order";
    private static final String GDT_VIEW_ORDER_URL = "/users/%1$s/delivery-takeout/order/%2$s";
    private static final String PARTIAL_INTENT = "partial_intent";
    private static final String PARTY_SIZE = "party_size";
    private static final String PREPURCHASE_BACK_ACTION = "action_back";
    private static final String PREPURCHASE_BACK_CLICK_TYPE = "back_reservation";
    private static final String PREPURCHASE_BOOKING_PAGE_ID = com/groupon/activity/MobileScheduler.getSimpleName();
    private static final String PREPURCHASE_BOOKING_SCRIPT = (new StringBuilder()).append("javascript:window.").append(com/groupon/activity/MobileScheduler$PrePurchaseJavascriptInterface.getSimpleName()).append(".").append("getData(JSON.stringify(window.reservationDetails))").toString();
    private static final String PREPURCHASE_SCHEDULE_ACTION = "w_schedule_action";
    private static final String PREPURCHASE_SCHEDULE_CLICK_TYPE = "w_schedule_step";
    private static final String PREPURCHASE_SKIP_ACTION = "w_skip_action";
    private static final String PREPURCHASE_SKIP_CLICK_TYPE = "w_skip_step";
    public static final int REQUEST_CODE = 10140;
    private static final String SCHEDULER_ERROR_DIALOG = "scheduler_error_dialog";
    private static final String SEGMENT_ID = "segment_id";
    private static final String TIME = "time";
    private AbTestService abTestService;
    private String bookingStatus;
    private BuyUtils buyUtil;
    Channel channel;
    protected CookieFactory cookieFactory;
    private DateTimeFinderReservationDetails dateTimeFinderReservationDetails;
    Bundle dateTimeFinderReservationDetailsBundle;
    private DialogManager dialogManager;
    boolean fromThankYou;
    protected boolean gdtThanksPageReached;
    private DaoMyGrouponItem grouponItemDao;
    private IntentFactory intentFactory;
    private InternetUsDateFormat internetUsDateFormat;
    private boolean isBookingUpdates1408USCA;
    private boolean isBookingUpdatesPreBook1506USCA;
    boolean isGdt;
    boolean isPrePurchaseBooking;
    ProgressBar loading;
    private LoggingUtils loggingUtils;
    private LoginService loginService;
    private MobileSchedulerData mobileSchedulerData;
    Intent next;
    private ObjectMapper objectMapper;
    private SharedPreferences prefs;
    SchedulerReservationDetails reservation;
    String reservationId;
    String scheduleJsonObjectAsString;
    private WebView scheduleWebView;
    FrameLayout scheduleWebViewPlaceholder;
    String selectedOptionId;

    public MobileScheduler()
    {
    }

    private String extractFormattedDate(Date date)
    {
        return internetUsDateFormat.getFormatter("yyyy-MM-dd").format(date);
    }

    private String extractFormattedTime(Date date)
    {
        return internetUsDateFormat.getFormatter("HH:mm:ss").format(date);
    }

    private String getCurrentBaseUrl()
    {
        SharedPreferences sharedpreferences = prefs;
        String s;
        int i;
        if (isGdt)
        {
            s = "web_base_url_gdt";
        } else
        {
            s = "base_url_booking_engine";
        }
        if (isGdt)
        {
            i = 0x7f080533;
        } else
        {
            i = 0x7f0804be;
        }
        return sharedpreferences.getString(s, getString(i));
    }

    private String getJsonLocalBookingInfoStatus()
    {
        return mobileSchedulerData.localBookingInfo.reservation.status;
    }

    private Intent getNextIntent()
    {
        Intent intent = (Intent)next.getParcelableExtra("next");
        if (!loginService.isLoggedIn() || intent == null)
        {
            intent = next;
        }
        if (channel != null)
        {
            intent.putExtra("channel", channel);
        }
        return intent;
    }

    private Intent getPurchaseIntent()
    {
        if (next != null)
        {
            next.setExtrasClassLoader(getClassLoader());
        }
        Intent intent = (Intent)next.getParcelableExtra("next");
        if (intent != null)
        {
            return intent;
        } else
        {
            return next;
        }
    }

    private void goToFeaturedTab()
    {
        navigateUpTo(intentFactory.newCarouselChannelIntent(Channel.FEATURED, new String[0]));
    }

    private void goToMyGroupons()
    {
        navigateUpTo(intentFactory.newMyGrouponsIntent());
    }

    private boolean hasLocalBookingInfoStatusChanged()
    {
        return !Strings.equals(getJsonLocalBookingInfoStatus(), bookingStatus);
    }

    private void logOnBackPressedClick()
    {
        if (!isGdt)
        {
            if (isBookingUpdatesPreBook1506USCA && isPrePurchaseBooking)
            {
                loggingUtils.logPrePurchaseBookingClick("action_back", "back_reservation", mobileSchedulerData.deal.id, Channel.safeValueOf(mobileSchedulerData.channel), PREPURCHASE_BOOKING_PAGE_ID);
            } else
            if (isBookingUpdates1408USCA && !isBookableDeal())
            {
                Object obj = new HashMap(3);
                ((HashMap) (obj)).put("dealId", mobileSchedulerData.deal.id);
                ((HashMap) (obj)).put("channel", mobileSchedulerData.channel);
                ((HashMap) (obj)).put("action", "back");
                obj = buyUtil.nstClickMetadata(logger, ((HashMap) (obj)));
                logger.logClick("", "back_appointment", "post_purchase_booking_page", ((String) (obj)));
                return;
            }
        }
    }

    private void setPrePurchaseExtra(Intent intent, SchedulerReservationDetails schedulerreservationdetails)
    {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("reservation_extra", schedulerreservationdetails);
        intent.putExtra("reservation_bundle", bundle);
        if (Strings.notEmpty(selectedOptionId))
        {
            intent.putExtra("optionId", selectedOptionId);
        }
    }

    private void setupWebView()
    {
        if (scheduleWebView == null)
        {
            scheduleWebView = new WebView(this);
            scheduleWebView.getSettings().setJavaScriptEnabled(true);
            WebViewHelper.addInAppUserAgent(scheduleWebView);
            if (isGdt)
            {
                scheduleWebView.getSettings().setDomStorageEnabled(true);
            }
            scheduleWebView.addJavascriptInterface(new MobileJSBridge(this), "MobileScheduler");
            scheduleWebView.setWebViewClient(new MobileSchedulerWebViewClient());
            scheduleWebView.setWebChromeClient(new MobileSchedulerWebChromeClient());
            scheduleWebView.addJavascriptInterface(new PrePurchaseJavascriptInterface(), com/groupon/activity/MobileScheduler$PrePurchaseJavascriptInterface.getSimpleName());
            String s = getCurrentBaseUrl();
            Object obj = new ArrayList();
            HashMap hashmap = new HashMap(2);
            String s1;
            if (isGdt)
            {
                Object obj1 = mobileSchedulerData.gdtOrderId;
                double d;
                double d1;
                if (Strings.notEmpty(obj1))
                {
                    s = (new StringBuilder()).append(s).append(String.format("/users/%1$s/delivery-takeout/order/%2$s", new Object[] {
                        loginService.getUserId(), obj1
                    })).toString();
                } else
                {
                    s = (new StringBuilder()).append(s).append("/biz/locations/delivery-takeout").toString();
                    ((List) (obj)).add(new NameValuePair("mid", mobileSchedulerData.merchant.id));
                    ((List) (obj)).add(new NameValuePair("user_id", loginService.getUserId()));
                }
                obj1 = mobileSchedulerData.location;
                d = ((Location) (obj1)).lat;
                d1 = ((Location) (obj1)).lng;
                if (Strings.notEmpty(Double.valueOf(d)) && Strings.notEmpty(Double.valueOf(d1)))
                {
                    ((List) (obj)).add(new NameValuePair("lat", String.valueOf(d)));
                    ((List) (obj)).add(new NameValuePair("lng", String.valueOf(d1)));
                }
                hashmap.put("x-auth-token", loginService.getAccessToken());
                hashmap.put("x-cookies", String.format("s=%1$s;b=%2$s;division=%3$s", new Object[] {
                    cookieFactory.getSessionCookie(), cookieFactory.getBrowserCookie(), ((Location) (obj1)).division
                }));
            } else
            {
                ((List) (obj)).add(new NameValuePair("show_close", "true"));
                ((List) (obj)).add(new NameValuePair("api_auth_token", loginService.getAccessToken()));
                ((List) (obj)).add(new NameValuePair("option_id", mobileSchedulerData.dealOption.id));
                if (loginService.isLoggedIn())
                {
                    ((List) (obj)).add(new NameValuePair("client_first_name", loginService.getFirstName()));
                    ((List) (obj)).add(new NameValuePair("client_last_name", loginService.getLastName()));
                    ((List) (obj)).add(new NameValuePair("user_id", loginService.getUserId()));
                }
                if (Strings.notEmpty(reservationId))
                {
                    ((List) (obj)).add(new NameValuePair("booking_reservation_id", reservationId));
                }
                ((List) (obj)).add(new NameValuePair("merchant_id", mobileSchedulerData.merchant.id));
                ((List) (obj)).add(new NameValuePair("client_email", loginService.getEmail()));
                ((List) (obj)).add(new NameValuePair("deal_id", mobileSchedulerData.deal.id));
            }
            obj1 = mobileSchedulerData.grouponCode;
            s1 = mobileSchedulerData.orderId;
            if (Strings.notEmpty(obj1))
            {
                ((List) (obj)).add(new NameValuePair("groupon_code", ((String) (obj1))));
            } else
            if (Strings.notEmpty(s1))
            {
                ((List) (obj)).add(new NameValuePair("order_id", s1));
            }
            if (dateTimeFinderReservationDetails != null && (Strings.isEmpty(selectedOptionId) || Strings.equalsIgnoreCase(dateTimeFinderReservationDetails.optionId, selectedOptionId)))
            {
                if (dateTimeFinderReservationDetails.partySize > 0)
                {
                    ((List) (obj)).add(new NameValuePair("party_size", String.valueOf(dateTimeFinderReservationDetails.partySize)));
                }
                if (dateTimeFinderReservationDetails.reservationDate != null)
                {
                    ((List) (obj)).add(new NameValuePair("date", extractFormattedDate(dateTimeFinderReservationDetails.reservationDate)));
                    ((List) (obj)).add(new NameValuePair("time", extractFormattedTime(dateTimeFinderReservationDetails.reservationDate)));
                }
                if (Strings.notEmpty(dateTimeFinderReservationDetails.segmentId))
                {
                    ((List) (obj)).add(new NameValuePair("segment_id", dateTimeFinderReservationDetails.segmentId));
                }
                ((List) (obj)).add(new NameValuePair("partial_intent", String.valueOf(dateTimeFinderReservationDetails.partialIntent)));
            }
            ((List) (obj)).add(new NameValuePair("hide_header", "true"));
            obj = HttpUtil.urlEncode(((List) (obj)));
            if (hashmap.size() > 0)
            {
                scheduleWebView.loadUrl((new StringBuilder()).append(s).append("?").append(((String) (obj))).toString(), hashmap);
            } else
            {
                scheduleWebView.loadUrl((new StringBuilder()).append(s).append("?").append(((String) (obj))).toString());
            }
        }
        scheduleWebViewPlaceholder.addView(scheduleWebView);
    }

    private void updateBookingStatus(final String bookingStatus)
    {
        Exception exception1;
        try
        {
            grouponItemDao.callBatchTasks(new Callable() {

                final MobileScheduler this$0;
                final String val$bookingStatus;

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

                public Void call()
                    throws Exception
                {
                    grouponItemDao.updateBookingStatusById(mobileSchedulerData.grouponCode, bookingStatus);
                    return null;
                }

            
            {
                this$0 = MobileScheduler.this;
                bookingStatus = s;
                super();
            }
            });
        }
        catch (Exception exception)
        {
            this.bookingStatus = bookingStatus;
            return;
        }
        finally
        {
            this.bookingStatus = bookingStatus;
        }
        this.bookingStatus = bookingStatus;
        return;
        throw exception1;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        updateActionBarTitle();
    }

    protected boolean isBookableDeal()
    {
        return mobileSchedulerData.bookable;
    }

    public void onBackPressed()
    {
        logOnBackPressedClick();
        if (hasLocalBookingInfoStatusChanged())
        {
            setResult(-1);
        }
        if (isGdt)
        {
            if (gdtThanksPageReached)
            {
                if (fromThankYou)
                {
                    goToFeaturedTab();
                    return;
                } else
                {
                    goToMyGroupons();
                    return;
                }
            }
            if (scheduleWebView.canGoBack())
            {
                scheduleWebView.goBack();
                return;
            } else
            {
                super.onBackPressed();
                return;
            }
        }
        if (fromThankYou)
        {
            goToFeaturedTab();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (scheduleWebView != null)
        {
            scheduleWebViewPlaceholder.removeView(scheduleWebView);
        }
        super.onConfigurationChanged(configuration);
        setupWebView();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030167);
        isBookingUpdates1408USCA = abTestService.isVariantEnabled("bookingUpdates1408USCA", "on");
        isBookingUpdatesPreBook1506USCA = abTestService.isVariantEnabled("bookingUpdatesPreBook1506USCA", "on");
        if (dateTimeFinderReservationDetailsBundle != null)
        {
            dateTimeFinderReservationDetails = (DateTimeFinderReservationDetails)dateTimeFinderReservationDetailsBundle.getParcelable("reservation_details");
        }
        try
        {
            mobileSchedulerData = (MobileSchedulerData)objectMapper.readValue(scheduleJsonObjectAsString, com/groupon/models/mobilescheduler/MobileSchedulerData);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Ln.e(bundle, "Impossible to read mobile scheduler from extras.", new Object[0]);
            return;
        }
        bookingStatus = getJsonLocalBookingInfoStatus();
        setupWebView();
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
label0:
        {
            if (Strings.equals(s, "scheduler_error_dialog"))
            {
                if (!fromThankYou)
                {
                    break label0;
                }
                goToFeaturedTab();
            }
            return;
        }
        finish();
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        logOnBackPressedClick();
        if (menuitem.getItemId() == 0x102002c && !isPrePurchaseBooking && dateTimeFinderReservationDetails == null)
        {
            goToFeaturedTab();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onRestart()
    {
        if (scheduleWebView != null)
        {
            scheduleWebViewPlaceholder.removeView(scheduleWebView);
            scheduleWebView = null;
        }
        super.onRestart();
        setupWebView();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        gdtThanksPageReached = bundle.getBoolean("gdt_thanks_page_reached");
        scheduleWebView.restoreState(bundle);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("gdt_thanks_page_reached", gdtThanksPageReached);
        scheduleWebView.saveState(bundle);
    }

    protected void updateActionBarTitle()
    {
        String s;
        if (isGdt)
        {
            s = "";
        } else
        if ((isBookingUpdates1408USCA || isBookingUpdatesPreBook1506USCA) && !isBookableDeal())
        {
            int i;
            if (Strings.equals(bookingStatus, "unbooked"))
            {
                i = 0x7f080327;
            } else
            {
                i = 0x7f080428;
            }
            s = getString(i);
        } else
        {
            int j;
            if (Strings.equals(bookingStatus, "unbooked"))
            {
                j = 0x7f080075;
            } else
            {
                j = 0x7f08052d;
            }
            s = getString(j);
        }
        updateActionBarTitle(s);
    }

    protected void updateActionBarTitle(String s)
    {
        setToolbarTitle(s);
    }














}
