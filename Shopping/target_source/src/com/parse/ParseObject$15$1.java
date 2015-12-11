// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            Parse, ParseEventuallyQueue, ParseObject, ParseOperationSet

class this._cls1
    implements i
{

    final then this$1;

    public j then(j j1)
        throws Exception
    {
        return Parse.getEventuallyQueue().waitForOperationSetAndEventuallyPin(operationSet, null).j();
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$15

/* anonymous class */
    class ParseObject._cls15
        implements i
    {

        final ParseObject this$0;
        final ParseOperationSet val$operationSet;

        public j then(j j1)
            throws Exception
        {
            return j1.b(new ParseObject._cls15._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_parseobject;
                operationSet = ParseOperationSet.this;
                super();
            }
    }

}
