// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.info.f;
import com.inmobi.signals.a.a;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.signals:
//            m

public class l
{

    private static final String a = com/inmobi/signals/l.getSimpleName();
    private long b;
    private a c;
    private Map d;
    private f e;
    private List f;
    private List g;

    public l()
    {
        a(Calendar.getInstance().getTimeInMillis());
    }

    public JSONObject a()
    {
        boolean flag = false;
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray;
        int i;
        try
        {
            jsonobject.put("ts", b);
            if (c != null)
            {
                if (c.a() != null)
                {
                    jsonobject.put("s-co", c.a());
                }
                if (c.b() != null)
                {
                    jsonobject.put("s-ho", c.b());
                }
            }
            if (d != null && !d.isEmpty())
            {
                jsonobject.put("l", new JSONObject(d));
            }
            if (e != null)
            {
                jsonobject.put("s", e.b());
            }
            jsonarray = new JSONArray();
        }
        catch (JSONException jsonexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while converting IceSample to string.", jsonexception);
            return jsonobject;
        }
        i = 0;
        if (i >= f.size())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonarray.put(((m)f.get(i)).b());
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_145;
_L1:
        if (jsonarray.length() > 0)
        {
            jsonobject.put("w", jsonarray);
        }
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        jsonarray = new JSONArray();
        i = ((flag) ? 1 : 0);
_L4:
        if (i >= g.size())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonarray.put(((com.inmobi.signals.activityrecognition.a)g.get(i)).a());
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (jsonarray.length() > 0)
        {
            jsonobject.put("ar", jsonarray);
        }
        return jsonobject;
    }

    public void a(long l1)
    {
        b = l1;
    }

    public void a(f f1)
    {
        e = f1;
    }

    public void a(a a1)
    {
        c = a1;
    }

    public void a(List list)
    {
        f = list;
    }

    public void a(Map map)
    {
        d = map;
    }

    public void b(List list)
    {
        g = list;
    }

}
