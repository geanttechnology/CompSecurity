// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;

public final class sf
{

    final bje a;
    rx b;
    int c;
    private final int d;
    private final Handler e = new Handler(Looper.getMainLooper());
    private final Runnable f = new sg(this);

    public sf(bje bje1, int i)
    {
        a = (bje)b.a(bje1);
        d = i;
    }

    private void handleVideoStageEvent(ctd ctd1)
    {
        if (ctd1.b == ctt.i)
        {
            c = 0;
        }
    }

    public final void handlePlaybackServiceException(cse cse1)
    {
        if (b != null)
        {
            Object obj = b;
            if (((rx) (obj)).g == null)
            {
                obj = uc.a;
            } else
            {
                obj = ((rx) (obj)).g.f_();
            }
            if (((uc) (obj)).a() && cse1.a.a(new csf[] {
    csf.c, csf.b, csf.e, csf.f, csf.k, csf.i
}) && c < d)
            {
                e.post(f);
                c = c + 1;
            }
        }
    }
}
