// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm;

import com.comcast.cim.httpcomponentsandroid.conn.OperatedClientConnection;
import com.comcast.cim.httpcomponentsandroid.conn.params.ConnPerRoute;
import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoute;
import com.comcast.cim.httpcomponentsandroid.util.LangUtils;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm:
//            BasicPoolEntry, WaitingThread

public class RouteSpecificPool
{

    protected final ConnPerRoute connPerRoute;
    protected final LinkedList freeEntries = new LinkedList();
    private final Log log = LogFactory.getLog(getClass());
    protected final int maxEntries;
    protected int numEntries;
    protected final HttpRoute route;
    protected final Queue waitingThreads = new LinkedList();

    public RouteSpecificPool(HttpRoute httproute, ConnPerRoute connperroute)
    {
        route = httproute;
        connPerRoute = connperroute;
        maxEntries = connperroute.getMaxForRoute(httproute);
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
        if (!route.equals(basicpoolentry.getPlannedRoute()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Entry not planned for this pool.\npool: ").append(route).append("\nplan: ").append(basicpoolentry.getPlannedRoute()).toString());
        } else
        {
            numEntries = numEntries + 1;
            return;
        }
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
        if (numEntries < 1)
        {
            throw new IllegalStateException("There is no entry that could be dropped.");
        } else
        {
            numEntries = numEntries - 1;
            return;
        }
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
        if (waitingthread == null)
        {
            throw new IllegalArgumentException("Waiting thread must not be null.");
        } else
        {
            waitingThreads.add(waitingthread);
            return;
        }
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
