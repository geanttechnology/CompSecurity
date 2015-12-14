// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.masteraccess;

import android.os.AsyncTask;
import android.util.Pair;
import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import com.cyberlink.youcammakeup.jniproxy.UIImageFormat;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.jniproxy.k;
import com.cyberlink.youcammakeup.jniproxy.v;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.utility.y;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.masteraccess:
//            Exporter, a, c

class d extends AsyncTask
{

    final c a;
    final ImageBufferWrapper b;
    final UIImageOrientation c;
    final boolean d;
    final Exporter e;

    protected transient Void a(Void avoid[])
    {
        for (avoid = new File(Exporter.a()); !Exporter.a(a, avoid) || b == null;)
        {
            return null;
        }

        Object obj1 = b.j();
        v v1 = new v();
        v1.a(UIImageFormat.b);
        v1.a(c);
        v1.a(94);
        File file = new File(com.cyberlink.youcammakeup.masteraccess.Exporter.k());
        if (d)
        {
            Pair pair = y.a().b();
            Object obj;
            if (pair != y.a)
            {
                obj = Exporter.a(e, pair);
                if (obj != null)
                {
                    avoid = new a();
                    avoid.a = true;
                    avoid.b = ((Double)pair.first).doubleValue();
                    avoid.c = ((Double)pair.second).doubleValue();
                } else
                {
                    avoid = null;
                }
            } else
            {
                obj = null;
                avoid = null;
            }
            obj1 = Exporter.a(e).a(file.getPath(), ((com.cyberlink.youcammakeup.jniproxy.d) (obj1)), v1, ((com.cyberlink.youcammakeup.jniproxy.ba) (obj)));
            obj = avoid;
            avoid = ((Void []) (obj1));
        } else
        {
            avoid = Exporter.a(e).a(file.getPath(), ((com.cyberlink.youcammakeup.jniproxy.d) (obj1)), v1, null);
            obj = null;
        }
        if (avoid != UIImageCodecErrorCode.a)
        {
            b.m();
            a.a(new ror(avoid));
        }
        e.a(-1L, file, avoid, b, c, ((a) (obj)), a);
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    ion(Exporter exporter, c c1, ImageBufferWrapper imagebufferwrapper, UIImageOrientation uiimageorientation, boolean flag)
    {
        e = exporter;
        a = c1;
        b = imagebufferwrapper;
        c = uiimageorientation;
        d = flag;
        super();
    }
}
