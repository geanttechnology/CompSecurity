// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapturePhotoEditActivity1;

public class ny
    implements android.view.View.OnClickListener
{

    final ActivityCameraNoRealtime a;

    public ny(ActivityCameraNoRealtime activitycameranorealtime)
    {
        a = activitycameranorealtime;
        super();
    }

    public void onClick(View view)
    {
        FlurryAgent.logEvent("camera_nextstep_click");
        ActivityCameraNoRealtime.a(a).getBackground().setColorFilter(a.getResources().getColor(0x7f0c000f), android.graphics.PorterDuff.Mode.SRC_IN);
        if (pt.b(pt.c, a, false))
        {
            Toast.makeText(a, 0x7f0601f0, 0).show();
        }
        view = new Intent(a, com/fotoable/beautyui/gpuimage/sample/activity/contiCapturePhotoEditActivity1);
        view.putExtra(contiCapturePhotoEditActivity1.A, ActivityCameraNoRealtime.b(a));
        view.putExtra(contiCapturePhotoEditActivity1.B, false);
        a.startActivity(view);
        (new Handler()).postDelayed(new nz(this), 1000L);
    }
}
