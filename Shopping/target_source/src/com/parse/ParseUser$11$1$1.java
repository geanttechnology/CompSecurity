// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser, ParseUserController, ParseObject

class val.user
    implements i
{

    final then this$1;
    final ParseUser val$user;

    public ParseUser then(j j)
        throws Exception
    {
        return val$user;
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    authData()
    {
        this$1 = final_authdata;
        val$user = ParseUser.this;
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


    // Unreferenced inner class com/parse/ParseUser$11$1

/* anonymous class */
    class ParseUser._cls11._cls1
        implements i
    {

        final ParseUser._cls11 this$0;

        public j then(j j1)
            throws Exception
        {
            j1 = (ParseUser)ParseObject.from((ParseUser.State)j1.e());
            return ParseUser.access$200(j1).c(j1. new ParseUser._cls11._cls1._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = ParseUser._cls11.this;
                super();
            }
    }

}
