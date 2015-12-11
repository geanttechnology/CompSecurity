// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.int;

import android.app.KeyguardManager;
import android.content.Context;
import io.presage.Presage;
import io.presage.ads.d;
import io.presage.utils.do.do.b;
import io.presage.utils.e;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package io.presage.int:
//            b, g

public final class a extends io.presage.int.b
    implements g
{

    private io.presage.ads.a a;

    public a(String s)
    {
        super(s);
    }

    private static boolean b(Map map)
    {
        if (map == null || !map.containsKey("format") || !map.containsKey("params") || !map.containsKey("actions") || !map.containsKey("id") || !map.containsKey("name") || !map.containsKey("finish"))
        {
            e.b(new String[] {
                "Ad", "No ad to showAd... Missing Key"
            });
            return false;
        }
        Map map1;
        try
        {
            map1 = (Map)map.get("format");
            map.get("params");
            map.get("actions");
            map.get("finish");
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            e.b(new String[] {
                "Ad", "No ad to showAd... Not a map or a List"
            });
            return false;
        }
        if (map1 != null && (!map1.containsKey("id") || !map1.containsKey("name")))
        {
            e.b(new String[] {
                "Ad", "No ad to showAd... incorrect viewer"
            });
            return false;
        } else
        {
            return true;
        }
    }

    public final void a(b b1)
    {
        Object obj;
        obj = (Map)a().get(c());
        break MISSING_BLOCK_LABEL_17;
        if (b(((Map) (obj))) && !((KeyguardManager)Presage.getInstance().getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
        {
            if (a == null)
            {
                a = io.presage.ads.a.a();
            }
            b1 = a.a(((Map) (obj)), b1);
            b1.a();
            obj = b().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Map map = (Map)((Iterator) (obj)).next();
                b1.a((String)map.get("type"), (String)map.get("content"));
            }
        }
        return;
    }
}
