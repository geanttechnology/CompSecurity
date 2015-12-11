// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.support.v7.app.MediaRouteButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ajd
{

    public final ip a;
    public final ir b;
    public final aje c = new aje(this);
    public gk d;
    public final List e = new ArrayList();

    public ajd(Activity activity, ip ip, aiu aiu)
    {
        b = ir.a(activity);
        a = ip;
        d = (gk)b.a(aiu);
    }

    static void a(ajd ajd1)
    {
        ir ir1 = ajd1.b;
        boolean flag = ir.a(ajd1.a, 0);
        ajd1 = ajd1.e.iterator();
        while (ajd1.hasNext()) 
        {
            MediaRouteButton mediaroutebutton = (MediaRouteButton)ajd1.next();
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            mediaroutebutton.setVisibility(i);
        }
    }
}
