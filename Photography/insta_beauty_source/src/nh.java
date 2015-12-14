// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class nh
    implements android.view.View.OnClickListener
{

    final ActivityCameraNew a;

    public nh(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onClick(View view)
    {
        boolean flag;
        if (ActivityCameraNew.j(a))
        {
            ActivityCameraNew.k(a);
            ActivityCameraNew.l(a).getBackground().clearColorFilter();
        } else
        {
            ActivityCameraNew.m(a);
            ActivityCameraNew.l(a).getBackground().setColorFilter(a.getResources().getColor(0x7f0c009d), android.graphics.PorterDuff.Mode.SRC_IN);
        }
        view = a;
        if (!ActivityCameraNew.j(a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ActivityCameraNew.c(view, flag);
    }
}
