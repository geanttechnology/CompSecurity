// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObjectStore, ParseObject, ParseQuery

class OfflineObjectStore
    implements ParseObjectStore
{

    private final String className;
    private final ParseObjectStore legacy;
    private final String pinName;

    public OfflineObjectStore(Class class1, String s, ParseObjectStore parseobjectstore)
    {
        this(ParseObject.getClassName(class1), s, parseobjectstore);
    }

    public OfflineObjectStore(String s, String s1, ParseObjectStore parseobjectstore)
    {
        className = s;
        pinName = s1;
        legacy = parseobjectstore;
    }

    private static j migrate(ParseObjectStore parseobjectstore, ParseObjectStore parseobjectstore1)
    {
        return parseobjectstore.getAsync().d(new i(parseobjectstore, parseobjectstore1) {

            final ParseObjectStore val$from;
            final ParseObjectStore val$to;

            public j then(j j1)
                throws Exception
            {
                ParseObject parseobject = (ParseObject)j1.e();
                if (parseobject == null)
                {
                    return j1;
                } else
                {
                    return j.a(Arrays.asList(new j[] {
                        from.deleteAsync(), to.setAsync(parseobject)
                    })).a(parseobject. new i() {

                        final _cls1 this$0;
                        final ParseObject val$object;

                        public ParseObject then(j j1)
                            throws Exception
                        {
                            return object;
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$0 = final__pcls1;
                object = ParseObject.this;
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
                from = parseobjectstore;
                to = parseobjectstore1;
                super();
            }
        });
    }

    public j deleteAsync()
    {
        final j ldsTask = ParseObject.unpinAllInBackground(pinName);
        return j.a(Arrays.asList(new j[] {
            legacy.deleteAsync(), ldsTask
        })).b(new i() {

            final OfflineObjectStore this$0;
            final j val$ldsTask;

            public j then(j j1)
                throws Exception
            {
                return ldsTask;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineObjectStore.this;
                ldsTask = j1;
                super();
            }
        });
    }

    public j existsAsync()
    {
        return ParseQuery.getQuery(className).fromPin(pinName).ignoreACLs().countInBackground().d(new i() {

            final OfflineObjectStore this$0;

            public j then(j j1)
                throws Exception
            {
                boolean flag;
                if (((Integer)j1.e()).intValue() == 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    return j.a(Boolean.valueOf(true));
                } else
                {
                    return legacy.existsAsync();
                }
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineObjectStore.this;
                super();
            }
        });
    }

    public j getAsync()
    {
        return ParseQuery.getQuery(className).fromPin(pinName).ignoreACLs().findInBackground().d(new i() {

            final OfflineObjectStore this$0;

            public j then(j j1)
                throws Exception
            {
                j1 = (List)j1.e();
                if (j1 != null)
                {
                    if (j1.size() == 1)
                    {
                        return j.a(j1.get(0));
                    } else
                    {
                        return ParseObject.unpinAllInBackground(pinName).i();
                    }
                } else
                {
                    return j.a(null);
                }
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineObjectStore.this;
                super();
            }
        }).d(new i() {

            final OfflineObjectStore this$0;

            public j then(j j1)
                throws Exception
            {
                if ((ParseObject)j1.e() != null)
                {
                    return j1;
                } else
                {
                    return OfflineObjectStore.migrate(legacy, OfflineObjectStore.this).i();
                }
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineObjectStore.this;
                super();
            }
        });
    }

    public j setAsync(final ParseObject object)
    {
        return ParseObject.unpinAllInBackground(pinName).b(new i() {

            final OfflineObjectStore this$0;
            final ParseObject val$object;

            public j then(j j1)
                throws Exception
            {
                return object.pinInBackground(pinName, false);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineObjectStore.this;
                object = parseobject;
                super();
            }
        });
    }



}
