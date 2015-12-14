// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.View;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class lz
    implements android.view.View.OnClickListener
{

    final ActivityCameraNew a;

    public lz(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onClick(View view)
    {
        Log.e(ActivityCameraNew.i(a), "changeRecordStateListener");
    }
}
