// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.PendingIntent;
import java.util.List;

final class axb
    implements Runnable
{

    private final int a;
    private final avq b;
    private awy c;

    public axb(awy awy1, int i, avq avq1)
    {
        c = awy1;
        super();
        a = i;
        b = avq1;
    }

    public final void run()
    {
        if (b.a())
        {
            try
            {
                int i = ((j) (c)).w.b.c().indexOf(c);
                avq avq1 = b;
                m m1 = ((j) (c)).w;
                if (avq1.a())
                {
                    m1.startIntentSenderForResult(avq1.b.getIntentSender(), (i + 1 << 16) + 1, null, 0, 0, 0);
                }
                return;
            }
            catch (android.content.IntentSender.SendIntentException sendintentexception)
            {
                awy.a(c);
            }
            return;
        }
        if (avw.a(b.c))
        {
            avw.a(b.c, ((j) (c)).w, c, 2, c);
            return;
        } else
        {
            awy.a(c, a, b);
            return;
        }
    }
}
