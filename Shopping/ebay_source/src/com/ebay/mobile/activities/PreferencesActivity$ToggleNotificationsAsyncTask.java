// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.MenuItem;
import com.ebay.mobile.notifications.NotificationUtil;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.activities:
//            PreferencesActivity

final class item extends AsyncTask
{

    private Boolean enabling;
    private MenuItem item;
    final PreferencesActivity this$0;

    protected transient ResultStatus doInBackground(Void avoid[])
    {
        return NotificationUtil.updateNotificationSubscriptions(PreferencesActivity.this, getEbayContext(), notificationType);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(ResultStatus resultstatus)
    {
        dialog.dismiss();
        onNotificationsUpdateComplete(resultstatus, enabling, item);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    protected void onPreExecute()
    {
        int i;
        if (enabling != null)
        {
            if (enabling.booleanValue())
            {
                i = 0x7f0703b7;
            } else
            {
                i = 0x7f070293;
            }
        } else
        {
            i = 0x7f070b95;
        }
        dialog = ProgressDialog.show(PreferencesActivity.this, null, getString(i));
    }

    public Q(Boolean boolean1)
    {
        this$0 = PreferencesActivity.this;
        super();
        enabling = null;
        item = null;
        enabling = boolean1;
    }

    public enabling(Boolean boolean1, MenuItem menuitem)
    {
        this(boolean1);
        item = menuitem;
    }
}
