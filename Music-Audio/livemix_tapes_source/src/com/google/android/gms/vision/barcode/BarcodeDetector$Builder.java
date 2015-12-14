// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.content.Context;
import com.google.android.gms.vision.barcode.internal.client.BarcodeDetectorOptions;
import com.google.android.gms.vision.barcode.internal.client.zzd;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            BarcodeDetector

public static class etectorOptions
{

    private Context mContext;
    private BarcodeDetectorOptions zzaVs;

    public BarcodeDetector build()
    {
        return new BarcodeDetector(new zzd(mContext, zzaVs), null);
    }

    public zzaVs setBarcodeFormats(int i)
    {
        zzaVs.zzaVt = i;
        return this;
    }

    public etectorOptions(Context context)
    {
        mContext = context;
        zzaVs = new BarcodeDetectorOptions();
    }
}
