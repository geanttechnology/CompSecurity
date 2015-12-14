// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.framework.kindle.ftue.ContactInfoListener;
import com.amazon.gallery.framework.kindle.ftue.FTUEPrimeBenefitScreen;
import com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetricsHelper;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.senna.model.ContactInfo;
import com.amazon.gallery.framework.network.util.EndpointLoadedEvent;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class DesktopScreen extends FTUEPrimeBenefitScreen
    implements ContactInfoListener
{
    private class EmailClickListener
        implements android.view.View.OnClickListener
    {

        final DesktopScreen this$0;

        public void onClick(View view)
        {
            ((FTUEMetricsHelper)
// JavaClassFileOutputException: get_constant: invalid tag

        private EmailClickListener()
        {
            this$0 = DesktopScreen.this;
            super();
        }

    }

    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent EmailSent;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/ftue/DesktopScreen$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            EmailSent = new MetricsEvent("EmailSent", 0);
            $VALUES = (new MetricsEvent[] {
                EmailSent
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/thor/ftue/DesktopScreen.getName();
    private ContactInfo contactInfo;
    private Button desktopEmailButton;
    private Button desktopEmailEntryButton;
    private View desktopEmailEntryRow;
    private EditText desktopTextView;
    private final Runnable onSendNotificationFailure = new Runnable() ;
    private View skipLink;

    public DesktopScreen()
    {
    }

    private void contactInfoUpdated()
    {
        if (activity != null)
        {
            activity.runOnUiThread(new Runnable() {

                final DesktopScreen this$0;

                public void run()
                {
                    if (contactInfo == null && desktopTextView != null)
                    {
                        desktopTextView.setText("");
                    }
                    updateEmailEntryMode();
                }

            
            {
                this$0 = DesktopScreen.this;
                super();
            }
            });
        }
    }

    private void disableButtons()
    {
        desktopEmailButton.setClickable(false);
        desktopEmailEntryButton.setClickable(false);
        skipLink.setClickable(false);
    }

    private void enableButtons()
    {
        desktopEmailButton.setClickable(true);
        desktopEmailEntryButton.setClickable(true);
        skipLink.setClickable(true);
    }

    public static final boolean isValidEmail(CharSequence charsequence)
    {
        if (StringUtils.isEmpty(charsequence))
        {
            return false;
        } else
        {
            return Patterns.EMAIL_ADDRESS.matcher(charsequence).matches();
        }
    }

    private void resetButton()
    {
        spinnerDialog.hide();
        enableButtons();
    }

    private void updateEmailEntryMode()
    {
        boolean flag = false;
        if (!isResumed())
        {
            return;
        }
        Object obj;
        int i;
        byte byte0;
        if (contactInfo == null || StringUtils.isEmpty(contactInfo.getEmail()))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        obj = desktopEmailButton;
        if (i != 0)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        ((Button) (obj)).setVisibility(byte0);
        obj = desktopEmailEntryRow;
        if (i != 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }

    protected int getBackgroundResource()
    {
        return 0x7f0201dd;
    }

    public int getLayout()
    {
        return 0x7f030094;
    }

    public com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEvent getShowScreenMetric()
    {
        return com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEvent.PCScreenDisplayed;
    }

    public void onEndpointEvent(EndpointLoadedEvent endpointloadedevent)
    {
        onEndpointLoaded(endpointloadedevent.endpoint);
    }

    public void onResume()
    {
        super.onResume();
        desktopEmailEntryRow = layout.findViewById(0x7f0c0161);
        desktopEmailEntryButton = (Button)layout.findViewById(0x7f0c0163);
        desktopEmailButton = (Button)layout.findViewById(0x7f0c0164);
        skipLink = layout.findViewById(0x7f0c0165);
        desktopTextView = (EditText)layout.findViewById(0x7f0c0162);
        desktopTextView.addTextChangedListener(new TextWatcher() {

            final DesktopScreen this$0;

            public void afterTextChanged(Editable editable)
            {
                Button button = desktopEmailEntryButton;
                boolean flag;
                if (editable != null && editable.length() != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                button.setEnabled(flag);
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = DesktopScreen.this;
                super();
            }
        });
        EmailClickListener emailclicklistener = new EmailClickListener();
        desktopEmailButton.setOnClickListener(emailclicklistener);
        desktopEmailEntryButton.setOnClickListener(emailclicklistener);
        layout.findViewById(0x7f0c0165).setOnClickListener(new android.view.View.OnClickListener() );
        layout.findViewById(0x7f0c0167).setOnClickListener(new android.view.View.OnClickListener() );
        contactInfoUpdated();
        updateEmailEntryMode();
    }

    public void setContactInfo(ContactInfo contactinfo)
    {
        contactInfo = contactinfo;
        contactInfoUpdated();
    }































    // Unreferenced inner class com/amazon/gallery/thor/ftue/DesktopScreen$EmailClickListener$1

/* anonymous class */

    // Unreferenced inner class com/amazon/gallery/thor/ftue/DesktopScreen$EmailClickListener$1$1

/* anonymous class */
    class EmailClickListener._cls1._cls1
        implements Runnable
    {

        final EmailClickListener._cls1 this$2;

        public void run()
        {
            resetButton();
            desktopTextView.setText("");
            getString.setNotification(getString.getString(0x7f0e00b0, new Object[] {
                email
            }));
            getString.proceedToNext(_fld0, true);
        }

            
            {
                this$2 = EmailClickListener._cls1.this;
                super();
            }
    }

}
