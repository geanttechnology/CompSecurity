// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.t;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.utility.BeautyMode;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            ImageViewer, q

class a extends AsyncTask
{

    final ImageViewer a;

    protected transient Void a(Void avoid[])
    {
        avoid = ViewEngine.a().a(a.m.a, 1.0D, null);
        if (avoid != null)
        {
            Object obj = Globals.d();
            if (((Globals) (obj)).n == a.m.a)
            {
                a.m.i = ((Globals) (obj)).o;
                a.m.j = ((Globals) (obj)).p;
            }
            obj = t.a(avoid, StatusManager.j().I());
            obj = new a(a.m.a, a.m.b, a.m.c, a.m.d, j.a(a.m.i), j.a(a.m.i), null, null, a.m.j, ((String) (obj)), new v(BeautyMode.D), "");
            StatusManager.j().a(((a) (obj)), avoid);
            avoid.m();
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    r(ImageViewer imageviewer)
    {
        a = imageviewer;
        super();
    }
}
