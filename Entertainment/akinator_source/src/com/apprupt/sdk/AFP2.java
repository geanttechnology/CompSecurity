// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk:
//            Logger, CvAppInfo, CvCrypto, CvUrl, 
//            URLRequest, CvAppsList

public class AFP2
    implements Runnable
{

    private static final long MIN_SCAN_INTERVAL = 0x2932e00L;
    private static final long RETRY_DELAY = 0x493e0L;
    private static long nextScan = 0L;
    private final Context context;
    private final Logger.log log = Logger.get("AFP2");

    private AFP2(Context context1)
    {
        context = context1.getApplicationContext();
    }

    private void send(Set set, Collection collection)
    {
        JSONArray jsonarray = new JSONArray();
        if (jsonarray != null && jsonarray.length() > 0)
        {
            Iterator iterator = set.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (s != null)
                {
                    jsonarray.put(s);
                }
            } while (true);
        }
        jsonarray = new JSONArray();
        for (collection = collection.iterator(); collection.hasNext(); jsonarray.put((JSONObject)collection.next())) { }
        log.v(new Object[] {
            "packages collected", set, jsonarray
        });
        collection = new JSONObject();
        CvAppInfo cvappinfo = CvAppInfo.getInstance();
        try
        {
            collection.put("uid", cvappinfo.getUid());
            collection.put("processes", set);
            collection.put("packages", jsonarray);
        }
        // Misplaced declaration of an exception variable
        catch (Set set)
        {
            log.e(new Object[] {
                (new StringBuilder()).append("Error while building request (").append(set.getClass().getName()).append("): ").append(set.getMessage()).toString()
            });
            return;
        }
        log.v(new Object[] {
            "request data ready"
        });
        set = CvCrypto.encode(collection.toString().getBytes());
        URLRequest.post(CvUrl.build("/afp2")).setListener(new _cls2()).addPostParam("_", set).send();
        log.v(new Object[] {
            "request sent"
        });
    }

    static void start(Context context1)
    {
        long l = System.currentTimeMillis();
        if (nextScan > l)
        {
            Logger.get("AFP2").v(new Object[] {
                "AFP2 call to early"
            });
            return;
        } else
        {
            Logger.get("AFP2").v(new Object[] {
                "AFP2 start.."
            });
            nextScan = 0x493e0L + l;
            (new Thread(new AFP2(context1))).start();
            return;
        }
    }

    public void run()
    {
        CvAppInfo.getInstance().appsList.runningApps(new _cls1());
    }





/*
    static long access$202(long l)
    {
        nextScan = l;
        return l;
    }

*/

    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
