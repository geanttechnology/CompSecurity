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
//            ParsePinningEventuallyQueue, EventuallyPin

class this._cls0
    implements i
{

    final ParsePinningEventuallyQueue this$0;

    public j then(j j1)
        throws Exception
    {
        return j1.b(new i() {

            final ParsePinningEventuallyQueue._cls14 this$1;

            public j then(j j2)
                throws Exception
            {
                return EventuallyPin.findAllPinned().d(new i() {

                    final _cls1 this$2;

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

            
            {
                this$2 = _cls1.this;
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
                this$1 = ParsePinningEventuallyQueue._cls14.this;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    _cls1.this._cls1()
    {
        this$0 = ParsePinningEventuallyQueue.this;
        super();
    }
}
