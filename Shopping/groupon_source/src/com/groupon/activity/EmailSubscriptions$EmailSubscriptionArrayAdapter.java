// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.groupon.models.emailsubscription.EmailSubscription;
import com.groupon.view.EmailSubscriptionItemView;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            EmailSubscriptions

private class allSubscriptions extends ArrayAdapter
{

    private final List allSubscriptions;
    final EmailSubscriptions this$0;

    public int getCount()
    {
        return allSubscriptions.size();
    }

    public EmailSubscription getItem(int i)
    {
        return (EmailSubscription)allSubscriptions.get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view instanceof EmailSubscriptionItemView)
        {
            view = (EmailSubscriptionItemView)view;
        } else
        {
            view = new EmailSubscriptionItemView(getContext());
        }
        viewgroup = getItem(i);
        view.setClickable(false);
        view.setSubscription(viewgroup);
        return view;
    }

    public (List list)
    {
        this$0 = EmailSubscriptions.this;
        super(EmailSubscriptions.this, 0x7f0300d6, 0x7f100280, list);
        allSubscriptions = list;
    }
}
