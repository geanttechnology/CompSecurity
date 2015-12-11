// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseCurrentInstallationController, TaskQueue, ParseException, InstallationId, 
//            ParseObjectStore, ParseTaskUtils, ParseInstallation, ParseObject, 
//            ParseExecutors, PLog

class CachedCurrentInstallationController
    implements ParseCurrentInstallationController
{

    static final String TAG = "com.parse.CachedCurrentInstallationController";
    ParseInstallation currentInstallation;
    private final InstallationId installationId;
    private final Object mutex = new Object();
    private final ParseObjectStore store;
    private final TaskQueue taskQueue = new TaskQueue();

    public CachedCurrentInstallationController(ParseObjectStore parseobjectstore, InstallationId installationid)
    {
        store = parseobjectstore;
        installationId = installationid;
    }

    public void clearFromDisk()
    {
        synchronized (mutex)
        {
            currentInstallation = null;
        }
        try
        {
            installationId.clear();
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
            currentInstallation = null;
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
        if (currentInstallation == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        j1 = j.a(Boolean.valueOf(true));
        return j1;
        obj;
        JVM INSTR monitorexit ;
        return taskQueue.enqueue(new i() {

            final CachedCurrentInstallationController this$0;

            public j then(j j2)
                throws Exception
            {
                return j2.b(new i() {

                    final _cls3 this$1;

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
                this$1 = _cls3.this;
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
                this$0 = CachedCurrentInstallationController.this;
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
        ParseInstallation parseinstallation;
        synchronized (mutex)
        {
            parseinstallation = currentInstallation;
        }
        if (parseinstallation != null)
        {
            return j.a(parseinstallation);
        } else
        {
            return taskQueue.enqueue(new i() {

                final CachedCurrentInstallationController this$0;

                public j then(j j1)
                    throws Exception
                {
                    return j1.b(new i() {

                        final _cls2 this$1;

                        public j then(j j1)
                            throws Exception
                        {
                            return store.getAsync();
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
                    }).a(new i() {

                        final _cls2 this$1;

                        public ParseInstallation then(j j1)
                            throws Exception
                        {
                            j1 = (ParseInstallation)j1.e();
                            if (j1 == null)
                            {
                                j1 = (ParseInstallation)ParseObject.create(com/parse/ParseInstallation);
                                j1.updateDeviceInfo(installationId);
                            } else
                            {
                                installationId.set(j1.getInstallationId());
                                PLog.v("com.parse.CachedCurrentInstallationController", "Successfully deserialized Installation object");
                            }
                            synchronized (mutex)
                            {
                                currentInstallation = j1;
                            }
                            return j1;
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
                this$1 = _cls2.this;
                super();
            }
                    }, ParseExecutors.io());
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = CachedCurrentInstallationController.this;
                super();
            }
            });
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isCurrent(ParseInstallation parseinstallation)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (currentInstallation == parseinstallation)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        parseinstallation;
        obj;
        JVM INSTR monitorexit ;
        throw parseinstallation;
    }

    public volatile boolean isCurrent(ParseObject parseobject)
    {
        return isCurrent((ParseInstallation)parseobject);
    }

    public j setAsync(final ParseInstallation installation)
    {
        if (!isCurrent(installation))
        {
            return j.a(null);
        } else
        {
            return taskQueue.enqueue(new i() {

                final CachedCurrentInstallationController this$0;
                final ParseInstallation val$installation;

                public j then(j j1)
                    throws Exception
                {
                    return j1.b(new i() {

                        final _cls1 this$1;

                        public j then(j j1)
                            throws Exception
                        {
                            return store.setAsync(installation);
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
                    }).b(new i() {

                        final _cls1 this$1;

                        public j then(j j1)
                            throws Exception
                        {
                            installationId.set(installation.getInstallationId());
                            return j1;
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
                    }, ParseExecutors.io());
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = CachedCurrentInstallationController.this;
                installation = parseinstallation;
                super();
            }
            });
        }
    }

    public volatile j setAsync(ParseObject parseobject)
    {
        return setAsync((ParseInstallation)parseobject);
    }



}
