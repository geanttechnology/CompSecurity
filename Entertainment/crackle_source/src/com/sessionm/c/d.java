// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.sessionm.core.StatsCollector;
import com.sessionm.net.Request;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.sessionm.c:
//            c, a, b

public class d
    implements c
{

    private static final String gS = "com.sesisonm.persistentstore.name";
    private static final String gT = "com.sesisonm.persistentstore.istransient";
    private Context bg;
    private c gU;
    private c gV;

    public d(Context context, String s1)
    {
        if (context == null)
        {
            throw new NullPointerException("Store context must not be null.");
        }
        bg = context.getApplicationContext();
        if (bg.getSharedPreferences("com.sesisonm.persistentstore.name", 0).getBoolean("com.sesisonm.persistentstore.istransient", false))
        {
            gV = new a();
            return;
        } else
        {
            gU = new b(context, s1);
            return;
        }
    }

    private void bE()
    {
        try
        {
            android.content.SharedPreferences.Editor editor = bg.getSharedPreferences("com.sesisonm.persistentstore.name", 0).edit();
            editor.putBoolean("com.sesisonm.persistentstore.istransient", true);
            editor.commit();
        }
        catch (Exception exception) { }
        StatsCollector.a(com.sessionm.core.StatsCollector.Stat.dr, 1L);
        gV = new a();
        gU = null;
    }

    public static void s(Context context)
    {
        try
        {
            context = context.getSharedPreferences("com.sesisonm.persistentstore.name", 0).edit();
            context.clear();
            context.commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public long bC()
    {
        if (bD())
        {
            return gV.bC();
        } else
        {
            return gU.bC();
        }
    }

    public boolean bD()
    {
        return gV != null;
    }

    public void close()
    {
        if (gU != null)
        {
            gU.close();
        }
    }

    public long getSize()
    {
        if (bD())
        {
            return gV.getSize();
        } else
        {
            return gU.getSize();
        }
    }

    public boolean k(Request request)
    {
        if (!bD()) goto _L2; else goto _L1
_L1:
        gV.k(request);
_L4:
        request.c(this);
        return true;
_L2:
        if (!gU.k(request))
        {
            bE();
            gV.k(request);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean l(Request request)
    {
        if (!bD()) goto _L2; else goto _L1
_L1:
        request.c(gV);
        gV.l(request);
_L4:
        request.c(null);
        return true;
_L2:
        request.c(gU);
        if (!gU.l(request))
        {
            bE();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean removeAll()
    {
        if (bD())
        {
            gV.removeAll();
        } else
        {
            gU.removeAll();
        }
        return true;
    }

    public List s(int i)
    {
        if (!bD()) goto _L2; else goto _L1
_L1:
        List list = gV.s(i);
_L4:
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ((Request)iterator.next()).c(this)) { }
        break; /* Loop/switch isn't completed */
_L2:
        list = gU.s(i);
        if (list == null)
        {
            bE();
            list = gV.s(i);
        }
        if (true) goto _L4; else goto _L3
_L3:
        return list;
    }

    public void t(int i)
    {
        if (bD())
        {
            gV.t(i);
            return;
        } else
        {
            gU.t(i);
            return;
        }
    }
}
