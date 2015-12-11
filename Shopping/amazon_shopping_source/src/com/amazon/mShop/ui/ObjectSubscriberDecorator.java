// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;

import com.amazon.mShop.control.ObjectSubscriber;
import com.amazon.rio.j2me.client.services.ServiceCall;
import java.lang.ref.WeakReference;

public class ObjectSubscriberDecorator
    implements ObjectSubscriber
{

    private final WeakReference weakSubscriber;

    public ObjectSubscriberDecorator(ObjectSubscriber objectsubscriber)
    {
        weakSubscriber = new WeakReference(objectsubscriber);
    }

    private ObjectSubscriber getSubscriber()
    {
        return (ObjectSubscriber)weakSubscriber.get();
    }

    public void onAvailableCountReceived(int i)
    {
        ObjectSubscriber objectsubscriber = getSubscriber();
        if (objectsubscriber != null)
        {
            objectsubscriber.onAvailableCountReceived(i);
        }
    }

    public void onCancelled()
    {
        ObjectSubscriber objectsubscriber = getSubscriber();
        if (objectsubscriber != null)
        {
            objectsubscriber.onCancelled();
        }
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        ObjectSubscriber objectsubscriber = getSubscriber();
        if (objectsubscriber != null)
        {
            objectsubscriber.onError(exception, servicecall);
        }
    }

    public void onObjectReceived(Object obj, int i)
    {
        ObjectSubscriber objectsubscriber = getSubscriber();
        if (objectsubscriber != null)
        {
            objectsubscriber.onObjectReceived(obj, i);
        }
    }

    public void onObjectsReceived()
    {
        ObjectSubscriber objectsubscriber = getSubscriber();
        if (objectsubscriber != null)
        {
            objectsubscriber.onObjectsReceived();
        }
    }

    public void onPageComplete()
    {
        ObjectSubscriber objectsubscriber = getSubscriber();
        if (objectsubscriber != null)
        {
            objectsubscriber.onPageComplete();
        }
    }
}
