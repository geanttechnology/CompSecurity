// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser, ParseACL

class this._cls0
    implements i
{

    final ParseObject this$0;

    public j then(final j acl)
        throws Exception
    {
        acl = (ParseUser)acl.e();
        if (acl == null)
        {
            return j.a(null);
        }
        if (!acl.isLazy())
        {
            return j.a(acl.getSessionToken());
        }
        if (!isDataAvailable("ACL"))
        {
            return j.a(null);
        }
        acl = ParseObject.access$600(ParseObject.this, false);
        if (acl == null)
        {
            return j.a(null);
        }
        final ParseUser user = acl.getUnresolvedUser();
        if (user == null || !user.isCurrentUser())
        {
            return j.a(null);
        } else
        {
            return user.saveAsync(null).c(new i() {

                final ParseObject._cls10 this$1;
                final ParseACL val$acl;
                final ParseUser val$user;

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

                public String then(j j1)
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
                this$1 = ParseObject._cls10.this;
                acl = parseacl;
                user = parseuser;
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

    _cls1.val.user()
    {
        this$0 = ParseObject.this;
        super();
    }
}
