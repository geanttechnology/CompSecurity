// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.fotobeautySettingActivity;

public class sf
    implements android.view.View.OnClickListener
{

    final fotobeautySettingActivity a;

    public sf(fotobeautySettingActivity fotobeautysettingactivity)
    {
        a = fotobeautysettingactivity;
        super();
    }

    public void onClick(View view)
    {
        fotobeautySettingActivity.a(a).getBackground().setAlpha(255);
        a.finish();
    }
}
