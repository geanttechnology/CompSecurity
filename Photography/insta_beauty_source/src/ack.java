// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import com.fotoable.fotobeauty.SplashScreenActivity;

public class ack
    implements Runnable
{

    final boolean a;
    final SharedPreferences b;
    final SplashScreenActivity c;

    public ack(SplashScreenActivity splashscreenactivity, boolean flag, SharedPreferences sharedpreferences)
    {
        c = splashscreenactivity;
        a = flag;
        b = sharedpreferences;
        super();
    }

    public void run()
    {
        if (!apq.b())
        {
            c.b();
            return;
        }
        if (a)
        {
            android.content.SharedPreferences.Editor editor = b.edit();
            editor.putBoolean((new StringBuilder()).append("isGotoGuideView_").append(apq.a).toString(), false);
            editor.apply();
            c.a();
            return;
        } else
        {
            c.b();
            return;
        }
    }
}
