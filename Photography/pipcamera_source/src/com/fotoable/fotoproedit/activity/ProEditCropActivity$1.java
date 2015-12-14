// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.widget.SeekBar;
import com.fotoable.fotoproedit.activity.crop.CropMaskView;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditCropActivity

class a
    implements android.widget.eListener
{

    final ProEditCropActivity a;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        float f = (float)(i - 50) / 100F;
        ProEditCropActivity.a(a, (int)(f * 90F));
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        ProEditCropActivity.a(a).setVisibility(0);
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        ProEditCropActivity.a(a).setVisibility(4);
    }

    (ProEditCropActivity proeditcropactivity)
    {
        a = proeditcropactivity;
        super();
    }
}
