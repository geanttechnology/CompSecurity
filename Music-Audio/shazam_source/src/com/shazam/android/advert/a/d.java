// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.a;

import android.media.MediaPlayer;
import android.view.Surface;
import com.jirbo.adcolony.aj;
import com.jirbo.adcolony.l;
import com.jirbo.adcolony.n;
import com.jirbo.adcolony.q;
import java.util.ArrayList;

// Referenced classes of package com.shazam.android.advert.a:
//            b

public final class d
    implements b
{

    private final n a;

    public d(n n1)
    {
        a = n1;
    }

    public final n a()
    {
        return a;
    }

    public final boolean b()
    {
        n n1 = a;
        return n1.D.b() && n1.n && !n1.y;
    }

    public final void c()
    {
        n n1 = a;
        aj.c.b("[ADC] Native Ad Destroy called.");
        if (n1.T != null)
        {
            n1.T.release();
        }
        if (n1.S != null)
        {
            n1.S.release();
        }
        n1.S = null;
        q.X.remove(n1);
    }
}
