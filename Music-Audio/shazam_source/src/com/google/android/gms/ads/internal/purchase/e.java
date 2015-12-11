// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.el;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.gn;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            h, j, GInAppPurchaseManagerInfoParcel, b, 
//            i, k, f

public final class e extends com.google.android.gms.d.en.a
    implements ServiceConnection
{

    h a;
    private final Activity b;
    private Context c;
    private el d;
    private com.google.android.gms.ads.internal.purchase.b e;
    private f f;
    private j g;
    private k h;
    private String i;

    public e(Activity activity)
    {
        i = null;
        b = activity;
        a = com.google.android.gms.ads.internal.purchase.h.a(b.getApplicationContext());
    }

    private void a(String s, boolean flag, int l, Intent intent)
    {
        if (g != null)
        {
            g.a(s, flag, l, intent, f);
        }
    }

    public final void a()
    {
        Object obj = GInAppPurchaseManagerInfoParcel.a(b.getIntent());
        g = ((GInAppPurchaseManagerInfoParcel) (obj)).e;
        h = ((GInAppPurchaseManagerInfoParcel) (obj)).b;
        d = ((GInAppPurchaseManagerInfoParcel) (obj)).c;
        e = new com.google.android.gms.ads.internal.purchase.b(b.getApplicationContext());
        c = ((GInAppPurchaseManagerInfoParcel) (obj)).d;
        if (b.getResources().getConfiguration().orientation == 2)
        {
            b.setRequestedOrientation(p.g().a());
        } else
        {
            b.setRequestedOrientation(p.g().b());
        }
        obj = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        ((Intent) (obj)).setPackage("com.android.vending");
        b.bindService(((Intent) (obj)), this, 1);
    }

    public final void a(int l, int i1, Intent intent)
    {
        if (l != 1001) goto _L2; else goto _L1
_L1:
        boolean flag = false;
        p.o();
        l = com.google.android.gms.ads.internal.purchase.i.a(intent);
        if (i1 != -1)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        p.o();
        if (l != 0)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (h.a(i, intent))
        {
            flag = true;
        }
_L3:
        d.b(l);
        b.finish();
        a(d.a(), flag, i1, intent);
        i = null;
_L2:
        return;
        a.a(f);
          goto _L3
        intent;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        b.finish();
        i = null;
        return;
        intent;
        i = null;
        throw intent;
    }

    public final void b()
    {
        b.unbindService(this);
        e.a = null;
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        e.a(ibinder);
        PendingIntent pendingintent;
        p.e();
        i = gm.a();
        componentname = e.a(b.getPackageName(), d.a(), i);
        pendingintent = (PendingIntent)componentname.getParcelable("BUY_INTENT");
        h h1;
        Object obj1;
        if (pendingintent == null)
        {
            Object obj;
            try
            {
                p.o();
                int l = com.google.android.gms.ads.internal.purchase.i.a(componentname);
                d.b(l);
                a(d.a(), false, l, null);
                b.finish();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname) { }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname) { }
            com.google.android.gms.ads.internal.util.client.b.a(5);
            b.finish();
            return;
        }
        f = new f(d.a(), i);
        h1 = a;
        componentname = f;
        if (componentname == null) goto _L2; else goto _L1
_L1:
        obj = h.a;
        obj;
        JVM INSTR monitorenter ;
        ibinder = h1.a();
        if (ibinder != null) goto _L4; else goto _L3
_L3:
        obj;
        JVM INSTR monitorexit ;
_L2:
        b.startIntentSenderForResult(pendingintent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        return;
_L4:
        obj1 = new ContentValues();
        ((ContentValues) (obj1)).put("product_id", ((f) (componentname)).c);
        ((ContentValues) (obj1)).put("developer_payload", ((f) (componentname)).b);
        ((ContentValues) (obj1)).put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
        componentname.a = ibinder.insert("InAppPurchase", null, ((ContentValues) (obj1)));
        if ((long)h1.c() <= 20000L) goto _L6; else goto _L5
_L5:
        obj1 = h.a;
        obj1;
        JVM INSTR monitorenter ;
        componentname = h1.a();
        if (componentname != null) goto _L8; else goto _L7
_L7:
        obj1;
        JVM INSTR monitorexit ;
_L6:
        obj;
        JVM INSTR monitorexit ;
          goto _L2
        componentname;
        obj;
        JVM INSTR monitorexit ;
        throw componentname;
_L8:
        ibinder = componentname.query("InAppPurchase", null, null, null, null, null, "record_time ASC", "1");
        if (ibinder == null)
        {
            break MISSING_BLOCK_LABEL_376;
        }
        componentname = ibinder;
        if (!ibinder.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_376;
        }
        componentname = ibinder;
        h1.a(com.google.android.gms.ads.internal.purchase.h.a(ibinder));
        if (ibinder == null)
        {
            break MISSING_BLOCK_LABEL_386;
        }
        ibinder.close();
_L10:
        obj1;
        JVM INSTR monitorexit ;
          goto _L6
        componentname;
        obj1;
        JVM INSTR monitorexit ;
        throw componentname;
        SQLiteException sqliteexception;
        sqliteexception;
        ibinder = null;
_L12:
        componentname = ibinder;
        (new StringBuilder("Error remove oldest record")).append(sqliteexception.getMessage());
        componentname = ibinder;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        if (ibinder == null) goto _L10; else goto _L9
_L9:
        ibinder.close();
          goto _L10
_L11:
        if (componentname == null)
        {
            break MISSING_BLOCK_LABEL_451;
        }
        componentname.close();
        throw ibinder;
        ibinder;
          goto _L11
        sqliteexception;
          goto _L12
        ibinder;
        componentname = null;
          goto _L11
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        com.google.android.gms.ads.internal.util.client.b.a(4);
        e.a = null;
    }
}
