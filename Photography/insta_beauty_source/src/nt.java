// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapEditItem;
import java.util.ArrayList;

class nt
    implements Runnable
{

    final ns a;

    nt(ns ns1)
    {
        a = ns1;
        super();
    }

    public void run()
    {
        ActivityCameraNoRealtime.n(a.b);
        Log.e(ActivityCameraNoRealtime.b(), "saveInstaBeautySrcBitmapAsync finished");
        if (ActivityCameraNoRealtime.q(a.b) == 0)
        {
            ActivityCameraNoRealtime.d(a.b).setVisibility(0);
        }
        ActivityCameraNoRealtime.r(a.b);
        ActivityCameraNoRealtime.s(a.b).setText(String.valueOf(ActivityCameraNoRealtime.q(a.b)));
        contiCapEditItem conticapedititem = new contiCapEditItem();
        conticapedititem.urlStr = a.a;
        conticapedititem.isFrontFace = qd.c(a.b.c);
        ActivityCameraNoRealtime.b(a.b).add(conticapedititem);
        if (a.b.a != null)
        {
            a.b.a.startPreview();
            ActivityCameraNoRealtime.n(a.b);
            return;
        } else
        {
            a.b.finish();
            return;
        }
    }
}
