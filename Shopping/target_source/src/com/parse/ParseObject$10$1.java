// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseACL, ParseUser, ParseObject

class val.user
    implements i
{

    final ionToken this$1;
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

    is._cls0()
    {
        this$1 = final__pcls0;
        val$acl = parseacl;
        val$user = ParseUser.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$10

/* anonymous class */
    class ParseObject._cls10
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
            ParseUser parseuser = acl.getUnresolvedUser();
            if (parseuser == null || !parseuser.isCurrentUser())
            {
                return j.a(null);
            } else
            {
                return parseuser.saveAsync(null).c(parseuser. new ParseObject._cls10._cls1());
            }
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = ParseObject.this;
                super();
            }
    }

}
