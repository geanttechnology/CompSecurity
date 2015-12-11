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

class val.isConnected
    implements Callable
{

    final val.isConnected this$1;
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
        if (val$connectionLost)
        {
            setConnected(false);
        } else
        {
            setConnected(val$isConnected);
        }
        return null;
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$connectionLost = flag;
        val$isConnected = Z.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseCommandCache$1

/* anonymous class */
    class ParseCommandCache._cls1
        implements ConnectivityNotifier.ConnectivityListener
    {

        final ParseCommandCache this$0;

        public void networkConnectivityStatusChanged(Context context, Intent intent)
        {
            j.a(ConnectivityNotifier.isConnected(context). new ParseCommandCache._cls1._cls1(), ParseExecutors.io());
        }

            
            {
                this$0 = ParseCommandCache.this;
                super();
            }
    }

}
