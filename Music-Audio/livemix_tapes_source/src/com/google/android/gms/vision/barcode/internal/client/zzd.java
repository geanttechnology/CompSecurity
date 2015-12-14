// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode.internal.client;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.gms.vision.barcode.internal.client:
//            zzb, BarcodeDetectorOptions, zzc

public class zzd
{
    static class zza extends zzg
    {

        private static zza zzaVv;

        static zzb zza(Context context, BarcodeDetectorOptions barcodedetectoroptions)
        {
            if (zzaVv == null)
            {
                zzaVv = new zza();
            }
            return zzaVv.zzb(context, barcodedetectoroptions);
        }

        private zzb zzb(Context context, BarcodeDetectorOptions barcodedetectoroptions)
        {
            com.google.android.gms.dynamic.zzd zzd1 = zze.zzx(context);
            context = ((zzc)zzar(context)).zza(zzd1, barcodedetectoroptions);
            return context;
            context;
            Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", context);
_L2:
            return null;
            context;
            Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", context);
            if (true) goto _L2; else goto _L1
_L1:
        }

        protected Object zzd(IBinder ibinder)
        {
            return zzdL(ibinder);
        }

        protected zzc zzdL(IBinder ibinder)
        {
            return zzc.zza.zzdK(ibinder);
        }

        zza()
        {
            super("com.google.android.gms.vision.client.DynamiteNativeBarcodeDetectorCreator");
        }
    }


    private final Context mContext;
    private final BarcodeDetectorOptions zzaVs;
    private zzb zzaVu;
    private final Object zzpc = new Object();

    public zzd(Context context, BarcodeDetectorOptions barcodedetectoroptions)
    {
        zzaVu = null;
        mContext = context;
        zzaVs = barcodedetectoroptions;
        zzCe();
    }

    private zzb zzCe()
    {
        zzb zzb1;
        synchronized (zzpc)
        {
            if (zzaVu == null)
            {
                zzaVu = zza.zza(mContext, zzaVs);
            }
            zzb1 = zzaVu;
        }
        return zzb1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isOperational()
    {
        return zzCe() != null;
    }

    public Barcode[] zza(Bitmap bitmap, FrameMetadataParcel framemetadataparcel)
    {
        zzb zzb1 = zzCe();
        if (zzb1 == null)
        {
            return new Barcode[0];
        }
        try
        {
            bitmap = zzb1.zzb(zze.zzx(bitmap), framemetadataparcel);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", bitmap);
            return new Barcode[0];
        }
        return bitmap;
    }

    public Barcode[] zza(ByteBuffer bytebuffer, FrameMetadataParcel framemetadataparcel)
    {
        zzb zzb1 = zzCe();
        if (zzb1 == null)
        {
            return new Barcode[0];
        }
        try
        {
            bytebuffer = zzb1.zza(zze.zzx(bytebuffer), framemetadataparcel);
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", bytebuffer);
            return new Barcode[0];
        }
        return bytebuffer;
    }
}
