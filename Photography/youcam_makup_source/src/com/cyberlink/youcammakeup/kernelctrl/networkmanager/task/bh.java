// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import com.cyberlink.youcammakeup.database.more.l.c;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b

public class bh extends b
{

    public static final String d = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/bh.getSimpleName();
    private AbstractList e;
    private int f;
    private List g;

    public bh()
    {
        e = null;
        f = -1;
    }

    public bh(HttpEntity httpentity)
    {
        super(httpentity);
        if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            e = null;
            f = -1;
            return;
        } else
        {
            httpentity = b;
            g = a(httpentity);
            f = httpentity.getInt("totalCount");
            return;
        }
    }

    public static List a(JSONObject jsonobject)
    {
        jsonobject = jsonobject.getJSONArray("templates");
        int j = jsonobject.length();
        ArrayList arraylist = new ArrayList(j);
        int i = 0;
        while (i < j) 
        {
            try
            {
                arraylist.add(new c(jsonobject.getJSONObject(i)));
            }
            catch (Exception exception) { }
            i++;
        }
        return arraylist;
    }

    public JSONObject a()
    {
        return b;
    }

    public List b()
    {
        return g;
    }

    public int c()
    {
        return f;
    }

}
