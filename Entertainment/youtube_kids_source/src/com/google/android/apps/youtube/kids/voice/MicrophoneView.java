// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.voice;

import agl;
import agm;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

// Referenced classes of package com.google.android.apps.youtube.kids.voice:
//            BitmapSoundLevelsView

public class MicrophoneView extends RelativeLayout
{

    public BitmapSoundLevelsView a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private Animation f;
    private int g;

    public MicrophoneView(Context context)
    {
        super(context);
    }

    public MicrophoneView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public MicrophoneView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public static ImageView a(MicrophoneView microphoneview)
    {
        return microphoneview.e;
    }

    private static void a(View view, int i)
    {
        view.setAlpha(0.0F);
        view.animate().alpha(1.0F).setDuration(i).start();
    }

    private static void b(View view, int i)
    {
        view.setAlpha(1.0F);
        view.animate().alpha(0.0F).setDuration(536L).start();
    }

    public static void b(MicrophoneView microphoneview)
    {
        microphoneview.e();
    }

    private void e()
    {
        if (e.getVisibility() == 8)
        {
            return;
        } else
        {
            e.setAnimation(f);
            f.start();
            return;
        }
    }

    private void f()
    {
        agm.a[g - 1];
        JVM INSTR tableswitch 1 5: default 44
    //                   1 45
    //                   2 118
    //                   3 193
    //                   4 266
    //                   5 359;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        b.setVisibility(0);
        d.setVisibility(0);
        c.setVisibility(8);
        e.setVisibility(8);
        if (f != null)
        {
            f.cancel();
            f.reset();
        }
        a.setEnabled(false);
        a.setVisibility(8);
        return;
_L3:
        b.setVisibility(0);
        d.setVisibility(0);
        a.setEnabled(true);
        a.setVisibility(0);
        e.setVisibility(0);
        e();
        a(a, 218);
        a(b, 218);
        a(d, 218);
        return;
_L4:
        b.setVisibility(0);
        d.setVisibility(0);
        a.setEnabled(true);
        a.setVisibility(0);
        e.setVisibility(0);
        e();
        c.setVisibility(0);
        b(d, 536);
        a(c, 536);
        return;
_L5:
        b(c, 536);
        a(d, 536);
        b.setVisibility(0);
        c.setVisibility(8);
        d.setVisibility(0);
        a.setEnabled(false);
        a.setVisibility(8);
        e.setVisibility(8);
        if (f != null)
        {
            f.cancel();
            f.reset();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        b.setVisibility(0);
        c.setVisibility(0);
        a.setEnabled(false);
        a.setVisibility(0);
        e.setVisibility(0);
        e.setVisibility(8);
        if (f != null)
        {
            f.cancel();
            f.reset();
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    public final void a()
    {
        g = 4;
        f();
    }

    public final void b()
    {
        g = 3;
        f();
    }

    public final void c()
    {
        g = 1;
        f();
    }

    public final void d()
    {
        g = 5;
        f();
    }

    public void onFinishInflate()
    {
        a = (BitmapSoundLevelsView)findViewById(0x7f1001c4);
        b = (ImageView)findViewById(0x7f1001c8);
        c = (ImageView)findViewById(0x7f1001c7);
        d = (ImageView)findViewById(0x7f1001c6);
        e = (ImageView)findViewById(0x7f1001c5);
        f = AnimationUtils.loadAnimation(getContext(), 0x7f050013);
        f.setAnimationListener(new agl(this));
    }

    static 
    {
        com/google/android/apps/youtube/kids/voice/MicrophoneView.getSimpleName();
    }
}
