// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import com.google.android.gms.ads.internal.formats.zzc;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.android.gms.internal:
//            zzgm, zzmt

class zzAs
    implements a
{

    final String zzAs;
    final zzgm zzDN;
    final boolean zzDX;
    final double zzDY;

    public zzc zzfE()
    {
        zzDN.zza(2, zzDX);
        return null;
    }

    public Object zzfF()
    {
        return zzfE();
    }

    public zzc zzg(InputStream inputstream)
    {
        try
        {
            inputstream = zzmt.zzk(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream = null;
        }
        if (inputstream == null)
        {
            zzDN.zza(2, zzDX);
            return null;
        }
        inputstream = BitmapFactory.decodeByteArray(inputstream, 0, inputstream.length);
        if (inputstream == null)
        {
            zzDN.zza(2, zzDX);
            return null;
        } else
        {
            inputstream.setDensity((int)(160D * zzDY));
            return new zzc(new BitmapDrawable(Resources.getSystem(), inputstream), Uri.parse(zzAs), zzDY);
        }
    }

    public Object zzh(InputStream inputstream)
    {
        return zzg(inputstream);
    }

    mats.zzc(zzgm zzgm1, boolean flag, double d, String s)
    {
        zzDN = zzgm1;
        zzDX = flag;
        zzDY = d;
        zzAs = s;
        super();
    }
}
