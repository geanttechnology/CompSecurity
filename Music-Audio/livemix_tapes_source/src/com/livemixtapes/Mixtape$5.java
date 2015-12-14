// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.livemixtapes:
//            Mixtape

class init> extends CountDownTimer
{

    final Mixtape this$0;

    public void onFinish()
    {
    }

    public void onTick(long l)
    {
        Mixtape.access$2(l / 0x5265c00L);
        Mixtape.access$4(l / 0x36ee80L - Mixtape.access$3() * 24L);
        Mixtape.access$6(l / 60000L - Mixtape.access$5() * 60L - Mixtape.access$3() * 24L * 60L);
        Mixtape.access$8(l / 1000L - Mixtape.access$7() * 60L - Mixtape.access$5() * 60L * 60L - Mixtape.access$3() * 24L * 60L * 60L);
        Log.v("COUNTER", (new StringBuilder("DAYS: ")).append(Long.toString(Mixtape.access$3())).toString());
        Log.v("COUNTER", (new StringBuilder("HOURS: ")).append(Long.toString(Mixtape.access$5())).toString());
        Log.v("COUNTER", (new StringBuilder("MINUTES: ")).append(Long.toString(Mixtape.access$7())).toString());
        Log.v("COUNTER", (new StringBuilder("SECONDS: ")).append(Long.toString(Mixtape.access$9())).toString());
        if (Mixtape.access$3() != Mixtape.access$10())
        {
            Mixtape.access$11(Mixtape.this, (TextView)rootView.findViewById(0x7f0800a5));
            Mixtape.access$12(Mixtape.this).setText((new StringBuilder(String.valueOf(Long.toString(Mixtape.access$3())))).toString());
            Mixtape.access$13(Mixtape.access$3());
        }
        if (Mixtape.access$5() != Mixtape.access$14())
        {
            Mixtape.access$11(Mixtape.this, (TextView)rootView.findViewById(0x7f0800a6));
            Mixtape.access$12(Mixtape.this).setText((new StringBuilder(String.valueOf(Long.toString(Mixtape.access$5())))).toString());
            Mixtape.access$15(Mixtape.access$5());
        }
        if (Mixtape.access$7() != Mixtape.access$16())
        {
            Mixtape.access$11(Mixtape.this, (TextView)rootView.findViewById(0x7f0800a7));
            Mixtape.access$12(Mixtape.this).setText((new StringBuilder(String.valueOf(Long.toString(Mixtape.access$7())))).toString());
            Mixtape.access$17(Mixtape.access$7());
        }
        if (Mixtape.access$9() != Mixtape.access$18())
        {
            Mixtape.access$11(Mixtape.this, (TextView)rootView.findViewById(0x7f0800a8));
            Mixtape.access$12(Mixtape.this).setText((new StringBuilder(String.valueOf(Long.toString(Mixtape.access$9())))).toString());
            Mixtape.access$19(Mixtape.access$9());
        }
    }

    (long l, long l1)
    {
        this$0 = Mixtape.this;
        super(l, l1);
    }
}
