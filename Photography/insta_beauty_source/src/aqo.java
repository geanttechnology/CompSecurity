// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import com.crashlytics.android.Crashlytics;
import com.fotoable.message.RegistrationService;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.lang.ref.WeakReference;

public class aqo
{

    private static aqo a = null;
    private Context b;
    private SharedPreferences c;
    private WeakReference d;
    private String e;
    private BroadcastReceiver f;

    private aqo(Context context, String s)
    {
        d = null;
        f = new aqp(this);
        b = context;
        e = s;
        a();
    }

    static SharedPreferences a(aqo aqo1)
    {
        return aqo1.c;
    }

    public static aqo a(Context context, String s)
    {
        if (a == null)
        {
            a = new aqo(context, s);
        }
        return a;
    }

    static WeakReference b(aqo aqo1)
    {
        return aqo1.d;
    }

    public void a()
    {
        c = PreferenceManager.getDefaultSharedPreferences(b);
        LocalBroadcastManager.getInstance(b).registerReceiver(f, new IntentFilter("registration_completed"));
    }

    public void a(anz anz1)
    {
        d = new WeakReference(anz1);
    }

    public void b()
    {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(b) == 0)
        {
            Intent intent = new Intent(b, com/fotoable/message/RegistrationService);
            intent.putExtra("sender_id", e);
            b.startService(intent);
            return;
        }
        try
        {
            if (d != null && d.get() != null)
            {
                ((anz)d.get()).e();
                return;
            }
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            return;
        }
        catch (Error error)
        {
            Crashlytics.logException(new Exception((new StringBuilder()).append("registerPush error : ").append(error).toString()));
        }
        return;
    }

    public String c()
    {
        if (c.getBoolean("has_token", false))
        {
            return c.getString("token", "");
        } else
        {
            return null;
        }
    }

}
