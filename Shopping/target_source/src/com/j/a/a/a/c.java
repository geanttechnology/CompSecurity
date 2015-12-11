// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a.a;

import android.os.Handler;
import com.j.a.g.w;
import java.lang.reflect.Method;

// Referenced classes of package com.j.a.a.a:
//            m, l

class c
    implements Runnable
{

    final l a;

    c(l l)
    {
        a = l;
        super();
    }

    public void run()
    {
        Class class1 = Class.forName("com.flurry.android.FlurryAgent");
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        class1.getMethod("logEvent", new Class[] {
            java/lang/String
        }).invoke(class1, new Object[] {
            "app started"
        });
_L2:
        (new Handler()).postDelayed(new m(this), 750L);
        return;
        Object obj;
        obj;
_L3:
        Exception exception;
        if (obj instanceof Exception)
        {
            exception = (Exception)obj;
        } else
        {
            exception = null;
        }
        w.b("flr", exception);
        if (true) goto _L2; else goto _L1
_L1:
        exception;
          goto _L3
    }
}
