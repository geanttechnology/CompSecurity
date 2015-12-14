// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request;


// Referenced classes of package com.bumptech.glide.request:
//            Request, RequestCoordinator

public class ThumbnailRequestCoordinator
    implements Request, RequestCoordinator
{

    private RequestCoordinator coordinator;
    private Request full;
    private Request thumb;

    public ThumbnailRequestCoordinator()
    {
        this(null);
    }

    public ThumbnailRequestCoordinator(RequestCoordinator requestcoordinator)
    {
        coordinator = requestcoordinator;
    }

    private boolean parentCanNotifyStatusChanged()
    {
        return coordinator == null || coordinator.canNotifyStatusChanged(this);
    }

    private boolean parentCanSetImage()
    {
        return coordinator == null || coordinator.canSetImage(this);
    }

    private boolean parentIsAnyResourceSet()
    {
        return coordinator != null && coordinator.isAnyResourceSet();
    }

    public void begin()
    {
        if (!thumb.isRunning())
        {
            thumb.begin();
        }
        if (!full.isRunning())
        {
            full.begin();
        }
    }

    public boolean canNotifyStatusChanged(Request request)
    {
        return parentCanNotifyStatusChanged() && request.equals(full) && !isAnyResourceSet();
    }

    public boolean canSetImage(Request request)
    {
        return parentCanSetImage() && (request.equals(full) || !full.isResourceSet());
    }

    public void clear()
    {
        thumb.clear();
        full.clear();
    }

    public boolean isAnyResourceSet()
    {
        return parentIsAnyResourceSet() || isResourceSet();
    }

    public boolean isCancelled()
    {
        return full.isCancelled();
    }

    public boolean isComplete()
    {
        return full.isComplete() || thumb.isComplete();
    }

    public boolean isResourceSet()
    {
        return full.isResourceSet() || thumb.isResourceSet();
    }

    public boolean isRunning()
    {
        return full.isRunning();
    }

    public void onRequestSuccess(Request request)
    {
        if (request.equals(thumb))
        {
            return;
        }
        if (coordinator != null)
        {
            coordinator.onRequestSuccess(this);
        }
        thumb.clear();
    }

    public void pause()
    {
        full.pause();
        thumb.pause();
    }

    public void recycle()
    {
        full.recycle();
        thumb.recycle();
    }

    public void setRequests(Request request, Request request1)
    {
        full = request;
        thumb = request1;
    }
}
