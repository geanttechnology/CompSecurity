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
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.events.CustomPageViewEvent;
import com.groupon.loader.MyGrouponItemLoaderCallbacks;
import com.groupon.models.MarkUsedData;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.models.nst.ClickMetadata;
import com.groupon.models.nst.RedemptionExtraInfo;
import com.groupon.service.LocationService;
import com.groupon.service.LoginService;
import com.groupon.service.MarkUsedManager;
import com.groupon.service.VoucherService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BitmapUtil;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.ExpirationFormat;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.LoggingUtils;
import com.groupon.util.MyGrouponUtils;
import com.groupon.util.RedemptionUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory, GrouponBookNowActivity

public class Redeem extends GrouponActivity
    implements CustomPageViewEvent, GrouponDialogListener
{
    private class CustomerServiceOnClickListener
        implements android.view.View.OnClickListener
    {

        final Redeem this$0;

        public void onClick(View view)
        {
            startActivity(((IntentFactory)intentFactory.get()).newCustomerServiceIntent());
        }

        private CustomerServiceOnClickListener()
        {
            this$0 = Redeem.this;
            super();
        }

    }

    public abstract class Delegate
    {

        final Redeem this$0;

        public abstract String getExpirationString(Date date, String s, Integer integer);

        public abstract String getGrouponString(String s);

        public abstract int getInstructionsAndHelpStringResource();

        public abstract String getRefNumberString(String s);

        public abstract String getSecurityCodeString(String s);

        public abstract void onClick();

        public abstract void onCreate(Bundle bundle);

        public abstract void refresh();

        public Delegate()
        {
            this$0 = Redeem.this;
            super();
        }
    }

    public class LiveEventLayout extends RedesignedLayout
    {

        final Redeem this$0;

        public void onCreate(Bundle bundle)
        {
            setContentView(0x7f0301db);
        }

        public void refresh()
        {
            event.setText(groupon.ticketEvent);
            account.setText(groupon.ticketAccount);
            moreInfo.setText(groupon.ticketEntrance);
            section.setText(groupon.ticketSection);
            row.setText(groupon.ticketRow);
            seat.setText(groupon.ticketSeat);
        }

        public LiveEventLayout()
        {
            this$0 = Redeem.this;
            super();
        }
    }

    public class RedesignedLayout extends Delegate
    {

        final Redeem this$0;

        public String getExpirationString(Date date, String s, Integer integer)
        {
            return expirationFormat.format(date, s, integer, null);
        }

        public String getGrouponString(String s)
        {
            return s;
        }

        public int getInstructionsAndHelpStringResource()
        {
            return 0x7f080290;
        }

        public String getRefNumberString(String s)
        {
            return s;
        }

        public String getSecurityCodeString(String s)
        {
            return s;
        }

        public void onClick()
        {
            showRedeemedView();
        }

        public void onCreate(Bundle bundle)
        {
            if (currentCountryManager.getCurrentCountry().isUSACompatible())
            {
                setContentView(0x7f0301d8);
                return;
            } else
            {
                setContentView(0x7f0301d9);
                return;
            }
        }

        public void refresh()
        {
        }

        public RedesignedLayout()
        {
            this$0 = Redeem.this;
            super();
        }
    }


    private static final String GROUPON_MARK_AS_REDEEMED_DIALOG = "groupon_mark_as_redeemed_dialog";
    public static final int MARKED_USED = 100;
    private static final String REDEEM_STAMP_DISPLAY_TIME = "redeem_stamp_display_time";
    public static final int REQUEST_CODE = 10115;
    private static final String WAS_MARKED_AS_USED = "was_marked_as_redeemed";
    TextView account;
    ImageView barcodeImageView;
    TextView barcodeNumberView;
    View barcodeView;
    private BitmapUtil bitmapUtil;
    Button bookNowView;
    LinearLayout bottomBar;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    private Delegate _flddelegate;
    private DeviceInfoUtil deviceInfoUtil;
    private DialogManager dialogManager;
    TextView event;
    private ExpirationFormat expirationFormat;
    TextView expirationView;
    private MyGrouponItem groupon;
    String grouponId;
    TextView grouponNumberView;
    private Lazy intentFactory;
    private LocationService locationService;
    private Logger logger;
    private LoggingUtils loggingUtils;
    private LoginService loginService;
    TextView maintenanceLabel;
    Button markUsedButton;
    private MarkUsedManager markUsedManager;
    TextView moreInfo;
    View progressView;
    WebView redeemInstructions;
    LinearLayout redeemInstructionsContainer;
    private ExpirationFormat redeemedAtFormat;
    TextView redeemedTimeView;
    View redeemedView;
    TextView refLabel;
    View refNumberContainer;
    TextView refNumberView;
    TextView row;
    TextView seat;
    TextView section;
    TextView showThisScreenView;
    private String stampDisplayTime;
    TextView subTitleView;
    TextView titleView;
    TextView usernameView;
    View verificationCodeContainer;
    TextView verificationCodeView;
    TextView voucherRedeemedText;
    private VoucherService voucherService;
    private boolean wasMarkedAsRedeemed;

    public Redeem()
    {
        intentFactory = new Lazy(this) {

            final Redeem this$0;

            
            {
                this$0 = Redeem.this;
                super(context);
            }
        };
    }

    private boolean hasValidTicket()
    {
        return Strings.notEmpty(groupon.ticketAccount) || Strings.notEmpty(groupon.ticketEvent) || Strings.notEmpty(groupon.ticketEntrance) || Strings.notEmpty(groupon.ticketSection) || Strings.notEmpty(groupon.ticketRow) || Strings.notEmpty(groupon.ticketSeat);
    }

    private boolean isVoucherRedeemed()
    {
        boolean flag1 = false;
        String s1 = groupon.availability;
        String s = s1;
        if (Strings.isEmpty(s1))
        {
            s = groupon.purchaseStatus;
        }
        boolean flag2 = Strings.equalsIgnoreCase(groupon.status, "succeeded");
        boolean flag;
        if (groupon.isCustomerRedeemed || groupon.isMerchantRedeemed)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s1 = groupon.remoteId;
        if (flag || markUsedManager.isQueued(s1) || markUsedManager.isCachedForGroupons(s1) || Strings.equalsIgnoreCase(s, "redeemed") && flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || groupon.isCustomerRedeemed || groupon.isMerchantRedeemed || wasMarkedAsRedeemed)
        {
            flag1 = true;
        }
        return flag1;
    }

    private void logVoucherView()
    {
        Location location = locationService.getLocation();
        if (location != null)
        {
            logger.logLocationTracking("", (float)location.getLatitude(), (float)location.getLongitude(), (int)location.getAccuracy(), System.currentTimeMillis(), Logger.NULL_NST_FIELD);
            return;
        } else
        {
            double d = (double)currentDivisionManager.getCurrentDivision().latE6 / 1000000D;
            double d1 = (double)currentDivisionManager.getCurrentDivision().lngE6 / 1000000D;
            logger.logLocationTracking("", (float)d, (float)d1, 0, System.currentTimeMillis(), Logger.NULL_NST_FIELD);
            return;
        }
    }

    private void markUsedIfNecessary(String s)
    {
        Ln.d("BARCODE: marking groupon as viewed", new Object[0]);
        if (currentCountryManager.getCurrentCountry().requiresMarkViewedBeforeShowingBarcode())
        {
            boolean flag;
            if (groupon.printedAt != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                Ln.d("BARCODE: has not yet been printed, do it now", new Object[0]);
                markUsedManager.markUsedImmediately(s, new Function1() {

                    final Redeem this$0;

                    public void execute(MarkUsedData markuseddata)
                    {
                        Ln.d("BARCODE: mark used success, got %s", new Object[] {
                            markuseddata.toString()
                        });
                        groupon.barcodeImageUrl = markuseddata.barcodeImageUrl;
                        groupon.redemptionCode = markuseddata.redemptionCode;
                        groupon.remoteId = markuseddata.id;
                        groupon.printedAt = markuseddata.printedAt;
                        updateRedemptionDetails();
                    }

                    public volatile void execute(Object obj)
                        throws Exception
                    {
                        execute((MarkUsedData)obj);
                    }

            
            {
                this$0 = Redeem.this;
                super();
            }
                }, new Function1() {

                    final Redeem this$0;

                    public void execute(Exception exception)
                    {
                        updateRedemptionDetails();
                    }

                    public volatile void execute(Object obj)
                        throws Exception
                    {
                        execute((Exception)obj);
                    }

            
            {
                this$0 = Redeem.this;
                super();
            }
                }, null);
                return;
            }
        }
        updateRedemptionDetails();
    }

    private void setExpirationView()
    {
label0:
        {
            if (expirationView != null)
            {
                Object obj = groupon.expiresAt;
                if (!Strings.notEmpty(obj))
                {
                    break label0;
                }
                boolean flag1 = DateUtils.isToday(((Date) (obj)).getTime());
                expirationView.setVisibility(0);
                expirationFormat.shouldDisplayTime(false);
                String s;
                Object obj1;
                Resources resources;
                int i;
                if (currentCountryManager.getCurrentCountry().isRussia())
                {
                    expirationFormat.shouldDisplayRUFriendlyDateFormat(true);
                } else
                {
                    boolean flag = Strings.equals(getResources().getConfiguration().locale, Locale.JAPAN);
                    ExpirationFormat expirationformat = expirationFormat;
                    if (!flag)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    expirationformat.shouldDisplayUSFriendlyDateFormat(flag);
                }
                s = MyGrouponUtils.getGrouponDivisionTimezoneIdentifier(groupon);
                obj1 = MyGrouponUtils.getGrouponDivisionTimezoneOffsetInSeconds(groupon);
                obj = _flddelegate.getExpirationString(((Date) (obj)), s, ((Integer) (obj1)));
                s = String.format(getString(0x7f0801ae), new Object[] {
                    obj
                });
                obj1 = new SpannableString(s);
                resources = getResources();
                if (flag1)
                {
                    i = 0x7f0e0144;
                } else
                {
                    i = 0x7f0e00c1;
                }
                ((Spannable) (obj1)).setSpan(new ForegroundColorSpan(resources.getColor(i)), s.length() - ((String) (obj)).length(), s.length(), 33);
                expirationView.setText(((CharSequence) (obj1)));
            }
            return;
        }
        expirationView.setVisibility(8);
    }

    private void setRedeemedTime()
    {
        boolean flag1 = true;
        int i = 0;
        Object obj;
        Object obj1;
        if (groupon.customerRedeemedAt != null)
        {
            obj = groupon.customerRedeemedAt;
        } else
        {
            obj = groupon.merchantRedeemedAt;
        }
        obj1 = "";
        if (obj != null)
        {
            obj1 = redeemedAtFormat;
            boolean flag;
            if (!currentCountryManager.getCurrentCountry().isJapan())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((ExpirationFormat) (obj1)).shouldDisplayTime(flag);
            obj1 = redeemedAtFormat;
            if (!currentCountryManager.getCurrentCountry().isJapan())
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            ((ExpirationFormat) (obj1)).shouldDisplayUSRedeemedAtDataFormat(flag);
            obj = redeemedAtFormat.format(((Date) (obj)), null, null, null, null);
        } else
        {
            obj = obj1;
            if (stampDisplayTime != null)
            {
                obj = stampDisplayTime;
            }
        }
        if (redeemedTimeView != null)
        {
            flag = Strings.notEmpty(obj);
            redeemedTimeView.setText(((CharSequence) (obj)));
            obj = redeemedTimeView;
            if (!flag)
            {
                i = 8;
            }
            ((TextView) (obj)).setVisibility(i);
        }
    }

    private void showRedeemedView()
    {
        barcodeView.setVisibility(0);
        barcodeImageView.setVisibility(8);
        markUsedButton.setVisibility(8);
        redeemedView.setVisibility(0);
        setRedeemedTime();
    }

    private void toggleRedeemButtonVisibility()
    {
        Button button = markUsedButton;
        byte byte0;
        if (isVoucherRedeemed())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        button.setVisibility(byte0);
    }

    private void updateRedemptionDetails()
    {
        String s = groupon.dealOptionId;
        Object obj = groupon.redemptionCode;
        String s1 = RedemptionUtils.addBarcodeParams(groupon.barcodeImageUrl);
        String s2 = groupon.verificationCode;
        int i;
        if (currentCountryManager.getCurrentCountry().isRussia() && Strings.notEmpty(s2))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        Ln.d("BARCODE: updateRedemptionDetails, code = %s, barcodeUrl = %s", new Object[] {
            obj, s1
        });
        if (Strings.notEmpty(obj))
        {
            SpannableString spannablestring;
            int j;
            if (!currentCountryManager.getCurrentCountry().isUSACompatible())
            {
                if (currentCountryManager.getCurrentCountry().isJapan())
                {
                    obj = groupon.cnoOrSnText;
                    s = groupon.serialNumber;
                    if (!Strings.notEmpty(obj))
                    {
                        obj = s;
                    }
                } else
                {
                    if (refNumberView != null && refNumberContainer != null)
                    {
                        s = _flddelegate.getRefNumberString(s);
                        refNumberView.setText(s);
                        View view = refNumberContainer;
                        if (Strings.notEmpty(s))
                        {
                            j = 0;
                        } else
                        {
                            j = 8;
                        }
                        view.setVisibility(j);
                    }
                    obj = _flddelegate.getSecurityCodeString(((String) (obj)));
                }
            }
            if (currentCountryManager.getCurrentCountry().isUSACompatible())
            {
                j = 0x7f080412;
            } else
            {
                j = 0x7f08034c;
            }
            s = String.format(getString(j), new Object[] {
                obj
            });
            spannablestring = new SpannableString(s);
            spannablestring.setSpan(new TypefaceSpan(getString(0x7f080511)), 0, s.length() - ((String) (obj)).length(), 33);
            barcodeNumberView.setText(spannablestring);
            barcodeNumberView.setVisibility(0);
        }
        if (verificationCodeView != null && i != 0)
        {
            verificationCodeView.setText(s2);
        }
        if (verificationCodeContainer != null)
        {
            obj = verificationCodeContainer;
            if (i != 0)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((View) (obj)).setVisibility(i);
        }
        if (refNumberContainer != null)
        {
            obj = refNumberContainer;
            if (currentCountryManager.getCurrentCountry().isJapan())
            {
                i = 8;
            } else
            {
                i = 0;
            }
            ((View) (obj)).setVisibility(i);
        }
        if (isVoucherRedeemed())
        {
            barcodeView.setVisibility(0);
            progressView.setVisibility(8);
            return;
        }
        if (Strings.notEmpty(s1))
        {
            voucherService.getVoucherBarcodeImage(s1, progressView, new Function1() {

                final Redeem this$0;

                public void execute(Bitmap bitmap)
                    throws RuntimeException
                {
                    int k = deviceInfoUtil.getDisplayMetrics().widthPixels;
                    int l = deviceInfoUtil.getDisplayMetrics().heightPixels;
                    if (usesTabletLayout())
                    {
                        k = getResources().getDimensionPixelSize(0x7f0b01e3);
                    }
                    k = (int)((float)k * 0.8F);
                    l = (int)((float)l * 0.5F);
                    bitmap = bitmapUtil.createScaledBitmap(bitmap, k, l);
                    barcodeImageView.setImageBitmap(bitmap);
                    barcodeView.setVisibility(0);
                }

                public volatile void execute(Object obj1)
                    throws Exception
                {
                    execute((Bitmap)obj1);
                }

            
            {
                this$0 = Redeem.this;
                super();
            }
            }, null, new Function0() {

                final Redeem this$0;

                public void execute()
                    throws RuntimeException
                {
                    barcodeView.setVisibility(0);
                }

            
            {
                this$0 = Redeem.this;
                super();
            }
            });
            return;
        } else
        {
            barcodeView.setVisibility(8);
            progressView.setVisibility(8);
            return;
        }
    }

    private boolean usesTabletLayout()
    {
        return getResources().getInteger(0x7f0d0001) > 1;
    }

    public void determineCustomerSupportRedirect()
    {
        String s = getString(_flddelegate.getInstructionsAndHelpStringResource());
        SpannableString spannablestring = new SpannableString(s);
        if (showThisScreenView != null)
        {
            if (currentCountryManager.getCurrentCountry().isEuCompatible() || currentCountryManager.getCurrentCountry().isUSACompatible())
            {
                spannablestring.setSpan(new UnderlineSpan(), 0, s.length(), 0);
                showThisScreenView.setOnClickListener(new CustomerServiceOnClickListener());
            } else
            {
                spannablestring.setSpan(new URLSpan(getString(0x7f0804e5, new Object[] {
                    groupon.remoteId
                })), 0, s.length(), 0);
                showThisScreenView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            showThisScreenView.setText(spannablestring);
        }
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f080410));
    }

    public void logPageViewEvent()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getLoaderManager().initLoader(0, null, new MyGrouponItemLoaderCallbacks(grouponId, bundle) {

            final Redeem this$0;
            final Bundle val$savedInstanceState;

            public void onDealLoaded(MyGrouponItem mygrouponitem)
            {
                boolean flag = false;
                if (mygrouponitem == null)
                {
                    finish();
                    return;
                }
                groupon = mygrouponitem;
                boolean flag1 = groupon.isAwaitingTicket;
                int i;
                int j;
                int k;
                boolean flag2;
                boolean flag3;
                if (hasValidTicket() || flag1)
                {
                    _flddelegate = new LiveEventLayout();
                } else
                {
                    _flddelegate = new RedesignedLayout();
                }
                _flddelegate.onCreate(savedInstanceState);
                if (savedInstanceState != null)
                {
                    wasMarkedAsRedeemed = savedInstanceState.getBoolean("was_marked_as_redeemed", false);
                    stampDisplayTime = savedInstanceState.getString("redeem_stamp_display_time", null);
                }
                if (currentCountryManager.getCurrentCountry().isUSACompatible() || !currentCountryManager.getCurrentCountry().isJapan() && currentCountryManager.getCurrentCountry().markAsUsed)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                mygrouponitem = markUsedButton;
                if (i != 0)
                {
                    j = 0;
                } else
                {
                    j = 8;
                }
                mygrouponitem.setVisibility(j);
                determineCustomerSupportRedirect();
                flag1 = groupon.isBookableTravelDeal;
                flag2 = groupon.isBooked;
                flag3 = groupon.isMaintenance;
                if (flag1 && currentCountryManager.getCurrentCountry().isJapan() && !flag3)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                if (bookNowView != null)
                {
                    mygrouponitem = bookNowView;
                    if (j != 0)
                    {
                        k = 0;
                    } else
                    {
                        k = 8;
                    }
                    mygrouponitem.setVisibility(k);
                    if (j != 0)
                    {
                        mygrouponitem = bookNowView;
                        if (flag2)
                        {
                            k = 0x7f080404;
                        } else
                        {
                            k = 0x7f080075;
                        }
                        mygrouponitem.setText(k);
                        bookNowView.setOnClickListener(new android.view.View.OnClickListener() {

                            final _cls2 this$1;

                            public void onClick(View view)
                            {
                                startActivity((new Intent(_fld0, com/groupon/activity/GrouponBookNowActivity)).putExtra("url", groupon.travelBookingUrl));
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        });
                    }
                }
                if (!currentCountryManager.getCurrentCountry().isUSACompatible() && maintenanceLabel != null)
                {
                    mygrouponitem = maintenanceLabel;
                    if (flag3)
                    {
                        k = 0;
                    } else
                    {
                        k = 8;
                    }
                    mygrouponitem.setVisibility(k);
                }
                if (bottomBar != null)
                {
                    mygrouponitem = bottomBar;
                    if (i != 0 || j != 0 || flag3)
                    {
                        j = 0;
                    } else
                    {
                        j = 8;
                    }
                    mygrouponitem.setVisibility(j);
                }
                if (markUsedButton != null)
                {
                    mygrouponitem = markUsedButton;
                    if (i != 0)
                    {
                        i = ((flag) ? 1 : 0);
                    } else
                    {
                        i = 8;
                    }
                    mygrouponitem.setVisibility(i);
                }
                if (isVoucherRedeemed())
                {
                    if (markUsedButton != null)
                    {
                        markUsedButton.setVisibility(8);
                    }
                    showRedeemedView();
                }
                refresh();
                logVoucherView();
            }

            
            {
                this$0 = Redeem.this;
                savedInstanceState = bundle;
                super(final_context, s);
            }
        });
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
        if (Strings.equals(s, "groupon_mark_as_redeemed_dialog"))
        {
            s = new ClickMetadata(getPageViewId(), groupon.remoteId);
            dialoginterface = new RedemptionExtraInfo(groupon.grouponNumber, groupon.redemptionCode, groupon.uuid);
            logger.logClick("", "redeem_voucher_cancel", groupon.dealId, s, dialoginterface);
            finish();
        }
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "groupon_mark_as_redeemed_dialog"))
        {
            s = groupon.remoteId;
            redeemedAtFormat.shouldDisplayTime(true);
            redeemedAtFormat.shouldDisplayUSRedeemedAtDataFormat(true);
            stampDisplayTime = redeemedAtFormat.format(new Date(), Calendar.getInstance().getTimeZone().getID(), Integer.valueOf(0), null, null);
            markUsedManager.markUsed(s, stampDisplayTime);
            setResult(100);
            wasMarkedAsRedeemed = true;
            _flddelegate.onClick();
            s = new ClickMetadata(getPageViewId(), groupon.remoteId);
            dialoginterface = new RedemptionExtraInfo(groupon.grouponNumber, groupon.redemptionCode, groupon.uuid);
            logger.logRedemption("", groupon.dealId, dialoginterface);
            logger.logClick("", "redeem_voucher_confirm", groupon.dealId, s, dialoginterface);
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            navigateUpTo(((IntentFactory)intentFactory.get()).newMyGrouponsIntent());
            break;
        }
        return true;
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("was_marked_as_redeemed", wasMarkedAsRedeemed);
        bundle.putString("redeem_stamp_display_time", stampDisplayTime);
    }

    public void refresh()
    {
        String s = groupon.remoteId;
        Object obj1 = groupon.grouponNumber;
        TextView textview = grouponNumberView;
        Delegate delegate1 = _flddelegate;
        Object obj = obj1;
        if (Strings.isEmpty(obj1))
        {
            obj = s;
        }
        textview.setText(delegate1.getGrouponString(((String) (obj))));
        titleView.setText(groupon.title);
        subTitleView.setText(groupon.subTitle);
        obj = groupon.redeemerName;
        obj1 = usernameView;
        if (!Strings.notEmpty(obj))
        {
            obj = loginService.getFullName();
        }
        ((TextView) (obj1)).setText(((CharSequence) (obj)));
        setExpirationView();
        if (redeemInstructionsContainer != null)
        {
            obj = redeemInstructionsContainer;
            int i;
            if (currentCountryManager.getCurrentCountry().isJapan())
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((LinearLayout) (obj)).setVisibility(i);
            if (redeemInstructions != null && currentCountryManager.getCurrentCountry().isJapan())
            {
                obj = groupon.redeemInstructions;
                redeemInstructions.setBackgroundColor(0);
                redeemInstructions.loadDataWithBaseURL(null, (new StringBuilder()).append("<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:10px 0px 0px 0px; color:#75787b;} a:link {color:#369ec1;} ul{padding-left:25px} blockquote{margin:0px;}</style>").append(((String) (obj))).toString(), "text/html", "UTF-8", null);
            }
        }
        markUsedButton.setOnClickListener(new android.view.View.OnClickListener() {

            final Redeem this$0;

            public void onClick(View view)
            {
                GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(Integer.valueOf(0x7f080414), Integer.valueOf(0x7f080413), Integer.valueOf(0x7f080232), Integer.valueOf(0x7f080205), false), "groupon_mark_as_redeemed_dialog");
                view = new ClickMetadata(getPageViewId(), groupon.remoteId);
                RedemptionExtraInfo redemptionextrainfo = new RedemptionExtraInfo(groupon.grouponNumber, groupon.redemptionCode, groupon.uuid);
                logger.logClick("", "redeem_voucher", groupon.dealId, view, redemptionextrainfo);
            }

            
            {
                this$0 = Redeem.this;
                super();
            }
        });
        _flddelegate.refresh();
        markUsedIfNecessary(s);
        loggingUtils.logPageView("", getPageViewId(), Logger.NULL_NST_FIELD);
    }



/*
    static MyGrouponItem access$002(Redeem redeem, MyGrouponItem mygrouponitem)
    {
        redeem.groupon = mygrouponitem;
        return mygrouponitem;
    }

*/












/*
    static Delegate access$202(Redeem redeem, Delegate delegate1)
    {
        redeem._flddelegate = delegate1;
        return delegate1;
    }

*/


/*
    static boolean access$302(Redeem redeem, boolean flag)
    {
        redeem.wasMarkedAsRedeemed = flag;
        return flag;
    }

*/


/*
    static String access$402(Redeem redeem, String s)
    {
        redeem.stampDisplayTime = s;
        return s;
    }

*/




}
