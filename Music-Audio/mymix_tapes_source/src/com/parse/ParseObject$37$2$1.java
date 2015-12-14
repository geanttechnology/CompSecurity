// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;

// Referenced classes of package com.parse:
//            ParseUser, ParseObject, ParseOperationSet, PointerEncodingStrategy, 
//            ParseCommand

class val.current
    implements Continuation
{

    final tUser this$1;
    final List val$current;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        val$current.remove(ParseUser.getCurrentUser());
        return null;
    }

    sessionToken()
    {
        this$1 = final_sessiontoken;
        val$current = List.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$37

/* anonymous class */
    static final class ParseObject._cls37
        implements Continuation
    {

        final List val$objects;
        final String val$sessionToken;

        public Task then(final Task remaining)
            throws Exception
        {
            remaining = new IdentityHashMap();
            for (Iterator iterator = objects.iterator(); iterator.hasNext(); remaining.put((ParseObject)iterator.next(), Boolean.valueOf(true))) { }
            remaining = new Capture(new ArrayList(remaining.keySet()));
            return Task.forResult(null).continueWhile(new ParseObject._cls37._cls1(), remaining. new ParseObject._cls37._cls2());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                objects = list;
                sessionToken = s;
                super();
            }

        // Unreferenced inner class com/parse/ParseObject$37$1

/* anonymous class */
        class ParseObject._cls37._cls1
            implements Callable
        {

            final ParseObject._cls37 this$0;
            final Capture val$remaining;

            public Boolean call()
                throws Exception
            {
                boolean flag;
                if (((List)remaining.get()).size() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

                    
                    {
                        this$0 = ParseObject._cls37.this;
                        remaining = capture;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/parse/ParseObject$37$2

/* anonymous class */
    class ParseObject._cls37._cls2
        implements Continuation
    {

        final ParseObject._cls37 this$0;
        final Capture val$remaining;

        public Task then(Task task)
            throws Exception
        {
            final ArrayList current = new ArrayList();
            task = new ArrayList();
            for (Iterator iterator = ((List)remaining.get()).iterator(); iterator.hasNext();)
            {
                ParseObject parseobject = (ParseObject)iterator.next();
                if (ParseObject.access$1400(parseobject))
                {
                    current.add(parseobject);
                } else
                {
                    task.add(parseobject);
                }
            }

            remaining.set(task);
            if (current.size() == 0)
            {
                throw new RuntimeException("Unable to save a PFObject with a relation to a cycle.");
            }
            Task task1 = Task.forResult(null);
            task = task1;
            if (ParseUser.getCurrentUser() != null)
            {
                task = task1;
                if (ParseUser.getCurrentUser().isLazy())
                {
                    task = task1;
                    if (current.contains(ParseUser.getCurrentUser()))
                    {
                        task = task1.onSuccessTask(new ParseObject._cls37._cls2._cls2()).onSuccess(current. new ParseObject._cls37._cls2._cls1());
                    }
                }
            }
            return task.onSuccessTask(new ParseObject._cls37._cls2._cls3());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final__pcls37;
                remaining = Capture.this;
                super();
            }

        // Unreferenced inner class com/parse/ParseObject$37$2$2

/* anonymous class */
        class ParseObject._cls37._cls2._cls2
            implements Continuation
        {

            final ParseObject._cls37._cls2 this$1;

            public Task then(Task task)
                throws Exception
            {
                return ParseUser.getCurrentUser().saveInBackground();
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$1 = ParseObject._cls37._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/ParseObject$37$2$3

/* anonymous class */
        class ParseObject._cls37._cls2._cls3
            implements Continuation
        {

            final ParseObject._cls37._cls2 this$1;
            final List val$current;
            final List val$operations;

            public Task then(Task task)
                throws Exception
            {
                if (current.size() == 0)
                {
                    return Task.forResult(null);
                } else
                {
                    return ParseObject.enqueueForAll(current, new ParseObject._cls37._cls2._cls3._cls1());
                }
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$1 = ParseObject._cls37._cls2.this;
                        current = list;
                        operations = list1;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/ParseObject$37$2$3$1

/* anonymous class */
        class ParseObject._cls37._cls2._cls3._cls1
            implements Continuation
        {

            final ParseObject._cls37._cls2._cls3 this$2;

            public Task then(Task task)
                throws Exception
            {
                for (Iterator iterator = current.iterator(); iterator.hasNext();)
                {
                    ParseObject parseobject = (ParseObject)iterator.next();
                    synchronized (parseobject.mutex)
                    {
                        parseobject.validateSave();
                        operations.add(parseobject.startSave());
                    }
                }

                break MISSING_BLOCK_LABEL_74;
                task;
                obj;
                JVM INSTR monitorexit ;
                throw task;
                return task.continueWithTask(new ParseObject._cls37._cls2._cls3._cls1._cls1());
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$2 = ParseObject._cls37._cls2._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/ParseObject$37$2$3$1$1

/* anonymous class */
        class ParseObject._cls37._cls2._cls3._cls1._cls1
            implements Continuation
        {

            final ParseObject._cls37._cls2._cls3._cls1 this$3;

            public Task then(Task task)
                throws Exception
            {
                task = new JSONArray();
                for (int i = 0; i < current.size(); i++)
                {
                    task.put(((ParseObject)current.get(i)).constructSaveCommand((ParseOperationSet)operations.get(i), PointerEncodingStrategy.get(), sessionToken).toJSONObject());
                }

                ParseCommand parsecommand = new ParseCommand("multi", sessionToken);
                parsecommand.put("commands", task);
                return parsecommand.executeAsync().cast().onSuccessTask(new ParseObject._cls37._cls2._cls3._cls1._cls1._cls1());
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$3 = ParseObject._cls37._cls2._cls3._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/ParseObject$37$2$3$1$1$1

/* anonymous class */
        class ParseObject._cls37._cls2._cls3._cls1._cls1._cls1
            implements Continuation
        {

            final ParseObject._cls37._cls2._cls3._cls1._cls1 this$4;

            public Task then(Task task)
                throws Exception
            {
                ArrayList arraylist = new ArrayList();
                for (int i = 0; i < current.size(); i++)
                {
                    org.json.JSONObject jsonobject = ((JSONArray)task.getResult()).getJSONObject(i);
                    arraylist.add(((ParseObject)current.get(i)).handleSaveResultAsync(jsonobject, (ParseOperationSet)operations.get(i)));
                }

                return Task.whenAll(arraylist).continueWithTask(arraylist. new ParseObject._cls37._cls2._cls3._cls1._cls1._cls1._cls1());
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$4 = ParseObject._cls37._cls2._cls3._cls1._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/ParseObject$37$2$3$1$1$1$1

/* anonymous class */
        class ParseObject._cls37._cls2._cls3._cls1._cls1._cls1._cls1
            implements Continuation
        {

            final ParseObject._cls37._cls2._cls3._cls1._cls1._cls1 this$5;
            final List val$tasks;

            public Task then(Task task)
                throws Exception
            {
label0:
                {
                    if (!task.isFaulted())
                    {
                        break label0;
                    }
                    Iterator iterator = tasks.iterator();
                    Task task1;
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break label0;
                        }
                        task1 = (Task)iterator.next();
                    } while (!task1.isFaulted());
                    return task1;
                }
                return task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$5 = final__pcls1;
                        tasks = List.this;
                        super();
                    }
        }

    }

}
