// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.PointF;
import android.util.Log;
import com.fotoable.sketch.activity.TTieZhiActivity;

class aux
    implements Runnable
{

    final auw a;

    aux(auw auw1)
    {
        a = auw1;
        super();
    }

    public void run()
    {
        ig ig1 = new ig();
        ig1.a(a.a.getAssets(), a.a.h);
        if (ig1.c())
        {
            adh adh1 = new adh();
            ig1.a(adh1, 0);
            if (a.a.s == null)
            {
                a.a.s = new awl();
            }
            a.a.s.a = new PointF(adh1.b().b(), adh1.b().c());
            a.a.s.b = new PointF(adh1.c().b(), adh1.c().c());
            a.a.s.c = new PointF(adh1.d().b(), adh1.d().c());
            a.a.s.d = new PointF(adh1.e().b(), adh1.e().c());
            a.a.s.e = new PointF(adh1.f().b(), adh1.f().c());
            a.a.s.f = new PointF(adh1.g().b(), adh1.g().c());
            a.a.s.h = new PointF(adh1.h().b(), adh1.h().c());
        } else
        {
            Log.e("Face Detect", "this picture has no face!");
        }
        a.a.runOnUiThread(new auy(this));
    }
}
