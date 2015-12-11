// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

// Referenced classes of package com.google.android.gms.nearby.messages:
//            Message, PublishOptions, Strategy, StatusCallback, 
//            MessageListener, MessageFilter, SubscribeOptions

public interface Messages
{

    public abstract PendingResult getPermissionStatus(GoogleApiClient googleapiclient);

    public abstract PendingResult publish(GoogleApiClient googleapiclient, Message message);

    public abstract PendingResult publish(GoogleApiClient googleapiclient, Message message, PublishOptions publishoptions);

    public abstract PendingResult publish(GoogleApiClient googleapiclient, Message message, Strategy strategy);

    public abstract PendingResult registerStatusCallback(GoogleApiClient googleapiclient, StatusCallback statuscallback);

    public abstract PendingResult subscribe(GoogleApiClient googleapiclient, MessageListener messagelistener);

    public abstract PendingResult subscribe(GoogleApiClient googleapiclient, MessageListener messagelistener, Strategy strategy);

    public abstract PendingResult subscribe(GoogleApiClient googleapiclient, MessageListener messagelistener, Strategy strategy, MessageFilter messagefilter);

    public abstract PendingResult subscribe(GoogleApiClient googleapiclient, MessageListener messagelistener, SubscribeOptions subscribeoptions);

    public abstract PendingResult unpublish(GoogleApiClient googleapiclient, Message message);

    public abstract PendingResult unregisterStatusCallback(GoogleApiClient googleapiclient, StatusCallback statuscallback);

    public abstract PendingResult unsubscribe(GoogleApiClient googleapiclient, MessageListener messagelistener);
}
