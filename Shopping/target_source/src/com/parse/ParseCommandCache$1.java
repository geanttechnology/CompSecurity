// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseCommandCache, ConnectivityNotifier, ParseExecutors

class this._cls0
    implements .ConnectivityListener
{

    final ParseCommandCache this$0;

    public void networkConnectivityStatusChanged(Context context, Intent intent)
    {
        j.a(new Callable() {

            final ParseCommandCache._cls1 this$1;
            final boolean val$connectionLost;
            final boolean val$isConnected;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                if (connectionLost)
                {
                    setConnected(false);
                } else
                {
                    setConnected(isConnected);
                }
                return null;
            }

            
            {
                this$1 = ParseCommandCache._cls1.this;
                connectionLost = flag;
                isConnected = flag1;
                super();
            }
        }, ParseExecutors.io());
    }

    _cls1.val.isConnected()
    {
        this$0 = ParseCommandCache.this;
        super();
    }
}
