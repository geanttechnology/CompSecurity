// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser, ParseACL

static final class val.objects
    implements ct
{

    final List val$objects;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (ParseUser)cu1.e();
        if (cu1 == null)
        {
            return cu.a(null);
        }
        if (!cu1.isLazy())
        {
            return cu.a(cu1.getSessionToken());
        }
        for (cu1 = val$objects.iterator(); cu1.hasNext();)
        {
            final ParseACL acl = (ParseObject)cu1.next();
            if (ParseObject.access$600(acl, "ACL"))
            {
                acl = ParseObject.access$700(acl, false);
                if (acl != null)
                {
                    final ParseUser user = acl.getUnresolvedUser();
                    if (user != null && user.isCurrentUser())
                    {
                        return user.saveAsync(null).c(new ct() {

                            final ParseObject._cls44 this$0;
                            final ParseACL val$acl;
                            final ParseUser val$user;

                            public volatile Object then(cu cu2)
                                throws Exception
                            {
                                return then(cu2);
                            }

                            public String then(cu cu2)
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

        return cu.a(null);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    _cls1.val.user(List list)
    {
        val$objects = list;
        super();
    }
}
