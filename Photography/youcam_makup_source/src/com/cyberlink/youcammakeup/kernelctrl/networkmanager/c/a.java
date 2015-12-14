// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.c;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.b;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.c:
//            b

public class a extends b
{

    private List d;

    public a()
    {
        d = new ArrayList();
    }

    public a(HttpEntity httpentity)
    {
        super(httpentity);
        d = new ArrayList();
        d = a(b, c);
    }

    public static long a(JSONObject jsonobject, String s)
    {
        return Long.parseLong(jsonobject.getString(s));
    }

    public static List a(JSONObject jsonobject, com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        m.c("GetPromotionListResponse", String.valueOf(jsonobject));
        if (responsestatus == com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a && jsonobject != null) goto _L2; else goto _L1
_L1:
        return arraylist;
_L2:
        if ((jsonobject = jsonobject.getJSONArray("promotionList")) != null)
        {
            int j = jsonobject.length();
            int i = 0;
            while (i < j) 
            {
                responsestatus = jsonobject.getJSONObject(i);
                arraylist.add(new com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b(a(((JSONObject) (responsestatus)), "promotionId"), responsestatus.getString("title"), responsestatus.getString("message"), responsestatus.getString("actionURL"), responsestatus.getString("coverImgURL"), a(((JSONObject) (responsestatus)), "endDate"), a(((JSONObject) (responsestatus)), "lastModified")));
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
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
