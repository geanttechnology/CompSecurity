// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.newui.FotoBeautySimpleActivity;

public class ta
    implements Runnable
{

    final FotoBeautySimpleActivity a;

    public ta(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        a = fotobeautysimpleactivity;
        super();
    }

    public void run()
    {
        if (FotoBeautySimpleActivity.f(a) != null && !FotoBeautySimpleActivity.f(a).c())
        {
            return;
        }
        try
        {
            FotoBeautySimpleActivity.g(a).b(a.getAssets(), FotoBeautySimpleActivity.d(a));
            FotoBeautySimpleActivity.h(a);
            if (a != null)
            {
                a.runOnUiThread(new tb(this));
                return;
            }
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            exception.printStackTrace();
        }
        return;
    }
}
