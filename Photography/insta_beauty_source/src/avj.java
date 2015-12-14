// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.fotoable.sketch.activity.TTieZhiActivity;

public class avj
    implements Runnable
{

    final avz a;
    final android.widget.LinearLayout.LayoutParams b;
    final TTieZhiActivity c;

    public avj(TTieZhiActivity ttiezhiactivity, avz avz1, android.widget.LinearLayout.LayoutParams layoutparams)
    {
        c = ttiezhiactivity;
        a = avz1;
        b = layoutparams;
        super();
    }

    public void run()
    {
        android.view.animation.Animation animation = AnimationUtils.loadAnimation(c, 0x7f04003f);
        c.r.addView(a, b);
        a.startAnimation(animation);
    }
}
