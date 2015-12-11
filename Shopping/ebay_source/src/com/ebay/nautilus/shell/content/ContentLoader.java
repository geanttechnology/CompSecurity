// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.content;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import com.ebay.nautilus.domain.content.ObservableContent;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class ContentLoader extends AsyncTaskLoader
{

    private Object _data;
    final android.content.Loader.ForceLoadContentObserver _observer = new android.content.Loader.ForceLoadContentObserver(this);

    public ContentLoader(Context context)
    {
        super(context);
    }

    static void defaultReleaseResources(Object obj)
    {
        obj = getCloseable(obj);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        ((Closeable) (obj)).close();
        return;
        obj;
        ((IOException) (obj)).printStackTrace();
        return;
    }

    private static Closeable getCloseable(Object obj)
    {
        Closeable closeable = null;
        if (!(obj instanceof Closeable))
        {
            break MISSING_BLOCK_LABEL_66;
        }
        Closeable closeable1 = (Closeable)obj;
        Method method;
        boolean flag;
        try
        {
            method = obj.getClass().getMethod("isClosed", new Class[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return closeable1;
        }
        closeable = closeable1;
        if (method.getReturnType() != Boolean.TYPE)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        flag = ((Boolean)method.invoke(obj, new Object[0])).booleanValue();
        closeable = closeable1;
        if (flag)
        {
            closeable = null;
        }
        return closeable;
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

    public void onCanceled(Object obj)
    {
        if (obj != null)
        {
            onReleaseResources(obj);
        }
    }

    protected Object onLoadInBackground()
    {
        Object obj = super.onLoadInBackground();
        if (obj != null)
        {
            if (obj instanceof Cursor)
            {
                Cursor cursor = (Cursor)obj;
                cursor.getCount();
                cursor.registerContentObserver(_observer);
            } else
            if (obj instanceof ObservableContent)
            {
                ((ObservableContent)obj).registerContentObserver(_observer);
                return obj;
            }
        }
        return obj;
    }

    protected void onReleaseResources(Object obj)
    {
        defaultReleaseResources(obj);
    }

    protected void onReset()
    {
        super.onReset();
        onStopLoading();
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
}
