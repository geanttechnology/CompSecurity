// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.database.ContentObservable;
import android.database.ContentObserver;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            ObservableContent

private static final class _observer extends ContentObserver
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

    public I(ContentObservable contentobservable)
    {
        super(null);
        _observable = contentobservable;
        _observer = null;
    }
}
