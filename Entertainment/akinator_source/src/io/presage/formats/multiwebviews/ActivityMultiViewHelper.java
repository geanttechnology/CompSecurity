// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats.multiwebviews;

import android.app.Activity;
import io.presage.ads.NewAd;
import io.presage.ads.NewAdController;
import io.presage.ads.NewAdViewer;
import io.presage.model.Parameter;
import io.presage.model.Zone;
import io.presage.try.h;
import io.presage.utils.n;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package io.presage.formats.multiwebviews:
//            a

public class ActivityMultiViewHelper extends NewAdViewer
{

    private h e;
    private a f;
    private Activity g;

    public ActivityMultiViewHelper(NewAdController newadcontroller, NewAd newad, int i)
    {
        super(newadcontroller, newad, i);
        g = (Activity)a;
    }

    public void hide()
    {
        if (f != null)
        {
            f.d();
            f = null;
        }
        if (!g.isFinishing())
        {
            g.finish();
        }
        onHide();
    }

    public void show()
    {
        e = new h(a);
        f = new a(c, e);
        f.c();
        Zone zone = (Zone)c.getOverridedParameterValue("frame", io/presage/model/Zone);
        Object obj;
        if (zone == null)
        {
            obj = n.a();
        } else
        {
            obj = n.a(zone);
            n.a(e, zone);
        }
        g.setContentView(e, ((android.view.ViewGroup.LayoutParams) (obj)));
        obj = (List)c.getOverridedParameter("zones").get();
        if (obj != null)
        {
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); e.a(n.a(a, zone)))
            {
                zone = (Zone)((Iterator) (obj)).next();
            }

        }
        c.onFormatEvent("shown");
        onShow();
    }
}
