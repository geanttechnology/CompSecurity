// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser, ParseOperationSet, PointerEncoder, ParseRESTUserCommand, 
//            ParseRESTCommand

class val.signUpTask
    implements ct
{

    final then this$2;
    final cu val$signUpTask;

    public cu then(cu cu1)
        throws Exception
    {
        if (!val$signUpTask.c() && !val$signUpTask.d())
        {
            synchronized (mutex)
            {
                ParseUser.access$602(_fld0, true);
                ParseUser.access$702(_fld0, false);
            }
            return ParseUser.access$200(_fld0).j();
        } else
        {
            return val$signUpTask.j();
        }
        exception;
        cu1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    sessionToken()
    {
        this$2 = final_sessiontoken;
        val$signUpTask = cu.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$5

/* anonymous class */
    class ParseUser._cls5
        implements ct
    {

        final ParseUser this$0;
        final String val$sessionToken;

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = (ParseOperationSet)cu1.e();
            return ParseRESTUserCommand.signUpUserCommand(toJSONObjectForSaving(getState(), cu1, PointerEncoder.get()), sessionToken, ParseUser.access$500()).executeAsync().b(cu1. new ParseUser._cls5._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_parseuser;
                sessionToken = String.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/ParseUser$5$1

/* anonymous class */
    class ParseUser._cls5._cls1
        implements ct
    {

        final ParseUser._cls5 this$1;
        final ParseOperationSet val$operations;

        public cu then(cu cu1)
            throws Exception
        {
            return handleSaveResultAsync((JSONObject)cu1.e(), operations).b(cu1. new ParseUser._cls5._cls1._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$1 = final__pcls5;
                operations = ParseOperationSet.this;
                super();
            }
    }

}
