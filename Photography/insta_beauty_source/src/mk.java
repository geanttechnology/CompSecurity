// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

class mk
    implements android.hardware.Camera.PictureCallback
{

    final Camera a;
    final mj b;

    mk(mj mj1, Camera camera)
    {
        b = mj1;
        a = camera;
        super();
    }

    public void onPictureTaken(byte abyte0[], Camera camera)
    {
        try
        {
            b.a();
            abyte0 = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
            camera = b.b.k.getCameraInfo();
            if (!b.b.k.isFrontFacing());
            Matrix matrix = new Matrix();
            matrix.postRotate(oj.a(b.a, b.b));
            if (((android.hardware.Camera.CameraInfo) (camera)).facing == 1)
            {
                matrix.postScale(-1F, 1.0F);
            }
            abyte0 = Bitmap.createBitmap(abyte0, 0, 0, abyte0.getWidth(), abyte0.getHeight(), matrix, true);
            ActivityCameraNew.X(b.b).a(abyte0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Crashlytics.logException(abyte0);
        }
        if (a != null)
        {
            b.a();
            return;
        } else
        {
            b.b.finish();
            return;
        }
    }
}
