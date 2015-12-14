// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;
import android.util.Log;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import java.util.Iterator;
import java.util.List;
import jp.co.cyberagent.android.gpuimage.Rotation;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class mj
    implements or
{

    final boolean a;
    final ActivityCameraNew b;

    public mj(ActivityCameraNew activitycameranew, boolean flag)
    {
        b = activitycameranew;
        a = flag;
        super();
    }

    public void a()
    {
        if (b.k.getCamera() != null)
        {
            b.k.restartCamera();
        }
    }

    public void a(int i)
    {
        Rotation rotation;
        ActivityCameraNew.W(b).setVisibility(4);
        if (a)
        {
            i = (b.a() + pt.b(pt.k, b, 0) + i % 360) % 360;
        } else
        {
            i = (b.a() + pt.b(pt.l, b, 0) + i) % 360;
        }
        b.g = i % 360;
        rotation = Rotation.NORMAL;
        b.g;
        JVM INSTR lookupswitch 3: default 104
    //                   90: 150
    //                   180: 157
    //                   270: 164;
           goto _L1 _L2 _L3 _L4
_L1:
        b.k.setRotation(rotation, a, false);
        return;
_L2:
        rotation = Rotation.ROTATION_90;
        continue; /* Loop/switch isn't completed */
_L3:
        rotation = Rotation.ROTATION_180;
        continue; /* Loop/switch isn't completed */
_L4:
        rotation = Rotation.ROTATION_270;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void b(int i)
    {
        android.hardware.Camera.Size size;
        Object obj;
        Camera camera;
        android.hardware.Camera.Parameters parameters;
        Iterator iterator;
        int j;
        if (a)
        {
            i = (pt.b(pt.k, b, 0) + i % 360) % 360;
            pt.a(pt.k, b, i);
            Log.d(ActivityCameraNew.i(b), (new StringBuilder()).append("activitycameranew displayRotation front:").append(i).toString());
        } else
        {
            i = (pt.b(pt.l, b, 0) + i) % 360;
            pt.a(pt.l, b, i);
            Log.d(ActivityCameraNew.i(b), (new StringBuilder()).append("activitycameranew displayRotation back:").append(i).toString());
        }
        camera = b.k.getCamera();
        parameters = camera.getParameters();
        obj = parameters.getSupportedPictureSizes();
        i = 0x7fffffff;
        size = (android.hardware.Camera.Size)((List) (obj)).get(0);
        iterator = ((List) (obj)).iterator();
_L1:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_227;
        }
        obj = (android.hardware.Camera.Size)iterator.next();
        j = ((android.hardware.Camera.Size) (obj)).width;
        if (j < i && i > 650)
        {
            i = j;
            size = ((android.hardware.Camera.Size) (obj));
        }
          goto _L1
        try
        {
            parameters.setPictureSize(size.width, size.height);
            camera.setParameters(parameters);
            camera.setPreviewCallback(null);
            ActivityCameraNew.X(b).b();
            camera.takePicture(null, null, new mk(this, camera));
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        ActivityCameraNew.X(b).b();
        return;
    }
}
