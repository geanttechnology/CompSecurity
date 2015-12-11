// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin

class this._cls1
    implements ct
{

    final then this$1;

    public cu then(cu cu1)
        throws Exception
    {
        return cu.a(Integer.valueOf(((List)cu1.e()).size()));
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$3

/* anonymous class */
    class ParsePinningEventuallyQueue._cls3
        implements ct
    {

        final ParsePinningEventuallyQueue this$0;

        public cu then(cu cu1)
            throws Exception
        {
            return EventuallyPin.findAllPinned().b(new ParsePinningEventuallyQueue._cls3._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
    }

}
