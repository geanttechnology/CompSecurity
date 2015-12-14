// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;
import java.util.ArrayList;

class ku
    implements Runnable
{

    final kt a;

    ku(kt kt1)
    {
        a = kt1;
        super();
    }

    public void run()
    {
        if (!ActivityCamera.f(a.a))
        {
            ActivityCamera.a(a.a, 0);
            ActivityCamera.e(a.a).clear();
            a.a.runOnUiThread(new kv(this));
        }
    }
}
