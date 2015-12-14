// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.framework.kindle.ftue.ContactInfoListener;
import com.amazon.gallery.framework.kindle.ftue.FTUEPrimeBenefitScreen;
import com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetricsHelper;
import com.amazon.gallery.framework.metrics.clickstream.ClickstreamEventHelper;
import com.amazon.gallery.framework.metrics.clickstream.HitType;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.senna.model.ContactInfo;
import com.amazon.gallery.framework.network.util.EndpointLoadedEvent;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;
import org.apache.commons.lang3.StringUtils;

public class MobileScreen extends FTUEPrimeBenefitScreen
    implements ContactInfoListener
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent SmsSent;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/ftue/MobileScreen$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            SmsSent = new MetricsEvent("SmsSent", 0);
            $VALUES = (new MetricsEvent[] {
                SmsSent
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private ContactInfo contactInfo;
    private String emailSuccessNotification;
    private View mobileEmailButton;
    private Button mobileSmsButton;
    private View mobileSmsEntryRow;
    private TextView mobileTextView;
    private final Runnable onSendNotificationFailure = new Runnable() ;
    private final Runnable onSendNotificationSuccess = new Runnable() {

        final MobileScreen this$0;

        public void run()
        {
            resetButton();
            InputMethodManager inputmethodmanager = (InputMethodManager)
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = MobileScreen.this;
                super();
            }
    };
    private boolean sentToSMS;
    private String smsSuccessMessage;

    public MobileScreen()
    {
        emailSuccessNotification = "";
        sentToSMS = true;
    }

    private void resetButton()
    {
        spinnerDialog.hide();
        mobileTextView.setEnabled(true);
    }

    private void sendMessage(final com.amazon.gallery.framework.network.http.senna.operations.SendNotificationOperation.NotificationType notificationType)
    {
        ((FTUEMetricsHelper)activity.getProfiler()).logClickEvent(com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetricsHelper.ClickSource.MOBILE_CLICK, startTime);
        try
        {
            if (!networkConnectivity.promptIfOffline(activity))
            {
                mobileTextView.setEnabled(false);
                spinnerDialog.show();
                Object obj = mobileTextView.getText();
                obj = restClient.sendSmsNotification(notificationType, ((CharSequence) (obj)));
                NetworkExecutor.getInstance().executeForeground(((com.amazon.gallery.framework.network.NetworkExecutor.NetworkOperation) (obj)), new com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler() );
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final com.amazon.gallery.framework.network.http.senna.operations.SendNotificationOperation.NotificationType notificationType)
        {
            onSendNotificationFailure.run();
        }
    }

    private void updateEmailMode()
    {
        byte byte1 = 8;
        if (contactInfo != null && isResumed())
        {
            View view;
            byte byte0;
            int i;
            if (!contactInfo.isSmsAllowed())
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            view = mobileEmailButton;
            if (byte0 != 0)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
            view = mobileSmsEntryRow;
            if (byte0 != 0)
            {
                byte0 = byte1;
            } else
            {
                byte0 = 0;
            }
            view.setVisibility(byte0);
            if (mobileTextView != null && StringUtils.isEmpty(mobileTextView.getText()))
            {
                mobileTextView.setText(contactInfo.getTextPhoneNumber());
                return;
            }
        }
    }

    private void updateSendButtonVisibility()
    {
        Button button = mobileSmsButton;
        boolean flag;
        if (mobileTextView != null && mobileTextView.getText().length() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        button.setEnabled(flag);
    }

    protected int getBackgroundResource()
    {
        return 0x7f0201ce;
    }

    public int getLayout()
    {
        return 0x7f030096;
    }

    public com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEvent getShowScreenMetric()
    {
        return com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEvent.MobileScreenDisplayed;
    }

    void hideSoftkeyBar(View view)
    {
        this;
        JVM INSTR monitorenter ;
        InputMethodManager inputmethodmanager = (InputMethodManager)activity.getSystemService("input_method");
        if (inputmethodmanager == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        inputmethodmanager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        this;
        JVM INSTR monitorexit ;
        return;
        view;
        throw view;
    }

    public void onEndpointEvent(EndpointLoadedEvent endpointloadedevent)
    {
        onEndpointLoaded(endpointloadedevent.endpoint);
    }

    public void onResume()
    {
        onResume();
        mobileSmsEntryRow = layout.findViewById(0x7f0c016b);
        mobileEmailButton = layout.findViewById(0x7f0c016d);
        mobileEmailButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MobileScreen this$0;

            public void onClick(View view)
            {
                sendMessage(com.amazon.gallery.framework.network.http.senna.operations.SendNotificationOperation.NotificationType.MOBILE_INSTALL_HELP_EMAIL);
            }

            
            {
                this$0 = MobileScreen.this;
                super();
            }
        });
        smsSuccessMessage = activity.getString(0x7f0e00cc);
        emailSuccessNotification = activity.getString(0x7f0e00b0, new Object[] {
            ""
        });
        mobileTextView = (TextView)layout.findViewById(0x7f0c016c);
        mobileSmsButton = (Button)layout.findViewById(0x7f0c0164);
        ((EditText)layout.findViewById(0x7f0c016c)).addTextChangedListener(new MobilePhoneNumberFormattingTextWatcher());
        mobileSmsButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MobileScreen this$0;

            public void onClick(View view)
            {
                if (mobileTextView != null && mobileTextView.getText().length() > 0)
                {
                    sendMessage(com.amazon.gallery.framework.network.http.senna.operations.SendNotificationOperation.NotificationType.MOBILE_INSTALL_HELP);
                }
            }

            
            {
                this$0 = MobileScreen.this;
                super();
            }
        });
        layout.findViewById(0x7f0c0165).setOnClickListener(new android.view.View.OnClickListener() );
        layout.findViewById(0x7f0c0167).setOnClickListener(new android.view.View.OnClickListener() );
        mobileTextView.setEnabled(true);
        updateSendButtonVisibility();
        updateEmailMode();
    }

    public void setContactInfo(ContactInfo contactinfo)
    {
        contactInfo = contactinfo;
        if (contactinfo == null)
        {
            if (activity != null)
            {
                activity.runOnUiThread(new Runnable() {

                    final MobileScreen this$0;

                    public void run()
                    {
                        if (isResumed())
                        {
                            mobileTextView.setText("");
                        }
                    }

            
            {
                this$0 = MobileScreen.this;
                super();
            }
                });
            }
        } else
        if (activity != null)
        {
            activity.runOnUiThread(new Runnable() {

                final MobileScreen this$0;

                public void run()
                {
                    updateEmailMode();
                }

            
            {
                this$0 = MobileScreen.this;
                super();
            }
            });
            if (contactinfo.getEmail() != null)
            {
                emailSuccessNotification = activity.getString(0x7f0e00b0, new Object[] {
                    contactinfo.getEmail()
                });
                return;
            }
        }
    }





/*
    static boolean access$1102(MobileScreen mobilescreen, boolean flag)
    {
        mobilescreen.sentToSMS = flag;
        return flag;
    }

*/
































    // Unreferenced inner class com/amazon/gallery/thor/ftue/MobileScreen$9$1

/* anonymous class */
    class _cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final _cls9 this$1;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            sendMessage(com.amazon.gallery.framework.network.http.senna.operations.SendNotificationOperation.NotificationType.MOBILE_INSTALL_HELP_EMAIL);
        }

            
            {
                this$1 = _cls9.this;
                super();
            }
    }

}
