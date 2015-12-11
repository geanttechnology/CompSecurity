// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

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
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.bk;
import com.google.android.gms.b.ca;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            e, GInAppPurchaseManagerInfoParcel, b, f, 
//            h, g, d

public class c extends com.google.android.gms.b.bl.a
    implements ServiceConnection
{

    e a;
    private final Activity b;
    private Context c;
    private bk d;
    private com.google.android.gms.ads.internal.purchase.b e;
    private d f;
    private g g;
    private h h;
    private String i;

    public c(Activity activity)
    {
        i = null;
        b = activity;
        a = com.google.android.gms.ads.internal.purchase.e.a(b.getApplicationContext());
    }

    public void a()
    {
        Object obj = GInAppPurchaseManagerInfoParcel.a(b.getIntent());
        g = ((GInAppPurchaseManagerInfoParcel) (obj)).e;
        h = ((GInAppPurchaseManagerInfoParcel) (obj)).b;
        d = ((GInAppPurchaseManagerInfoParcel) (obj)).c;
        e = new com.google.android.gms.ads.internal.purchase.b(b.getApplicationContext());
        c = ((GInAppPurchaseManagerInfoParcel) (obj)).d;
        if (b.getResources().getConfiguration().orientation == 2)
        {
            b.setRequestedOrientation(com.google.android.gms.ads.internal.c.e().a());
        } else
        {
            b.setRequestedOrientation(com.google.android.gms.ads.internal.c.e().b());
        }
        obj = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        ((Intent) (obj)).setPackage("com.android.vending");
        b.bindService(((Intent) (obj)), this, 1);
    }

    public void a(int j, int k, Intent intent)
    {
        if (j != 1001) goto _L2; else goto _L1
_L1:
        boolean flag = false;
        j = com.google.android.gms.ads.internal.c.j().a(intent);
        if (k != -1)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        com.google.android.gms.ads.internal.c.j();
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (h.a(i, k, intent))
        {
            flag = true;
        }
_L3:
        d.a(j);
        b.finish();
        a(d.a(), flag, k, intent);
        i = null;
_L2:
        return;
        a.a(f);
          goto _L3
        intent;
        com.google.android.gms.ads.internal.util.client.b.e("Fail to process purchase result.");
        b.finish();
        i = null;
        return;
        intent;
        i = null;
        throw intent;
    }

    protected void a(String s, boolean flag, int j, Intent intent)
    {
        if (g != null)
        {
            g.a(s, flag, j, intent, f);
        }
    }

    public void b()
    {
        b.unbindService(this);
        e.a();
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        e.a(ibinder);
        i = h.a();
        componentname = e.a(b.getPackageName(), d.a(), i);
        ibinder = (PendingIntent)componentname.getParcelable("BUY_INTENT");
        if (ibinder == null)
        {
            try
            {
                int j = com.google.android.gms.ads.internal.c.j().a(componentname);
                d.a(j);
                a(d.a(), false, j, null);
                b.finish();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname) { }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname) { }
            break MISSING_BLOCK_LABEL_182;
        }
        f = new d(d.a(), i);
        a.b(f);
        b.startIntentSenderForResult(ibinder.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        return;
        com.google.android.gms.ads.internal.util.client.b.c("Error when connecting in-app billing service", componentname);
        b.finish();
        return;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        com.google.android.gms.ads.internal.util.client.b.c("In-app billing service disconnected.");
        e.a();
    }
}
