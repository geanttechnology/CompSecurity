// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b, ag

public class af extends b
{

    private List d;
    private JSONObject e;

    public af(HttpEntity httpentity)
    {
        super(httpentity);
        if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            d = null;
            e = null;
            return;
        } else
        {
            e = b;
            a(b);
            return;
        }
    }

    public af(JSONObject jsonobject)
    {
        e = jsonobject;
        a(jsonobject);
    }

    private void a(JSONObject jsonobject)
    {
        jsonobject = jsonobject.getJSONArray("makeupItems");
        if (jsonobject != null && jsonobject.length() > 0)
        {
            d = new ArrayList(jsonobject.length());
            int i = 0;
            while (i < jsonobject.length()) 
            {
                try
                {
                    JSONObject jsonobject1 = jsonobject.getJSONObject(i);
                    ag ag1 = new ag();
                    ag1.a = Long.parseLong(jsonobject1.getString("mkId"));
                    ag1.b = Long.parseLong(jsonobject1.getString("lastModified"));
                    d.add(ag1);
                }
                catch (Exception exception) { }
                i++;
            }
        } else
        {
            d = null;
        }
    }

    public List a()
    {
        return d;
    }

    public JSONObject b()
    {
        return e;
    }
}
