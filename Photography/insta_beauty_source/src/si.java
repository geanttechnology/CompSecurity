// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.fotoable.beautyui.gpuimage.sample.activity.fotobeautySettingActivity;

public class si
    implements sr
{

    final fotobeautySettingActivity a;

    public si(fotobeautySettingActivity fotobeautysettingactivity)
    {
        a = fotobeautysettingactivity;
        super();
    }

    public void a(boolean flag, String s)
    {
        if (flag && s == pt.h)
        {
            s = (new android.app.AlertDialog.Builder(a)).create();
            s.setCanceledOnTouchOutside(false);
            s.show();
            View view = LayoutInflater.from(a).inflate(0x7f03006c, null);
            ((TextView)view.findViewById(0x7f0d0034)).setText(0x7f0601d5);
            ((TextView)view.findViewById(0x7f0d01b4)).setText(0x7f0601d4);
            ((Button)view.findViewById(0x7f0d01b5)).setOnClickListener(new sj(this, s));
            s.setContentView(view);
        }
    }
}
