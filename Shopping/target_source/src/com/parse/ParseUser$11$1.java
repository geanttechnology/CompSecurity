// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser, ParseUserController

class this._cls0
    implements i
{

    final then this$0;

    public j then(final j user)
        throws Exception
    {
        user = (ParseUser)ParseObject.from(()user.e());
        return ParseUser.access$200(user).c(new i() {

            final ParseUser._cls11._cls1 this$1;
            final ParseUser val$user;

            public ParseUser then(j j1)
                throws Exception
            {
                return user;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$1 = ParseUser._cls11._cls1.this;
                user = parseuser;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    l.authData()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$11

/* anonymous class */
    static final class ParseUser._cls11
        implements i
    {

        final Map val$authData;
        final String val$authType;

        public j then(j j1)
            throws Exception
        {
            return ParseUser.getUserController().logInAsync(authType, authData).d(new ParseUser._cls11._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                authType = s;
                authData = map;
                super();
            }
    }

}
