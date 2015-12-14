// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.CompoundButton;
import com.fotoable.sketch.activity.TTieZhiActivity;
import com.instabeauty.application.InstaBeautyApplication;

public class avy
    implements android.widget.CompoundButton.OnCheckedChangeListener
{

    final TTieZhiActivity a;

    public avy(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            aqx.b(InstaBeautyApplication.a, "TTieZhiActivity", "TAG_BACKTIP", true);
            return;
        } else
        {
            aqx.b(InstaBeautyApplication.a, "TTieZhiActivity", "TAG_BACKTIP", false);
            return;
        }
    }
}
