// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.database.ContentObservable;
import android.database.ContentObserver;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.io.Closeable;
import java.io.IOException;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            Content

public class ObservableContent extends Content
    implements Closeable
{
    private static final class InternalObserver extends ContentObserver
    {

        private final ContentObservable _observable;
        private volatile ContentObserver _observer;

        public void close()
        {
            if (_observer != null)
            {
                unregisterContentObserver(_observer);
            }
        }

        public boolean deliverSelfNotifications()
        {
            ContentObserver contentobserver = _observer;
            return contentobserver != null && contentobserver.deliverSelfNotifications();
        }

        public void onChange(boolean flag)
        {
            ContentObserver contentobserver = _observer;
            if (contentobserver != null)
            {
                contentobserver.dispatchChange(flag);
            }
        }

        public void registerContentObserver(ContentObserver contentobserver)
        {
            if (contentobserver == null)
            {
                throw new IllegalArgumentException("The observer is null.");
            }
            if (_observer != null)
            {
                throw new IllegalArgumentException("The observer is already registered!");
            } else
            {
                _observer = contentobserver;
                _observable.registerObserver(this);
                return;
            }
        }

        public void unregisterContentObserver(ContentObserver contentobserver)
        {
            if (contentobserver == null)
            {
                throw new IllegalArgumentException("The observer is null.");
            }
            if (_observer != contentobserver)
            {
                throw new IllegalArgumentException("The observer is not registered!");
            } else
            {
                _observer = null;
                _observable.unregisterObserver(this);
                return;
            }
        }

        public InternalObserver(ContentObservable contentobservable)
        {
            super(null);
            _observable = contentobservable;
            _observer = null;
        }
    }


    private volatile InternalObserver _observer;

    public ObservableContent(ResultStatus resultstatus, ContentObservable contentobservable)
    {
        this(null, resultstatus, contentobservable);
    }

    public ObservableContent(Object obj, ContentObservable contentobservable)
    {
        this(obj, ResultStatus.SUCCESS, contentobservable);
    }

    public ObservableContent(Object obj, ResultStatus resultstatus, ContentObservable contentobservable)
    {
        super(obj, resultstatus);
        _observer = new InternalObserver(contentobservable);
    }

    public void close()
        throws IOException
    {
        Object obj = _observer;
        _observer = null;
        if (obj != null)
        {
            ((InternalObserver) (obj)).close();
        }
        obj = getData();
        if (obj instanceof Closeable)
        {
            ((Closeable)obj).close();
        }
    }

    public boolean isClosed()
    {
        return _observer == null;
    }

    public void registerContentObserver(ContentObserver contentobserver)
    {
        InternalObserver internalobserver = _observer;
        if (internalobserver != null)
        {
            internalobserver.registerContentObserver(contentobserver);
        }
    }

    public void unregisterContentObserver(ContentObserver contentobserver)
    {
        InternalObserver internalobserver = _observer;
        if (internalobserver != null)
        {
            internalobserver.unregisterContentObserver(contentobserver);
        }
    }
}
