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
//            EventuallyPin, ParseObject

class val.pins
    implements Continuation
{

    final then this$0;
    final List val$pins;

    public Task then(Task task)
        throws Exception
    {
        return Task.forResult(val$pins);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_;
        val$pins = List.this;
        super();
    }

    // Unreferenced inner class com/parse/EventuallyPin$2

/* anonymous class */
    static final class EventuallyPin._cls2
        implements Continuation
    {

        public Task then(Task task)
            throws Exception
        {
            task = (List)task.getResult();
            ArrayList arraylist = new ArrayList();
            Iterator iterator = task.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ParseObject parseobject = ((EventuallyPin)iterator.next()).getObject();
                if (parseobject != null)
                {
                    arraylist.add(parseobject.fetchFromLocalDatastoreAsync().makeVoid());
                }
            } while (true);
            return Task.whenAll(arraylist).continueWithTask(task. new EventuallyPin._cls2._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

    }

}
