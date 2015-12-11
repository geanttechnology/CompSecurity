// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPControlChannelStateMachine, TPLog, TPCFHttp, TwinPrimeSDKPvt

public class TPCookieManager extends CookieManager
{
    private static class SyncTask extends Thread
    {

        private final BlockingQueue queue;

        private void privRun()
        {
label0:
            do
            {
                try
                {
                    Object obj = (QueueItem)queue.take();
                    android.webkit.CookieManager cookiemanager = android.webkit.CookieManager.getInstance();
                    String s = ((QueueItem) (obj)).uri;
                    obj = ((QueueItem) (obj)).responseHeaders.entrySet().iterator();
                    do
                    {
                        Object obj1;
                        do
                        {
                            if (!((Iterator) (obj)).hasNext())
                            {
                                continue label0;
                            }
                            obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                        } while (((java.util.Map.Entry) (obj1)).getKey() == null || !((String)((java.util.Map.Entry) (obj1)).getKey()).equalsIgnoreCase("Set-Cookie"));
                        obj1 = ((List)((java.util.Map.Entry) (obj1)).getValue()).iterator();
                        while (((Iterator) (obj1)).hasNext()) 
                        {
                            cookiemanager.setCookie(s, (String)((Iterator) (obj1)).next());
                        }
                    } while (true);
                }
                catch (InterruptedException interruptedexception) { }
            } while (true);
        }

        public void add(String s, Map map)
        {
            queue.add(new QueueItem(s, map));
        }

        public void run()
        {
            try
            {
                privRun();
                return;
            }
            catch (Throwable throwable)
            {
                TwinPrimeSDKPvt.disableSDK();
            }
        }

        private SyncTask()
        {
            queue = new LinkedBlockingDeque();
        }

    }

    private static class SyncTask.QueueItem
    {

        Map responseHeaders;
        String uri;

        public SyncTask.QueueItem(String s, Map map)
        {
            uri = s;
            responseHeaders = map;
        }
    }


    private static CookieHandler appCookieHandler = null;
    private final SyncTask syncTask;

    public TPCookieManager()
    {
        this(null, null);
    }

    public TPCookieManager(CookieStore cookiestore, CookiePolicy cookiepolicy)
    {
        super(cookiestore, cookiepolicy);
        syncTask = new SyncTask();
    }

    protected static void removeAcceleratorIPCookies()
    {
        Object obj = TPControlChannelStateMachine.getInstance().accIPAddrStr;
        URI uri = new URI("http", ((String) (obj)), null, null);
        Object obj1 = CookieHandler.getDefault();
        if ((obj1 instanceof CookieManager) && !(obj1 instanceof TPCookieManager))
        {
            obj1 = ((CookieManager)obj1).getCookieStore();
            for (Iterator iterator = ((CookieStore) (obj1)).getCookies().iterator(); iterator.hasNext();)
            {
                HttpCookie httpcookie = (HttpCookie)iterator.next();
                if (httpcookie.getDomain().equalsIgnoreCase(((String) (obj))))
                {
                    ((CookieStore) (obj1)).remove(uri, httpcookie);
                }
            }

        }
        if (appCookieHandler instanceof CookieManager)
        {
            CookieStore cookiestore = ((CookieManager)appCookieHandler).getCookieStore();
            Iterator iterator1 = cookiestore.getCookies().iterator();
            while (iterator1.hasNext()) 
            {
                HttpCookie httpcookie1 = (HttpCookie)iterator1.next();
                if (httpcookie1.getDomain().equalsIgnoreCase(((String) (obj))))
                {
                    cookiestore.remove(uri, httpcookie1);
                }
            }
        }
          goto _L1
        obj;
        if (TPLog.LOG11.isLoggable("TPCookieManager"))
        {
            ((Exception) (obj)).printStackTrace();
        }
_L3:
        return;
_L1:
        if (true) goto _L3; else goto _L2
_L2:
    }

    protected static void setSelfAsDefault()
    {
        CookieHandler cookiehandler = CookieHandler.getDefault();
        if (cookiehandler == null || (cookiehandler instanceof TPCookieManager))
        {
            return;
        } else
        {
            appCookieHandler = cookiehandler;
            CookieHandler.setDefault(new TPCookieManager());
            return;
        }
    }

    public Map get(URI uri, Map map)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        URI uri1 = uri;
        if (!TPCFHttp.isRewritten(uri)) goto _L2; else goto _L1
_L1:
        uri = TPCFHttp.getOriginalURI(uri);
        uri1 = uri;
        if (uri != null) goto _L2; else goto _L3
_L3:
        uri = new HashMap();
_L5:
        this;
        JVM INSTR monitorexit ;
        return uri;
_L2:
        if (appCookieHandler != null)
        {
            uri = appCookieHandler.get(uri1, map);
            continue; /* Loop/switch isn't completed */
        }
        uri = super.get(uri1, map);
        if (true) goto _L5; else goto _L4
_L4:
        uri;
        throw uri;
    }

    public void put(URI uri, Map map)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        URI uri1 = uri;
        if (!TPCFHttp.isRewritten(uri)) goto _L2; else goto _L1
_L1:
        uri = TPCFHttp.getOriginalURI(uri);
        uri1 = uri;
        if (uri != null) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        super.put(uri1, map);
        if (appCookieHandler != null)
        {
            appCookieHandler.put(uri1, map);
        }
        if (android.webkit.CookieManager.getInstance().acceptCookie())
        {
            syncTask.add(uri1.toString(), map);
        }
        if (true) goto _L3; else goto _L4
_L4:
        uri;
        throw uri;
    }

}
