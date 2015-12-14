// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.activity.ProEditCropActivity;
import com.fotoable.fotoproedit.activity.crop.CropImageView;

public class afi
    implements android.view.View.OnClickListener
{

    final ProEditCropActivity a;

    public afi(ProEditCropActivity proeditcropactivity)
    {
        a = proeditcropactivity;
        super();
    }

    public void onClick(View view)
    {
        if (ProEditCropActivity.d(a) == 2)
        {
            return;
        } else
        {
            ProEditCropActivity.a(a, 2);
            ProEditCropActivity.a(a, ProEditCropActivity.h(a), true);
            a.a.setVisibility(4);
            return;
        }
    }
}
