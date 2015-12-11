// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTUserCommand, Parse, ParseOperationSet, ParseUser, 
//            ParseObject

class mmand
    implements ct
{

    final then this$1;
    final ParseRESTUserCommand val$command;

    public cu then(final cu commandResult)
        throws Exception
    {
        commandResult = (JSONObject)commandResult.e();
        final boolean isNew;
        if (val$command.getStatusCode() == 201)
        {
            isNew = true;
        } else
        {
            isNew = false;
        }
        if (Parse.isLocalDatastoreEnabled() && !isNew)
        {
            commandResult = cu.a(commandResult);
        } else
        {
            commandResult = handleSaveResultAsync(commandResult, (ParseOperationSet)operations.a()).c(new ct() {

                final ParseUser._cls24._cls1 this$2;
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
                this$2 = ParseUser._cls24._cls1.this;
                commandResult = jsonobject;
                super();
            }
            });
        }
        return commandResult.d(new ct() {

            final ParseUser._cls24._cls1 this$2;
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
                this$2 = ParseUser._cls24._cls1.this;
                isNew = flag;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    mmand()
    {
        this$1 = final_mmand;
        val$command = ParseRESTUserCommand.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$24

/* anonymous class */
    class ParseUser._cls24
        implements ct
    {

        final ParseUser this$0;
        final cs val$operations;

        public cu then(cu cu1)
            throws Exception
        {
            operations.a(cu1.e());
            cu1 = ParseUser.access$2500(ParseUser.this, getState(), (ParseOperationSet)operations.a());
            return cu1.executeAsync().d(cu1. new ParseUser._cls24._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_parseuser;
                operations = cs.this;
                super();
            }
    }

}
