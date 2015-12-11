// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            Parse, ParseEventuallyQueue, ParseObject, ParseOperationSet

class this._cls1
    implements ct
{

    final then this$1;

    public cu then(cu cu1)
        throws Exception
    {
        return Parse.getEventuallyQueue().waitForOperationSetAndEventuallyPin(operationSet, null).j();
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$16

/* anonymous class */
    class ParseObject._cls16
        implements ct
    {

        final ParseObject this$0;
        final ParseOperationSet val$operationSet;

        public cu then(cu cu1)
            throws Exception
        {
            return cu1.b(new ParseObject._cls16._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_parseobject;
                operationSet = ParseOperationSet.this;
                super();
            }
    }

}
