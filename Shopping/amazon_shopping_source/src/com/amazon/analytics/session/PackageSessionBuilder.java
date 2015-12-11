// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session;

import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Referenced classes of package com.amazon.analytics.session:
//            PackageSession, SessionState

public class PackageSessionBuilder
{

    private static final Logger logger = Logging.getLogger(com/amazon/analytics/session/PackageSessionBuilder);
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final ConcurrentHashMap packageSessions = new ConcurrentHashMap();
    private final java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock;
    private final java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock;

    public PackageSessionBuilder()
    {
        readLock = lock.readLock();
        writeLock = lock.writeLock();
    }

    private void cleanInstanceMappings()
    {
        Iterator iterator = packageSessions.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((PackageSession)entry.getValue()).getSessionState() == SessionState.NO_SESSION || ((PackageSession)entry.getValue()).getSessionState() == SessionState.ORPHANED_SESSION)
            {
                packageSessions.remove(entry.getKey());
            }
        } while (true);
    }

    public PackageSession getInstance(String s)
    {
        writeLock.lock();
        PackageSession packagesession1;
        logger.v("Initializing cleanup by deregistering sessions in no session state");
        cleanInstanceMappings();
        logger.v((new StringBuilder()).append("Getting PackageSession object for package ").append(s).toString());
        packagesession1 = (PackageSession)packageSessions.get(s);
        PackageSession packagesession;
        packagesession = packagesession1;
        if (packagesession1 != null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        packagesession = new PackageSession(s);
        packageSessions.put(s, packagesession);
        logger.d((new StringBuilder()).append("Creating PackageSession object for package ").append(s).append(" and caching it").toString());
        writeLock.unlock();
        return packagesession;
        s;
        writeLock.unlock();
        throw s;
    }

    public Set getRunningSessions()
    {
        readLock.lock();
        Object obj;
        obj = new HashSet();
        Iterator iterator = packageSessions.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            PackageSession packagesession = (PackageSession)iterator.next();
            if (packagesession.getSessionState() == SessionState.RUNNING_SESSION)
            {
                ((Set) (obj)).add(packagesession);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_78;
        obj;
        readLock.unlock();
        throw obj;
        readLock.unlock();
        return ((Set) (obj));
    }

}
