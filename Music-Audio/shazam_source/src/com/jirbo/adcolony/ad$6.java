// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.widget.MediaController;

// Referenced classes of package com.jirbo.adcolony:
//            ad

final class a
    implements android.view.ceHolder.Callback
{

    final ad a;

    public final void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        boolean flag = true;
        a.k = j;
        a.l = k;
        if (a.f == 3)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (a.i == j && a.j == k)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        if (a.h != null && i != 0 && j != 0)
        {
            if (a.r != 0)
            {
                a.seekTo(a.r);
            }
            a.start();
            if (a.m != null)
            {
                a.m.show();
            }
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceholder)
    {
        a.g = surfaceholder;
        if (a.h == null || a.e != 6 || a.f != 7)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        a.h.setDisplay(a.g);
        surfaceholder = a;
        if (((ad) (surfaceholder)).g != null || ((ad) (surfaceholder)).e != 6) goto _L2; else goto _L1
_L1:
        surfaceholder.f = 7;
_L4:
        return;
_L2:
        if (((ad) (surfaceholder)).h != null && ((ad) (surfaceholder)).e == 6)
        {
            ((ad) (surfaceholder)).h.start();
            surfaceholder.e = ((ad) (surfaceholder)).w;
            surfaceholder.f = ((ad) (surfaceholder)).w;
            return;
        }
        if (((ad) (surfaceholder)).e != 8) goto _L4; else goto _L3
_L3:
        surfaceholder.c();
        return;
        ad.a(a);
        return;
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        a.g = null;
        if (a.m != null)
        {
            a.m.hide();
        }
        if (a.e != 6)
        {
            ad.b(a);
        }
    }

    er(ad ad1)
    {
        a = ad1;
        super();
    }
}
