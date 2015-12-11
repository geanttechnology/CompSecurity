// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.streaming;

import com.shazam.b.b;
import com.shazam.model.social.ConnectionState;

// Referenced classes of package com.shazam.model.streaming:
//            SubscriptionType

public interface StreamingConnectionState
    extends ConnectionState
{

    public static final StreamingConnectionState NO_OP = (StreamingConnectionState)b.a(com/shazam/model/streaming/StreamingConnectionState);

    public abstract void a(SubscriptionType subscriptiontype);

    public abstract String f();

    public abstract SubscriptionType g();

}
