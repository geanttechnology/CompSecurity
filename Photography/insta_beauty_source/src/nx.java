// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.util.Log;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;

class nx
    implements android.hardware.Camera.PictureCallback
{

    final nw a;

    nx(nw nw1)
    {
        a = nw1;
        super();
    }

    public void onPictureTaken(byte abyte0[], Camera camera)
    {
        Log.e(ActivityCameraNoRealtime.b(), (new StringBuilder()).append(ActivityCameraNoRealtime.b()).append("  take picture").toString());
        if (a.a.a != null) goto _L2; else goto _L1
_L1:
        Toast.makeText(a.a, "sorry...", 0).show();
        FlurryAgent.onError((new StringBuilder()).append(ActivityCameraNoRealtime.b()).append("003").toString(), "unexpected", "003");
        a.a.f.b();
        a.a.finish();
_L4:
        return;
_L2:
        a.a();
        if (abyte0.length == 0 || abyte0 == null) goto _L4; else goto _L3
_L3:
        abyte0 = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
        if (abyte0 == null)
        {
            try
            {
                FlurryAgent.onError((new StringBuilder()).append(ActivityCameraNoRealtime.b()).append("004").toString(), "unexpected", "004");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                Crashlytics.logException(abyte0);
            }
            return;
        }
        camera = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(a.a.c, camera);
        Matrix matrix = new Matrix();
        matrix.postRotate(oj.a(ActivityCameraNoRealtime.v(a.a), a.a));
        if (((android.hardware.Camera.CameraInfo) (camera)).facing == 1)
        {
            matrix.postScale(-1F, 1.0F);
        }
        abyte0 = Bitmap.createBitmap(abyte0, 0, 0, abyte0.getWidth(), abyte0.getHeight(), matrix, true);
        a.a.f.a(abyte0);
        return;
    }
}
