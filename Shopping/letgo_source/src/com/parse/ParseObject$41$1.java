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

class val.current
    implements ct
{

    final then this$0;
    final List val$current;

    public cu then(cu cu)
        throws Exception
    {
        return ParseObject.access$1700(val$current, sessionToken, cu);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
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
        implements ct
    {

        final AtomicBoolean val$filesComplete;
        final cs val$remaining;
        final String val$sessionToken;
        final AtomicBoolean val$usersComplete;

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = new ArrayList();
            HashSet hashset = new HashSet();
            for (Iterator iterator = ((Set)remaining.a()).iterator(); iterator.hasNext();)
            {
                ParseObject parseobject = (ParseObject)iterator.next();
                if (ParseObject.access$1600(parseobject))
                {
                    cu1.add(parseobject);
                } else
                {
                    hashset.add(parseobject);
                }
            }

            remaining.a(hashset);
            if (cu1.size() == 0 && filesComplete.get() && usersComplete.get())
            {
                throw new RuntimeException("Unable to save a ParseObject with a relation to a cycle.");
            }
            if (cu1.size() == 0)
            {
                return cu.a(null);
            } else
            {
                return ParseObject.enqueueForAll(cu1, cu1. new ParseObject._cls41._cls1());
            }
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                remaining = cs1;
                filesComplete = atomicboolean;
                usersComplete = atomicboolean1;
                sessionToken = s;
                super();
            }
    }

}
