// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import com.cyberlink.youcammakeup.database.more.f.b;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b

public class bo extends com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.b
{

    private static final String e = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/bo.getSimpleName();
    Collection d;
    private long f;

    public bo()
    {
    }

    public bo(HttpEntity httpentity, Collection collection)
    {
        super(httpentity);
        int i;
        if (collection != null)
        {
            i = collection.size();
        } else
        {
            i = 0;
        }
        a(httpentity, collection, i);
    }

    private void a(HttpEntity httpentity, Collection collection, int i)
    {
        if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            d = null;
            f = -1L;
            return;
        }
        httpentity = b;
        JSONArray jsonarray = httpentity.getJSONArray("notices");
        d = new ArrayList(jsonarray.length() + i);
        if (i != 0)
        {
            d.addAll(collection);
        }
        i = 0;
        while (i < jsonarray.length()) 
        {
            try
            {
                collection = new b((JSONObject)jsonarray.get(i));
                d.add(collection);
            }
            // Misplaced declaration of an exception variable
            catch (Collection collection)
            {
                d.add(null);
            }
            i++;
        }
        f = httpentity.getInt("totalCount");
    }

    public Collection a()
    {
        return d;
    }

    public long b()
    {
        return f;
    }

}
