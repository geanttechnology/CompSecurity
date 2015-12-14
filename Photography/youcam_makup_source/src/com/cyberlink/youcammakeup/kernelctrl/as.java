// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            VenusHelper, aw

class as extends AsyncTask
{

    final VenusHelper a;
    private ImageBufferWrapper b;
    private UIImageOrientation c;
    private aw d;

    public as(VenusHelper venushelper, ImageBufferWrapper imagebufferwrapper, UIImageOrientation uiimageorientation, aw aw1)
    {
        a = venushelper;
        super();
        b = null;
        c = null;
        d = null;
        b = imagebufferwrapper;
        b.l();
        c = uiimageorientation;
        d = aw1;
    }

    protected transient List a(Void avoid[])
    {
        return VenusHelper.a(a, b, c);
    }

    protected void a(List list)
    {
        b.m();
        if (d != null)
        {
            d.a(list);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    public void onCancelled()
    {
        b.m();
        if (d != null)
        {
            d.a();
        }
    }

    protected void onPostExecute(Object obj)
    {
        a((List)obj);
    }
}
