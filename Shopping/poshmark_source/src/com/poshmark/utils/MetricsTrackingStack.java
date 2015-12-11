// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package com.poshmark.utils:
//            VisitedScreen

public class MetricsTrackingStack
{

    private static final MetricsTrackingStack metricsStack = new MetricsTrackingStack();
    int MAX_SIZE;
    int count;
    Set currentScreensInStack;
    Deque stack;

    private MetricsTrackingStack()
    {
        MAX_SIZE = 10;
        count = 0;
        stack = new LinkedList();
        currentScreensInStack = new HashSet();
    }

    public void addToEndOfStack(UUID uuid, String s)
    {
        removeFromStack(uuid);
        s = new VisitedScreen(uuid, s);
        currentScreensInStack.add(uuid);
        stack.addLast(s);
        count = count + 1;
    }

    public void addToStack(UUID uuid, String s)
    {
        if (!currentScreensInStack.contains(uuid))
        {
            if (count == MAX_SIZE)
            {
                VisitedScreen visitedscreen = (VisitedScreen)stack.removeLast();
                currentScreensInStack.remove(visitedscreen.fragmentID);
                count = count - 1;
            }
            s = new VisitedScreen(uuid, s);
            stack.addFirst(s);
            currentScreensInStack.add(uuid);
            count = count + 1;
        }
    }

    public void clearStack()
    {
        stack.clear();
        currentScreensInStack.clear();
    }

    public boolean isOnStack()
    {
        return false;
    }

    public void removeFromStack(UUID uuid)
    {
label0:
        {
            if (!currentScreensInStack.contains(uuid))
            {
                break label0;
            }
            Iterator iterator = stack.iterator();
            VisitedScreen visitedscreen;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                visitedscreen = (VisitedScreen)iterator.next();
            } while (visitedscreen.fragmentID != uuid);
            iterator.remove();
            currentScreensInStack.remove(visitedscreen.fragmentID);
            count = count - 1;
        }
    }

    public String serializeStack()
    {
        return null;
    }

}
