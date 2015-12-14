// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;

class li
    implements Runnable
{

    final lg a;

    li(lg lg1)
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
        Toast.makeText(a.b.a.getApplicationContext(), 0x7f060195, 0).show();
    }
}
