// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.d;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            ce, co, he, cn, 
//            cr, gi, gl

public final class cq
    implements ce
{

    public cq()
    {
    }

    public final void a(he he1, Map map)
    {
        p.r();
        if (map.containsKey("abort"))
        {
            if (!co.a(he1))
            {
                b.a(5);
            }
            return;
        }
        String s = (String)map.get("src");
        if (s == null)
        {
            b.a(5);
            return;
        }
        boolean flag;
        try
        {
            Integer.parseInt((String)map.get("player"));
        }
        catch (NumberFormatException numberformatexception) { }
        if (map.containsKey("mimetype"))
        {
            map.get("mimetype");
        }
        if (com.google.android.gms.d.co.b(he1) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            b.a(5);
            return;
        } else
        {
            d.a(he1.e());
            gl.a(((gi) (new cn(he1, he1.e().a.a(he1), s))).i);
            return;
        }
    }
}
