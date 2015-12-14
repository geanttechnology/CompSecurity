// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.masteraccess;

import android.net.Uri;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.n;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.masteraccess:
//            Exporter, c, b

class f
    implements android.media.rConnection.OnScanCompletedListener
{

    final ImageBufferWrapper a;
    final com.cyberlink.youcammakeup.masteraccess.c b;
    final UIImageOrientation c;
    final UIImageCodecErrorCode d;
    final long e;
    final File f;
    final Exporter g;

    public void onScanCompleted(String s, Uri uri)
    {
        Object obj;
        long l;
        obj = com.cyberlink.youcammakeup.c.e();
        uri = com.cyberlink.youcammakeup.c.f();
        s = ((n) (obj)).a(s);
        if (s == null)
        {
            a.m();
            b.a(new ror(ror.JavaError.e));
            return;
        }
        obj = ((n) (obj)).a(s.longValue());
        if (obj == null)
        {
            a.m();
            b.a(new ror(ror.JavaError.g));
            return;
        }
        l = uri.f(s.longValue());
        if (l == -1L)
        {
            a.m();
            b.a(new ror(ror.JavaError.f));
            return;
        }
        if (a != null)
        {
            ViewEngine.a().a(l, a, c);
        }
        if (a != null)
        {
            a.m();
        }
_L2:
        s = new b(d, e, l, ((Long) (obj)).longValue(), f);
        b.a(s);
        return;
        s;
        if (a != null)
        {
            a.m();
        }
        if (true) goto _L2; else goto _L1
_L1:
        s;
        if (a != null)
        {
            a.m();
        }
        throw s;
    }

    orCode(Exporter exporter, ImageBufferWrapper imagebufferwrapper, com.cyberlink.youcammakeup.masteraccess.c c1, UIImageOrientation uiimageorientation, UIImageCodecErrorCode uiimagecodecerrorcode, long l, 
            File file)
    {
        g = exporter;
        a = imagebufferwrapper;
        b = c1;
        c = uiimageorientation;
        d = uiimagecodecerrorcode;
        e = l;
        f = file;
        super();
    }
}
