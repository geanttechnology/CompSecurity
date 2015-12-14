// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.socialin.camera.opengl:
//            d, a

final class a
    implements Runnable
{

    private d a;

    public final void run()
    {
        String s = com.socialin.camera.opengl.a.c(a.d).getString(0x7f0801bc);
        ((TextView)a.b.findViewById(0x7f100400)).setText((new StringBuilder()).append(s).append(" : ").append(a.c).toString());
        ((SeekBar)a.b.findViewById(0x7f100401)).setProgress((int)a.c);
    }

    (d d1)
    {
        a = d1;
        super();
    }
}
