// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.PointF;
import android.util.Log;
import com.fotoable.sketch.activity.TTieZhiActivity;

public class avt
    implements Runnable
{

    final TTieZhiActivity a;

    public avt(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }

    public void run()
    {
        a.h = a.b();
        if (a.h == null);
        ig ig1 = new ig();
        ig1.a(a.getAssets(), a.h);
        if (ig1.c())
        {
            adh adh1 = new adh();
            ig1.a(adh1, 0);
            if (a.s == null)
            {
                a.s = new awl();
            }
            a.s.a = new PointF(adh1.b().b(), adh1.b().c());
            a.s.b = new PointF(adh1.c().b(), adh1.c().c());
            a.s.c = new PointF(adh1.d().b(), adh1.d().c());
            a.s.d = new PointF(adh1.e().b(), adh1.e().c());
            a.s.e = new PointF(adh1.f().b(), adh1.f().c());
            a.s.f = new PointF(adh1.g().b(), adh1.g().c());
            a.s.h = new PointF(adh1.h().b(), adh1.h().c());
        } else
        {
            Log.e("Face Detect", "this picture has no face!");
        }
        a.runOnUiThread(new avu(this));
    }
}
