// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.masteraccess;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import com.cyberlink.youcammakeup.jniproxy.UIImageFormat;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.jniproxy.ba;
import com.cyberlink.youcammakeup.jniproxy.k;
import com.cyberlink.youcammakeup.jniproxy.v;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.masteraccess:
//            Exporter, c, b

class e extends AsyncTask
{

    final String a;
    final c b;
    final ImageBufferWrapper c;
    final UIImageOrientation d;
    final ba e;
    final Exporter f;

    protected transient Void a(Void avoid[])
    {
        avoid = (new File(a)).getParentFile();
        if (avoid != null && !Exporter.a(b, avoid))
        {
            return null;
        }
        Object obj = c.j();
        v v1 = new v();
        v1.a(UIImageFormat.b);
        v1.a(d);
        v1.a(94);
        avoid = new File(a);
        obj = Exporter.a(f).a(avoid.getPath(), ((com.cyberlink.youcammakeup.jniproxy.d) (obj)), v1, e);
        if (obj != UIImageCodecErrorCode.a)
        {
            c.m();
            b.a(new ror(((UIImageCodecErrorCode) (obj))));
        }
        b.a(new b(((UIImageCodecErrorCode) (obj)), -1L, -1L, -1L, avoid));
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    ion(Exporter exporter, String s, c c1, ImageBufferWrapper imagebufferwrapper, UIImageOrientation uiimageorientation, ba ba)
    {
        f = exporter;
        a = s;
        b = c1;
        c = imagebufferwrapper;
        d = uiimageorientation;
        e = ba;
        super();
    }
}
