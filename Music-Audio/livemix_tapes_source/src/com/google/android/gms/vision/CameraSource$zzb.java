// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;

import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.images.Size;
import java.nio.ByteBuffer;
import java.util.Map;

// Referenced classes of package com.google.android.gms.vision:
//            CameraSource, Detector

private class zzaUK
    implements Runnable
{

    static final boolean $assertionsDisabled;
    private long zzMS;
    private Detector zzaUK;
    final CameraSource zzaUM;
    private boolean zzaUN;
    private long zzaUO;
    private int zzaUP;
    private ByteBuffer zzaUQ;
    private final Object zzpc = new Object();

    void release()
    {
        if (!$assertionsDisabled && CameraSource.zzd(zzaUM).getState() != INATED)
        {
            throw new AssertionError();
        } else
        {
            zzaUK.release();
            zzaUK = null;
            return;
        }
    }

    public void run()
    {
_L1:
        Object obj = zzpc;
        obj;
        JVM INSTR monitorenter ;
        ByteBuffer bytebuffer;
        if (!zzaUN)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        bytebuffer = zzaUQ;
        if (bytebuffer != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        zzpc.wait();
        if (zzaUN)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj2;
        obj2;
        Log.d("CameraSource", "Frame processing loop terminated.", ((Throwable) (obj2)));
        obj;
        JVM INSTR monitorexit ;
        return;
        obj2;
        obj;
        JVM INSTR monitorexit ;
        throw obj2;
        Frame frame;
        frame = (new it>()).ImageData(zzaUQ, CameraSource.zzg(zzaUM).getWidth(), CameraSource.zzg(zzaUM).getHeight(), 17).Id(zzaUP).TimestampMillis(zzaUO).Rotation(CameraSource.zzf(zzaUM)).ld();
        obj2 = zzaUQ;
        zzaUQ = null;
        obj;
        JVM INSTR monitorexit ;
        zzaUK.receiveFrame(frame);
        CameraSource.zzb(zzaUM).addCallbackBuffer(((ByteBuffer) (obj2)).array());
          goto _L1
        Object obj1;
        obj1;
        Log.e("CameraSource", "Exception thrown from receiver.", ((Throwable) (obj1)));
        CameraSource.zzb(zzaUM).addCallbackBuffer(((ByteBuffer) (obj2)).array());
          goto _L1
        obj1;
        CameraSource.zzb(zzaUM).addCallbackBuffer(((ByteBuffer) (obj2)).array());
        throw obj1;
    }

    void setActive(boolean flag)
    {
        synchronized (zzpc)
        {
            zzaUN = flag;
            zzpc.notifyAll();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void zza(byte abyte0[], Camera camera)
    {
        synchronized (zzpc)
        {
            if (zzaUQ != null)
            {
                camera.addCallbackBuffer(zzaUQ.array());
                zzaUQ = null;
            }
            zzaUO = SystemClock.elapsedRealtime() - zzMS;
            zzaUP = zzaUP + 1;
            zzaUQ = (ByteBuffer)CameraSource.zze(zzaUM).get(abyte0);
            zzpc.notifyAll();
        }
        return;
        abyte0;
        obj;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    static 
    {
        boolean flag;
        if (!com/google/android/gms/vision/CameraSource.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

    (CameraSource camerasource, Detector detector)
    {
        zzaUM = camerasource;
        super();
        zzMS = SystemClock.elapsedRealtime();
        zzaUN = true;
        zzaUP = 0;
        zzaUK = detector;
    }
}
