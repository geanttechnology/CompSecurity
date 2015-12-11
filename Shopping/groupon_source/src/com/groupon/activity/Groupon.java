// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.LoaderManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.abtest.EditOrderAbTestHelper;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.Shipment;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.GrouponSyncManagerProcess;
import com.groupon.models.MarkUsedData;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.models.gdt.GdtFeatures;
import com.groupon.models.gdt.GdtMerchantData;
import com.groupon.models.gdt.GdtMerchantDataContainer;
import com.groupon.models.gdt.GdtOrderData;
import com.groupon.models.gdt.GdtOrderDataContainer;
import com.groupon.models.gdt.GdtOrderDataState;
import com.groupon.models.mobilescheduler.Deal;
import com.groupon.models.mobilescheduler.DealOption;
import com.groupon.models.mobilescheduler.LocalBookingInfo;
import com.groupon.models.mobilescheduler.Merchant;
import com.groupon.models.mobilescheduler.MobileSchedulerData;
import com.groupon.models.mobilescheduler.Reservation;
import com.groupon.models.nst.ClickMetadata;
import com.groupon.models.nst.RedemptionExtraInfo;
import com.groupon.models.support.SupportInfo;
import com.groupon.network.HttpResponseException;
import com.groupon.service.LocationService;
import com.groupon.service.LoginService;
import com.groupon.service.MarkUsedManager;
import com.groupon.service.core.AbTestService;
import com.groupon.service.core.SupportInfoService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.service.gdt.GdtService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BuyUtils;
import com.groupon.util.CountryUtil;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.DivisionTimeZone;
import com.groupon.util.ExpirationFormat;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.Function2;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.LoaderCallbacksUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.MyGrouponUtils;
import com.groupon.util.ReturningFunction1;
import com.groupon.util.ShareHelper;
import com.groupon.v3.loader.IUniversalCallback;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.GrouponItemLoader;
import com.groupon.view.MapSlice;
import com.groupon.view.SpinnerButton;
import com.groupon.view.Transformation.AspectScaleTransformation;
import com.groupon.view.UrlImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory, ConfirmVoucherHelper

public class Groupon extends GrouponActivity
    implements GrouponDialogListener, IUniversalCallback, commonlib.manager.SyncManager.SyncUiCallbacks
{

    private static final String DB_CHANNEL = "GrouponItem";
    private static final String GROUPON_MARK_USED_HTTP_ERROR_DIALOG = "groupon_mark_used_http_error_dialog";
    private static final String GROUPON_MARK_USED_NETWORK_ERROR_DIALOG = "groupon_mark_used_network_error_dialog";
    private static final String GROUPON_PENDING = "pending";
    private static final String GROUPON_REFUND_PENDING = "refund_pending";
    private static final int INVALID_BOOKING_BUTTON_RESOURCE = -1;
    public static final int REQUEST_CODE = 10108;
    public static final int REQUEST_CODE_EDIT_ORDER = 0;
    private static final String USE_GROUPON_DIALOG = "use_groupon_dialog";
    private static final String VOUCHER_CODE = "voucherCode";
    private AbTestService abTestService;
    String available;
    Button bookNowButton;
    LinearLayout bottomBarButtonsContainer;
    View bottomBarView;
    private BuyUtils buyUtil;
    Button cancelOrderButton;
    private ConfirmVoucherHelper confirmVoucherHelper;
    private ConnectivityManager connectivityManager;
    View contentView;
    private Context context;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    UrlImageView dealImageView;
    private DeviceInfoUtil deviceInfoUtil;
    private DialogManager dialogManager;
    private EditOrderAbTestHelper editOrderAbTestHelper;
    private ExpirationFormat expirationFormat;
    TextView expirationView;
    private DateFormat finePrintDateFormat;
    WebView finePrintView;
    Button gdtOrderButton;
    private String gdtOrderId;
    private GdtService gdtService;
    TextView giftClaimedView;
    View giftContainer;
    TextView giftEmailView;
    TextView giftSubjectView;
    private MyGrouponItem groupon;
    LinearLayout grouponContent;
    String grouponId;
    View imageContainer;
    private LayoutInflater inflater;
    View instructionsSection;
    TextView instructionsView;
    private IntentFactory intentFactory;
    private boolean isBookableTravelDeal;
    private boolean isBookingUpdates1408USCA;
    private boolean isGDT1503USCA;
    private boolean isGdtRedeemed;
    private LayoutInflater layoutInflater;
    private DateFormat localTimeDateFormat;
    private LocationService locationService;
    private Logger logger;
    private LoggingUtils loggingUtils;
    private LoginService loginService;
    MapSlice mapSlice;
    private MarkUsedManager markUsedManager;
    TextView messageView;
    int myGrouponsTabPosition;
    String no;
    TextView noVoucher;
    LinearLayout pageButtonsContainer;
    LinearLayout paymentDetailsContainer;
    String primeNoNetworkMessage;
    String primeNoNetworkTitle;
    View progressView;
    String refundPending;
    ViewGroup shipmentInfoContainer;
    String shipmentInfoStatusNotShipped;
    String shipmentInfoStatusShipped;
    String shipmentInfoStatusShippedFormat;
    private boolean shouldShowGdt;
    TextView status;
    View subtitleDivider;
    TextView subtitleView;
    private SupportInfoService supportInfoService;
    TextView titleView;
    LinearLayout tripDetailsContainer;
    private UniversalLoaderCallbacks universalLoaderCallbacks;
    TextView universalRulesView;
    protected UniversalSyncManager universalSyncManager;
    SpinnerButton useGrouponView;
    View usedOnDivider;
    TextView usedOnView;
    TextView vendorNameView;
    TextView vendorUrlView;
    String voucherInSeparateEmail;
    String yes;

    public Groupon()
    {
        myGrouponsTabPosition = -1;
        shouldShowGdt = false;
        isGdtRedeemed = false;
    }

    private void configureLoaderCallBacks()
    {
        universalLoaderCallbacks = new UniversalLoaderCallbacks(null, this, "GrouponItem", this);
        GrouponItemLoader grouponitemloader = new GrouponItemLoader(this, grouponId);
        universalLoaderCallbacks.setBackgroundDataProcessors(new BackgroundDataProcessor[] {
            grouponitemloader
        });
        getLoaderManager().initLoader(0, null, universalLoaderCallbacks);
    }

    private void configureSyncManager()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new GrouponSyncManagerProcess(this, grouponId, "GrouponItem"));
        universalSyncManager.configurePaginatedSyncManager(null, arraylist, new UniversalUpdateEvent("GrouponItem"));
    }

    private void configureToolbarTitle()
    {
        if (groupon != null)
        {
            String s = groupon.name;
            if (!Strings.notEmpty(s))
            {
                s = groupon.dealTitle;
            }
            setToolbarTitle(s);
        }
    }

    private int getViewVoucherButtonText()
    {
        if (isOrderEditable())
        {
            return 0x7f080141;
        }
        return !currentCountryManager.getCurrentCountry().isSellerOfRecordCountry() || !groupon.isInventoryDeal ? 0x7f08040e : 0x7f080406;
    }

    private boolean isOrderEditable()
    {
        return editOrderAbTestHelper.isEditOrderEnabled() && Strings.equals(groupon.status, "failed");
    }

    private void showEditOrder()
    {
        RedemptionExtraInfo redemptionextrainfo = new RedemptionExtraInfo(groupon.grouponNumber, groupon.redemptionCode, groupon.uuid);
        loggingUtils.logEditOrderClick(groupon.dealId, redemptionextrainfo);
        startActivityForResult(intentFactory.newEditOrderIntent(groupon.dealId, groupon.orderId), 0);
    }

    private void triggerUseGrouponClick()
    {
        if (connectivityManager.getActiveNetworkInfo() == null)
        {
            GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(primeNoNetworkTitle, primeNoNetworkMessage), "generic_error_dialog");
            return;
        }
        if (isOrderEditable())
        {
            showEditOrder();
            return;
        }
        if (shouldShowSelectLocation())
        {
            showSelectLocation();
            return;
        } else
        {
            showRedeemLauncher();
            return;
        }
    }

    protected void addSeparator(ViewGroup viewgroup)
    {
        inflater.inflate(0x7f03016f, viewgroup);
    }

    protected void checkGdtLocations()
    {
        gdtService.getMerchantGdtLocations(groupon.merchantUuid, new Function1() {

            final Groupon this$0;

            public void execute(GdtMerchantDataContainer gdtmerchantdatacontainer)
            {
                boolean flag2 = false;
                boolean flag3 = false;
                boolean flag1 = flag2;
                boolean flag = flag3;
                if (gdtmerchantdatacontainer != null)
                {
                    flag1 = flag2;
                    flag = flag3;
                    if (gdtmerchantdatacontainer.data != null)
                    {
                        flag1 = flag2;
                        flag = flag3;
                        if (gdtmerchantdatacontainer.data.gdtFeatures != null)
                        {
                            flag1 = gdtmerchantdatacontainer.data.gdtFeatures.offersDelivery;
                            flag = gdtmerchantdatacontainer.data.gdtFeatures.offersTakeout;
                        }
                    }
                }
                if (flag1 || flag)
                {
                    if (Strings.equals(groupon.availability, "redeemed"))
                    {
                        gdtOrderId = "";
                        checkGdtRedemption();
                        return;
                    } else
                    {
                        shouldShowGdt = true;
                        refresh();
                        return;
                    }
                } else
                {
                    refresh();
                    return;
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((GdtMerchantDataContainer)obj);
            }

            
            {
                this$0 = Groupon.this;
                super();
            }
        }, new ReturningFunction1() {

            final Groupon this$0;

            public Boolean execute(Exception exception)
            {
                shouldShowGdt = false;
                refresh();
                return Boolean.valueOf(true);
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = Groupon.this;
                super();
            }
        }, null);
    }

    protected void checkGdtRedemption()
    {
        gdtService.getGdtOrder(groupon.remoteId, new Function1() {

            final Groupon this$0;

            public void execute(GdtOrderDataContainer gdtorderdatacontainer)
            {
                if (gdtorderdatacontainer != null && gdtorderdatacontainer.data != null && gdtorderdatacontainer.data.state != null && gdtorderdatacontainer.data.state.voucherRedeemed)
                {
                    shouldShowGdt = true;
                    isGdtRedeemed = true;
                    gdtOrderId = gdtorderdatacontainer.data.state.orderId;
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((GdtOrderDataContainer)obj);
            }

            
            {
                this$0 = Groupon.this;
                super();
            }
        }, new ReturningFunction1() {

            final Groupon this$0;

            public Boolean execute(Exception exception)
            {
                shouldShowGdt = false;
                return Boolean.valueOf(true);
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = Groupon.this;
                super();
            }
        }, new Function0() {

            final Groupon this$0;

            public void execute()
            {
                refresh();
            }

            
            {
                this$0 = Groupon.this;
                super();
            }
        });
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
    }

    protected View getBasicListItem(ViewGroup viewgroup, int i, String s, String s1)
    {
        if (i > 0)
        {
            View view = inflater.inflate(i, viewgroup, false);
            TextView textview = (TextView)view.findViewById(0x7f1002d3);
            if (textview != null && s != null)
            {
                textview.setText(s);
            }
            s = (TextView)view.findViewById(0x7f100249);
            if (s != null && s1 != null)
            {
                s.setText(s1);
            }
            viewgroup.addView(view);
            return view;
        } else
        {
            return null;
        }
    }

    protected int getBookButtonDisplayResource()
    {
        String s;
        String s1;
        boolean flag;
        flag = groupon.bookable;
        s = groupon.bookingType;
        s1 = groupon.localBookingInfoStatus;
        if (!isBookingUpdates1408USCA || flag) goto _L2; else goto _L1
_L1:
        if (!Strings.equals(s, "booking_engine"))
        {
            break MISSING_BLOCK_LABEL_138;
        }
        if (!Strings.equals(s1, "unbooked")) goto _L4; else goto _L3
_L3:
        return 0x7f080075;
_L4:
        if (Strings.equals(s1, "pending"))
        {
            return 0x7f08040b;
        }
        return !Strings.equals(s1, "booked") ? -1 : 0x7f080403;
_L2:
        if (!currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            break MISSING_BLOCK_LABEL_138;
        }
        if (!Strings.equals(s, "booking_engine"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!Strings.notEmpty(s1) || !Strings.equals(s1, "booked")) goto _L3; else goto _L5
_L5:
        return 0x7f08040c;
        if (flag) goto _L3; else goto _L6
_L6:
        return -1;
        return -1;
    }

    protected void getSupportInfo(boolean flag)
    {
        Object obj = supportInfoService.getSupportInfo();
        if (Strings.isEmpty(((SupportInfo) (obj)).contents.finePrint) || currentCountryManager.getCurrentCountry().isSweden())
        {
            universalRulesView.setVisibility(8);
        }
        int i;
        if (!currentCountryManager.getCurrentCountry().isJapan())
        {
            obj = ((SupportInfo) (obj)).contents;
            String s;
            String s1;
            String s2;
            SpannableStringBuilder spannablestringbuilder;
            if (flag)
            {
                obj = ((com.groupon.models.support.SupportInfo.Contents) (obj)).getawayBookingsCustomerSupport;
            } else
            {
                obj = ((com.groupon.models.support.SupportInfo.Contents) (obj)).customerSupport;
            }
            s1 = ((com.groupon.models.support.SupportInfo.CustomerSupport) (obj)).operatingHours;
            s2 = ((com.groupon.models.support.SupportInfo.CustomerSupport) (obj)).afterHoursPhoneNumber;
            if (flag)
            {
                s = ((com.groupon.models.support.SupportInfo.CustomerSupport) (obj)).afterHoursPhoneNumber;
            } else
            {
                s = "";
            }
            spannablestringbuilder = new SpannableStringBuilder();
            if (Strings.notEmpty(s2))
            {
                String s3;
                if (currentCountryManager.getCurrentCountry().isRussia())
                {
                    obj = String.format(getString(0x7f0802ca), new Object[] {
                        s1
                    });
                } else
                {
                    obj = s1;
                }
                s3 = getString(0x7f080082);
                if (!Strings.notEmpty(s1))
                {
                    obj = "";
                }
                spannablestringbuilder.append(String.format("%s %s%n%s%n", new Object[] {
                    s3, s2, obj
                }));
            }
            if (Strings.notEmpty(s))
            {
                spannablestringbuilder.append(String.format("%s %s", new Object[] {
                    getString(0x7f080231), s
                }));
            }
            Linkify.addLinks(spannablestringbuilder, 7);
            instructionsView.setText(TextUtils.concat(new CharSequence[] {
                instructionsView.getText(), spannablestringbuilder
            }));
        }
        flag = Strings.notEmpty(instructionsView.getText());
        obj = instructionsSection;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }

    protected void handleBookingUpdateClick()
    {
        MobileSchedulerData mobileschedulerdata = new MobileSchedulerData();
        mobileschedulerdata.dealOption.id = groupon.dealOptionId;
        mobileschedulerdata.merchant.id = groupon.merchantId;
        mobileschedulerdata.deal.id = groupon.dealId;
        mobileschedulerdata.localBookingInfo.reservation.status = groupon.localBookingInfoStatus;
        mobileschedulerdata.grouponCode = groupon.remoteId;
        mobileschedulerdata.bookable = groupon.bookable;
        startActivityForResult(intentFactory.newMobileSchedulerIntent(mobileschedulerdata, null, false, false, false, null), 10140);
    }

    protected void handleGdtOrderClick()
    {
        MobileSchedulerData mobileschedulerdata = new MobileSchedulerData();
        Object obj;
        HashMap hashmap;
        Logger logger1;
        if (isGdtRedeemed)
        {
            mobileschedulerdata.gdtOrderId = gdtOrderId;
        } else
        {
            mobileschedulerdata.grouponCode = groupon.remoteId;
            mobileschedulerdata.merchant.id = groupon.merchantUuid;
        }
        obj = locationService.getLocation();
        if (obj != null)
        {
            mobileschedulerdata.location.lat = ((Location) (obj)).getLatitude();
            mobileschedulerdata.location.lng = ((Location) (obj)).getLongitude();
        }
        mobileschedulerdata.location.division = currentDivisionManager.getCurrentDivision().name;
        hashmap = new HashMap(1);
        hashmap.put("voucherCode", grouponId);
        logger1 = logger;
        if (isGdtRedeemed)
        {
            obj = "view_order_gdt";
        } else
        {
            obj = "order_food_gdt";
        }
        logger1.logClick("", ((String) (obj)), groupon.dealId, buyUtil.nstClickMetadata(logger, hashmap));
        startActivity(intentFactory.newMobileSchedulerIntent(mobileschedulerdata, null, true, false, false, null));
    }

    protected void handlePaymentDetailsSection()
    {
        int i = 0;
        String s = groupon.hotelFormattedAmount;
        String s1 = groupon.subTotalFormattedAmount;
        Object obj = groupon.totalFormattedAmount;
        if (Strings.notEmpty(s1))
        {
            getBasicListItem(paymentDetailsContainer, 0x7f03016d, getString(0x7f08044c), s1);
            i = 1;
        }
        if (Strings.notEmpty(s))
        {
            addSeparator(paymentDetailsContainer);
            getBasicListItem(paymentDetailsContainer, 0x7f03016d, getString(0x7f0803ca), s);
            i = 1;
        }
        s = groupon.cash;
        s1 = groupon.credit;
        if (Strings.notEmpty(s1))
        {
            addSeparator(paymentDetailsContainer);
            getBasicListItem(paymentDetailsContainer, 0x7f03016d, getString(0x7f08021b), (new StringBuilder()).append("-").append(s1).toString());
            i = 1;
        }
        if (Strings.notEmpty(s))
        {
            addSeparator(paymentDetailsContainer);
            getBasicListItem(paymentDetailsContainer, 0x7f03016d, getString(0x7f0803e4), s);
            i = 1;
        } else
        if (Strings.notEmpty(obj))
        {
            addSeparator(paymentDetailsContainer);
            getBasicListItem(paymentDetailsContainer, 0x7f03016d, getString(0x7f0803e4), ((String) (obj)));
            i = 1;
        }
        obj = paymentDetailsContainer;
        if (i != 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((LinearLayout) (obj)).setVisibility(i);
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        LoaderCallbacksUtil.handleSyncError(runnable, exception, this, loginService, countryUtil, currentCountryManager.getCurrentCountry(), universalSyncManager, intentFactory, new Function2() {

            final Groupon this$0;

            public volatile void execute(Object obj, Object obj1)
                throws Exception
            {
                execute((Runnable)obj, (Exception)obj1);
            }

            public void execute(Runnable runnable1, Exception exception1)
            {
                LoaderCallbacksUtil.showGenericErrorMessage(runnable1, exception1, context, dialogManager, universalSyncManager, null, new Function2() {

                    final _cls15 this$1;

                    public volatile void execute(Object obj, Object obj1)
                        throws Exception
                    {
                        execute((Runnable)obj, (Exception)obj1);
                    }

                    public void execute(Runnable runnable, Exception exception)
                    {
                        startActivity(intentFactory.newMyGrouponsIntent(myGrouponsTabPosition));
                        finish();
                    }

            
            {
                this$1 = _cls15.this;
                super();
            }
                });
            }

            
            {
                this$0 = Groupon.this;
                super();
            }
        });
    }

    protected void handleTripDetailsSection()
    {
        boolean flag = false;
        Object obj = groupon.travellerFirstName;
        String s = groupon.travellerLastName;
        int j = groupon.numOfNights;
        int i;
        if (Strings.notEmpty(obj) || Strings.notEmpty(s))
        {
            LinearLayout linearlayout = tripDetailsContainer;
            String s1 = getString(0x7f0803ea);
            StringBuilder stringbuilder = new StringBuilder();
            if (Strings.isEmpty(obj))
            {
                obj = "";
            } else
            {
                obj = (new StringBuilder()).append(((String) (obj))).append(" ").toString();
            }
            getBasicListItem(linearlayout, 0x7f03016d, s1, stringbuilder.append(((String) (obj))).append(s).toString());
            flag = true;
        }
        obj = DivisionTimeZone.getDateToDisplay(groupon.checkInDate, this);
        if (Strings.notEmpty(obj))
        {
            addSeparator(tripDetailsContainer);
            getBasicListItem(tripDetailsContainer, 0x7f03016d, getString(0x7f0800af), ((String) (obj)));
            flag = true;
            expirationView.setText(String.format(getString(0x7f0800b1), new Object[] {
                obj
            }));
        }
        obj = DivisionTimeZone.getDateToDisplay(groupon.checkOutDate, this);
        if (Strings.notEmpty(obj))
        {
            addSeparator(tripDetailsContainer);
            getBasicListItem(tripDetailsContainer, 0x7f03016d, getString(0x7f0800b2), ((String) (obj)));
            flag = true;
        }
        if (j > 0)
        {
            obj = getApplicationContext().getResources().getQuantityString(0x7f0c0013, j);
            addSeparator(tripDetailsContainer);
            getBasicListItem(tripDetailsContainer, 0x7f03016d, ((String) (obj)), Strings.toString(Integer.valueOf(j)));
            flag = true;
        }
        obj = tripDetailsContainer;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((LinearLayout) (obj)).setVisibility(i);
    }

    protected boolean hasCartIcon()
    {
        return true;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        configureToolbarTitle();
    }

    protected boolean isViewed()
    {
        return Strings.notEmpty(groupon.printedAt);
    }

    protected void launchRedeemView(String s)
    {
        if (Strings.notEmpty(s))
        {
            if (connectivityManager.getActiveNetworkInfo() == null)
            {
                GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(primeNoNetworkTitle, primeNoNetworkMessage), "generic_error_dialog");
                return;
            } else
            {
                startActivity(intentFactory.newRedeemIntent(true, grouponId));
                return;
            }
        } else
        {
            startActivityForResult(intentFactory.newRedeemIntent(false, grouponId), 10115);
            return;
        }
    }

    protected void loadNonUSFinePrint(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s1;
        if (deviceInfoUtil.isRTLLanguage())
        {
            s1 = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{ direction: rtl; margin:0px; } ul{padding-left:25px} blockquote{margin:0px;}</style>";
        } else
        {
            s1 = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:0px;} ul{padding-left:25px} blockquote{margin:0px;}</style>";
        }
        s = stringbuilder.append(s1).append(Strings.join("<BR />", new String[] {
            s, "<BR />", groupon.listDescriptions
        })).toString();
        finePrintView.loadDataWithBaseURL(null, s, "text/html", "UTF-8", null);
    }

    protected void logBookNowButtonClick(int i, String s, String s1)
    {
        i;
        JVM INSTR lookupswitch 4: default 44
    //                   2131230837: 126
    //                   2131231747: 140
    //                   2131231755: 147
    //                   2131231756: 133;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        s = "";
_L7:
        if (Strings.notEmpty(s))
        {
            s1 = new ClickMetadata(getPageViewId(), groupon.remoteId);
            RedemptionExtraInfo redemptionextrainfo = new RedemptionExtraInfo(groupon.grouponNumber, groupon.redemptionCode, groupon.uuid);
            logger.logClick("", s, groupon.dealId, s1, redemptionextrainfo);
        }
        return;
_L2:
        s = "book_now_click";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "view_reservation_click";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "view_appointment_click";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "view_request_click";
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected void markAsViewedAndDisplayVoucher(String s)
    {
        final String externalVoucherUrl = groupon.externalVoucherUrl;
        if (!currentCountryManager.getCurrentCountry().requiresMarkViewedBeforeShowingBarcode() || isViewed())
        {
            launchRedeemView(externalVoucherUrl);
            return;
        } else
        {
            Ln.d("BARCODE: marking groupon as viewed", new Object[0]);
            startRefreshingViewVoucherButton();
            markUsedManager.markUsedImmediately(s, new Function1() {

                final Groupon this$0;

                public void execute(MarkUsedData markuseddata)
                {
                    Ln.d("BARCODE: mark used success, got %s", new Object[] {
                        markuseddata.toString()
                    });
                    groupon.barcodeImageUrl = markuseddata.barcodeImageUrl;
                    groupon.redemptionCode = markuseddata.redemptionCode;
                    groupon.remoteId = markuseddata.id;
                    groupon.printedAt = markuseddata.printedAt;
                    markuseddata = markuseddata.externalVoucherUrl;
                    groupon.externalVoucherUrl = markuseddata;
                    launchRedeemView(markuseddata);
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((MarkUsedData)obj);
                }

            
            {
                this$0 = Groupon.this;
                super();
            }
            }, new Function1() {

                final Groupon this$0;
                final String val$externalVoucherUrl;

                public void execute(Exception exception)
                {
                    if (connectivityManager.getActiveNetworkInfo() == null)
                    {
                        GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(primeNoNetworkTitle, primeNoNetworkMessage), "groupon_mark_used_network_error_dialog");
                        return;
                    }
                    if ((exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 404)
                    {
                        Ln.e(exception);
                        launchRedeemView(externalVoucherUrl);
                        return;
                    } else
                    {
                        GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(Integer.valueOf(0x7f080165)), "groupon_mark_used_http_error_dialog");
                        return;
                    }
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((Exception)obj);
                }

            
            {
                this$0 = Groupon.this;
                externalVoucherUrl = s;
                super();
            }
            }, new Function0() {

                final Groupon this$0;

                public void execute()
                {
                    useGrouponView.setText(getViewVoucherButtonText());
                    stopRefreshingViewVoucherButton();
                }

            
            {
                this$0 = Groupon.this;
                super();
            }
            });
            return;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 10115 && j == 100)
        {
            setResult(j);
            finish();
        } else
        {
            if ((i == 10140 || i == 10141) && j == -1)
            {
                getLoaderManager().restartLoader(0, null, universalLoaderCallbacks);
                return;
            }
            if (i == 0)
            {
                finish();
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030124);
        isBookingUpdates1408USCA = abTestService.isVariantEnabledAndUSCA("bookingUpdates1408USCA", "on");
        isGDT1503USCA = abTestService.isVariantEnabledAndUSCA("GDT1503USCA", "on");
        configureLoaderCallBacks();
        if (!grouponId.contains("groupon_item_internal_id"))
        {
            configureSyncManager();
        }
        abTestService.isVariantEnabled("AAonMyGrouponDetailsPage1510", "On");
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 0x7f10001d, 0, 0x7f080370).setIcon(0x7f0201f5).setShowAsAction(2);
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy()
    {
        super.onDestroy();
        finePrintView.destroy();
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
        if (!Strings.equals(s, "use_groupon_dialog")) goto _L2; else goto _L1
_L1:
        if (!shouldShowSelectLocation()) goto _L4; else goto _L3
_L3:
        showSelectLocation();
_L6:
        return;
_L4:
        showRedeemLauncher();
        return;
_L2:
        if (Strings.equals(s, "groupon_mark_used_network_error_dialog") || Strings.equals(s, "groupon_mark_used_http_error_dialog"))
        {
            setViewVoucherButtonText();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
label0:
        {
            if (universallistloadresultdata.getListData().size() > 0)
            {
                groupon = (MyGrouponItem)universallistloadresultdata.getListData().get(0);
                if (groupon != null)
                {
                    configureToolbarTitle();
                    finePrintView.setBackground(null);
                    universalRulesView.setMovementMethod(LinkMovementMethod.getInstance());
                    useGrouponView.setText(getViewVoucherButtonText());
                    if (!isGDT1503USCA || !groupon.dealOptionSpecificAttributeDelivery && !groupon.isDealOptionSpecificAttributeTakeout)
                    {
                        break label0;
                    }
                    checkGdtLocations();
                }
            }
            return;
        }
        refresh();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (isDeepLinked) goto _L2; else goto _L1
_L1:
        menuitem.getItemId();
        JVM INSTR lookupswitch 2: default 40
    //                   16908332: 46
    //                   2131755037: 64;
           goto _L2 _L3 _L4
_L2:
        return super.onOptionsItemSelected(menuitem);
_L3:
        navigateUpTo(intentFactory.newMyGrouponsIntent(myGrouponsTabPosition));
        return true;
_L4:
        if (groupon != null)
        {
            String s = String.format("http://www.groupon.com/dispatch/%s/deal/%s", new Object[] {
                currentCountryManager.getCurrentCountry().shortName, groupon.dealId
            });
            (new ShareHelper(this, groupon.dealTitle, s)).shareDeal();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void onPause()
    {
        super.onPause();
        universalSyncManager.stopAutomaticSyncs();
    }

    protected void onResume()
    {
        super.onResume();
        universalSyncManager.startAutomaticSyncs(this, null);
        useGrouponView.setEnabled(true);
    }

    public void refresh()
    {
        Object obj;
        final Object websiteUrl;
        int i;
        Object obj3 = groupon.voucherReleaseAt;
        Calendar calendar = Calendar.getInstance();
        isBookableTravelDeal = groupon.isBookableTravelDeal;
        websiteUrl = groupon.title;
        Object obj1 = groupon.subTitle;
        String s;
        String s1;
        TextView textview;
        boolean flag;
        int j;
        int k;
        final int bookButtonDisplayResource;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        if (Strings.equals(groupon.showUseThisGroupon, "YES") || Strings.equals(groupon.showUseThisGroupon, "true"))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        s = groupon.availability;
        obj = s;
        if (Strings.isEmpty(s))
        {
            obj = groupon.purchaseStatus;
        }
        flag2 = Strings.equals(obj, "redeemed");
        flag1 = Strings.equals(obj, "refund_pending");
        s = groupon.remoteId;
        flag3 = Strings.equals(obj, "pending");
        s1 = groupon.status;
        flag4 = Strings.equalsIgnoreCase(s1, "failed");
        if (!flag1 && !flag2 && !flag3 && !flag4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        textview = titleView;
        if (!Strings.notEmpty(websiteUrl))
        {
            websiteUrl = groupon.dealTitle;
        }
        textview.setText(((CharSequence) (websiteUrl)));
        textview = subtitleView;
        if (Strings.notEmpty(obj1))
        {
            websiteUrl = obj1;
        } else
        {
            websiteUrl = "";
        }
        textview.setText(((CharSequence) (websiteUrl)));
        vendorNameView.setText(groupon.name);
        websiteUrl = Strings.toString(groupon.instructions).replace("\\r\\n", "\n").replace("\r\n", "\n").replace("\n", "<br />");
        if (Strings.notEmpty(websiteUrl))
        {
            websiteUrl = Html.fromHtml(((String) (websiteUrl)));
            removeInvalidSpans(((Spanned) (websiteUrl)));
            instructionsView.setText(((CharSequence) (websiteUrl)));
            instructionsView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (groupon.isGift && groupon.isSentGift())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        setInfoForGifts();
        getSupportInfo(isBookableTravelDeal);
        websiteUrl = (new StringBuilder()).append("<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:0px;} ul{padding-left:25px} blockquote{margin:0px;}</style>").append(groupon.listDescriptionFromDetails).toString();
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            finePrintView.loadDataWithBaseURL(null, ((String) (websiteUrl)), "text/html", "UTF-8", null);
        } else
        {
            loadNonUSFinePrint(((String) (websiteUrl)));
        }
        flag3 = isOrderEditable();
        if (!Strings.equalsIgnoreCase(vendorNameView.getText(), subtitleView.getText()) && Strings.notEmpty(subtitleView.getText()) && !flag3)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        websiteUrl = subtitleView;
        if (k != 0)
        {
            bookButtonDisplayResource = 0;
        } else
        {
            bookButtonDisplayResource = 8;
        }
        ((TextView) (websiteUrl)).setVisibility(bookButtonDisplayResource);
        websiteUrl = subtitleDivider;
        if (k != 0)
        {
            k = 0;
        } else
        {
            k = 8;
        }
        ((View) (websiteUrl)).setVisibility(k);
        websiteUrl = usedOnView;
        if (flag2 && j == 0)
        {
            k = 0;
        } else
        {
            k = 8;
        }
        ((TextView) (websiteUrl)).setVisibility(k);
        websiteUrl = usedOnDivider;
        if (flag2 && j == 0)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((View) (websiteUrl)).setVisibility(j);
        websiteUrl = vendorNameView;
        if (Strings.notEmpty(vendorNameView.getText()))
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((TextView) (websiteUrl)).setVisibility(j);
        obj1 = noVoucher;
        if (isBookableTravelDeal)
        {
            websiteUrl = getString(0x7f0802b5);
        } else
        {
            if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
            {
                j = 0x7f0802b3;
            } else
            {
                j = 0x7f0802aa;
            }
            websiteUrl = getString(j);
        }
        ((TextView) (obj1)).setText(((CharSequence) (websiteUrl)));
        websiteUrl = noVoucher;
        if (isBookableTravelDeal && !currentCountryManager.getCurrentCountry().isJapan())
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((TextView) (websiteUrl)).setVisibility(j);
        if (obj3 != null && ((Date) (obj3)).after(calendar.getTime()))
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (k == 0 && Strings.equalsIgnoreCase(s1, "succeeded") && (Strings.equalsIgnoreCase(obj, "available") || Strings.equalsIgnoreCase(obj, "purchased")))
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if ((j != 0 || Strings.equalsIgnoreCase(obj, "redeemed")) && isBookableTravelDeal && currentCountryManager.getCurrentCountry().isJapan())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        obj = bottomBarView;
        if (j != 0 || flag3)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((View) (obj)).setVisibility(j);
        if (getResources().getConfiguration().orientation == 1)
        {
            obj = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
            dealImageView.setImageUrl(groupon.largeImageUrl, new AspectScaleTransformation(((DisplayMetrics) (obj)).widthPixels));
        } else
        {
            dealImageView.setImageUrl(groupon.largeImageUrl);
        }
        if (k != 0 || flag1)
        {
            Object obj2;
            if (k != 0)
            {
                obj = String.format("%s\n%s %s", new Object[] {
                    available, finePrintDateFormat.format(((Date) (obj3))), localTimeDateFormat.format(((Date) (obj3)))
                });
            } else
            {
                obj = refundPending;
            }
            messageView.setText(((CharSequence) (obj)));
            messageView.setVisibility(0);
        }
        if (i == 0)
        {
            messageView.setText(voucherInSeparateEmail);
            messageView.setVisibility(0);
        }
        useGrouponView.setOnClickListener(new android.view.View.OnClickListener() {

            private static final int CLICK_THRESHOLD_MILLIS = 1500;
            private long lastClickMillis;
            final Groupon this$0;

            public void onClick(View view)
            {
                long l = SystemClock.elapsedRealtime();
                if (l - lastClickMillis > 1500L)
                {
                    triggerUseGrouponClick();
                }
                lastClickMillis = l;
            }

            
            {
                this$0 = Groupon.this;
                super();
            }
        });
        loggingUtils.logPageView("", getPageViewId(), Logger.NULL_NST_FIELD);
        bookButtonDisplayResource = getBookButtonDisplayResource();
        if (bookButtonDisplayResource != -1 && i != 0 && flag && !shouldShowGdt && !flag3)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (j != 0 && groupon.bookable && Strings.notEmpty(groupon.localBookingInfoStatus) && Strings.notEmpty(groupon.bookingType))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((i == 0 || isGdtRedeemed || k != 0 || flag1 || flag) && !flag3)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (currentCountryManager.getCurrentCountry().isUSACompatible() && !isGdtRedeemed && groupon.isEditable && !flag3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = ((flag) ? 1 : 0);
        if (j != 0)
        {
            bookNowButton.setOnClickListener(new android.view.View.OnClickListener() {

                final Groupon this$0;
                final int val$bookButtonDisplayResource;

                public void onClick(View view)
                {
                    logBookNowButtonClick(bookButtonDisplayResource, groupon.dealId, groupon.remoteId);
                    handleBookingUpdateClick();
                }

            
            {
                this$0 = Groupon.this;
                bookButtonDisplayResource = i;
                super();
            }
            });
            bookNowButton.setVisibility(0);
            bookNowButton.setText(bookButtonDisplayResource);
        } else
        {
            bookNowButton.setVisibility(8);
        }
        bookButtonDisplayResource = i;
        if (shouldShowGdt)
        {
            if (!isGdtRedeemed)
            {
                obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
                bookButtonDisplayResource = getResources().getDimensionPixelSize(0x7f0b011f);
                if (flag)
                {
                    i = bookButtonDisplayResource;
                } else
                {
                    i = 0;
                }
                ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(bookButtonDisplayResource, 0, bookButtonDisplayResource, i);
                bottomBarButtonsContainer.removeView(useGrouponView);
                useGrouponView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                pageButtonsContainer.addView(useGrouponView, 0);
                if (k == 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
            }
            gdtOrderButton.setOnClickListener(new android.view.View.OnClickListener() {

                final Groupon this$0;

                public void onClick(View view)
                {
                    handleGdtOrderClick();
                }

            
            {
                this$0 = Groupon.this;
                super();
            }
            });
            bookButtonDisplayResource = i;
        }
        obj = gdtOrderButton;
        if (shouldShowGdt)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((Button) (obj)).setVisibility(i);
        obj = gdtOrderButton;
        if (isGdtRedeemed)
        {
            i = 0x7f0801e0;
        } else
        {
            i = 0x7f0801dd;
        }
        ((Button) (obj)).setText(i);
        obj = cancelOrderButton;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((Button) (obj)).setVisibility(i);
        obj = pageButtonsContainer;
        if (bookButtonDisplayResource != 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((LinearLayout) (obj)).setVisibility(i);
        obj = useGrouponView;
        if (k != 0)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((SpinnerButton) (obj)).setVisibility(i);
        if (k == 0)
        {
            useGrouponView.setTextSize(1, 15F);
            if (j != 0)
            {
                bookNowButton.setTextSize(1, 15F);
                useGrouponView.setupSecondaryActionButtonStyle();
            } else
            if (isOrderEditable())
            {
                useGrouponView.setupCancelActionButtonStyle();
                if (Strings.notEmpty(groupon.statusMessage))
                {
                    status.setVisibility(0);
                    status.setText(groupon.statusMessage);
                }
            }
        }
        obj = groupon.expiresAt;
        websiteUrl = MyGrouponUtils.getGrouponDivisionTimezoneIdentifier(groupon);
        obj2 = MyGrouponUtils.getGrouponDivisionTimezoneOffsetInSeconds(groupon);
        obj3 = expirationFormat;
        if (!currentCountryManager.getCurrentCountry().isJapan() && !currentCountryManager.getCurrentCountry().isRussia())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((ExpirationFormat) (obj3)).shouldDisplayUSFriendlyDateFormat(flag1);
        expirationFormat.shouldDisplayRUFriendlyDateFormat(currentCountryManager.getCurrentCountry().isRussia());
        expirationView.setText(expirationFormat.format(((Date) (obj)), ((String) (websiteUrl)), ((Integer) (obj2))));
        contentView.setVisibility(0);
        grouponContent.setVisibility(0);
        progressView.setVisibility(8);
        confirmVoucherHelper.refreshMapSection(groupon, groupon.getRedemptionLocations(), mapSlice, groupon.name, vendorNameView, "mygroupons");
        websiteUrl = groupon.customerRedeemedAt;
        expirationFormat.shouldDisplayTime(true);
        obj = expirationFormat.format(((Date) (websiteUrl)), null, null, null, null);
        if (flag2 && websiteUrl != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            websiteUrl = usedOnView;
            obj2 = getApplicationContext();
            if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
            {
                j = 0x7f0803b5;
            } else
            {
                j = 0x7f080282;
            }
            ((TextView) (websiteUrl)).setText(String.format(((Context) (obj2)).getString(j), new Object[] {
                s, obj
            }));
        }
        obj = usedOnView;
        if (i != 0)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((TextView) (obj)).setVisibility(j);
        obj = usedOnDivider;
        if (i != 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        websiteUrl = groupon.websiteUrl;
        obj = new URL(((String) (websiteUrl)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_2180;
        }
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            break MISSING_BLOCK_LABEL_2180;
        }
        obj = ((URL) (obj)).getAuthority();
_L1:
        vendorUrlView.setText(((CharSequence) (obj)));
        obj = vendorUrlView;
        if (Strings.notEmpty(vendorUrlView.getText()))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        try
        {
            ((TextView) (obj)).setVisibility(i);
            vendorUrlView.setOnClickListener(new android.view.View.OnClickListener() {

                final Groupon this$0;
                final String val$websiteUrl;

                public void onClick(View view)
                {
                    try
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(websiteUrl)));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                }

            
            {
                this$0 = Groupon.this;
                websiteUrl = s;
                super();
            }
            });
        }
        catch (MalformedURLException malformedurlexception)
        {
            vendorUrlView.setVisibility(8);
        }
        if (isBookableTravelDeal)
        {
            handleTripDetailsSection();
            handlePaymentDetailsSection();
        }
        imageContainer.setOnClickListener(new android.view.View.OnClickListener() {

            final Groupon this$0;

            public void onClick(View view)
            {
                view = groupon.dealId;
                String s2 = groupon.dealOptionId;
                if (Strings.notEmpty(view))
                {
                    if (Strings.notEmpty(s2))
                    {
                        view = intentFactory.newDealIntentWithOption(view, s2, true);
                    } else
                    {
                        view = intentFactory.newDealIntent(view, null, false, true);
                    }
                    startActivity(view);
                }
            }

            
            {
                this$0 = Groupon.this;
                super();
            }
        });
        if (flag)
        {
            cancelOrderButton.setOnClickListener(new android.view.View.OnClickListener() {

                final Groupon this$0;

                public void onClick(View view)
                {
                    view = new ClickMetadata(getPageViewId(), groupon.remoteId);
                    RedemptionExtraInfo redemptionextrainfo = new RedemptionExtraInfo(groupon.grouponNumber, groupon.redemptionCode, groupon.uuid);
                    logger.logClick("", "cancel_order_click", "cancel_order", view, redemptionextrainfo);
                    view = intentFactory.newCancelOrderIntent();
                    view.putExtra("dealId", groupon.dealId);
                    view.putExtra("orderID", groupon.orderId);
                    view.putExtra("optionId", groupon.dealOptionId);
                    startActivityForResult(view, 10146);
                }

            
            {
                this$0 = Groupon.this;
                super();
            }
            });
        }
        updateShipmentInfo();
        updateMapAndLocation();
        return;
        obj = String.format(getResources().getString(0x7f0800bd), new Object[] {
            websiteUrl
        });
          goto _L1
    }

    protected void removeInvalidSpans(Spanned spanned)
    {
        int i = 0;
        if (spanned instanceof SpannableStringBuilder)
        {
            spanned = (SpannableStringBuilder)spanned;
            Object aobj[] = spanned.getSpans(0, spanned.length(), java/lang/Object);
            for (int j = aobj.length; i < j; i++)
            {
                Object obj = aobj[i];
                int k = spanned.getSpanEnd(obj);
                if (!(obj instanceof URLSpan))
                {
                    continue;
                }
                URLSpan urlspan = (URLSpan)obj;
                if (!urlspan.getURL().startsWith("http://") && !urlspan.getURL().startsWith("https://"))
                {
                    StringBuilder stringbuilder = new StringBuilder();
                    stringbuilder.append(" (");
                    stringbuilder.append(urlspan.getURL());
                    stringbuilder.append(")");
                    spanned.insert(k, stringbuilder);
                    spanned.removeSpan(obj);
                }
            }

        }
    }

    protected void setInfoForGifts()
    {
        if (groupon.isGift && (groupon.isSentGift() || groupon.isReceivedGift()))
        {
            giftContainer.setVisibility(0);
            String s = groupon.giftRecipientName;
            String s1 = groupon.giftRecipientEmail;
            if (groupon.isSentGift())
            {
                giftSubjectView.setText(com.groupon.view.MyGrouponItem.generateSentGiftText(groupon, getResources()));
                giftSubjectView.setVisibility(0);
            } else
            if (groupon.isReceivedGift())
            {
                String s2 = String.format(getResources().getString(0x7f080303), new Object[] {
                    groupon.giftFromName
                });
                giftSubjectView.setText(s2);
                giftSubjectView.setVisibility(0);
            } else
            {
                giftSubjectView.setVisibility(8);
            }
            if (Strings.notEmpty(s) && Strings.notEmpty(s1))
            {
                giftEmailView.setVisibility(0);
                giftEmailView.setText(s1);
            } else
            {
                giftEmailView.setVisibility(8);
            }
            if (groupon.isSentGift() && groupon.isGiftClaimed)
            {
                giftClaimedView.setVisibility(0);
                giftClaimedView.setText(0x7f0801ed);
                return;
            } else
            {
                giftClaimedView.setVisibility(8);
                return;
            }
        } else
        {
            giftContainer.setVisibility(8);
            return;
        }
    }

    protected void setViewVoucherButtonText()
    {
        if (useGrouponView.getVisibility() == 0)
        {
            useGrouponView.setText(getViewVoucherButtonText());
            stopRefreshingViewVoucherButton();
        }
    }

    protected void setupShipmentItem(Shipment shipment)
    {
        Object obj;
        View view;
        TextView textview;
        TextView textview1;
        View view1;
        byte byte0;
        byte byte1;
        view = layoutInflater.inflate(0x7f0301ec, null);
        textview = (TextView)view.findViewById(0x7f100511);
        textview1 = (TextView)view.findViewById(0x7f100513);
        view1 = view.findViewById(0x7f100512);
        byte1 = 8;
        obj = shipmentInfoStatusNotShipped;
        byte0 = byte1;
        if (shipment == null) goto _L2; else goto _L1
_L1:
        String s;
        Object obj1;
        obj1 = shipment.trackingNumber;
        s = shipment.trackingUrl;
        shipment = shipment.carrier;
        if (Strings.notEmpty(shipment))
        {
            shipment = String.format(shipmentInfoStatusShippedFormat, new Object[] {
                shipment
            });
        } else
        if (Strings.notEmpty(obj1) || Strings.notEmpty(s))
        {
            shipment = shipmentInfoStatusShipped;
        } else
        {
            shipment = shipmentInfoStatusNotShipped;
        }
        if (!Strings.notEmpty(s)) goto _L4; else goto _L3
_L3:
        obj = obj1;
        if (Strings.isEmpty(obj1))
        {
            try
            {
                obj = (new URL(s)).getAuthority();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = s;
            }
        }
        obj1 = new SpannableString(((CharSequence) (obj)));
        ((SpannableString) (obj1)).setSpan(new URLSpan(s), 0, ((String) (obj)).length(), 33);
        textview1.setMovementMethod(LinkMovementMethod.getInstance());
        textview1.setText(((CharSequence) (obj1)));
        byte0 = 0;
        obj = shipment;
_L2:
        textview.setText(((CharSequence) (obj)));
        view1.setVisibility(byte0);
        shipmentInfoContainer.addView(view);
        return;
_L4:
        obj = shipment;
        byte0 = byte1;
        if (Strings.notEmpty(obj1))
        {
            textview1.setText(((CharSequence) (obj1)));
            byte0 = 0;
            obj = shipment;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected boolean shouldShowSelectLocation()
    {
        ArrayList arraylist = groupon.getRedemptionLocations();
        return currentCountryManager.getCurrentCountry().isRussia() && !groupon.located && arraylist != null && arraylist.size() > 0;
    }

    protected void showRedeemLauncher()
    {
        ClickMetadata clickmetadata = new ClickMetadata(getPageViewId(), groupon.remoteId);
        RedemptionExtraInfo redemptionextrainfo = new RedemptionExtraInfo(groupon.grouponNumber, groupon.redemptionCode, groupon.uuid);
        logger.logClick("", "show_voucher_click", groupon.dealId, clickmetadata, redemptionextrainfo);
        markAsViewedAndDisplayVoucher(groupon.remoteId);
    }

    protected void showSelectLocation()
    {
        Object obj = groupon.getRedemptionLocations();
        HashMap hashmap = new HashMap(((List) (obj)).size());
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (com.groupon.db.models.Location)((Iterator) (obj)).next();
            String s = ((com.groupon.db.models.Location) (obj1)).streetAddress1;
            obj1 = ((com.groupon.db.models.Location) (obj1)).remoteId;
            if (Strings.notEmpty(s) && Strings.notEmpty(obj1))
            {
                hashmap.put(s, obj1);
            }
        } while (true);
        startActivityForResult(intentFactory.newGrouponLocationSelectionIntent(grouponId, hashmap), 10141);
    }

    protected void startRefreshingViewVoucherButton()
    {
        useGrouponView.startSpinning();
    }

    protected void stopRefreshingViewVoucherButton()
    {
        useGrouponView.stopSpinning();
    }

    protected void updateMapAndLocation()
    {
        boolean flag = groupon.shouldDisplayMap;
        boolean flag1 = groupon.shouldDisplayLocation;
        mapSlice.toggleMapViewVisibility(flag);
        mapSlice.toggleVendorAddressVisibility(flag1);
    }

    protected void updateShipmentInfo()
    {
        byte byte3 = 8;
        boolean flag = false;
        byte byte1 = 0;
        boolean flag2 = isOrderEditable();
        byte byte0 = flag;
        byte byte2 = byte3;
        if (groupon != null)
        {
            byte0 = flag;
            byte2 = byte3;
            if (groupon.hasTrackableShipments)
            {
                boolean flag1 = false;
                if (!flag2)
                {
                    byte1 = 8;
                }
                ArrayList arraylist = groupon.getShipments();
                if (arraylist != null && arraylist.size() > 0)
                {
                    int i = 0;
                    do
                    {
                        byte0 = byte1;
                        byte2 = flag1;
                        if (i >= arraylist.size())
                        {
                            break;
                        }
                        setupShipmentItem((Shipment)arraylist.get(i));
                        i++;
                    } while (true);
                } else
                {
                    setupShipmentItem(null);
                    byte2 = flag1;
                    byte0 = byte1;
                }
            }
        }
        shipmentInfoContainer.setVisibility(byte2);
        View view = bottomBarView;
        byte1 = byte0;
        if (!flag2)
        {
            byte1 = byte0;
            if (isBookableTravelDeal)
            {
                byte1 = byte0;
                if (!currentCountryManager.getCurrentCountry().isJapan())
                {
                    byte1 = 8;
                }
            }
        }
        view.setVisibility(byte1);
    }




/*
    static String access$102(Groupon groupon1, String s)
    {
        groupon1.gdtOrderId = s;
        return s;
    }

*/


/*
    static boolean access$202(Groupon groupon1, boolean flag)
    {
        groupon1.shouldShowGdt = flag;
        return flag;
    }

*/


/*
    static boolean access$302(Groupon groupon1, boolean flag)
    {
        groupon1.isGdtRedeemed = flag;
        return flag;
    }

*/






}
