// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util.mediator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.mShop.util.mediator:
//            Mediator, Task

public class MediatorImpl
    implements Mediator
{

    protected Map mDependencyTasks;
    protected final Map mTasks = new ConcurrentHashMap();

    public MediatorImpl()
    {
        mDependencyTasks = new ConcurrentHashMap();
    }

    private List createTaskListWith(Task task)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(task);
        return arraylist;
    }

    public void addDependency(Task task, String s)
    {
        if (mDependencyTasks.containsKey(s))
        {
            List list = (List)mDependencyTasks.get(s);
            if (list != null)
            {
                if (list.indexOf(task) == -1)
                {
                    list.add(task);
                }
                return;
            } else
            {
                mDependencyTasks.remove(s);
                mDependencyTasks.put(s, createTaskListWith(task));
                return;
            }
        } else
        {
            mDependencyTasks.put(s, createTaskListWith(task));
            return;
        }
    }

    public void onFailed(String s)
    {
        onReady(s);
    }

    public void onReady(String s)
    {
        if (mDependencyTasks.containsKey(s))
        {
            List list = (List)mDependencyTasks.get(s);
            if (list != null)
            {
                ArrayList arraylist = new ArrayList();
                Iterator iterator = list.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Task task = (Task)iterator.next();
                    if (mTasks.containsKey(task.getId()))
                    {
                        task.removeInputDependency(s);
                        List list1 = task.getInputDependency();
                        if (list1 == null || list1.size() == 0)
                        {
                            task.start();
                            arraylist.add(task);
                        }
                    }
                } while (true);
                list.removeAll(arraylist);
            }
        }
    }

    public void register(Task task)
    {
        mTasks.put(task.getId(), task);
        for (Iterator iterator = task.getInputDependency().iterator(); iterator.hasNext(); addDependency(task, (String)iterator.next())) { }
    }
}
