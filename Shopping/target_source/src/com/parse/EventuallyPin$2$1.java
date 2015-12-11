// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            EventuallyPin, ParseObject

class val.pins
    implements i
{

    final then this$0;
    final List val$pins;

    public j then(j j1)
        throws Exception
    {
        return j.a(val$pins);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
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
        implements i
    {

        public j then(j j1)
            throws Exception
        {
            j1 = (List)j1.e();
            ArrayList arraylist = new ArrayList();
            Iterator iterator = j1.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ParseObject parseobject = ((EventuallyPin)iterator.next()).getObject();
                if (parseobject != null)
                {
                    arraylist.add(parseobject.fetchFromLocalDatastoreAsync().j());
                }
            } while (true);
            return j.a(arraylist).b(j1. new EventuallyPin._cls2._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

    }

}
