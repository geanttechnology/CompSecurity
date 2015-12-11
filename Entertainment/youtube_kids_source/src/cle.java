// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;

final class cle extends cld
{

    final clb a;
    private int b;

    cle(clb clb1)
    {
        a = clb1;
        super(clb1);
    }

    public final boolean handleMessage(Message message)
    {
        if (!a.d) goto _L2; else goto _L1
_L1:
        if (message.what == 8 || message.what == 4)
        {
            a.o();
            return super.handleMessage(message);
        }
        if (message.what != 10) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        j = a.a.h();
        i = a.b.h();
        j -= i;
        if (j <= 50) goto _L6; else goto _L5
_L5:
        bmo.d((new StringBuilder(39)).append("Foreground sync is ahead by ").append(j).toString());
        b = 0;
        a.a.e();
        (new Handler()).postDelayed(new clf(this), j);
_L4:
        return true;
_L6:
        if (j < -50)
        {
            int k = b;
            b = k + 1;
            if (k < 2)
            {
                j = b;
                bmo.d((new StringBuilder(56)).append("Foreground sync is behind. Retry seek ahead: ").append(j).toString());
                a.a.b(i + 4000);
                continue; /* Loop/switch isn't completed */
            }
        }
        i = b;
        bmo.d((new StringBuilder(67)).append("Foreground synced with time diff: ").append(j).append(", retries: ").append(i).toString());
        b = 0;
        a.o();
        if (true) goto _L4; else goto _L2
_L2:
        return super.handleMessage(message);
    }
}
