// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import com.smule.android.network.core.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.android.network.models:
//            AccountIcon

public class g extends t
{

    private static final String d = com/smule/android/network/models/g.getName();
    public AccountIcon accountIcon;
    public List apps;
    public int b;
    public int c;
    private HashMap e;
    private HashMap f;
    public String webUrl;

    public g()
    {
        apps = new ArrayList();
        e = new HashMap();
        f = new HashMap();
    }

    public void setPerformances(List list)
    {
        Map map;
        for (list = list.iterator(); list.hasNext(); e.put(map.get("app"), Integer.valueOf((String)map.get("numPerformances"))))
        {
            map = (Map)list.next();
        }

    }

    public void setPlayers(List list)
    {
        Map map;
        for (list = list.iterator(); list.hasNext(); f.put(map.get("app"), map.get("playerId")))
        {
            map = (Map)list.next();
        }

    }

    public void setSocial(Map map)
    {
        b = Integer.parseInt(map.get("numFollowers").toString());
        c = Integer.parseInt(map.get("numFollowees").toString());
    }

}
