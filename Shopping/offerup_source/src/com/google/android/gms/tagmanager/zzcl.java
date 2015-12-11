// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.zzrb;
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbg, zzbf, zzs, zzcb

class zzcl
    implements Runnable
{

    private final Context mContext;
    private final String zzaVQ;
    private volatile String zzaWn;
    private final zzrg zzaYi;
    private final String zzaYj;
    private zzbf zzaYk;
    private volatile zzs zzaYl;
    private volatile String zzaYm;

    zzcl(Context context, String s, zzrg zzrg1, zzs zzs1)
    {
        mContext = context;
        zzaYi = zzrg1;
        zzaVQ = s;
        zzaYl = zzs1;
        zzaYj = (new StringBuilder("/r?id=")).append(s).toString();
        zzaWn = zzaYj;
        zzaYm = null;
    }

    public zzcl(Context context, String s, zzs zzs1)
    {
        this(context, s, new zzrg(), zzs1);
    }

    private boolean zzDp()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            zzbg.v("...no network connectivity");
            return false;
        } else
        {
            return true;
        }
    }

    private void zzDq()
    {
        zzrf zzrf1;
        String s;
        if (!zzDp())
        {
            zzaYk.zza(zzbf.zza.zzaXy);
            return;
        }
        zzbg.v("Start loading resource from network ...");
        s = zzDr();
        zzrf1 = zzaYi.zzEt();
        Object obj = zzrf1.zzft(s);
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        zzrb.zzb(((java.io.InputStream) (obj)), bytearrayoutputstream);
        obj = com.google.android.gms.internal.zzaf.zzj.zzd(bytearrayoutputstream.toByteArray());
        zzbg.v((new StringBuilder("Successfully loaded supplemented resource: ")).append(obj).toString());
        if (((com.google.android.gms.internal.zzaf.zzj) (obj)).zziR == null && ((com.google.android.gms.internal.zzaf.zzj) (obj)).zziQ.length == 0)
        {
            zzbg.v((new StringBuilder("No change for container: ")).append(zzaVQ).toString());
        }
        zzaYk.zzH(obj);
        zzrf1.close();
        zzbg.v("Load resource from network finished.");
        return;
        Object obj1;
        obj1;
        zzbg.zzaH((new StringBuilder("No data is retrieved from the given url: ")).append(s).append(". Make sure container_id: ").append(zzaVQ).append(" is correct.").toString());
        zzaYk.zza(zzbf.zza.zzaXA);
        zzrf1.close();
        return;
        obj1;
        zzbg.zzd((new StringBuilder("Error when loading resources from url: ")).append(s).append(" ").append(((IOException) (obj1)).getMessage()).toString(), ((Throwable) (obj1)));
        zzaYk.zza(zzbf.zza.zzaXz);
        zzrf1.close();
        return;
        obj1;
        zzbg.zzd((new StringBuilder("Error when parsing downloaded resources from url: ")).append(s).append(" ").append(((IOException) (obj1)).getMessage()).toString(), ((Throwable) (obj1)));
        zzaYk.zza(zzbf.zza.zzaXA);
        zzrf1.close();
        return;
        Exception exception;
        exception;
        zzrf1.close();
        throw exception;
    }

    public void run()
    {
        if (zzaYk == null)
        {
            throw new IllegalStateException("callback must be set before execute");
        } else
        {
            zzaYk.zzCC();
            zzDq();
            return;
        }
    }

    String zzDr()
    {
        String s1 = (new StringBuilder()).append(zzaYl.zzCE()).append(zzaWn).append("&v=a65833898").toString();
        String s = s1;
        if (zzaYm != null)
        {
            s = s1;
            if (!zzaYm.trim().equals(""))
            {
                s = (new StringBuilder()).append(s1).append("&pv=").append(zzaYm).toString();
            }
        }
        s1 = s;
        if (zzcb.zzDm().zzDn().equals(zzcb.zza.zzaYa))
        {
            s1 = (new StringBuilder()).append(s).append("&gtm_debug=x").toString();
        }
        return s1;
    }

    void zza(zzbf zzbf1)
    {
        zzaYk = zzbf1;
    }

    void zzeH(String s)
    {
        if (s == null)
        {
            zzaWn = zzaYj;
            return;
        } else
        {
            zzbg.zzaF((new StringBuilder("Setting CTFE URL path: ")).append(s).toString());
            zzaWn = s;
            return;
        }
    }

    void zzeW(String s)
    {
        zzbg.zzaF((new StringBuilder("Setting previous container version: ")).append(s).toString());
        zzaYm = s;
    }
}
