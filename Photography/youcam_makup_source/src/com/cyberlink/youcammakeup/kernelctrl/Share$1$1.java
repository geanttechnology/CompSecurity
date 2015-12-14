// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.net.Uri;
import android.os.Handler;
import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import com.cyberlink.youcammakeup.masteraccess.b;
import com.cyberlink.youcammakeup.masteraccess.c;
import java.io.File;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            Share

class a
    implements Runnable
{

    final b a;
    final b b;

    public void run()
    {
        if (a == null)
        {
            Exception exception = new Exception(rMessage.a.name());
            Share.a(b.b, exception);
            return;
        }
        Uri uri = Uri.parse((new StringBuilder()).append("file://").append(a.b().getPath()).toString());
        Share.a(b.b).add(uri);
        int i = b.b + 1;
        if (com.cyberlink.youcammakeup.kernelctrl.Share.b(b.b))
        {
            com.cyberlink.youcammakeup.kernelctrl.Share.c(b.b);
            return;
        }
        if (i < Share.d(b.b).length)
        {
            b.b.a(i, b.b);
            return;
        } else
        {
            Share.e(b.b);
            return;
        }
    }

    .Error(.Error error, b b1)
    {
        b = error;
        a = b1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/kernelctrl/Share$1

/* anonymous class */
    class Share._cls1
        implements c
    {

        final int a;
        final boolean b;
        final Share c;

        public void a()
        {
        }

        public void a(com.cyberlink.youcammakeup.masteraccess.Exporter.Error error)
        {
            Exception exception;
            com.cyberlink.youcammakeup.masteraccess.Exporter.Error.JavaError javaerror;
            UIImageCodecErrorCode uiimagecodecerrorcode;
            exception = new Exception(Share.ErrorMessage.a.name());
            javaerror = error.a();
            uiimagecodecerrorcode = error.b();
            if (javaerror == com.cyberlink.youcammakeup.masteraccess.Exporter.Error.JavaError.a) goto _L2; else goto _L1
_L1:
            error = exception;
_L4:
            Share.a(c, error);
            return;
_L2:
            error = exception;
            if (uiimagecodecerrorcode != UIImageCodecErrorCode.a)
            {
                if (uiimagecodecerrorcode == UIImageCodecErrorCode.j)
                {
                    error = new Exception(com.cyberlink.youcammakeup.kernelctrl.Share.ErrorMessage.b.name());
                } else
                {
                    error = exception;
                    if (uiimagecodecerrorcode == UIImageCodecErrorCode.i)
                    {
                        error = new Exception(com.cyberlink.youcammakeup.kernelctrl.Share.ErrorMessage.c.name());
                    }
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void a(b b1)
        {
            Share.f(c).post(new Share._cls1._cls1(this, b1));
        }

            
            {
                c = share;
                a = i;
                b = flag;
                super();
            }
    }

}
