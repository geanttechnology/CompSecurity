// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.fotoable.beautyui.gpuimage.sample.activity.fotobeautySettingActivity;

public class sh
    implements sr
{

    final fotobeautySettingActivity a;

    public sh(fotobeautySettingActivity fotobeautysettingactivity)
    {
        a = fotobeautysettingactivity;
        super();
    }

    public void a(boolean flag, String s)
    {
        if (!flag && s == pt.d)
        {
            s = Toast.makeText(a, 0x7f060278, 0);
            s.setGravity(48, 0, a.getResources().getDisplayMetrics().heightPixels / 3);
            s.show();
        }
    }
}
