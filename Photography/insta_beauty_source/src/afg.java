// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.activity.ProEditCropActivity;
import com.fotoable.fotoproedit.activity.crop.CropImageView;

public class afg
    implements android.view.View.OnClickListener
{

    final ProEditCropActivity a;

    public afg(ProEditCropActivity proeditcropactivity)
    {
        a = proeditcropactivity;
        super();
    }

    public void onClick(View view)
    {
        if (ProEditCropActivity.d(a) == 0)
        {
            return;
        } else
        {
            ProEditCropActivity.a(a, 0);
            ProEditCropActivity.a(a, ProEditCropActivity.e(a), true);
            a.a.setVisibility(0);
            return;
        }
    }
}
