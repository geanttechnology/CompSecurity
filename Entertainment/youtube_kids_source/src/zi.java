// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import com.google.android.apps.youtube.kids.activities.SplashScreenActivity;

public final class zi
    implements android.content.DialogInterface.OnCancelListener
{

    private SplashScreenActivity a;

    public zi(SplashScreenActivity splashscreenactivity)
    {
        a = splashscreenactivity;
        super();
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.finish();
    }
}
