// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet, Parse, ParseEventuallyQueue

class et
    implements i
{

    final ParseObject this$0;
    final ParseOperationSet val$operationSet;

    public j then(j j1)
        throws Exception
    {
        return j1.b(new i() {

            final ParseObject._cls15 this$1;

            public j then(j j2)
                throws Exception
            {
                return Parse.getEventuallyQueue().waitForOperationSetAndEventuallyPin(operationSet, null).j();
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$1 = ParseObject._cls15.this;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    et()
    {
        this$0 = final_parseobject;
        val$operationSet = ParseOperationSet.this;
        super();
    }
}
