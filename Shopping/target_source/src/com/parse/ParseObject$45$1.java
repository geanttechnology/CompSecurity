// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser

class val.user
    implements i
{

    final then this$0;
    final ParseUser val$user;

    public j then(j j)
        throws Exception
    {
        return ParseObject.access$1800(objects, val$user, onlyIfNeeded, j);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
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
        implements i
    {

        final List val$objects;
        final boolean val$onlyIfNeeded;

        public j then(j j1)
            throws Exception
        {
            j1 = (ParseUser)j1.e();
            return ParseObject.enqueueForAll(objects, j1. new ParseObject._cls45._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                objects = list;
                onlyIfNeeded = flag;
                super();
            }
    }

}
