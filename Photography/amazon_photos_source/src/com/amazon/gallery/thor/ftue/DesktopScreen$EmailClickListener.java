// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetricsHelper;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.senna.model.ContactInfo;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            DesktopScreen

private class <init>
    implements android.view.ilClickListener
{

    final DesktopScreen this$0;

    public void onClick(final View email)
    {
        ((FTUEMetricsHelper)DesktopScreen.access$1000(DesktopScreen.this).getProfiler()).logClickEvent(com.amazon.gallery.framework.kindle.metrics.customer.KTOP_CLICK, DesktopScreen.access$1100(DesktopScreen.this));
        DesktopScreen.access$1200(DesktopScreen.this);
        if (DesktopScreen.access$1400(DesktopScreen.this).promptIfOffline(DesktopScreen.access$1300(DesktopScreen.this)))
        {
            break MISSING_BLOCK_LABEL_253;
        }
        DesktopScreen.access$1500(DesktopScreen.this).setMessage(getString(0x7f0e00b1));
        DesktopScreen.access$1600(DesktopScreen.this).show();
        ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(email.getWindowToken(), 0);
        if (DesktopScreen.access$700(DesktopScreen.this) == null || !StringUtils.isNotEmpty(DesktopScreen.access$700(DesktopScreen.this).getEmail())) goto _L2; else goto _L1
_L1:
        email = DesktopScreen.access$700(DesktopScreen.this).getEmail();
_L4:
        com.amazon.gallery.framework.network.http.rest.tion.NotificationType notificationtype = DesktopScreen.access$2000(DesktopScreen.this).sendEmailNotification(com.amazon.gallery.framework.network.http.senna.operations.ationType.DESKTOP_INSTALL_HELP, email);
        NetworkExecutor.getInstance().executeForeground(notificationtype, new com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler() {

            final DesktopScreen.EmailClickListener this$1;
            final CharSequence val$email;

            public void onFailure(TerminalException terminalexception)
            {
                DesktopScreen.access$2700(this$0).post(DesktopScreen.access$2600(this$0));
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((Void)obj);
            }

            public void onSuccess(Void void1)
            {
                if (DesktopScreen.access$700(this$0) != null)
                {
                    ((AmazonInsightsHelper)DesktopScreen.access$2100(this$0).getApplicationBean(Keys.AMAZON_INSIGHTS_HELPER)).recordEvent(DesktopScreen.MetricsEvent.EmailSent);
                    DesktopScreen.access$2500(this$0).post(new Runnable() {

                        final _cls1 this$2;

                        public void run()
                        {
                            DesktopScreen.access$1900(this$0);
                            DesktopScreen.access$800(this$0).setText("");
                            DesktopScreen.access$2300(this$0).setNotification(DesktopScreen.access$2200(this$0).getString(0x7f0e00b0, new Object[] {
                                email
                            }));
                            DesktopScreen.access$2400(this$0).proceedToNext(this$0, true);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                }
            }

            
            {
                this$1 = DesktopScreen.EmailClickListener.this;
                email = charsequence;
                super();
            }
        });
        return;
_L2:
        android.text.Editable editable = DesktopScreen.access$800(DesktopScreen.this).getText();
        email = editable;
        if (DesktopScreen.isValidEmail(editable)) goto _L4; else goto _L3
_L3:
        DesktopScreen.access$800(DesktopScreen.this).setText("");
        DesktopScreen.access$1800(DesktopScreen.this).createConfirmDialogWithOKButton(DesktopScreen.access$1700(DesktopScreen.this), 0x7f0e00b2).show();
        DesktopScreen.access$1900(DesktopScreen.this);
        return;
        email;
        DesktopScreen.access$2600(DesktopScreen.this).run();
    }

    private _cls1.val.email()
    {
        this$0 = DesktopScreen.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
