// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;

public class us
    implements Runnable
{

    final MNewFotoBeautyActivity a;

    public us(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        a = mnewfotobeautyactivity;
        super();
    }

    public void run()
    {
        MNewFotoBeautyActivity.r(a).a(a.getAssets(), MNewFotoBeautyActivity.q(a));
        if (MNewFotoBeautyActivity.r(a).a() > 0)
        {
            MNewFotoBeautyActivity.r(a).a(0);
        }
        SharedPreferences sharedpreferences = a.getSharedPreferences("setting", 0);
        sharedpreferences.edit();
        boolean flag = sharedpreferences.getBoolean("isfastphone", false);
        MNewFotoBeautyActivity.r(a).a(flag);
        MNewFotoBeautyActivity.a(a, true);
        a.runOnUiThread(new ut(this));
    }
}
