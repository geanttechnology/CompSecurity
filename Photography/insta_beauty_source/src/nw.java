// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;
import android.widget.ImageView;
import android.widget.Toast;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;
import java.util.Iterator;
import java.util.List;

public class nw
    implements or
{

    final ActivityCameraNoRealtime a;

    public nw(ActivityCameraNoRealtime activitycameranorealtime)
    {
        a = activitycameranorealtime;
        super();
    }

    public void a()
    {
        ActivityCameraNoRealtime.u(a).a(a.a);
    }

    public void a(int i)
    {
        ActivityCameraNoRealtime.t(a).setVisibility(4);
        if (ActivityCameraNoRealtime.a(a.c))
        {
            i = a.b(a.c) + pt.b(pt.k, a, 0) + i;
        } else
        {
            i = a.b(a.c) + pt.b(pt.l, a, 0) + i;
        }
        a.h = i % 360;
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            try
            {
                a.a.setDisplayOrientation(a.h);
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            return;
        }
        a.a.stopPreview();
        try
        {
            a.a.setDisplayOrientation(a.h);
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
        }
        a.a.startPreview();
    }

    public void b(int i)
    {
        if (qd.c(a.c))
        {
            pt.a(pt.k, a, (pt.b(pt.k, a, 0) + i % 360) % 360);
        } else
        {
            pt.a(pt.l, a, (pt.b(pt.l, a, 0) + i % 360) % 360);
        }
        if (a.a == null)
        {
            a.f.b();
            Toast.makeText(a, "sorry...", 0).show();
        } else
        {
            android.hardware.Camera.Parameters parameters;
            try
            {
                parameters = a.a.getParameters();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                parameters = null;
            }
            if (parameters == null)
            {
                a.f.b();
                return;
            }
            List list = parameters.getSupportedPictureSizes();
            if (list != null)
            {
                android.hardware.Camera.Size size = (android.hardware.Camera.Size)list.get(0);
                Iterator iterator = list.iterator();
                i = 0x7fffffff;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    android.hardware.Camera.Size size1 = (android.hardware.Camera.Size)iterator.next();
                    int j = size1.width;
                    if (j < i && i > 650)
                    {
                        i = j;
                        size = size1;
                    }
                } while (true);
                parameters.setPictureSize(size.width, size.height);
                a.a.setParameters(parameters);
                a.a.setPreviewCallback(null);
                a.f.b();
                a.a.takePicture(null, null, new nx(this));
                return;
            }
        }
    }
}
