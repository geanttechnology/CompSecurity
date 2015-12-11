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

static final class val.sessionToken
    implements i
{

    final AtomicBoolean val$filesComplete;
    final h val$remaining;
    final String val$sessionToken;
    final AtomicBoolean val$usersComplete;

    public j then(final j current)
        throws Exception
    {
        current = new ArrayList();
        HashSet hashset = new HashSet();
        for (Iterator iterator = ((Set)val$remaining.a()).iterator(); iterator.hasNext();)
        {
            ParseObject parseobject = (ParseObject)iterator.next();
            if (ParseObject.access$1500(parseobject))
            {
                current.add(parseobject);
            } else
            {
                hashset.add(parseobject);
            }
        }

        val$remaining.a(hashset);
        if (current.size() == 0 && val$filesComplete.get() && val$usersComplete.get())
        {
            throw new RuntimeException("Unable to save a ParseObject with a relation to a cycle.");
        }
        if (current.size() == 0)
        {
            return j.a(null);
        } else
        {
            return ParseObject.enqueueForAll(current, new i() {

                final ParseObject._cls41 this$0;
                final List val$current;

                public j then(j j1)
                    throws Exception
                {
                    return ParseObject.access$1600(current, sessionToken, j1);
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseObject._cls41.this;
                current = list;
                super();
            }
            });
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ic.AtomicBoolean(h h1, AtomicBoolean atomicboolean, AtomicBoolean atomicboolean1, String s)
    {
        val$remaining = h1;
        val$filesComplete = atomicboolean;
        val$usersComplete = atomicboolean1;
        val$sessionToken = s;
        super();
    }
}
