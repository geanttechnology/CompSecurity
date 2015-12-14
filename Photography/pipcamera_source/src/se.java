// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;

public class se
{

    private static String a = "PictureAdjustFront";
    private static String b = "PictureAdjustBack";

    public static int a(Context context, boolean flag)
    {
        Object obj = new android.hardware.Camera.CameraInfo();
        int k = Camera.getNumberOfCameras();
        int i = 1;
        if (!flag)
        {
            i = 0;
        }
        int j = 0;
        do
        {
label0:
            {
                if (j < k)
                {
                    Camera.getCameraInfo(j, ((android.hardware.Camera.CameraInfo) (obj)));
                    if (((android.hardware.Camera.CameraInfo) (obj)).facing != i)
                    {
                        break label0;
                    }
                }
                i = ((android.hardware.Camera.CameraInfo) (obj)).orientation;
                obj = b;
                if (flag)
                {
                    obj = a;
                }
                return context.getSharedPreferences(((String) (obj)), 32768).getInt(((String) (obj)), 0) + i;
            }
            j++;
        } while (true);
    }

}
