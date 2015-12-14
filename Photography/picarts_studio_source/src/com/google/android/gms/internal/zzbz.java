// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzby, zzbu, zzid, zzgz, 
//            zzgy

public class zzbz
{

    private Context mContext;
    private String zzqV;
    private boolean zzvA;
    private String zzvB;
    private Map zzvC;

    public zzbz(Context context, String s)
    {
        mContext = null;
        zzqV = null;
        mContext = context;
        zzqV = s;
        zzvA = ((Boolean)zzby.zzuQ.get()).booleanValue();
        zzvB = (String)zzby.zzuR.get();
        zzvC = new LinkedHashMap();
        zzvC.put("s", "gmob_sdk");
        zzvC.put("v", "3");
        zzvC.put("os", android.os.Build.VERSION.RELEASE);
        zzvC.put("sdk", android.os.Build.VERSION.SDK);
        zzvC.put("device", zzp.zzbv().zzgE());
        s = zzvC;
        if (context.getApplicationContext() != null)
        {
            context = context.getApplicationContext().getPackageName();
        } else
        {
            context = context.getPackageName();
        }
        s.put("app", context);
        context = zzp.zzbB().zzC(mContext);
        zzvC.put("network_coarse", Integer.toString(((zzgy) (context)).zzGE));
        zzvC.put("network_fine", Integer.toString(((zzgy) (context)).zzGF));
    }

    Context getContext()
    {
        return mContext;
    }

    String zzbV()
    {
        return zzqV;
    }

    boolean zzdg()
    {
        return zzvA;
    }

    String zzdh()
    {
        return zzvB;
    }

    Map zzdi()
    {
        return zzvC;
    }
}
