// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.face;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.gms.vision.face:
//            Landmark

public class Face
{

    public static final float UNCOMPUTED_PROBABILITY = -1F;
    private int mId;
    private float zzaHe;
    private float zzaHf;
    private float zzaVA;
    private float zzaVB;
    private float zzaVC;
    private PointF zzaVw;
    private float zzaVx;
    private float zzaVy;
    private List zzaVz;

    public Face(int i, PointF pointf, float f, float f1, float f2, float f3, Landmark alandmark[], 
            float f4, float f5, float f6)
    {
        mId = i;
        zzaVw = pointf;
        zzaHe = f;
        zzaHf = f1;
        zzaVx = f2;
        zzaVy = f3;
        zzaVz = Arrays.asList(alandmark);
        if (f4 >= 0.0F && f4 <= 1.0F)
        {
            zzaVA = f4;
        } else
        {
            zzaVA = -1F;
        }
        if (f5 >= 0.0F && f5 <= 1.0F)
        {
            zzaVB = f5;
        } else
        {
            zzaVB = -1F;
        }
        if (zzaVC >= 0.0F && zzaVC <= 1.0F)
        {
            zzaVC = f6;
            return;
        } else
        {
            zzaVC = -1F;
            return;
        }
    }

    public float getEulerY()
    {
        return zzaVx;
    }

    public float getEulerZ()
    {
        return zzaVy;
    }

    public float getHeight()
    {
        return zzaHf;
    }

    public int getId()
    {
        return mId;
    }

    public float getIsLeftEyeOpenProbability()
    {
        return zzaVA;
    }

    public float getIsRightEyeOpenProbability()
    {
        return zzaVB;
    }

    public float getIsSmilingProbability()
    {
        return zzaVC;
    }

    public List getLandmarks()
    {
        return zzaVz;
    }

    public PointF getPosition()
    {
        return new PointF(zzaVw.x - zzaHe / 2.0F, zzaVw.y - zzaHf / 2.0F);
    }

    public float getWidth()
    {
        return zzaHe;
    }
}
