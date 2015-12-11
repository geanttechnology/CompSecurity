// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser, ParseTaskUtils, ParseQuery, 
//            GetCallback, ParseRESTSessionCommand

public class ParseSession extends ParseObject
{

    private static final String KEY_CREATED_WITH = "createdWith";
    private static final String KEY_EXPIRES_AT = "expiresAt";
    private static final String KEY_INSTALLATION_ID = "installationId";
    private static final String KEY_RESTRICTED = "restricted";
    private static final String KEY_SESSION_TOKEN = "sessionToken";
    private static final String KEY_USER = "user";
    private static final List READ_ONLY_KEYS = Collections.unmodifiableList(Arrays.asList(new String[] {
        "sessionToken", "createdWith", "restricted", "user", "expiresAt", "installationId"
    }));

    public ParseSession()
    {
    }

    public static cu getCurrentSessionInBackground()
    {
        return ParseUser.getCurrentSessionTokenAsync().d(new ct() {

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (String)cu1.e();
                if (cu1 == null)
                {
                    return cu.a(null);
                } else
                {
                    return ParseRESTSessionCommand.getCurrentSessionCommand(cu1).executeAsync().i();
                }
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

        }).c(new ct() {

            public ParseSession then(cu cu1)
                throws Exception
            {
                cu1 = (JSONObject)cu1.e();
                if (cu1 == null)
                {
                    return null;
                } else
                {
                    return (ParseSession)ParseObject.fromJSON(cu1, "_Session", true);
                }
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

        });
    }

    public static void getCurrentSessionInBackground(GetCallback getcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(getCurrentSessionInBackground(), getcallback);
    }

    public static ParseQuery getQuery()
    {
        return ParseQuery.getQuery(com/parse/ParseSession);
    }

    public String getSessionToken()
    {
        return getString("sessionToken");
    }

    boolean isKeyMutable(String s)
    {
        return !READ_ONLY_KEYS.contains(s);
    }

    boolean needsDefaultACL()
    {
        return false;
    }

}
