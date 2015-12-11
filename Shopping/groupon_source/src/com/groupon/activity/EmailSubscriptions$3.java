// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.division.Division;
import com.groupon.models.emailsubscription.EmailSubscription;
import com.groupon.util.DeviceInfoUtil;
import java.text.Collator;
import java.util.Comparator;

// Referenced classes of package com.groupon.activity:
//            EmailSubscriptions

class this._cls0
    implements Comparator
{

    final EmailSubscriptions this$0;

    public int compare(EmailSubscription emailsubscription, EmailSubscription emailsubscription1)
    {
        return Collator.getInstance(EmailSubscriptions.access$500(EmailSubscriptions.this).getDeviceLocale()).compare(emailsubscription.division.name, emailsubscription1.division.name);
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((EmailSubscription)obj, (EmailSubscription)obj1);
    }

    Subscription()
    {
        this$0 = EmailSubscriptions.this;
        super();
    }
}
