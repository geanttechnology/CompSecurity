// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.google_api;

import android.content.Intent;
import com.commonsware.cwac.wakeful.WakefulIntentService;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import com.groupon.activity.IntentFactory;
import com.groupon.foundations.service.BaseIntentService;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.google_api:
//            ActivityDetectionRequester

public class ActivityRecognitionIntentService extends BaseIntentService
{

    private ActivityDetectionRequester activityDetectionRequester;
    private IntentFactory intentFactory;

    public ActivityRecognitionIntentService()
    {
        super(com/groupon/google_api/ActivityRecognitionIntentService.getCanonicalName());
    }

    private String getNameFromType(int i)
    {
        switch (i)
        {
        default:
            return "unknown";

        case 0: // '\0'
            return "in_vehicle";

        case 1: // '\001'
            return "on_bicycle";

        case 2: // '\002'
            return "on_foot";

        case 3: // '\003'
            return "still";

        case 4: // '\004'
            return "unknown";

        case 5: // '\005'
            return "tilting";
        }
    }

    protected void onHandleIntent(Intent intent)
    {
        if (ActivityRecognitionResult.hasResult(intent))
        {
            intent = ActivityRecognitionResult.extractResult(intent).getMostProbableActivity();
            int i = intent.getConfidence();
            Ln.d("Proximity_Notifications - ActivityRecognitionIntentService: Activity detected %s with confidence %d", new Object[] {
                getNameFromType(intent.getType()), Integer.valueOf(i)
            });
            Ln.d("Proximity_Notifications - ActivityRecognitionIntentService: Calling set geofence", new Object[0]);
            WakefulIntentService.sendWakefulWork(this, intentFactory.newProximityBasedNotificationServiceSetGeofenceIntent(intent.getType(), i));
            activityDetectionRequester.removeUpdates();
            Ln.d("Proximity_Notifications - ActivityRecognitionIntentService: Removed activity updates.", new Object[0]);
            return;
        } else
        {
            Ln.d("Proximity_Notifications - ActivityRecognitionIntentService: No Activity result detected by the OS.", new Object[0]);
            return;
        }
    }
}
