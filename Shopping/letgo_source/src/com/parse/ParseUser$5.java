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

class >
    implements ct
{

    final ParseUser this$0;
    final String val$sessionToken;

    public cu then(final cu operations)
        throws Exception
    {
        operations = (ParseOperationSet)operations.e();
        return ParseRESTUserCommand.signUpUserCommand(toJSONObjectForSaving(getState(), operations, PointerEncoder.get()), val$sessionToken, ParseUser.access$500()).executeAsync().b(new ct() {

            final ParseUser._cls5 this$1;
            final ParseOperationSet val$operations;

            public cu then(cu cu1)
                throws Exception
            {
                return handleSaveResultAsync((JSONObject)cu1.e(), operations).b(cu1. new ct() {

                    final _cls1 this$2;
                    final cu val$signUpTask;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        if (!signUpTask.c() && !signUpTask.d())
                        {
                            synchronized (mutex)
                            {
                                ParseUser.access$602(this$0, true);
                                ParseUser.access$702(this$0, false);
                            }
                            return ParseUser.access$200(this$0).j();
                        } else
                        {
                            return signUpTask.j();
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

            
            {
                this$2 = final__pcls1;
                signUpTask = cu.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$1 = ParseUser._cls5.this;
                operations = parseoperationset;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    >()
    {
        this$0 = final_parseuser;
        val$sessionToken = String.this;
        super();
    }
}
