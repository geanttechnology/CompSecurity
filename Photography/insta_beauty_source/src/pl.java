// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityMediaPlayerTest;
import java.io.File;

public class pl
    implements android.view.View.OnClickListener
{

    final ActivityMediaPlayerTest a;

    public pl(ActivityMediaPlayerTest activitymediaplayertest)
    {
        a = activitymediaplayertest;
        super();
    }

    public void onClick(View view)
    {
        view = new File(ActivityMediaPlayerTest.c(a));
        a.a(view);
        sm.a(ActivityMediaPlayerTest.c(a), a);
        a.finish();
    }
}
