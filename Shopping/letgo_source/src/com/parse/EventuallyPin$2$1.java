// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            EventuallyPin, ParseObject

class val.pins
    implements ct
{

    final then this$0;
    final List val$pins;

    public cu then(cu cu1)
        throws Exception
    {
        return cu.a(val$pins);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
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
        implements ct
    {

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = (List)cu1.e();
            ArrayList arraylist = new ArrayList();
            Iterator iterator = cu1.iterator();
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
            return cu.a(arraylist).b(cu1. new EventuallyPin._cls2._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

    }

}
