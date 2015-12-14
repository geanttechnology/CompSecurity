// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;
import com.fotoable.comlib.util.AsyncTask;
import com.instabeauty.application.InstaBeautyApplication;
import java.io.File;
import jp.co.cyberagent.android.gpuimage.GPUImage;

public class ld extends AsyncTask
{

    final ActivityCamera a;
    private boolean b;
    private Bitmap c;

    public ld(ActivityCamera activitycamera, byte abyte0[], boolean flag)
    {
        a = activitycamera;
        super();
        b = flag;
        Matrix matrix;
        if (abyte0.length != 0)
        {
            c = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
        } else
        {
            c = null;
        }
        abyte0 = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(ActivityCamera.c(activitycamera).a, abyte0);
        matrix = new Matrix();
        matrix.postRotate(oj.a(ActivityCamera.c(activitycamera).c, activitycamera));
        if (((android.hardware.Camera.CameraInfo) (abyte0)).facing == 1)
        {
            matrix.postScale(-1F, 1.0F);
        }
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        activitycamera = Bitmap.createBitmap(c, 0, 0, c.getWidth(), c.getHeight(), matrix, true);
        if (activitycamera != null)
        {
            c = activitycamera;
        }
_L2:
        return;
        activitycamera;
        if (true) goto _L2; else goto _L1
_L1:
        c = null;
        return;
        activitycamera;
        if (false)
        {
            c = null;
        }
        throw activitycamera;
    }

    private void a()
    {
        a.findViewById(0x7f0d0060).setVisibility(0);
    }

    private void a(File file, String s)
    {
        if (pt.b(pt.b, a, true))
        {
            Toast.makeText(a.getBaseContext(), 0x7f0600a3, 0).show();
        }
        pt.a(pt.o, a, 0.7F);
        file = new Intent(a, com/fotoable/beautyui/newui/MNewFotoBeautyActivity);
        file.putExtra(MNewFotoBeautyActivity.b, s);
        if (ActivityCamera.B(a) != null)
        {
            file.putExtra(MNewFotoBeautyActivity.i, ActivityCamera.B(a).toString());
            a.startActivityForResult(file, 1244);
            return;
        } else
        {
            a.startActivity(file);
            return;
        }
    }

    static void a(ld ld1)
    {
        ld1.b();
    }

    static void a(ld ld1, File file, String s)
    {
        ld1.a(file, s);
    }

    private void b()
    {
        a.findViewById(0x7f0d0060).setVisibility(8);
    }

    protected transient File a(Void avoid[])
    {
        try
        {
            avoid = pu.a(b, a.getApplicationContext());
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            Crashlytics.logException(avoid);
            return null;
        }
        return avoid;
    }

    protected void a(File file)
    {
        super.onPostExecute(file);
        String s = Uri.fromFile(file).toString();
        if (b)
        {
            boolean flag;
            if (ActivityCamera.c(a).c)
            {
                flag = pt.b(pt.b, InstaBeautyApplication.a, true);
            } else
            {
                flag = pt.b(pt.c, InstaBeautyApplication.a, false);
            }
            ActivityCamera.w(a).setEnabled(true);
            ActivityCamera.d(a).setEnabled(true);
            ActivityCamera.i(a).setEnabled(true);
            ActivityCamera.c(a, false);
            a();
            uv.c().a(c, file.getAbsolutePath(), flag, new le(this, file, s));
            return;
        } else
        {
            qa.a().a(c, file.getAbsolutePath(), new lg(this, s));
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((File)obj);
    }

    protected void onPreExecute()
    {
        if (ActivityCamera.r(a))
        {
            return;
        }
        ActivityCamera.v(a).setVisibility(4);
        ActivityCamera.b(a, false);
        if (!b)
        {
            if (ActivityCamera.m(a) == null)
            {
                try
                {
                    throw new Exception("gpuimage is null on the AcitivtyCamera");
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                return;
            }
            ActivityCamera.m(a).a(ActivityCamera.c(a).b);
            ActivityCamera.c(a).b.startPreview();
        }
        super.onPreExecute();
    }
}
