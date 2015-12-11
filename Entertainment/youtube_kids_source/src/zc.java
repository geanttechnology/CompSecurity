// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.apps.youtube.kids.activities.SplashScreenActivity;
import com.google.android.apps.youtube.kids.application.KidsApplication;

public final class zc
    implements Runnable
{

    private SplashScreenActivity a;

    public zc(SplashScreenActivity splashscreenactivity)
    {
        a = splashscreenactivity;
        super();
    }

    public final void run()
    {
        SplashScreenActivity.a(a, new wg(((KidsApplication)a.getApplicationContext()).h().E(), SplashScreenActivity.c(a)));
        SplashScreenActivity.d(a).a(SplashScreenActivity.d(a).a(null));
    }
}
