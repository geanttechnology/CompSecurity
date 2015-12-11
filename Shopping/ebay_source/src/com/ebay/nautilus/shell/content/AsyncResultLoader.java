// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.content;

import android.content.Context;
import android.content.Loader;
import android.database.ContentObserver;
import android.database.Cursor;
import com.ebay.nautilus.domain.content.AsyncResult;
import com.ebay.nautilus.domain.content.ObservableContent;

// Referenced classes of package com.ebay.nautilus.shell.content:
//            ContentLoader

public abstract class AsyncResultLoader extends Loader
    implements com.ebay.nautilus.domain.content.AsyncResult.Callback
{

    private AsyncResult _controller;
    private Object _data;
    final android.content.Loader.ForceLoadContentObserver _observer = new android.content.Loader.ForceLoadContentObserver(this);

    public AsyncResultLoader(Context context)
    {
        super(context);
    }

    public boolean cancelLoad()
    {
        if (_controller != null)
        {
            return _controller.cancelLoad();
        } else
        {
            return false;
        }
    }

    public void deliverResult(Object obj)
    {
        if (isReset())
        {
            if (obj != null)
            {
                onReleaseResources(obj);
            }
        } else
        {
            Object obj1 = _data;
            _data = obj;
            if (obj != null && obj != obj1)
            {
                registerContentObserver(obj, _observer);
            }
            if (isStarted())
            {
                super.deliverResult(obj);
            }
            if (obj1 != null && obj1 != obj)
            {
                onReleaseResources(obj1);
                return;
            }
        }
    }

    public abstract AsyncResult getAsync(com.ebay.nautilus.domain.content.AsyncResult.Callback callback);

    public void onCanceled(Object obj)
    {
        if (obj != null)
        {
            onReleaseResources(obj);
        }
    }

    protected void onForceLoad()
    {
        super.onForceLoad();
        if (_controller == null)
        {
            _controller = getAsync(this);
        }
        _controller.startLoad();
    }

    protected void onReleaseResources(Object obj)
    {
        ContentLoader.defaultReleaseResources(obj);
    }

    protected void onReset()
    {
        super.onReset();
        onStopLoading();
        if (_controller != null)
        {
            ContentLoader.defaultReleaseResources(_controller);
            _controller = null;
        }
        if (_data != null)
        {
            onReleaseResources(_data);
            _data = null;
        }
    }

    protected void onStartLoading()
    {
        if (_data != null)
        {
            deliverResult(_data);
        }
        if (takeContentChanged() || _data == null)
        {
            forceLoad();
        }
    }

    protected void onStopLoading()
    {
        cancelLoad();
    }

    void registerContentObserver(Object obj, ContentObserver contentobserver)
    {
        if (obj instanceof Cursor)
        {
            ((Cursor)obj).registerContentObserver(_observer);
        } else
        if (obj instanceof ObservableContent)
        {
            ((ObservableContent)obj).registerContentObserver(_observer);
            return;
        }
    }
}
