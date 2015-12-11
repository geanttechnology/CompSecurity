// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.tapjoy:
//            TapjoyCache, TapjoyLog, TJCacheListener

final class b extends Thread
{

    final JSONArray a;
    final TJCacheListener b;
    final TapjoyCache c;

    public final void run()
    {
        Object obj;
        int i;
        boolean flag;
        obj = new ArrayList();
        flag = true;
        i = 0;
_L3:
        if (i >= a.length()) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = a.getJSONObject(i);
        obj1 = c.cacheAssetFromJSONObject(((org.json.JSONObject) (obj1)));
        Object obj2;
        if (obj1 != null)
        {
            try
            {
                ((List) (obj)).add(obj1);
            }
            catch (JSONException jsonexception) { }
        }
        i++;
          goto _L3
_L2:
        obj = ((List) (obj)).iterator();
        i = ((flag) ? 1 : 0);
_L5:
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (Future)((Iterator) (obj)).next();
        if (!((Boolean)((Future) (obj1)).get()).booleanValue())
        {
            i = 2;
        }
        try
        {
            if (TapjoyCache.a(c))
            {
                TapjoyLog.i("TapjoyCache", "Caching thread completed");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            i = 2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            i = 2;
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (b != null)
        {
            b.onCachingComplete(i);
        }
        return;
    }

    r(TapjoyCache tapjoycache, JSONArray jsonarray, TJCacheListener tjcachelistener)
    {
        c = tapjoycache;
        a = jsonarray;
        b = tjcachelistener;
        super();
    }
}
