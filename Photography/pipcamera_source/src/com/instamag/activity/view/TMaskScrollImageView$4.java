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

class c
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
            b.fastProcessImage(bitmap, a, new Handler() {

                final TMaskScrollImageView._cls4 a;

                public void handleMessage(Message message)
                {
                    if (message != null)
                    {
                        message = (Bitmap)message.obj;
                        if (message != null)
                        {
                            message = ev.a(message, (int)TMaskScrollImageView.access$300(a.d).gaussianBlur);
                            a.d.updateBackgroundImage(message, a.c);
                        }
                    }
                }

            
            {
                a = TMaskScrollImageView._cls4.this;
                super();
            }
            });
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

    _cls1.a(TMaskScrollImageView tmaskscrollimageview, String s, ImageGLSurfaceView imageglsurfaceview, boolean flag)
    {
        d = tmaskscrollimageview;
        a = s;
        b = imageglsurfaceview;
        c = flag;
        super();
    }
}
