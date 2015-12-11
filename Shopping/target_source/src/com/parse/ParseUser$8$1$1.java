// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseUser, ParseUserController, ParseOperationSet

class val.signUpTask
    implements i
{

    final then this$2;
    final j val$signUpTask;

    public j then(j j1)
        throws Exception
    {
        if (!val$signUpTask.c() && !val$signUpTask.d())
        {
            return ParseUser.access$200(_fld0);
        } else
        {
            return val$signUpTask.j();
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    sessionToken()
    {
        this$2 = final_sessiontoken;
        val$signUpTask = j.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$8

/* anonymous class */
    class ParseUser._cls8
        implements i
    {

        final ParseUser this$0;
        final ParseOperationSet val$operations;
        final String val$sessionToken;

        public j then(j j1)
            throws Exception
        {
            return ParseUser.getUserController().signUpAsync(getState(), operations, sessionToken).b(new ParseUser._cls8._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_parseuser;
                operations = parseoperationset;
                sessionToken = String.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/ParseUser$8$1

/* anonymous class */
    class ParseUser._cls8._cls1
        implements i
    {

        final ParseUser._cls8 this$1;

        public j then(j j1)
            throws Exception
        {
            ParseUser.State state = (ParseUser.State)j1.e();
            return handleSaveResultAsync(state, operations).b(j1. new ParseUser._cls8._cls1._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$1 = ParseUser._cls8.this;
                super();
            }
    }

}
