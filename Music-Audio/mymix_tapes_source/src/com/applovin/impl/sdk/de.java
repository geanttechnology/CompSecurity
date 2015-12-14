// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            bt, AppLovinAdImpl, bl, q, 
//            ax, z, df, AppLovinSdkImpl

class de extends bt
{

    private final AppLovinAdImpl a;
    private final AppLovinAdRewardListener b;
    private final Object c = new Object();
    private volatile boolean d;

    public de(AppLovinSdkImpl applovinsdkimpl, AppLovinAd applovinad, AppLovinAdRewardListener applovinadrewardlistener)
    {
        super("TaskValidateReward", applovinsdkimpl);
        d = false;
        a = (AppLovinAdImpl)applovinad;
        b = applovinadrewardlistener;
    }

    private void a(int i)
    {
        if (c())
        {
            return;
        }
        String s = "network_timeout";
        if (i >= 400 && i <= 500)
        {
            b.userRewardRejected(a, new HashMap(0));
            s = "rejected";
        } else
        {
            b.validationRequestFailed(a, i);
        }
        bl.a().a(a, s);
    }

    static void a(de de1, int i)
    {
        de1.a(i);
    }

    static void a(de de1, JSONObject jsonobject)
    {
        de1.a(jsonobject);
    }

    private void a(String s, Map map)
    {
        if (c())
        {
            return;
        }
        bl bl1 = bl.a();
        bl1.a(a, s);
        bl1.a(a, map);
        if (s.equals("accepted"))
        {
            b.userRewardVerified(a, map);
            return;
        }
        if (s.equals("quota_exceeded"))
        {
            b.userOverQuota(a, map);
            return;
        }
        if (s.equals("rejected"))
        {
            b.userRewardRejected(a, map);
            return;
        } else
        {
            b.validationRequestFailed(a, -400);
            return;
        }
    }

    private void a(JSONObject jsonobject)
    {
        if (c())
        {
            return;
        }
        Object obj;
        obj = q.a(jsonobject);
        q.a(((JSONObject) (obj)), f);
        try
        {
            jsonobject = ax.a((JSONObject)((JSONObject) (obj)).get("params"));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            try
            {
                jsonobject = new HashMap(0);
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                g.e(e, "Unable to parse API response", jsonobject);
                return;
            }
        }
        try
        {
            obj = ((JSONObject) (obj)).getString("result");
        }
        catch (Throwable throwable)
        {
            throwable = "network_timeout";
        }
        a(((String) (obj)), ((Map) (jsonobject)));
        return;
    }

    public void a(boolean flag)
    {
        synchronized (c)
        {
            d = flag;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    boolean c()
    {
        boolean flag;
        synchronized (c)
        {
            flag = d;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void run()
    {
        String s = z.b();
        String s1 = a.getClCode();
        HashMap hashmap = new HashMap(2);
        if (AppLovinSdkUtils.isValidString(s1))
        {
            hashmap.put("clcode", s1);
        } else
        {
            hashmap.put("clcode", "NO_CLCODE");
        }
        if (s != null)
        {
            hashmap.put("user_id", s);
        }
        a("vr", new JSONObject(hashmap), new df(this));
    }
}
