// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;
import java.util.Iterator;
import java.util.List;
import jp.co.cyberagent.android.gpuimage.GPUImage;

public class la
    implements or
{

    final ActivityCamera a;

    public la(ActivityCamera activitycamera)
    {
        a = activitycamera;
        super();
    }

    public void a(int i)
    {
        ActivityCamera.l(a).setVisibility(4);
        int j;
        if (ActivityCamera.c(a).c)
        {
            j = (ActivityCamera.c(a).d() + pt.b(pt.k, a, 0) + i % 360) % 360;
        } else
        {
            j = (pt.b(pt.l, a, 0) + ActivityCamera.c(a).d() + i) % 360;
        }
        Log.e(ActivityCamera.b(), (new StringBuilder()).append("correctpreSize angle:").append(i).toString());
        ActivityCamera.m(a).a(j);
    }

    public void b(int i)
    {
        if (ActivityCamera.c(a).c)
        {
            pt.a(pt.k, a, (pt.b(pt.k, a, 0) + i % 360) % 360);
        } else
        {
            pt.a(pt.l, a, (pt.b(pt.l, a, 0) + i) % 360);
        }
        if (ActivityCamera.c(a) == null)
        {
            ActivityCamera.o(a).b();
            Toast.makeText(a, "sorry...", 0).show();
        } else
        {
            android.hardware.Camera.Parameters parameters;
            try
            {
                parameters = ActivityCamera.c(a).b.getParameters();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                parameters = null;
            }
            if (parameters == null)
            {
                ActivityCamera.o(a).b();
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
                    if (j < i && i > 400)
                    {
                        i = j;
                        size = size1;
                    }
                } while (true);
                parameters.setPictureSize(size.width, size.height);
                ActivityCamera.c(a).b.setParameters(parameters);
                ActivityCamera.c(a).b.setPreviewCallback(null);
                ActivityCamera.o(a).b();
                ActivityCamera.c(a).b.takePicture(null, null, new lb(this));
                return;
            }
        }
    }
}
