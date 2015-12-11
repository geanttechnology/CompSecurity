// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseACL, ParseUser, ParseObject

class val.user
    implements ct
{

    final ionToken this$0;
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
            for (cu1 = objects.iterator(); cu1.hasNext();)
            {
                final ParseACL acl = (ParseObject)cu1.next();
                if (ParseObject.access$600(acl, "ACL"))
                {
                    acl = ParseObject.access$700(acl, false);
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

            return cu.a(null);
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                objects = list;
                super();
            }
    }

}
