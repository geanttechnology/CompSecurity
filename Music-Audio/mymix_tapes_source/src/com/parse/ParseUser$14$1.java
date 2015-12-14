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
//            ParseObject, ParseUser, ParseCommand, ParseException

class this._cls0
    implements Continuation
{

    final then this$0;

    public Task then(Task task)
        throws Exception
    {
        return ParseUser.access$100((ParseUser)ParseObject.fromJSON((JSONObject)task.getResult(), "_User", true));
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    l.authData()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$14

/* anonymous class */
    static final class ParseUser._cls14
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
                ParseUser.access$900(task).put(authType, authData);
                ParseUser.access$1000(task).add(authType);
            }
            // Misplaced declaration of an exception variable
            catch (Task task)
            {
                throw new ParseException(task);
            }
            return ParseUser.access$1100(task, task.startSave()).executeAsync().onSuccessTask(new ParseUser._cls14._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                authType = s;
                authData = jsonobject;
                super();
            }
    }

}
