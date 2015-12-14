// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.FrameLayout;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;

class kv
    implements Runnable
{

    final ku a;

    kv(ku ku1)
    {
        a = ku1;
        super();
    }

    public void run()
    {
        ActivityCamera.g(a.a.a).setVisibility(4);
    }
}
