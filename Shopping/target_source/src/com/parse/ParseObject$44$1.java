// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseACL, ParseUser, ParseObject

class val.user
    implements i
{

    final ionToken this$0;
    final ParseACL val$acl;
    final ParseUser val$user;

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    public String then(j j)
        throws Exception
    {
        if (val$acl.hasUnresolvedUser())
        {
            throw new IllegalStateException("ACL has an unresolved ParseUser. Save or sign up before attempting to serialize the ACL.");
        } else
        {
            return val$user.getSessionToken();
        }
    }

    l.objects()
    {
        this$0 = final_objects;
        val$acl = parseacl;
        val$user = ParseUser.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$44

/* anonymous class */
    static final class ParseObject._cls44
        implements i
    {

        final List val$objects;

        public j then(j j1)
            throws Exception
        {
            j1 = (ParseUser)j1.e();
            if (j1 == null)
            {
                return j.a(null);
            }
            if (!j1.isLazy())
            {
                return j.a(j1.getSessionToken());
            }
            for (j1 = objects.iterator(); j1.hasNext();)
            {
                final ParseACL acl = (ParseObject)j1.next();
                if (acl.isDataAvailable("ACL"))
                {
                    acl = ParseObject.access$600(acl, false);
                    if (acl != null)
                    {
                        ParseUser parseuser = acl.getUnresolvedUser();
                        if (parseuser != null && parseuser.isCurrentUser())
                        {
                            return parseuser.saveAsync(null).c(parseuser. new ParseObject._cls44._cls1());
                        }
                    }
                }
            }

            return j.a(null);
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                objects = list;
                super();
            }
    }

}
