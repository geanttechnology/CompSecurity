// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.content.Context;
import android.os.AsyncTask;
import com.ebay.mobile.notifications.NotificationUtil;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.Arrays;

// Referenced classes of package com.ebay.mobile.following:
//            EditFollowingFragment

private static final class observer extends AsyncTask
{
    public static interface Observer
    {

        public abstract void onSearchesSaved(boolean flag);
    }


    private final Context context;
    private final EbayContext ebayContext;
    private final Observer observer;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        NotificationUtil.updateNotificationSubscriptions(context, ebayContext, Arrays.asList(as));
        return null;
    }

    protected volatile void onCancelled(Object obj)
    {
        onCancelled((Void)obj);
    }

    protected void onCancelled(Void void1)
    {
        super.onCancelled(void1);
        if (observer != null)
        {
            observer.onSearchesSaved(false);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        if (observer != null)
        {
            observer.onSearchesSaved(true);
        }
    }

    public Observer(Context context1, EbayContext ebaycontext, Observer observer1)
    {
        context = context1;
        ebayContext = ebaycontext;
        observer = observer1;
    }
}
