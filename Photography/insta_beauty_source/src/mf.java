// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class mf
    implements Runnable
{

    final byte a[];
    final int b;
    final boolean c;
    final String d;
    final ActivityCameraNew e;

    public mf(ActivityCameraNew activitycameranew, byte abyte0[], int i, boolean flag, String s)
    {
        e = activitycameranew;
        a = abyte0;
        b = i;
        c = flag;
        d = s;
        super();
    }

    public void run()
    {
        try
        {
            Bitmap bitmap = yo.a(a, a, b, b);
            Matrix matrix = new Matrix();
            matrix.postRotate(oj.a(c, e));
            if (c)
            {
                matrix.postScale(-1F, 1.0F);
            }
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap = Bitmap.createScaledBitmap(bitmap, (int)((float)b * ((float)bitmap.getWidth() / (float)bitmap.getHeight())), b, true);
            qa.a().a(bitmap, d, new mg(this));
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        ActivityCameraNew.T(e);
    }
}
