// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser, ParseRESTUserCommand

class mmand
    implements ct
{

    final then this$0;
    final ParseRESTUserCommand val$command;

    public cu then(cu cu1)
        throws Exception
    {
        ParseUser parseuser;
        boolean flag;
        flag = true;
        parseuser = (ParseUser)ParseObject.fromJSON((JSONObject)cu1.e(), "_User", true);
        cu1 = ((cu) (parseuser.mutex));
        cu1;
        JVM INSTR monitorenter ;
        .Builder builder = parseuser.getState().newBuilder().putAuthData(authType, authData);
        if (val$command.getStatusCode() != 201)
        {
            flag = false;
        }
        ParseUser.access$602(parseuser, flag);
        parseuser.setState(builder.build());
        return ParseUser.access$200(parseuser);
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

    mmand()
    {
        this$0 = final_mmand;
        val$command = ParseRESTUserCommand.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$18

/* anonymous class */
    static final class ParseUser._cls18
        implements ct
    {

        final Map val$authData;
        final String val$authType;

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = ParseRESTUserCommand.serviceLogInUserCommand(authType, authData, ParseUser.access$500());
            return cu1.executeAsync().d(cu1. new ParseUser._cls18._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                authType = s;
                authData = map;
                super();
            }
    }

}
