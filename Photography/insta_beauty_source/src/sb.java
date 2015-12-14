// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapturePhotoEditActivity1;
import java.lang.ref.WeakReference;

public class sb extends Handler
{

    private WeakReference a;

    public sb(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        a = new WeakReference(conticapturephotoeditactivity1);
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            message = (String)message.obj;
            break;
        }
        contiCapturePhotoEditActivity1 conticapturephotoeditactivity1 = (contiCapturePhotoEditActivity1)a.get();
        Log.e("contiCapturePhotoEditActivity1", "MSG_SAVE_IMG_FINISH ");
        conticapturephotoeditactivity1.a(message);
    }
}
