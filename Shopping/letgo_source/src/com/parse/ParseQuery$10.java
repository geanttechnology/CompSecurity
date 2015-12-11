// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
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

    public cu call()
        throws Exception
    {
        return getUserAsync(val$state).d(new ct() {

            final ParseQuery._cls10 this$1;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (ParseUser)cu1.e();
                ParseQuery.State state1 = (new ParseQuery.State.Builder(state)).setCachePolicy(ParseQuery.CachePolicy.CACHE_ONLY).build();
                final ParseQuery.State networkState = (new ParseQuery.State.Builder(state)).setCachePolicy(ParseQuery.CachePolicy.NETWORK_ONLY).build();
                return ParseTaskUtils.callbackOnMainThreadAsync((cu)delegate.call(state1, cu1, ParseQuery.access$1900(this$0).a()), callback).b(cu1. new ct() {

                    final _cls1 this$2;
                    final ParseQuery.State val$networkState;
                    final ParseUser val$user;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        if (cu1.c())
                        {
                            return cu1;
                        } else
                        {
                            return (cu)delegate.call(networkState, user, ParseQuery.access$1900(this$0).a());
                        }
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$2 = final__pcls1;
                networkState = state1;
                user = ParseUser.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
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
