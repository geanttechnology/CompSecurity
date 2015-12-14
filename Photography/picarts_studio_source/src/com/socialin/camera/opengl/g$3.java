// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.socialin.camera.opengl:
//            g, a

final class a
    implements Runnable
{

    private g a;

    public final void run()
    {
        String s = com.socialin.camera.opengl.a.c(a.e).getString(0x7f0801bc);
        ((TextView)a.d.findViewById(0x7f1004a7)).setText((new StringBuilder()).append(s).append(" : ").append(a.b).toString());
        ((SeekBar)a.d.findViewById(0x7f1004a8)).setProgress((int)a.b);
        ((RadioButton)a.d.findViewById(0x7f1004a5)).setChecked(true);
    }

    (g g1)
    {
        a = g1;
        super();
    }
}
