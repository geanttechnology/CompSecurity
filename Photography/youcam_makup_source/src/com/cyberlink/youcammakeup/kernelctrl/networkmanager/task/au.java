// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            at

public class au
{

    private static String c = "MakeupItemTree";
    JSONObject a;
    List b;

    public au(JSONObject jsonobject)
    {
        a = jsonobject;
        JSONArray jsonarray = jsonobject.getJSONArray("makeupItemTree");
        int j = jsonarray.length();
        b = new ArrayList(j);
        int i = 0;
        while (i < j) 
        {
            try
            {
                jsonobject = new at(jsonarray.getJSONObject(i));
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject = null;
            }
            b.add(jsonobject);
            i++;
        }
    }

    public List a()
    {
        return b;
    }

    public JSONObject b()
    {
        return a;
    }

}
