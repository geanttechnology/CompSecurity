// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ConditionVariable;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapEditItem;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapturePhotoEditActivity1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory;

public class sc
    implements Runnable
{

    final WeakReference a;
    final contiCapturePhotoEditActivity1 b;
    private ConditionVariable c;
    private int d;
    private boolean e;

    public sc(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1, contiCapturePhotoEditActivity1 conticapturephotoeditactivity1_1)
    {
        b = conticapturephotoeditactivity1;
        super();
        c = new ConditionVariable();
        e = true;
        a = new WeakReference(conticapturephotoeditactivity1_1);
        d = -1;
        (new Thread(this, getClass().getSimpleName())).start();
    }

    static int a(sc sc1)
    {
        return sc1.d;
    }

    public static void b(sc sc1)
    {
        sc1.e();
    }

    private void e()
    {
        this;
        JVM INSTR monitorenter ;
        c.open();
        e = false;
        Log.e("contiCapturePhotoEditActivity1", (new StringBuilder()).append("startProcess mPhotoIndex=").append(d).toString());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int a()
    {
        this;
        JVM INSTR monitorenter ;
        int i = d;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        c.open();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = e;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void d()
    {
        this;
        JVM INSTR monitorenter ;
        if (d >= 0)
        {
            d = d - 1;
            Log.e("contiCapturePhotoEditActivity1", (new StringBuilder()).append("pauseProcess mPhotoIndex=").append(d).toString());
            e = true;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void run()
    {
        Object obj;
        c.close();
        c.block();
        try
        {
            obj = (contiCapturePhotoEditActivity1)a.get();
            do
            {
                while (e) ;
                if (d >= contiCapturePhotoEditActivity1.f(b).size() - 1 || d <= -2)
                {
                    break;
                }
                d = d + 1;
                android.graphics.Bitmap bitmap = BitmapFactory.decodeFile(Uri.parse(((contiCapEditItem)contiCapturePhotoEditActivity1.f(b).get(d)).urlStr).getPath());
                GPUImage gpuimage = new GPUImage(((android.content.Context) (obj)));
                cco cco1 = (cco)GPUImageBeautyFilterFactory.a(b.getBaseContext(), jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SOFTEN);
                cco1.b(((contiCapEditItem)contiCapturePhotoEditActivity1.f(b).get(d)).softLevel);
                gpuimage.a(cco1);
                bitmap = gpuimage.b(bitmap);
                int i = d;
                b.runOnUiThread(new sd(this, i, bitmap, ((contiCapturePhotoEditActivity1) (obj))));
                c.close();
                c.block();
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            Crashlytics.logException(((Throwable) (obj)));
            return;
        }
        ((contiCapturePhotoEditActivity1) (obj)).runOnUiThread(new se(this));
        return;
    }
}
