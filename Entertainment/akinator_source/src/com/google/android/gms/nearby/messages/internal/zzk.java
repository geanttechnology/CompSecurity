// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;

public class zzk
    implements Messages
{

    public static final com.google.android.gms.common.api.Api.zzc zzRk = new com.google.android.gms.common.api.Api.zzc();
    public static final com.google.android.gms.common.api.Api.zza zzRl = new _cls1();

    public zzk()
    {
    }

    public PendingResult getPermissionStatus(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new _cls8(googleapiclient));
    }

    public PendingResult publish(GoogleApiClient googleapiclient, Message message)
    {
        return publish(googleapiclient, message, PublishOptions.DEFAULT);
    }

    public PendingResult publish(GoogleApiClient googleapiclient, Message message, PublishOptions publishoptions)
    {
        zzx.zzw(message);
        zzx.zzw(publishoptions);
        return googleapiclient.zzb(new _cls4(googleapiclient, message, publishoptions));
    }

    public PendingResult publish(GoogleApiClient googleapiclient, Message message, Strategy strategy)
    {
        return publish(googleapiclient, message, (new com.google.android.gms.nearby.messages.PublishOptions.Builder()).setStrategy(strategy).build());
    }

    public PendingResult registerStatusCallback(GoogleApiClient googleapiclient, StatusCallback statuscallback)
    {
        zzx.zzw(statuscallback);
        return googleapiclient.zzb(new _cls2(googleapiclient, statuscallback));
    }

    public PendingResult subscribe(GoogleApiClient googleapiclient, MessageListener messagelistener)
    {
        return subscribe(googleapiclient, messagelistener, SubscribeOptions.DEFAULT);
    }

    public PendingResult subscribe(GoogleApiClient googleapiclient, MessageListener messagelistener, Strategy strategy)
    {
        return subscribe(googleapiclient, messagelistener, (new com.google.android.gms.nearby.messages.SubscribeOptions.Builder()).setStrategy(strategy).build());
    }

    public PendingResult subscribe(GoogleApiClient googleapiclient, MessageListener messagelistener, Strategy strategy, MessageFilter messagefilter)
    {
        return subscribe(googleapiclient, messagelistener, (new com.google.android.gms.nearby.messages.SubscribeOptions.Builder()).setStrategy(strategy).setFilter(messagefilter).build());
    }

    public PendingResult subscribe(GoogleApiClient googleapiclient, MessageListener messagelistener, SubscribeOptions subscribeoptions)
    {
        zzx.zzw(messagelistener);
        zzx.zzw(subscribeoptions);
        return googleapiclient.zzb(new _cls6(googleapiclient, messagelistener, subscribeoptions));
    }

    public PendingResult unpublish(GoogleApiClient googleapiclient, Message message)
    {
        zzx.zzw(message);
        return googleapiclient.zzb(new _cls5(googleapiclient, message));
    }

    public PendingResult unregisterStatusCallback(GoogleApiClient googleapiclient, StatusCallback statuscallback)
    {
        return googleapiclient.zzb(new _cls3(googleapiclient, statuscallback));
    }

    public PendingResult unsubscribe(GoogleApiClient googleapiclient, MessageListener messagelistener)
    {
        zzx.zzw(messagelistener);
        return googleapiclient.zzb(new _cls7(googleapiclient, messagelistener));
    }


    // Unreferenced inner class com/google/android/gms/nearby/messages/internal/zzk$zza
    /* block-local class not found */
    class zza {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls1 {}

}
