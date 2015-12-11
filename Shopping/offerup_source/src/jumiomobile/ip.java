// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.CountDownTimer;

// Referenced classes of package jumiomobile:
//            in, na

public class ip extends CountDownTimer
{

    final in a;

    public ip(in in1, long l, long l1)
    {
        a = in1;
        super(l, l1);
    }

    public void onFinish()
    {
        in.q(a).a(0, 0);
        in.r(a);
    }

    public void onTick(long l)
    {
        float f = 100F;
        float f1 = ((float)((5000L - l) + 200L) * 100F) / 5000F;
        if (f1 <= 100F)
        {
            f = f1;
        }
        in.q(a).a(100 - (int)f, Math.round((float)l / 1000F));
    }
}
