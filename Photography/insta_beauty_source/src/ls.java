// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.FrameLayout;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

class ls
    implements Runnable
{

    final lr a;

    ls(lr lr1)
    {
        a = lr1;
        super();
    }

    public void run()
    {
        ActivityCameraNew.B(a.a.a).setVisibility(4);
    }
}
