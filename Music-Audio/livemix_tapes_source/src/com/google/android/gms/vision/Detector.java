// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;

import android.util.SparseArray;

// Referenced classes of package com.google.android.gms.vision:
//            Frame

public abstract class Detector
{
    public static class Detections
    {

        private SparseArray zzaUX;
        private Frame.Metadata zzaUY;
        private boolean zzaUZ;

        public boolean detectorIsOperational()
        {
            return zzaUZ;
        }

        public SparseArray getDetectedItems()
        {
            return zzaUX;
        }

        public Frame.Metadata getFrameMetadata()
        {
            return zzaUY;
        }

        public Detections(SparseArray sparsearray, Frame.Metadata metadata, boolean flag)
        {
            zzaUX = sparsearray;
            zzaUY = metadata;
            zzaUZ = flag;
        }
    }

    public static interface Processor
    {

        public abstract void receiveDetections(Detections detections);

        public abstract void release();
    }


    private Object zzaUV;
    private Processor zzaUW;

    public Detector()
    {
        zzaUV = new Object();
    }

    public abstract SparseArray detect(Frame frame);

    public boolean isOperational()
    {
        return true;
    }

    public void receiveFrame(Frame frame)
    {
        Object obj = zzaUV;
        obj;
        JVM INSTR monitorenter ;
        if (zzaUW == null)
        {
            throw new IllegalStateException("Detector processor must first be set with setProcessor in order to receive detection results.");
        }
        break MISSING_BLOCK_LABEL_29;
        frame;
        obj;
        JVM INSTR monitorexit ;
        throw frame;
        Frame.Metadata metadata = new Frame.Metadata(frame.getMetadata());
        metadata.zzCd();
        frame = new Detections(detect(frame), metadata, isOperational());
        zzaUW.receiveDetections(frame);
        obj;
        JVM INSTR monitorexit ;
    }

    public void release()
    {
        synchronized (zzaUV)
        {
            if (zzaUW != null)
            {
                zzaUW.release();
                zzaUW = null;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean setFocus(int i)
    {
        return true;
    }

    public void setProcessor(Processor processor)
    {
        zzaUW = processor;
    }
}
