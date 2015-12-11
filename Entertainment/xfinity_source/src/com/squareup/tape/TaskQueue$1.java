// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.tape;


// Referenced classes of package com.squareup.tape:
//            TaskQueue, Task, ObjectQueue

class Listener
    implements Listener
{

    final TaskQueue this$0;
    final Listener val$listener;

    public void onAdd(ObjectQueue objectqueue, Task task)
    {
        val$listener.onAdd(TaskQueue.this, task);
    }

    public volatile void onAdd(ObjectQueue objectqueue, Object obj)
    {
        onAdd(objectqueue, (Task)obj);
    }

    public void onRemove(ObjectQueue objectqueue)
    {
        val$listener.onRemove(TaskQueue.this);
    }

    Listener()
    {
        this$0 = final_taskqueue;
        val$listener = Listener.this;
        super();
    }
}
