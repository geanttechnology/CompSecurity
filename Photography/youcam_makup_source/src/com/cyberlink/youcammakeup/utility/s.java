// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.app.Activity;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.c.a;
import com.cyberlink.youcammakeup.kernelctrl.c.b;
import com.cyberlink.youcammakeup.kernelctrl.c.d;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.widgetpool.dialogs.FaceSwitcherDialog;
import com.cyberlink.youcammakeup.widgetpool.dialogs.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            t, o

public class s
{

    private boolean a;

    private s()
    {
        boolean flag = false;
        super();
        a = false;
        if (!z.a("HAS_SHOWN_FACE_SWITCHER_HINT", Globals.d()))
        {
            flag = true;
        }
        a = flag;
        if (a)
        {
            z.a("HAS_SHOWN_FACE_SWITCHER_HINT", Boolean.valueOf(true), Globals.d());
        }
    }


    public static s a()
    {
        return com.cyberlink.youcammakeup.utility.t.a();
    }

    private PanZoomViewer b()
    {
        Object obj;
        obj = ((a)Globals.d().i.b().get()).a();
        if (obj == null)
        {
            return null;
        }
        obj = ((ArrayList) (obj)).iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        b b1 = (b)((WeakReference)((Iterator) (obj)).next()).get();
        if (b1 == null || !(b1 instanceof PanZoomViewer)) goto _L4; else goto _L3
_L3:
        obj = (PanZoomViewer)b1;
_L6:
        return ((PanZoomViewer) (obj));
_L2:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a(Activity activity, View view, j j)
    {
        FaceSwitcherDialog faceswitcherdialog = new FaceSwitcherDialog();
        PanZoomViewer panzoomviewer = b();
        if (panzoomviewer == null || panzoomviewer.s() == null)
        {
            return;
        } else
        {
            faceswitcherdialog.a(view);
            faceswitcherdialog.a(panzoomviewer, panzoomviewer.s());
            faceswitcherdialog.b();
            faceswitcherdialog.a(j);
            faceswitcherdialog.a(a);
            com.cyberlink.youcammakeup.utility.o.a(activity, faceswitcherdialog, "FaceSwitcherDialog");
            a = false;
            return;
        }
    }
}
