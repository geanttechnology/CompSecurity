// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import java.util.ArrayList;

class lr
    implements Runnable
{

    final lq a;

    lr(lq lq1)
    {
        a = lq1;
        super();
    }

    public void run()
    {
        if (!ActivityCameraNew.r(a.a))
        {
            ActivityCameraNew.e(a.a, 0);
            ActivityCameraNew.A(a.a).clear();
            a.a.runOnUiThread(new ls(this));
        }
    }
}
