// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.pubsub;


// Referenced classes of package com.rdio.android.core.pubsub:
//            PubSubConnection

class this._cls0
    implements Runnable
{

    final PubSubConnection this$0;

    public void run()
    {
        PubSubConnection.access$702(PubSubConnection.this, false);
        if (PubSubConnection.access$800(PubSubConnection.this))
        {
            connect();
        }
    }

    ()
    {
        this$0 = PubSubConnection.this;
        super();
    }
}
