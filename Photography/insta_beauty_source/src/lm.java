// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class lm
    implements android.view.View.OnClickListener
{

    final ActivityCameraNew a;

    public lm(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onClick(View view)
    {
        int i = ActivityCameraNew.p(a).getBottom();
        view = new rb(a, new ln(this));
        boolean flag = pt.b(pt.i, a, false);
        boolean flag1 = pt.b(pt.j, a, false);
        boolean flag2 = pt.b(pt.e, a, true);
        boolean flag3 = pt.b(pt.g, a, true);
        boolean flag4 = pt.b(pt.f, a, true);
        view.a(pt.b(pt.t, a, false), flag, flag1, flag2, flag3, flag4, ActivityCameraNew.r(a));
        view.a(0, i);
    }
}
