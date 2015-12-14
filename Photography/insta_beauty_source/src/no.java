// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;

public class no
    implements android.hardware.Camera.PictureCallback
{

    final ActivityCameraNoRealtime a;

    public no(ActivityCameraNoRealtime activitycameranorealtime)
    {
        a = activitycameranorealtime;
        super();
    }

    public void onPictureTaken(byte abyte0[], Camera camera)
    {
        try
        {
            a.a(abyte0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Crashlytics.logException(abyte0);
        }
        a.a.startPreview();
        ActivityCameraNoRealtime.n(a);
    }
}
