// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.ahc;
import android.support.v7.ahj;
import android.util.Log;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.f;
import com.google.android.gms.location.h;
import java.util.List;

// Referenced classes of package com.kahuna.sdk:
//            m, t, w

public class KahunaCoreReceiver extends BroadcastReceiver
{

    public KahunaCoreReceiver()
    {
    }

    private String a(int i)
    {
        switch (i)
        {
        default:
            return "unknown";

        case 1: // '\001'
            return "enter";

        case 2: // '\002'
            return "exit";
        }
    }

    private void a(Context context, Intent intent)
    {
        context = h.a(intent);
        if (context != null) goto _L2; else goto _L1
_L1:
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Unable to create a Geofence Intent for: ").append(intent.toString()).toString());
        }
_L4:
        return;
_L2:
        if (!context.a())
        {
            break; /* Loop/switch isn't completed */
        }
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Geofence Intent processing has an error. Code:").append(context.b()).toString());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        j = context.c();
        if (j != 1 && j != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (m.a)
        {
            Log.d("Kahuna", "Recevied Kahuna Geofence update!");
        }
        context = context.d();
        intent = new String[context.size()];
        i = 0;
_L8:
        if (i >= context.size()) goto _L4; else goto _L5
_L5:
        String s;
        s = ((f)context.get(i)).a();
        intent[i] = s;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("GeofenceId: ").append(s).append(" Transition: ").append(a(j)).toString());
        }
        if (!s.contains("KahunaEngineRegion_")) goto _L7; else goto _L6
_L6:
label0:
        {
            if (j != 1)
            {
                break MISSING_BLOCK_LABEL_358;
            }
            if (t.a(true))
            {
                if (m.a)
                {
                    Log.d("Kahuna", "Updated existing regions registered from before 516, ignoring false first enter event");
                }
                ahj.a(m.j(), s);
                return;
            }
            String s1 = ahj.c(m.j());
            if (s1 == null || !s1.equals(s))
            {
                break label0;
            }
            if (m.a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Received Geofence enter again even though we are already in region for id:").append(s).toString());
                Log.d("Kahuna", "Not tracking geofence enter event.");
                return;
            }
        }
          goto _L4
        ahj.a(m.j(), s);
_L9:
        s = s.replace("KahunaEngineRegion_", "");
        m.j().a(s, a(j));
_L7:
        i++;
          goto _L8
        ahj.d(m.j());
          goto _L9
        if (!m.a) goto _L4; else goto _L10
_L10:
        Log.d("Kahuna", (new StringBuilder()).append("Received Unknown Geofence transition state:").append(j).toString());
        return;
    }

    public void onReceive(Context context, Intent intent)
    {
        String s;
        try
        {
            s = intent.getAction();
            if ("KAHUNA_PUSH_CLICKED".equals(s))
            {
                w.a(context, intent);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Handled exception in CoreReceiver.onReceive(): ").append(context).toString());
            context.printStackTrace();
            return;
        }
        if ("KAHUNA_GEOFENCES_UPDATED".equals(s))
        {
            a(context, intent);
            return;
        }
        if (ActivityRecognitionResult.a(intent))
        {
            ahc.a(context, intent);
        }
        return;
    }
}
