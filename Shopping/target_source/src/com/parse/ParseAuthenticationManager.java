// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            AuthenticationCallback, ParseExecutors, ParseCurrentUserController, ParseUser

class ParseAuthenticationManager
{

    private final Map callbacks = new HashMap();
    private final ParseCurrentUserController controller;
    private final Object lock = new Object();

    public ParseAuthenticationManager(ParseCurrentUserController parsecurrentusercontroller)
    {
        controller = parsecurrentusercontroller;
    }

    public j deauthenticateAsync(final String callback)
    {
        synchronized (lock)
        {
            callback = (AuthenticationCallback)callbacks.get(callback);
        }
        if (callback != null)
        {
            return j.a(new Callable() {

                final ParseAuthenticationManager this$0;
                final AuthenticationCallback val$callback;

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

                public Void call()
                    throws Exception
                {
                    callback.onRestore(null);
                    return null;
                }

            
            {
                this$0 = ParseAuthenticationManager.this;
                callback = authenticationcallback;
                super();
            }
            }, ParseExecutors.io());
        } else
        {
            return j.a(null);
        }
        callback;
        obj;
        JVM INSTR monitorexit ;
        throw callback;
    }

    public void register(final String authType, AuthenticationCallback authenticationcallback)
    {
        if (authType == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid authType: ").append(null).toString());
        }
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        if (callbacks.containsKey(authType))
        {
            throw new IllegalStateException((new StringBuilder()).append("Callback already registered for <").append(authType).append(">: ").append(callbacks.get(authType)).toString());
        }
        break MISSING_BLOCK_LABEL_101;
        authType;
        obj;
        JVM INSTR monitorexit ;
        throw authType;
        callbacks.put(authType, authenticationcallback);
        obj;
        JVM INSTR monitorexit ;
        if ("anonymous".equals(authType))
        {
            return;
        } else
        {
            controller.getAsync(false).d(new i() {

                final ParseAuthenticationManager this$0;
                final String val$authType;

                public j then(j j1)
                    throws Exception
                {
                    j1 = (ParseUser)j1.e();
                    if (j1 != null)
                    {
                        return j1.synchronizeAuthDataAsync(authType);
                    } else
                    {
                        return null;
                    }
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseAuthenticationManager.this;
                authType = s;
                super();
            }
            });
            return;
        }
    }

    public j restoreAuthenticationAsync(final String callback, final Map authData)
    {
        synchronized (lock)
        {
            callback = (AuthenticationCallback)callbacks.get(callback);
        }
        if (callback == null)
        {
            return j.a(Boolean.valueOf(true));
        } else
        {
            return j.a(new Callable() {

                final ParseAuthenticationManager this$0;
                final Map val$authData;
                final AuthenticationCallback val$callback;

                public Boolean call()
                    throws Exception
                {
                    return Boolean.valueOf(callback.onRestore(authData));
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                this$0 = ParseAuthenticationManager.this;
                callback = authenticationcallback;
                authData = map;
                super();
            }
            }, ParseExecutors.io());
        }
        callback;
        obj;
        JVM INSTR monitorexit ;
        throw callback;
    }
}
