// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.google.ads.internal.d;
import com.google.ads.internal.e;
import com.google.ads.util.b;

// Referenced classes of package com.google.ads:
//            AdActivity, n

public static class 
{

    public boolean isShowing()
    {
        Object obj = AdActivity.a();
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (com.google.ads.AdActivity.b() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void launchAdActivity(d d1, e e1)
    {
        Object obj = AdActivity.a();
        obj;
        JVM INSTR monitorenter ;
        if (com.google.ads.AdActivity.d() != null) goto _L2; else goto _L1
_L1:
        com.google.ads.AdActivity.b(d1);
_L4:
        d1 = (Activity)d1.i().c.();
        if (d1 == null)
        {
            b.e("activity was null while launching an AdActivity.");
            return;
        }
        break MISSING_BLOCK_LABEL_63;
_L2:
        if (com.google.ads.AdActivity.d() == d1) goto _L4; else goto _L3
_L3:
        b.b("Tried to launch a new AdActivity with a different AdManager.");
        obj;
        JVM INSTR monitorexit ;
        return;
        d1;
        obj;
        JVM INSTR monitorexit ;
        throw d1;
        Intent intent = new Intent(d1.getApplicationContext(), com/google/ads/AdActivity);
        intent.putExtra("com.google.ads.AdOpener", e1.a());
        try
        {
            b.a("Launching AdActivity.");
            d1.startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (d d1)
        {
            b.b("Activity not found.", d1);
        }
        return;
    }

    public boolean leftApplication()
    {
        Object obj = AdActivity.a();
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (AdActivity.c() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ()
    {
    }
}
