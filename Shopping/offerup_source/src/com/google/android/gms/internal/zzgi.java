// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zzgc, zziz, zzja, zzid

public class zzgi extends zzgc
    implements zzja.zza
{

    zzgi(Context context, zzhs.zza zza, zziz zziz1, zzgg.zza zza1)
    {
        super(context, zza, zziz1, zza1);
    }

    protected void zzfs()
    {
        if (zzDf.errorCode != -2)
        {
            return;
        } else
        {
            zzoM.zzhe().zza(this);
            zzfz();
            zzb.v("Loading HTML in WebView.");
            zzoM.loadDataWithBaseURL(zzp.zzbv().zzaz(zzDf.zzBF), zzDf.body, "text/html", "UTF-8", null);
            return;
        }
    }

    protected void zzfz()
    {
    }
}
