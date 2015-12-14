// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapturePhotoEditActivity1;
import java.lang.ref.WeakReference;

public class rz extends Handler
{

    private WeakReference a;
    private sb b;

    public rz(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1, sb sb)
    {
        a = new WeakReference(conticapturephotoeditactivity1);
        b = sb;
    }

    static sb a(rz rz1)
    {
        return rz1.b;
    }

    public void handleMessage(Message message)
    {
        contiCapturePhotoEditActivity1 conticapturephotoeditactivity1 = (contiCapturePhotoEditActivity1)a.get();
        if (conticapturephotoeditactivity1 != null && message != null)
        {
            message = (Bitmap)message.obj;
            if (message != null)
            {
                (new Thread(new sa(this, conticapturephotoeditactivity1, message))).start();
            }
        }
    }
}
