// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.SeekBar;
import com.fotoable.fotoproedit.activity.ProEditCropActivity;
import com.fotoable.fotoproedit.activity.crop.CropImageView;

public class afh
    implements android.view.View.OnClickListener
{

    final ProEditCropActivity a;

    public afh(ProEditCropActivity proeditcropactivity)
    {
        a = proeditcropactivity;
        super();
    }

    public void onClick(View view)
    {
        if (ProEditCropActivity.d(a) == 1)
        {
            return;
        } else
        {
            ProEditCropActivity.a(a, 1);
            ProEditCropActivity.a(a, ProEditCropActivity.f(a), true);
            a.a.setVisibility(4);
            ProEditCropActivity.g(a).setProgress(50);
            return;
        }
    }
}
