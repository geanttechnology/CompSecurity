// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.tape;


// Referenced classes of package com.squareup.tape:
//            ObjectQueue, Task, TaskInjector

public class TaskQueue
    implements ObjectQueue
{

    private final ObjectQueue _flddelegate;
    private final TaskInjector taskInjector;

    public TaskQueue(ObjectQueue objectqueue, TaskInjector taskinjector)
    {
        _flddelegate = objectqueue;
        taskInjector = taskinjector;
    }

    public void add(Task task)
    {
        _flddelegate.add(task);
    }

    public volatile void add(Object obj)
    {
        add((Task)obj);
    }

    public Task peek()
    {
        Task task = (Task)_flddelegate.peek();
        if (task != null && taskInjector != null)
        {
            taskInjector.injectMembers(task);
        }
        return task;
    }

    public volatile Object peek()
    {
        return peek();
    }

    public void remove()
    {
        _flddelegate.remove();
    }

    public void setListener(final ObjectQueue.Listener listener)
    {
        if (listener != null)
        {
            _flddelegate.setListener(new ObjectQueue.Listener() {

                final TaskQueue this$0;
                final ObjectQueue.Listener val$listener;

                public void onAdd(ObjectQueue objectqueue, Task task)
                {
                    listener.onAdd(TaskQueue.this, task);
                }

                public volatile void onAdd(ObjectQueue objectqueue, Object obj)
                {
                    onAdd(objectqueue, (Task)obj);
                }

                public void onRemove(ObjectQueue objectqueue)
                {
                    listener.onRemove(TaskQueue.this);
                }

            
            {
                this$0 = TaskQueue.this;
                listener = listener1;
                super();
            }
            });
            return;
        } else
        {
            _flddelegate.setListener(null);
            return;
        }
    }

    public int size()
    {
        return _flddelegate.size();
    }
}
