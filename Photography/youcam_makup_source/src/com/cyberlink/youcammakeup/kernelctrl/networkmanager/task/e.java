// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import com.cyberlink.youcammakeup.database.a.a;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b

public class e extends b
{

    private List d;

    public e()
    {
    }

    public e(HttpEntity httpentity)
    {
        super(httpentity);
        if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            d = null;
            return;
        } else
        {
            d = a(b);
            return;
        }
    }

    public static List a(JSONObject jsonobject)
    {
        jsonobject = jsonobject.getJSONArray("result");
        int j = jsonobject.length();
        ArrayList arraylist = new ArrayList(j);
        int i = 0;
        while (i < j) 
        {
            try
            {
                arraylist.add(new a(jsonobject.getJSONObject(i)));
            }
            catch (Exception exception) { }
            i++;
        }
        return arraylist;
    }

    public List a()
    {
        return d;
    }

    public JSONObject b()
    {
        return b;
    }
}
