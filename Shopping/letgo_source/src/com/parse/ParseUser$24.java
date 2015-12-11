// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser, ParseOperationSet, ParseRESTUserCommand, Parse, 
//            ParseObject

class 
    implements ct
{

    final ParseUser this$0;
    final cs val$operations;

    public cu then(final cu command)
        throws Exception
    {
        val$operations.a(command.e());
        command = ParseUser.access$2500(ParseUser.this, getState(), (ParseOperationSet)val$operations.a());
        return command.executeAsync().d(new ct() {

            final ParseUser._cls24 this$1;
            final ParseRESTUserCommand val$command;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (JSONObject)cu1.e();
                boolean flag;
                if (command.getStatusCode() == 201)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (Parse.isLocalDatastoreEnabled() && !flag)
                {
                    cu1 = cu.a(cu1);
                } else
                {
                    cu1 = handleSaveResultAsync(cu1, (ParseOperationSet)operations.a()).c(cu1. new ct() {

                        final _cls1 this$2;
                        final JSONObject val$commandResult;

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

                        public JSONObject then(cu cu1)
                            throws Exception
                        {
                            return commandResult;
                        }

            
            {
                this$2 = final__pcls1;
                commandResult = JSONObject.this;
                super();
            }
                    });
                }
                return cu1.d(flag. new ct() {

                    final _cls1 this$2;
                    final boolean val$isNew;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        Object obj = (JSONObject)cu1.e();
                        cu1 = ((cu) (mutex));
                        cu1;
                        JVM INSTR monitorenter ;
                        if (!isNew)
                        {
                            break MISSING_BLOCK_LABEL_64;
                        }
                        ParseUser.access$702(this$0, false);
                        obj = cu.a(this$0);
                        return ((cu) (obj));
                        cu1;
                        JVM INSTR monitorexit ;
                        return ParseUser.access$200((ParseUser)ParseObject.fromJSON(((JSONObject) (obj)), "_User", true));
                        Exception exception;
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
                isNew = Z.this;
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
                this$1 = ParseUser._cls24.this;
                command = parserestusercommand;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = final_parseuser;
        val$operations = cs.this;
        super();
    }
}
