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

class this._cls1
    implements i
{

    final then this$1;

    public j then(j j1)
        throws Exception
    {
        return EventuallyPin.findAllPinned().d(new i() {

            final ParsePinningEventuallyQueue._cls14._cls1 this$2;

            public j then(j j2)
                throws Exception
            {
                Object obj = (List)j2.e();
                j2 = new ArrayList();
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); j2.add(((EventuallyPin)((Iterator) (obj)).next()).unpinInBackground("_eventuallyPin"))) { }
                return j.a(j2);
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$2 = ParsePinningEventuallyQueue._cls14._cls1.this;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
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

}
