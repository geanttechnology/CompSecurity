// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.view.View;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityMediaPlayerTest;

public class pm
    implements android.view.View.OnClickListener
{

    final ActivityMediaPlayerTest a;

    public pm(ActivityMediaPlayerTest activitymediaplayertest)
    {
        a = activitymediaplayertest;
        super();
    }

    public void onClick(View view)
    {
        if (ActivityMediaPlayerTest.d(a) != null)
        {
            ActivityMediaPlayerTest.d(a).dismiss();
            ActivityMediaPlayerTest.a(a, null);
        }
    }
}
