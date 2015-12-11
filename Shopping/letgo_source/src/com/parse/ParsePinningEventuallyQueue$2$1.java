// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue

class this._cls1
    implements ct
{

    final then this$1;

    public cu then(cu cu1)
        throws Exception
    {
        int i = ((Integer)cu1.e()).intValue();
        tcs.(Integer.valueOf(i));
        return cu.a(null);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    l.tcs()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$2

/* anonymous class */
    class ParsePinningEventuallyQueue._cls2
        implements ct
    {

        final ParsePinningEventuallyQueue this$0;
        final android.support.v7.cu.a val$tcs;

        public cu then(cu cu1)
            throws Exception
        {
            return pendingCountAsync(cu1).b(new ParsePinningEventuallyQueue._cls2._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_parsepinningeventuallyqueue;
                tcs = android.support.v7.cu.a.this;
                super();
            }
    }

}
