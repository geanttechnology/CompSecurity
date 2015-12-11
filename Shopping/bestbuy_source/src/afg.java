// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.PendingIntent;
import android.util.Log;

final class afg extends ada
{

    final afd b;
    private final int c;
    private final String d[];
    private final PendingIntent e;
    private final int f;

    public afg(afd afd, int i, aih aih1, int j, PendingIntent pendingintent)
    {
        boolean flag = true;
        b = afd;
        super(afd, aih1);
        if (i != 1)
        {
            flag = false;
        }
        acu.a(flag);
        f = i;
        c = aia.a(j);
        e = pendingintent;
        d = null;
    }

    public afg(afd afd, int i, aih aih1, int j, String as[])
    {
        b = afd;
        super(afd, aih1);
        boolean flag;
        if (i == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        acu.a(flag);
        f = i;
        c = aia.a(j);
        d = as;
        e = null;
    }

    protected void a()
    {
    }

    protected void a(aih aih1)
    {
label0:
        {
label1:
            {
                if (aih1 != null)
                {
                    switch (f)
                    {
                    default:
                        Log.wtf("LocationClientImpl", (new StringBuilder()).append("Unsupported action: ").append(f).toString());
                        break;

                    case 1: // '\001'
                        break label1;

                    case 2: // '\002'
                        break label0;
                    }
                }
                return;
            }
            aih1.a(c, e);
            return;
        }
        aih1.a(c, d);
    }

    protected void a(Object obj)
    {
        a((aih)obj);
    }
}
