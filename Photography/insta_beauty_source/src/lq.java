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
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapturePhotoEditActivity1;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class lq
    implements android.view.View.OnClickListener
{

    final ActivityCameraNew a;

    public lq(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onClick(View view)
    {
        ActivityCameraNew.z(a).getBackground().setColorFilter(a.getResources().getColor(0x7f0c000f), android.graphics.PorterDuff.Mode.SRC_IN);
        if (pt.b(pt.c, a, false))
        {
            Toast.makeText(a, 0x7f0601f0, 0).show();
        }
        view = new Intent(a, com/fotoable/beautyui/gpuimage/sample/activity/contiCapturePhotoEditActivity1);
        view.putExtra(contiCapturePhotoEditActivity1.A, ActivityCameraNew.A(a));
        view.putExtra(contiCapturePhotoEditActivity1.B, true);
        view.putExtra(contiCapturePhotoEditActivity1.C, (float)a.k.getTakePicSize().width / (float)a.k.getTakePicSize().height);
        a.startActivity(view);
        (new Handler()).postDelayed(new lr(this), 1000L);
    }
}
