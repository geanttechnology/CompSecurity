// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            VenusHelper, as, aw

class c
    implements Runnable
{

    final ImageBufferWrapper a;
    final UIImageOrientation b;
    final aw c;
    final VenusHelper d;

    public void run()
    {
        (new as(d, a, b, c)).executeOnExecutor(VenusHelper.a(d), new Void[0]);
    }

    on(VenusHelper venushelper, ImageBufferWrapper imagebufferwrapper, UIImageOrientation uiimageorientation, aw aw)
    {
        d = venushelper;
        a = imagebufferwrapper;
        b = uiimageorientation;
        c = aw;
        super();
    }
}
