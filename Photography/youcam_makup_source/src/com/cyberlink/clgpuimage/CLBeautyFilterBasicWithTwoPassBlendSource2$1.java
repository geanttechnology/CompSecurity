// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;


// Referenced classes of package com.cyberlink.clgpuimage:
//            CLBeautyFilterBasicWithTwoPassBlendSource2

class b
    implements Runnable
{

    final float a;
    final float b;
    final CLBeautyFilterBasicWithTwoPassBlendSource2 c;

    public void run()
    {
        c.a(CLBeautyFilterBasicWithTwoPassBlendSource2.a(c), new float[] {
            0.0F, a / (float)c.c
        });
        c.a(CLBeautyFilterBasicWithTwoPassBlendSource2.b(c), new float[] {
            0.0F, b / (float)c.c
        });
    }

    (CLBeautyFilterBasicWithTwoPassBlendSource2 clbeautyfilterbasicwithtwopassblendsource2, float f, float f1)
    {
        c = clbeautyfilterbasicwithtwopassblendsource2;
        a = f;
        b = f1;
        super();
    }
}
