// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;
import com.fotoable.fotoproedit.activity.ProEditCropActivity;
import com.fotoable.fotoproedit.activity.crop.CropMaskView;

public class aff
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final ProEditCropActivity a;

    public aff(ProEditCropActivity proeditcropactivity)
    {
        a = proeditcropactivity;
        super();
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        float f = (float)(i - 50) / 100F;
        ProEditCropActivity.a(a, (int)(f * 90F));
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        ProEditCropActivity.c(a).setVisibility(0);
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        ProEditCropActivity.c(a).setVisibility(4);
    }
}
