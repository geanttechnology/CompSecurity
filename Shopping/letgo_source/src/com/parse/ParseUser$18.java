// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser, ParseRESTUserCommand, ParseObject

static final class 
    implements ct
{

    final Map val$authData;
    final String val$authType;

    public cu then(final cu command)
        throws Exception
    {
        command = ParseRESTUserCommand.serviceLogInUserCommand(val$authType, val$authData, ParseUser.access$500());
        return command.executeAsync().d(new ct() {

            final ParseUser._cls18 this$0;
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
                ParseUser.State.Builder builder = parseuser.getState().newBuilder().putAuthData(authType, authData);
                if (command.getStatusCode() != 201)
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

            
            {
                this$0 = ParseUser._cls18.this;
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

    (String s, Map map)
    {
        val$authType = s;
        val$authData = map;
        super();
    }
}
