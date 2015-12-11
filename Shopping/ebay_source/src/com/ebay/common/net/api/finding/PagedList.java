// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finding;

import android.os.Handler;
import android.os.Message;
import com.ebay.common.net.AsyncList;
import com.ebay.common.net.CacheConfiguration;
import com.ebay.nautilus.kernel.util.FwLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class PagedList
    implements android.os.Handler.Callback, AsyncList, CacheConfiguration, ThreadFactory
{
    private static final class IteratorImpl
        implements ListIterator
    {

        private int currentPosition;
        private final List parent;

        public void add(Object obj)
        {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext()
        {
            return currentPosition < parent.size();
        }

        public boolean hasPrevious()
        {
            return currentPosition > 0;
        }

        public Object next()
        {
            if (currentPosition >= parent.size())
            {
                throw new NoSuchElementException();
            } else
            {
                List list = parent;
                int i = currentPosition;
                currentPosition = i + 1;
                return list.get(i);
            }
        }

        public int nextIndex()
        {
            return currentPosition;
        }

        public Object previous()
        {
            if (currentPosition == 0)
            {
                throw new NoSuchElementException();
            } else
            {
                List list = parent;
                int i = currentPosition - 1;
                currentPosition = i;
                return list.get(i);
            }
        }

        public int previousIndex()
        {
            return currentPosition - 1;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public void set(Object obj)
        {
            throw new UnsupportedOperationException();
        }

        public IteratorImpl(List list, int i)
        {
            parent = list;
            currentPosition = i;
        }
    }

    private static final class Page
    {

        public static final int STATE_FAILED = -1;
        public static final int STATE_LOADED = 1;
        public static final int STATE_NOT_LOADED = 0;
        public final int count;
        public int loadState;
        public final ArrayList rows;
        public final int start;

        public String toString()
        {
            loadState;
            JVM INSTR tableswitch -1 1: default 32
        //                       -1 95
        //                       0 32
        //                       1 89;
               goto _L1 _L2 _L1 _L3
_L1:
            String s = "";
_L5:
            return (new StringBuilder()).append("P(").append(start).append("-").append(String.valueOf((count + start) - 1)).append(s).append(')').toString();
_L3:
            s = " rdy";
            continue; /* Loop/switch isn't completed */
_L2:
            s = " err";
            if (true) goto _L5; else goto _L4
_L4:
        }

        public Page(int i, int j)
        {
            start = i;
            count = j;
            rows = new ArrayList(j);
            loadState = 0;
        }
    }

    public static interface Query
    {

        public abstract void fill(ArrayList arraylist, int i, int j)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException;

        public abstract int query()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException;
    }

    private static final class SubList
        implements List
    {

        private final int count;
        private final List parent;
        private final int start;

        public void add(int i, Object obj)
        {
            throw new UnsupportedOperationException();
        }

        public boolean add(Object obj)
        {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(int i, Collection collection)
        {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection)
        {
            throw new UnsupportedOperationException();
        }

        public void clear()
        {
            throw new UnsupportedOperationException();
        }

        public boolean contains(Object obj)
        {
            throw new UnsupportedOperationException();
        }

        public boolean containsAll(Collection collection)
        {
            throw new UnsupportedOperationException();
        }

        public Object get(int i)
        {
            if (i < 0 || i >= count)
            {
                throw new IndexOutOfBoundsException();
            } else
            {
                return parent.get(i - start);
            }
        }

        public int indexOf(Object obj)
        {
            throw new UnsupportedOperationException();
        }

        public boolean isEmpty()
        {
            return count == 0;
        }

        public Iterator iterator()
        {
            return listIterator();
        }

        public int lastIndexOf(Object obj)
        {
            throw new UnsupportedOperationException();
        }

        public ListIterator listIterator()
        {
            return listIterator(0);
        }

        public ListIterator listIterator(int i)
        {
            return new IteratorImpl(this, i);
        }

        public Object remove(int i)
        {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object obj)
        {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection collection)
        {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection collection)
        {
            throw new UnsupportedOperationException();
        }

        public Object set(int i, Object obj)
        {
            throw new UnsupportedOperationException();
        }

        public int size()
        {
            return count;
        }

        public List subList(int i, int j)
        {
            if (i < 0 || i > j || j > count)
            {
                throw new IndexOutOfBoundsException();
            }
            if (i == 0 && j == count)
            {
                return this;
            } else
            {
                return new SubList(this, i, j);
            }
        }

        public Object[] toArray()
        {
            throw new UnsupportedOperationException();
        }

        public Object[] toArray(Object aobj[])
        {
            throw new UnsupportedOperationException();
        }

        public SubList(List list, int i, int j)
        {
            parent = list;
            start = i;
            count = j - i;
        }
    }


    private static final int NET_HANDLER_FAILED = -1;
    private static final int NET_HANDLER_SUCCESS = 0;
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("PagedList", 3, "Log paged list data");
    private ArrayList cachedPages;
    private int count;
    private Page currentPage;
    private final ArrayList failedPages;
    private Handler handler;
    private ExecutorService loadPagePool;
    private final int maxCountPerPage;
    private int maxPagesCached;
    private com.ebay.common.net.AsyncList.NetworkListObserver netObserver;
    private int pagePrefetchLevel;
    private final Query query;
    private final ArrayList waitingOnPages;

    public PagedList(Query query1)
    {
        this(query1, 25, 5, 2);
    }

    public PagedList(Query query1, int i, int j, int k)
    {
        count = 0;
        currentPage = null;
        cachedPages = null;
        failedPages = new ArrayList();
        waitingOnPages = new ArrayList();
        netObserver = null;
        handler = null;
        loadPagePool = null;
        maxCountPerPage = i;
        setCacheLevel(j, k);
        query = query1;
    }

    private final void asyncLoadPage(final Page page)
    {
        this;
        JVM INSTR monitorenter ;
        if (log.isLoggable)
        {
            FwLog.logMethod(log, new Object[] {
                page
            });
        }
        if (loadPagePool == null)
        {
            loadPagePool = Executors.newFixedThreadPool(3, this);
        }
        page = new Runnable() {

            final PagedList this$0;
            final Page val$page;

            public void run()
            {
                loadPage(page);
            }

            
            {
                this$0 = PagedList.this;
                page = page1;
                super();
            }
        };
        loadPagePool.execute(page);
        this;
        JVM INSTR monitorexit ;
        return;
        page;
        throw page;
    }

    private final void clearPages()
    {
        this;
        JVM INSTR monitorenter ;
        if (loadPagePool != null)
        {
            loadPagePool.shutdownNow();
            loadPagePool = null;
        }
        currentPage = null;
        cachedPages = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private Object getAsync(int i)
    {
        this;
        JVM INSTR monitorenter ;
        int j = i - i % maxCountPerPage;
        if (currentPage == null || currentPage.start != j || currentPage.loadState != 1)
        {
            setPage(j, false);
        }
        Page page = currentPage;
        page;
        JVM INSTR monitorenter ;
        page.loadState;
        JVM INSTR tableswitch -1 1: default 241
    //                   -1 125
    //                   0 160
    //                   1 96;
           goto _L1 _L2 _L3 _L4
_L1:
        Object obj = null;
_L6:
        this;
        JVM INSTR monitorexit ;
        return obj;
_L4:
        obj = page.rows.get(i - page.start);
        page;
        JVM INSTR monitorexit ;
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        page;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        synchronized (failedPages)
        {
            failedPages.remove(page);
        }
        page.rows.clear();
        page.loadState = 0;
        asyncLoadPage(page);
_L3:
        if (netObserver != null)
        {
            netObserver.onGetNotReady();
        }
        synchronized (waitingOnPages)
        {
            if (!waitingOnPages.contains(page))
            {
                waitingOnPages.add(page);
                if (handler == null)
                {
                    handler = new Handler(this);
                }
            }
        }
        if (true) goto _L1; else goto _L7
_L7:
        exception1;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception1;
        exception2;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception2;
    }

    private void loadPage(Page page)
    {
        IOException ioexception;
        int i;
        i = -1;
        ioexception = null;
        query.fill(page.rows, page.start, page.count);
_L7:
        page;
        JVM INSTR monitorenter ;
        Object obj;
        if (ioexception == null)
        {
            i = 1;
        }
        page.loadState = i;
        obj1 = waitingOnPages;
        obj1;
        JVM INSTR monitorenter ;
        if (!waitingOnPages.remove(page)) goto _L2; else goto _L1
_L1:
        if (ioexception == null) goto _L4; else goto _L3
_L3:
        waitingOnPages.clear();
        handler.obtainMessage(-1, ioexception).sendToTarget();
_L2:
        obj1;
        JVM INSTR monitorexit ;
        page;
        JVM INSTR monitorexit ;
        return;
        obj;
        try
        {
            obj1 = new IOException(((OutOfMemoryError) (obj)).getLocalizedMessage());
            ((IOException) (obj1)).initCause(((Throwable) (obj)));
            throw obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Page page)
        {
            return;
        }
        synchronized (failedPages)
        {
            failedPages.add(page);
        }
        continue; /* Loop/switch isn't completed */
        page;
        obj1;
        JVM INSTR monitorexit ;
        throw page;
_L4:
        if (!waitingOnPages.isEmpty()) goto _L2; else goto _L5
_L5:
        handler.obtainMessage(0).sendToTarget();
          goto _L2
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        page;
        JVM INSTR monitorexit ;
        throw obj;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private final void logDump()
    {
        String as[] = new String[3];
        as[0] = (new StringBuilder()).append("count:").append(count).toString();
        as[1] = (new StringBuilder()).append("current:").append(currentPage).toString();
        as[2] = "cached:";
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append('{');
        if (cachedPages != null)
        {
            boolean flag = true;
            Iterator iterator1 = cachedPages.iterator();
            while (iterator1.hasNext()) 
            {
                Page page = (Page)iterator1.next();
                if (flag)
                {
                    flag = false;
                } else
                {
                    stringbuilder.append(',');
                }
                stringbuilder.append(' ').append(page);
            }
        }
        stringbuilder.append(" }");
        as[2] = (new StringBuilder()).append(as[2]).append(stringbuilder.toString()).toString();
        FwLog.logMethod(log, new Object[] {
            as[0], as[1], as[2]
        });
    }

    private void retry_loadPage(Page page)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        this;
        JVM INSTR monitorenter ;
        query.fill(page.rows, page.start, page.count);
        this;
        JVM INSTR monitorexit ;
        return;
        page;
        throw page;
    }

    private final void setPage(int i, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (log.isLoggable)
        {
            FwLog.logMethod(log, new Object[] {
                Integer.valueOf(i), Boolean.valueOf(flag)
            });
        }
        if (i == -1) goto _L2; else goto _L1
_L1:
        if (i != count) goto _L3; else goto _L2
_L2:
        currentPage = null;
_L19:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        int j;
        int k;
        int i2;
        j = count - 1;
        i2 = j - j % maxCountPerPage;
        j = maxCountPerPage * pagePrefetchLevel;
        break MISSING_BLOCK_LABEL_87;
_L21:
        if (cachedPages != null) goto _L5; else goto _L4
_L4:
        int i1 = -1;
_L10:
        if (cachedPages != null) goto _L7; else goto _L6
_L6:
        int j1 = -1;
_L11:
        l = (j - k) / maxCountPerPage + 1;
_L9:
        int l1;
        l1 = j;
        k1 = l;
        if (l >= maxPagesCached)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = j;
        k1 = l;
        if (k <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = j;
        k1 = l;
        if (k - maxCountPerPage < i1)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = j;
        k1 = l;
        if (k - maxCountPerPage > j1)
        {
            break; /* Loop/switch isn't completed */
        }
        k -= maxCountPerPage;
        l++;
        if (true) goto _L9; else goto _L8
_L5:
        i1 = ((Page)cachedPages.get(0)).start;
          goto _L10
_L7:
        j1 = ((Page)cachedPages.get(cachedPages.size() - 1)).start;
          goto _L11
_L8:
        if (k1 >= maxPagesCached || l1 >= i2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (maxCountPerPage + l1 < i1 || maxCountPerPage + l1 > j1)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 += maxCountPerPage;
        k1++;
        if (true) goto _L8; else goto _L12
_L12:
        if (log.isLoggable)
        {
            FwLog.println(log, (new StringBuilder()).append("new low:").append(k).append(", new high:").append(l1).append(", old low:").append(i1).append(", old high:").append(j1).toString());
        }
          goto _L13
_L22:
        obj1 = new ArrayList(k1);
        j = 0;
_L16:
        if (j >= k1)
        {
            break MISSING_BLOCK_LABEL_635;
        }
        l1 = k + maxCountPerPage * j;
        if (l1 < i1 || l1 > j1) goto _L15; else goto _L14
_L14:
        obj = (Page)cachedPages.get((l1 - i1) / maxCountPerPage);
        obj;
        JVM INSTR monitorenter ;
        if (((Page) (obj)).loadState != -1)
        {
            break MISSING_BLOCK_LABEL_516;
        }
        synchronized (failedPages)
        {
            failedPages.remove(obj);
        }
        ((Page) (obj)).rows.clear();
        obj.loadState = 0;
        asyncLoadPage(((Page) (obj)));
        obj;
        JVM INSTR monitorexit ;
_L17:
        ((ArrayList) (obj1)).add(obj);
        if (l1 != i)
        {
            break MISSING_BLOCK_LABEL_536;
        }
        currentPage = ((Page) (obj));
        j++;
          goto _L16
        obj1;
        arraylist;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L15:
        if (count - l1 <= maxCountPerPage)
        {
            break MISSING_BLOCK_LABEL_615;
        }
        l = maxCountPerPage;
_L18:
        obj = new Page(l1, l);
        if (!flag || l1 != i)
        {
            break MISSING_BLOCK_LABEL_627;
        }
        loadPage(((Page) (obj)));
          goto _L17
        l = count - l1;
          goto _L18
        asyncLoadPage(((Page) (obj)));
          goto _L17
        cachedPages = ((ArrayList) (obj1));
_L20:
        if (log.isLoggable)
        {
            logDump();
        }
          goto _L19
_L23:
        i = (i - i1) / maxCountPerPage;
        currentPage = (Page)cachedPages.get(i);
        obj = failedPages;
        obj;
        JVM INSTR monitorenter ;
        if (failedPages.isEmpty())
        {
            break MISSING_BLOCK_LABEL_767;
        }
        Page page;
        for (Iterator iterator1 = failedPages.iterator(); iterator1.hasNext(); asyncLoadPage(page))
        {
            page = (Page)iterator1.next();
            page.rows.clear();
            page.loadState = 0;
        }

        break MISSING_BLOCK_LABEL_760;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        failedPages.clear();
        obj;
        JVM INSTR monitorexit ;
          goto _L20
        Object obj;
        Exception exception;
        int l;
        int k1;
        if (i > j)
        {
            k = i - j;
        } else
        {
            k = 0;
        }
        if (i + j < i2)
        {
            j = i + j;
        } else
        {
            j = i2;
        }
          goto _L21
_L13:
        if (k == i1 && l1 == j1) goto _L23; else goto _L22
    }

    public void add(int i, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public boolean add(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public void clear()
    {
        clearPages();
    }

    public void close()
    {
        clearPages();
    }

    public boolean contains(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public Object get(int i)
    {
        if (i < 0 || i >= count)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return getAsync(i);
        }
    }

    public boolean handleMessage(Message message)
    {
        if (netObserver == null) goto _L2; else goto _L1
_L1:
        message.what;
        JVM INSTR tableswitch -1 0: default 32
    //                   -1 46
    //                   0 34;
           goto _L2 _L3 _L4
_L2:
        return true;
_L4:
        netObserver.onChanged();
        continue; /* Loop/switch isn't completed */
_L3:
        netObserver.onNetworkError((IOException)message.obj);
        if (true) goto _L2; else goto _L5
_L5:
    }

    public int indexOf(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public boolean isPrefetchEnabled()
    {
        return pagePrefetchLevel > 0;
    }

    public Iterator iterator()
    {
        return listIterator();
    }

    public int lastIndexOf(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public ListIterator listIterator()
    {
        return listIterator(0);
    }

    public ListIterator listIterator(int i)
    {
        return new IteratorImpl(this, i);
    }

    public Thread newThread(Runnable runnable)
    {
        runnable = Executors.defaultThreadFactory().newThread(runnable);
        try
        {
            runnable.setPriority(10);
        }
        catch (Exception exception)
        {
            return runnable;
        }
        return runnable;
    }

    public void registerObserver(com.ebay.common.net.AsyncList.NetworkListObserver networklistobserver)
    {
        if (networklistobserver != null)
        {
            netObserver = networklistobserver;
        }
    }

    public Object remove(int i)
    {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public void restartFetch(int i, int j, int k)
    {
        setCacheLevel(i, j);
        setPage(k, false);
    }

    public boolean retainAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final void retry()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        ArrayList arraylist = failedPages;
        arraylist;
        JVM INSTR monitorenter ;
        for (ArrayList arraylist1 = failedPages; !arraylist1.isEmpty(); arraylist1.remove(0))
        {
            Page page = (Page)arraylist1.get(0);
            page.rows.clear();
            retry_loadPage(page);
            page.loadState = 1;
        }

        break MISSING_BLOCK_LABEL_59;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
        arraylist;
        JVM INSTR monitorexit ;
    }

    public Object set(int i, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final void setCacheLevel(int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        int k = i;
        if (i < pagePrefetchLevel * 2 + 1)
        {
            k = pagePrefetchLevel * 2 + 1;
        }
        maxPagesCached = k;
        pagePrefetchLevel = j;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int size()
    {
        return count;
    }

    public final void startQuery()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        this;
        JVM INSTR monitorenter ;
        if (log.isLoggable)
        {
            FwLog.logMethod(log, new Object[0]);
        }
        clearPages();
        count = query.query();
        if (count > 0)
        {
            setPage(0, true);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public List subList(int i, int j)
    {
        if (i < 0 || i > j || j > count)
        {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0 && j == count)
        {
            return this;
        } else
        {
            return new SubList(this, i, j);
        }
    }

    public Object[] toArray()
    {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray(Object aobj[])
    {
        throw new UnsupportedOperationException();
    }

    public void unregisterObserver(com.ebay.common.net.AsyncList.NetworkListObserver networklistobserver)
    {
        if (netObserver == networklistobserver)
        {
            netObserver = null;
        }
    }


}
