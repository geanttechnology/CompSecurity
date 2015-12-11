// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

// Referenced classes of package a.a:
//            ay, aw

public final class au
{

    public JSONArray a;

    public au(ay ay1)
    {
        a = new JSONArray();
        ay1 = ay1.c().iterator();
        do
        {
            if (!ay1.hasNext())
            {
                break;
            }
            Object obj = ((aw)ay1.next()).a();
            if (obj != null)
            {
                a.put(obj);
            }
        } while (true);
    }
}
