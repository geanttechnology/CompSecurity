// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;

public class ui
    implements Runnable
{

    final MNewFotoBeautyActivity a;

    public ui(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        a = mnewfotobeautyactivity;
        super();
    }

    public void run()
    {
        if (MNewFotoBeautyActivity.r(a) != null)
        {
            MNewFotoBeautyActivity.r(a).b(true);
            MNewFotoBeautyActivity.r(a).b(a.getAssets(), MNewFotoBeautyActivity.f(a));
        }
        a.runOnUiThread(new uj(this));
    }
}
