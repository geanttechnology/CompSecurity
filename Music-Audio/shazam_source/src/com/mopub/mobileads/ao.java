// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.m;
import com.mopub.mobileads.b.f;

// Referenced classes of package com.mopub.mobileads:
//            v, an, am, al

public final class ao extends v
{

    private final an c;

    public ao(an an1, Handler handler)
    {
        super(handler);
        m.a(handler);
        m.a(an1);
        c = an1;
    }

    public final void a()
    {
        an an1 = c;
        boolean flag;
        if (an1.v)
        {
            Object obj = an1.j;
            int i = an1.q;
            int j = an1.e.getCurrentPosition();
            if (j >= ((al) (obj)).b)
            {
                if (i - j < 0)
                {
                    ((al) (obj)).setVisibility(8);
                } else
                {
                    f f1 = ((al) (obj)).a;
                    f1.b = (int)Math.round(Math.ceil((float)(long)(f1.a - j) / 1000F));
                    f1.c = (360F * (float)j) / (float)f1.a;
                    f1.invalidateSelf();
                    obj.b = j;
                }
            }
        }
        obj = c;
        if (!((an) (obj)).r && ((an) (obj)).e.getCurrentPosition() >= ((an) (obj)).q)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            c.i();
        }
    }
}
