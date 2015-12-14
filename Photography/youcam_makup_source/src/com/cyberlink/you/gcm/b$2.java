// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.gcm;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.cyberlink.you.a;
import com.cyberlink.you.d;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.ULogUtility;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

// Referenced classes of package com.cyberlink.you.gcm:
//            b

final class rror
    implements Runnable
{

    public void run()
    {
        Object obj;
        if (!g.a().G())
        {
            return;
        }
        Log.d("GcmWorker", "Update");
        ULogUtility.b("Update", "GcmWorker");
        if (!a.a().c())
        {
            Log.d("GcmWorker", "Network Not Connected");
            ULogUtility.b("Network Not Connected", "GcmWorker");
            return;
        }
        obj = g.I().getSharedPreferences("U", 0);
        if (((SharedPreferences) (obj)).getLong("GcmRegIdSent", 0L) != 0L)
        {
            Log.d("GcmWorker", "Already Registered");
            ULogUtility.b("Already Registered", "GcmWorker");
            return;
        }
        String s = ((SharedPreferences) (obj)).getString("regId", "");
        if (s != null && !s.isEmpty())
        {
            l.j();
            return;
        }
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(g.I().getApplicationContext());
        if (i != 0)
        {
            String s1;
            try
            {
                Log.e("GcmWorker", (new StringBuilder()).append("isGooglePlayServicesAvailable() = ").append(i).toString());
                ULogUtility.b((new StringBuilder()).append("isGooglePlayServicesAvailable() = ").append(i).toString(), "GcmWorker");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (((IOException) (obj)).getMessage() != null)
                {
                    Log.e("GcmWorker", ((IOException) (obj)).getMessage());
                }
                ((IOException) (obj)).printStackTrace();
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                return;
            }
            catch (NoClassDefFoundError noclassdeffounderror)
            {
                noclassdeffounderror.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_277;
        }
        Log.d("GcmWorker", "Register GCM");
        ULogUtility.b("Register GCM", "GcmWorker");
        s1 = GoogleCloudMessaging.getInstance(g.I().getApplicationContext()).register(new String[] {
            d.d
        });
        ((SharedPreferences) (obj)).edit().putString("regId", s1).apply();
        l.j();
        return;
    }

    rror()
    {
    }
}
