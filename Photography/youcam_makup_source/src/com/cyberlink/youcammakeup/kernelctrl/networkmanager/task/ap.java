// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import com.cyberlink.youcammakeup.database.more.a.a;
import com.cyberlink.youcammakeup.database.more.i.f;
import com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b, aq

public class ap extends b
{

    private final String d = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/ap.getName();
    private final long e;
    private final Collection f;
    private final long g;
    private aq h;
    private final long i;
    private final List j;
    private JSONArray k;
    private MKCategoryV2Status l;

    public ap(HttpEntity httpentity)
    {
        super(httpentity);
        if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            e = -1L;
            f = null;
            g = -1L;
            h = null;
            i = -1L;
            j = null;
        } else
        {
            JSONObject jsonobject = b;
            httpentity = jsonobject.getJSONObject("ymkStatus");
            e = httpentity.getJSONObject("filmStatus").getLong("maxFilmId");
            JSONArray jsonarray = httpentity.getJSONArray("categoryStatus");
            int k1 = jsonarray.length();
            f = new ArrayList(k1);
            int i1 = 0;
            while (i1 < k1) 
            {
                Object obj = (JSONObject)jsonarray.get(i1);
                try
                {
                    obj = new a(((JSONObject) (obj)));
                    f.add(obj);
                }
                catch (Exception exception1)
                {
                    f.add(null);
                }
                i1++;
            }
            g = httpentity.getJSONObject("categoryListStatus").getLong("lastModified");
            jsonobject = jsonobject.getJSONObject("noticeStatus");
            try
            {
                h = new aq(jsonobject);
            }
            catch (Exception exception)
            {
                h = null;
            }
            i = httpentity.getJSONObject("mkStatus").getLong("maxMKId");
            if (httpentity.has("skuStatus"))
            {
                k = httpentity.getJSONArray("skuStatus");
                int l1 = k.length();
                j = new ArrayList(l1);
                for (int j1 = 0; j1 < l1; j1++)
                {
                    f f1 = new f(k.getJSONObject(j1));
                    j.add(f1);
                }

            } else
            {
                j = null;
            }
            if (httpentity.has("mkCategoryV2Status"))
            {
                try
                {
                    l = new MKCategoryV2Status(httpentity.getJSONObject("mkCategoryV2Status"));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (HttpEntity httpentity)
                {
                    l = null;
                }
                return;
            }
        }
    }

    public long a()
    {
        return e;
    }

    public Collection b()
    {
        return f;
    }

    public long c()
    {
        return g;
    }

    public aq e()
    {
        return h;
    }

    public long f()
    {
        return i;
    }

    public List g()
    {
        return j;
    }

    public JSONArray h()
    {
        return k;
    }

    public MKCategoryV2Status i()
    {
        return l;
    }
}
