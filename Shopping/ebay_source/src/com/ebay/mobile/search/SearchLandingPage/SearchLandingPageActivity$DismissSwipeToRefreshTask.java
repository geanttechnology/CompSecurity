// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.SearchLandingPage;

import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.ebay.mobile.search.SearchLandingPage:
//            SearchLandingPageActivity

private static class swipeToRefreshLatch extends AsyncTask
{

    private WeakReference activityRef;
    protected CountDownLatch swipeToRefreshLatch;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (!isCancelled())
        {
            try
            {
                swipeToRefreshLatch.await(20L, TimeUnit.SECONDS);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[]) { }
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        void1 = (SearchLandingPageActivity)activityRef.get();
        if (void1 != null && !void1.isFinishing())
        {
            ((SearchLandingPageActivity) (void1)).refreshLayout.setRefreshing(false);
            void1.dismissSwipeToRefreshTask = null;
        }
    }

    (SearchLandingPageActivity searchlandingpageactivity, int i)
    {
        activityRef = new WeakReference(searchlandingpageactivity);
        swipeToRefreshLatch = new CountDownLatch(i);
    }
}
