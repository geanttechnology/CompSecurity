// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.trading.EbayTradingApiHelper;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.util.FwLog;

// Referenced classes of package com.ebay.mobile.notifications:
//            NotificationUtil, NotificationPreferenceManager

private static final class <init> extends AsyncTask
{

    protected transient Boolean doInBackground(Object aobj[])
    {
        Context context;
        Authentication authentication;
        context = (Context)aobj[0];
        aobj = (EbayContext)aobj[1];
        authentication = MyApp.getPrefs().getAuthentication();
        if (authentication == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        NotificationPreferenceManager notificationpreferencemanager = new NotificationPreferenceManager(context);
        EbayTradingApiHelper.setClientAlertsPreferences(((EbayContext) (aobj)), EbayApiUtil.getTradingApi(context, authentication), NotificationUtil.buildClientAlertNames(notificationpreferencemanager, authentication.user), NotificationUtil.getWatchedTimeLeft(notificationpreferencemanager, authentication.user), NotificationUtil.getBidTimeLeft(notificationpreferencemanager, authentication.user));
        if (NotificationUtil.logTag.ferences)
        {
            FwLog.println(NotificationUtil.logTag, "setClientAlertPreferences: Client alerts preferences set");
        }
        return Boolean.valueOf(true);
        aobj;
        Log.w("NotificationUtil", "SetClientAlertAsyncTask: Exception setting client alerts", ((Throwable) (aobj)));
        return Boolean.valueOf(false);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground(aobj);
    }

    protected void onPostExecute(Boolean boolean1)
    {
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
