// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b

public class y extends b
{

    private static String d = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/y.getName();
    private List e;
    private int f;

    public y()
    {
    }

    public y(HttpEntity httpentity, List list)
    {
        super(httpentity);
        int i;
        if (list != null)
        {
            i = list.size();
        } else
        {
            i = 0;
        }
        a(httpentity, list, i);
    }

    private void a(HttpEntity httpentity, List list, int i)
    {
        if (c == com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a) goto _L2; else goto _L1
_L1:
        e = null;
        f = 0;
_L4:
        return;
_L2:
        httpentity = b;
        JSONArray jsonarray = httpentity.getJSONArray("itemList");
        e = new ArrayList(jsonarray.length() + i);
        if (i != 0)
        {
            e.addAll(list);
        }
        i = 0;
        do
        {
            if (i >= jsonarray.length())
            {
                continue; /* Loop/switch isn't completed */
            }
            try
            {
                list = new MakeupItemMetadata((JSONObject)jsonarray.get(i));
                e.add(list);
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                e.add(null);
                list.printStackTrace();
            }
            i++;
        } while (true);
        if (!httpentity.has("totalCount")) goto _L4; else goto _L3
_L3:
        f = httpentity.getInt("totalCount");
        return;
    }

    public List a()
    {
        return e;
    }

    public void a(List list)
    {
        e = list;
    }

}
