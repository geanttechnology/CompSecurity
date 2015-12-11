// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

final class alf extends ald
{

    private final String a;
    private akx b;

    public alf(akx akx1, Set set)
    {
        b = akx1;
        super(akx1, set);
        if (!akx1.k.c()) goto _L2; else goto _L1
_L1:
        set = (WifiManager)akx1.d.getSystemService("wifi");
        if (set == null) goto _L2; else goto _L3
_L3:
        set = set.getConnectionInfo();
        if (set == null) goto _L2; else goto _L4
_L4:
        set = set.getSSID();
_L6:
        Object obj = set;
        if (set == null)
        {
            obj = "";
        }
        a = ((String) (obj));
        akx1.c();
        set = akx1.i.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            cgt cgt1 = (cgt)set.next();
            alc alc1 = (alc)akx1.g.get(cgt1);
            if (alc1 != null && !TextUtils.isEmpty(alc1.b) && a.equals(alc1.d))
            {
                cgy cgy1 = new cgy();
                cgy1.g = cgt1;
                cgy1.c = String.valueOf(alc1.a).concat(" (WoL)");
                cgy1.h = alc1.b;
                cgy1.i = alc1.c;
                super.a(cgy1.a());
            }
        } while (true);
        return;
_L2:
        set = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(cgw cgw1)
    {
        Object obj;
        if (!a.isEmpty() && cgw1.h != null)
        {
            alc alc1 = (alc)b.g.get(cgw1.g);
            if (alc1 == null || !a.equals(alc1.d))
            {
                if (alc1 == null)
                {
                    obj = cgw1.c;
                } else
                {
                    obj = alc1.a;
                }
                obj = new alc(((String) (obj)), cgw1.h, cgw1.i, a);
                b.g.put(cgw1.g, obj);
                if (alc1 == null)
                {
                    b.i.add(cgw1.g);
                }
                b.d();
            }
        }
        obj = b.a(cgw1);
        if (obj != null)
        {
            cgw1 = new cgy(cgw1);
            cgw1.c = ((String) (obj));
            cgw1 = cgw1.a();
        }
        super.a(cgw1);
    }
}
