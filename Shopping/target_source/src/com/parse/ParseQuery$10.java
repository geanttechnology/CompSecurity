// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseQuery, ParseCallback2, ParseUser, ParseTaskUtils

class 
    implements Callable
{

    final ParseQuery this$0;
    final ParseCallback2 val$callback;
    final heThenNetworkCallable val$delegate;
    final te val$state;

    public j call()
        throws Exception
    {
        return getUserAsync(val$state).d(new i() {

            final ParseQuery._cls10 this$1;

            public j then(j j1)
                throws Exception
            {
                j1 = (ParseUser)j1.e();
                ParseQuery.State state1 = (new ParseQuery.State.Builder(state)).setCachePolicy(ParseQuery.CachePolicy.CACHE_ONLY).build();
                final ParseQuery.State networkState = (new ParseQuery.State.Builder(state)).setCachePolicy(ParseQuery.CachePolicy.NETWORK_ONLY).build();
                return ParseTaskUtils.callbackOnMainThreadAsync((j)delegate.call(state1, j1, ParseQuery.access$1900(this$0).a()), callback).b(j1. new i() {

                    final _cls1 this$2;
                    final ParseQuery.State val$networkState;
                    final ParseUser val$user;

                    public j then(j j1)
                        throws Exception
                    {
                        if (j1.c())
                        {
                            return j1;
                        } else
                        {
                            return (j)delegate.call(networkState, user, ParseQuery.access$1900(this$0).a());
                        }
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$2 = final__pcls1;
                networkState = state1;
                user = ParseUser.this;
                super();
            }
                });
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$1 = ParseQuery._cls10.this;
                super();
            }
        });
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    ()
    {
        this$0 = final_parsequery;
        val$state = te;
        val$delegate = hethennetworkcallable;
        val$callback = ParseCallback2.this;
        super();
    }
}
