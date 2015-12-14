// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.internal.client.BarcodeDetectorOptions;
import com.google.android.gms.vision.barcode.internal.client.zzd;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            Barcode

public final class BarcodeDetector extends Detector
{
    public static class Builder
    {

        private Context mContext;
        private BarcodeDetectorOptions zzaVs;

        public BarcodeDetector build()
        {
            return new BarcodeDetector(new zzd(mContext, zzaVs));
        }

        public Builder setBarcodeFormats(int i)
        {
            zzaVs.zzaVt = i;
            return this;
        }

        public Builder(Context context)
        {
            mContext = context;
            zzaVs = new BarcodeDetectorOptions();
        }
    }


    private final zzd zzaVr;

    private BarcodeDetector()
    {
        throw new IllegalStateException("Default constructor called");
    }

    private BarcodeDetector(zzd zzd1)
    {
        zzaVr = zzd1;
    }


    public SparseArray detect(Frame frame)
    {
        if (frame == null)
        {
            throw new IllegalArgumentException("No frame supplied.");
        }
        frame.getMetadata();
        Object obj = FrameMetadataParcel.zzc(frame);
        int j;
        if (frame.getBitmap() != null)
        {
            frame = zzaVr.zza(frame.getBitmap(), ((FrameMetadataParcel) (obj)));
        } else
        {
            frame = frame.getGrayscaleImageData();
            frame = zzaVr.zza(frame, ((FrameMetadataParcel) (obj)));
        }
        obj = new SparseArray(frame.length);
        j = frame.length;
        for (int i = 0; i < j; i++)
        {
            Object obj1 = frame[i];
            ((SparseArray) (obj)).append(((Barcode) (obj1)).rawValue.hashCode(), obj1);
        }

        return ((SparseArray) (obj));
    }

    public boolean isOperational()
    {
        return zzaVr.isOperational();
    }
}
