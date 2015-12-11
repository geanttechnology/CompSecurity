// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.tasks;

import com.google.a.d.e;
import java.util.UUID;

public abstract class PresenterTask
{
    public static interface OnCleanUpCompletedListener
    {

        public abstract void onCleanupCompleted(PresenterTask presentertask);
    }

    public static interface TaskListener
    {

        public abstract void onCompleted(Object obj);

        public abstract void onError(String s);
    }


    private OnCleanUpCompletedListener cleanUpCompletedListener;
    private e eventBus;
    private boolean isCancelled;
    private boolean isRequesterIdCheckedAndDidMatch;
    private boolean isStarted;
    private TaskListener listener;
    private UUID requesterId;

    public PresenterTask(e e1)
    {
        eventBus = e1;
        requesterId = UUID.randomUUID();
    }

    public void cancel()
    {
        isCancelled = true;
    }

    protected final boolean checkRequesterId(Object obj)
    {
        isRequesterIdCheckedAndDidMatch = obj.equals(requesterId);
        return isRequesterIdCheckedAndDidMatch;
    }

    protected void cleanup()
    {
        if (isStarted)
        {
            isStarted = false;
            eventBus.unregister(this);
        }
        if (cleanUpCompletedListener != null)
        {
            cleanUpCompletedListener.onCleanupCompleted(this);
        }
    }

    protected e getEventBus()
    {
        return eventBus;
    }

    protected Object getEventId()
    {
        return null;
    }

    public Object getEventRequesterId()
    {
        return requesterId;
    }

    public TaskListener getListener()
    {
        return listener;
    }

    public boolean isStarted()
    {
        return isStarted;
    }

    protected abstract void onPerformTask();

    protected void onTaskCompleted(Object obj)
    {
        onTaskCompleted(obj, true);
    }

    protected void onTaskCompleted(Object obj, boolean flag)
    {
        if (isRequesterIdCheckedAndDidMatch)
        {
            if (listener != null && !isCancelled)
            {
                listener.onCompleted(obj);
            }
            if (flag)
            {
                cleanup();
            }
            return;
        } else
        {
            throw new IllegalStateException("Task requester ID has not been checked. Please call checkRequesterId() method in the subclass to validate the requester ID.");
        }
    }

    protected void onTaskError(String s)
    {
        if (listener != null && !isCancelled)
        {
            listener.onError(s);
        }
        cleanup();
    }

    public void setOnCleanUpCompletedListener(OnCleanUpCompletedListener oncleanupcompletedlistener)
    {
        cleanUpCompletedListener = oncleanupcompletedlistener;
    }

    public void startTask(TaskListener tasklistener)
    {
        if (isStarted)
        {
            throw new IllegalStateException("Task is already started!");
        } else
        {
            isStarted = true;
            eventBus.register(this);
            listener = tasklistener;
            onPerformTask();
            return;
        }
    }
}
