// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.params.ConnPerRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn.tsccm:
//            BasicPoolEntry, WaitingThread

public class RouteSpecificPool
{

    protected final ConnPerRoute connPerRoute;
    protected final LinkedList freeEntries;
    public HttpClientAndroidLog log;
    protected final int maxEntries;
    protected int numEntries;
    protected final HttpRoute route;
    protected final Queue waitingThreads;

    public RouteSpecificPool(HttpRoute httproute, int i)
    {
        log = new HttpClientAndroidLog(getClass());
        route = httproute;
        maxEntries = i;
        connPerRoute = new ConnPerRoute() {

            final RouteSpecificPool this$0;

            public int getMaxForRoute(HttpRoute httproute1)
            {
                return maxEntries;
            }

            
            {
                this$0 = RouteSpecificPool.this;
                super();
            }
        };
        freeEntries = new LinkedList();
        waitingThreads = new LinkedList();
        numEntries = 0;
    }

    public RouteSpecificPool(HttpRoute httproute, ConnPerRoute connperroute)
    {
        log = new HttpClientAndroidLog(getClass());
        route = httproute;
        connPerRoute = connperroute;
        maxEntries = connperroute.getMaxForRoute(httproute);
        freeEntries = new LinkedList();
        waitingThreads = new LinkedList();
        numEntries = 0;
    }

    public BasicPoolEntry allocEntry(Object obj)
    {
label0:
        {
            if (freeEntries.isEmpty())
            {
                break label0;
            }
            ListIterator listiterator = freeEntries.listIterator(freeEntries.size());
            BasicPoolEntry basicpoolentry;
            do
            {
                if (!listiterator.hasPrevious())
                {
                    break label0;
                }
                basicpoolentry = (BasicPoolEntry)listiterator.previous();
            } while (basicpoolentry.getState() != null && !LangUtils.equals(obj, basicpoolentry.getState()));
            listiterator.remove();
            return basicpoolentry;
        }
        if (getCapacity() == 0 && !freeEntries.isEmpty())
        {
            obj = (BasicPoolEntry)freeEntries.remove();
            ((BasicPoolEntry) (obj)).shutdownEntry();
            OperatedClientConnection operatedclientconnection = ((BasicPoolEntry) (obj)).getConnection();
            try
            {
                operatedclientconnection.close();
            }
            catch (IOException ioexception)
            {
                log.debug("I/O error closing connection", ioexception);
                return ((BasicPoolEntry) (obj));
            }
            return ((BasicPoolEntry) (obj));
        } else
        {
            return null;
        }
    }

    public void createdEntry(BasicPoolEntry basicpoolentry)
    {
        Args.check(route.equals(basicpoolentry.getPlannedRoute()), "Entry not planned for this pool");
        numEntries = numEntries + 1;
    }

    public boolean deleteEntry(BasicPoolEntry basicpoolentry)
    {
        boolean flag = freeEntries.remove(basicpoolentry);
        if (flag)
        {
            numEntries = numEntries - 1;
        }
        return flag;
    }

    public void dropEntry()
    {
        boolean flag;
        if (numEntries > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "There is no entry that could be dropped");
        numEntries = numEntries - 1;
    }

    public void freeEntry(BasicPoolEntry basicpoolentry)
    {
        if (numEntries < 1)
        {
            throw new IllegalStateException((new StringBuilder()).append("No entry created for this pool. ").append(route).toString());
        }
        if (numEntries <= freeEntries.size())
        {
            throw new IllegalStateException((new StringBuilder()).append("No entry allocated from this pool. ").append(route).toString());
        } else
        {
            freeEntries.add(basicpoolentry);
            return;
        }
    }

    public int getCapacity()
    {
        return connPerRoute.getMaxForRoute(route) - numEntries;
    }

    public final int getEntryCount()
    {
        return numEntries;
    }

    public final int getMaxEntries()
    {
        return maxEntries;
    }

    public final HttpRoute getRoute()
    {
        return route;
    }

    public boolean hasThread()
    {
        return !waitingThreads.isEmpty();
    }

    public boolean isUnused()
    {
        return numEntries < 1 && waitingThreads.isEmpty();
    }

    public WaitingThread nextThread()
    {
        return (WaitingThread)waitingThreads.peek();
    }

    public void queueThread(WaitingThread waitingthread)
    {
        Args.notNull(waitingthread, "Waiting thread");
        waitingThreads.add(waitingthread);
    }

    public void removeThread(WaitingThread waitingthread)
    {
        if (waitingthread == null)
        {
            return;
        } else
        {
            waitingThreads.remove(waitingthread);
            return;
        }
    }
}
