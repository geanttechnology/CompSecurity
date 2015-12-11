// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.client;

import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.retailsearch.web.WebSearchFilter;
import com.amazon.searchapp.retailsearch.client.RetailSearchServiceCall;
import com.amazon.searchapp.retailsearch.client.SearchListener;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.retailsearch.client:
//            UiInvocationHandler

public class SearchClientUtil
{

    private static final String ALIAS_REFINEMENT = "i";
    private static final String KEYWORDS_REFINEMENT = "k";
    private static final String NODE_REFINEMENT = "n";
    private static final String REFINEMENT_SEPERATOR = ",";
    private static final String REFINEMENT_VALUE_SEPARATOR = ":";
    private static ExecutorService executorService;
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/client/SearchClientUtil);

    public SearchClientUtil()
    {
    }

    private static ExecutorService createExecutorService()
    {
        ThreadPoolExecutor threadpoolexecutor = new ThreadPoolExecutor(10, 10, 15000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        threadpoolexecutor.allowCoreThreadTimeOut(true);
        return threadpoolexecutor;
    }

    public static SearchListener createListenerProxy(SearchListener searchlistener)
    {
        searchlistener = new UiInvocationHandler(searchlistener);
        return (SearchListener)Proxy.newProxyInstance(com/amazon/searchapp/retailsearch/client/SearchListener.getClassLoader(), new Class[] {
            com/amazon/searchapp/retailsearch/client/SearchListener
        }, searchlistener);
    }

    private static void execute(Runnable runnable)
    {
        getExecutorService().submit(runnable);
    }

    public static RetailSearchServiceCall executeRequest(RetailSearchServiceCall retailsearchservicecall)
    {
        try
        {
            execute(new Runnable(retailsearchservicecall) {

                final RetailSearchServiceCall val$searchCall;

                public void run()
                {
                    try
                    {
                        searchCall.execute();
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        return;
                    }
                }

            
            {
                searchCall = retailsearchservicecall;
                super();
            }
            });
        }
        catch (Exception exception)
        {
            log.error("Failed to execute service call", exception);
            return retailsearchservicecall;
        }
        return retailsearchservicecall;
    }

    public static String filterToRefinement(String s, String s1)
    {
        if (s == null)
        {
            return null;
        }
        int j = s.length();
        StringBuilder stringbuilder;
        int i;
        if (s1 != null)
        {
            i = s1.length();
        } else
        {
            i = 0;
        }
        stringbuilder = new StringBuilder(i + j);
        s = WebSearchFilter.splitFilters(s).iterator();
        do
        {
            if (!s.hasNext())
            {
                break;
            }
            WebSearchFilter websearchfilter = (WebSearchFilter)s.next();
            String s2 = websearchfilter.getFilterValue();
            if (s2 != null && s2.length() != 0)
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(",");
                }
                if (stringbuilder.length() == 0 && websearchfilter.isAlias())
                {
                    stringbuilder.append("i").append(":").append(s2);
                } else
                {
                    stringbuilder.append("n").append(":").append(s2);
                }
            }
        } while (true);
        if (s1 != null && s1.length() > 0)
        {
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(",");
            }
            stringbuilder.append("k").append(":").append(s1);
        }
        return stringbuilder.toString();
    }

    private static ExecutorService getExecutorService()
    {
        com/amazon/retailsearch/client/SearchClientUtil;
        JVM INSTR monitorenter ;
        ExecutorService executorservice;
        if (executorService == null)
        {
            executorService = createExecutorService();
        }
        executorservice = executorService;
        com/amazon/retailsearch/client/SearchClientUtil;
        JVM INSTR monitorexit ;
        return executorservice;
        Exception exception;
        exception;
        throw exception;
    }

}
