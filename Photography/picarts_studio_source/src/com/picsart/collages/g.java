// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.picsart.collages:
//            e

public class g
{

    e a;

    g(e e1)
    {
        a = e1;
        super();
    }

    public void a(float f)
    {
        e.i(a).setText(String.valueOf(Math.round((e.h(a) / f) * 100F)));
        e.j(a).setProgress(Math.round((e.h(a) / f) * 100F));
    }
}
