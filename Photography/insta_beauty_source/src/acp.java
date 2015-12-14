// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.gpuimage.sample.activity.fotobeautySettingActivity;
import com.fotoable.fotobeauty.WantuActivity;

public class acp
    implements android.view.View.OnClickListener
{

    final WantuActivity a;

    public acp(WantuActivity wantuactivity)
    {
        a = wantuactivity;
        super();
    }

    public void onClick(View view)
    {
        view = new Intent(a, com/fotoable/beautyui/gpuimage/sample/activity/fotobeautySettingActivity);
        a.startActivity(view);
        FlurryAgent.logEvent("HomeButton_Setting");
        Log.d(WantuActivity.a, "HomeButton_Setting");
    }
}
