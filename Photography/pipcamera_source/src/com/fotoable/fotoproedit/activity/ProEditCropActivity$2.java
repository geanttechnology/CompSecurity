// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.View;
import com.fotoable.fotoproedit.activity.crop.CropImageView;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditCropActivity

class a
    implements android.view.roEditCropActivity._cls2
{

    final ProEditCropActivity a;

    public void onClick(View view)
    {
        if (ProEditCropActivity.b(a) == 0)
        {
            return;
        } else
        {
            ProEditCropActivity.a(a, 0);
            ProEditCropActivity.a(a, ProEditCropActivity.c(a));
            a.a.setVisibility(0);
            return;
        }
    }

    (ProEditCropActivity proeditcropactivity)
    {
        a = proeditcropactivity;
        super();
    }
}
