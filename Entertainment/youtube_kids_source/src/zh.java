// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.apps.youtube.kids.activities.SplashScreenActivity;

final class zh
    implements Runnable
{

    private zg a;

    zh(zg zg1)
    {
        a = zg1;
        super();
    }

    public final void run()
    {
        SplashScreenActivity.f(a.a);
    }
}
