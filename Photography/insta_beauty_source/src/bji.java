// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ViewTreeObserver;
import android.widget.Button;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.activity.photoselector.InstaRandomPhotoSelectorActivity;

public class bji
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final Button a;
    final InstaRandomPhotoSelectorActivity b;

    public bji(InstaRandomPhotoSelectorActivity instarandomphotoselectoractivity, Button button)
    {
        b = instarandomphotoselectoractivity;
        a = button;
        super();
    }

    public void onGlobalLayout()
    {
        a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (a != null)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)a.getLayoutParams();
            if (layoutparams != null)
            {
                layoutparams.height = axw.a(InstaBeautyApplication.a().b(), 33F);
                layoutparams.width = axw.a(InstaBeautyApplication.a().b(), 59F);
                layoutparams.topMargin = yp.a(InstaBeautyApplication.a, 7F);
                layoutparams.bottomMargin = yp.a(InstaBeautyApplication.a, 7F);
                a.setLayoutParams(layoutparams);
            }
        }
    }
}
