// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseUser, ParseUserController, ParseOperationSet

class >
    implements i
{

    final ParseUser this$0;
    final ParseOperationSet val$operations;
    final String val$sessionToken;

    public j then(j j1)
        throws Exception
    {
        return ParseUser.getUserController().signUpAsync(getState(), val$operations, val$sessionToken).b(new i() {

            final ParseUser._cls8 this$1;

            public j then(j j2)
                throws Exception
            {
                ParseUser.State state = (ParseUser.State)j2.e();
                return handleSaveResultAsync(state, operations).b(j2. new i() {

                    final _cls1 this$2;
                    final j val$signUpTask;

                    public j then(j j1)
                        throws Exception
                    {
                        if (!signUpTask.c() && !signUpTask.d())
                        {
                            return ParseUser.access$200(this$0);
                        } else
                        {
                            return signUpTask.j();
                        }
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$2 = final__pcls1;
                signUpTask = j.this;
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
                this$1 = ParseUser._cls8.this;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    onSet()
    {
        this$0 = final_parseuser;
        val$operations = parseoperationset;
        val$sessionToken = String.this;
        super();
    }
}
