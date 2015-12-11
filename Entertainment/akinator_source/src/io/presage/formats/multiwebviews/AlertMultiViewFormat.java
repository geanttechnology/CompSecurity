// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats.multiwebviews;

import android.content.Context;
import android.view.WindowManager;
import io.presage.ads.NewAd;
import io.presage.ads.NewAdController;
import io.presage.ads.NewAdViewer;
import io.presage.model.Zone;
import io.presage.try.h;
import io.presage.utils.m;
import io.presage.utils.n;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package io.presage.formats.multiwebviews:
//            a

public class AlertMultiViewFormat extends NewAdViewer
{

    private h e;
    private a f;

    public AlertMultiViewFormat(NewAdController newadcontroller, NewAd newad, int i)
    {
        super(newadcontroller, newad, i);
    }

    public void hide()
    {
        if (e != null)
        {
            ((WindowManager)a.getSystemService("window")).removeView(e);
            e = null;
        }
        if (f != null)
        {
            f.d();
            f = null;
        }
        onHide();
    }

    public void show()
    {
        e = new h(a);
        f = new a(c, e);
        f.c();
        WindowManager windowmanager = (WindowManager)a.getSystemService("window");
        Zone zone1 = (Zone)c.getOverridedParameterValue("frame", io/presage/model/Zone);
        Object obj;
        if (zone1 == null)
        {
            obj = n.b();
        } else
        {
            obj = n.b();
            Object obj1 = zone1.getSize();
            if (obj1 != null)
            {
                if (((io.presage.model.Zone.Size) (obj1)).width > 0)
                {
                    obj.width = m.a(Math.round(((io.presage.model.Zone.Size) (obj1)).width));
                }
                if (((io.presage.model.Zone.Size) (obj1)).height > 0)
                {
                    obj.height = m.a(Math.round(((io.presage.model.Zone.Size) (obj1)).height));
                }
            }
            obj1 = zone1.getGravity();
            if (obj1 != null)
            {
                obj.gravity = 0;
                obj1 = ((List) (obj1)).iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    String s = (String)((Iterator) (obj1)).next();
                    if (s.equals("top"))
                    {
                        obj.gravity = ((android.view.WindowManager.LayoutParams) (obj)).gravity | 0x30;
                    } else
                    if (s.equals("left"))
                    {
                        obj.gravity = ((android.view.WindowManager.LayoutParams) (obj)).gravity | 3;
                    } else
                    if (s.equals("bottom"))
                    {
                        obj.gravity = ((android.view.WindowManager.LayoutParams) (obj)).gravity | 0x50;
                    } else
                    if (s.equals("right"))
                    {
                        obj.gravity = ((android.view.WindowManager.LayoutParams) (obj)).gravity | 5;
                    }
                } while (true);
            }
            obj1 = zone1.getPosition();
            if (obj1 != null)
            {
                if (((io.presage.model.Zone.Position) (obj1)).x > 0)
                {
                    obj.x = m.a(Math.round(((io.presage.model.Zone.Position) (obj1)).x));
                }
                if (((io.presage.model.Zone.Position) (obj1)).y > 0)
                {
                    obj.y = m.a(Math.round(((io.presage.model.Zone.Position) (obj1)).y));
                }
            }
            n.a(e, zone1);
        }
        windowmanager.addView(e, ((android.view.ViewGroup.LayoutParams) (obj)));
        obj = (List)c.getOverridedParameterValue("zones", java/util/List);
        if (obj != null)
        {
            Zone zone;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); e.a(n.a(a, zone)))
            {
                zone = (Zone)((Iterator) (obj)).next();
            }

        }
        c.onFormatEvent("shown");
        onShow();
    }
}
