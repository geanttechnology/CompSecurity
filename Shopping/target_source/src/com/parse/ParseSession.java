// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser, ParseTaskUtils, ParseQuery, 
//            ParseCorePlugins, ParseSessionController, GetCallback

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

    public static j getCurrentSessionInBackground()
    {
        return ParseUser.getCurrentSessionTokenAsync().d(new i() {

            public j then(j j1)
                throws Exception
            {
                j1 = (String)j1.e();
                if (j1 == null)
                {
                    return j.a(null);
                } else
                {
                    return ParseSession.getSessionController().getSessionAsync(j1).c(new i() {

                        final _cls1 this$0;

                        public ParseSession then(j j1)
                            throws Exception
                        {
                            return (ParseSession)ParseObject.from((ParseObject.State)j1.e());
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$0 = _cls1.this;
                super();
            }
                    });
                }
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
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

    private static ParseSessionController getSessionController()
    {
        return ParseCorePlugins.getInstance().getSessionController();
    }

    static boolean isRevocableSessionToken(String s)
    {
        return s.contains("r:");
    }

    static j revokeAsync(String s)
    {
        if (s == null || !isRevocableSessionToken(s))
        {
            return j.a(null);
        } else
        {
            return getSessionController().revokeAsync(s);
        }
    }

    static j upgradeToRevocableSessionAsync(String s)
    {
        if (s == null || isRevocableSessionToken(s))
        {
            return j.a(s);
        } else
        {
            return getSessionController().upgradeToRevocable(s).c(new i() {

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

                public String then(j j1)
                    throws Exception
                {
                    return ((ParseSession)ParseObject.from((ParseObject.State)j1.e())).getSessionToken();
                }

            });
        }
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
