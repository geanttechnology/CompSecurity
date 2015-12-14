// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.utilities.uid.d;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

// Referenced classes of package com.inmobi.signals:
//            c, d

public class f extends NetworkRequest
{

    private int d;
    private int e;
    private c f;
    private List g;

    public f(String s, int i, int j, d d1, List list, c c1)
    {
        super(com.inmobi.commons.core.network.NetworkRequest.RequestType.POST, s, true, d1);
        d = i;
        e = j;
        g = list;
        f = c1;
        c.put("req_id", f.c());
        c.put("i_till", Integer.toString(f.d()));
        c.put("p_a_apps", d());
    }

    private String d()
    {
        JSONArray jsonarray = new JSONArray();
        for (int i = 0; i < g.size(); i++)
        {
            jsonarray.put(((com.inmobi.signals.d)g.get(i)).b());
        }

        return jsonarray.toString();
    }

    public int b()
    {
        return d;
    }

    public int c()
    {
        return e;
    }
}
