// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            HeapResourceFactory

class CacheEntryUpdater
{

    private final ResourceFactory resourceFactory;

    CacheEntryUpdater()
    {
        this(((ResourceFactory) (new HeapResourceFactory())));
    }

    CacheEntryUpdater(ResourceFactory resourcefactory)
    {
        resourceFactory = resourcefactory;
    }

    private boolean entryAndResponseHaveDateHeader(HttpCacheEntry httpcacheentry, HttpResponse httpresponse)
    {
        return httpcacheentry.getFirstHeader("Date") != null && httpresponse.getFirstHeader("Date") != null;
    }

    private boolean entryDateHeaderNewerThenResponse(HttpCacheEntry httpcacheentry, HttpResponse httpresponse)
    {
        httpcacheentry = DateUtils.parseDate(httpcacheentry.getFirstHeader("Date").getValue());
        for (httpresponse = DateUtils.parseDate(httpresponse.getFirstHeader("Date").getValue()); httpcacheentry == null || httpresponse == null || !httpcacheentry.after(httpresponse);)
        {
            return false;
        }

        return true;
    }

    private void removeCacheEntry1xxWarnings(List list, HttpCacheEntry httpcacheentry)
    {
        list = list.listIterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            if ("Warning".equals(((Header)list.next()).getName()))
            {
                Header aheader[] = httpcacheentry.getHeaders("Warning");
                int j = aheader.length;
                int i = 0;
                while (i < j) 
                {
                    if (aheader[i].getValue().startsWith("1"))
                    {
                        list.remove();
                    }
                    i++;
                }
            }
        } while (true);
    }

    private void removeCacheHeadersThatMatchResponse(List list, HttpResponse httpresponse)
    {
        httpresponse = httpresponse.getAllHeaders();
        int j = httpresponse.length;
label0:
        for (int i = 0; i < j; i++)
        {
            Header header = httpresponse[i];
            ListIterator listiterator = list.listIterator();
            do
            {
                if (!listiterator.hasNext())
                {
                    continue label0;
                }
                if (((Header)listiterator.next()).getName().equals(header.getName()))
                {
                    listiterator.remove();
                }
            } while (true);
        }

    }

    protected Header[] mergeHeaders(HttpCacheEntry httpcacheentry, HttpResponse httpresponse)
    {
        if (entryAndResponseHaveDateHeader(httpcacheentry, httpresponse) && entryDateHeaderNewerThenResponse(httpcacheentry, httpresponse))
        {
            return httpcacheentry.getAllHeaders();
        } else
        {
            ArrayList arraylist = new ArrayList(Arrays.asList(httpcacheentry.getAllHeaders()));
            removeCacheHeadersThatMatchResponse(arraylist, httpresponse);
            removeCacheEntry1xxWarnings(arraylist, httpcacheentry);
            arraylist.addAll(Arrays.asList(httpresponse.getAllHeaders()));
            return (Header[])arraylist.toArray(new Header[arraylist.size()]);
        }
    }

    public HttpCacheEntry updateCacheEntry(String s, HttpCacheEntry httpcacheentry, Date date, Date date1, HttpResponse httpresponse)
        throws IOException
    {
        Header aheader[];
        boolean flag;
        if (httpresponse.getStatusLine().getStatusCode() == 304)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Args.check(flag, "Response must have 304 status code");
        aheader = mergeHeaders(httpcacheentry, httpresponse);
        httpresponse = null;
        if (httpcacheentry.getResource() != null)
        {
            httpresponse = resourceFactory.copy(s, httpcacheentry.getResource());
        }
        return new HttpCacheEntry(date, date1, httpcacheentry.getStatusLine(), aheader, httpresponse);
    }
}
