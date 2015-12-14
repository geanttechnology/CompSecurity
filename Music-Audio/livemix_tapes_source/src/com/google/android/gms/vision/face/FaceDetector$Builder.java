// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.face;

import android.content.Context;
import com.google.android.gms.vision.face.internal.client.FaceSettingsParcel;
import com.google.android.gms.vision.face.internal.client.zzg;

// Referenced classes of package com.google.android.gms.vision.face:
//            FaceDetector

public static class mContext
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
        return new FaceDetector(new zzg(mContext, facesettingsparcel), null);
    }

    public ettingsParcel setClassificationType(int i)
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

    public zzaVI setLandmarkType(int i)
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

    public zzaVG setMode(int i)
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

    public zzagr setProminentFaceOnly(boolean flag)
    {
        zzaVH = flag;
        return this;
    }

    public zzaVH setTrackingEnabled(boolean flag)
    {
        zzaVJ = flag;
        return this;
    }

    public ettingsParcel(Context context)
    {
        zzaVG = 0;
        zzaVH = false;
        zzaVI = 0;
        zzaVJ = true;
        zzagr = 0;
        mContext = context;
    }
}
