// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.view.View;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import com.wantu.activity.photoselector.SinglePhotoSelectorActivity;

public class mq
    implements android.view.View.OnClickListener
{

    final ActivityCameraNew a;

    public mq(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onClick(View view)
    {
        view = new Intent(a, com/wantu/activity/photoselector/SinglePhotoSelectorActivity);
        a.startActivityForResult(view, 1243);
    }
}
