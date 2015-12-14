// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import com.cyberlink.youcammakeup.database.more.a.d;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b

public class bb extends b
{

    private static final String d = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/bb.getName();
    private Collection e;
    private int f;

    public bb()
    {
    }

    public bb(HttpEntity httpentity)
    {
        super(httpentity);
        if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            e = null;
            f = 0;
            return;
        }
        httpentity = b;
        JSONArray jsonarray = httpentity.getJSONArray("categoryList");
        int j = jsonarray.length();
        e = new ArrayList(j);
        int i = 0;
        while (i < j) 
        {
            Object obj = (JSONObject)jsonarray.get(i);
            try
            {
                obj = new d(((JSONObject) (obj)));
                e.add(obj);
            }
            catch (Exception exception)
            {
                e.add(null);
            }
            i++;
        }
        f = httpentity.getInt("totalCount");
    }

    public Collection a()
    {
        return e;
    }

    public void a(int i)
    {
        f = i;
    }

    public void a(Collection collection)
    {
        e = collection;
    }

}
