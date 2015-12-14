// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser, ParseObject, ParseCommand, ParseException

static final class 
    implements Continuation
{

    final JSONObject val$authData;
    final String val$authType;

    public Task then(Task task)
        throws Exception
    {
        task = (ParseUser)ParseObject.create(com/parse/ParseUser);
        try
        {
            ParseUser.access$900(task).put(val$authType, val$authData);
            ParseUser.access$1000(task).add(val$authType);
        }
        // Misplaced declaration of an exception variable
        catch (Task task)
        {
            throw new ParseException(task);
        }
        return ParseUser.access$1100(task, task.startSave()).executeAsync().onSuccessTask(new Continuation() {

            final ParseUser._cls14 this$0;

            public Task then(Task task1)
                throws Exception
            {
                return ParseUser.access$100((ParseUser)ParseObject.fromJSON((JSONObject)task1.getResult(), "_User", true));
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseUser._cls14.this;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    (String s, JSONObject jsonobject)
    {
        val$authType = s;
        val$authData = jsonobject;
        super();
    }
}
