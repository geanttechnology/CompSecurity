// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.os.AsyncTask;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.notifications.NotificationUtil;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragmentActivity

private static class userId extends AsyncTask
{

    private final BaseActivity baseActivity;
    private NotificationPreferenceManager notificationPrefs;
    private String userId;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        NotificationUtil.updateNotificationSubscriptions(baseActivity, baseActivity.getEbayContext(), notificationPrefs.getNotifyEnabledSavedSearchIdList(userId));
        return null;
    }

    public (BaseActivity baseactivity, NotificationPreferenceManager notificationpreferencemanager, String s)
    {
        baseActivity = baseactivity;
        notificationPrefs = notificationpreferencemanager;
        userId = s;
    }
}
