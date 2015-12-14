// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;

public class kq
    implements android.hardware.Camera.PictureCallback
{

    final ActivityCamera a;

    public kq(ActivityCamera activitycamera)
    {
        a = activitycamera;
        super();
    }

    public void onPictureTaken(byte abyte0[], Camera camera)
    {
        (new ld(a, abyte0, ActivityCamera.f(a))).execute(new Void[0]);
    }
}
