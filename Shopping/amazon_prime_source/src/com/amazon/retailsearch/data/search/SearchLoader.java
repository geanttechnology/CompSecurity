// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.search;

import com.amazon.retailsearch.client.UiInvocationHandler;
import com.amazon.retailsearch.data.SearchTask;
import com.amazon.retailsearch.deviceinfo.DeviceInfoLoader;
import com.amazon.searchapp.retailsearch.client.RetailSearchClient;
import com.amazon.searchapp.retailsearch.client.SearchListener;
import com.amazon.searchapp.retailsearch.client.SearchRequest;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.retailsearch.data.search:
//            ResultStream, SearchLoaderLogger, RequestListener, ResultEvent, 
//            ResultStreamListener

public class SearchLoader
    implements SearchTask
{

    private final RetailSearchClient client;
    private final ExecutorService executorService;
    private final SearchRequest initialRequest;
    private SearchRequest lastRequest;
    private RequestListener listener;
    private boolean loading;
    private String nextUrl;
    private int pageStartIndex;
    private final ResultStream resultStream = new ResultStream();
    private SearchLoaderLogger searchLoaderLogger;
    private final Set searchTaskListener = new LinkedHashSet();

    public SearchLoader(RetailSearchClient retailsearchclient, SearchRequest searchrequest, ExecutorService executorservice)
    {
        pageStartIndex = 0;
        lastRequest = null;
        searchLoaderLogger = new SearchLoaderLogger();
        client = retailsearchclient;
        initialRequest = searchrequest;
        executorService = executorservice;
    }

    public static SearchListener createListenerProxy(SearchListener searchlistener)
    {
        searchlistener = new UiInvocationHandler(searchlistener);
        return (SearchListener)Proxy.newProxyInstance(com/amazon/searchapp/retailsearch/client/SearchListener.getClassLoader(), new Class[] {
            com/amazon/searchapp/retailsearch/client/SearchListener
        }, searchlistener);
    }

    public void addListener(com.amazon.retailsearch.data.SearchTask.SearchTaskListener searchtasklistener)
    {
        resultStream.read(searchtasklistener);
        searchTaskListener.add(searchtasklistener);
    }

    public void clearError()
    {
        resultStream.getContent().subList(pageStartIndex, resultStream.getContent().size()).clear();
        (new ResultEvent() {

            final SearchLoader this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.clearError();
            }

            
            {
                this$0 = SearchLoader.this;
                super();
            }
        }).send(resultStream.getListeners());
    }

    public void close()
    {
        resultStream.addRecord(new ResultEvent() {

            final SearchLoader this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.close();
            }

            
            {
                this$0 = SearchLoader.this;
                super();
            }
        });
        resultStream.close();
        searchLoaderLogger.setATFLogged(false);
    }

    public SearchLoaderLogger getLogger()
    {
        return searchLoaderLogger;
    }

    protected String getNextUrl()
    {
        return nextUrl;
    }

    protected int getPageStartIndex()
    {
        return pageStartIndex;
    }

    public ResultStream getResultStream()
    {
        return resultStream;
    }

    public ResultStream.Status getStatus()
    {
        return resultStream.getStatus();
    }

    public boolean isLoading()
    {
        return loading;
    }

    public void load()
    {
        while (loading || ResultStream.Status.Done.equals(resultStream.getStatus())) 
        {
            return;
        }
        loading = true;
        SearchRequest searchrequest = initialRequest;
        ExecutorService executorservice;
        com.amazon.searchapp.retailsearch.client.SearchServiceCall searchservicecall;
        if (ResultStream.Status.Error.equals(resultStream.getStatus()))
        {
            clearError();
            if (lastRequest != null)
            {
                searchrequest = lastRequest;
            }
        } else
        if (nextUrl != null)
        {
            searchrequest = (new com.amazon.searchapp.retailsearch.client.SearchRequest.Builder()).setDataUrl(nextUrl).setImageCrop(true).setImageResolution(Integer.valueOf(0)).setDeviceInformation(DeviceInfoLoader.getInstance().getDeviceInfo()).build();
        }
        listener = new RequestListener(this, resultStream);
        searchservicecall = client.search(searchrequest, createListenerProxy(listener));
        listener.setServiceCall(searchservicecall);
        if (executorService != null)
        {
            executorservice = executorService;
        } else
        {
            executorservice = Executors.newSingleThreadExecutor();
        }
        lastRequest = searchrequest;
        executorservice.submit(searchservicecall);
    }

    public void loadNext()
    {
        load();
    }

    public void loadNext(int i)
    {
    }

    public boolean removeAllListeners()
    {
        com.amazon.retailsearch.data.SearchTask.SearchTaskListener searchtasklistener;
        for (Iterator iterator = searchTaskListener.iterator(); iterator.hasNext(); resultStream.detach(searchtasklistener))
        {
            searchtasklistener = (com.amazon.retailsearch.data.SearchTask.SearchTaskListener)iterator.next();
        }

        searchTaskListener.clear();
        searchLoaderLogger.setATFLogged(false);
        return true;
    }

    public boolean removeListener(com.amazon.retailsearch.data.SearchTask.SearchTaskListener searchtasklistener)
    {
        resultStream.detach(searchtasklistener);
        if (!searchTaskListener.contains(searchtasklistener))
        {
            searchTaskListener.remove(searchtasklistener);
        }
        return true;
    }

    public void retry()
    {
        load();
    }

    protected void setLoading(boolean flag)
    {
        loading = flag;
    }

    protected void setNextUrl(String s)
    {
        nextUrl = s;
    }

    protected void setPageStartIndex(int i)
    {
        pageStartIndex = i;
    }
}
