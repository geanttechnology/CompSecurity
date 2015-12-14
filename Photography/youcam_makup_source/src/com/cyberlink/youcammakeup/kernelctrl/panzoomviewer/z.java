// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            aa, PanZoomViewer

class z
{

    final PanZoomViewer a;
    private long b;
    private ArrayList c;

    public z(PanZoomViewer panzoomviewer)
    {
        a = panzoomviewer;
        super();
        b = 150L;
        c = null;
        c = new ArrayList();
    }

    public void a(PointF pointf)
    {
        long l = System.currentTimeMillis();
        pointf = new aa(a, pointf, l);
        c.add(0, pointf);
    }

    public boolean a(PointF pointf, PointF pointf1)
    {
        Iterator iterator;
        long l;
        while (pointf == null || pointf1 == null || c.size() < 2) 
        {
            return false;
        }
        l = System.currentTimeMillis();
        iterator = c.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        aa aa1 = (aa)iterator.next();
        if (l - aa1.a < b) goto _L4; else goto _L3
_L3:
        boolean flag;
        pointf.x = aa1.b.x;
        pointf.y = aa1.b.y;
        flag = true;
_L6:
        PointF pointf2 = ((aa)c.get(0)).b;
        pointf1.x = pointf.x - pointf2.x;
        pointf1.y = pointf.y - pointf2.y;
        c.clear();
        return flag;
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
