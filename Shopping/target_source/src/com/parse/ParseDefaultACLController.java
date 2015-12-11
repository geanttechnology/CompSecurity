// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.lang.ref.WeakReference;

// Referenced classes of package com.parse:
//            ParseUser, ParseACL

class ParseDefaultACLController
{

    ParseACL defaultACL;
    boolean defaultACLUsesCurrentUser;
    ParseACL defaultACLWithCurrentUser;
    WeakReference lastCurrentUser;

    ParseDefaultACLController()
    {
    }

    public ParseACL get()
    {
        if (defaultACLUsesCurrentUser && defaultACL != null)
        {
            ParseUser parseuser = ParseUser.getCurrentUser();
            if (parseuser != null)
            {
                Object obj;
                if (lastCurrentUser != null)
                {
                    obj = (ParseUser)lastCurrentUser.get();
                } else
                {
                    obj = null;
                }
                if (obj != parseuser)
                {
                    obj = defaultACL.copy();
                    ((ParseACL) (obj)).setShared(true);
                    ((ParseACL) (obj)).setReadAccess(parseuser, true);
                    ((ParseACL) (obj)).setWriteAccess(parseuser, true);
                    defaultACLWithCurrentUser = ((ParseACL) (obj));
                    lastCurrentUser = new WeakReference(parseuser);
                }
                return defaultACLWithCurrentUser;
            }
        }
        return defaultACL;
    }

    public void set(ParseACL parseacl, boolean flag)
    {
        defaultACLWithCurrentUser = null;
        lastCurrentUser = null;
        if (parseacl != null)
        {
            parseacl = parseacl.copy();
            parseacl.setShared(true);
            defaultACL = parseacl;
            defaultACLUsesCurrentUser = flag;
            return;
        } else
        {
            defaultACL = null;
            return;
        }
    }
}
