// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.widget.MediaController;

// Referenced classes of package com.jirbo.adcolony:
//            bf

class a
    implements android.view.ceHolder.Callback
{

    final bf a;

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
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

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        a.g = surfaceholder;
        if (a.h != null && a.e == 6 && a.f == 7)
        {
            a.h.setDisplay(a.g);
            a.c();
            return;
        } else
        {
            bf.a(a);
            return;
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        a.g = null;
        if (a.m != null)
        {
            a.m.hide();
        }
        if (a.e != 6)
        {
            bf.a(a, true);
        }
    }

    er(bf bf1)
    {
        a = bf1;
        super();
    }
}
