// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.google_api;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionApi;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.google_api:
//            ActivityRecognitionIntentService

public class ActivityDetectionRequester
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
{

    public static final int DETECTION_INTERVAL_MILLISECONDS = 1000;
    public static final int DETECTION_INTERVAL_SECONDS = 1;
    public static final int MILLISECONDS_PER_SECOND = 1000;
    private GoogleApiClient activityRecognitionClient;
    private PendingIntent activityRecognitionPendingIntent;
    private Context context;
    private boolean isRemoveRequest;

    public ActivityDetectionRequester()
    {
        isRemoveRequest = false;
        activityRecognitionPendingIntent = null;
        activityRecognitionClient = null;
    }

    private void continueRemoveUpdates()
    {
        activityRecognitionPendingIntent = createRequestPendingIntent();
        ActivityRecognition.ActivityRecognitionApi.removeActivityUpdates(getActivityRecognitionClient(), activityRecognitionPendingIntent).setResultCallback(new ResultCallback() {

            final ActivityDetectionRequester this$0;

            public volatile void onResult(Result result)
            {
                onResult((Status)result);
            }

            public void onResult(Status status)
            {
                if (status.isSuccess())
                {
                    Ln.d("Proximity_Notifications - ActivityDetectionRequester: Removed activity updates successfully.", new Object[0]);
                    return;
                } else
                {
                    Ln.d("Proximity_Notifications - ActivityDetectionRequester: Removed activity updates unsuccessfully.", new Object[0]);
                    return;
                }
            }

            
            {
                this$0 = ActivityDetectionRequester.this;
                super();
            }
        });
        activityRecognitionPendingIntent.cancel();
        requestDisconnection();
    }

    private void continueRequestActivityUpdates()
    {
        activityRecognitionPendingIntent = createRequestPendingIntent();
        ActivityRecognition.ActivityRecognitionApi.requestActivityUpdates(getActivityRecognitionClient(), 1000L, activityRecognitionPendingIntent).setResultCallback(new ResultCallback() {

            final ActivityDetectionRequester this$0;

            public volatile void onResult(Result result)
            {
                onResult((Status)result);
            }

            public void onResult(Status status)
            {
                if (status.isSuccess())
                {
                    Ln.d("Proximity_Notifications - ActivityDetectionRequester: Starting activity listening services successfully ", new Object[0]);
                    return;
                } else
                {
                    Ln.d("Proximity_Notifications - ActivityDetectionRequester: Starting activity listening services was unsuccessful", new Object[0]);
                    return;
                }
            }

            
            {
                this$0 = ActivityDetectionRequester.this;
                super();
            }
        });
        requestDisconnection();
    }

    private PendingIntent createRequestPendingIntent()
    {
        if (getRequestPendingIntent() != null)
        {
            return activityRecognitionPendingIntent;
        } else
        {
            Object obj = new Intent(context, com/groupon/google_api/ActivityRecognitionIntentService);
            obj = PendingIntent.getService(context, 0, ((Intent) (obj)), 0x8000000);
            setRequestPendingIntent(((PendingIntent) (obj)));
            return ((PendingIntent) (obj));
        }
    }

    private GoogleApiClient getActivityRecognitionClient()
    {
        if (activityRecognitionClient == null)
        {
            activityRecognitionClient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).addApi(ActivityRecognition.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        }
        return activityRecognitionClient;
    }

    private void requestConnection()
    {
        getActivityRecognitionClient().connect();
        Ln.d("Proximity_Notifications - ActivityDetectionRequester: Location services connection called", new Object[0]);
    }

    private void requestDisconnection()
    {
        getActivityRecognitionClient().disconnect();
        Ln.d("Proximity_Notifications - ActivityDetectionRequester: Location services disconnected called", new Object[0]);
    }

    public PendingIntent getRequestPendingIntent()
    {
        return activityRecognitionPendingIntent;
    }

    public void onConnected(Bundle bundle)
    {
        Ln.d("Proximity_Notifications - ActivityDetectionRequester: Location services Connected", new Object[0]);
        if (!isRemoveRequest)
        {
            continueRequestActivityUpdates();
            return;
        } else
        {
            continueRemoveUpdates();
            return;
        }
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        Ln.d("Proximity_Notifications - ActivityDetectionRequester: Connection failure.", new Object[0]);
    }

    public void onConnectionSuspended(int i)
    {
        requestDisconnection();
        Ln.d("Proximity_Notifications - ActivityDetectionRequester: Location services disconnected (connection suspended)", new Object[0]);
    }

    public void onDisconnected()
    {
        Ln.d("Proximity_Notifications - ActivityDetectionRequester: Location services Disconnected", new Object[0]);
        activityRecognitionClient = null;
    }

    public void removeUpdates()
    {
        isRemoveRequest = true;
        requestConnection();
    }

    public void requestUpdates()
    {
        Ln.d("Proximity_Notifications - ActivityDetectionRequester: Request connection.", new Object[0]);
        isRemoveRequest = false;
        requestConnection();
    }

    public void setActivityRecognitionClient(GoogleApiClient googleapiclient)
    {
        activityRecognitionClient = googleapiclient;
    }

    public void setRequestPendingIntent(PendingIntent pendingintent)
    {
        activityRecognitionPendingIntent = pendingintent;
    }
}
