// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser, ParseUserController, ParseObject

static final class 
    implements i
{

    final Map val$authData;
    final String val$authType;

    public j then(j j1)
        throws Exception
    {
        return ParseUser.getUserController().logInAsync(val$authType, val$authData).d(new i() {

            final ParseUser._cls11 this$0;

            public j then(j j2)
                throws Exception
            {
                j2 = (ParseUser)ParseObject.from((ParseUser.State)j2.e());
                return ParseUser.access$200(j2).c(j2. new i() {

                    final _cls1 this$1;
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
                this$1 = final__pcls1;
                user = ParseUser.this;
                super();
            }
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = ParseUser._cls11.this;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    (String s, Map map)
    {
        val$authType = s;
        val$authData = map;
        super();
    }
}
