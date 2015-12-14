// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMaskInfo;
import com.wantu.imagerender.ImageGLSurfaceView;
import ev;
import sn;

// Referenced classes of package com.instamag.activity.view:
//            TMaskScrollImageView

class a extends Handler
{

    final a a;

    public void handleMessage(Message message)
    {
        if (message != null)
        {
            message = (Bitmap)message.obj;
            if (message != null)
            {
                message = ev.a(message, (int)TMaskScrollImageView.access$300(a.a).gaussianBlur);
                a.a.updateBackgroundImage(message, a.a);
            }
        }
    }

    fo(fo fo)
    {
        a = fo;
        super();
    }

    // Unreferenced inner class com/instamag/activity/view/TMaskScrollImageView$4

/* anonymous class */
    class TMaskScrollImageView._cls4
        implements sn
    {

        final String a;
        final ImageGLSurfaceView b;
        final boolean c;
        final TMaskScrollImageView d;

        public void a(int i)
        {
        }

        public void a(Bitmap bitmap, int i)
        {
            if (TMaskScrollImageView.access$400(d, a) && !TMaskScrollImageView.access$500(d, a) && TMaskScrollImageView.access$300(d).gaussianBlur > 0.0F && bitmap != null)
            {
                b.fastProcessImage(bitmap, a, new TMaskScrollImageView._cls4._cls1(this));
                return;
            } else
            {
                bitmap = ev.a(bitmap, (int)TMaskScrollImageView.access$300(d).gaussianBlur);
                d.updateBackgroundImage(bitmap, c);
                return;
            }
        }

        public void a(Exception exception)
        {
        }

            
            {
                d = tmaskscrollimageview;
                a = s;
                b = imageglsurfaceview;
                c = flag;
                super();
            }
    }

}
