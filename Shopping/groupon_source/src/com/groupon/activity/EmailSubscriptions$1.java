// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import com.groupon.models.emailsubscription.EmailSubscription;
import com.groupon.models.emailsubscription.EmailSubscriptionsContainer;
import com.groupon.util.Function1;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            EmailSubscriptions

class val.userSubscriptions
    implements Function1
{

    final EmailSubscriptions this$0;
    final List val$userSubscriptions;

    public void execute(EmailSubscriptionsContainer emailsubscriptionscontainer)
    {
        val$userSubscriptions.clear();
        val$userSubscriptions.addAll(emailsubscriptionscontainer.emailSubscriptions);
        EmailSubscriptions.access$200(EmailSubscriptions.this, EmailSubscriptions.access$100(EmailSubscriptions.this));
        Ln.d("SUBSCRIPTIONS: %s", new Object[] {
            val$userSubscriptions
        });
        emailsubscriptionscontainer = val$userSubscriptions.iterator();
label0:
        do
        {
            if (!emailsubscriptionscontainer.hasNext())
            {
                break;
            }
            EmailSubscription emailsubscription = (EmailSubscription)emailsubscriptionscontainer.next();
            Iterator iterator = EmailSubscriptions.access$100(EmailSubscriptions.this).iterator();
            EmailSubscription emailsubscription1;
            do
            {
                if (!iterator.hasNext())
                {
                    continue label0;
                }
                emailsubscription1 = (EmailSubscription)iterator.next();
            } while (!emailsubscription1.equals(emailsubscription));
            Ln.d("SUBSCRIPTIONS: %s, %s", new Object[] {
                emailsubscription.id, emailsubscription.emailAddress
            });
            emailsubscription1.id = emailsubscription.id;
            emailsubscription1.emailAddress = emailsubscription.emailAddress;
            swipeLayout.setRefreshing(false);
        } while (true);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((EmailSubscriptionsContainer)obj);
    }

    SubscriptionsContainer()
    {
        this$0 = final_emailsubscriptions;
        val$userSubscriptions = List.this;
        super();
    }
}
