// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.parse:
//            ParseObject

static final class val.sessionToken
    implements ct
{

    final AtomicBoolean val$filesComplete;
    final cs val$remaining;
    final String val$sessionToken;
    final AtomicBoolean val$usersComplete;

    public cu then(final cu current)
        throws Exception
    {
        current = new ArrayList();
        HashSet hashset = new HashSet();
        for (Iterator iterator = ((Set)val$remaining.a()).iterator(); iterator.hasNext();)
        {
            ParseObject parseobject = (ParseObject)iterator.next();
            if (ParseObject.access$1600(parseobject))
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
            return cu.a(null);
        } else
        {
            return ParseObject.enqueueForAll(current, new ct() {

                final ParseObject._cls41 this$0;
                final List val$current;

                public cu then(cu cu1)
                    throws Exception
                {
                    return ParseObject.access$1700(current, sessionToken, cu1);
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseObject._cls41.this;
                current = list;
                super();
            }
            });
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ic.AtomicBoolean(cs cs1, AtomicBoolean atomicboolean, AtomicBoolean atomicboolean1, String s)
    {
        val$remaining = cs1;
        val$filesComplete = atomicboolean;
        val$usersComplete = atomicboolean1;
        val$sessionToken = s;
        super();
    }
}
