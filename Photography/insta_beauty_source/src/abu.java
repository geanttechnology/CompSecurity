// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.fotoable.fotobeauty.NewPhotoShareActivity;

public class abu
    implements Runnable
{

    final NewPhotoShareActivity a;

    public abu(NewPhotoShareActivity newphotoshareactivity)
    {
        a = newphotoshareactivity;
        super();
    }

    public void run()
    {
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -NewPhotoShareActivity.f(a).getHeight());
        translateanimation.setInterpolator(new DecelerateInterpolator());
        translateanimation.setDuration(300L);
        translateanimation.setFillAfter(true);
        NewPhotoShareActivity.f(a).startAnimation(translateanimation);
    }
}
