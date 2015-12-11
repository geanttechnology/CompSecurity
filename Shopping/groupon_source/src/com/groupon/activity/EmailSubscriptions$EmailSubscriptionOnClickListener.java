// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.AdapterView;
import com.groupon.models.emailsubscription.EmailSubscription;
import com.groupon.util.Function1;
import com.groupon.view.EmailSubscriptionItemView;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            EmailSubscriptions

private class <init>
    implements android.widget.tener
{

    final EmailSubscriptions this$0;

    public void onItemClick(AdapterView adapterview, View view, final int position, long l)
    {
        if (view instanceof EmailSubscriptionItemView)
        {
            ((EmailSubscriptionItemView)view).toggleStateWithApiCall(new Function1() {

                final EmailSubscriptions.EmailSubscriptionOnClickListener this$1;
                final int val$position;

                public void execute(EmailSubscription emailsubscription)
                {
                    if (emailsubscription != null)
                    {
                        EmailSubscriptions.access$100(this$0).set(position, emailsubscription);
                    }
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((EmailSubscription)obj);
                }

            
            {
                this$1 = EmailSubscriptions.EmailSubscriptionOnClickListener.this;
                position = i;
                super();
            }
            });
        }
    }

    private _cls1.val.position()
    {
        this$0 = EmailSubscriptions.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
