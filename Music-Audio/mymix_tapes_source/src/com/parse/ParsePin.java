// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, ParseQuery, OfflineStore

class ParsePin extends ParseObject
{

    private static final String KEY_NAME = "_name";
    private static final String KEY_OBJECTS = "_objects";

    public ParsePin()
    {
    }

    static Task getParsePin(String s)
    {
        ParseQuery parsequery = ParseQuery.getQuery(com/parse/ParsePin).whereEqualTo("_name", s);
        return OfflineStore.getCurrent().findAsync(parsequery, null, null, false, false).onSuccess(new Continuation(s) {

            final String val$name;

            public ParsePin then(Task task)
                throws Exception
            {
                Object obj = null;
                ParsePin parsepin = obj;
                if (task.getResult() != null)
                {
                    parsepin = obj;
                    if (((List)task.getResult()).size() > 0)
                    {
                        parsepin = (ParsePin)((List)task.getResult()).get(0);
                    }
                }
                task = parsepin;
                if (parsepin == null)
                {
                    task = (ParsePin)ParseObject.create(com/parse/ParsePin);
                    task.setName(name);
                }
                return task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                name = s;
                super();
            }
        });
    }

    static Task pinAllObjectsAsync(String s, List list)
    {
        if (list == null || list.size() == 0)
        {
            return Task.forResult(null);
        } else
        {
            return getParsePin(s).onSuccessTask(new Continuation(list) {

                final List val$objects;

                public Task then(Task task)
                    throws Exception
                {
                    List list1;
                    ParsePin parsepin;
                    OfflineStore offlinestore;
                    parsepin = (ParsePin)task.getResult();
                    offlinestore = OfflineStore.getCurrent();
                    list1 = parsepin.getObjects();
                    if (list1 != null) goto _L2; else goto _L1
_L1:
                    task = new ArrayList(objects);
_L4:
                    parsepin.setObjects(task);
                    return offlinestore.saveLocallyAsync(parsepin, true);
_L2:
                    Iterator iterator = objects.iterator();
                    do
                    {
                        task = list1;
                        if (!iterator.hasNext())
                        {
                            continue;
                        }
                        task = (ParseObject)iterator.next();
                        if (!list1.contains(task))
                        {
                            list1.add(task);
                        }
                    } while (true);
                    if (true) goto _L4; else goto _L3
_L3:
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                objects = list;
                super();
            }
            });
        }
    }

    static Task unpinAllObjectsAsync(String s)
    {
        return getParsePin(s).continueWithTask(new Continuation() {

            public Task then(Task task)
                throws Exception
            {
                if (task.isFaulted())
                {
                    return task.makeVoid();
                } else
                {
                    task = (ParsePin)task.getResult();
                    return OfflineStore.getCurrent().unpinAsync(task);
                }
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

        });
    }

    static Task unpinAllObjectsAsync(String s, List list)
    {
        if (list == null || list.size() == 0)
        {
            return Task.forResult(null);
        } else
        {
            return getParsePin(s).onSuccessTask(new Continuation(list) {

                final List val$objects;

                public Task then(Task task)
                    throws Exception
                {
                    task = (ParsePin)task.getResult();
                    OfflineStore offlinestore = OfflineStore.getCurrent();
                    List list1 = task.getObjects();
                    if (list1 == null)
                    {
                        return Task.forResult(null);
                    }
                    list1.removeAll(objects);
                    if (list1.size() == 0)
                    {
                        return offlinestore.unpinAsync(task);
                    } else
                    {
                        task.setObjects(list1);
                        return offlinestore.saveLocallyAsync(task, true);
                    }
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                objects = list;
                super();
            }
            });
        }
    }

    public String getName()
    {
        return getString("_name");
    }

    public List getObjects()
    {
        return getList("_objects");
    }

    boolean needsDefaultACL()
    {
        return false;
    }

    public void setName(String s)
    {
        put("_name", s);
    }

    public void setObjects(List list)
    {
        put("_objects", list);
    }
}
