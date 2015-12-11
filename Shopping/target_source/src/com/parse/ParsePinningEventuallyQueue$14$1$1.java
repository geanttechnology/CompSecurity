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
//            EventuallyPin, ParsePinningEventuallyQueue

class this._cls2
    implements i
{

    final then this$2;

    public j then(j j1)
        throws Exception
    {
        Object obj = (List)j1.e();
        j1 = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); j1.add(((EventuallyPin)((Iterator) (obj)).next()).unpinInBackground("_eventuallyPin"))) { }
        return j.a(j1);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$14

/* anonymous class */
    class ParsePinningEventuallyQueue._cls14
        implements i
    {

        final ParsePinningEventuallyQueue this$0;

        public j then(j j1)
            throws Exception
        {
            return j1.b(new ParsePinningEventuallyQueue._cls14._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$14$1

/* anonymous class */
    class ParsePinningEventuallyQueue._cls14._cls1
        implements i
    {

        final ParsePinningEventuallyQueue._cls14 this$1;

        public j then(j j1)
            throws Exception
        {
            return EventuallyPin.findAllPinned().d(new ParsePinningEventuallyQueue._cls14._cls1._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls14.this;
                super();
            }
    }

}
