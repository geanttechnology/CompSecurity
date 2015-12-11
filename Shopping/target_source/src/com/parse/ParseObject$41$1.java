// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.h;
import a.i;
import a.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.parse:
//            ParseObject

class val.current
    implements i
{

    final then this$0;
    final List val$current;

    public j then(j j)
        throws Exception
    {
        return ParseObject.access$1600(val$current, sessionToken, j);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    l.sessionToken()
    {
        this$0 = final_sessiontoken;
        val$current = List.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$41

/* anonymous class */
    static final class ParseObject._cls41
        implements i
    {

        final AtomicBoolean val$filesComplete;
        final h val$remaining;
        final String val$sessionToken;
        final AtomicBoolean val$usersComplete;

        public j then(j j1)
            throws Exception
        {
            j1 = new ArrayList();
            HashSet hashset = new HashSet();
            for (Iterator iterator = ((Set)remaining.a()).iterator(); iterator.hasNext();)
            {
                ParseObject parseobject = (ParseObject)iterator.next();
                if (ParseObject.access$1500(parseobject))
                {
                    j1.add(parseobject);
                } else
                {
                    hashset.add(parseobject);
                }
            }

            remaining.a(hashset);
            if (j1.size() == 0 && filesComplete.get() && usersComplete.get())
            {
                throw new RuntimeException("Unable to save a ParseObject with a relation to a cycle.");
            }
            if (j1.size() == 0)
            {
                return j.a(null);
            } else
            {
                return ParseObject.enqueueForAll(j1, j1. new ParseObject._cls41._cls1());
            }
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                remaining = h1;
                filesComplete = atomicboolean;
                usersComplete = atomicboolean1;
                sessionToken = s;
                super();
            }
    }

}
