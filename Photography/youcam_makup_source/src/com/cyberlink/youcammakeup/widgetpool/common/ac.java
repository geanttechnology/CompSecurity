// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.cyberlink.youcammakeup.masteraccess.b;
import com.cyberlink.youcammakeup.masteraccess.c;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.aq;
import com.cyberlink.youcammakeup.utility.bo;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            MotionControlHelper

class ac extends AsyncTask
{

    final MotionControlHelper a;
    private aq b;
    private String c;

    ac(MotionControlHelper motioncontrolhelper, aq aq1, String s)
    {
        a = motioncontrolhelper;
        super();
        b = null;
        c = null;
        b = aq1;
        c = s;
    }

    static aq a(ac ac1)
    {
        return ac1.b;
    }

    protected transient Boolean a(Void avoid[])
    {
        if (bo.o() != null)
        {
            if (b != null)
            {
                b.a(bo.o());
            }
            return Boolean.valueOf(true);
        }
        long l = StatusManager.j().l();
        d d1 = StatusManager.j().c(l);
        avoid = d1.e();
        Object obj = (ar)avoid.d().get(((a) (avoid)).e);
        ImageBufferWrapper imagebufferwrapper = d1.g().b();
        if (imagebufferwrapper == null)
        {
            if (b != null)
            {
                b.a(new Exception("Failed to load image buffer."));
            }
            return Boolean.valueOf(false);
        } else
        {
            Object obj1 = Bitmap.createBitmap((int)imagebufferwrapper.b(), (int)imagebufferwrapper.c(), android.graphics.Bitmap.Config.ARGB_8888);
            imagebufferwrapper.c(((Bitmap) (obj1)));
            imagebufferwrapper.m();
            obj = aa.a(((Bitmap) (obj1)), ((ar) (obj)), ((a) (avoid)).d, true);
            ((Bitmap) (obj1)).recycle();
            obj1 = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
            imagebufferwrapper = new ImageBufferWrapper();
            imagebufferwrapper.a(((Bitmap) (obj)));
            ((Bitmap) (obj)).recycle();
            Globals.d().r().a(null, ((a) (avoid)).d, imagebufferwrapper, ((String) (obj1)), new c(imagebufferwrapper, ((String) (obj1))) {

                final ImageBufferWrapper a;
                final String b;
                final ac c;

                public void a()
                {
                    bo.B(null);
                    a.m();
                    if (com.cyberlink.youcammakeup.widgetpool.common.ac.a(c) != null)
                    {
                        com.cyberlink.youcammakeup.widgetpool.common.ac.a(c).a(new Exception("Failed to save thumbnail."));
                    }
                }

                public void a(com.cyberlink.youcammakeup.masteraccess.Exporter.Error error)
                {
                    bo.B(null);
                    a.m();
                    if (com.cyberlink.youcammakeup.widgetpool.common.ac.a(c) != null)
                    {
                        com.cyberlink.youcammakeup.widgetpool.common.ac.a(c).a(new Exception("Failed to save thumbnail."));
                    }
                }

                public void a(b b1)
                {
                    bo.B(b);
                    a.m();
                    if (com.cyberlink.youcammakeup.widgetpool.common.ac.a(c) != null)
                    {
                        com.cyberlink.youcammakeup.widgetpool.common.ac.a(c).a(b);
                    }
                }

            
            {
                c = ac.this;
                a = imagebufferwrapper;
                b = s;
                super();
            }
            });
            return Boolean.valueOf(true);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }
}
