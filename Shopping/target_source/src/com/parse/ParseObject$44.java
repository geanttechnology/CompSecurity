// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser, ParseACL

static final class val.objects
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
        for (j1 = val$objects.iterator(); j1.hasNext();)
        {
            final ParseACL acl = (ParseObject)j1.next();
            if (acl.isDataAvailable("ACL"))
            {
                acl = ParseObject.access$600(acl, false);
                if (acl != null)
                {
                    final ParseUser user = acl.getUnresolvedUser();
                    if (user != null && user.isCurrentUser())
                    {
                        return user.saveAsync(null).c(new i() {

                            final ParseObject._cls44 this$0;
                            final ParseACL val$acl;
                            final ParseUser val$user;

                            public volatile Object then(j j2)
                                throws Exception
                            {
                                return then(j2);
                            }

                            public String then(j j2)
                                throws Exception
                            {
                                if (acl.hasUnresolvedUser())
                                {
                                    throw new IllegalStateException("ACL has an unresolved ParseUser. Save or sign up before attempting to serialize the ACL.");
                                } else
                                {
                                    return user.getSessionToken();
                                }
                            }

            
            {
                this$0 = ParseObject._cls44.this;
                acl = parseacl;
                user = parseuser;
                super();
            }
                        });
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

    _cls1.val.user(List list)
    {
        val$objects = list;
        super();
    }
}
