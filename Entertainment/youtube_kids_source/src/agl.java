// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.widget.ImageView;
import com.google.android.apps.youtube.kids.voice.MicrophoneView;

public final class agl
    implements android.view.animation.Animation.AnimationListener
{

    private MicrophoneView a;

    public agl(MicrophoneView microphoneview)
    {
        a = microphoneview;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        MicrophoneView.a(a).setAlpha(0.0F);
        MicrophoneView.b(a);
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
        MicrophoneView.a(a).setAlpha(1.0F);
    }
}
