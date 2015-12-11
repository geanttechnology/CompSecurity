// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import android.util.Log;
import android.widget.BaseAdapter;
import com.amazon.mShop.control.ObjectSubscriber;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop:
//            AmazonActivity

public abstract class ObjectSubscriberAdapter extends BaseAdapter
    implements ObjectSubscriber
{

    private final AmazonActivity amazonActivity;

    public ObjectSubscriberAdapter(AmazonActivity amazonactivity)
    {
        amazonActivity = amazonactivity;
    }

    public AmazonActivity getAmazonActivity()
    {
        return amazonActivity;
    }

    public Context getContext()
    {
        return amazonActivity;
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public void onAvailableCountReceived(int i)
    {
    }

    public void onCancelled()
    {
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        Log.e("Amazon.ObjectSubscriberAdapter", "onError", exception);
    }

    public void onObjectReceived(Object obj, int i)
    {
        notifyDataSetChanged();
    }

    public void onObjectsReceived()
    {
        notifyDataSetChanged();
    }

    public void onPageComplete()
    {
    }
}
