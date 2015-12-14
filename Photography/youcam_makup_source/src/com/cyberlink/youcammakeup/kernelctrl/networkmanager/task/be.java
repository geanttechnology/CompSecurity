// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import com.cyberlink.youcammakeup.database.more.a.b;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b

public class be extends com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.b
{

    private String d;
    private int e;
    private Collection f;

    public be()
    {
        d = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/be.getName();
        e = -1;
        f = null;
    }

    public be(HttpEntity httpentity, Collection collection)
    {
        super(httpentity);
        d = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/be.getName();
        if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            e = -1;
            f = null;
            return;
        }
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
        httpentity = b;
        JSONArray jsonarray = httpentity.getJSONArray("filmList");
        f = new ArrayList(jsonarray.length() + i);
        if (i != 0)
        {
            f.addAll(collection);
        }
        i = 0;
        while (i < jsonarray.length()) 
        {
            collection = (JSONObject)jsonarray.get(i);
            try
            {
                collection = new b(collection);
                f.add(collection);
            }
            // Misplaced declaration of an exception variable
            catch (Collection collection)
            {
                f.add(null);
            }
            i++;
        }
        e = httpentity.getInt("totalCount");
    }

    public int a()
    {
        return e;
    }

    public void a(Collection collection)
    {
        f = collection;
    }

    public Collection b()
    {
        return f;
    }
}
