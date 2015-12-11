// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import co.vine.android.client.AppController;
import com.edisonwang.android.slog.SLog;
import com.google.android.gms.gcm.GoogleCloudMessaging;

// Referenced classes of package co.vine.android.service:
//            GCMRegistrationService, GCMNotificationService

private class mSessionKey extends AsyncTask
{

    private String mRegId;
    private String mSessionKey;
    private long mUserId;
    final GCMRegistrationService this$0;

    private Context getContext()
    {
        return GCMRegistrationService.this;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (GCMRegistrationService.access$100(GCMRegistrationService.this) == null)
        {
            GCMRegistrationService.access$102(GCMRegistrationService.this, GoogleCloudMessaging.getInstance(getContext()));
        }
        SLog.dWithTag("GCMRegService", "Unregistering...");
        GCMRegistrationService.access$400(GCMRegistrationService.this).clearGcmRegId(mRegId, mUserId, mSessionKey);
        GCMRegistrationService.getGCMPreferences(getContext()).edit().getContext().getContext();
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        startService(GCMNotificationService.getClearNotificationIntent(getContext(), 1));
        startService(GCMNotificationService.getClearNotificationIntent(getContext(), 2));
        GCMRegistrationService.access$500(GCMRegistrationService.this);
    }

    public (String s, long l, String s1)
    {
        this$0 = GCMRegistrationService.this;
        super();
        mRegId = s;
        mUserId = l;
        mSessionKey = s1;
    }
}
