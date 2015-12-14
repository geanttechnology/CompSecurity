// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.fotobeautySettingActivity;

public class sg
    implements android.view.View.OnTouchListener
{

    final fotobeautySettingActivity a;

    public sg(fotobeautySettingActivity fotobeautysettingactivity)
    {
        a = fotobeautysettingactivity;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 4: default 40
    //                   0 61
    //                   1 97
    //                   2 79
    //                   3 40
    //                   4 42;
           goto _L1 _L2 _L3 _L4 _L1 _L5
_L1:
        return false;
_L5:
        fotobeautySettingActivity.a(a).getBackground().setAlpha(255);
        continue; /* Loop/switch isn't completed */
_L2:
        fotobeautySettingActivity.a(a).getBackground().setAlpha(100);
        continue; /* Loop/switch isn't completed */
_L4:
        fotobeautySettingActivity.a(a).getBackground().setAlpha(100);
        continue; /* Loop/switch isn't completed */
_L3:
        fotobeautySettingActivity.a(a).getBackground().setAlpha(255);
        if (true) goto _L1; else goto _L6
_L6:
    }
}
