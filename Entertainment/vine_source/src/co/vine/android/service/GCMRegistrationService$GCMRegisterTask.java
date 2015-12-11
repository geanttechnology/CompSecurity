// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.content.Context;
import android.os.AsyncTask;
import co.vine.android.client.AppController;
import com.edisonwang.android.slog.SLog;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

// Referenced classes of package co.vine.android.service:
//            GCMRegistrationService

private class mUserId extends AsyncTask
{

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
        try
        {
            SLog.dWithTag("GCMRegService", (new StringBuilder()).append("Registering with senderId=").append(GCMRegistrationService.access$200(GCMRegistrationService.this)).toString());
            avoid = GCMRegistrationService.access$100(GCMRegistrationService.this).register(new String[] {
                GCMRegistrationService.access$200(GCMRegistrationService.this)
            });
            SLog.d("GCM: Registration complete with regId={}", avoid);
            GCMRegistrationService.access$300(GCMRegistrationService.this, avoid);
            GCMRegistrationService.access$400(GCMRegistrationService.this).sendGcmRegId(avoid, mUserId);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            SLog.dWithTag("GCMRegService", "Failed to register with GCM service.");
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        GCMRegistrationService.access$500(GCMRegistrationService.this);
    }

    public (long l)
    {
        this$0 = GCMRegistrationService.this;
        super();
        mUserId = l;
    }
}
