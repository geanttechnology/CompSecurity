// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import aaj;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.flurry.android.FlurryAgent;
import com.fotoable.fotobeauty.FullscreenActivity;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;
import ra;

// Referenced classes of package com.fotoable.beautyui.gpuimage.sample.activity:
//            ActivityCameraNew, ActivityCamera

public class Third2CameraActivity extends FullscreenActivity
{

    public static String a = "capture_state";
    public static String b = "StartCameraFromShortCut";
    public static String c = "StartCameraFromThree";
    private boolean d;
    private Uri e;
    private boolean f;
    private int g;

    public Third2CameraActivity()
    {
        d = true;
        e = null;
        f = false;
        g = 1000;
    }

    private void a(int i)
    {
        Intent intent = new Intent(this, com/fotoable/beautyui/gpuimage/sample/activity/ActivityCameraNew);
        intent.putExtra(a, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_TAKE_PHOTO);
        intent.putExtra(c, d);
        if (e != null)
        {
            intent.putExtra("output", e);
            intent.putExtra("output", e);
        }
        startActivityForResult(intent, i);
    }

    private void b(int i)
    {
        Intent intent = new Intent(this, com/fotoable/beautyui/gpuimage/sample/activity/ActivityCamera);
        intent.putExtra(ActivityCamera.a, true);
        intent.putExtra(c, d);
        if (e != null)
        {
            intent.putExtra("output", e);
            intent.putExtra("output", e);
        }
        startActivityForResult(intent, i);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        setResult(j, intent);
        runOnUiThread(new ra(this));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent().getExtras();
        jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState enumcameracapturestate = jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_TAKE_PHOTO;
        if (bundle != null)
        {
            jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState enumcameracapturestate1;
            if (bundle.get(a) != null)
            {
                enumcameracapturestate1 = (jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState)bundle.get(a);
            }
            f = bundle.getBoolean(b, false);
            if (f)
            {
                FlurryAgent.logEvent("camera_start_from_shortcut");
            }
            e = (Uri)bundle.getParcelable("output");
            if (e != null)
            {
                FlurryAgent.logEvent("camera_start_from_three");
            }
        }
        boolean flag1 = aaj.f();
        boolean flag = true;
        try
        {
            new BeautyCameraGLSurfaceView(this);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            flag = false;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            flag = false;
        }
        if (flag1 && flag)
        {
            a(g);
            return;
        } else
        {
            b(g);
            return;
        }
    }

}
