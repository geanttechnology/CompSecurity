// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.kernelctrl.s;
import java.util.HashMap;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            PanZoomViewer

class ag extends AsyncTask
{

    final PanZoomViewer a;

    private ag(PanZoomViewer panzoomviewer)
    {
        a = panzoomviewer;
        super();
    }

    ag(PanZoomViewer panzoomviewer, PanZoomViewer._cls1 _pcls1)
    {
        this(panzoomviewer);
    }

    protected transient Void a(Void avoid[])
    {
        try
        {
            Thread.sleep(PanZoomViewer.a(a));
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.getLocalizedMessage();
        }
        return null;
    }

    protected void a(Void void1)
    {
        if (PanZoomViewer.b(a) != null && PanZoomViewer.c(a) != null && PanZoomViewer.b(a).containsKey(PanZoomViewer.c(a)))
        {
            void1 = a;
            boolean flag;
            if (!PanZoomViewer.d(a).booleanValue())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            PanZoomViewer.a(void1, Boolean.valueOf(flag));
            void1 = (s)PanZoomViewer.b(a).get(PanZoomViewer.c(a));
            if (void1 != null && !PanZoomViewer.e(a))
            {
                void1.a(Boolean.valueOf(true));
                return;
            }
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }
}
