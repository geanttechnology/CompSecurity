// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            AbstractQueryController, ParseRESTQueryCommand, ParseUser, NetworkQueryController, 
//            ParseKeyValueCache, ParseException

class CacheQueryController extends AbstractQueryController
{
    private static interface CommandDelegate
    {

        public abstract j runFromCacheAsync();

        public abstract j runOnNetworkAsync(boolean flag);
    }


    private final NetworkQueryController networkController;

    public CacheQueryController(NetworkQueryController networkquerycontroller)
    {
        networkController = networkquerycontroller;
    }

    private j countFromCacheAsync(ParseQuery.State state, String s)
    {
        return j.a(new Callable() {

            final CacheQueryController this$0;
            final String val$cacheKey;
            final ParseQuery.State val$state;

            public Integer call()
                throws Exception
            {
                JSONObject jsonobject = ParseKeyValueCache.jsonFromKeyValueCache(cacheKey, state.maxCacheAge());
                if (jsonobject == null)
                {
                    throw new ParseException(120, "results not cached");
                }
                int i;
                try
                {
                    i = jsonobject.getInt("count");
                }
                catch (JSONException jsonexception)
                {
                    throw new ParseException(120, "the cache contains corrupted json");
                }
                return Integer.valueOf(i);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = CacheQueryController.this;
                cacheKey = s;
                state = state1;
                super();
            }
        }, j.a);
    }

    private j findFromCacheAsync(ParseQuery.State state, String s)
    {
        return j.a(new Callable() {

            final CacheQueryController this$0;
            final String val$cacheKey;
            final ParseQuery.State val$state;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public List call()
                throws Exception
            {
                Object obj = ParseKeyValueCache.jsonFromKeyValueCache(cacheKey, state.maxCacheAge());
                if (obj == null)
                {
                    throw new ParseException(120, "results not cached");
                }
                try
                {
                    obj = networkController.convertFindResponse(state, ((JSONObject) (obj)));
                }
                catch (JSONException jsonexception)
                {
                    throw new ParseException(120, "the cache contains corrupted json");
                }
                return ((List) (obj));
            }

            
            {
                this$0 = CacheQueryController.this;
                cacheKey = s;
                state = state1;
                super();
            }
        }, j.a);
    }

    private j runCommandWithPolicyAsync(final CommandDelegate c, ParseQuery.CachePolicy cachepolicy)
    {
        static class _cls7
        {

            static final int $SwitchMap$com$parse$ParseQuery$CachePolicy[];

            static 
            {
                $SwitchMap$com$parse$ParseQuery$CachePolicy = new int[ParseQuery.CachePolicy.values().length];
                try
                {
                    $SwitchMap$com$parse$ParseQuery$CachePolicy[ParseQuery.CachePolicy.IGNORE_CACHE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$parse$ParseQuery$CachePolicy[ParseQuery.CachePolicy.NETWORK_ONLY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$parse$ParseQuery$CachePolicy[ParseQuery.CachePolicy.CACHE_ONLY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$parse$ParseQuery$CachePolicy[ParseQuery.CachePolicy.CACHE_ELSE_NETWORK.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$parse$ParseQuery$CachePolicy[ParseQuery.CachePolicy.NETWORK_ELSE_CACHE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$parse$ParseQuery$CachePolicy[ParseQuery.CachePolicy.CACHE_THEN_NETWORK.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls7..SwitchMap.com.parse.ParseQuery.CachePolicy[cachepolicy.ordinal()])
        {
        default:
            throw new RuntimeException((new StringBuilder()).append("Unknown cache policy: ").append(cachepolicy).toString());

        case 1: // '\001'
        case 2: // '\002'
            return c.runOnNetworkAsync(true);

        case 3: // '\003'
            return c.runFromCacheAsync();

        case 4: // '\004'
            return c.runFromCacheAsync().b(new i() {

                final CacheQueryController this$0;
                final CommandDelegate val$c;

                public j then(j j1)
                    throws Exception
                {
                    j j2 = j1;
                    if (j1.f() instanceof ParseException)
                    {
                        j2 = c.runOnNetworkAsync(true);
                    }
                    return j2;
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = CacheQueryController.this;
                c = commanddelegate;
                super();
            }
            });

        case 5: // '\005'
            return c.runOnNetworkAsync(false).b(new i() {

                final CacheQueryController this$0;
                final CommandDelegate val$c;

                public j then(j j1)
                    throws Exception
                {
                    Exception exception = j1.f();
                    j j2 = j1;
                    if (exception instanceof ParseException)
                    {
                        j2 = j1;
                        if (((ParseException)exception).getCode() == 100)
                        {
                            j2 = c.runFromCacheAsync();
                        }
                    }
                    return j2;
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = CacheQueryController.this;
                c = commanddelegate;
                super();
            }
            });

        case 6: // '\006'
            throw new RuntimeException("You cannot use the cache policy CACHE_THEN_NETWORK with find()");
        }
    }

    public j countAsync(final ParseQuery.State state, final ParseUser sessionToken, final j cancellationToken)
    {
        if (sessionToken != null)
        {
            sessionToken = sessionToken.getSessionToken();
        } else
        {
            sessionToken = null;
        }
        return runCommandWithPolicyAsync(new CommandDelegate() {

            final CacheQueryController this$0;
            final j val$cancellationToken;
            final String val$sessionToken;
            final ParseQuery.State val$state;

            public j runFromCacheAsync()
            {
                return countFromCacheAsync(state, sessionToken);
            }

            public j runOnNetworkAsync(boolean flag)
            {
                return networkController.countAsync(state, sessionToken, flag, cancellationToken);
            }

            
            {
                this$0 = CacheQueryController.this;
                state = state1;
                sessionToken = s;
                cancellationToken = j1;
                super();
            }
        }, state.cachePolicy());
    }

    public j findAsync(final ParseQuery.State state, final ParseUser sessionToken, final j cancellationToken)
    {
        if (sessionToken != null)
        {
            sessionToken = sessionToken.getSessionToken();
        } else
        {
            sessionToken = null;
        }
        return runCommandWithPolicyAsync(new CommandDelegate() {

            final CacheQueryController this$0;
            final j val$cancellationToken;
            final String val$sessionToken;
            final ParseQuery.State val$state;

            public j runFromCacheAsync()
            {
                return findFromCacheAsync(state, sessionToken);
            }

            public j runOnNetworkAsync(boolean flag)
            {
                return networkController.findAsync(state, sessionToken, flag, cancellationToken);
            }

            
            {
                this$0 = CacheQueryController.this;
                state = state1;
                sessionToken = s;
                cancellationToken = j1;
                super();
            }
        }, state.cachePolicy());
    }



}
