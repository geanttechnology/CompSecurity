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

public class kw
{

    private static kw a = null;
    private Context b;
    private SharedPreferences c;
    private WeakReference d;
    private String e;
    private BroadcastReceiver f;

    private kw(Context context, String s)
    {
        d = null;
        f = new BroadcastReceiver() {

            final kw a;

            public void onReceive(Context context1, Intent intent)
            {
                if (kw.a(a).getBoolean("has_token", false) && kw.b(a) != null && kw.b(a).get() != null)
                {
                    context1 = kw.a(a).getString("token", "");
                    ((jd)kw.b(a).get()).a(context1);
                }
            }

            
            {
                a = kw.this;
                super();
            }
        };
        b = context;
        e = s;
        a();
    }

    static SharedPreferences a(kw kw1)
    {
        return kw1.c;
    }

    public static kw a(Context context, String s)
    {
        if (a == null)
        {
            a = new kw(context, s);
        }
        return a;
    }

    static WeakReference b(kw kw1)
    {
        return kw1.d;
    }

    public void a()
    {
        c = PreferenceManager.getDefaultSharedPreferences(b);
        LocalBroadcastManager.getInstance(b).registerReceiver(f, new IntentFilter("registration_completed"));
    }

    public void a(jd jd1)
    {
        d = new WeakReference(jd1);
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
                ((jd)d.get()).a();
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
