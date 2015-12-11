// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.groupon.models.division.Division;
import com.groupon.models.emailsubscription.EmailSubscription;
import com.groupon.models.emailsubscription.EmailSubscriptionContainer;
import com.groupon.service.AttributionService;
import com.groupon.service.EmailSubscriptionsService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class EmailSubscriptionItemView extends LinearLayout
{
    private static class BooleanExceptionReturningFunction1
        implements ReturningFunction1
    {

        private final Function1 internalCallback;

        public Boolean execute(Exception exception)
        {
            internalCallback.execute(null);
            return Boolean.valueOf(true);
        }

        public volatile Object execute(Object obj)
            throws Exception
        {
            return execute((Exception)obj);
        }

        public BooleanExceptionReturningFunction1(Function1 function1)
        {
            internalCallback = function1;
        }
    }

    private class EmailSubscriptionFunction1
        implements Function1
    {

        private final Function1 callback;
        final EmailSubscriptionItemView this$0;

        public void execute(EmailSubscription emailsubscription)
        {
            setInProgress(false);
            if (callback != null)
            {
                callback.execute(emailsubscription);
            }
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((EmailSubscription)obj);
        }

        public EmailSubscriptionFunction1(Function1 function1)
        {
            this$0 = EmailSubscriptionItemView.this;
            super();
            callback = function1;
        }
    }


    private AttributionService attributionService;
    private CheckBox checkbox;
    private EmailSubscriptionsService emailSubscriptionsService;
    private boolean inProgress;
    private Logger logger;
    private ProgressBar progressBar;
    private TextView subName;
    private EmailSubscription subscription;

    public EmailSubscriptionItemView(Context context)
    {
        this(context, null);
    }

    public EmailSubscriptionItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflate(context, 0x7f0300d6, this);
        RoboGuice.getInjector(context).injectMembers(this);
        subName = (TextView)findViewById(0x7f100280);
        checkbox = (CheckBox)findViewById(0x7f100282);
        progressBar = (ProgressBar)findViewById(0x7f100283);
    }

    public Division getDivision()
    {
        return subscription.division;
    }

    protected void refresh()
    {
        boolean flag = false;
        Object obj = checkbox;
        int i;
        boolean flag1;
        if (subscription != null && Strings.notEmpty(subscription.id))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((CheckBox) (obj)).setChecked(flag1);
        obj = checkbox;
        if (inProgress)
        {
            i = 4;
        } else
        {
            i = 0;
        }
        ((CheckBox) (obj)).setVisibility(i);
        obj = progressBar;
        if (inProgress)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 4;
        }
        ((ProgressBar) (obj)).setVisibility(i);
        subName.setText(subscription.getDisplayString());
    }

    protected void setInProgress(boolean flag)
    {
        inProgress = flag;
        refresh();
    }

    public void setSubscription(EmailSubscription emailsubscription)
    {
        subscription = emailsubscription;
        inProgress = false;
        refresh();
    }

    public void toggleStateWithApiCall(final Function1 internalCallback)
    {
        if (inProgress)
        {
            return;
        }
        BooleanExceptionReturningFunction1 booleanexceptionreturningfunction1;
        boolean flag;
        if (!checkbox.isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setInProgress(true);
        internalCallback = new EmailSubscriptionFunction1(internalCallback);
        booleanexceptionreturningfunction1 = new BooleanExceptionReturningFunction1(internalCallback);
        if (!flag)
        {
            if (!emailSubscriptionsService.isDeleteSupported())
            {
                setInProgress(false);
                return;
            } else
            {
                emailSubscriptionsService.deleteEmailSubscription(subscription.id, new Function1() {

                    final EmailSubscriptionItemView this$0;
                    final Function1 val$internalCallback;

                    public volatile void execute(Object obj)
                        throws Exception
                    {
                        execute((Void)obj);
                    }

                    public void execute(Void void1)
                    {
                        subscription.id = null;
                        internalCallback.execute(null);
                    }

            
            {
                this$0 = EmailSubscriptionItemView.this;
                internalCallback = function1;
                super();
            }
                }, booleanexceptionreturningfunction1, null);
                return;
            }
        } else
        {
            emailSubscriptionsService.addEmailSubscription(getDivision(), new Function1() {

                final EmailSubscriptionItemView this$0;
                final Function1 val$internalCallback;

                public void execute(EmailSubscriptionContainer emailsubscriptioncontainer)
                {
                    emailsubscriptioncontainer = emailsubscriptioncontainer.emailSubscription;
                    setSubscription(emailsubscriptioncontainer);
                    internalCallback.execute(emailsubscriptioncontainer);
                    logger.logSubscriptionSignUp("", "email", getDivision().id, attributionService.getAttributionCid(), attributionService.getAttributionId(), attributionService.getAttributionType(), attributionService.getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue(), attributionService.getAttributionDownloadId(), attributionService.getAttributionDownloadCid(), Logger.NULL_NST_FIELD);
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((EmailSubscriptionContainer)obj);
                }

            
            {
                this$0 = EmailSubscriptionItemView.this;
                internalCallback = function1;
                super();
            }
            }, booleanexceptionreturningfunction1, null);
            return;
        }
    }



}
