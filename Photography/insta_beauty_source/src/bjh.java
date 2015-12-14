// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ViewTreeObserver;
import android.widget.Button;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.activity.photoselector.InstaRandomPhotoSelectorActivity;

public class bjh
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final Button a;
    final InstaRandomPhotoSelectorActivity b;

    public bjh(InstaRandomPhotoSelectorActivity instarandomphotoselectoractivity, Button button)
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
            android.view.ViewGroup.LayoutParams layoutparams = a.getLayoutParams();
            if (layoutparams != null)
            {
                layoutparams.height = axw.a(InstaBeautyApplication.a().b(), 45F);
                layoutparams.width = axw.a(InstaBeautyApplication.a().b(), 45F);
                a.setLayoutParams(layoutparams);
            }
        }
    }
}
