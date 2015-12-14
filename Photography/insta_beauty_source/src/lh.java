// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapEditItem;
import java.util.ArrayList;

class lh
    implements Runnable
{

    final lg a;

    lh(lg lg1)
    {
        a = lg1;
        super();
    }

    public void run()
    {
        ActivityCamera.w(a.b.a).setEnabled(true);
        ActivityCamera.d(a.b.a).setEnabled(true);
        ActivityCamera.i(a.b.a).setEnabled(true);
        ActivityCamera.c(a.b.a, false);
        if (ActivityCamera.x(a.b.a) == 0)
        {
            ActivityCamera.g(a.b.a).setVisibility(0);
        }
        ActivityCamera.y(a.b.a);
        ActivityCamera.z(a.b.a).setText(String.valueOf(ActivityCamera.x(a.b.a)));
        contiCapEditItem conticapedititem = new contiCapEditItem();
        conticapedititem.urlStr = a.a;
        conticapedititem.isFrontFace = qd.c(ActivityCamera.c(a.b.a).a);
        conticapedititem.softLevel = (float)ActivityCamera.A(a.b.a).getProgress() / 100F;
        ActivityCamera.e(a.b.a).add(conticapedititem);
    }
}
