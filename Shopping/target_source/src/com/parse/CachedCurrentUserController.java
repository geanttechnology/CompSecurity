// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Arrays;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseCurrentUserController, TaskQueue, ParseAnonymousUtils, ParseException, 
//            ParseObjectStore, ParseTaskUtils, ParseUser, ParseObject

class CachedCurrentUserController
    implements ParseCurrentUserController
{

    ParseUser currentUser;
    boolean currentUserMatchesDisk;
    private final Object mutex = new Object();
    private final ParseObjectStore store;
    private final TaskQueue taskQueue = new TaskQueue();

    public CachedCurrentUserController(ParseObjectStore parseobjectstore)
    {
        currentUserMatchesDisk = false;
        store = parseobjectstore;
    }

    private ParseUser lazyLogIn()
    {
        return lazyLogIn("anonymous", ParseAnonymousUtils.getAuthData());
    }

    public void clearFromDisk()
    {
        synchronized (mutex)
        {
            currentUser = null;
            currentUserMatchesDisk = false;
        }
        try
        {
            ParseTaskUtils.wait(store.deleteAsync());
            return;
        }
        catch (ParseException parseexception)
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clearFromMemory()
    {
        synchronized (mutex)
        {
            currentUser = null;
            currentUserMatchesDisk = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public j existsAsync()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        j j1;
        if (currentUser == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        j1 = j.a(Boolean.valueOf(true));
        return j1;
        obj;
        JVM INSTR monitorexit ;
        return taskQueue.enqueue(new i() {

            final CachedCurrentUserController this$0;

            public j then(j j2)
                throws Exception
            {
                return j2.b(new i() {

                    final _cls2 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        return store.existsAsync();
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = CachedCurrentUserController.this;
                super();
            }
        });
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public j getAsync()
    {
        return getAsync(ParseUser.isAutomaticUserEnabled());
    }

    public j getAsync(final boolean shouldAutoCreateUser)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        j j1;
        if (currentUser == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        j1 = j.a(currentUser);
        return j1;
        obj;
        JVM INSTR monitorexit ;
        return taskQueue.enqueue(new i() {

            final CachedCurrentUserController this$0;
            final boolean val$shouldAutoCreateUser;

            public j then(j j2)
                throws Exception
            {
                return j2.b(new i() {

                    final _cls5 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        boolean flag;
                        ParseUser parseuser;
                        synchronized (mutex)
                        {
                            parseuser = currentUser;
                            flag = currentUserMatchesDisk;
                        }
                        if (parseuser != null)
                        {
                            return j.a(parseuser);
                        }
                        break MISSING_BLOCK_LABEL_51;
                        exception;
                        j1;
                        JVM INSTR monitorexit ;
                        throw exception;
                        if (flag)
                        {
                            if (shouldAutoCreateUser)
                            {
                                return j.a(lazyLogIn());
                            } else
                            {
                                return null;
                            }
                        } else
                        {
                            return store.getAsync().a(new i() {

                                final _cls1 this$2;

                                public ParseUser then(j j1)
                                    throws Exception
                                {
                                    boolean flag = true;
                                    ParseUser parseuser = (ParseUser)j1.e();
                                    if (j1.d())
                                    {
                                        flag = false;
                                    }
                                    synchronized (mutex)
                                    {
                                        currentUser = parseuser;
                                        currentUserMatchesDisk = flag;
                                    }
                                    if (parseuser != null)
                                    {
                                        synchronized (parseuser.mutex)
                                        {
                                            parseuser.setIsCurrentUser(true);
                                        }
                                        return parseuser;
                                    }
                                    break MISSING_BLOCK_LABEL_98;
                                    exception;
                                    j1;
                                    JVM INSTR monitorexit ;
                                    throw exception;
                                    exception1;
                                    j1;
                                    JVM INSTR monitorexit ;
                                    throw exception1;
                                    if (shouldAutoCreateUser)
                                    {
                                        return lazyLogIn();
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
                this$2 = _cls1.this;
                super();
            }
                            });
                        }
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = CachedCurrentUserController.this;
                shouldAutoCreateUser = flag;
                super();
            }
        });
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public j getCurrentSessionTokenAsync()
    {
        return getAsync(false).c(new i() {

            final CachedCurrentUserController this$0;

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            public String then(j j1)
                throws Exception
            {
                j1 = (ParseUser)j1.e();
                if (j1 != null)
                {
                    return j1.getSessionToken();
                } else
                {
                    return null;
                }
            }

            
            {
                this$0 = CachedCurrentUserController.this;
                super();
            }
        });
    }

    public volatile boolean isCurrent(ParseObject parseobject)
    {
        return isCurrent((ParseUser)parseobject);
    }

    public boolean isCurrent(ParseUser parseuser)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (currentUser == parseuser)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        parseuser;
        obj;
        JVM INSTR monitorexit ;
        throw parseuser;
    }

    ParseUser lazyLogIn(String s, Map map)
    {
        ParseUser parseuser = (ParseUser)ParseObject.create(com/parse/ParseUser);
        synchronized (parseuser.mutex)
        {
            parseuser.setIsCurrentUser(true);
            parseuser.putAuthData(s, map);
        }
        synchronized (mutex)
        {
            currentUserMatchesDisk = false;
            currentUser = parseuser;
        }
        return parseuser;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        map;
        s;
        JVM INSTR monitorexit ;
        throw map;
    }

    public j logOutAsync()
    {
        return taskQueue.enqueue(new i() {

            final CachedCurrentUserController this$0;

            public j then(j j1)
                throws Exception
            {
                j j2 = getAsync(false);
                return j.a(Arrays.asList(new j[] {
                    j2, j1
                })).b(j2. new i() {

                    final _cls4 this$1;
                    final j val$userTask;

                    public j then(j j1)
                        throws Exception
                    {
                        return j.a(Arrays.asList(new j[] {
                            userTask.d(new i() {

                                final _cls1 this$2;

                                public j then(j j1)
                                    throws Exception
                                {
                                    ParseUser parseuser = (ParseUser)j1.e();
                                    if (parseuser == null)
                                    {
                                        return j1.i();
                                    } else
                                    {
                                        return parseuser.logOutAsync();
                                    }
                                }

                                public volatile Object then(j j1)
                                    throws Exception
                                {
                                    return then(j1);
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            }), store.deleteAsync().a(new i() {

                                final _cls1 this$2;

                                public volatile Object then(j j1)
                                    throws Exception
                                {
                                    return then(j1);
                                }

                                public Void then(j j1)
                                    throws Exception
                                {
                                    boolean flag;
                                    if (!j1.d())
                                    {
                                        flag = true;
                                    } else
                                    {
                                        flag = false;
                                    }
                                    synchronized (mutex)
                                    {
                                        currentUserMatchesDisk = flag;
                                        currentUser = null;
                                    }
                                    return null;
                                    exception;
                                    j1;
                                    JVM INSTR monitorexit ;
                                    throw exception;
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            })
                        }));
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = final__pcls4;
                userTask = j.this;
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
                this$0 = CachedCurrentUserController.this;
                super();
            }
        });
    }

    public volatile j setAsync(ParseObject parseobject)
    {
        return setAsync((ParseUser)parseobject);
    }

    public j setAsync(final ParseUser user)
    {
        return taskQueue.enqueue(new i() {

            final CachedCurrentUserController this$0;
            final ParseUser val$user;

            public j then(j j1)
                throws Exception
            {
                return j1.b(new i() {

                    final _cls1 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        ParseUser parseuser;
                        synchronized (mutex)
                        {
                            parseuser = currentUser;
                        }
                        obj = j1;
                        if (parseuser != null)
                        {
                            obj = j1;
                            if (parseuser != user)
                            {
                                obj = parseuser.logOutAsync(false).a(new i() {

                                    final _cls3 this$2;

                                    public volatile Object then(j j1)
                                        throws Exception
                                    {
                                        return then(j1);
                                    }

                                    public Void then(j j1)
                                        throws Exception
                                    {
                                        return null;
                                    }

            
            {
                this$2 = _cls3.this;
                super();
            }
                                });
                            }
                        }
                        return ((j) (obj));
                        j1;
                        obj;
                        JVM INSTR monitorexit ;
                        throw j1;
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }).d(new i() {

                    final _cls1 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        user.setIsCurrentUser(true);
                        return user.synchronizeAllAuthDataAsync();
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }).d(new i() {

                    final _cls1 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        return store.setAsync(user).a(new i() {

                            final _cls1 this$2;

                            public volatile Object then(j j1)
                                throws Exception
                            {
                                return then(j1);
                            }

                            public Void then(j j1)
                                throws Exception
                            {
                                Object obj = mutex;
                                obj;
                                JVM INSTR monitorenter ;
                                CachedCurrentUserController cachedcurrentusercontroller = _fld0;
                                boolean flag;
                                if (!j1.d())
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                cachedcurrentusercontroller.currentUserMatchesDisk = flag;
                                currentUser = user;
                                obj;
                                JVM INSTR monitorexit ;
                                return null;
                                j1;
                                obj;
                                JVM INSTR monitorexit ;
                                throw j1;
                            }

            
            {
                this$2 = _cls1.this;
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
                this$1 = _cls1.this;
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
                this$0 = CachedCurrentUserController.this;
                user = parseuser;
                super();
            }
        });
    }

    public j setIfNeededAsync(ParseUser parseuser)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (parseuser.isCurrentUser() && !currentUserMatchesDisk)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        parseuser = j.a(null);
        return parseuser;
        obj;
        JVM INSTR monitorexit ;
        return setAsync(parseuser);
        parseuser;
        obj;
        JVM INSTR monitorexit ;
        throw parseuser;
    }



}
