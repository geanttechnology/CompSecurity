// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.groupon.abtest.GiftingAbTestHelper;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.DerivedGiftTheme;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.GiftingThemePreviewSyncManagerProcess;
import com.groupon.models.country.Country;
import com.groupon.models.gift.GiftingRecord;
import com.groupon.models.nst.ClickExtraInfo;
import com.groupon.models.nst.GiftingNSTField;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GiftingUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ViewUtils;
import com.groupon.v3.loader.IUniversalCallback;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.GiftingThemePreviewLoader;
import com.groupon.view.GiftingLimitedEditText;
import com.groupon.view.UrlImageView;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponFragmentActivity, IntentFactory

public class Gifting extends GrouponFragmentActivity
    implements IUniversalCallback, commonlib.manager.SyncManager.SyncUiCallbacks
{
    protected class DatePickerFragment extends DialogFragment
        implements android.app.DatePickerDialog.OnDateSetListener
    {

        final Gifting this$0;

        public void onActivityCreated(Bundle bundle)
        {
            super.onActivityCreated(bundle);
            ((DatePickerDialog)getDialog()).updateDate(selectedDate.get(1), selectedDate.get(2), selectedDate.get(5));
        }

        public void onCreate(Bundle bundle)
        {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        public Dialog onCreateDialog(Bundle bundle)
        {
            bundle = new MyDatePickerDialog(getActivity(), this, selectedDate.get(1), selectedDate.get(2), selectedDate.get(5));
            DateFormat dateformat = DateFormat.getDateInstance(0);
            bundle.getDatePicker().setMinDate(nowDate.getTimeInMillis());
            bundle.getDatePicker().setMaxDate(endDate.getTimeInMillis());
            setTitle(dateformat.format(nowDate.getTime()));
            return bundle;
        }

        public void onDateSet(DatePicker datepicker, int i, int j, int k)
        {
            setSelectedDate(i, j, k);
            datepicker = new GregorianCalendar(i, j, k);
            setDateText(datepicker);
        }

        public void onDestroyView()
        {
            if (getDialog() != null && getRetainInstance())
            {
                getDialog().setDismissMessage(null);
            }
            super.onDestroyView();
        }

        protected void setSelectedDate(int i, int j, int k)
        {
            selectedDate.set(1, i);
            selectedDate.set(2, j);
            selectedDate.set(5, k);
        }

        protected DatePickerFragment()
        {
            this$0 = Gifting.this;
            super();
        }
    }

    protected class DatePickerFragment.MyDatePickerDialog extends DatePickerDialog
    {

        final DatePickerFragment this$1;

        public void onDateChanged(DatePicker datepicker, int i, int j, int k)
        {
            GregorianCalendar gregoriancalendar = new GregorianCalendar();
            gregoriancalendar.set(1, i);
            gregoriancalendar.set(2, j);
            gregoriancalendar.set(5, k);
            if (gregoriancalendar.before(nowDate))
            {
                datepicker.init(nowDate.get(1), nowDate.get(2), nowDate.get(5), this);
                setSelectedDate(nowDate.get(1), nowDate.get(2), nowDate.get(5));
                super.onDateChanged(datepicker, nowDate.get(1), nowDate.get(2), nowDate.get(5));
                return;
            }
            if (gregoriancalendar.after(endDate))
            {
                datepicker.init(endDate.get(1), endDate.get(2), endDate.get(5), this);
                setSelectedDate(endDate.get(1), endDate.get(2), endDate.get(5));
                super.onDateChanged(datepicker, endDate.get(1), endDate.get(2), endDate.get(5));
                return;
            } else
            {
                setSelectedDate(i, j, k);
                super.onDateChanged(datepicker, i, j, k);
                return;
            }
        }

        public DatePickerFragment.MyDatePickerDialog(Context context1, android.app.DatePickerDialog.OnDateSetListener ondatesetlistener, int i, int j, int k)
        {
            this$1 = DatePickerFragment.this;
            super(context1, ondatesetlistener, i, j, k);
        }
    }

    private class MessageCountTextWatcher
        implements TextWatcher
    {

        final Gifting this$0;

        public void afterTextChanged(Editable editable)
        {
            messageCount.setText(getString(0x7f0800ae, new Object[] {
                Integer.valueOf(220 - message1510.length())
            }));
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private MessageCountTextWatcher()
        {
            this$0 = Gifting.this;
            super();
        }

    }

    private class SenderTextOnFocusChangeListener
        implements android.view.View.OnFocusChangeListener
    {

        final Gifting this$0;

        public void onFocusChange(View view, boolean flag)
        {
            view = fromIcon;
            Resources resources = getResources();
            int i;
            if (flag)
            {
                i = 0x7f020077;
            } else
            {
                i = 0x7f020076;
            }
            view.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(i), null, null, null);
        }

        private SenderTextOnFocusChangeListener()
        {
            this$0 = Gifting.this;
            super();
        }

    }

    private class SubmitButtonOnClickListener
        implements android.view.View.OnClickListener
    {

        final Gifting this$0;

        public void onClick(View view)
        {
            if (!valid())
            {
                ViewUtils.setSoftKeyboardState(context, true, currentFocusedView);
                return;
            }
            saveData();
            setResult(-1, (new Intent()).putExtra("giftingRecord", giftingRecord));
            view = new ClickExtraInfo();
            GiftingNSTField giftingnstfield = new GiftingNSTField();
            giftingnstfield.deliveryMethod = giftingRecord.deliveryMethod;
            view.gifting = giftingnstfield;
            view.pageId = "edit_gift_info_page";
            loggingUtils.logClick("", "gifting_details_done_click", "", null, view);
            if (next != null)
            {
                next.setExtrasClassLoader(getClassLoader());
                next.putExtra("giftingRecord", giftingRecord);
                startActivity(next);
            }
            finish();
        }

        private SubmitButtonOnClickListener()
        {
            this$0 = Gifting.this;
            super();
        }

    }


    private static final int CHARACTER_LIMIT = 220;
    private static final String DB_CHANNEL = "PreviewGiftingTheme";
    private static final String DELIVERY_METHOD_KEY = "delivery_method_key";
    private static final String EDIT_GIFT_INFO_PAGE = "edit_gift_info_page";
    public static final String GIFTING_DETAILS_DONE_CLICK = "gifting_details_done_click";
    public static final String IS_GIFTABLE_DEAL = "isGiftableDeal";
    public static final int REQUEST_CODE = 10107;
    public static final int RESULT_REMOVE_GIFT = 1;
    private static final String SELECTED_DATE_KEY = "selected_date_key";
    Button cancelGiftButton;
    private Context context;
    private CurrentCountryManager currentCountryManager;
    private View currentFocusedView;
    String dealId;
    RadioButton emailButton;
    LinearLayout emailPrintToggleFrame;
    private final Calendar endDate = new GregorianCalendar();
    EditText from;
    TextView fromIcon;
    TextView giftWrapText;
    ToggleButton giftWrapToggle;
    LinearLayout giftWrapToggleFrame;
    private GiftingAbTestHelper giftingAbTestHelper;
    GiftingRecord giftingRecord;
    private boolean isEmailDelivery;
    boolean isGiftableDeal;
    private DateFormat iso8601DateFormat;
    private DateFormat localLongDateFormat;
    private Logger logger;
    private LoggingUtils loggingUtils;
    protected LoginService loginService;
    GiftingLimitedEditText message;
    EditText message1510;
    TextView messageCount;
    Intent next;
    private final Calendar nowDate = new GregorianCalendar();
    UrlImageView previewThemeImage;
    RadioButton printLaterButton;
    TextView printLaterNotice;
    EditText recipientEmail;
    EditText recipientName;
    private Calendar selectedDate;
    TextView sendByDate;
    LinearLayout sendOnLayoutFrame;
    private boolean shouldShowGiftingNewFlow;
    Button submitButton;
    RelativeLayout themeSelectSection;
    private UniversalLoaderCallbacks universalLoaderCallbacks;
    protected UniversalSyncManager universalSyncManager;

    public Gifting()
    {
        selectedDate = new GregorianCalendar();
    }

    private Date getLastDayInNextMonth(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, 1);
        calendar.set(5, calendar.getActualMaximum(5));
        return calendar.getTime();
    }

    public static boolean isEmailValid(CharSequence charsequence)
    {
        return Strings.notEmpty(charsequence) && com.groupon.Constants.RegularExpressions.EMAIL_ADDRESS.matcher(charsequence).matches();
    }

    private void saveData()
    {
        giftingRecord.fromName = Strings.toString(from.getText());
        giftingRecord.recipientName = Strings.toString(recipientName.getText());
        GiftingRecord giftingrecord = giftingRecord;
        Object obj;
        if (shouldShowGiftingNewFlow)
        {
            obj = message1510.getText();
        } else
        {
            obj = message.getText();
        }
        giftingrecord.message = Strings.toString(obj);
        if (giftingRecord.isGiftWrappable && !shouldShowGiftingNewFlow)
        {
            giftingRecord.isGiftWrapped = giftWrapToggle.isChecked();
            return;
        }
        boolean flag;
        if (isEmailDelivery && !DateUtils.isToday(selectedDate.getTimeInMillis()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (isEmailDelivery)
        {
            obj = "email";
        } else
        {
            obj = "print";
        }
        giftingRecord.deliveryMethod = ((String) (obj));
        if (isEmailDelivery)
        {
            obj = recipientEmail.getText().toString();
        } else
        {
            obj = "";
        }
        giftingRecord.recipientEmail = ((String) (obj));
        if (flag)
        {
            obj = iso8601DateFormat.format(selectedDate.getTime());
        } else
        {
            obj = "";
        }
        giftingRecord.emailDeliveryTime = ((String) (obj));
    }

    private void setDateText(Calendar calendar)
    {
        TextView textview = sendByDate;
        if (DateUtils.isToday(calendar.getTimeInMillis()))
        {
            calendar = getString(0x7f0803e0);
        } else
        {
            calendar = localLongDateFormat.format(selectedDate.getTime());
        }
        textview.setText(calendar);
    }

    private void setLayoutsVisibility(boolean flag, boolean flag1)
    {
        boolean flag2 = false;
        Object obj = recipientEmail;
        int i;
        if (flag1 || flag || !isEmailDelivery)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((EditText) (obj)).setVisibility(i);
        obj = printLaterNotice;
        if (flag1 || flag || isEmailDelivery)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((TextView) (obj)).setVisibility(i);
        obj = sendOnLayoutFrame;
        if (flag1 || flag || !isEmailDelivery)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((LinearLayout) (obj)).setVisibility(i);
        if (!shouldShowGiftingNewFlow)
        {
            LinearLayout linearlayout = emailPrintToggleFrame;
            if (flag1 || flag)
            {
                i = 8;
            } else
            {
                i = 0;
            }
            linearlayout.setVisibility(i);
            linearlayout = giftWrapToggleFrame;
            if (flag)
            {
                i = ((flag2) ? 1 : 0);
            } else
            {
                i = 8;
            }
            linearlayout.setVisibility(i);
        }
    }

    private boolean valid()
    {
        boolean flag = true;
        if (!shouldShowGiftingNewFlow) goto _L2; else goto _L1
_L1:
        if (Strings.isEmpty(message1510.getText()))
        {
            message1510.requestFocus();
            message1510.setError(getString(0x7f080367));
            flag = false;
        }
_L4:
        if (Strings.isEmpty(recipientName.getText()))
        {
            recipientName.requestFocus();
            recipientName.setError(getString(0x7f080368));
            flag = false;
        }
        boolean flag1 = flag;
        if (isEmailDelivery)
        {
            flag1 = flag;
            if (!isEmailValid(recipientEmail.getText()))
            {
                recipientEmail.requestFocus();
                recipientEmail.setError(getString(0x7f080366));
                flag1 = false;
            }
        }
        if (Strings.isEmpty(from.getText()))
        {
            from.requestFocus();
            from.setError(getString(0x7f080188));
            flag1 = false;
        }
        currentFocusedView = getCurrentFocus();
        return flag1;
_L2:
        if (Strings.isEmpty(message.getText()))
        {
            message.requestFocus();
            message.setError(getString(0x7f080367));
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void configureSyncManagerAndLoader()
    {
        Object obj = new ArrayList();
        ((List) (obj)).add(new GiftingThemePreviewSyncManagerProcess(this, "PreviewGiftingTheme"));
        universalSyncManager.configurePaginatedSyncManager(null, ((List) (obj)), new UniversalUpdateEvent("PreviewGiftingTheme"));
        universalLoaderCallbacks = new UniversalLoaderCallbacks(null, this, "PreviewGiftingTheme", this);
        if (Strings.isEmpty(giftingRecord.themeId))
        {
            obj = "default";
        } else
        {
            obj = giftingRecord.themeId;
        }
        obj = new GiftingThemePreviewLoader(this, ((String) (obj)));
        universalLoaderCallbacks.setBackgroundDataProcessors(new BackgroundDataProcessor[] {
            obj
        });
        getLoaderManager().initLoader(0, null, universalLoaderCallbacks);
    }

    protected void emailPrintToggle(boolean flag)
    {
        byte byte0 = 8;
        isEmailDelivery = flag;
        Object obj;
        Logger logger1;
        int i;
        if (flag)
        {
            obj = "email";
        } else
        {
            obj = "print";
        }
        giftingRecord.deliveryMethod = ((String) (obj));
        obj = recipientEmail;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((EditText) (obj)).setVisibility(i);
        obj = sendOnLayoutFrame;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((LinearLayout) (obj)).setVisibility(i);
        obj = printLaterNotice;
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        ((TextView) (obj)).setVisibility(i);
        logger1 = logger;
        if (flag)
        {
            obj = "email_now_click";
        } else
        {
            obj = "print_later_click";
        }
        logger1.logClick("", ((String) (obj)), "send_as_gift", dealId);
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
    }

    protected void initActionBar(Bundle bundle)
    {
        initActionBar(bundle);
        if (shouldShowGiftingNewFlow)
        {
            setToolbarTitle(getString(0x7f08011e));
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        onActivityResult(i, j, intent);
        if (i == 10153 && j == -1)
        {
            setResult(j, intent);
            finish();
        }
    }

    public void onBackPressed()
    {
        setResult(0, (new Intent()).putExtra("giftingRecord", giftingRecord));
        onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        onCreate(bundle);
        int i;
        boolean flag;
        if (giftingAbTestHelper.shouldShowGiftNewFlow1510USCA() && isGiftableDeal)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        shouldShowGiftingNewFlow = flag;
        if (shouldShowGiftingNewFlow)
        {
            i = 0x7f0300fe;
        } else
        {
            i = 0x7f0300fd;
        }
        setContentView(i);
        endDate.setTime(getLastDayInNextMonth(nowDate.getTime()));
        bundle = giftingRecord.emailDeliveryTime;
        if (Strings.notEmpty(bundle))
        {
            try
            {
                selectedDate.setTime(iso8601DateFormat.parse(bundle));
                setDateText(selectedDate);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Ln.e(bundle);
            }
        }
        selectedDate.set(11, 0);
        selectedDate.set(12, 0);
        selectedDate.set(13, 0);
        selectedDate.set(14, 0);
        if (giftingRecord.deliveryMethod.equals("email") && !giftingRecord.isGoods)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isEmailDelivery = flag;
        bundle = printLaterButton;
        if (!isEmailDelivery)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.setChecked(flag);
        setLayoutsVisibility(giftingRecord.isGiftWrappable, giftingRecord.isGoods);
        if (Strings.notEmpty(giftingRecord.recipientName))
        {
            recipientName.setText(giftingRecord.recipientName);
        }
        if (Strings.notEmpty(giftingRecord.fromName))
        {
            from.setText(giftingRecord.fromName);
        } else
        if (loginService.isLoggedIn())
        {
            from.setText(loginService.getFullName());
        }
        if (Strings.notEmpty(giftingRecord.message))
        {
            if (shouldShowGiftingNewFlow)
            {
                message1510.setText(giftingRecord.message);
            } else
            {
                message.setText(giftingRecord.message);
            }
        }
        if (Strings.notEmpty(giftingRecord.recipientEmail))
        {
            recipientEmail.setText(giftingRecord.recipientEmail);
        }
        if (giftingRecord.isGiftWrappable)
        {
            flag = giftingRecord.isGiftWrapped;
            giftWrapToggle.setChecked(flag);
            bundle = giftWrapToggle;
            Resources resources;
            if (flag)
            {
                i = getResources().getColor(0x7f0e00bc);
            } else
            {
                i = getResources().getColor(0x7f0e00ce);
            }
            bundle.setBackgroundColor(i);
            bundle = giftWrapText;
            resources = getResources();
            if (flag)
            {
                i = 0x7f020077;
            } else
            {
                i = 0x7f020076;
            }
            bundle.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(i), null, null, null);
        }
        emailButton.setButtonDrawable(0x106000d);
        printLaterButton.setButtonDrawable(0x106000d);
        submitButton.setOnClickListener(new SubmitButtonOnClickListener());
        emailButton.setOnClickListener(new android.view.View.OnClickListener() {

            final Gifting this$0;

            public void onClick(View view)
            {
                emailPrintToggle(true);
            }

            
            {
                this$0 = Gifting.this;
                super();
            }
        });
        printLaterButton.setOnClickListener(new android.view.View.OnClickListener() {

            final Gifting this$0;

            public void onClick(View view)
            {
                emailPrintToggle(false);
            }

            
            {
                this$0 = Gifting.this;
                super();
            }
        });
        if (!shouldShowGiftingNewFlow) goto _L2; else goto _L1
_L1:
        if (Strings.isEmpty(giftingRecord.themeId))
        {
            giftingRecord.themeId = "default";
        }
        messageCount.setText(getString(0x7f0800ae, new Object[] {
            Integer.valueOf(220 - message1510.length())
        }));
        message1510.addTextChangedListener(new MessageCountTextWatcher());
        bundle = new ThemeSelectionOnCLickListener();
        if (!giftingAbTestHelper.isThemeSelectionRequired()) goto _L4; else goto _L3
_L3:
        themeSelectSection.setVisibility(8);
        submitButton.setText(getString(0x7f080360));
        submitButton.setOnClickListener(bundle);
_L6:
        return;
_L4:
        themeSelectSection.setOnClickListener(bundle);
        themeSelectSection.setVisibility(0);
        configureSyncManagerAndLoader();
        return;
_L2:
        cancelGiftButton.setOnClickListener(new android.view.View.OnClickListener() {

            final Gifting this$0;

            public void onClick(View view)
            {
                setResult(1);
                finish();
            }

            
            {
                this$0 = Gifting.this;
                super();
            }
        });
        setPrintLaterNotice();
        from.setOnFocusChangeListener(new SenderTextOnFocusChangeListener());
        if (giftingRecord.isGiftWrappable)
        {
            giftWrapText.setText(getString(0x7f080422, new Object[] {
                giftingRecord.giftWrapChargeAmount
            }));
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
        if (universallistloadresultdata.getListData().size() > 0)
        {
            universallistloadresultdata = (DerivedGiftTheme)universallistloadresultdata.getListData().get(0);
            previewThemeImage.setImageUrl(((DerivedGiftTheme) (universallistloadresultdata)).imageUrl);
        }
    }

    protected void onPause()
    {
        onPause();
        if (giftingAbTestHelper.isThemeSelectionOptional() && shouldShowGiftingNewFlow)
        {
            universalSyncManager.stopAutomaticSyncs();
        }
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        onRestoreInstanceState(bundle);
        selectedDate.setTimeInMillis(bundle.getLong("selected_date_key"));
        setDateText(selectedDate);
        giftingRecord.deliveryMethod = bundle.getString("delivery_method_key");
        boolean flag;
        if (giftingRecord.deliveryMethod.equals("email") && !giftingRecord.isGoods)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isEmailDelivery = flag;
        emailPrintToggle(isEmailDelivery);
    }

    protected void onResume()
    {
        onResume();
        if (giftingAbTestHelper.isThemeSelectionOptional() && shouldShowGiftingNewFlow)
        {
            universalSyncManager.startAutomaticSyncs(this, null);
        }
        loggingUtils.logPageView("", "edit_gift_info_page", null);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        onSaveInstanceState(bundle);
        bundle.putLong("selected_date_key", selectedDate.getTimeInMillis());
        bundle.putString("delivery_method_key", giftingRecord.deliveryMethod);
    }

    public void onToggleClicked(View view)
    {
        view = (ToggleButton)view;
        TextView textview;
        Resources resources;
        int i;
        if (view.isChecked())
        {
            i = getResources().getColor(0x7f0e00bc);
        } else
        {
            i = getResources().getColor(0x7f0e00ce);
        }
        view.setBackgroundColor(i);
        textview = giftWrapText;
        resources = getResources();
        if (view.isChecked())
        {
            i = 0x7f020077;
        } else
        {
            i = 0x7f020076;
        }
        textview.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(i), null, null, null);
    }

    protected void setPrintLaterNotice()
    {
        String s = GiftingUtil.getDomain(giftingRecord.dealUrl);
        TextView textview = printLaterNotice;
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            s = getString(0x7f0801f6);
        } else
        {
            if (s == null)
            {
                s = "";
            }
            s = getString(0x7f0801f7, new Object[] {
                s
            });
        }
        textview.setText(s);
    }

    public void showDatePickerDialog(View view)
    {
        (new DatePickerFragment()).show(getFragmentManager(), "datePicker");
    }










}
