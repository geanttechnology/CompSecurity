// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.sdk.AppLovinLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl, bo, ax, bw, 
//            n, bn, PostbackServiceImpl

public class bm
{

    private final AppLovinSdkImpl a;
    private final AppLovinLogger b;
    private ArrayList c;
    private ArrayList d;
    private final Object e;
    private final SharedPreferences f;

    bm(AppLovinSdkImpl applovinsdkimpl)
    {
        if (applovinsdkimpl == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        } else
        {
            a = applovinsdkimpl;
            b = applovinsdkimpl.getLogger();
            f = applovinsdkimpl.getApplicationContext().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
            e = new Object();
            c = c();
            d = new ArrayList();
            return;
        }
    }

    private bo a(String s)
    {
        try
        {
            s = new JSONObject(s);
            int i = s.getInt("attemptNumber");
            s = new bo(this, s.getString("targetUrl"), ax.a(s.getJSONObject("requestBody")), i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            b.w("PersistentPostbackManager", "Unable to inflate postback request from JSON.", s);
            return null;
        }
        return s;
    }

    static AppLovinLogger a(bm bm1)
    {
        return bm1.b;
    }

    static void a(bm bm1, bo bo1)
    {
        bm1.d(bo1);
    }

    private void a(bo bo1)
    {
        synchronized (e)
        {
            b(bo1);
            c(bo1);
        }
        return;
        bo1;
        obj;
        JVM INSTR monitorexit ;
        throw bo1;
    }

    static void b(bm bm1, bo bo1)
    {
        bm1.e(bo1);
    }

    private void b(bo bo1)
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        int i = ((Integer)a.a(bw.bl)).intValue();
        if (c.size() >= i)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        c.add(bo1);
        d();
        b.d("PersistentPostbackManager", (new StringBuilder()).append("Enqueued postback: ").append(bo1).toString());
_L2:
        return;
        b.w("PersistentPostbackManager", (new StringBuilder()).append("Persistent queue has reached maximum size; postback retried in memory only.").append(bo1).toString());
        if (true) goto _L2; else goto _L1
_L1:
        bo1;
        obj;
        JVM INSTR monitorexit ;
        throw bo1;
    }

    private ArrayList c()
    {
        if (n.b())
        {
            Object obj = f.getStringSet("com.applovin.sdk.impl.postbackQueue.key", new LinkedHashSet(0));
            ArrayList arraylist = new ArrayList(Math.max(1, ((Set) (obj)).size()));
            int i = ((Integer)a.a(bw.bm)).intValue();
            b.d("PersistentPostbackManager", (new StringBuilder()).append("Deserializing ").append(((Set) (obj)).size()).append(" postback(s).").toString());
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                String s = (String)((Iterator) (obj)).next();
                bo bo1 = a(s);
                if (bo1 != null)
                {
                    if (bo1.a() > i)
                    {
                        arraylist.add(bo1);
                    } else
                    {
                        b.d("PersistentPostbackManager", (new StringBuilder()).append("Skipping deserialization because maximum attempt count exceeded for postback: ").append(bo1).toString());
                    }
                } else
                {
                    b.e("PersistentPostbackManager", (new StringBuilder()).append("Unable to deserialize postback json: ").append(s).toString());
                }
            }

            b.d("PersistentPostbackManager", (new StringBuilder()).append("Successfully loaded postback queue with ").append(arraylist.size()).append(" postback(s).").toString());
            return arraylist;
        } else
        {
            b.d("PersistentPostbackManager", "Loading new postback queue due to old Android version...");
            return new ArrayList();
        }
    }

    private void c(bo bo1)
    {
        b.d("PersistentPostbackManager", (new StringBuilder()).append("Preparing to submit postback...").append(bo1).toString());
        synchronized (e)
        {
            bo1.a(bo1.a() + 1);
            d();
        }
        int i = ((Integer)a.a(bw.bm)).intValue();
        if (bo1.a() > i)
        {
            b.w("PersistentPostbackManager", (new StringBuilder()).append("Exceeded maximum persisted attempt count of ").append(i).append(". Dequeuing postback: ").append(bo1).toString());
            d(bo1);
            return;
        } else
        {
            a.getPostbackService().dispatchPostbackAsync(bo1.b(), bo1.c(), new bn(this, bo1));
            return;
        }
        bo1;
        obj;
        JVM INSTR monitorexit ;
        throw bo1;
    }

    private void d()
    {
        if (n.b())
        {
            LinkedHashSet linkedhashset = new LinkedHashSet(c.size());
            Iterator iterator = c.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = f((bo)iterator.next());
                if (s != null)
                {
                    linkedhashset.add(s);
                }
            } while (true);
            f.edit().putStringSet("com.applovin.sdk.impl.postbackQueue.key", linkedhashset).commit();
            b.d("PersistentPostbackManager", "Wrote updated postback queue to disk.");
            return;
        } else
        {
            b.d("PersistentPostbackManager", "Skipping writing postback queue to disk due to old Android version...");
            return;
        }
    }

    private void d(bo bo1)
    {
        synchronized (e)
        {
            c.remove(bo1);
            d();
        }
        b.d("PersistentPostbackManager", (new StringBuilder()).append("Dequeued successfully transmitted postback: ").append(bo1).toString());
        return;
        bo1;
        obj;
        JVM INSTR monitorexit ;
        throw bo1;
    }

    private void e(bo bo1)
    {
        synchronized (e)
        {
            d.add(bo1);
        }
        return;
        bo1;
        obj;
        JVM INSTR monitorexit ;
        throw bo1;
    }

    private String f(bo bo1)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("attemptNumber", bo1.a()).put("targetUrl", bo1.b()).put("requestBody", new JSONObject(bo1.c()));
            bo1 = jsonobject.toString();
        }
        // Misplaced declaration of an exception variable
        catch (bo bo1)
        {
            b.w("PersistentPostbackManager", "Unable to serialize postback request to JSON.", bo1);
            return null;
        }
        return bo1;
    }

    public void a()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); c((bo)iterator.next())) { }
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    public void a(String s, Map map)
    {
        a(new bo(this, s, map));
    }

    public void b()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = d.iterator(); iterator.hasNext(); c((bo)iterator.next())) { }
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        d.clear();
        obj;
        JVM INSTR monitorexit ;
    }
}
