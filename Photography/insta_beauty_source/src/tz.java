// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;
import com.fotoable.beautyui.newui.MNewProEditScrollView;

public class tz
    implements android.view.View.OnClickListener
{

    final MNewFotoBeautyActivity a;

    public tz(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        a = mnewfotobeautyactivity;
        super();
    }

    public void onClick(View view)
    {
        MNewFotoBeautyActivity.a(a).setBackgroundColor(a.getResources().getColor(0x7f0c001a));
        MNewFotoBeautyActivity.b(a).setBackgroundColor(a.getResources().getColor(0x7f0c00a6));
        if (!a.j)
        {
            view = AnimationUtils.loadAnimation(a, 0x7f04001d);
            android.view.animation.Animation animation = AnimationUtils.loadAnimation(a, 0x7f04001e);
            MNewFotoBeautyActivity.c(a).setVisibility(0);
            MNewFotoBeautyActivity.c(a).startAnimation(view);
            MNewFotoBeautyActivity.d(a).setVisibility(4);
            MNewFotoBeautyActivity.d(a).startAnimation(animation);
            MNewFotoBeautyActivity.a(a).setTextColor(a.getResources().getColor(0x7f0c009d));
            MNewFotoBeautyActivity.b(a).setTextColor(a.getResources().getColor(0x7f0c002d));
            a.j = true;
        }
    }
}
