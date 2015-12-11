// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser

class val.user
    implements ct
{

    final then this$0;
    final ParseUser val$user;

    public cu then(cu cu)
        throws Exception
    {
        return ParseObject.access$1900(objects, val$user, onlyIfNeeded, cu);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    l.onlyIfNeeded()
    {
        this$0 = final_onlyifneeded;
        val$user = ParseUser.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$45

/* anonymous class */
    static final class ParseObject._cls45
        implements ct
    {

        final List val$objects;
        final boolean val$onlyIfNeeded;

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = (ParseUser)cu1.e();
            return ParseObject.enqueueForAll(objects, cu1. new ParseObject._cls45._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                objects = list;
                onlyIfNeeded = flag;
                super();
            }
    }

}
