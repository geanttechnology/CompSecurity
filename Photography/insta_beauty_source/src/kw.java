// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;

public class kw
    implements android.view.View.OnClickListener
{

    final ActivityCamera a;

    public kw(ActivityCamera activitycamera)
    {
        a = activitycamera;
        super();
    }

    public void onClick(View view)
    {
        a.finish();
    }
}
