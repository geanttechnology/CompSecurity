// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import com.fotoable.beautyui.newui.MNewFindFaceFragment;
import com.instabeauty.application.InstaBeautyApplication;

public class tv
    implements android.view.View.OnClickListener
{

    final MNewFindFaceFragment a;

    public tv(MNewFindFaceFragment mnewfindfacefragment)
    {
        a = mnewfindfacefragment;
        super();
    }

    public void onClick(View view)
    {
        if (MNewFindFaceFragment.f(a).isSelected())
        {
            MNewFindFaceFragment.f(a).setSelected(false);
            MNewFindFaceFragment.f(a).setBackgroundResource(0x7f02043d);
            view = new TranslateAnimation(0, 0.0F, 0, -yp.a(InstaBeautyApplication.a, 100F), 0, 0.0F, 0, 0.0F);
            view.setDuration(300L);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
            layoutparams.leftMargin = -yp.a(InstaBeautyApplication.a, 100F);
            layoutparams.topMargin = a.getResources().getDisplayMetrics().heightPixels - yp.a(InstaBeautyApplication.a, 190F);
            layoutparams.gravity = 51;
            MNewFindFaceFragment.g(a).setLayoutParams(layoutparams);
            MNewFindFaceFragment.g(a).startAnimation(view);
            return;
        } else
        {
            MNewFindFaceFragment.f(a).setSelected(true);
            MNewFindFaceFragment.f(a).setBackgroundResource(0x7f02043e);
            view = new TranslateAnimation(0, -yp.a(InstaBeautyApplication.a, 100F), 0, 0.0F, 0, 0.0F, 0, 0.0F);
            view.setDuration(300L);
            android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(-2, -2);
            layoutparams1.leftMargin = 0;
            layoutparams1.topMargin = a.getResources().getDisplayMetrics().heightPixels - yp.a(InstaBeautyApplication.a, 190F);
            layoutparams1.gravity = 51;
            MNewFindFaceFragment.g(a).setLayoutParams(layoutparams1);
            MNewFindFaceFragment.g(a).startAnimation(view);
            return;
        }
    }
}
