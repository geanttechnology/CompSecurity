// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.face;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.internal.client.FaceSettingsParcel;
import com.google.android.gms.vision.face.internal.client.zzg;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import com.google.android.gms.vision.zza;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.vision.face:
//            Face

public final class FaceDetector extends Detector
{
    public static class Builder
    {

        private final Context mContext;
        private int zzaVG;
        private boolean zzaVH;
        private int zzaVI;
        private boolean zzaVJ;
        private int zzagr;

        public FaceDetector build()
        {
            FaceSettingsParcel facesettingsparcel = new FaceSettingsParcel();
            facesettingsparcel.mode = zzagr;
            facesettingsparcel.zzaVQ = zzaVG;
            facesettingsparcel.zzaVR = zzaVI;
            facesettingsparcel.zzaVS = zzaVH;
            facesettingsparcel.zzaVT = zzaVJ;
            return new FaceDetector(new zzg(mContext, facesettingsparcel));
        }

        public Builder setClassificationType(int i)
        {
            if (i != 0 && i != 1)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid classification type: ").append(i).toString());
            } else
            {
                zzaVI = i;
                return this;
            }
        }

        public Builder setLandmarkType(int i)
        {
            if (i != 0 && i != 1)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid landmark type: ").append(i).toString());
            } else
            {
                zzaVG = i;
                return this;
            }
        }

        public Builder setMode(int i)
        {
            switch (i)
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid mode: ").append(i).toString());

            case 0: // '\0'
            case 1: // '\001'
                zzagr = i;
                break;
            }
            return this;
        }

        public Builder setProminentFaceOnly(boolean flag)
        {
            zzaVH = flag;
            return this;
        }

        public Builder setTrackingEnabled(boolean flag)
        {
            zzaVJ = flag;
            return this;
        }

        public Builder(Context context)
        {
            zzaVG = 0;
            zzaVH = false;
            zzaVI = 0;
            zzaVJ = true;
            zzagr = 0;
            mContext = context;
        }
    }


    public static final int ACCURATE_MODE = 1;
    public static final int ALL_CLASSIFICATIONS = 1;
    public static final int ALL_LANDMARKS = 1;
    public static final int FAST_MODE = 0;
    public static final int NO_CLASSIFICATIONS = 0;
    public static final int NO_LANDMARKS = 0;
    private final zza zzaVD;
    private final zzg zzaVE;
    private boolean zzaVF;
    private final Object zzpc;

    private FaceDetector()
    {
        zzaVD = new zza();
        zzpc = new Object();
        zzaVF = true;
        throw new IllegalStateException("Default constructor called");
    }

    private FaceDetector(zzg zzg1)
    {
        zzaVD = new zza();
        zzpc = new Object();
        zzaVF = true;
        zzaVE = zzg1;
    }


    public SparseArray detect(Frame frame)
    {
        java.nio.ByteBuffer bytebuffer;
        if (frame == null)
        {
            throw new IllegalArgumentException("No frame supplied.");
        }
        bytebuffer = frame.getGrayscaleImageData();
        Object obj = zzpc;
        obj;
        JVM INSTR monitorenter ;
        if (!zzaVF)
        {
            throw new RuntimeException("Cannot use detector after release()");
        }
        break MISSING_BLOCK_LABEL_48;
        frame;
        obj;
        JVM INSTR monitorexit ;
        throw frame;
        frame = zzaVE.zzb(bytebuffer, FrameMetadataParcel.zzc(frame));
        obj;
        JVM INSTR monitorexit ;
        HashSet hashset = new HashSet();
        SparseArray sparsearray = new SparseArray(frame.length);
        int j1 = frame.length;
        int j = 0;
        int i = 0;
        for (; j < j1; j++)
        {
            Face face = frame[j];
            int l = face.getId();
            int i1 = Math.max(i, l);
            int k = l;
            i = i1;
            if (hashset.contains(Integer.valueOf(l)))
            {
                k = i1 + 1;
                i = k;
            }
            hashset.add(Integer.valueOf(k));
            sparsearray.append(zzaVD.zzjo(k), face);
        }

        return sparsearray;
    }

    protected void finalize()
        throws Throwable
    {
        synchronized (zzpc)
        {
            if (zzaVF)
            {
                Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                release();
            }
        }
        super.finalize();
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public boolean isOperational()
    {
        return zzaVE.isOperational();
    }

    public void release()
    {
label0:
        {
            synchronized (zzpc)
            {
                if (zzaVF)
                {
                    break label0;
                }
            }
            return;
        }
        zzaVE.zzCf();
        zzaVF = false;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean setFocus(int i)
    {
        i = zzaVD.zzjp(i);
        Object obj = zzpc;
        obj;
        JVM INSTR monitorenter ;
        if (!zzaVF)
        {
            throw new RuntimeException("Cannot use detector after release()");
        }
        break MISSING_BLOCK_LABEL_38;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        boolean flag = zzaVE.zzjG(i);
        obj;
        JVM INSTR monitorexit ;
        return flag;
    }
}
