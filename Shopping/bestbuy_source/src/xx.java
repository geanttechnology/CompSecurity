// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.ea;

public class xx extends yn
    implements ServiceConnection
{

    private final Activity a;
    private final ya b;
    private Context c;
    private yg d;
    private xu e;
    private xy f;
    private yd g;
    private ye h;
    private String i;

    public xx(Activity activity)
    {
        i = null;
        a = activity;
        b = ya.a(a.getApplicationContext());
    }

    public static void a(Context context, boolean flag, ea ea1)
    {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", flag);
        ea.a(intent, ea1);
        context.startActivity(intent);
    }

    private void a(String s, boolean flag, int j, Intent intent)
    {
        if (g != null)
        {
            g.a(s, flag, j, intent, f);
        }
    }

    public void a()
    {
        Object obj = ea.a(a.getIntent());
        g = ((ea) (obj)).e;
        h = ((ea) (obj)).b;
        d = ((ea) (obj)).c;
        e = new xu(a.getApplicationContext());
        c = ((ea) (obj)).d;
        if (a.getResources().getConfiguration().orientation == 2)
        {
            a.setRequestedOrientation(6);
        } else
        {
            a.setRequestedOrientation(7);
        }
        obj = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        ((Intent) (obj)).setPackage("com.android.vending");
        a.bindService(((Intent) (obj)), this, 1);
    }

    public void a(int j, int k, Intent intent)
    {
        if (j != 1001) goto _L2; else goto _L1
_L1:
        boolean flag = false;
        j = yc.a(intent);
        if (k != -1 || j != 0)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        if (h.a(i, k, intent))
        {
            flag = true;
        }
_L3:
        d.c(j);
        a.finish();
        a(d.a(), flag, k, intent);
        i = null;
_L2:
        return;
        b.a(f);
          goto _L3
        intent;
        acb.e("Fail to process purchase result.");
        a.finish();
        i = null;
        return;
        intent;
        i = null;
        throw intent;
    }

    public void b()
    {
        a.unbindService(this);
        e.a();
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        e.a(ibinder);
        i = h.a();
        componentname = e.a(a.getPackageName(), d.a(), i);
        ibinder = (PendingIntent)componentname.getParcelable("BUY_INTENT");
        if (ibinder == null)
        {
            try
            {
                int j = yc.a(componentname);
                d.c(j);
                a(d.a(), false, j, null);
                a.finish();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname) { }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname) { }
            break MISSING_BLOCK_LABEL_179;
        }
        f = new xy(d.a(), i);
        b.b(f);
        a.startIntentSenderForResult(ibinder.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        return;
        acb.d("Error when connecting in-app billing service", componentname);
        a.finish();
        return;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        acb.c("In-app billing service disconnected.");
        e.a();
    }
}
