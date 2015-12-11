// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseUser

class val.fetchAsyncTask
    implements ct
{

    final then this$1;
    final cu val$fetchAsyncTask;

    public cu then(cu cu)
        throws Exception
    {
        return val$fetchAsyncTask;
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$fetchAsyncTask = cu.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$2

/* anonymous class */
    class ParseUser._cls2
        implements ct
    {

        final ParseUser this$0;

        public cu then(cu cu1)
            throws Exception
        {
            cu cu2 = cu1;
            if (isCurrentUser())
            {
                ParseUser.access$100(ParseUser.this);
                cu2 = ParseUser.access$200(ParseUser.this).b(cu1. new ParseUser._cls2._cls1());
            }
            return cu2;
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = ParseUser.this;
                super();
            }
    }

}
