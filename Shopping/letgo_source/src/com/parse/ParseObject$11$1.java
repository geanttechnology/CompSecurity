// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseACL, ParseUser, ParseObject

class val.user
    implements ct
{

    final ionToken this$1;
    final ParseACL val$acl;
    final ParseUser val$user;

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    public String then(cu cu)
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

    // Unreferenced inner class com/parse/ParseObject$11

/* anonymous class */
    class ParseObject._cls11
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
            ParseUser parseuser = acl.getUnresolvedUser();
            if (parseuser == null || !parseuser.isCurrentUser())
            {
                return cu.a(null);
            } else
            {
                return parseuser.saveAsync(null).c(parseuser. new ParseObject._cls11._cls1());
            }
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = ParseObject.this;
                super();
            }
    }

}
