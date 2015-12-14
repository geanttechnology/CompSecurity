// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.gms.vision.face.internal.client:
//            zzf, FaceParcel, LandmarkParcel, zzc, 
//            FaceSettingsParcel

public class zzg
{

    private final Context mContext;
    private final FaceSettingsParcel zzaVV;
    private zzc zzaVW;
    private boolean zzaVX;
    private final Object zzpc = new Object();

    public zzg(Context context, FaceSettingsParcel facesettingsparcel)
    {
        zzaVW = null;
        zzaVX = false;
        mContext = context;
        zzaVV = facesettingsparcel;
        zzCg();
    }

    private zzc zzCg()
    {
label0:
        {
            zzc zzc1;
            synchronized (zzpc)
            {
                if (zzaVW == null)
                {
                    break label0;
                }
                zzc1 = zzaVW;
            }
            return zzc1;
        }
        zzaVW = zzf.zza(mContext, zzaVV);
        if (zzaVX || zzaVW != null) goto _L2; else goto _L1
_L1:
        Log.w("FaceDetectorHandle", "Native face detector not yet available.  Reverting to no-op detection.");
        zzaVX = true;
_L4:
        zzc zzc2 = zzaVW;
        obj;
        JVM INSTR monitorexit ;
        return zzc2;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if (!zzaVX || zzaVW == null) goto _L4; else goto _L3
_L3:
        Log.w("FaceDetectorHandle", "Native face detector is now available.");
          goto _L4
    }

    private Face zza(FaceParcel faceparcel)
    {
        return new Face(faceparcel.id, new PointF(faceparcel.centerX, faceparcel.centerY), faceparcel.width, faceparcel.height, faceparcel.zzaVK, faceparcel.zzaVL, zzb(faceparcel), faceparcel.zzaVN, faceparcel.zzaVO, faceparcel.zzaVP);
    }

    private Landmark zza(LandmarkParcel landmarkparcel)
    {
        return new Landmark(new PointF(landmarkparcel.x, landmarkparcel.y), landmarkparcel.type);
    }

    private Landmark[] zzb(FaceParcel faceparcel)
    {
        int i = 0;
        faceparcel = faceparcel.zzaVM;
        if (faceparcel == null)
        {
            return new Landmark[0];
        }
        Landmark alandmark[] = new Landmark[faceparcel.length];
        for (; i < faceparcel.length; i++)
        {
            alandmark[i] = zza(faceparcel[i]);
        }

        return alandmark;
    }

    public boolean isOperational()
    {
        return zzCg() != null;
    }

    public void zzCf()
    {
label0:
        {
            synchronized (zzpc)
            {
                if (zzaVW != null)
                {
                    break label0;
                }
            }
            return;
        }
        zzaVW.zzCf();
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        RemoteException remoteexception;
        remoteexception;
        Log.e("FaceDetectorHandle", "Could not finalize native face detector", remoteexception);
          goto _L1
    }

    public Face[] zzb(ByteBuffer bytebuffer, FrameMetadataParcel framemetadataparcel)
    {
        int i = 0;
        zzc zzc1 = zzCg();
        if (zzc1 == null)
        {
            return new Face[0];
        }
        try
        {
            bytebuffer = zzc1.zzc(zze.zzx(bytebuffer), framemetadataparcel);
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            Log.e("FaceDetectorHandle", "Could not call native face detector", bytebuffer);
            return new Face[0];
        }
        framemetadataparcel = new Face[bytebuffer.length];
        for (; i < bytebuffer.length; i++)
        {
            framemetadataparcel[i] = zza(bytebuffer[i]);
        }

        return framemetadataparcel;
    }

    public boolean zzjG(int i)
    {
        zzc zzc1 = zzCg();
        if (zzc1 == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = zzc1.zzjG(i);
        }
        catch (RemoteException remoteexception)
        {
            Log.e("FaceDetectorHandle", "Could not call native face detector", remoteexception);
            return false;
        }
        return flag;
    }
}
