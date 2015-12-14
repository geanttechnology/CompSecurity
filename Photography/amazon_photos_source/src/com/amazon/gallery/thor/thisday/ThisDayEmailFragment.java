// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.actions.PersistentDialogFragment;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.app.activity.ThisDayActivity;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;

public class ThisDayEmailFragment extends PersistentDialogFragment
{

    private static final String TAG = com/amazon/gallery/thor/thisday/ThisDayEmailFragment.getName();
    private String emailAddress;
    private NetworkExecutor networkExecutor;
    private RestClient restClient;
    private Handler uiThreadHandler;

    public ThisDayEmailFragment()
    {
    }

    private void init(BeanAwareActivity beanawareactivity)
    {
        restClient = (RestClient)beanawareactivity.getApplicationBean(Keys.REST_CLIENT);
        networkExecutor = NetworkExecutor.getInstance();
        uiThreadHandler = new Handler();
    }

    public static ThisDayEmailFragment newInstance(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("email_address", s);
        s = new ThisDayEmailFragment();
        s.setArguments(bundle);
        return s;
    }

    private void onEmailDeliveryFailure()
    {
        ThisDayActivity thisdayactivity = (ThisDayActivity)getActivity();
        if (thisdayactivity != null)
        {
            thisdayactivity.onEmailOperationCompleted(emailAddress, false);
        }
    }

    private void onEmailSentSuccessfully()
    {
        ThisDayActivity thisdayactivity = (ThisDayActivity)getActivity();
        if (thisdayactivity != null)
        {
            thisdayactivity.onEmailOperationCompleted(emailAddress, true);
        }
    }

    private void sendEmail()
    {
        try
        {
            com.amazon.gallery.framework.network.http.rest.RestClient.Operation operation = restClient.sendEmailNotification(com.amazon.gallery.framework.network.http.senna.operations.SendNotificationOperation.NotificationType.DESKTOP_INSTALL_HELP, emailAddress);
            networkExecutor.executeForeground(operation, new com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler() {

                final ThisDayEmailFragment this$0;

                public void onFailure(TerminalException terminalexception)
                {
                    uiThreadHandler.post(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            onEmailDeliveryFailure();
                            dismiss();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }

                public volatile void onSuccess(Object obj)
                {
                    onSuccess((Void)obj);
                }

                public void onSuccess(Void void1)
                {
                    uiThreadHandler.post(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            onEmailSentSuccessfully();
                            dismiss();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }

            
            {
                this$0 = ThisDayEmailFragment.this;
                super();
            }
            });
            return;
        }
        catch (InvalidParameterException invalidparameterexception)
        {
            GLogger.ex(TAG, "Failed to send email", invalidparameterexception);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getArguments() != null)
        {
            emailAddress = getArguments().getString("email_address");
        }
        init((BeanAwareActivity)getActivity());
        sendEmail();
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = (new com.amazon.gallery.thor.widget.AppCompatProgressDialog.Builder(getActivity())).setStyle(com.amazon.gallery.thor.widget.AppCompatProgressDialog.ProgressStyle.SPINNER).setCancellable(false).build();
        bundle.setMessage(getString(0x7f0e00b1));
        return bundle;
    }




}
