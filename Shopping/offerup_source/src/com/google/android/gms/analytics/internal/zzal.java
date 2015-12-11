// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzp

public class zzal
    implements zzp
{

    public String zzLq;
    public double zzPJ;
    public int zzPK;
    public int zzPL;
    public int zzPM;
    public int zzPN;
    public Map zzPO;

    public zzal()
    {
        zzPJ = -1D;
        zzPK = -1;
        zzPL = -1;
        zzPM = -1;
        zzPN = -1;
        zzPO = new HashMap();
    }

    public int getSessionTimeout()
    {
        return zzPK;
    }

    public String getTrackingId()
    {
        return zzLq;
    }

    public String zzbo(String s)
    {
        String s1 = (String)zzPO.get(s);
        if (s1 != null)
        {
            return s1;
        } else
        {
            return s;
        }
    }

    public boolean zzlc()
    {
        return zzLq != null;
    }

    public boolean zzld()
    {
        return zzPJ >= 0.0D;
    }

    public double zzle()
    {
        return zzPJ;
    }

    public boolean zzlf()
    {
        return zzPK >= 0;
    }

    public boolean zzlg()
    {
        return zzPL != -1;
    }

    public boolean zzlh()
    {
        return zzPL == 1;
    }

    public boolean zzli()
    {
        return zzPM != -1;
    }

    public boolean zzlj()
    {
        return zzPM == 1;
    }

    public boolean zzlk()
    {
        return zzPN == 1;
    }

    public String zzq(Activity activity)
    {
        return zzbo(activity.getClass().getCanonicalName());
    }
}
