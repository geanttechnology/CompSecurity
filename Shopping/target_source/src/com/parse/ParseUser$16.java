// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseUser, ParseUserController, ParseOperationSet, Parse, 
//            ParseObject

class 
    implements i
{

    final ParseUser this$0;
    final ParseOperationSet val$operations;

    public j then(j j1)
        throws Exception
    {
        return ParseUser.getUserController().logInAsync(getState(), val$operations).d(new i() {

            final ParseUser._cls16 this$1;

            public j then(j j2)
                throws Exception
            {
                j2 = (ParseUser.State)j2.e();
                if (Parse.isLocalDatastoreEnabled() && !j2.isNew())
                {
                    j2 = j.a(j2);
                } else
                {
                    j2 = handleSaveResultAsync(j2, operations).c(j2. new i() {

                        final _cls1 this$2;
                        final ParseUser.State val$result;

                        public ParseUser.State then(j j1)
                            throws Exception
                        {
                            return result;
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$2 = final__pcls1;
                result = ParseUser.State.this;
                super();
            }
                    });
                }
                return j2.d(new i() {

                    final _cls1 this$2;

                    public j then(j j1)
                        throws Exception
                    {
                        ParseUser.State state = (ParseUser.State)j1.e();
                        if (!state.isNew())
                        {
                            return ParseUser.access$200((ParseUser)ParseObject.from(state));
                        } else
                        {
                            return j1.j();
                        }
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$2 = _cls1.this;
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
                this$1 = ParseUser._cls16.this;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    nSet()
    {
        this$0 = final_parseuser;
        val$operations = ParseOperationSet.this;
        super();
    }
}
