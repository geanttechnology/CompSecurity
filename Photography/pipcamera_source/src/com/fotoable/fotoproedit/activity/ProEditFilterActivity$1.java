// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.widget.SeekBar;
import com.wantu.imagerender.ImageGLSurfaceView;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFilterActivity

public class a
    implements android.widget.istener
{

    final ProEditFilterActivity a;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (ProEditFilterActivity.a(a) != null)
        {
            ProEditFilterActivity.a(a).setOpacity((float)i / 100F);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    (ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }
}
