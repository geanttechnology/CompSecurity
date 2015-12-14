// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.manager;

import com.bumptech.glide.request.Request;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker
{

    private boolean isPaused;
    private final List pendingRequests = new ArrayList();
    private final Set requests = Collections.newSetFromMap(new WeakHashMap());

    public RequestTracker()
    {
    }

    private List getSnapshot()
    {
        ArrayList arraylist = new ArrayList(requests.size());
        for (Iterator iterator = requests.iterator(); iterator.hasNext(); arraylist.add((Request)iterator.next())) { }
        return arraylist;
    }

    public void clearRequests()
    {
        for (Iterator iterator = getSnapshot().iterator(); iterator.hasNext(); ((Request)iterator.next()).clear()) { }
        pendingRequests.clear();
    }

    public void pauseRequests()
    {
        isPaused = true;
        Iterator iterator = getSnapshot().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Request request = (Request)iterator.next();
            if (request.isRunning())
            {
                request.pause();
                pendingRequests.add(request);
            }
        } while (true);
    }

    public void removeRequest(Request request)
    {
        requests.remove(request);
        pendingRequests.remove(request);
    }

    public void restartRequests()
    {
        Iterator iterator = getSnapshot().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Request request = (Request)iterator.next();
            if (!request.isComplete() && !request.isCancelled())
            {
                request.pause();
                if (!isPaused)
                {
                    request.begin();
                } else
                {
                    pendingRequests.add(request);
                }
            }
        } while (true);
    }

    public void resumeRequests()
    {
        isPaused = false;
        Iterator iterator = getSnapshot().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Request request = (Request)iterator.next();
            if (!request.isComplete() && !request.isCancelled() && !request.isRunning())
            {
                request.begin();
            }
        } while (true);
        pendingRequests.clear();
    }

    public void runRequest(Request request)
    {
        requests.add(request);
        if (!isPaused)
        {
            request.begin();
            return;
        } else
        {
            pendingRequests.add(request);
            return;
        }
    }
}
