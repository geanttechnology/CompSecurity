// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            n, ae, aq, br, 
//            bv

public class q extends n
{

    private String r;
    private aq s;

    public q(br br, JSONObject jsonobject, boolean flag)
        throws Exception
    {
        super(br, jsonobject, flag);
        s = null;
        r = jsonobject.getString("asset-url");
        a(jsonobject);
    }

    public String E()
    {
        return r;
    }

    public List a()
    {
        ArrayList arraylist = new ArrayList();
        if (c != null)
        {
            HashMap hashmap = new HashMap(2);
            hashmap.put("url", c.c());
            hashmap.put("crc", Long.valueOf(c.d()));
            hashmap.put("checkCache", Boolean.valueOf(false));
            arraylist.add(new n.a(this, bf.d.a, "coupon", hashmap));
        }
        if (e != null)
        {
            arraylist.add(new n.a(this, bf.d.c, "survey"));
        }
        return arraylist;
    }

    public void a(bv bv)
    {
        d = bv;
    }

    protected boolean o()
    {
        return true;
    }
}
