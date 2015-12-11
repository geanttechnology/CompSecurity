// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseUser, ParseQuery

class this._cls1
    implements ct
{

    final then this$1;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (ParseUser)cu1.e();
        return ParseQuery.access$2100(_fld0, state, cu1, ParseQuery.access$1900(_fld0).());
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    e()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseQuery$8

/* anonymous class */
    class ParseQuery._cls8
        implements Callable
    {

        final ParseQuery this$0;
        final ParseQuery.State val$state;

        public cu call()
            throws Exception
        {
            return getUserAsync(state).d(new ParseQuery._cls8._cls1());
        }

        public volatile Object call()
            throws Exception
        {
            return call();
        }

            
            {
                this$0 = final_parsequery;
                state = ParseQuery.State.this;
                super();
            }
    }

}
