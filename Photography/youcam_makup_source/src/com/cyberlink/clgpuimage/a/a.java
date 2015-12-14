// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage.a;

import com.cyberlink.clgpuimage.Rotation;

public class a
{

    public static final float a[] = {
        0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F
    };
    public static final float b[] = {
        1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F
    };
    public static final float c[] = {
        1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F
    };
    public static final float d[] = {
        0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F
    };

    private static float a(float f)
    {
        float f1 = 0.0F;
        if (f == 0.0F)
        {
            f1 = 1.0F;
        }
        return f1;
    }

    public static float[] a(Rotation rotation, boolean flag, boolean flag1)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[Rotation.values().length];
                try
                {
                    a[Rotation.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[Rotation.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[Rotation.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Rotation.a.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[rotation.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 188
    //                   2 195
    //                   3 202;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_202;
_L1:
        rotation = a;
_L5:
        if (flag)
        {
            float af[] = new float[8];
            af[0] = a(rotation[0]);
            af[1] = rotation[1];
            af[2] = a(rotation[2]);
            af[3] = rotation[3];
            af[4] = a(rotation[4]);
            af[5] = rotation[5];
            af[6] = a(rotation[6]);
            af[7] = rotation[7];
            rotation = af;
        }
        if (flag1)
        {
            return (new float[] {
                rotation[0], a(rotation[1]), rotation[2], a(rotation[3]), rotation[4], a(rotation[5]), rotation[6], a(rotation[7])
            });
        } else
        {
            return rotation;
        }
_L2:
        rotation = b;
          goto _L5
_L3:
        rotation = c;
          goto _L5
        rotation = d;
          goto _L5
    }

}
