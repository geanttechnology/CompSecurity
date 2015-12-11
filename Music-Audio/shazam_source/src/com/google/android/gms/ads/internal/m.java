// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.client.MobileAdsSettingsParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import com.google.android.gms.common.api.e;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.jc;
import com.google.android.gms.d.jj;
import com.google.android.gms.d.jw;
import com.google.android.gms.d.jx;
import com.google.android.gms.d.jy;
import com.google.android.gms.d.ka;
import com.google.android.gms.d.kc;
import com.google.android.gms.d.kd;
import com.google.android.gms.e.cz;
import com.google.android.gms.e.d;
import java.util.Set;
import java.util.regex.Pattern;

// Referenced classes of package com.google.android.gms.ads.internal:
//            p

public final class m extends com.google.android.gms.ads.internal.client.x.a
    implements com.google.android.gms.d.jc.a, com.google.android.gms.d.jx.a
{

    private static final Object e = new Object();
    private static m f;
    jw a;
    String b;
    String c;
    private final Context d;
    private boolean g;
    private boolean h;

    private m(Context context)
    {
        d = context;
        g = false;
    }

    public static m a(Context context)
    {
        synchronized (e)
        {
            if (f == null)
            {
                f = new m(context.getApplicationContext());
            }
            context = f;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public final void a(jj jj1)
    {
    }

    public final void a(jj jj1, Activity activity)
    {
        if (jj1 != null && activity != null)
        {
            if (activity instanceof AdActivity)
            {
                com.google.android.gms.ads.internal.p.e();
                int i = gm.d(activity);
                if (i == 1)
                {
                    jj1.a(true);
                    jj1.a("Interstitial Ad");
                    return;
                }
                if (i == 2 || i == 3)
                {
                    jj1.a("Expanded Ad");
                    return;
                } else
                {
                    jj1.a(null);
                    return;
                }
            }
            if (activity instanceof InAppPurchaseActivity)
            {
                jj1.a(null);
                return;
            }
        }
    }

    public final void a(String s, MobileAdsSettingsParcel mobileadssettingsparcel)
    {
label0:
        {
            synchronized (e)
            {
                if (!g)
                {
                    break label0;
                }
                com.google.android.gms.ads.internal.util.client.b.a(5);
            }
            return;
        }
        if (d != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        com.google.android.gms.ads.internal.util.client.b.a(5);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        if (!TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        com.google.android.gms.ads.internal.util.client.b.a(5);
        obj;
        JVM INSTR monitorexit ;
        return;
        g = true;
        if (mobileadssettingsparcel == null) goto _L2; else goto _L1
_L1:
        if (!mobileadssettingsparcel.b) goto _L2; else goto _L3
_L3:
        com.google.android.gms.ads.internal.p.e();
        if (gm.a(d.getPackageManager(), d.getPackageName(), "android.permission.INTERNET")) goto _L5; else goto _L4
_L4:
        com.google.android.gms.ads.internal.util.client.b.a("Missing permission android.permission.INTERNET");
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
_L5:
label1:
        {
            com.google.android.gms.ads.internal.p.e();
            if (gm.a(d.getPackageManager(), d.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
            {
                break label1;
            }
            com.google.android.gms.ads.internal.util.client.b.a("Missing permission android.permission.ACCESS_NETWORK_STATE");
        }
          goto _L2
        if (!Pattern.matches("ca-app-[a-z0-9_-]+~[a-z0-9_-]+", s))
        {
            throw new IllegalArgumentException("Please provide a valid application code");
        }
        h = true;
        b = s;
        c = mobileadssettingsparcel.c;
        mobileadssettingsparcel = jx.a(d);
        s = new com.google.android.gms.d.jw.a(b);
        if (!TextUtils.isEmpty(c))
        {
            s.d = c;
        }
        s = s.a();
        mobileadssettingsparcel;
        JVM INSTR monitorenter ;
        if (((jx) (mobileadssettingsparcel)).d)
        {
            throw new IllegalStateException("Settings can't be changed after TagManager has been started");
        }
        break MISSING_BLOCK_LABEL_244;
        s;
        mobileadssettingsparcel;
        JVM INSTR monitorexit ;
        throw s;
        mobileadssettingsparcel.a = s;
        mobileadssettingsparcel;
        JVM INSTR monitorexit ;
        mobileadssettingsparcel;
        JVM INSTR monitorenter ;
        ((jx) (mobileadssettingsparcel)).b.add(this);
        mobileadssettingsparcel;
        JVM INSTR monitorexit ;
        jc.a(d).a(this);
        mobileadssettingsparcel;
        JVM INSTR monitorenter ;
        if (((jx) (mobileadssettingsparcel)).d)
        {
            throw new IllegalStateException("Method start() has already been called");
        }
        break MISSING_BLOCK_LABEL_306;
        s;
        mobileadssettingsparcel;
        JVM INSTR monitorexit ;
        throw s;
        s;
        mobileadssettingsparcel;
        JVM INSTR monitorexit ;
        throw s;
        Object obj1;
        if (((jx) (mobileadssettingsparcel)).a == null)
        {
            throw new IllegalStateException("No settings configured");
        }
        mobileadssettingsparcel.d = true;
        s = ((jx) (mobileadssettingsparcel)).c;
        obj1 = ((jx) (mobileadssettingsparcel)).a.d;
        obj1 = ((d) (s)).a.a(((d) (s)).b, s, ((String) (obj1)), ((d) (s)).f);
        if (((cz) (obj1)).c == -1) goto _L7; else goto _L6
_L6:
        s = Integer.valueOf(((cz) (obj1)).c);
_L8:
        ka ka1 = ((cz) (obj1)).g;
        String s1 = ((cz) (obj1)).f;
        com.google.android.gms.e.cz._cls1 _lcls1 = new com.google.android.gms.e.cz._cls1(((cz) (obj1)), "admob");
        s = (new kd()).a(new jy(s1, s, "admob"));
        ka1.a(s, _lcls1, new com.google.android.gms.d.ka.b(ka1, s, kc.a, _lcls1));
        ((e) (obj1)).a(new com.google.android.gms.d.jx._cls1(mobileadssettingsparcel));
        mobileadssettingsparcel;
        JVM INSTR monitorexit ;
          goto _L2
_L7:
        s = null;
          goto _L8
    }

    public final boolean a()
    {
        boolean flag;
        synchronized (e)
        {
            flag = h;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void b()
    {
        a = jx.a(d).a();
    }

    public final int c()
    {
label0:
        {
            synchronized (e)
            {
                if (h)
                {
                    break label0;
                }
            }
            return -1;
        }
        jj jj1 = jc.a(d).b;
        if (jj1 == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        int i = jj1.b;
        obj;
        JVM INSTR monitorexit ;
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
        return -1;
    }

    public final String d()
    {
label0:
        {
            synchronized (e)
            {
                if (h)
                {
                    break label0;
                }
            }
            return null;
        }
        String s = com.google.android.gms.analytics.e.a(d).b();
        obj;
        JVM INSTR monitorexit ;
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
