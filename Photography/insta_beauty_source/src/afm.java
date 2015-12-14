// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;
import com.wantu.imagerender.ImageGLSurfaceView;

public class afm
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final ProEditFilterActivity a;

    public afm(ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }

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
}
