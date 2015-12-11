// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzs, zzaf, zzy

public class zzae
{

    private static volatile Logger zzPq;

    public static Logger getLogger()
    {
        return zzPq;
    }

    public static void setLogger(Logger logger)
    {
        zzPq = logger;
    }

    public static void v(String s)
    {
        zzaf zzaf1 = zzaf.zzkG();
        if (zzaf1 == null) goto _L2; else goto _L1
_L1:
        zzaf1.zzba(s);
_L4:
        Logger logger = zzPq;
        if (logger != null)
        {
            logger.verbose(s);
        }
        return;
_L2:
        if (zzN(0))
        {
            Log.v((String)zzy.zzOg.get(), s);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean zzN(int i)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (getLogger() != null)
        {
            flag = flag1;
            if (getLogger().getLogLevel() <= i)
            {
                flag = true;
            }
        }
        return flag;
    }

    public static void zzaG(String s)
    {
        zzaf zzaf1 = zzaf.zzkG();
        if (zzaf1 == null) goto _L2; else goto _L1
_L1:
        zzaf1.zzbc(s);
_L4:
        Logger logger = zzPq;
        if (logger != null)
        {
            logger.info(s);
        }
        return;
_L2:
        if (zzN(1))
        {
            Log.i((String)zzy.zzOg.get(), s);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void zzaH(String s)
    {
        zzaf zzaf1 = zzaf.zzkG();
        if (zzaf1 == null) goto _L2; else goto _L1
_L1:
        zzaf1.zzbd(s);
_L4:
        Logger logger = zzPq;
        if (logger != null)
        {
            logger.warn(s);
        }
        return;
_L2:
        if (zzN(2))
        {
            Log.w((String)zzy.zzOg.get(), s);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void zzf(String s, Object obj)
    {
        zzaf zzaf1 = zzaf.zzkG();
        if (zzaf1 == null) goto _L2; else goto _L1
_L1:
        zzaf1.zze(s, obj);
_L4:
        obj = zzPq;
        if (obj != null)
        {
            ((Logger) (obj)).error(s);
        }
        return;
_L2:
        if (zzN(3))
        {
            if (obj != null)
            {
                obj = (new StringBuilder()).append(s).append(":").append(obj).toString();
            } else
            {
                obj = s;
            }
            Log.e((String)zzy.zzOg.get(), ((String) (obj)));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        setLogger(new zzs());
    }
}
