// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser, ParseACL

class this._cls0
    implements ct
{

    final ParseObject this$0;

    public cu then(final cu acl)
        throws Exception
    {
        acl = (ParseUser)acl.e();
        if (acl == null)
        {
            return cu.a(null);
        }
        if (!acl.isLazy())
        {
            return cu.a(acl.getSessionToken());
        }
        if (!ParseObject.access$600(ParseObject.this, "ACL"))
        {
            return cu.a(null);
        }
        acl = ParseObject.access$700(ParseObject.this, false);
        if (acl == null)
        {
            return cu.a(null);
        }
        final ParseUser user = acl.getUnresolvedUser();
        if (user == null || !user.isCurrentUser())
        {
            return cu.a(null);
        } else
        {
            return user.saveAsync(null).c(new ct() {

                final ParseObject._cls11 this$1;
                final ParseACL val$acl;
                final ParseUser val$user;

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

                public String then(cu cu1)
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
                this$1 = ParseObject._cls11.this;
                acl = parseacl;
                user = parseuser;
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

    _cls1.val.user()
    {
        this$0 = ParseObject.this;
        super();
    }
}
