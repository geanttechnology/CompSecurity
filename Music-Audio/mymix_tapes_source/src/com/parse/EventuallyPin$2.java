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

static final class _cls1.val.pins
    implements Continuation
{

    public Task then(final Task pins)
        throws Exception
    {
        pins = (List)pins.getResult();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = pins.iterator();
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
        return Task.whenAll(arraylist).continueWithTask(new Continuation() {

            final EventuallyPin._cls2 this$0;
            final List val$pins;

            public Task then(Task task)
                throws Exception
            {
                return Task.forResult(pins);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = EventuallyPin._cls2.this;
                pins = list;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    _cls1.val.pins()
    {
    }
}
