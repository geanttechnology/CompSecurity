// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.google.android.gms.internal:
//            zzhz, zzid

public final class zzij extends zzhz
{

    private final Context mContext;
    private final String zzF;
    private String zzIa;
    private final String zzqV;

    public zzij(Context context, String s, String s1)
    {
        zzIa = null;
        mContext = context;
        zzqV = s;
        zzF = s1;
    }

    public zzij(Context context, String s, String s1, String s2)
    {
        zzIa = null;
        mContext = context;
        zzqV = s;
        zzF = s1;
        zzIa = s2;
    }

    public void onStop()
    {
    }

    public void zzbn()
    {
        HttpURLConnection httpurlconnection;
        zzb.v((new StringBuilder()).append("Pinging URL: ").append(zzF).toString());
        httpurlconnection = (HttpURLConnection)(new URL(zzF)).openConnection();
        if (!TextUtils.isEmpty(zzIa))
        {
            break MISSING_BLOCK_LABEL_127;
        }
        zzp.zzbv().zza(mContext, zzqV, true, httpurlconnection);
_L1:
        int i = httpurlconnection.getResponseCode();
        if (i >= 200 && i < 300)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        zzb.zzaH((new StringBuilder()).append("Received non-success response code ").append(i).append(" from pinging URL: ").append(zzF).toString());
        Exception exception;
        try
        {
            httpurlconnection.disconnect();
            return;
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            zzb.zzaH((new StringBuilder()).append("Error while parsing ping URL: ").append(zzF).append(". ").append(indexoutofboundsexception.getMessage()).toString());
            return;
        }
        catch (IOException ioexception)
        {
            zzb.zzaH((new StringBuilder()).append("Error while pinging URL: ").append(zzF).append(". ").append(ioexception.getMessage()).toString());
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            zzb.zzaH((new StringBuilder()).append("Error while pinging URL: ").append(zzF).append(". ").append(runtimeexception.getMessage()).toString());
        }
        break MISSING_BLOCK_LABEL_273;
        zzp.zzbv().zza(mContext, zzqV, true, httpurlconnection, zzIa);
          goto _L1
        exception;
        httpurlconnection.disconnect();
        throw exception;
    }
}
