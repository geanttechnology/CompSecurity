// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.amazon.geo.mapsv2.AmazonMapsStrictMode;
import com.amazon.geo.mapsv2.internal.IMapsApiStrictModePolicy;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            AmazonMapsRuntimeUtil

private static class g
    implements IMapsApiStrictModePolicy
{

    public boolean detectAll()
    {
        com.amazon.geo.mapsv2.licy licy = AmazonMapsStrictMode.getApiPolicy();
        if (licy == null)
        {
            return false;
        } else
        {
            return licy.licy;
        }
    }

    public boolean detectUnimplemented()
    {
        com.amazon.geo.mapsv2.licy licy = AmazonMapsStrictMode.getApiPolicy();
        if (licy == null)
        {
            return false;
        } else
        {
            return licy.emented;
        }
    }

    public boolean penaltyLog()
    {
        com.amazon.geo.mapsv2.licy licy = AmazonMapsStrictMode.getApiPolicy();
        if (licy == null)
        {
            return false;
        } else
        {
            return licy.licy;
        }
    }

    public boolean penaltyThrow()
    {
        com.amazon.geo.mapsv2.licy licy = AmazonMapsStrictMode.getApiPolicy();
        if (licy == null)
        {
            return false;
        } else
        {
            return licy.;
        }
    }

    public void throwException(String s, Throwable throwable)
    {
        if (s == null && throwable == null)
        {
            throw new com.amazon.geo.mapsv2.nit>();
        }
        if (s == null)
        {
            throw new com.amazon.geo.mapsv2.nit>(throwable);
        }
        if (throwable == null)
        {
            throw new com.amazon.geo.mapsv2.nit>(s);
        } else
        {
            throw new com.amazon.geo.mapsv2.nit>(s, throwable);
        }
    }

    (Context context)
    {
        if (AmazonMapsStrictMode.getApiPolicy() != com.amazon.geo.mapsv2.licy) goto _L2; else goto _L1
_L1:
        context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (context == null) goto _L2; else goto _L3
_L3:
        if (((ApplicationInfo) (context)).metaData == null) goto _L2; else goto _L4
_L4:
        String s = (String)java/lang/String.cast(((ApplicationInfo) (context)).metaData.get("amazon.maps.strictmode.ApiPolicy"));
        if (s == null) goto _L2; else goto _L5
_L5:
        String as[];
        int j;
        context = new com.amazon.geo.mapsv2.t>();
        context.ctUnimplemented();
        as = s.split(",");
        j = as.length;
        int i = 0;
_L6:
        String s1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        s1 = as[i];
        if (s1.equals("throw"))
        {
            context.ltyThrow();
            break MISSING_BLOCK_LABEL_142;
        }
        if (s1.equals("log"))
        {
            context.ltyLog();
        }
        break MISSING_BLOCK_LABEL_142;
        try
        {
            AmazonMapsStrictMode.setApiPolicy(context.d());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        break; /* Loop/switch isn't completed */
        i++;
        if (true) goto _L6; else goto _L2
_L2:
    }
}
