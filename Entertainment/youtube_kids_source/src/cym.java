// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;

public final class cym
{

    final cyn a;
    public final bmi b;
    public int c;
    private final Handler d;
    private final cyo e = new cyo(this);

    public cym(cyn cyn1, bmi bmi1, Handler handler)
    {
        a = (cyn)b.a(cyn1);
        b = (bmi)b.a(bmi1);
        d = (Handler)b.a(handler);
    }

    public final void a()
    {
        d.removeCallbacks(e);
    }

    public void a(int i)
    {
label0:
        {
            d.removeCallbacks(e);
            if (i != -1)
            {
                i -= (int)(b.b() - (long)c);
                if (i <= 0)
                {
                    break label0;
                }
                d.postDelayed(e, i);
            }
            return;
        }
        d.post(e);
    }
}
